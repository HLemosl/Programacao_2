package Prog2;

/**
 * O acompanhamento do estado da saúde do aluno é importante,
 * Todo aluno tem uma saúde física e mental, podendo ser boa ou fraca,
 * assim este programa tem por função criar um cadastro da saúde do aluno.
 * 
 * @author Henrique Lemos
 */

public class Saude {

/**
 * Na criação da conta de saúde do aluno, são cadastrados:
 * Sua condição de saúde física;
 * Sua condição de saúde mental;
 * Sua sensção, representado por emoji.
 */

	private String fisica;
	private String mental;
	private String sensacao;


/**
 * Realiza a criação da conta saúde do aluno.
 */

	public Saude() {
	}

/**
 * Define a condição mental do aluno.
 * 
 * @param valor valor mental, sendo fraco ou forte
 */

	public void defineSaudeMental(String valor) {
		this.mental = valor;
	}

/**
 * Define a condição fisica do aluno.
 * 
 * @param valor valor fisico, sendo fraco ou forte
 */

	public void defineSaudeFisica(String valor) {
		this.fisica = valor;
	}

/**
 * Define um emoji para a sensação do aluno no momento.
 * 
 * @param valor emoji feito pelo aluno
 */

	public void definirEmoji(String valor) {
		this.sensacao = valor;
	}


/**
 * Calcula o status do aluno a apartir da analise das informações da sua conta saúde com a sua sensação.
 * Onde, se for: FÌSICA: fraca + MENTAL: fraca = fraca;
 * se for FÌSICA: boa + MENTAL: boa = boa;
 * se for FÌSICA: fraca + MENTAL: boa = ok, ou visse versa.
 * 
 * 
 * @return a situação do aluno
 */

	public String getStatusGeral() {
		if ("fraca".equals(this.fisica) && "fraca".equals(this.mental)) {
			return "fraca" + this.sensacao;
		} else if ("boa".equals(this.fisica) && "boa".equals(this.mental)) {
			return "boa" + this.sensacao;
		} else if (("fraca".equals(this.fisica) && "boa".equals(this.mental)) || ("boa".equals(this.fisica) && "fraca".equals(this.mental))) {
			return "ok" + this.sensacao;
		}
		return "boa" + this.sensacao;
	}

/**
 * Acessa o atributo fisica, e informa a situação física.
 * 
 * @return situação física
 */

	public String getFisica() {
		return fisica;
	}

/**
 * Acessa o atributo mental, e informa a situação mental.
 * 
 * @return situação mental
 */

	public String getMental() {
		return mental;
	}

/**
 * Acessa o atributo sensacao, e informa a sensação informada pelo aluno
 * 
 * @return informa a sensação do aluno
 */

	public String getSensacao() {
		return sensacao;
	}
}
