package sapo.atividade;

import java.util.ArrayList;
import java.util.Set;

import sapo.pessoa.PessoaService;
import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaService;

public class AtividadeService {
	private AtividadeRepository ar;

	public AtividadeService() {
		this.ar = new AtividadeRepository();
	}

	public String getNome(String atividadeId) {return ar.getAtividade(atividadeId).getNome();}
	public String getDescricao(String atividadeId) {return ar.getAtividade(atividadeId).getDescricao();}
	public String getCodigo(String atividadeId) {return ar.getAtividade(atividadeId).getCodigo();}
	public String getResponsavel(String atividadeId) {return ar.getAtividade(atividadeId).getcpfResponsavel();}
	public String getStatus(String atividadeId) {return ar.getAtividade(atividadeId).getStatus();}
	public ArrayList<String> getTarefasCadastradas(String atividadeId) {return ar.getAtividade(atividadeId).gettarefascadastradas();}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		int numeroAtividade = ar.tamanhoListaAtividade();
		String id = geraSigla(nome) + "-" + numeroAtividade;
		Atividade novaAtividade = new Atividade(nome, descricao, cpf, id);
		ar.cadastrarAtividade(id, novaAtividade);
		return id;
	}
	
	public int addTarefa(String atividadeId, Tarefa tarefa) {
		ar.getAtividade(atividadeId).addTarefa(tarefa);
		return ar.getAtividade(atividadeId).gettarefascadastradas().size();
	}

	public void encerrarAtividade(String atividadeId) {
		ar.getAtividade(atividadeId).encerrar();
	}

	public void desativarAtividade(String atividadeId) {
		ar.getAtividade(atividadeId).desativar();
	}

	public void reabrirAtividade(String atividadeId) {
		ar.getAtividade(atividadeId).reabrir();
	}

	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		ar.getAtividade(atividadeId).alterarDescricao(descricao);
	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		ar.getAtividade(atividadeId).alterarResponsavel(cpf);
	}

	public void removerResponsavel(String atividadeId) {
		ar.getAtividade(atividadeId).alterarResponsavel(null);
	}
	
	public String representacao(PessoaService ps, TarefaService ts,String atividadeId) {
		String nomeAtividade = ar.getAtividade(atividadeId).getNome();
		String codigoAtividade = ar.getAtividade(atividadeId).getCodigo();
		String cpfResponsa = ar.getAtividade(atividadeId).getcpfResponsavel();
		String descricao = ar.getAtividade(atividadeId).getDescricao();
		String texto = codigoAtividade + ": " + nomeAtividade + "\n";
		if (cpfResponsa != null) {
			texto += "Responsavel: "+ ps.getNome(cpfResponsa) + " - " + cpfResponsa + "\n";
		}
		texto += "===\n";
		texto += descricao + "\n";
		texto += "===\n";
		
		return texto;

	}
	
	public Set<Atividade> busca(String termo){
		return ar.busca(termo);
	}
	
	private String geraSigla(String nome) {
		String sigla = "";
		String vogais = "aeiouAEIOU 123456789";
		for (int i = 0; i < nome.length(); i++) {
			String letra = "" + nome.charAt(i);
			if (sigla.length() < 3 && !vogais.contains(letra)) {
				sigla += letra.toUpperCase();
			}
		}
		while (sigla.length() < 3) {
			sigla += "X";
		}
		return sigla;
	}

}
