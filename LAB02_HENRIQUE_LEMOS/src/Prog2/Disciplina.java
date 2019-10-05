package Prog2;

import java.util.Arrays;

/**
 * Responsável por cadastrar as disciplinas realizadas pelo aluno.
 * Onde são cadastrados informações referentes a disciplina.
 *  
 * @author Henrique Lemos
 */

public class Disciplina {

/**
 * A cada cadastro de um disciplina, são cadastrados também:
 * O nome da disciplina referente no qual o aluno está matriculado;
 * Notas referentes à aquela disciplina, onde a partir delas será informado se o aluno foi aprovado ou não;
 * Horas de Estudo do aluno em sua disciplina.
 */

	private String nomeDisciplina;
	private int horaEstudo;
	private double[] notas;


/**
 * Constrói um cadastro da disciplina no qual o aluno está matriculado.
 * Omde por padrão toda disciplina tem 4 notas.
 * 
 * @param nomeDisciplina o nome da disciplina no qual o aluno está matriculado
 */

	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double [4];
	}
	
	int numeroNotas;
	

/**
 * Informa a quantidade de notas que o aluno possui.
 * 
 * @param numero quantidade de notas do aluno
 */

	public void numNotasDisciplina(int numero) {
		numeroNotas = numero;
	}

/**
 * Cadastra a quantidade de horas estudadas pelo aluno.
 * Atualizando de dorma somátória o número de horas estudadas.
 * 
 * @param horas volor de horas que o aluno estudou
 */

	public void cadastraHoras(int horas) {
		horaEstudo += horas;
	}

/**
 * A partir do padrão de 4 notas por disciplina, ele cadastra o valor da nota em determinada nota.
 * 
 * @param nota valor entre 4, por disciplina.
 * @param valorNota valor da nota (dentre as 4 da disciplina)
 */

	public void cadastraNota(int nota, double valorNota) {
		notas[nota-1] = valorNota;
	}

/**
 * Cálculo de média, para definir se o aluno foi aprovado na discíplina.
 * 
 * @return valor da media
 */

	public double media() {
		int soma = 0;
		for (int m = 0; m < notas.length; m++) {
			soma += notas[m];
		}
		double media = soma / notas.length;
		return media;
	}

/**
 * Calculo de média ponderada das notas do aluno.
 * 
 * @param numeroDeNotas quantidade de notas do aluno
 * @param pesos peso de cada nota
 * @return valor da media ponderada
 */

	public double mediaPonderada(int numeroDeNotas, int[] pesos) {
		double soma = 0.0;
		
		for (int i = 0; i < numeroDeNotas; i++) {
			soma += pesos[i] * notas[i];
		}
		return soma / 10;
	}

/**
 * Calculo de média aritmética da notas do aluno.
 * 
 * @param numeroDeNotas quantidade de notas do aluno
 * @return valor da media aritmética
 */

	public double mediaAritmetica(int numeroDeNotas) {
		double soma = 0.0;
		
		for (int i = 0; i < numeroDeNotas; i++) {
			soma += notas[i];
		}
		return soma / numeroDeNotas;
	}

/**
 * A partir do calculo da media, informa se o aluno passou ou não na disciplina.
 * 
 * @return true para sim e false para não
 */

	public boolean aprovado() {
		return media() >= 7.0;
	}


/**
 * Acessa ao atributo nomeDisciplina, e informa o nome dela.
 * 
 * @return informa o nome da disciplina
 */

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

/**
 * Acessa ao atributo horaEstudo, e informa a quantidade de hora estudada.
 * 
 * @return informa o valor de horas estudada
 */

	public int getHoraEstudo() {
		return horaEstudo;
	}

/**
 * Acessa ao atributo notas, e informa as notas do aluno.
 * 
 * @return informa as notas do aluno
 */

	public double[] getNotas() {
		return notas;
	}

/**
 * Retorna as notas do aluno em um array.
 * 
 * @return notas do aluno
 */

	public String notasToString() {
		return Arrays.toString(notas);
	}

/**
 * Retorna a String que representa as informações do aluno na disciplina.
 * A representação segue o formato "nomeDisciplina horaEstudo media notasdoaluno".
 * 
 * @return a representação em String dos dados do aluno na disciplina 
 */

	public String toString() {
		return nomeDisciplina + " " + horaEstudo + " " + media() + " " + notasToString();
	}
}
