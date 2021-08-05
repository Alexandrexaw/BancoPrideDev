package dominio;

public class ContaInvestimento extends Conta{
	
	public void investir(float valorInvestido){
		this.saldo += valorInvestido * 1.1;
	}


}
