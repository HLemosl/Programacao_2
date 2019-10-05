package Prog2;

/**
 * Responsável por manter registrado a quantidade de espaço utilizado por um aluno, em um determinado laboratório.
 * Onde para cada laboratório, é criado um objeto para controle desse espaço ocupado.
 * 
 * @author Henrique Lemos
 */

public class ContaLaboratorio {

/**
 * A cada nova conta criada pelo aluno, será salvo:
 * O laboratório à qual ele esta usando;
 * Um espaço onde será manipulado o armazenamento de informaçoes do aluno, e a partir dele saberá quanto utilizou e quanto tem disponível para uso;
 * Um valor de cota (que por padrão são 2GB ou 2000MB) como limite disponível para o aluno.
 */

	private String nomeLaboratorio;
	private int espaco;
	private int cota;

/**
 * Constrói uma conta no laboratório ao qual o aluno esta utilizando.
 * Todo aluno que não há especificação da sua cota, automáticamente sua cota é 2000MB.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno esta utilizando
 */

	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}

/**
 * Constrói uma conta no laboratório ao qual o aluno esta utilizando.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno esta utilizando.
 * @param cota quantidade de memória de uso possível do aluno
 */

	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}

/**
 * Adiciona a quantidade de memoria utilizada.
 * 
 * @param mbytes número de MB de dados utilizado pelo aluno.
 */

	public void consomeEspaco(int mbytes) {
		espaco += mbytes;
	}

/**
 * Libera da memória utilizada a quantidade de memoria apagada.
 * 
 * @param mbytes númeor de MB de dados utilizados pelo aluno
 */

	public void liberaEspaco(int mbytes) {
		espaco -= mbytes;
	}

/**
 * Avisa ao aluno quando a sua memória atingiu ao limite de cota disponível.
 * 
 * @return true para quando sim, e false para quando não
 */

	public boolean atingiuCota() {
		if (espaco >= cota) {
			return true;
		}
		return false;
	}
	

/**
 * Acessa ao atributo espaco, informando o valor dele.
 * 
 * @return informa o valor de espaco
 */

	public int getEspaco() {
		return espaco;
	}

/**
 * Acessa ao atributo cota, informando o valor dele.
 * 
 * @return informa o valor de cota
 */

	public int getCota() {
		return cota;
	}

/**
 * Acessa ao atributo nomeLaboratorio, e informa o valor dele.
 * 
 * @return informa o nome do laboratório
 */

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

/**
 * Retorna a String que representa as informações do aluno no laboratorio.
 * A representação segue o formato "nomeLaboratorio espaco cota".
 * 
 * @return a representação em String dos dados do aluno no laboratorio 
 */

	public String toString() {
		return nomeLaboratorio + " " + espaco + "/" + cota;
	}
}
