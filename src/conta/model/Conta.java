package conta.model;

public class Conta {

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public void visualizar() {

		String tipoConta = "";

		switch (this.tipo) {
			case 1:
				tipoConta = "Conta Corrente";
				break;
			case 2:
				tipoConta = "Conta Poupança";
				break;
		}

		System.out.println("\n*****************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("*****************************************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipoConta);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: R$ " + this.saldo);
	}

	public int getNumero() {
		return numero;
	}
}