package sapo;

public class TarefaController {
    TarefaRepository tr;
    
    public TarefaController(TarefaRepository tr) {
        this.tr = tr;
    }
    String cadastrarTarefa(String atividadeId , String nome, String[] habilidades){
        return this.tr.cadastrarTarefa(atividadeId, nome, habilidades);
    } 
    void alterarNomeTarefa(String idTarefa, String novoNome){
        this.tr.alterarNomeTarefa(idTarefa, novoNome);
    }
    void alterarHabilidadesTarefa(String idTarefa, String[] habilidades){
        this.tr.alterarHabilidadesTarefa(idTarefa, habilidades);
    }
    void adicionarHorasTarefa(String idTarefa, int horas){
        this.tr.adicionarHorasTarefa(idTarefa, horas);
    }
    void removerHorasTarefa(String idTarefa, int horas){
        this.tr.removerHorasTarefa(idTarefa, horas);
    }
    void concluirTarefa(String idTarefa){
        this.tr.concluirTarefa(idTarefa);
    }
    void removerTarefa(String idTarefa){
        this.tr.removerTarefa(idTarefa);
    }
    String exibirTarefa(String idTarefa){
        return this.tr.exibirTarefa(idTarefa);
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.tr.associarPessoaTarefa(cpf, idTarefa);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.tr.removerPessoaTarefa(cpf, idTarefa);
    }
}
