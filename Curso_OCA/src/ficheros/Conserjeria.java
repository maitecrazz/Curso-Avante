package ficheros;

import java.util.List;

public class Conserjeria<T> {
	private List<Puesto<T>> puestos;
	

	public Conserjeria(List<Puesto<T>> puestos) {
		super();
		this.puestos = puestos;
	}

	public List<Puesto<T>> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<Puesto<T>> puestos) {
		this.puestos = puestos;
	}
	
	public String findElement(T element) {
		String ubicacion = "";
		
		for(Puesto<T> p : puestos) {
			if(puestos.contains(p)) {
				ubicacion = p.getUbicacion();
				break;
			}
		}
		
		return ubicacion;
	}
}
