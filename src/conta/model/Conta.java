package conta.model;

public class Conta {

	// Atributos da conta
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	/*
	 * Método construtor responsável por inicializar
	 * os dados da conta no momento da criação.
	 */
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {

		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	/*
	 * Método responsável por exibir os dados da conta.
	 */
	public void visualizar() {

		String tipoConta = "";

		// Verifica o tipo da conta
		switch (this.tipo) {

			case 1:
				tipoConta = "Conta Corrente";
				break;

			case 2:
				tipoConta = "Conta Poupança";
				break;
		}

		// Exibe os dados da conta
		System.out.println("\n*****************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("*****************************************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipoConta);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: R$ " + this.saldo);
	}

	/*
	 * Getter responsável por retornar o número da conta.
	 */
	public int getNumero() {

		return numero;
	}

	/*****************************************************
	 * FEATURE: Métodos Bancários
	 *****************************************************/

	/*
	 * Método responsável por realizar saque da conta.
	 * Primeiro verifica se existe saldo suficiente.
	 * Caso tenha saldo, o valor é removido da conta.
	 */
	public boolean sacar(float valor) {

		// Verifica se o saldo é insuficiente
		if (this.saldo < valor) {

			System.out.println("\nSaldo insuficiente!");

			return false;
		}

		// Remove o valor do saldo da conta
		this.saldo -= valor;

		return true;
	}

	/*
	 * Método responsável por realizar depósito na conta.
	 * O valor informado é somado ao saldo atual.
	 */
	public void depositar(float valor) {

		// Soma o valor ao saldo da conta
		this.saldo += valor;
	}

	/*
	 * Getter responsável por retornar o saldo atual da conta.
	 */
	public float getSaldo() {

		return saldo;
	}
}