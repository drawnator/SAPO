package sapo;

import java.util.HashMap;

public class PessoaRepository {
	
	private HashMap<String, Pessoa> pessoasCadastradas;
	
	public PessoaRepository() {
		this.pessoasCadastradas = new HashMap<String, Pessoa>();	
	}
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) throws IllegalArgumentException{
		if (cpf.equals("")) {
			throw new IllegalArgumentException("cpf inválido");
		}
		else if (nome.equals("")) {
			throw new IllegalArgumentException("nome inválido");
		}
		Pessoa novaPessoa = new Pessoa(cpf, nome, habilidades);
		pessoasCadastradas.put(cpf, novaPessoa);
	}
	
	public String exibirPessoa(String cpf) {
		return pessoasCadastradas.get(cpf).toString();
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		if (novoNome.equals("")) {
			throw new IllegalArgumentException("nome inválido");
		}
		pessoasCadastradas.get(cpf).setNome(novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		pessoasCadastradas.get(cpf).setHabilidades(novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		pessoasCadastradas.get(cpf).setNome("");
		String[] vaz = new String[0];
		pessoasCadastradas.get(cpf).setHabilidades(vaz);
		pessoasCadastradas.remove(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		pessoasCadastradas.get(cpf).adicionaComentario(comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return pessoasCadastradas.get(cpf).exibirComentarios();
		
	}
	public String getAutor(String cpf, int index) {
		return getNome(pessoasCadastradas.get(cpf).getAutor(index));
	}
	
	public String getNome(String cpf) {
		return pessoasCadastradas.get(cpf).getNome();
	}
	
	public Pessoa getPessoa(String cpf) {
		return pessoasCadastradas.get(cpf);
	}
}
