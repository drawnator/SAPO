package sapo.tarefa;

import java.util.HashMap;
import java.util.Map;

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
    public void removerTarefa(String idTarefa){
        this.tarefas.remove(idTarefa);
    }
    public int getTarefasCadastradas() {
        return tarefasCadastradas;
    }
    public void incrementaTarefasCadastradas() {
        this.tarefasCadastradas++;
    }
}