package prueba;

public class DNIDuplicadoException extends DNINoValidoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DNIDuplicadoException() {
		super();
	}
	
	public DNIDuplicadoException(String msg) {
		super(msg);
	}
}
