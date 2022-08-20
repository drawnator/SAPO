package sapo;

import java.util.HashMap;
import java.util.Map;

public class AtividadeRepository {
	private Map<String,Atividade> listaAtividades;
	public AtividadeRepository() {
		this.listaAtividades = new HashMap<String,Atividade>();
	}
	
	public Map<String,Atividade> getListaAtividade(){
		return this.listaAtividades;
	}
	
	public int tamanhoListaAtividade() {
		return this.listaAtividades.size();
	}
	
	public void cadastrarAtividade(String id, Atividade novaAtividade) {
		this.listaAtividades.put(id, novaAtividade);
	}
	
	public Atividade getAtividade(String ativadeId) {
		return listaAtividades.get(ativadeId);
	}
	
	@Override
	public String toString() {return null;}

}
