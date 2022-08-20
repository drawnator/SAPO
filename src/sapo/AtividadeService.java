package sapo;

public class AtividadeService {
	AtividadeRepository ar;
	
	public AtividadeService(AtividadeRepository ar) {
		this.ar = ar;
	}
	
	public String cadastrarAtividade(String nome,String descricao,String cpf) {
		return null;
	}
	
	private String geraSigla(String nome) {
		String sigla = "";
		String vogais = "aeiouAEIOU ";
		for(int i =0;i<nome.length();i++) {
			String letra = "" + nome.charAt(i);
			if (sigla.length() < 3 || !vogais.contains(letra)) {
				sigla += letra;
			}
			}
		while (sigla.length() < 3){
			sigla += "X";
		}
		return sigla;
	}
	
}
