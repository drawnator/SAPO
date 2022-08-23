package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuscaTest extends BaseTest {

	@Test
	void testExibirPessoas() {
		assertEquals("blabla", this.busca.exibirPessoas("Stias"));
	}

}
