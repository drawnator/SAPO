package tarefa;

public class TarefaGerencialService {
	
	public String cadastraTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
		TarefaGerencial tarefaGerencial = new TarefaGerencial(atividadeId, nome, habilidades, idTarefas);
	}
}
