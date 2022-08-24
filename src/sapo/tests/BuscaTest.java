package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuscaTest extends BaseTest {

	@Test
	void testExibirPessoas() {
		String[] habilidade = {"canta muito"};
		
		this.pessoaController.cadastrarPessoa("111.111.111-111", "Pedrinho doido", habilidade);
		assertEquals(this.pessoaController.getPessoa("111.111.111-111").getNome(), this.busca.exibirPessoas("doido")[0]);
	}
	
	@Test
	void testBuscarAtividade() {
		
	}
	
	@Test
	void testBuscarTarefas() {
		
	}
	
	@Test
	void testBuscarTarefas2() {
		
	}
	
	@Test
	void testSugerirTarefas() {
		
	}
	
	@Test
	void testBuscasMaisRecentes() {
		
	}
	
	@Test
	void testExibirHistoricoBusca() {
		
	}

}
