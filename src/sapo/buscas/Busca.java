package sapo.buscas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import sapo.atividade.Atividade;
import sapo.atividade.AtividadeService;
import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;
import sapo.tarefa.Tarefa;
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
		Set<Pessoa> encontro = ps.busca(consulta);
		String[] resultado = new String[encontro.size()];
		int iterator = 0;
		for (Pessoa pessoa : encontro) {
			resultado[iterator] = pessoa.getNome();
		}
		String[] tipo = { "PESSOA" };
		historicoValores.add(consulta);
		addHistorico(tipo, resultado);
		return resultado;
	}

	public String[] buscarAtividade(String consulta) {
		Set<Atividade> encontro = as.busca(consulta);
		String[] resultado = new String[encontro.size()];
		int iterator = 0;
		for (Atividade Atividade : encontro) {
			resultado[iterator] = Atividade.getNome();
		}
		String[] tipo = { "ATIVIDADE" };
		historicoValores.add(consulta);
		addHistorico(tipo, resultado);
		return resultado;
	}

	public String[] buscarTarefas(String nome) {
		Set<Tarefa> encontro = ts.busca(nome);
		String[] resultado = new String[encontro.size()];
		int iterator = 0;
		for (Tarefa Tarefa : encontro) {
			resultado[iterator] = Tarefa.getNome();
		}
		String[] tipo = { "TAREFA" };
		historicoValores.add(nome);
		addHistorico(tipo, resultado);
		return resultado;
	}

	public String[] buscarTarefas(String idAtividade, String nome) {
		Set<Tarefa> encontro = as.busca(idAtividade, nome);
		String[] resultado = new String[encontro.size()];
		int iterator = 0;
		for (Tarefa Tarefa : encontro) {
			resultado[iterator] = Tarefa.getNome();
		}
		String[] tipo = { "TAREFA" };
		historicoValores.add(nome);
		addHistorico(tipo, resultado);
		return resultado;
	}

	public String[] sugerirTarefas(String idAtividade, String cpf) {
		return null;
	}

	public String[] buscasMaisRecentes(int nBuscas) {
		String[] recentes = new String[nBuscas];
		for (int i = 0; i < nBuscas; i++) {
			recentes[i] = historicoValores.get(nBuscas - i);
		}
		return recentes;
	}

	public String[] exibirHistoricoBusca(int indexBusca) {
		return historicoBusca.get(indexBusca);
	}

	private void addHistorico(String[] tipo, String[] resultado) {
		historicoBusca.add(Arrays.stream(Stream.concat(Arrays.stream(tipo), Arrays.stream(resultado)).toArray())
				.toArray(String[]::new));
	}
}
