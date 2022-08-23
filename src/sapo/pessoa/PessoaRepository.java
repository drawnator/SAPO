package sapo.pessoa;

import java.util.HashMap;

public class PessoaRepository {
	
	private HashMap<String, Pessoa> pessoasCadastradas;
	
	public PessoaRepository() {
		this.pessoasCadastradas = new HashMap<String, Pessoa>();	
	}
	
	public HashMap<String, Pessoa> getMap() {
		return this.pessoasCadastradas;
	}
	
	public void cadastraPessoa(String cpf, Pessoa novaPessoa) {
		pessoasCadastradas.put(cpf, novaPessoa);
	}
	
	public String getNome(String cpf) {
		return pessoasCadastradas.get(cpf).getNome();
	}
	
	public Pessoa getPessoa(String cpf) {
		return pessoasCadastradas.get(cpf);
	}
	public String[] getHabilidades(String cpf) {
		return pessoasCadastradas.get(cpf).getHabilidades();
	}
	
	public void removePessoa(String cpf) {
		pessoasCadastradas.remove(cpf);
	}
}
