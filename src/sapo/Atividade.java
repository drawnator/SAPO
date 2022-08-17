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
	
	public Atividade(String nome,String decricao,String cpfResponsavel) {
		this.nome = nome;
		this.decricao = decricao;
		this.cpfResponsavel = cpfResponsavel;
		this.codigo = this.geraSigla(nome);
	}
	
	private String geraSigla(String nome) {
		String sigla = "";
		String vogais = "aeiouAEIOU ";
		for(int i =0;i<nome.length();i++) {
			String letra = "" + nome.charAt(i);
			if (codigo.length() < 3 || !vogais.contains(letra)) {
				sigla += letra;
			}
			}
		while (codigo.length() < 3){
			sigla += "X";
		}
		return sigla;
	}
	
	
	
	@Override
	public String toString() {
		return null;
	}
}
