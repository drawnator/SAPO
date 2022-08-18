package sapo;

import java.util.HashMap;
import java.util.Map;

public class TarefaRepository {
    private Map<String, Tarefa> tarefas;
    int tarefasCadastradas;

    public TarefaRepository() {
        this.tarefas = new HashMap<String, Tarefa>();
        this.tarefasCadastradas = 0;
    }
    
    String cadastrarTarefa(String atividadeId , String nome, String[] habilidades){
        Tarefa tarefa = new Tarefa(atividadeId, nome, habilidades, this.tarefasCadastradas);
        this.tarefas.put(tarefa.getId(), tarefa);
        this.tarefasCadastradas++;
        return tarefa.getId();  
    } 
    void alterarNomeTarefa(String idTarefa, String novoNome){
        this.tarefas.get(idTarefa).setNome(novoNome);
    }
    void alterarHabilidadesTarefa(String idTarefa, String[] habilidades){
        this.tarefas.get(idTarefa).setHabilidades(habilidades);
    }
    void adicionarHorasTarefa(String idTarefa, int horas){
        this.tarefas.get(idTarefa).mudarHoras(horas);
    }
    void removerHorasTarefa(String idTarefa, int horas){
        this.tarefas.get(idTarefa).mudarHoras(-horas);
    }
    void concluirTarefa(String idTarefa){
        this.tarefas.get(idTarefa).concluir();
    }
    void removerTarefa(String idTarefa){
        this.tarefas.remove(idTarefa);
    }
    String exibirTarefa(String idTarefa){
        return this.tarefas.get(idTarefa).toString();
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.tarefas.get(idTarefa).associarPessoa(cpf);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.tarefas.get(idTarefa).removerPessoa(cpf);
    }
}