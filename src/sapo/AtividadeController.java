package sapo;

public class AtividadeController {
	AtividadeRepository ar;
	public AtividadeController(AtividadeRepository ar){
		this.ar = ar;
	}
	
	public String cadastrarAtividade(String nome,String descricao,String cpf) {
		return ar.cadastrarAtividade(nome, descricao, cpf);
	}
	
	public void encerrarAtividade(String atividadeId) {
		ar.encerrarAtividade(atividadeId);
	}
	
	public void desativarAtividade(String atividadeId) {
		ar.desativarAtividade(atividadeId);
	}
	
	public void reabrirAtividade(String atividadeId) {
		ar.reabrirAtividade(atividadeId);
	}
	
	public String exibirAtividade(String atividadeId) {
		return ar.exibirAtividade(atividadeId);
	}
	
	public void alterarDescricaoAtividade(String atividadeId,String descricao) {
		ar.alterarDescricaoAtividade(atividadeId, descricao);
	}
	
	public void alterarResponsavelAtividade(String atividadeId,String cpf) {
		ar.alterarDescricaoAtividade(atividadeId, cpf);
	}


}
