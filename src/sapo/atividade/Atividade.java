package sapo.atividade;

import java.util.ArrayList;

import sapo.tarefa.Tarefa;

public class Atividade {
	private String nome;
	private String codigo;
	private String descricao;
	private String cpfResponsavel;
	private String status;
	private ArrayList<String> listaTarefas;

	public Atividade(String nome, String descricao, String cpfResponsavel, String sigla) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpfResponsavel;
		this.codigo = sigla;
		this.status = "aberta";
	}
	public String getNome() {return this.nome;}
	public String getDescricao() {return this.descricao;}
	public String getCodigo() {return this.codigo;}
	public String getcpfResponsavel() {return this.cpfResponsavel;}
	public ArrayList<String> gettarefascadastradas() {return this.listaTarefas;}

	public void encerrar() throws IllegalStateException {
		if (this.status == "aberta") {
			if (this.listaTarefas.size() == 0) {
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
			if (this.listaTarefas.size() == 0) {
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

	public void removerResponsavel() {
		this.cpfResponsavel = null;
	}
	
	public String getStatus() {
		return this.status;
	}

	public String addTarefa(Tarefa tarefa) {
		listaTarefas.add(tarefa.getId());
		return tarefa.getId();
	}
}
