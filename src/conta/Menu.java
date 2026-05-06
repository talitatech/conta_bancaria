package conta;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Objeto responsável pela leitura de dados do teclado
		Scanner leia = new Scanner(System.in);

		// Instância da classe controller responsável pelas operações bancárias
		ContaController contas = new ContaController();

		int opcao;

		// Estrutura de repetição responsável por manter o menu em execução
		while (true) {

			// Exibição do menu principal
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

			// Recebe a opção digitada pelo usuário
			opcao = leia.nextInt();

			// Finaliza o sistema caso o usuário digite 0
			if (opcao == 0) {

				System.out.println(Cores.TEXT_WHITE_BOLD
						+ "\nBanco do Brazil com Z - O seu Futuro começa aqui!");

				sobre();

				leia.close();

				System.exit(0);
			}

			// Estrutura responsável por executar cada funcionalidade do menu
			switch (opcao) {

				case 1:

					System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

					// Criação de uma conta corrente
					ContaCorrente cc1 = new ContaCorrente(
							1,
							123,
							1,
							"Talita Santos",
							1000.0f);

					// Criação de uma conta poupança
					ContaPoupanca cp1 = new ContaPoupanca(
							2,
							124,
							2,
							"Maria Silva",
							5000.0f);

					// Cadastro das contas no controller
					contas.cadastrar(cc1);
					contas.cadastrar(cp1);

					break;

				case 2:

					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

					// Lista todas as contas cadastradas
					contas.listarTodas();

					break;

				case 3:

					System.out.println(Cores.TEXT_WHITE
							+ "Consultar dados da Conta - por número\n\n");

					// Busca uma conta pelo número
					contas.procurarPorNumero(1);

					break;

				case 4:

					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

					// Atualiza os dados da conta existente
					ContaCorrente cc2 = new ContaCorrente(
							1,
							123,
							1,
							"Talita Atualizada",
							8000.0f);

					contas.atualizar(cc2);

					break;

				case 5:

					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

					// Remove a conta da lista
					contas.deletar(2);

					break;

				/*****************************************************
				 * FEATURE: Métodos Bancários
				 *****************************************************/

				case 6:

					System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

					// Realiza saque da conta
					contas.sacar(1, 100.0f);

					break;

				case 7:

					System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

					// Realiza depósito na conta
					contas.depositar(1, 200.0f);

					break;

				case 8:

					System.out.println(Cores.TEXT_WHITE
							+ "Transferência entre Contas\n\n");

					// Realiza transferência entre contas
					contas.transferir(1, 2, 300.0f);

					break;

				default:

					System.out.println(Cores.TEXT_RED_BOLD
							+ "\nOpção Inválida!\n"
							+ Cores.TEXT_RESET);

					break;
			}
		}
	}

	/*
	 * Método responsável por exibir os créditos do projeto.
	 */
	public static void sobre() {

		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Talita Santos");
		System.out.println("Generation Brasil - talitas@generation.org");
		System.out.println("github.com/talitatech");
		System.out.println("*********************************************************");
	}
}