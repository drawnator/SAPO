package sapo.pessoa;

import java.util.Arrays;

import sapo.tarefa.Tarefa;
import sapo.tarefa.TarefaService;

public class Professor extends Pessoa {
	private String siape;
	private String[] disciplinas;

	public Professor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades) {
		super(cpf, nome, habilidades);
		this.siape = siape;
		this.disciplinas = disciplinas;
	}

	public Professor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades, int nivel) {
		super(cpf, nome, habilidades, nivel);
		this.siape = siape;
		this.disciplinas = disciplinas;
	}

	public String getSiape() {
		return siape;
	}

	public String[] getDisciplinas() {
		return this.disciplinas;
	}

	@Override
	public int getNivel(TarefaService ts) {
		int tarefasAndamento = 0;
		int tarefasFinalizadas = 0;
		for (String idTarefa : super.tarefasAssociadas) {
			Tarefa tarefa = ts.getTarefa(idTarefa);
			if (tarefa.getConcluida()) {
				boolean existeOverlap = false;
				String[] habsTarefa = tarefa.getHabilidades();
				for (String habilidade : habsTarefa) {
					for (String habProfessor : super.habilidades) {
						if (habilidade.equals(habProfessor)) {
							existeOverlap = true;
						}
					}

					for (String disciplina : this.disciplinas) {
						if (habilidade.equals(disciplina)) {
							existeOverlap = true;
						}
					}
				}

				if (existeOverlap) {
					tarefasFinalizadas++;
				}
			} else {
				tarefasAndamento++;
			}
			super.tarefasAssociadas.remove(idTarefa);
		}
		super.nivel += tarefasAndamento / 4 + tarefasFinalizadas;
		return super.nivel;
	}

	@Override
	public String toString() {
		Arrays.sort(habilidades);
		String exibicao = nome + " – " + cpf;
		exibicao += "Professor - " + this.siape + " - ";
		for (String disciplina : disciplinas) {
			exibicao += disciplina;
			if (disciplina != disciplinas[disciplinas.length - 1]) {
				exibicao += ", ";
			}
		}
		for (int i = 0; i < habilidades.length; i++) {
			exibicao += "\n- " + habilidades[i];
		}
		return exibicao;
	}

}
