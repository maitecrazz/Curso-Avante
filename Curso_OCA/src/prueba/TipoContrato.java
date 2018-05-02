package prueba;

public enum TipoContrato {

	INDEFINIDO("Indefinido", 2.), OBRA_Y_SERVICIO("Obra y servicio", 3.), TEMPORAL("Temporal", 1.5);

	private final String nombre;
	private final Double multiplicador;

	TipoContrato(String nombre, Double multiplicador) {
		this.nombre = nombre;
		this.multiplicador = multiplicador;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getMultiplicador() {
		return multiplicador;
	}
	
	public Integer getDiasPreaviso(Integer añosTrabajados) {
		return (int) Math.round(añosTrabajados*this.multiplicador)&0xFFFFFFFF;
	}

}
