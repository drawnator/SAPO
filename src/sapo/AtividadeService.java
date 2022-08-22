package sapo;

import java.util.ArrayList;
import java.util.List;

public class AtividadeService {
	private AtividadeRepository ar;
	private ArrayList<String> tarefas;

	public AtividadeService() {
		this.ar = new AtividadeRepository();
		this.tarefas = new ArrayList<String>();
	}

	public String[] AtributosAtividade(String atividadeId) {
		String[] atributos = new String[5];
		atributos[0] = ar.getAtividade(atividadeId).getNome();
		atributos[1] = ar.getAtividade(atividadeId).getDescricao();
		atributos[2] = ar.getAtividade(atividadeId).getCodigo();
		atributos[3] = ar.getAtividade(atividadeId).getcpfResponsavel();
		atributos[4] = ar.getAtividade(atividadeId).gettarefascadastradas();
		return atributos;
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		int numeroAtividade = ar.tamanhoListaAtividade();
		String id = geraSigla(nome) + "-" + numeroAtividade;
		Atividade novaAtividade = new Atividade(nome, descricao, cpf, id);
		ar.cadastrarAtividade(id, novaAtividade);
		return id;
	}

	public void encerrarAtividade(String atividadeId) {
		ar.getAtividade(atividadeId).encerrar();
	}

	public void desativarAtividade(String atividadeId) {
		ar.getAtividade(atividadeId).desativar();
	}

	public void reabrirAtividade(String atividadeId) {
		ar.getAtividade(atividadeId).reabrir();
	}

	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		ar.getAtividade(atividadeId).alterarDescricao(descricao);
	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		ar.getAtividade(atividadeId).alterarResponsavel(cpf);
	}

	public void removerResponsavel(String atividadeId) {
		ar.getAtividade(atividadeId).alterarResponsavel(null);
	}
	
	public String representacao(PessoaService ps, TarefaService ts,String atividadeId) {
		String nomeAtividade = ar.getAtividade(atividadeId).getNome();
		String codigoAtividade = ar.getAtividade(atividadeId).getCodigo();
		String cpfResponsa = ar.getAtividade(atividadeId).getcpfResponsavel();
		String descricao = ar.getAtividade(cpfResponsa).getDescricao();
		String texto = codigoAtividade + ": " + nomeAtividade + "\n";
		if (cpfResponsa != null) {
			texto += "Responsavel: "+ ps.getNome(cpfResponsa) + " - " + cpfResponsa + "\n";
		}
		texto += "===\n";
		texto += descricao + "\n";
		texto += "===\n";
		
		return texto;

	}
	
	private String geraSigla(String nome) {
		String sigla = "";
		String vogais = "aeiouAEIOU ";
		for (int i = 0; i < nome.length(); i++) {
			String letra = "" + nome.charAt(i);
			if (sigla.length() < 3 || !vogais.contains(letra)) {
				sigla += letra;
			}
		}
		while (sigla.length() < 3) {
			sigla += "X";
		}
		return sigla;
	}

}
