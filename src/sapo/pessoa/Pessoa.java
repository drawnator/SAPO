package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pessoa {
	
	private String cpf;
	private String nome;
	private String[] habilidades;
	private List<Comentario> comentarios;
	
	public Pessoa(String cpf, String nome, String[] habilidades) {
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
		this.comentarios = new ArrayList<Comentario>();
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

	public String getAutor(int index) {
		return comentarios.get(index).getCpfautor();
	}
	
	public List<Comentario> getComentarios() {
		return this.comentarios;
	}
}
