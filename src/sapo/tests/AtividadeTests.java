package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AtividadeTests extends BaseTest {

	@Test
	void testCadastrarAtividade() {
		assertEquals("VRT-2", this.atividadeController.cadastrarAtividade("Ver Tiktok",
				"Gastar toda da internet m?vel assistindo tiktok", "124.123.754-12"));
	}

	@Test
	void testEncerrarAtividade() {
		this.atividadeController.cadastrarAtividade("Ver Tiktok", "Gastar toda da internet m?vel assistindo tiktok",
				"124.123.754-12");
		assertEquals("aberta", this.atividadeController.getStatus("VRT-2"));
		this.atividadeController.encerrarAtividade("VRT-2");
		assertEquals("encerrada", this.atividadeController.getStatus("VRT-2"));
	}

	@Test
	void testDesativarAtividade() {
		this.atividadeController.cadastrarAtividade("Ver Anime", "Assistir muito naruto", "124.123.754-12");
		assertEquals("aberta", this.atividadeController.getStatus("VRN-2"));
		this.atividadeController.desativarAtividade("VRN-2");
		assertEquals("desativada", this.atividadeController.getStatus("VRN-2"));
	}

	@Test
	void testReabrirAtividade() {
		this.atividadeController.cadastrarAtividade("Jogar Fortnite", "Ganhar muitas victory royales",
				"101.102.103-14");
		assertEquals("aberta", this.atividadeController.getStatus("JGR-2"));
		this.atividadeController.desativarAtividade("JGR-2");
		this.atividadeController.reabrirAtividade("JGR-2");
		assertEquals("aberta", this.atividadeController.getStatus("JGR-2"));
	}

	@Test
	void testExibirAtividade() {
		this.atividadeController.cadastrarAtividade("Jogar Fortnite", "Ganhar muitas victory royales",
				"101.102.103-14");
		String[] hab = { "ser bom" };
		this.tarefaController.cadastrarTarefa("JGR-2", "acabar com os inimgios", hab);
		assertEquals(
				"JGR-2: Jogar Fortnite\nResponsavel: Pikachu - 101.102.103-14\n===\nGanhar muitas victory royales\n===\nTarefas: 0/2\n - acabar com os inimgios - JGR-2-0",
				this.atividadeController.exibirAtividade("JGR-2"));
	}

	@Test
	void testAlterarDescricaoAtividade() {
		this.atividadeController.cadastrarAtividade("Maratonar Serie", "Assistir uma temporada na netflix",
				"124.123.754-12");
		this.atividadeController.alterarDescricaoAtividade("MRT-2", "Maratonar uma temporada de Stranger Things");
		assertEquals(
				"MRT-2: Maratonar Serie\nResponsavel: Stias - 124.123.754-12\n===\nMaratonar uma temporada de Stranger Things\n===\nTarefas: 0/0\n",
				this.atividadeController.exibirAtividade("MRT-2"));
	}

	@Test
	void testAlterarResponsavelAtividade() {
		this.atividadeController.cadastrarAtividade("Aproveitar as ferias",
				"Curtir muito os dias em que estarei de ferias", "124.123.754-12");
		this.atividadeController.alterarResponsavelAtividade("PRV-2", "101.102.103-14");
		assertEquals(
				"PRV-2: Aproveitar as ferias\nResponsavel: Pikachu - 101.102.103-14\n===\nCurtir muito os dias em que estarei de ferias\n===\nTarefas: 0/0\n",
				this.atividadeController.exibirAtividade("PRV-2"));
	}

}
