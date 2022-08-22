package tarefa;

public class TarefaController {
    private TarefaService ts;
    private PessoaService ps;
    private AtividadeService as;
    
    public TarefaController(TarefaService ts, PessoaService ps, AtividadeService as) {
        this.ts = ts;
        this.ps = ps;
        this.as = as;
    }
    public String cadastrarTarefa(String atividadeId , String nome, String[] habilidades){
        return this.ts.cadastrarTarefa(atividadeId, nome, habilidades);
    } 
    public void alterarNomeTarefa(String idTarefa, String novoNome){
        this.ts.alterarNomeTarefa(idTarefa, novoNome);
    }
    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades){
        this.ts.alterarHabilidadesTarefa(idTarefa, habilidades);
    }
    public void adicionarHorasTarefa(String idTarefa, int horas){
        this.ts.adicionarHorasTarefa(idTarefa, horas);
    }
    public void removerHorasTarefa(String idTarefa, int horas){
        this.ts.removerHorasTarefa(idTarefa, horas);
    }
    public void concluirTarefa(String idTarefa){
        this.ts.concluirTarefa(idTarefa);
    }
    public void removerTarefa(String idTarefa){
        this.ts.removerTarefa(idTarefa);
    }
    public String exibirTarefa(String idTarefa){
        return this.ts.exibirTarefa(idTarefa, this.ps, this.as);
    }
    public void associarPessoaTarefa(String cpf, String idTarefa){
        this.ts.associarPessoaTarefa(cpf, idTarefa);
    }
    public void removerPessoaTarefa(String cpf, String idTarefa){
        this.ts.removerPessoaTarefa(cpf, idTarefa);
    }
}
