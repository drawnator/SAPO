package sapo.pessoa;

import java.util.Arrays;

import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaService;

public class Aluno extends Pessoa{
    private String matricula;
    private int periodo;
    
    public Aluno(String cpf, String nome, String matr, int periodo, String[] habilidades){
        super(cpf, nome, habilidades);
        this.matricula = matr;
        this.periodo = periodo;
    }

    public Aluno(String cpf, String nome, String matr, int periodo, String[] habilidades, int nivel){
        super(cpf, nome, habilidades, nivel);
        this.matricula = matr;
        this.periodo = periodo;
    }

    public String getMatricula(){
        return this.matricula;
    }
    public int getPeriodo(){
        return this.periodo;
    }

    @Override
    public int getNivel(TarefaService ts){
        int tarefasAndamento = 0;
		int tarefasFinalizadasHab = 0;
        int tarefasFinalizadas = 0;
		for(String idTarefa: super.tarefasAssociadas){
			Tarefa tarefa = ts.getTarefa(idTarefa);
			if (tarefa.getConcluida()){
                boolean existeOverlap = false;
				String[] habsTarefa = tarefa.getHabilidades();
                for (String habilidade: habsTarefa){
                    for (String habAluno: super.habilidades){
                        if (habilidade.equals(habAluno)){
                            existeOverlap = true;
                        }
                    }
                }

                if (existeOverlap){
                    tarefasFinalizadasHab++;
                }
                tarefasFinalizadas++;
			}
			else{
				tarefasAndamento++;
			}
            super.tarefasAssociadas.remove(idTarefa);
		}
        double doubleTarFinHab = tarefasFinalizadasHab;
		super.nivel += tarefasAndamento/2 + tarefasFinalizadas + (int) Math.ceil(doubleTarFinHab*1.5);  
        return super.nivel;
    }

    @Override
    public String toString(){
        Arrays.sort(habilidades);
		String exibicao = nome + " – " + cpf;
        exibicao += "Aluno - " + this.matricula + " - " + this.periodo;
		for (int i = 0; i < habilidades.length; i++) {
			exibicao += "\n- " + habilidades[i];
		}
		return exibicao;
    }
    
}
