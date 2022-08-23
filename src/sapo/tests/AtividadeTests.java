package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AtividadeTests extends BaseTest {

	@Test
	//a geração do id de atividade ta errada. ta mostrando mais q 3 letras e mostra vogal
	void testCadastrarAtividade() {
		assertEquals("VRT-2",this.atividadeController.cadastrarAtividade("Ver Tiktok", "Gastar toda da internet móvel assistindo tiktok","124.123.754-12"));
	}
	
	@Test
	void testEncerrarAtividade() {
		this.atividadeController.cadastrarAtividade("Jogue 1000 horas", "Consiga 1000 horas jogadas no jogo cs:go", "124.123.754-12");
		//TESTE COM ID ERRADO QUANDO ARRUMAR A SIGLA MUDAR O ID NO TESTE
		assertEquals("aberta", this.atividadeController.getStatus("Jog1000hrs-0"));
		this.atividadeController.encerrarAtividade("Jog1000hrs-0");
		//aqui diz que tem um erro na hora de fazer listaTarefas.size() pq n ta dando pra encerrar uma atividade se n tiver nenhuma tarefa
		//n sei se é obrigado ter pelo menos uma tarefa
		assertEquals("encerrada", this.atividadeController.getStatus("Jog1000hrs-0"));
	}

}
