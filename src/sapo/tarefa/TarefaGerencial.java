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
	private HashSet<String> gerenciaisAssociadas; //2
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
		this.gerenciaisAssociadas = new HashSet<String>();
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
		int contador = 0;
		for (Tarefa i: tarefasAssociadas) {
			if (i.getClass() == this.getClass()) {
				contador++;
			}
		}
		return (this.tarefasAssociadas.size() - contador);
	}

	public boolean todasConcluidas() {
		for (Tarefa i : tarefasAssociadas) {
			if (!i.getConcluida()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checaSeGerencial(Tarefa tarefa) {
		if (tarefa.getClass() == this.getClass()) {
			this.gerenciaisAssociadas.add(tarefa.getId());
			for (String i: ((TarefaGerencial) tarefa).getGerenciaisAssociadas()) {
				this.gerenciaisAssociadas.add(i);
			}
			return true;
		} return false;
	}
	
	public boolean checarCiclo(String idTarefa) {
		if (this.gerenciaisAssociadas.contains(idTarefa)) {
			return true;
		} return false;
	}
	public HashSet<String> getGerenciaisAssociadas() {
		return this.gerenciaisAssociadas;
	}

}
