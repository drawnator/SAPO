package sapo;

import java.util.Map;

public class Atividade {
	private String nome;
	private String codigo;
	private String descricao;
	private String cpfResponsavel;
	private String status;
	private int tarefasRealizadas;
	private int tarefasPendentes;
	private int tafetasCadastradas;
	private Map<String, Tarefa> listaTarefas;

	public Atividade(String nome, String descricao, String cpfResponsavel, String sigla) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpfResponsavel;
		this.codigo = sigla;
		this.status = "aberta";
		this.tafetasCadastradas = 0;
		this.tarefasPendentes = 0;
		this.tarefasRealizadas = 0;
	}

	public void encerrar() throws IllegalStateException {
		if (this.status == "aberta") {
			if (this.tarefasPendentes == 0) {
				this.status = "encerrada";
			} else {
				throw new IllegalStateException("tarefas ainda pendentes");
			}
		} else {
			throw new IllegalStateException("atividade nao aberta");
		}
	}

	public void desativar() throws IllegalStateException {
		if (this.status == "aberta") {
			if (this.tarefasPendentes == 0) {
				this.status = "desativada";
			} else {
				throw new IllegalStateException("tarefas ainda pendentes");
			}
		} else {
			throw new IllegalStateException("atividade nao aberta");
		}
	}

	public void reabrir() throws IllegalStateException {
		if (this.status == "aberta") {
			throw new IllegalStateException("atividade ja aberta");
		} else {
			this.status = "aberta";
			
		}
	}

	public void alterarDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void alterarResponsavel(String cpf) {
		this.cpfResponsavel = cpf;
	}
	
	@Override
	public String toString() {
		String texto = this.codigo+": "+this.nome; 
		return texto;
	}
}
