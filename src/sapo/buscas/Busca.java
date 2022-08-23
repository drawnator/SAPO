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

	public Busca(AtividadeService as, PessoaService ps, TarefaService ts) {
		this.as = as;
		this.ps = ps;
		this.ts = ts;

	}

	public String[] exibirPessoas(String consulta) {
		String[] resultado = (String[]) ps.busca(consulta).toArray();
		String[] tipo = {"PESSOA"};
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] buscarAtividade(String consulta) {
		String[] resultado = (String[]) as.busca(consulta).toArray();
		String[] tipo = {"ATIVIDADE"};
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] buscarTarefas(String nome) {
		String[] resultado = (String[]) ts.busca(nome).toArray();
		String[] tipo = {"TAREFA"};
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] buscarTarefas(String idAtividade, String nome) {
		String[] resultado = (String[]) as.busca(idAtividade,nome).toArray();
		String[] tipo = {"TAREFA"};
		addHistorico(tipo,resultado);
		return resultado;
	}

	public String[] sugerirTarefas(String idAtividade, String cpf) {
		return null;
	}

	public String[] buscasMaisRecentes(int nBuscas) {
		return null;
	}

	public String[] exibirHistoricoBusca(int indexBusca) {
		return null;
	}
	
	private void addHistorico(String[] tipo, String[] resultado) {
		historicoBusca.add((String[]) Stream.concat(
				Arrays.stream(tipo), Arrays.stream(resultado)).toArray());
	}
}
