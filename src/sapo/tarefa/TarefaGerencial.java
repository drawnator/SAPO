package sapo.tarefa;

import java.util.HashSet;

public class TarefaGerencial extends Tarefa {

	// private String id;
	// private String idAtividade;
	// private String nome;
	private HashSet<Tarefa> tarefasAssociadas;
	// private int horas;
	private HashSet<String> habilidadesUniao;
	private String[] habilidadesTarefas;
	// private HashSet<String> pessoas;
	// private boolean concluida;

	public TarefaGerencial(String atividadeId, String nome, String[] habilidadesNovas, int tarefasCadastradas,
			Tarefa[] tarefasRelacionadas) {
		// this.idAtividade = atividadeId;
		// this.nome = nome;
		super(atividadeId, nome, habilidadesNovas, tarefasCadastradas);
		for (int i = 0; i < tarefasRelacionadas.length; i++) {
			this.tarefasAssociadas.add(tarefasRelacionadas[i]);
		}
		// this.horas = 0;
		for (int i = 0; i < habilidadesNovas.length; i++) {
			habilidadesTarefas = tarefasRelacionadas[i].getHabilidades();
			for (int y = 0; y < habilidadesNovas.length; y++) {
				habilidadesUniao.add(habilidadesTarefas[y]);
			}
		}
		for (int i = 0; i < habilidadesNovas.length; i++) {
			habilidadesUniao.add(habilidadesNovas[i]);
		}
	}

	public void addTarefa(Tarefa tarefa) {
		String habilidades[] = tarefa.getHabilidades();
		for (int y = 0; y < habilidades.length; y++) {
			habilidadesUniao.add(habilidades[y]);
		}
		tarefasAssociadas.add(tarefa);
	}

	public void excluirTarefa(Tarefa tarefa) {
		tarefasAssociadas.remove(tarefa);
	}

	public int contarTarefasAssociadas() {
		return this.tarefasAssociadas.size();
	}

	public boolean todasConcluidas() {
		for (Tarefa i : tarefasAssociadas) {
			if (!i.getConcluida()) {
				return false;
			}
		}
		return true;
	}

}
