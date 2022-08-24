package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaService;

public class Pessoa {
	
	protected String cpf;
	protected String nome;
	protected String[] habilidades;
	private List<Comentario> comentarios;
	protected Set<String> tarefasAssociadas;
	protected int nivel;
	
	public Pessoa(String cpf, String nome, String[] habilidades) {
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
		this.tarefasAssociadas = new HashSet<>();
		this.comentarios = new ArrayList<Comentario>();
		this.nivel = 0;
	}

	public Pessoa(String cpf, String nome, String[] habilidades, int nivel) {
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
		this.tarefasAssociadas = new HashSet<>();
		this.comentarios = new ArrayList<Comentario>();
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		Arrays.sort(habilidades);
		String exibicao = nome + " – " + cpf;
		for (int i = 0; i < habilidades.length; i++) {
			exibicao += "\n- " + habilidades[i];
		}
		return exibicao;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	
	public String[] getHabilidades() {
		return this.habilidades;
	}

	public int getNivel(TarefaService ts){
		int tarefasAndamento = 0;
		int tarefasFinalizadas = 0;
		for(String idTarefa: this.tarefasAssociadas){
			Tarefa tarefa = ts.getTarefa(idTarefa);
			if (tarefa.getConcluida()){
				tarefasFinalizadas++;
			}
			else{
				tarefasAndamento++;
			}
			this.tarefasAssociadas.remove(idTarefa);
		}
		this.nivel += tarefasAndamento/2 + tarefasFinalizadas;
		return this.nivel;
	}
	
	public String[] getHabilidadesLower() {
		String[] habilidadesclone = new String[this.habilidades.length];
		for(int i = 0; i < this.habilidades.length;i++) {
			habilidadesclone[i] = this.habilidades[i].toLowerCase();
		}
		return habilidadesclone;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setHabilidades(String[] novasHabilidades) {
		this.habilidades = novasHabilidades;
	}
	
	public void adicionaComentario(String comentario, String autorCpf) {
		Comentario novoComentario = new Comentario(comentario, autorCpf);
		comentarios.add(novoComentario);
	}
	
	public String exibirComentarios() {
		String exibicao = nome + " - " + cpf + "\nComentarios:\n";
		for (int i = 0; i < comentarios.size(); i++) {
			exibicao += "-- " + comentarios.get(i) + getAutor(i); 
		}
		return exibicao;
	}
	public String getAutor(int index) {
		return comentarios.get(index).getCpfautor();
	}
	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void associarTarefa(String id){
		this.tarefasAssociadas.add(id);
	}

	public void removerTarefa(String id){
		this.tarefasAssociadas.remove(id);
	}
}
