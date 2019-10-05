package Prog2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um controle de alunos de programação II, onde é possível cadastrar e consultar um aluno,
 * criar e alocar alunos em grupos de estudo e reallizar um controle dos alunos que responderam questões 
 * feitas pelo professor e resolveram questões no quadro. 
 * 
 * @author Henrique Lemos
 */

public class ControleDeAlunos {

/**
 * O listaAlunos, armazena os alunos, identicando-os por um valor único, que se refere a sua matrícula.
 * O grupeDeAlunos, registra os grupos de estudo, com os seus membros, em uma lista, identicados pelo seu nome.
 * O questoesQuadro, registra os alunos que responderam questões no quadro.
 */

	private HashMap<String, Aluno> listaAlunos;
	private HashMap<String, Grupo> grupoDeAlunos;
	private ArrayList<Aluno> questoesQuadro;
	private VerificaNullVazio verifica = new VerificaNullVazio();

/**
 * Cria a página de controle de alunos.
 */

	public ControleDeAlunos() {
		listaAlunos = new HashMap<>();
		grupoDeAlunos = new HashMap<>();
		questoesQuadro = new ArrayList<>();
	}

/**
 * Realiza o cadastro de um aluno, a partir dos dados de matrícula, nome e curso do aluno.
 * 
 * @param matricula a partir de um inteiro, um identicador único do aluno.
 * @param nome nome do aluno
 * @param curso em que o alunos esta matriculado
 * @return true para avisar que o cadastro foi realizado com sucesso, e false para identicar se esse cadastro passou por alguma falha no cadastro.
 */

	public boolean cadastraAluno(String matricula, String nome, String curso) {
		verifica.verificador(matricula);
		verifica.verificador(nome);
		verifica.verificador(curso);
		if (this.listaAlunos.containsKey(matricula) == false) {
			Aluno cadastro = new Aluno(matricula, nome, curso);
			this.listaAlunos.put(matricula, cadastro);
			return true;
		}
		return false;
	}

/**
 * Exibe as informações do aluno, no formato:
 * "Aluno: matricula - nome - curso".
 * 
 * @param matricula do aluno
 * @return dados do aluno selecionado.
 */

	public String exibeAluno(String matricula) {
		verifica.verificador(matricula);
		if(this.listaAlunos.containsKey(matricula)) {
			Aluno estudante = this.listaAlunos.get(matricula);
			return "Aluno: " + estudante.toString();
		}
		return "ALUNO NÃO CADASTRADO";
	}

/**
 * Verifica se um grupo ja existe na lista de grupos.
 * 
 * @param grupo nome do grupo
 * @return por um booleano se este grupo existe (true) ou não (false).
*/

	public boolean existeGrupo(String grupo) {
		verifica.verificador(grupo);
		return this.grupoDeAlunos.containsKey(grupo);
	}

/**
 * Realiza o cadastro de um novo grupo de estudos, e salva em uma lista com os grupos já cadastrados. 
 * 
 * @param grupo nome do grupo
 */

	public void cadastraGrupo(String grupo) {
		verifica.verificador(grupo);
		Grupo novoGrupo = new Grupo(grupo);
		this.grupoDeAlunos.put(grupo, novoGrupo);
		
	}

/**
 * Realiza o alocamento de um aluno em um determinado grupo de estudo.
 * 
 * @param matricula do aluno que vai ser alocado no grupo
 * @param grupo nome do grupo que o aluno irá ser alocado.
 * @return este método retorna três tipos de retorno, especificando o tipo de relização que o alocamento, esta acontecendo.
 */
	// 1 - Alocamento realizado.
	// 2 - Matrícula inexistente.
	// 3 - Grupo inexistente.
	
	public int alocaAluno(String matricula, String grupo) {
		verifica.verificador(matricula);
		verifica.verificador(grupo);
		if(this.grupoDeAlunos.containsKey(grupo) == true) {
			if (this.listaAlunos.containsKey(matricula) == true) {
				Aluno aluno = this.listaAlunos.get(matricula);
				this.grupoDeAlunos.get(grupo).alocaEmGrupo(aluno);
				return 1;
			}
			return 2;
		}
		return 3;
		
	}

/**
 * Imprime os integrantes de um determinado grupo selecionado pelo usuário.
 * 
 * @param grupo nome do grupo
 * @return A partir uma string os integrantes do grupo de estudos.
 */

	public String imprimeGrupo(String grupo) {
		verifica.verificador(grupo);
		String retorno;
		
		if (this.grupoDeAlunos.containsKey(grupo) == true) {
			retorno = this.grupoDeAlunos.get(grupo).impressaoGrupo();
		} else {
			retorno = "falha";
		}
		return retorno;
	}

/**
 * Aloca os alunos, em uma lista, que responderam questões no quadro.
 * 
 * @param matricula do aluno que respondeu um questão no quadro
 * @return a situação da realização deste alocamento de alunos que responderam questões no quadro.
 */

	public boolean alunoRespondeu(String matricula) {
		verifica.verificador(matricula);
		if (this.listaAlunos.containsKey(matricula) == true) {
			Aluno aluno = this.listaAlunos.get(matricula);
			questoesQuadro.add(aluno);
			return true;
		}
		return false;
	}

/**
 * Imprime os alunos que responderam questões no quadro.
 * 
 * @return String de alunos que responderam no quadro.
 */

	public String imprimeQuestoesQuadro() {
		String retorno = "";
		for (int i = 0; i < questoesQuadro.size(); i++) {
			retorno += (i+1) + ". " + questoesQuadro.get(i).toString() + "\n";
		}
		return retorno;
	}
}
