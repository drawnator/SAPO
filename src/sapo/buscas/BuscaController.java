package sapo.buscas;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaService;

public class BuscaController {
	AtividadeService as;
	PessoaService ps;
	TarefaService ts;

	public BuscaController(AtividadeService as,PessoaService ps, TarefaService ts) {
		this.as = as;
		this.ps = ps;
		this.ts = ts;
		
	}

	public String[] exibirPessoas(String consulta) {return null;}

	public String[] buscarAtividade(String consulta){return null;}

	public String[] buscarTarefas(String nome){return null;}

	public String[] buscarTarefas(String idAtividade,String nome){return null;}

	public String[] sugerirTarefas(String idAtividade,String cpf){return null;}

	public String[] buscasMaisRecentes(int nBuscas) {return null;}

	public String[] exibirHistóricoBusca(int indexBusca) {return null;}
}
