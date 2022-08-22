package sapo.tarefa;

public class TarefaGerencialController {
	
	TarefaGerencialService tgs;
	
	public TarefaGerencialController(TarefaGerencialService tgs) {
		this.tgs = tgs;
	}
	
	public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
		return null;
		// TBD
	}
	
	public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
		
	}
	
	public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
		
	}
	public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
		return -1;
		// TBD
	}
}
