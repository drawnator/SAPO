package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuscaTest extends BaseTest {

	@Test
	void testExibirPessoas() {
		String[] habilidade = {"canta muito"};
		this.pessoaController.cadastrarPessoa("111.111.111-111", "Pedrinho", habilidade);
		assertEquals("blabla", this.busca.exibirPessoas("111.111.111-111"));
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
