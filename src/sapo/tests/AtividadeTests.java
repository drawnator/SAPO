package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AtividadeTests extends BaseTest {
	
	@Test
	void testCadastrarAtividade() {
		assertEquals("VRT-2",this.atividadeController.cadastrarAtividade("Ver Tiktok", "Gastar toda da internet móvel assistindo tiktok","124.123.754-12"));
	}
	
	@Test
	void testEncerrarAtividade() {
		this.atividadeController.cadastrarAtividade("Ver Tiktok", "Gastar toda da internet móvel assistindo tiktok","124.123.754-12");
		assertEquals("aberta", this.atividadeController.getStatus("VRT-2"));
		this.atividadeController.encerrarAtividade("VRT-2");
		assertEquals("encerrada", this.atividadeController.getStatus("VRT-2"));
	}
	
	@Test
	void testDesativarAtividade() {
		this.atividadeController.cadastrarAtividade("Ver Anime", "Assistir muito naruto","124.123.754-12");
		assertEquals("aberta", this.atividadeController.getStatus("VRN-2"));
		this.atividadeController.desativarAtividade("VRN-2");
		assertEquals("desativada", this.atividadeController.getStatus("VRN-2"));
	}
	
	@Test
	void testReabrirAtividade() {
		this.atividadeController.cadastrarAtividade("Jogar Fortnite", "Ganhar muitas victory royales", "101.102.103-14");
		assertEquals("aberta", this.atividadeController.getStatus("JGR-2"));
		this.atividadeController.desativarAtividade("JGR-2");
		this.atividadeController.reabrirAtividade("JGR-2");
		assertEquals("aberta", this.atividadeController.getStatus("JGR-2"));
	}

}
