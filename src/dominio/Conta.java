package dominio;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	protected int id;
	protected String numeroConta;
	protected String numeroAgencia;
	protected float saldo;
	protected Cliente cliente;
	protected int id_cliente;

	public int getId() {
		return id;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public String[] getChavePix() {
		return chavePix;
	}

	protected String chavePix[] = new String[3]; // email, cpf, telefone

	
	public Conta(String numeroAgencia, String numeroConta,float saldo, int id_cliente) {
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.id_cliente = id_cliente;
	}
	
	
	public float getSaldo() {
		return saldo;

	}

	public String getChavePix(int pos) {
		return chavePix[pos];
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}


	public void adicionarChavePix(String novaChave) {

		if (chavePix[0] == null) {
			chavePix[0] = novaChave;
		} else {
			if (chavePix[1] == null) {
				chavePix[1] = novaChave;
			}else {
				chavePix[2] = novaChave;
			}
		}
	}

	public void depositar(float valorDepositado) {
		this.saldo += valorDepositado;
	}

	public void trasferir(float valorTransferencia, Conta contaDestino) {

		this.sacar(valorTransferencia);
		contaDestino.depositar(valorTransferencia);
	}

	public void sacar(float valorSaque) {
		this.saldo -= valorSaque; 

		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setId(String numeroAgencia, String numeroConta) {
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
	}


}
