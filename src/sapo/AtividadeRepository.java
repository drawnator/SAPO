package sapo;

public class AtividadeRepository {
	public String cadastrarAtividade(String nome,String descricao,String cpf) {
		return null;
	}
	public void encerrarAtividade(String atividadeId) {return;}
	public void desativarAtividade(String atividadeId) {return;}
	public void reabrirAtividade(String atividadeId) {return;}
	public String exibirAtividade(String atividadeId) {
		return null;
	}
	public void alterarDescricaoAtividade(String atividadeId,String descricao) {return;}
	public void alterarResponsavelAtividade(String atividadeId,String cpf) {return;}
	
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
