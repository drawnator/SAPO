package sapo;

public class Facade {

    private PessoaController pessoaController;
    private AtividadeController atividadeController;
    private TarefaController tarefaController;
    private PessoaRepository pessoaRepository;
    private AtividadeRepository atividadeRepository;
    private TarefaRepository tarefaRepository;

    public Facade() {
        this.pessoaRepository = new PessoaRepository();
        this.atividadeRepository = new AtividadeRepository();
        this.tarefaRepository = new TarefaRepository();
        this.pessoaController = new PessoaController(this.pessoaRepository);
        this.atividadeController = new AtividadeController(this.atividadeRepository);
        this.tarefaController = new TarefaController(this.tarefaRepository);
    }
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		this.pessoaController.cadastrarPessoa(cpf, nome, habilidades);
	}
	
	public String exibirPessoa(String cpf) {
		return this.pessoaController.exibirPessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		this.pessoaController.alterarNomePessoa(cpf, novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.pessoaController.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		this.pessoaController.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		this.pessoaController.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.pessoaController.listarComentariosPessoa(cpf);
	}
	
	public String getNome(String cpf) {
		return this.pessoaController.getNome(cpf);
	}
	
	public Pessoa getPessoa(String cpf) {
		return this.pessoaController.getPessoa(cpf);
	}

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return this.atividadeController.cadastrarAtividade(nome, descricao, cpf);
    }

	public void encerrarAtividade(String atividadeId) {
		this.atividadeController.encerrarAtividade(atividadeId);
	}

	public void desativarAtividade(String atividadeId) {
		this.atividadeController.desativarAtividade(atividadeId);
	}

	public void reabrirAtividade(String atividadeId) {
		this.atividadeController.reabrirAtividade(atividadeId);
	}

	public String exibirAtividade(String atividadeId) {
		return this.atividadeController.exibirAtividade(atividadeId);
	}

	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		this.atividadeController.alterarDescricaoAtividade(atividadeId, descricao);
	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		this.atividadeController.alterarResponsavelAtividade(atividadeId, cpf);
	}

    String cadastrarTarefa(String atividadeId , String nome, String[] habilidades){
        return this.tarefaController.cadastrarTarefa(atividadeId, nome, habilidades);
    } 
    void alterarNomeTarefa(String idTarefa, String novoNome){
        this.tarefaController.alterarNomeTarefa(idTarefa, novoNome);
    }
    void alterarHabilidadesTarefa(String idTarefa, String[] habilidades){
        this.tarefaController.alterarHabilidadesTarefa(idTarefa, habilidades);
    }
    void adicionarHorasTarefa(String idTarefa, int horas){
        this.tarefaController.adicionarHorasTarefa(idTarefa, horas);
    }
    void removerHorasTarefa(String idTarefa, int horas){
        this.tarefaController.removerHorasTarefa(idTarefa, horas);
    }
    void concluirTarefa(String idTarefa){
        this.tarefaController.concluirTarefa(idTarefa);
    }
    void removerTarefa(String idTarefa){
        this.tarefaController.removerTarefa(idTarefa);
    }
    String exibirTarefa(String idTarefa){
        return this.tarefaController.exibirTarefa(idTarefa);
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.tarefaController.associarPessoaTarefa(cpf, idTarefa);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.tarefaController.removerPessoaTarefa(cpf, idTarefa);
    }

}