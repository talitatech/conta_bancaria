package conta;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

					ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Talita Santos", 1000.0f);

					ContaPoupanca cp1 = new ContaPoupanca(2, 124, 2, "Maria Silva", 5000.0f);

					contas.cadastrar(cc1);
					contas.cadastrar(cp1);

					break;

				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

					contas.listarTodas();

					break;

				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

					contas.procurarPorNumero(1);

					break;

				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

					ContaCorrente cc2 = new ContaCorrente(1, 123, 1, "Talita Atualizada", 8000.0f);

					contas.atualizar(cc2);

					break;

				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

					contas.deletar(2);

					break;

				case 6:
					System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

					break;

				case 7:
					System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

					break;

				case 8:
					System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

					break;

				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					break;
			}
		}
	}

	public static void sobre() {

		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Talita Santos");
		System.out.println("Generation Brasil - talitas@generation.org");
		System.out.println("github.com/talitatech");
		System.out.println("*********************************************************");
	}
}