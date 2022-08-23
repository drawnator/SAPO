package sapo.tarefa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TarefaRepository {
    private Map<String, Tarefa> tarefas;
    private int tarefasCadastradas;

    public TarefaRepository() {
        this.tarefas = new HashMap<String, Tarefa>();
        this.tarefasCadastradas = 0;
    }
    
    public Tarefa getTarefa(String id) {
        return this.tarefas.get(id);
    }
    public void cadastrarTarefa(Tarefa tarefa) {
        this.tarefas.put(tarefa.getId(), tarefa);
    } 
    public void cadastrarTarefaGerencial(TarefaGerencial tarefa) {
        this.tarefas.put(tarefa.getId(), tarefa);
    } 
    public void removerTarefa(String idTarefa){
        this.tarefas.remove(idTarefa);
    }
    public int getTarefasCadastradas() {
        return tarefasCadastradas;
    }
    public void incrementaTarefasCadastradas() {
        this.tarefasCadastradas++;
    }
    
    public Set<Tarefa> busca(String termo) {
		return this.tarefas.values().stream()
					.filter((x) -> Arrays.binarySearch(x.getNome().toLowerCase().split(" "), termo.toLowerCase()) > 0)
					.collect(Collectors.toSet());
	}
    public int contaTarefasAssociadas(TarefaGerencial tarefaGer) {
    	return tarefaGer.contarTarefasAssociadas();
    }
}