package Prog2;

import java.util.Scanner;

public class LAB3_HENRIQUE_LEMOS {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Agenda agenda = new Agenda();

		while (true) {
			System.out.println("(C)adastrar Contato" + "\n" + "(L)istar Contatos" + "\n" + "(E)xibir Contato" + "\n" + "(S)air" + "\n");
			System.out.print("Opcão> ");
			String opcao = entrada.nextLine();
			
			if("C".equals(opcao)) {
				System.out.print("\n" + "Posição: ");
				int posicao = entrada.nextInt();
				if (agenda.aprovaPosicao(posicao) == true) {
					entrada.nextLine();
					System.out.print("Nome: ");
					String nome = entrada.nextLine();
					if (!"".equals(nome)) {
						System.out.print("Sobrenome: ");
						String sobrenome = entrada.nextLine();
						System.out.print("Telefone: ");
						String telefone = entrada.nextLine();
						boolean cadastro = agenda.cadastraContato(posicao, nome, sobrenome, telefone);
						if (cadastro == true) {
							System.out.println("CADASTRO REALIZADO!");
						} else {
							System.out.println("Sou eu, " + nome + "!");
						}
					} else {
						System.out.println("NOME VAZIO, TENTE NOVAMENTE!");
					}
				} else {
					System.out.println("POSIÇÃO INVÁLIDA!");
					entrada.nextLine();
				}
				System.out.println();
			} else if("L".equals(opcao)) {
				System.out.println("\n" + agenda.listaContatos());
			} else if("E".equals(opcao)) {
				System.out.print("Contato> ");
				int posicao = entrada.nextInt();
				entrada.nextLine();
				System.out.println(agenda.exibeContatos(posicao));
				System.out.println();
			} else if("S".equals(opcao)) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA!" + "\n");
			}
		}
		entrada.close();
	}
}
