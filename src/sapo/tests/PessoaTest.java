package sapo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class PessoaTest extends BaseTest {
	@Test
	void testCadastrarPessoa() {
		String[] habilidades = new String[] { "Mitadas", "Ironia" };
		this.pessoaController.cadastrarPessoa("100.999.888-24", "Reizinho", habilidades);
		assertEquals("Reizinho", this.pessoaController.getNome("100.999.888-24"));
	}

	@Test
	void testExibirPessoa() {
		assertEquals("Stias – 124.123.754-12\n" + "- Dizer seu nome\n" + "- Jogar cs:go",
				this.pessoaController.exibirPessoa("124.123.754-12"));
	}

	@Test
	void testAlterarNomePessoa() {
		this.pessoaController.alterarNomePessoa("124.123.754-12", "Nagazak1");
		assertEquals("Nagazak1", this.pessoaController.getNome("124.123.754-12"));
	}

	@Test
	void testAlterarHabilidadesPessoa() {
		String[] habilidades = new String[] { "NENHUMA!" };
		this.pessoaController.alterarHabilidadesPessoa("124.123.754-12", habilidades);
		assertEquals("Stias – 124.123.754-12\n" + "- NENHUMA!", this.pessoaController.exibirPessoa("124.123.754-12"));
	}

	@Test
	void testRemoverPessoa() {
		this.pessoaController.removerPessoa("124.123.754-12");
		assertThrows(NoSuchElementException.class, () -> {
			this.pessoaController.exibirPessoa("124.123.754-12");
		});
	}

	@Test
	void testAdicionarListarComentarioPessoa() {
		this.pessoaController.adicionarComentarioPessoa("124.123.754-12", "Excelente mestre.", "101.102.103-14");
		assertEquals("Stias - 124.123.754-12\n" + "Comentarios:\n" + "- Excelente mestre. (Pikachu)",
				this.pessoaController.listarComentariosPessoa("124.123.754-12"));
	}
}
