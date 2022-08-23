package sapo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sapo.Facade;
import sapo.atividade.AtividadeController;
import sapo.pessoa.PessoaController;
import sapo.tarefa.TarefaController;

class BaseTest {

    public static final String[] HABILIDADES1_STRINGS = {"Jogar cs:go", "Dizer seu nome"}; 
    public static final String[] HABILIDADES2_STRINGS = {"Raio do Trovao", "Dizer seu nome"}; 
    public static final String[] HABILIDADES3_STRINGS = {"Dizer seu nome"};
    public static final String[] HABILIDADES4_STRINGS = {"Jogar cs:go"};

    protected AtividadeController atividadeController;
    protected PessoaController pessoaController;
    protected TarefaController tarefaController;

	@BeforeEach
    void setUp(){
        Facade facade = new Facade();
        this.atividadeController = facade.getAtividadeController();
        this.pessoaController = facade.getPessoaController();
        this.tarefaController = facade.getTarefaController();
        facade.cadastrarPessoa("124.123.754-12", "Stias", HABILIDADES1_STRINGS);
        facade.cadastrarPessoa("101.102.103-14", "Pikachu", HABILIDADES2_STRINGS);

        facade.cadastrarAtividade("Jogue 1000 horas", "Consiga 1000 horas jogadas no jogo cs:go", "124.123.754-12");
        facade.cadastrarAtividade("Ganhe 3200 batalhas", "Ganhe 3200 batalhas mano-a-mano", "101.102.103-14");

        facade.cadastrarTarefa("JGH-0", "Jogue 500 horas de cs:go",HABILIDADES4_STRINGS);
        facade.cadastrarTarefa("JGH-0", "Jogue outras 500 horas de cs:go",HABILIDADES1_STRINGS);
        facade.cadastrarTarefa("GNH-1", "Destrua eles!",HABILIDADES2_STRINGS);
    }
}
