package prueba;

import java.util.Calendar;
import java.util.List;

public class EmpleadoPublico extends Persona implements AutoCloseable{
	private String organismoPublico;
	private Integer numeroTrienio;

	public EmpleadoPublico(String nombre, String apellido, Integer edad, String dNI, int fechaInicio,
			TipoContrato contrato, String organismoPublico, Integer numeroTrienio, boolean estaJubilado) 
					throws DNINoValidoException {
		super(nombre, apellido, edad, dNI, fechaInicio, contrato, estaJubilado);
		this.organismoPublico = organismoPublico;
		this.numeroTrienio = numeroTrienio;
	}

	public String getOrganismoPublico() {
		return organismoPublico;
	}

	public void setOrganismoPublico(String organismoPublico) {
		this.organismoPublico = organismoPublico;
	}

	public Integer getNumeroTrienio() {
		return numeroTrienio;
	}

	public void setNumeroTrienio(Integer numeroTrienio) {
		this.numeroTrienio = numeroTrienio;
	}
	
	public int compareTo(EmpleadoPublico o) {
		
		return this.getNumeroTrienio().compareTo(o.numeroTrienio);
	}
	
//
//	@Override
//	public String toString() {
//		return "Persona [nombre=" + super.getNombre() + ", apellido=" + super.getApellido() + ", EDAD=" + super.getEdad() + "]";
//	}

	@Override
	public boolean puedeJubilarse() {
		boolean t = false;
		int fecha = Calendar.getInstance().get(Calendar.YEAR)- super.getFechaInicio();
		if(super.getEdad() > 65 ^ fecha > 30 ) {
			t = true;
		}else {
			t = false;
		}

		return t;
	}

	@Override
	public int añosParaJubilarse() {

		int tiempoTrabajado = Calendar.getInstance().get(Calendar.YEAR)- super.getFechaInicio();
		int tiempoParaJubilarse = (int) (30 - tiempoTrabajado);
		int tiempoPorEdad = Calendar.getInstance().get(Calendar.YEAR) - super.getEdad();
		int res = 0;

		switch(super.getContrato()) {

			case TEMPORAL:
			tiempoParaJubilarse = (int) (tiempoParaJubilarse + (int)tiempoParaJubilarse*0.1);
			res = tiempoPorEdad | tiempoParaJubilarse;
			break;
			
			default:
			res = tiempoPorEdad | tiempoParaJubilarse;
			break;

		}
		
		return res;
	}

	@Override
	public String imprimeHistorial() {

		return "Fecha inicio: " + super.getFechaInicio() + 
				". \nTipo contrato: " + super.getContrato() +
				". \nOrganismo público: " + this.organismoPublico +
				". \nNúmero de trienios: " + this.numeroTrienio + ".";
	}
	

	@Override
	public Boolean puedeTrabajar(List<Boolean> condiciones) {
		
		return getOrganismoPublico()!=null && super.puedeTrabajar(condiciones);
		
	}

	@Override
	public void close() throws Exception {
		
		System.out.println("Cerrando expediente...");
		
	}
	
	public void procesaExpediente() {
		try {
			close();
		} catch (Exception e) {
		}
	}
	
}
