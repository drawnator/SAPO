package sapo.atividade;

import java.util.ArrayList;

import sapo.pessoa.PessoaService;
import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaService;

public class AtividadeController {
	AtividadeService as;
	PessoaService ps;
	TarefaService ts;

	public AtividadeController(AtividadeService as,PessoaService ps, TarefaService ts) {
		this.as = as;
		this.ps = ps;
		this.ts = ts;
		
	}
	
	public String getNome(String atividadeId) {return as.getNome(atividadeId);}
	public String getDescricao(String atividadeId) {return as.getDescricao(atividadeId);}
	public String getCodigo(String atividadeId) {return as.getCodigo(atividadeId);}
	public String getResponsavel(String atividadeId) {return as.getResponsavel(atividadeId);}
	public String getStatus(String atividadeId) {return as.getStatus(atividadeId);}
	public ArrayList<String> getTarefasCadastradas(String atividadeId) {return as.getTarefasCadastradas(atividadeId);}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		return as.cadastrarAtividade(nome, descricao, cpf);
	}
	
	public int addTarefa(String atividadeId, Tarefa tarefa) {
		return as.addTarefa(atividadeId, tarefa);
	}

	public void encerrarAtividade(String atividadeId) {
		as.encerrarAtividade(atividadeId);
	}

	public void desativarAtividade(String atividadeId) {
		as.encerrarAtividade(atividadeId);
	}

	public void reabrirAtividade(String atividadeId) {
		as.reabrirAtividade(atividadeId);
	}

	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		as.alterarDescricaoAtividade(atividadeId, descricao);
	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		as.alterarResponsavelAtividade(atividadeId, cpf);
	}

	public void removerResponsavel(String atividadeId) {
		as.removerResponsavel(atividadeId);
	}
	
	public String exibirAtividade(String atividadeId) {
		return as.representacao(ps, ts, atividadeId);

	}

}
