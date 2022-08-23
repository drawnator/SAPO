package sapo.tarefa;

import java.util.NoSuchElementException;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;

public class TarefaService {
    private TarefaRepository tr;

    public TarefaService() {
        this.tr = new TarefaRepository();
    }

    Tarefa getTarefa(String idTarefa){
        return this.tr.getTarefa(idTarefa);
    }
    
    String cadastrarTarefa(String atividadeId , String nome, String[] habilidades, AtividadeService as){
        if (as.getNome(atividadeId) == null){
            throw new NoSuchElementException();
        }
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
    String exibirTarefa(String idTarefa, PessoaService ps, AtividadeService as){
        
        Tarefa tarefa = this.tr.getTarefa(idTarefa);
        String output = "";
        output += tarefa.getNome() + " - " + tarefa.getId() + "\n";
        output +=  "- " + as.getNome(tarefa.getIdAtividade()) + "\n";
        String[] habilidades = tarefa.getHabilidades();
        for (String habilidade : habilidades) {
            output += habilidade;
            if (!habilidade.equals(habilidades[habilidades.length - 1])) {
                output += ", ";
            }
        }
        
        output += "\n(" + tarefa.getDuracao() + " hora(s) executadas))\n";
        output += "===\n";
        output += "Equipe:\n";
        for (String cpf : tarefa.getPessoas()) {
            output += ps.getPessoa(cpf).getNome() + " - " + cpf;
        }
        return output;
        
    }
    void associarPessoaTarefa(String cpf, String idTarefa){
        this.tr.getTarefa(idTarefa).associarPessoa(cpf);
    }
    void removerPessoaTarefa(String cpf, String idTarefa){
        this.tr.getTarefa(idTarefa).removerPessoa(cpf);
    }
    
    /*public String cadastrarTarefaGerencial(String atividadeId , String nome, String[] habilidades,String[] idTarefas) {
    	
    }
    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
    	
    }
    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
    	
    }*/
    
    
}
