package sapo.atividade;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import sapo.tarefa.Tarefa;

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
					.filter((x) -> Arrays.binarySearch(x.getNome().split(" "), termo) > 0
							|| Arrays.binarySearch(x.getDescricao().split(" "), termo) > 0
							|| x.getCodigo().contains(termo))
					.collect(Collectors.toSet());
	}
	
	public Set<Tarefa> busca(String IdAtividade, String termo) {
		return this.listaAtividades.get(IdAtividade).gettarefascadastradas().values().stream()
					.filter((x) -> Arrays.binarySearch(x.getNome().split(" "), termo) > 0)
					.collect(Collectors.toSet());
	}

}
