package ficheros;

public class Puesto<T> {
	String ubicacion;
	T elemento;
	
	public Puesto(String ubicacion, T elemento) {
		super();
		this.ubicacion = ubicacion;
		this.elemento = elemento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
}
