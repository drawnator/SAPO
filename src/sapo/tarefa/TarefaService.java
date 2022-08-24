package sapo.tarefa;

import java.util.HashSet;
import java.util.Set;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;

public class TarefaService {
	private TarefaRepository tr;

	public TarefaService() {
		this.tr = new TarefaRepository();
	}

	public Tarefa getTarefa(String idTarefa) {
		return this.tr.getTarefa(idTarefa);
	}

	public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
		Tarefa tarefa = new Tarefa(atividadeId, nome, habilidades, this.tr.getTarefasCadastradas());
		this.tr.cadastrarTarefa(tarefa);
		this.tr.incrementaTarefasCadastradas();
		return tarefa.getId();
	}

	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.tr.getTarefa(idTarefa).setNome(novoNome);
	}

	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		this.tr.getTarefa(idTarefa).setHabilidades(habilidades);
	}

	public void adicionarHorasTarefa(String idTarefa, int horas) {
		this.tr.getTarefa(idTarefa).mudarHoras(horas);
	}

	public void removerHorasTarefa(String idTarefa, int horas) {
		this.tr.getTarefa(idTarefa).mudarHoras(-horas);
	}

	public void concluirTarefa(String idTarefa) {
		this.tr.getTarefa(idTarefa).concluir();
		HashSet<String> gerenciaisParaChecagem = this.tr.getTarefa(idTarefa).getPresenteGerencial();
		if (this.tr.getTarefa(idTarefa).getPresenteNaGerencial()) {
			for (String i : gerenciaisParaChecagem) {
				TarefaGerencial taGer = (TarefaGerencial) this.tr.getTarefa(i);
				if (taGer.todasConcluidas()) {
					taGer.concluir();
				}
			}
		}
	}

	public void removerTarefa(String idTarefa) {
		this.tr.removerTarefa(idTarefa);
	}

	public String exibirTarefa(String idTarefa, PessoaService ps, AtividadeService as) {

		Tarefa tarefa = this.tr.getTarefa(idTarefa);
		String output = "";
		output += tarefa.getNome() + " - " + tarefa.getId() + "\n";
		// output += "- " + as.getNome(tarefa.getIdAtividade()) + "\n";
		output += "- " + as.getNome(tarefa.getIdAtividade()) + "\n";
		String[] habilidades = tarefa.getHabilidades();
		for (String habilidade : habilidades) {
			output += habilidade;
			if (!habilidade.equals(habilidades[habilidades.length - 1])) {
				output += ", ";
			}
		}

		output += "\n(" + tarefa.getDuracao() + " hora(s) executadas))\n";
		output += "===\n";
		output += "Equipe:\n";
		for (String cpf : tarefa.getPessoas()) {
			output += ps.getPessoa(cpf).getNome() + " - " + cpf;
		}
		return output;

	}

	public void associarPessoaTarefa(String cpf, String idTarefa, PessoaService ps) {
		this.tr.getTarefa(idTarefa).associarPessoa(cpf);
		ps.associarPessoaTarefa(cpf, idTarefa);
	}

	public void removerPessoaTarefa(String cpf, String idTarefa, PessoaService ps) {
		this.tr.getTarefa(idTarefa).removerPessoa(cpf);
		ps.removerPessoaTarefa(cpf, idTarefa);
	}

	public Set<Tarefa> busca(String termo) {
		return tr.busca(termo);
	}

	public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
		Tarefa[] tarefasAssociadas = new Tarefa[idTarefas.length];
		for (int i = 0; i < tarefasAssociadas.length; i++) {
			tarefasAssociadas[i] = this.tr.getTarefa(idTarefas[i]);
		}
		TarefaGerencial tarefaGer = new TarefaGerencial(atividadeId, nome, habilidades, this.tr.getTarefasCadastradas(),
				tarefasAssociadas);
		this.tr.cadastrarTarefaGerencial(tarefaGer);
		this.tr.incrementaTarefasCadastradas();
		return tarefaGer.getId();
	}

	public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) throws IllegalArgumentException {
		TarefaGerencial tarefaGer = (TarefaGerencial) tr.getTarefa(idTarefaGerencial);
		Tarefa tarefa = tr.getTarefa(idTarefa);
		if (((TarefaGerencial) tarefa).checarCiclo(idTarefaGerencial)) {
			throw new IllegalArgumentException();
		}
		tarefaGer.checaSeGerencial(tarefa);
		tarefa.addPresenteGerencial(idTarefaGerencial);
		tarefaGer.addTarefa(tarefa);
	}

	public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
		TarefaGerencial tarefaGer = (TarefaGerencial) tr.getTarefa(idTarefaGerencial);
		Tarefa tarefa = tr.getTarefa(idTarefa);
		tarefaGer.excluirTarefa(tarefa);
		tarefa.excluirPresenteGerencial(idTarefaGerencial);
	}

	public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
		TarefaGerencial tarefaGer = (TarefaGerencial) tr.getTarefa(idTarefaGerencial);
		return this.tr.contaTarefasAssociadas(tarefaGer);
	}

}
