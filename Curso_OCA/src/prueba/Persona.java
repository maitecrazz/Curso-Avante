package prueba;

public abstract class Persona implements Comparable<Persona>, Cotizable {

	public Persona(String nombre, String apellido, Integer edad, String dNI, int fechaInicio, 
			TipoContrato contrato, boolean estaJubilado) throws DNINoValidoException {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		checkDNI(dNI);
		DNI = dNI;
		this.fechaInicio = fechaInicio;
		this.contrato = contrato;
		this.estaJubilado = estaJubilado;
	}

	private String nombre;
	private String apellido;
	private Integer edad;
	private String DNI;
	private int fechaInicio;
	private TipoContrato contrato;
	private boolean estaJubilado;

	public Persona() {
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getDNI(){
		
		return DNI;
	}


	public void setDNI(String dNI) {
		try{
			checkDNI(dNI);
			DNI = dNI;
		}
		catch(DNINoValidoException e) {
			e.printStackTrace();
		}
	}
	
	public int getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(int fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public TipoContrato getContrato() {
		return contrato;
	}


	public void setContrato(TipoContrato contrato) {
		this.contrato = contrato;
	}
	
	public boolean getEstaJubilado() {
		return estaJubilado;
	}


	public void setEstaJubilado(boolean estaJubilado) {
		this.estaJubilado = estaJubilado;
	}


	public abstract boolean puedeJubilarse();

	public abstract int añosParaJubilarse();
	
	private void checkDNI(String dni) throws DNINoValidoException {
		
		String dic = "TRWAGMYFPDXBNJZSQVHLCKE";
		if(dni.length() != 9) {
			throw new DNINoValidoException("El DNI no debe tener longitud distinta a 9.");
		}
		else if(!dni.matches("\\d{8}[a-zA-Z]")){
			throw new DNINoValidoException("El DNI debe tener 8 dígitos y una letra.");
		}
		else if(dni.charAt(8) != dic.charAt(new Integer(dni.substring(0, 8)) % 23 )) {
			throw new DNINoValidoException("DNI no válido.");
		}
	}

	public int compareTo(Persona o) {
			return this.edad - o.edad;
	}
	
	public String toString() {
		return this.getNombre() + " " + this.getApellido() + ", " + this.getDNI();
	}
	

}
