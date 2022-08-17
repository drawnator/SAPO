package sapo;

import java.util.Map;

public class Atividade {
	private String nome;
	private String codigo;
	private String decricao;
	private String cpfResponsavel;
	private int tarefasRealizadas;
	private int tafetasCadastradas;
	private Map<String,Tarefas> listaTarefas;
	
	public Atividade(String nome,String decricao,String cpfResponsavel,String sigla) {
		this.nome = nome;
		this.decricao = decricao;
		this.cpfResponsavel = cpfResponsavel;
		this.codigo = sigla;
	}	
	
	@Override
	public String toString() {
		return null;
	}
}
