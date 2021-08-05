package dominio;

import exceptions.SaldoInsufucienteException;

public class ContaCorrente extends Conta  implements Sacavel {
	private float chequeEspecial = 100;
	

	@Override
	public void sacar(float valorSaque)  {
		if (valorSaque  <= this.saldo + chequeEspecial) {
			this.saldo = this.saldo - valorSaque;
		}else{
			throw new SaldoInsufucienteException("Saldo insuficiente");
		}
	}
	
	public float getChequeEspecial() {
		return this.chequeEspecial;
	}
	
	public void trasferir(float valorTransferencia, Conta outraConta) {
		this.sacar(valorTransferencia);
		outraConta.depositar(valorTransferencia);
		
	}



	

	
}
