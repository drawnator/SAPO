package sapo;

import java.util.HashMap;
import java.util.Set;

public class Tarefa {
    String id;  
    String nomeAtividade;
    int duracao;
    String nome;
    String[] habilidades;
    HashMap<String, Pessoa> pessoas;
    boolean concluida;
    
    public Tarefa(String id, String nome, String[] habilidades, int tarefasCadastradas) {
        this.id = id + '-' + tarefasCadastradas;
        this.nomeAtividade = id;
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

    public void associarPessoa(Pessoa pessoa) {
        if (!this.concluida) {
            this.pessoas.put(pessoa.getCpf(), pessoa);
        }
    }

    public void removerPessoa(String cpf) {
        if (!this.concluida) {
            this.pessoas.remove(cpf);
        }
    }

    public String toString() {
        String output = "";
        output += this.nome + " - " + this.id + "\n";
        output +=  "- " + this.nomeAtividade + "\n";
        for (String habilidade : this.habilidades) {
            output += habilidade;
            if (habilidade != this.habilidades[this.habilidades.length - 1]) {
                output += ", ";
            }
        output += "\n(" + this.duracao + " hora(s) executadas))\n";
        output += "===\n";
        output += "Equipe:\n";
        for (Pessoa pessoa : this.pessoas.keySet()) {
            output += pessoa + " - " + this.pessoas.get(pessoa.getCpf());
        }
        return output;
    }



    

}