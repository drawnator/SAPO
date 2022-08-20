package sapo;

public class Facade {

    private PessoaController pessoaController;
    private AtividadeController atividadeController;
    private TarefaController tarefaController;

    public Facade() {

        this.pessoaController = new PessoaController();

        // … demais controllers

    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {

        this.pessoaController.cadastrarPessoa(cpf, nome, habilidades)

    }

    // demais métodos …

}