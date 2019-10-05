package Prog2;

/**
 * Banco de dados do aluno, referente a(s) sua(s) conta(s) no(s) laboratório(s);
 * a(s) sua(s) disciplina(s) matriculada(s);
 * sua(s) conta(s) na(s) cantina(s);
 * sua situação de saúde.
 * 
 * @author Henrique Lemos
 */

public class Aluno {

/**
 * Em cada banco de dados do aluno, são cadastrados:
 * sua(s) conta(s) no(s) laboratório(s);
 * sua(s) disciplina(s) matriculada(s);
 * sua(s) conta(s) na(s) cantina(s);
 * sua situação de saúde.
 * 
 */
	
	private ContaLaboratorio lab;
	private ContaLaboratorio[] laboratorios = new ContaLaboratorio[100000];
	private Disciplina materia;
	private Disciplina[] todasMaterias = new Disciplina[100000];
	private ContaCantina cantina;
	private ContaCantina[] conveniencias = new ContaCantina[100000];
	private Saude diagnostico;


/**
 * Constrói uma conta no laboratório ao qual o aluno esta utilizando.
 * Todo aluno que não há especificação da sua cota, automáticamente sua cota é 2000MB.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno se refere
 * 
 */

	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.lab = new ContaLaboratorio(nomeLaboratorio);
		for (int l = 0; l < laboratorios.length; l++) {
			if(laboratorios[l] == null) {
				laboratorios[l] = lab;
				break;
			}
		}
	}

/**
 * Constrói uma conta no laboratório ao qual o aluno esta utilizando.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno se refere
 * @param cota quantidade de memória de uso possível do aluno
 */

	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.lab = new ContaLaboratorio(nomeLaboratorio, cota);
		for (int l = 0; l < laboratorios.length; l++) {
			if(laboratorios[l] == null) {
				laboratorios[l] = lab;
				break;
			}
		}
	}

/**
 * Adiciona a quantidade de memoria utilizada.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno se refere
 * @param mbytes número de MB de dados utilizado pelo aluno.
 * 
 */

	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		for (int i = 0; i < laboratorios.length; i++) {
			if(nomeLaboratorio.equals(laboratorios[i].getNomeLaboratorio())) {
				laboratorios[i].consomeEspaco(mbytes);
			}
		}
	}

/**
 * Libera da memória utilizada a quantidade de memoria apagada.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno se refere
 * @param mbytes númeor de MB de dados utilizados pelo aluno
 */

	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		for (int i = 0; i < laboratorios.length; i++) {
			if(nomeLaboratorio.equals(laboratorios[i].getNomeLaboratorio())) {
				laboratorios[i].liberaEspaco(mbytes);
			}
		}
	}

/**
 * Avisa ao aluno quando a sua memória atingiu ao limite de cota disponível.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno se refere
 * @return true para quando sim, e false para quando não
 * 
 */

	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio account = null;
		for (int i = 0; i < laboratorios.length; i++) {
			if(nomeLaboratorio.equals(laboratorios[i].getNomeLaboratorio())) {
				account = laboratorios[i];
			}
		}
		if (account != null) {
			return account.atingiuCota();
		} else {
			throw new IllegalArgumentException("Laboratório Inválido");
		}
	}

/**
 * Retorna a String que representa as informações do aluno no laboratorio selecionado.
 * 
 * @param nomeLaboratorio nome do laboratório ao qual o aluno se refere
 * @return a representação em String dos dados do aluno no laboratorio
 */

	public String laboratorioToString(String nomeLaboratorio) {
		ContaLaboratorio texto = null;
		for (int i = 0; i < laboratorios.length; i++) {
			if(nomeLaboratorio.equals(laboratorios[i].getNomeLaboratorio())) {
				texto = laboratorios[i];
			}
		}
		if (texto != null) {
			return texto.toString();
		} else {
			throw new IllegalArgumentException("Laboratório Inválido");
		}
	}

/**
 * Constrói um cadastro da disciplina no qual o aluno está matriculado.
 * Omde por padrão toda disciplina tem 4 notas.
 * 
 * @param nomeDisciplina o nome da disciplina no qual o aluno está matriculado
 */

	public void cadastraDisciplina(String nomeDisciplina) {
		this.materia = new Disciplina(nomeDisciplina);
		for (int m = 0; m < todasMaterias.length; m++) {
			if(todasMaterias[m] == null) {
				todasMaterias[m] = materia;
				break;
			}
		}
	}

/**
 * Cadastra a quantidade de horas estudadas pelo aluno.
 * Atualizando de dorma somátória o número de horas estudadas.
 * 
 * @param nomeDisciplina o nome da disciplina no qual o aluno está matriculado
 * @param horas volor de horas que o aluno estudou
 */

	public void cadastraHoras(String nomeDisciplina, int horas) {
		for (int i = 0; i < todasMaterias.length; i++) {
			if(nomeDisciplina.equals(todasMaterias[i].getNomeDisciplina())) {
				todasMaterias[i].cadastraHoras(horas);
			}
		}
	}

/**
 * A partir do padrão de 4 notas por disciplina, ele cadastra o valor da nota em determinada nota.
 * 
 * @param nomeDisciplina o nome da disciplina no qual o aluno está matriculado
 * @param nota valor entre 4, por disciplina.
 * @param valorNota valor da nota (dentre as 4 da disciplina)
 */

	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		for (int i = 0; i < todasMaterias.length; i++) {
			if(nomeDisciplina.equals(todasMaterias[i].getNomeDisciplina())) {
				todasMaterias[i].cadastraNota(nota, valorNota);
			}
		}
	}

/**
 * A partir do calculo da media, informa se o aluno passou ou não na disciplina.
 * 
 * @param nomeDisciplina o nome da disciplina no qual o aluno está matriculado
 * @return true para sim e false para não
 */

	public boolean aprovado(String nomeDisciplina) {
		Disciplina cadeira = null;
		for (int i = 0; i < todasMaterias.length; i++) {
			if(nomeDisciplina.equals(todasMaterias[i].getNomeDisciplina())) {
				cadeira = todasMaterias[i];
			}
		}
		if (cadeira != null) {
			return cadeira.aprovado();
		} else {
			throw new IllegalArgumentException("Disciplina Inválida");
		}
		
	}

/**
 * Retorna a String que representa as informações do aluno na disciplina.
 * A representação segue o formato "nomeDisciplina horaEstudo media notasdoaluno".
 * 
 * @param nomeDisciplina o nome da disciplina no qual o aluno está matriculado
 * @return a representação em String dos dados do aluno na disciplina
 */

	public String disciplinaToString(String nomeDisciplina) {
		Disciplina texto = null;
		for (int i = 0; i < todasMaterias.length; i++) {
			if(nomeDisciplina.equals(todasMaterias[i].getNomeDisciplina())) {
				texto = todasMaterias[i];
			}
		}
		if (texto != null) {
			return texto.toString();
		} else {
			throw new IllegalArgumentException("Disciplina Inválida");
		}
	}

/**
 * Constrói uma conta para o aluno na cantina, onde sua conta já começa com o débito zero.
 * 
 * @param nomeCantina nome do estabelecimento referente
 */

	public void cadastraCantina(String nomeCantina) {
		this.cantina = new ContaCantina(nomeCantina);
		for (int c = 0; c < conveniencias.length; c++) {
			if(conveniencias[c] == null) {
				conveniencias[c] = cantina;
				break;
			}
		}
	}

/**
 * Cadastra o(s) lanche(s) consumidos pelo aluno.
 * 
 * @param nomeCantina nome do estabelecimento referente
 * @param qtdItens número de produtos consumidos
 * @param valorCentavos valor total dos produtos consumidos
 */

	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		for (int i = 0; i < conveniencias.length; i++) {
			if (nomeCantina.equals(conveniencias[i].getNomeCantina())) {
				conveniencias[i].cadastraLanche(qtdItens, valorCentavos);
			}
		}
	}

/**
 * Realiza o pagamento do débito do aluno na cantina,
 * subtraindo do valor que ele deve.
 * Caso o aluno estiver pagando mais do que ele deve,
 * será informado um erro.
 * 
 * @param nomeCantina nome do estabelecimento referente
 * @param valorCentavos valor refrente ao quanto o aluno vai pagar
 */

	public void pagarConta(String nomeCantina, int valorCentavos) {
		for (int i = 0; i < conveniencias.length; i++) {
			if (nomeCantina.equals(conveniencias[i].getNomeCantina())) {
				conveniencias[i].pagaConta(valorCentavos);
			}
		}
	}

/**
 * Acessa ao atributo debitoConta, e informa o quanto o aluno falta pagar.
 * 
 * @param nomeCantina nome do estabelecimento referente
 * @return informa o que o aluno deve
 */

	public int getFaltarPagar(String nomeCantina) {
		ContaCantina conta = null;
		for (int i = 0; i < conveniencias.length; i++) {
			if (nomeCantina.equals(conveniencias[i].getNomeCantina())) {
				conta = conveniencias[i];
			}
		}
		if (conta != null) {
			return conta.getFaltaPagar();
		} else {
			throw new IllegalArgumentException("Conta Inválida");
		}
	}

/**
 * Retorna a String que representa as informações da conta do aluno na cantina.
 * A representação segue o formato "nomeCantina quantidadeprodutosconsumidos valorgastototal 5ultimosdetalhes".
 * 
 * @param nomeCantina nome do estabelecimento referente
 * @return a representação em String dos dados da conta do aluno na cantina 
 */

	public String cantinaToString(String nomeCantina) {
		ContaCantina conta = null;
		for (int i = 0; i < conveniencias.length; i++) {
			if (nomeCantina.equals(conveniencias[i].getNomeCantina())) {
				conta = conveniencias[i];
			}
		}
		if (conta != null) {
			return conta.getNomeCantina();
		} else {
			throw new IllegalArgumentException("Conta Inválida");
		}
	}

/**
 * Define a condição mental do aluno.
 * 
 * @param valor valor mental, sendo fraco ou forte
 */

	public void defineSaudeMental(String valor) {
		this.diagnostico.defineSaudeMental(valor);
	}

/**
 * Define a condição fisica do aluno.
 * 
 * @param valor valor fisico, sendo fraco ou forte
 */

	public void defineSaudeFisica(String valor) {
		this.diagnostico.defineSaudeFisica(valor);
	}

/**
 * Calcula o status do aluno a apartir da analise das informações da sua conta saúde com a sua sensação.
 * Onde, se for: FÌSICA: fraca + MENTAL: fraca = fraca;
 * se for FÌSICA: boa + MENTAL: boa = boa;
 * se for FÌSICA: fraca + MENTAL: boa = ok, ou visse versa.
 * 
 * @return a situação do aluno
 */

	public String getStatusGeral() {
		return this.diagnostico.getStatusGeral();
	}
}
