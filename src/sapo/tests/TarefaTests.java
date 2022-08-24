package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.atividade.AtividadeService;
import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaService;



class TarefaTests {
	
	//protected Facade facade;
	protected TarefaController tc;
	protected TarefaService ts;
	protected PessoaService ps;
	protected AtividadeService as;
	
	@BeforeEach
	void setUp() {
		//this.facade = new Facade();
		this.as = new AtividadeService();
		this.ts = new TarefaService();
		this.tc = new TarefaController(ts, ps, as);
	}
	
	@Test
	void testCadastraTarefa() {
		String[] habilidades = {"java","ver tiktok"};
		assertEquals("STD-0-0", tc.cadastrarTarefa("STD-0", "Estudar", habilidades));
		assertEquals("STD-0-1", tc.cadastrarTarefa("STD-0", "Ler", habilidades));
	}
	
	@Test
	void testAlterarNomeTarefa() {
		String[] habilidades = {"java","ver tiktok"};
		tc.cadastrarTarefa("STD-0", "Estudar", habilidades);
		tc.alterarNomeTarefa("STD-0-0", "Vender dindin");
		assertEquals("blabla", tc.exibirTarefa("STD-0-0"));
	}
	
	@Test
	void testMudarHoras() {
		ts.cadastrarTarefa("JGH-0", "testar github",null);
		ts.getTarefa("JGH-0-0").mudarHoras(10);
		assertEquals(10, ts.getTarefa("JGH-0-1").getDuracao());
		ts.getTarefa("JGH-0-0").mudarHoras(10);
		assertEquals(20, ts.getTarefa("JGH-0-1").getDuracao());
		ts.getTarefa("JGH-0-1").mudarHoras(10);
		assertEquals(10, ts.getTarefa("JGH-0-2").getDuracao());
	}

	@Test
	void testAssociarPessoa(){
		ts.getTarefa("JGH-0-1").associarPessoa("124.123.754-12");
		assertEquals(((Pessoa) ts.getTarefa("JGH-0-1").getPessoas().toArray()[0]).getNome(),"124.123.754-12");
	}
}
