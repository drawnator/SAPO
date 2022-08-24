package sapo.pessoa;

import java.util.NoSuchElementException;

import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaService;

public class PessoaController {
	
	PessoaService ps;
	TarefaService ts;
	
	public PessoaController(PessoaService ps, TarefaService ts) {
		this.ps = ps;
		this.ts = ts;
	}
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		ps.cadastrarPessoa(cpf, nome, habilidades);
	}
	
	public String exibirPessoa(String cpf) throws NoSuchElementException {
		return ps.exibirPessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		ps.alterarNomePessoa(cpf, novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		ps.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		ps.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		ps.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return ps.listarComentariosPessoa(cpf);
	}
	
	public String getNome(String cpf) {
		return ps.getNome(cpf);
	}
	
	public Pessoa getPessoa(String cpf) {
		return ps.getPessoa(cpf);
	}

	public void cadastrarAluno(String cpf, String matr, int periodo, String[] habilidades){
		//this.ps.cadastrarAluno(cpf, matr, periodo, habilidades);
	}

	public void cadastrarProfessor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades){
	}

	public void definirFuncaoAluno(String cpf, String matr, int periodo){
		
	}

	public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas){

	}

	public void removerFuncao(String cpf){

	}

	public int pegarNivel(String cpf){
		return this.ps.pegarNivel(cpf, this.ts);
	}

	public String[] listarPessoas(){

	}
}
