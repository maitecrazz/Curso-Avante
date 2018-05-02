package prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GestorPersona {
	
	//----------------- Singleton -----------------
	private static GestorPersona gestorPersona;
	
	private GestorPersona() {
		this.plantilla = new ArrayList<>();
	}
	
	public static GestorPersona getInstance() {
		
		if(gestorPersona == null) {
			gestorPersona = new GestorPersona();
		}
		
		return gestorPersona;
	}
	
	//----------------- Class -----------------
	private List<Persona> plantilla;
	
	public Double edadMedia() {
		
		Double res = null;
		
		if(plantilla != null && !plantilla.isEmpty()) {
			res =  plantilla.stream()
					.mapToInt(persona -> persona.getEdad())
					.average()
					.getAsDouble();
		}
		
		return res;
	}
	
	public List<Persona> getPersonas(Predicate<Persona> filtro) {
		
		List<Persona> res = null;
		
		if(plantilla != null && !plantilla.isEmpty()) {
			res =  plantilla.stream()
					.filter(p -> {
						return filtro.test(p);
					})
					.collect(Collectors.toList());
		}
		
		return res;
	}
	
	public void añadeEmpleados(List<EmpleadoPublico> personas) {
		personas.stream()
					.forEach(persona -> {
						try {
							this.añadeEmpleado(persona);
						} catch (DNIDuplicadoException e) {
							e.printStackTrace();
						}
					});
	}
	
	public void añadeEmpleado(Persona persona) throws DNIDuplicadoException {
		boolean b = true;
		for(Persona p : this.plantilla) {
			b = p.getDNI() == persona.getDNI()? false : true;
			if(!b)
				throw new DNIDuplicadoException("DNI duplidado en plantilla.");
		}
		this.plantilla.add(persona);
	}
	
	public void clearPlantilla() {
		
		this.plantilla.clear();
	}
	
	public void imprime(Predicate<Persona> filtro) {
		for(Persona p : this.plantilla) {
			if(filtro.test(p))
				System.out.println("Pasan el test: " 
						+ p + " " + "con " + p.getEdad() + " años.\n");
			else
				System.err.println("NO pasan el test: "
						+ p + " " + "con " + p.getEdad() + " años.\n");
		}
		System.out.println();
	}
	
	public void procesaPersona(Predicate<Persona> filtro, Consumer<Persona> accion) {
		for(Persona p : this.plantilla) {
			if(filtro.test(p)) {
				accion.accept(p);
			}
		}
	}
	
	public void procesaPersonaStream(Predicate<Persona> filtro, Consumer<Persona> accion) {
		this.plantilla.stream()
						.filter(filtro)
						.forEach(accion);
	}
	
	public Map<Character, List<Persona>> plantillaPorApellido(){
		
		return plantilla.stream()
							.collect(Collectors.groupingBy(p -> p.getApellido().charAt(0),
									() -> new TreeMap<>(), Collectors.toList()));
							
	}
	
	public Map<Character, String> dniPlantillaPorApellido(){
		
		return plantilla.stream()
							.collect(Collectors.groupingBy(p -> p.getApellido().charAt(0), 
									() -> new TreeMap<>(), dniPersonaCollector()));
	}

	public Collector<Persona, StringJoiner, String> dniPersonaCollector(){
		
		return Collector.of(
				() -> new StringJoiner(", "), 
				(j, p) -> j.add(p.getDNI().toUpperCase()), 
				(j1, j2) -> j1.merge(j2), 
				StringJoiner::toString);
	}
	
	public void jubilaMasMayor() {
		plantilla.stream()
					.filter(p -> p.getEstaJubilado() == false)
					.reduce((p1, p2) -> p1.getEdad() > p2.getEdad() ? p1 : p2)
					.ifPresent(p -> p.setEstaJubilado(true));
	}
	
}
