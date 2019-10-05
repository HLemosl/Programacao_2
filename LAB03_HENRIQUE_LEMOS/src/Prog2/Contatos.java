package Prog2;

/**
 * Realiza a construção do contato, solicitado pelo usuário, para ser salvo na agenda.
 * Para isso é necessário da posição ao qual o contato será salvo na agenda, o nome, sobrenome e o telefone.
 * 
 * @author Henrique Lemos
 */

public class Contatos {

/**
 * Reunião dos dados do contato: sua posição na agenda, nome, sobrenome e telefone.
 */

	private int posicao;
	private String nome;
	private String sobrenome;
	private String telefone;

/**
 * Constói o contato conforme as informações passadas pelo usuário.
 * 
 * @param posicao local onde o contato está localizado na agenda 
 * @param nome definido pelo usuário, porém este nome não pode ser "em branco"
 * @param sobrenome definido pelo usuário
 * @param telefone do respectivo perfil criado pelo usuário
 */
	
	public Contatos(int posicao, String nome, String sobrenome, String telefone) {
		if (!nome.trim().equals("")) {
			this.posicao = posicao - 1;
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.telefone = telefone;
		} else {
			throw new IllegalArgumentException("FALHA NO NOME, TENTE NOVAMENTE!");
		}
	}

/**
 * Acessa o atributo posicao, e informa a posição do contato na lista de contatos.
 * 
 * @return posição do contato na agenda
 */

	public int getPosicao() {
		return this.posicao + 1;
	}

/**
 * Acessa o atributo nome, e informa o nome do contato.
 * 
 * @return nome do contato
 */

	public String getNome() {
		return this.nome;
	}

/**
 * Acessa o atributo sobrenome, e informa o sobrenome do contato.
 * 
 * @return sobrenome do contato
 */

	public String getSobrenome() {
		return this.sobrenome;
	}

/**
 * Complementa o equals(), auxiliando para encontrar os objetos iguais para serem comparados.
 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

/**
 * Realiza uma comparação entre contatos para identificar se são iguais, para isso ele verifica se o nome e o sobrenome são iguais.
 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatos other = (Contatos) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

/**
 * Replica uma String, com o nome sobrenome e telefone, do contato.
 * 
 * @return informações do contato, na forma "nome sobrenome - telefone"
 */

	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}

/**
 * Um toString() exclusivo para a exibição de contatos, apresentando a posição na agenda, nome e sobrenome.
 * 
 * @return informações do contato, na forma "posição - nome sobrenome"
 */

	public String contatoToString() { 
		return getPosicao() + " - "+ getNome() + " " + getSobrenome();
	}
}
