package src;

public class Comentario {
	
	public String comentario;
	public String cpfAutor;
	
	public Comentario(String comentario, String cpfAutor) {
		this.comentario = comentario;
		this.cpfAutor = cpfAutor;
	}
	public String getComentario() {
		return this.comentario;
	}
	public String getCpfautor() {
		return this.cpfAutor;
	}
	
}
