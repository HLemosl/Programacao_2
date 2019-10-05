package Prog2;

import java.util.Scanner;

/**
 * Representação de um menu, da base de controle de alunos de Programação II, onde o usuário pode:
 * 
 *  (C)adastrar Aluno;
 *  (E)xibir Aluno
 *  (N)ovo Grupo
 *  (A)locar Aluno no Grupo e Imprimir Grupos
 *  (R)egistrar Aluno que Respondeu
 *  (I)mprimir Alunos que Responderam
 *  (O)ra, vamos fechar o programa!
 * 
 * @author Henrique Lemos
 */

public class Menu {

/**
 * Cria o controle de alunos
 */

	public static Scanner entrada = new Scanner(System.in);
	public static ControleDeAlunos controleAlunos;
	public static VerificaNullVazio verifica = new VerificaNullVazio();

/**
 * Exibição do menu para o usuário.
 */
	private static void exibeMenu() {
		System.out.println("(C)adastrar Aluno" + "\n" + "(E)xibir Aluno" + "\n" + "(N)ovo Grupo" + "\n" + "(A)locar Aluno no Grupo e Imprimir Grupos" + "\n" + "(R)egistrar Aluno que Respondeu" + "\n" + "(I)mprimir Alunos que Responderam" + "\n" + "(O)ra, vamos fechar o programa!");
	}

/**
 * Realização do cadastro do aluno.
 * Se a situação do cadastro for true, ele imprime ao usuário que o cadastro foi realizado, caso for falso, ele avisa que houve um erro de matricula.
 */

	private static void cadastraNovoAluno() {
		System.out.println();
		System.out.print("Matrícula: ");
		String matricula = entrada.nextLine();
		verifica.verificador(matricula);
		System.out.print("Nome: ");
		String nome = entrada.nextLine();
		verifica.verificador(nome);
		System.out.print("Curso: ");
		String curso = entrada.nextLine();
		verifica.verificador(curso);
		boolean situacao = controleAlunos.cadastraAluno(matricula, nome, curso);
		if (situacao == true) {
			System.out.println("CADASTRO REALIZADO!" + "\n");
		} else {
			System.out.println("MATRÍCULA JÁ CADASTRADA!" + "\n");
		}
	}

/**
 * Consulta o aluno no banco de dados e imprime os dados deste aluno.
 */
	public static void consultarAluno() {
		System.out.print("\n" + "Matrícula: ");
		String matricula = entrada.nextLine();
		verifica.verificador(matricula);
		System.out.println(controleAlunos.exibeAluno(matricula) + "\n");
	}

/**
 * Cria um grupo para determinados alunos.
 */
	
	public static void novoGrupo() {
		System.out.println();
		System.out.print("Grupo: ");
		String grupo = entrada.nextLine();
		verifica.verificador(grupo);
		boolean temGrupo = controleAlunos.existeGrupo(grupo);
		if (temGrupo == false) {
			controleAlunos.cadastraGrupo(grupo);
			System.out.println("CADASTRO REALIZADO!" + "\n");
		} else {
			System.out.println("GRUPO JÀ CADASTRADO!" + "\n");
		}
	}

/**
 * Aloca um aluno a um determinado grupo.
 * Quando o alocamento retorna 1 para quando o alocamento foi realizado com sucesso, 2 para quando a matricula do aluno selecionado for inexistente, e 3 para quando grupo sleecionado não existir, e a aparir destes retornos especifica a menagem a ser retornada.
 */

	public static void alocaAlunoGrupo() {
		System.out.println();
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String selecao = entrada.nextLine();
		verifica.verificador(selecao);
		if ("A".equals(selecao)) {
			System.out.print("Matricula: ");
			String matricula = entrada.nextLine();
			verifica.verificador(matricula);
			System.out.print("Grupo: ");
			String grupo = entrada.nextLine();
			verifica.verificador(grupo);
			int alocamento = controleAlunos.alocaAluno(matricula, grupo);
			if (alocamento == 1) {
				System.out.println("ALUNO ALOCADO!" + "\n");
			} else if (alocamento == 2) {
				System.out.println("ALUNO NÃO CADASTRADO!" + "\n");
			} else {
				System.out.println("GRUPO NÃO CADASTRADO!" + "\n");
			}
		} else if ("I".equals(selecao)) {
			System.out.println("Grupo: ");
			String grupo = entrada.nextLine();
			verifica.verificador(grupo);
			String execucao = controleAlunos.imprimeGrupo(grupo);
			if (!"falha".equals(execucao)) {
				String[] retorno = execucao.split(" // ");
				for (int i = 0; i < retorno.length; i++) {
					System.out.println(retorno[i]);
				}
			} else {
				System.out.println("GRUPO NÃO CADASTRADO!" + "\n");
			}
			
		}
	}

/**
 * Cadastra os alunos que responderam uma questão no quadro.	
 */

	public static void responderamQuestao() {
		System.out.print("Matricula: ");
		String matricula = entrada.nextLine();
		verifica.verificador(matricula);
		boolean situacao = controleAlunos.alunoRespondeu(matricula);
		if (situacao == true) {
			System.out.println("ALUNO REGISTRADO!" + "\n");
		} else {
			System.out.println("ALUNO NÃO CADASTRADO!" + "\n");
		}
	}

/**
 * Imprime lista de alunos que responderam questões no quadro.
 */

	public static void imprimeResponderamQuestoes() {
		System.out.println(controleAlunos.imprimeQuestoesQuadro());
	}

	public static void main(String[] args) {
		controleAlunos = new ControleDeAlunos();
		
		while (true) {
			exibeMenu();
			System.out.println();
			System.out.print("Opção> ");
			String opcao = entrada.nextLine();
			verifica.verificador(opcao);
			if ("C".equals(opcao)) {
				cadastraNovoAluno();
			} else if ("E".equals(opcao)) {
				consultarAluno();
			} else if ("N".equals(opcao)) {
				novoGrupo();
			} else if ("A".equals(opcao)) {
				alocaAlunoGrupo();
			} else if ("R".equals(opcao)) {
				responderamQuestao();
			} else if ("I".equals(opcao)) {
				imprimeResponderamQuestoes();
			} else if ("O".equals(opcao)) {
				break;
			}
		}
		entrada.close();
	}
}
