package sapo.tarefa;

import java.util.HashSet;

public class TarefaGerencial {
	
	private String id;
	private String idAtividade;
	private String nome;
	private Tarefa[] tarefasAssociadas;
	private int horas;
	private HashSet<String> habilidadesUniao;
	private String[] habilidadesTarefas;
	private HashSet<String> pessoas;
	private boolean concluida;
	
	
	
	public TarefaGerencial(String atividadeId, String nome, String[] habilidadesNovas, Tarefa[] tarefasRelacionadas) {
		this.idAtividade = atividadeId;
		this.nome = nome;
		this.tarefasAssociadas = tarefasRelacionadas;
		this.horas = 0;
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
	
	public void addHoras(int horasAdd) {
		this.horas += horasAdd;
	}
	
	public void addHabilidades(String[] habilidades) {
		for (int y = 0; y < habilidades.length; y++) {
			habilidadesUniao.add(habilidades[y]);
		}
	}
	
	public int contarTarefasAssociadas() {
		return this.tarefasAssociadas.length;
	}

}
