package Prog2;

/**
 * O aluno pode ter conta em varias cantinas da universidade. 
 * Para controlar os gastos em uma cantina, os lanches consumidos são adicionados à conta de uma determinada cantina,
 * e realiza um controle financeiro de débito do aluno.
 * 
 * @author Henrique Lemos
 */

public class ContaCantina {

/**
 * A cada criação de uma conta, são cadastrados:
 * O nome da cantina;
 * A quantidade de produtos consumidos na cantina;
 * O valor gasto total na cantina;
 * Detalhes referentes aos produtos consumidos na cantina.
 */

	private String nomeCantina;
	private int debitoConta;
	private int quantidade;
	private int valorGasto;
	private String detalhes;
	

/**
 * Constrói uma conta para o aluno na cantina, onde sua conta já começa com o débito zero.
 * 
 * @param nomeCantina nome do estabelecimento
 */

	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
		this.debitoConta = 0;
	}

/**
 * Cadastra o(s) lanche(s) consumidos pelo aluno.
 * 
 * @param qtdItens número de produtos consumidos
 * @param valorCentavos valor total dos produtos consumidos
 */

	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.valorGasto += valorCentavos;
		this.quantidade += qtdItens;
		this.debitoConta += valorCentavos;
	}

/**
 * Cadastra o(s) lanche(s) consumidos pelo aluno.
 * 
 * @param qtditens número de produtos consumidos
 * @param valorCentavos valor total dos produtos consumidos
 * @param detalhes detalhamento do aluno referente ao(s) produto(s) consumido(s)
 */

	public void cadastraLanche(int qtditens, int valorCentavos, String detalhes) {
		this.valorGasto += valorCentavos;
		this.quantidade += qtditens;
		this.debitoConta += valorCentavos;
		this.detalhes += detalhes + "; ";
	}

/**
 * Realiza o pagamento do débito do aluno na cantina,
 * subtraindo do valor que ele deve.
 * Caso o aluno estiver pagando mais do que ele deve,
 * será informado um erro.
 * 
 * @param valorCentavos valor refrente ao quanto o aluno vai pagar
 */

	public void pagaConta(int valorCentavos) {
		if (valorCentavos <= this.debitoConta) {
			this.debitoConta -= valorCentavos;
		} else {
			throw new IllegalArgumentException("Tem dinheiro a mais aí, você está pagando mais do que deve.");
		}
	}

/**
 * Realiza uma contrução no formato de array os detalhes do aluno,
 * selecionando apenas as 5 últimas.
 * 
 * @return array de detalhes escritos pelo aluno
 */

	public String listarDetalhes() {
		String[] arrayDetalhes = detalhes.split("; ");
		String retorno = "";
		for (int i = arrayDetalhes.length - 1; i >= 0; i--) {
			if (i <= 5) {
				retorno += arrayDetalhes[i] + "\n";
			}
		}
		return retorno;
	}
	

/**
 * Acessa ao atributo nomeCantina, e informa o nome da cantina.
 * 
 * @return informa nome da cantina
 */

	public String getNomeCantina() {
		return nomeCantina;
	}

/**
 * Acessa ao atributo debitoConta, e informa o debito do aluno na cantina.
 * 
 * @return informa o debito do aluno
 */

	public int getDebitoConta() {
		return debitoConta;
	}

/**
 * Acessa ao atributo debitoConta, e informa o quanto o aluno falta pagar.
 * 
 * @return informa o que o aluno deve
 */

	public int getFaltaPagar() {
		return debitoConta;
	}

/**
 * Retorna a String que representa as informações da conta do aluno na cantina.
 * A representação segue o formato "nomeCantina quantidadeprodutosconsumidos valorgastototal 5ultimosdetalhes".
 * 
 * @return a representação em String dos dados da conta do aluno na cantina 
 */

	public String toString() {
		return nomeCantina + " " + quantidade + " " + valorGasto + listarDetalhes();
	}
}
