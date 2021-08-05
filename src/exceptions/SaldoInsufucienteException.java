package exceptions;

public class SaldoInsufucienteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SaldoInsufucienteException(String mensagemErro) {
		super(mensagemErro);
	}
	

}