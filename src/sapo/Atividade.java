package sapo;

import java.util.Map;

public class Atividade {
	private String nome;
	private String codigo;
	private String decricao;
	private String cpfResponsavel;
	private String status;
	private int tarefasRealizadas;
	private int tarefasPendentes;
	private int tafetasCadastradas;
	private Map<String, Tarefas> listaTarefas;

	public Atividade(String nome, String decricao, String cpfResponsavel, String sigla) {
		this.nome = nome;
		this.decricao = decricao;
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

	@Override
	public String toString() {
		return null;
	}
}
