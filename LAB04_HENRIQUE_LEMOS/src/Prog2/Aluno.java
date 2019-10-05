package Prog2;

/**
 * Representação de um aluno, especificamente de programação II. Todo aluno precisa ter uma matricula, nome e curso ao qual está matriculado. 
 * 
 * @author Henrique Lemos
 */

public class Aluno {

/**
 * Os dadps de um aluno, são:
 * - Matricula: número que representa o aluno.
 * - nome: nome do aluno.
 * - curso: formação em que o aluno esta ocupando.
 */

	private String matricula;
	private String nome;
	private String curso;
	private VerificaNullVazio verifica = new VerificaNullVazio();

/**
 * Cria o aluno, a partir dos dados de matricula, nome e curso que esta em formação.
 * 
 * @param matricula numero de identificação do aluno
 * @param nome do aluno
 * @param curso em que o aluno está em formação.
 */

	public Aluno(String matricula, String nome, String curso) {
		verifica.verificador(matricula);
		verifica.verificador(nome);
		verifica.verificador(curso);
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	

/**
 * Complementa o equals(), auxiliando para encontrar os objetos iguais para serem comparados.
 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
/**
 * Realiza uma comparação entre alunos para identificar se são iguais, para isso ele verifica se as matriculas são iguais.
 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

/**
 * Retorna a String que representa o aluno. A representação segue o formato "Aluno: matricula - nome - curso".
 * 
 * @return a representação em String do aluno.
 */

	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
}
