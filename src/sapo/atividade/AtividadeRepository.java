package sapo.atividade;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	public Set<Atividade> busca(String termo) {
		return this.listaAtividades.values().stream()
					.filter((x) -> Arrays.binarySearch(x.getNome().toLowerCase().split(" "), termo.toLowerCase()) > 0
							|| Arrays.binarySearch(x.getDescricao().toLowerCase().split(" "), termo.toLowerCase()) > 0
							|| x.getCodigo().contains(termo))
					.collect(Collectors.toSet());
	}

}
