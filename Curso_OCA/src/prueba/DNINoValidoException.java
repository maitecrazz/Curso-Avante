package prueba;

public class DNINoValidoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DNINoValidoException() {
		
	}
	
	public DNINoValidoException(String msg) {
		super(msg);
	}
}
