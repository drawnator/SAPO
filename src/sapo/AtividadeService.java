package sapo;

public class AtividadeService {
	AtividadeRepository ar;

	public AtividadeService(AtividadeRepository ar) {
		this.ar = ar;
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

	public String exibirAtividade(String atividadeId) {
		return ar.getAtividade(atividadeId).toString();
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
	
	public String representacao(PessoaService ps,String atividadeId) {
		String nomeAtividade = ar.getAtividade(atividadeId).getNome();
		String codigoAtividade = ar.getAtividade(atividadeId).getCodigo();
		String cpfResponsa = ar.getAtividade(atividadeId).getcpfResponsavel();
		String texto = codigoAtividade + ": " + nomeAtividade + "\n";
		if (cpfResponsa != null) {
			texto += "Responsavel: "+ ps.getNome(cpfResponsa) + " - " + cpfResponsa + "\n";
		}
		
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
