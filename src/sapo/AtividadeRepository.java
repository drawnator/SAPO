package sapo;

import java.util.HashMap;
import java.util.Map;

public class AtividadeRepository {
	private Map<String,Atividade> listaAtividades;
	public AtividadeRepository() {
		this.listaAtividades = new HashMap<String,Atividade>();
	}
	public String cadastrarAtividade(String nome,String descricao,String cpf) {
		int numeroAtividade = listaAtividades.size();
		String id = geraSigla(nome)+"-"+numeroAtividade;
		Atividade novaAtividade = new Atividade(nome,descricao,cpf,id);
		this.listaAtividades.put(id, novaAtividade);
		return id;
	}
	public void encerrarAtividade(String atividadeId) {
		listaAtividades.get(atividadeId).encerrar();
	}
	public void desativarAtividade(String atividadeId) {
		listaAtividades.get(atividadeId).desativar();
	}
	public void reabrirAtividade(String atividadeId) {
		listaAtividades.get(atividadeId).reabrir();
	}
	public String exibirAtividade(String atividadeId) {
		return listaAtividades.get(atividadeId).toString();
	}
	public void alterarDescricaoAtividade(String atividadeId,String descricao) {
		listaAtividades.get(atividadeId).alterarDescricao(descricao);
	}
	public void alterarResponsavelAtividade(String atividadeId,String cpf) {
		listaAtividades.get(atividadeId).alterarResponsavel(cpf);
	}
	
	@Override
	public String toString() {return null;}
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
