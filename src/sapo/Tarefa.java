package sapo;

import java.util.HashMap;
import java.util.Set;

public class Tarefa {
    
    String id;  
    String atividade;
    int duracao;
    String nome;
    String[] habilidades;
    Set<String> pessoas;
    boolean concluida;
    
    public Tarefa(String id, String nome, String[] habilidades, int tarefasCadastradas) {
        this.id = id + '-' + tarefasCadastradas;
        this.atividade = id;
        this.nome = nome;
        this.habilidades = habilidades;
        this.duracao = 0;
        this.concluida = false;
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

    public String toString() {
        return null;
        /*this.nome + " - " + this.id + "\n"
                + "- " + this.atividade + "\n"
                + "Horas: " + this.duracao + "\n"
                + "Pessoas: " + this.pessoas + "\n"
                + "Concluida: " + this.concluida;*/
    }



    

}