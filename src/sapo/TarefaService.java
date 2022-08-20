package sapo;

public class TarefaService {
    private TarefaRepository tr;

    public TarefaService() {
        this.tr = new TarefaRepository();
    }
    
    String cadastrarTarefa(String atividadeId , String nome, String[] habilidades){
        Tarefa tarefa = new Tarefa(atividadeId, nome, habilidades, this.tr.getTarefasCadastradas());
        this.tr.cadastrarTarefa(tarefa);
        this.tr.incrementaTarefasCadastradas();
        return tarefa.getId();  
    } 
    void alterarNomeTarefa(String idTarefa, String novoNome){
        this.tr.getTarefa(idTarefa).setNome(novoNome);
    }
    void alterarHabilidadesTarefa(String idTarefa, String[] habilidades){
        this.tr.getTarefa(idTarefa).setHabilidades(habilidades);
    }
    void adicionarHorasTarefa(String idTarefa, int horas){
        this.tr.getTarefa(idTarefa).mudarHoras(horas);
    }
    void removerHorasTarefa(String idTarefa, int horas){
        this.tr.getTarefa(idTarefa).mudarHoras(-horas);
    }
    void concluirTarefa(String idTarefa){
        this.tr.getTarefa(idTarefa).concluir();
    }
    void removerTarefa(String idTarefa){
        this.tr.removerTarefa(idTarefa);
    }
    String exibirTarefa(String idTarefa){
        return this.tr.getTarefa(idTarefa).toString();
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.tr.getTarefa(idTarefa).associarPessoa(cpf);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.tr.getTarefa(idTarefa).removerPessoa(cpf);
    }
    String representacao(String idTarefa){
        Tarefa tarefa = this.tr.getTarefa(idTarefa);
        String output = "";
        output += tarefa.nome + " - " + tarefa.getId() + "\n";
        output +=  "- " + tarefa.getNomeAtividade + "\n";
        for (String habilidade : tarefa.habilidades) {
            output += habilidade;
            if (habilidade != tarefa.habilidades[tarefa.habilidades.length - 1]) {
                output += ", ";
            }
        output += "\n(" + tarefa.duracao + " hora(s) executadas))\n";
        output += "===\n";
        output += "Equipe:\n";
        for (Pessoa pessoa : tarefa.pessoas.keySet()) {
            output += pessoa + " - " + tarefa.pessoas.get(pessoa.getCpf());
        }
        return output;
    }
    
}
