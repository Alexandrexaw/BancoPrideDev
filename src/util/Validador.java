package util;
public class Validador {
	public static void  validaCPF(String cpf){
		if(cpf.length() != 11) {
			throw new IllegalArgumentException("CPF Invalido");
		}
		
	}
}
