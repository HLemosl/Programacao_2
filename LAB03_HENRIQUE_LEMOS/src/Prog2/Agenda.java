package Prog2;

import java.util.Arrays;

/**
 * Representação de uma agenda de um usuário, onde a partir do menu ele pode selecionar entre: 
 * Cadastrar um contato na agenda (Para cada cadastro é necessário uma posição na lista de telefone, nome, sobrenome e telefone);
 * Listar os contatos (Representado pela posição na lista de telefone, nome e sobrenome);
 * Exibir algum contato selecionado pelo usuário (A partir da posição do contato na lista é possível ver o nome, sobrenome e telefone do contato).
 * 
 * @author Henrique Lemos
 */

public class Agenda {
	
/**
 * Lista de Contatos do usuário, com um limite de 100 contatos possíveis, para serem salvos.
 */
	
	private Contatos[] contatos;

/**
 * Constrói uma agenda para o usuário, onde seus contatos ficaram salvos em um array de 100 espaços.
 */

	public Agenda() {
		this.contatos = new Contatos[100];
	}
	
/**
 * Verifica se a posição selecionada pelo usuário, pode ser utilizada, no intervalo de 1 a 100.
 * 
 * @param posicao ao qual o contato vai ser salvo na agenda
 * @return true se a posição é aprovada e false se a posição for negada
 */
	
	public boolean aprovaPosicao(int posicao) {
		if (posicao > 0 && posicao<= 100) {
			return true;
		}
		return false;
	}

/**
 * Cadastra o contato na agenda, a partir dos dados informados pelo usuário, sendo eles:
 * 
 * @param posicao na qual o contato estará salvo na agenda
 * @param nome do contato a ser salvo, onde não pode ser "em branco"
 * @param sobrenome do contato a ser salvo
 * @param telefone do contato a ser salvo
 * @return um booleano que confirma com true confirmando que ele foi salvo, e false para quando este contato já existe na agenda
 */

	
	public boolean cadastraContato(int posicao,  String nome, String sobrenome, String telefone) {
		if (aprovaPosicao(posicao) == true) {
			Contatos contato = new Contatos(posicao, nome, sobrenome, telefone);
			if (!contato.equals(contatos[posicao - 1])) {
				contatos[posicao - 1] = contato;
				return true;
			}
		}
		return false;
	}

/**
 * Realiza a listagem dos contatos salvos, pelo usuário, na agenda.
 * 
 * @return os contatos salvos em uma string, retornando "posição - nome sobrenome", um em cada linha
 */

	public String listaContatos() {
		String agenda = "";
		for (int l = 0; l < contatos.length; l++) {
			if (contatos[l] != null) {
				agenda += contatos[l].contatoToString() + "\n";
			}
		}
		return agenda;
	}

/**
 * Exibe o contato desejado pelo usuário, a partir da posição informada por ele(a).
 * 
 * @param posicao no qual o usuário quer receber as informações referentes a este contato
 * @return caso a posição possua um contato salvo, ele imprime o contato, na representação "nome sobrenome - telefone". Caso a posição não possua contato nenhum salvo, ele retorna uma mensagem dizendo "POSIÇÃO INVÁLIDA" 
 */

	public String exibeContatos(int posicao) {
		if (contatos[posicao - 1] != null) {
			return contatos[posicao - 1].toString();
		} else {				
			return "POSIÇÃO INVÁLIDA!";
		}
	}

/**
 * Avalia se uma agenda de contatos é igual a outra.
 */

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
}
