package sapo.pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class PessoaService {
	
	private PessoaRepository pr;
	
	public PessoaService() {
		this.pr = new PessoaRepository();
	}
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) throws IllegalArgumentException{
		if (cpf.equals("")) {
			throw new IllegalArgumentException("cpf invalido");
		}
		else if (nome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		Pessoa novaPessoa = new Pessoa(cpf, nome, habilidades);
		pr.cadastraPessoa(cpf, novaPessoa);
	}
	
	public String exibirPessoa(String cpf) throws NoSuchElementException {
		if (pr.getPessoa(cpf) == null) {
			throw new NoSuchElementException();
		}
		return pr.getPessoa(cpf).toString();
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		if (novoNome.equals("")) {
			throw new IllegalArgumentException("nome invalido");
		}
		pr.getPessoa(cpf).setNome(novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		pr.getPessoa(cpf).setHabilidades(novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		pr.getPessoa(cpf).setNome("");
		String[] vaz = new String[0];
		pr.getPessoa(cpf).setHabilidades(vaz);
		pr.removePessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		pr.getPessoa(cpf).adicionaComentario(comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return exibirComentarios(cpf);
		
	}
	public String getAutor(String cpf, int index) {
		return getNome(pr.getPessoa(cpf).getAutor(index));
	}
	
	public String getNome(String cpf) {
		return pr.getPessoa(cpf).getNome();
	}
	
	public Pessoa getPessoa(String cpf) {
		return pr.getPessoa(cpf);
	}
	
	public HashMap<String, Pessoa> getHashMap() {
		return pr.getMap();
	}
	
	public Set<Pessoa> busca(String termo){
		return pr.busca(termo);
	}
	
	public String exibirComentarios(String cpf) {
		String exibicao = pr.getNome(cpf) + " - " + cpf + "\nComentarios:\n";
		List<Comentario> listaComent = pr.getPessoa(cpf).getComentarios();
		for (int i = 0; i < listaComent.size(); i++) {
			exibicao += "- " + listaComent.get(i).toString() +" ("+ pr.getNome(listaComent.get(i).getCpfautor()) + ")"; 
		}
		return exibicao;
	}
}
