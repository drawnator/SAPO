package sapo;

public class TarefaController {
    TarefaService ts;
    PessoaService ps;
    
    public TarefaController(TarefaService ts, PessoaService ps) {
        this.ts = ts;
        this.ps = ps;
    }
    String cadastrarTarefa(String atividadeId , String nome, String[] habilidades){
        return this.ts.cadastrarTarefa(atividadeId, nome, habilidades);
    } 
    void alterarNomeTarefa(String idTarefa, String novoNome){
        this.ts.alterarNomeTarefa(idTarefa, novoNome);
    }
    void alterarHabilidadesTarefa(String idTarefa, String[] habilidades){
        this.ts.alterarHabilidadesTarefa(idTarefa, habilidades);
    }
    void adicionarHorasTarefa(String idTarefa, int horas){
        this.ts.adicionarHorasTarefa(idTarefa, horas);
    }
    void removerHorasTarefa(String idTarefa, int horas){
        this.ts.removerHorasTarefa(idTarefa, horas);
    }
    void concluirTarefa(String idTarefa){
        this.ts.concluirTarefa(idTarefa);
    }
    void removerTarefa(String idTarefa){
        this.ts.removerTarefa(idTarefa);
    }
    String exibirTarefa(String idTarefa, ){
        return this.ts.exibirTarefa(idTarefa);
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.ts.associarPessoaTarefa(cpf, idTarefa);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.ts.removerPessoaTarefa(cpf, idTarefa);
    }
}
