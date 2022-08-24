package sapo.pessoa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import sapo.tarefa.TarefaService;

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

	public void associarPessoaTarefa(String cpf, String id){
		this.pessoasCadastradas.get(cpf).associarTarefa(id);
	}

	public void removerPessoaTarefa(String cpf, String id){
		this.pessoasCadastradas.get(cpf).removerTarefa(id);
	}

	public int pegarNivel(String cpf, TarefaService ts){
		return this.pessoasCadastradas.get(cpf).getNivel(ts);
	}

	public void cadastrarAluno(String cpf, Aluno aluno){
		this.pessoasCadastradas.put(cpf, aluno);
	}

	public void cadastrarProfessor(String cpf, Professor professor){
		this.pessoasCadastradas.put(cpf, professor);
	}
	
	public Set<Pessoa> busca(String termo) {
		return this.pessoasCadastradas.values().stream()
					.filter((x) -> Arrays.binarySearch(x.getNome().split(" "), termo) > 0
							|| Arrays.binarySearch(x.getHabilidades(), termo) > 0
							|| x.getCpf().contains(termo))
					.collect(Collectors.toSet());
	}
}
