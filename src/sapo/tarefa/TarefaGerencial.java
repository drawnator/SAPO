package tarefa;

import java.util.HashSet;

public class TarefaGerencial {
	
	private String id;
	private String idAtividade;
	private String nome;
	private String[] idTarefasAssociadas;
	private int horas;
	private String[] habilidades;
	private HashSet<String> pessoas;
	private boolean concluida;
	
	
	
	public TarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
		this.idAtividade = atividadeId;
		this.nome = nome;
		this.idTarefasAssociadas = idTarefas;
		
	}

}
