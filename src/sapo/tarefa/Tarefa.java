package sapo.tarefa;

import java.util.HashSet;
import java.util.Set;

public class Tarefa {
    private String id;  
    private String idAtividade;
    private int duracao;
    private String nome;
    private String[] habilidades;
    private HashSet<String> pessoas;
    private boolean concluida;
    private boolean presenteGerencial;
    
    public Tarefa(String id, String nome, String[] habilidades, int tarefasCadastradas) {
        this.idAtividade = id;
        this.id = id + '-' + tarefasCadastradas;
        this.nome = nome;
        this.habilidades = habilidades;
        this.duracao = 0;
        this.concluida = false;
        this.presenteGerencial = false;
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String[] getHabilidades() {
        return this.habilidades;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public void mudarHoras(int horas) {
        if (!this.concluida) {
            this.duracao += horas;
        }
    }

    public void concluir() {
        this.concluida = true;
    }

    public void associarPessoa(String cpf) {
        if (!this.concluida) {
            this.pessoas.add(cpf);
        }
    }

    public void removerPessoa(String cpf) {
        if (!this.concluida) {
            this.pessoas.remove(cpf);
        }
    }

    public Set<String> getPessoas() {
        return this.pessoas;
    }

    public String getIdAtividade() {
        return this.idAtividade;
    }
    
    public boolean getConcluida() {
    	return this.concluida;
    }
    
    public boolean presenteGerencial() {
    	this.presenteGerencial = !this.presenteGerencial;
    	return this.presenteGerencial;
    }
    
    public boolean getPresenteGerencial() {
    	return this.presenteGerencial;
    }
}