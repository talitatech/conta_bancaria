package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
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
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nCriar Conta\n\n" + Cores.TEXT_RESET);
                    break;
                case 2:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nListar todas as Contas\n\n" + Cores.TEXT_RESET);
                    break;
                case 3:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nConsultar dados da Conta - por número\n\n" + Cores.TEXT_RESET);
                    break;
                case 4:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nAtualizar dados da Conta\n\n" + Cores.TEXT_RESET);
                    break;
                case 5:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nApagar a Conta\n\n" + Cores.TEXT_RESET);
                    break;
                case 6:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nSaque\n\n" + Cores.TEXT_RESET);
                    break;
                case 7:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nDepósito\n\n" + Cores.TEXT_RESET);
                    break;
                case 8:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "\nTransferência entre Contas\n\n" + Cores.TEXT_RESET);
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
        System.out.println("TALITA SANTOS - talitas@genstudents.org");
        System.out.println("github.com/talitatech");
        System.out.println("*********************************************************");
    }
}