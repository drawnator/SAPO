package sapo;

public class PessoaController {
	
	PessoaRepository pr;
	
	public PessoaController(PessoaRepository pr) {
		this.pr = pr;
	}
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		pr.cadastrarPessoa(cpf, nome, habilidades);
	}
	
	public String exibirPessoa(String cpf) {
		return pr.exibirPessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		pr.alterarNomePessoa(cpf, novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		pr.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		pr.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		pr.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return pr.listarComentariosPessoa(cpf);
	}
	
	public String getNome(String cpf ) {
		return pr.getNome(cpf);
	}
	
	public Pessoa getPessoa(String cpf) {
		return pr.getPessoa(cpf);
	}
}
