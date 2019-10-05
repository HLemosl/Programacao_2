package Prog2;

import java.util.ArrayList;

/**
 * Grupo de estdudos que possui o seu nome e agrupa um conjunto de alunos,a partir de uma lista, pertencentes a este grupo.
 * 
 * @author Henrique Lemos
 */


public class Grupo {
	
/**
 * Cada grupo e criado a partir de:
 * nome: nome do grupo;
 * membros: lista dos membros pertencentes a este grupo.
 */

	private String nome;
	private ArrayList<Aluno> membros;
	private VerificaNullVazio verifica = new VerificaNullVazio();
/**
 * Cria o grupo de estudos, com seu nome, e sua listade membros.
 * 
 * @param nome nome do grupo
 */

	public Grupo(String nome) {
		verifica.verificador(nome);
		this.nome = nome;
		this.membros = new ArrayList<Aluno>();
	}

/**
 * Adiciona na lista de membros os alunos participantes deste grupo.
 * 
 * @param aluno o aluno que será adicionado
 */

	public void alocaEmGrupo(Aluno aluno) {
		membros.add(aluno);
	}

/**
 * Imprime os alunos pertencentes a este grupo.
 * 
 * @return uma string com os alunos participantes do grupo.
 */

	public String impressaoGrupo() {
		String retorno = "";
		for (int i = 0; i < membros.size(); i++) {
			retorno += "* " + membros.get(i).toString() + "\n";
		}
		return retorno;
	}

/**
 * Complementa o equals(), auxiliando para encontrar os objetos iguais para serem comparados.
 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

/**
 * Realiza uma comparação entre grupos para identificar se são iguais, para isso ele verifica se os nomes são iguais.
 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}