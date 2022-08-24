package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuscaTest extends BaseTest {

	@Test
	void testExibirPessoas() {
		String[] habilidade = { "canta muito" };
		this.pessoaController.cadastrarPessoa("111.111.111-111", "Pedrinho doido", habilidade);
		assertEquals(this.pessoaController.getPessoa("111.111.111-111").getNome(),
				this.busca.exibirPessoas("doido")[0]);
	}

	@Test
	void testBuscarAtividade() {
		this.atividadeController.cadastrarAtividade("Assistir filme", "ver muito filme até virar cinefilo",
				"101.102.103-14");
		assertEquals("Assistir filme", this.busca.buscarAtividade("filme")[0]);
	}

	@Test
	void testBuscarTarefas() {
		String[] habilidades = { "fazer pipoca" };
		this.atividadeController.cadastrarAtividade("Assistir filme", "ver muito filme até virar cinefilo",
				"101.102.103-14");
		this.tarefaController.cadastrarTarefa("SSS-0", "assistir o lobo de wall street", habilidades);
		assertEquals("assistir o lobo de wall street", this.busca.buscarTarefas("lobo")[0]);
	}

	@Test
	void testBuscarTarefas2() {
		String[] habilidades = { "fazer pipoca" };
		String[] habilidades2 = { "dar xequemate" };
		this.atividadeController.cadastrarAtividade("Assistir filme", "ver muito filme até virar cinefilo",
				"101.102.103-14");
		this.atividadeController.cadastrarAtividade("Jogar xadrez", "virar mestre no xadrez", "124.123.754-12");
		this.tarefaController.cadastrarTarefa("SSS-0", "assistir o lobo de wall street", habilidades);
		this.tarefaController.cadastrarTarefa("JGR-1", "assistir jogos de profissionais", habilidades2);
		assertEquals("assistir jogos de profissionais", this.busca.buscarTarefas("JGR-1", "assistir"));
	}

	@Test
	void testSugerirTarefas() {
		String[] habilidade = { "paciencia" };
		String[] habilidades = { "paciencia" };
		this.pessoaController.cadastrarPessoa("111.111.111-111", "Pedrinho doido", habilidade);
		this.atividadeController.cadastrarAtividade("Jogar xadrez", "virar mestre no xadrez", "124.123.754-12");
		this.tarefaController.cadastrarTarefa("JGR-0", "dar xequemate", habilidades);
		assertEquals("paciencia", this.busca.sugerirTarefas("JGR-0", "111.111.111-111")[0]);
	}

	@Test
	void testBuscasMaisRecentes() {
		String[] habilidade = { "paciencia" };
		String[] habilidades = { "paciencia" };
		this.pessoaController.cadastrarPessoa("111.111.111-111", "Pedrinho doido", habilidade);
		this.atividadeController.cadastrarAtividade("Jogar xadrez", "virar mestre no xadrez", "124.123.754-12");
		this.tarefaController.cadastrarTarefa("JGR-0", "dar xequemate", habilidades);
		this.busca.buscarAtividade("jogar");
		this.busca.buscarTarefas("xequemate");
		assertEquals("xequemate", this.busca.buscasMaisRecentes(1)[0]);
	}

	@Test
	void testExibirHistoricoBusca() {
		String[] habilidade = { "paciencia" };
		String[] habilidades = { "paciencia" };
		this.pessoaController.cadastrarPessoa("111.111.111-111", "Pedrinho doido", habilidade);
		this.atividadeController.cadastrarAtividade("Jogar xadrez", "virar mestre no xadrez", "124.123.754-12");
		this.tarefaController.cadastrarTarefa("JGR-0", "dar xequemate", habilidades);
		this.busca.buscarAtividade("jogar");
		this.busca.buscarTarefas("xequemate");
		assertEquals("TAREFA", this.busca.exibirHistoricoBusca(1)[0]);
		assertEquals("dar xequemate", this.busca.exibirHistoricoBusca(1)[1]);
	}

}
