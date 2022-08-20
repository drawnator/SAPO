package sapo;

public class TarefaController {
    TarefaService ts;
    PessoaService ps;
    AtividadeService as;
    
    public TarefaController(TarefaService ts, PessoaService ps, AtividadeService as) {
        this.ts = ts;
        this.ps = ps;
        this.as = as;
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
    String exibirTarefa(String idTarefa){
        return this.ts.exibirTarefa(idTarefa, this.ps, this.as);
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.ts.associarPessoaTarefa(cpf, idTarefa);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.ts.removerPessoaTarefa(cpf, idTarefa);
    }
}
