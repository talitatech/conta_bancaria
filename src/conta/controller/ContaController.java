package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;

public class ContaController {

	// Lista responsável por armazenar todas as contas
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	/*
	 * Método responsável por procurar uma conta
	 * através do número da conta.
	 */
	public void procurarPorNumero(int numero) {

		for (Conta conta : listaContas) {

			if (conta.getNumero() == numero) {

				conta.visualizar();

				return;
			}
		}

		System.out.println("\nA Conta número " + numero + " não foi encontrada!");
	}

	/*
	 * Método responsável por listar todas as contas cadastradas.
	 */
	public void listarTodas() {

		for (Conta conta : listaContas) {

			conta.visualizar();
		}
	}

	/*
	 * Método responsável por cadastrar uma nova conta
	 * dentro da lista de contas.
	 */
	public void cadastrar(Conta conta) {

		listaContas.add(conta);

		System.out.println("\nA Conta número "
				+ conta.getNumero()
				+ " foi criada com sucesso!");
	}

	/*
	 * Método responsável por atualizar os dados
	 * de uma conta existente.
	 */
	public void atualizar(Conta conta) {

		int indice = buscarNaCollection(conta.getNumero());

		if (indice != -1) {

			listaContas.set(indice, conta);

			System.out.println("\nA Conta número "
					+ conta.getNumero()
					+ " foi atualizada com sucesso!");

		} else {

			System.out.println("\nA Conta número "
					+ conta.getNumero()
					+ " não foi encontrada!");
		}
	}

	/*
	 * Método responsável por deletar uma conta
	 * através do número.
	 */
	public void deletar(int numero) {

		int indice = buscarNaCollection(numero);

		if (indice != -1) {

			listaContas.remove(indice);

			System.out.println("\nA Conta número "
					+ numero
					+ " foi apagada com sucesso!");

		} else {

			System.out.println("\nA Conta número "
					+ numero
					+ " não foi encontrada!");
		}
	}

	/*
	 * Método auxiliar responsável por buscar
	 * a posição da conta dentro da lista.
	 */
	public int buscarNaCollection(int numero) {

		for (int i = 0; i < listaContas.size(); i++) {

			if (listaContas.get(i).getNumero() == numero) {

				return i;
			}
		}

		return -1;
	}

	/*****************************************************
	 * FEATURE: Métodos Bancários
	 *****************************************************/

	/*
	 * Método responsável por realizar saque em uma conta.
	 * Primeiro procura a conta pelo número.
	 * Depois verifica se existe saldo suficiente.
	 */
	public void sacar(int numero, float valor) {

		Conta conta = buscarConta(numero);

		if (conta != null) {

			if (conta.sacar(valor) == true) {

				System.out.println("\nSaque realizado com sucesso!");
			}

		} else {

			System.out.println("\nA Conta número "
					+ numero
					+ " não foi encontrada!");
		}
	}

	/*
	 * Método responsável por realizar depósito em uma conta.
	 * Procura a conta pelo número e adiciona o valor ao saldo.
	 */
	public void depositar(int numero, float valor) {

		Conta conta = buscarConta(numero);

		if (conta != null) {

			conta.depositar(valor);

			System.out.println("\nDepósito realizado com sucesso!");

		} else {

			System.out.println("\nA Conta número "
					+ numero
					+ " não foi encontrada!");
		}
	}

	/*
	 * Método responsável por transferir dinheiro entre contas.
	 * Primeiro procura a conta de origem e destino.
	 * Depois realiza o saque da conta origem
	 * e o depósito na conta destino.
	 */
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		Conta contaOrigem = buscarConta(numeroOrigem);
		Conta contaDestino = buscarConta(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {

			if (contaOrigem.sacar(valor) == true) {

				contaDestino.depositar(valor);

				System.out.println("\nTransferência realizada com sucesso!");
			}

		} else {

			System.out.println("\nConta de origem ou destino não encontrada!");
		}
	}

	/*
	 * Método auxiliar responsável por buscar uma conta
	 * dentro da lista através do número.
	 * Retorna a conta encontrada ou null.
	 */
	public Conta buscarConta(int numero) {

		for (Conta conta : listaContas) {

			if (conta.getNumero() == numero) {

				return conta;
			}
		}

		return null;
	}
}