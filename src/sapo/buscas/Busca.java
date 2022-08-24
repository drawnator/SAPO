package sapo.buscas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaService;

public class Busca {
	AtividadeService as;
	PessoaService ps;
	TarefaService ts;
	ArrayList<String[]> historicoBusca;
	ArrayList<String> historicoValores;

	public Busca(AtividadeService as, PessoaService ps, TarefaService ts) {
		this.as = as;
		this.ps = ps;
		this.ts = ts;
		this.historicoBusca = new ArrayList<String[]>();
		this.historicoValores = new ArrayList<String>();
	}

	public String[] exibirPessoas(String consulta) {
		String[] resultado = Arrays.stream(ps.busca(consulta).toArray()).toArray(String[]::new);
		String[] tipo = {"PESSOA"};
		historicoValores.add(consulta);
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] buscarAtividade(String consulta) {
		String[] resultado = Arrays.stream(as.busca(consulta).toArray()).toArray(String[]::new);
		String[] tipo = {"ATIVIDADE"};
		historicoValores.add(consulta);
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] buscarTarefas(String nome) {
		String[] resultado = Arrays.stream(ts.busca(nome).toArray()).toArray(String[]::new);
		String[] tipo = {"TAREFA"};
		historicoValores.add(nome);
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] buscarTarefas(String idAtividade, String nome) {
		String[] resultado = Arrays.stream(as.busca(idAtividade,nome).toArray()).toArray(String[]::new);
		String[] tipo = {"TAREFA"};
		historicoValores.add(nome);
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] sugerirTarefas(String idAtividade, String cpf) {
		return null;
	}

	public String[] buscasMaisRecentes(int nBuscas) {
		String[] recentes = new String[nBuscas];
		for(int i = 0; i < nBuscas;i++) {
			recentes[i] = historicoValores.get(nBuscas-i);
		}
		return recentes;
	}

	public String[] exibirHistoricoBusca(int indexBusca) {
		return historicoBusca.get(indexBusca);
	}
	
	private void addHistorico(String[] tipo, String[] resultado) {
		historicoBusca.add( Arrays.stream(Stream.concat(Arrays.stream(tipo), Arrays.stream(resultado)).toArray()).toArray(String[]::new));
	}
}
