package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;

public class ContaController {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Procurar conta por número
	public void procurarPorNumero(int numero) {

		for (Conta conta : listaContas) {
			if (conta.getNumero() == numero) {
				conta.visualizar();
				return;
			}
		}

		System.out.println("\nA Conta número " + numero + " não foi encontrada!");
	}

	// Listar todas as contas cadastradas
	public void listarTodas() {

		for (Conta conta : listaContas) {
			conta.visualizar();
		}
	}

	// Cadastrar uma nova conta na lista
	public void cadastrar(Conta conta) {

		listaContas.add(conta);

		System.out.println("\nA Conta número " + conta.getNumero() + " foi criada com sucesso!");
	}

	// Atualizar os dados de uma conta existente
	public void atualizar(Conta conta) {

		int indice = buscarNaCollection(conta.getNumero());

		if (indice != -1) {
			listaContas.set(indice, conta);

			System.out.println("\nA Conta número " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA Conta número " + conta.getNumero() + " não foi encontrada!");
		}
	}

	// Deletar uma conta pelo número
	public void deletar(int numero) {

		int indice = buscarNaCollection(numero);

		if (indice != -1) {
			listaContas.remove(indice);

			System.out.println("\nA Conta número " + numero + " foi apagada com sucesso!");
		} else {
			System.out.println("\nA Conta número " + numero + " não foi encontrada!");
		}
	}

	// Método auxiliar que busca a posição da conta na lista
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

	// Realiza saque em uma conta pelo número
	public void sacar(int numero, float valor) {

		Conta conta = buscarConta(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true) {
				System.out.println("\nSaque realizado com sucesso!");
			}
		} else {
			System.out.println("\nA Conta número " + numero + " não foi encontrada!");
		}
	}

	// Realiza depósito em uma conta pelo número
	public void depositar(int numero, float valor) {

		Conta conta = buscarConta(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nDepósito realizado com sucesso!");
		} else {
			System.out.println("\nA Conta número " + numero + " não foi encontrada!");
		}
	}

	// Realiza transferência entre duas contas
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

	// Método auxiliar que retorna a conta encontrada pelo número
	public Conta buscarConta(int numero) {

		for (Conta conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}
}