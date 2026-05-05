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

	// Listar todas as contas
	public void listarTodas() {

		for (Conta conta : listaContas) {
			conta.visualizar();
		}
	}

	// Cadastrar conta
	public void cadastrar(Conta conta) {

		listaContas.add(conta);

		System.out.println("\nA Conta número " + conta.getNumero() + " foi criada com sucesso!");
	}

	// Atualizar conta
	public void atualizar(Conta conta) {

		int indice = buscarNaCollection(conta.getNumero());

		if (indice != -1) {
			listaContas.set(indice, conta);

			System.out.println("\nA Conta número " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA Conta número " + conta.getNumero() + " não foi encontrada!");
		}
	}

	// Deletar conta
	public void deletar(int numero) {

		int indice = buscarNaCollection(numero);

		if (indice != -1) {
			listaContas.remove(indice);

			System.out.println("\nA Conta número " + numero + " foi apagada com sucesso!");
		} else {
			System.out.println("\nA Conta número " + numero + " não foi encontrada!");
		}
	}

	// Método auxiliar
	public int buscarNaCollection(int numero) {

		for (int i = 0; i < listaContas.size(); i++) {
			if (listaContas.get(i).getNumero() == numero) {
				return i;
			}
		}

		return -1;
	}
}