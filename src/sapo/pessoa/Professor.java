package sapo.pessoa;

public class Professor extends Pessoa{
    private String siape;
    private String[] disciplinas;
    
    public Professor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades){
        super(cpf, nome, habilidades);
        this.siape = siape;
        this.disciplinas = disciplinas;
    }

    public String getSiape(){
        return siape;
    }
    public String[] getDisciplinas(){
        return this.disciplinas;
    }
    public int calculaNivel(){
        int nivelCalculado = 0;
        int tarefasAndamento = 0;
        int 
    }
    
}
