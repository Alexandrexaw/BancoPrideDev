package dominio;

public class ContaPoupanca extends Conta implements Sacavel{

	public void sacar(float valorSaque)  {

		if (valorSaque  <= this.saldo) {
			this.saldo = this.saldo - valorSaque;
		}else{
			throw new RuntimeException("Saldo insuficiente");
		}
	}
	
	public void trasferir(float valorTransferencia, Conta outraConta) {
		this.sacar(valorTransferencia);
		outraConta.depositar(valorTransferencia);
		
	}
}