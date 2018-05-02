package prueba;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaPersona {

	private static List<EmpleadoPublico> list = new ArrayList<>();

	public static void main(String[] args) {
		// List<EmpleadoPublico> list = new ArrayList<EmpleadoPublico>();

		try {
			list.add(new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, false));
			list.add(new EmpleadoPublico("Jose", "Ramos", 65, "12345678Z", 1995, TipoContrato.INDEFINIDO,
					"Xunta de Galicia", 3, false));
			list.add(new EmpleadoPublico("Antonio", "Gil", 67, "75905655C", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 4, true));
			// list.add(new EmpleadoPublico("Juanjo", "Rodriguez", 25, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 0));
			// list.add(new EmpleadoPublico("Claudia", "Rodriguez", 58, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 1));
			// list.add(new EmpleadoPublico("Abel", "Rodriguez", 41, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Xunta de Galicia", 0));
			// list.add(new EmpleadoPublico("Gabriel", "Rodriguez", 28, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Xunta de Galicia", 2));
			// list.add(new EmpleadoPublico("Carlos", "Rodriguez", 39, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Xunta de Galicia", 1));
			// list.add(new EmpleadoPublico("Enrique", "Rodriguez", 36, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 2));
			// list.add(new EmpleadoPublico("Fernando", "Rodriguez", 47, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 1));
			// list.add(new EmpleadoPublico("Alberto", "Rodriguez", 52, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 0));
			// list.add(new EmpleadoPublico("Maria", "Rodriguez", 43, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 1));
			// list.add(new EmpleadoPublico("Laura", "Rodriguez", 75, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 5));
			// list.add(new EmpleadoPublico("Cristina", "Rodriguez", 45, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 1));
			// list.add(new EmpleadoPublico("Judi", "Rodriguez", 35, "53283151V", 1995,
			// TipoContrato.INDEFINIDO, "Junta de Andalucía", 2));
		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}

		/** -------------------- Prueba mostrar personas -------------------- **/
		// pruebaMostrarPersonas(list);

		/** -------------------- Prueba ordenar personas -------------------- **/
		// pruebaOrdenarPersonas(list);

		/** -------------------- Prueba import static -------------------- **/
		// pruebaImportStatic();

		/** -------------------- Prueba singleton -------------------- **/
		// pruebaSingleton();

		/** ----------- Prueba compareTo EmpleadoPublico como Persona ---------- **/
		// EmpleadoPublico emp1 = new EmpleadoPublico("Pablo", "Rodriguez", 25,
		// "53283151V", 1995,
		// TipoContrato.INDEFINIDO, "organismo1", 1);
		// EmpleadoPublico emp2 = new EmpleadoPublico("Jose", "Rodriguez", 25,
		// "53283151V", 1995,
		// TipoContrato.INDEFINIDO, "organismo1", 1);
		// System.out.println("Al comparar: " + emp1.compareTo(emp2) + ". No se puede,
		// solo se podría si "
		// + "el compareTo de Persona fuera estático.");

		/** --------------- Prueba método imprimir (interfaz) ------------------- **/
		// System.out.println(list.get(0).imprimeHistorial());

		/** -------------- Prueba referencias a clases e interfaces ------------- **/
		// pruebaClasesEInterfaces();

		/** -------------------- Prueba excepción DNI -------------------- **/
		// pruebaExcepcionDNI();

		/** -------------------- Prueba excepción DNI duplicado -------------------- **/
		// pruebaExcepcionDNIDuplicado();

		/** -------------------- Prueba try-with-resources -------------------- **/
		// try(EmpleadoPublico emp = new EmpleadoPublico("Pablo", "Rodriguez", 25,
		// "53283151V", 1995,
		// TipoContrato.INDEFINIDO, "Junta de Andalucía", 2)) {
		// System.out.println("Dentro del try con el menda " + emp);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		/** ---------------- Prueba filtrado con predicado lambda -------------- **/
		// GestorPersona.getInstance().añadeEmpleados(list);
		// GestorPersona.getInstance().imprime(p -> p.getEdad() > 30);
		// GestorPersona.getInstance().imprime(p -> {
		// return p.getNombre().endsWith("o");
		// });

		/** -------------------- Prueba filtrado y consumer -------------------- **/
		// GestorPersona.getInstance().añadeEmpleados(list);
		// GestorPersona.getInstance().procesaPersona(p -> p.getEdad() > 65,
		// p -> System.out.println(p + ": " + p.puedeJubilarse()));
		// GestorPersona.getInstance().procesaPersona(p -> p.getEdad() <= 65,
		// p -> System.err.println(p + ": " + p.puedeJubilarse()));

		/** ------------ Prueba filtrado y consumer (con stream) --------------- **/
		// GestorPersona.getInstance().añadeEmpleados(list);
		// GestorPersona.getInstance().procesaPersona(p -> p.getEdad() > 65,
		// p -> System.out.println(p + ": " + p.puedeJubilarse()));
		// GestorPersona.getInstance().procesaPersona(p -> p.getEdad() <= 65,
		// p -> {
		// p.setNombre(p.getNombre()+" JUBILADO");
		// System.err.println(p + ": " + p.puedeJubilarse());});

		/** ------------ Prueba media con stream y filtro --------------- **/
		// pruebaEdadMediaStream();

		/** ------------ Prueba supplier --------------- **/
		// pruebaSupplier();

		/** ------------ Prueba collect stream --------------- **/
		// pruebaCollectStream();

		/** ------------ Prueba groupBy --------------- **/
		// pruebaGroupBy();

		/** ------------ Prueba collector join --------------- **/
		// pruebaCollectorJoin();

		/** ------------ Prueba jubila más mayor --------------- **/
		// pruebaJubilaMasMayor();

		/** ------------ Prueba parallelStream --------------- **/
		pruebaParallelStream();
	}

	public static TreeSet<Persona> ordenaPersonas(Persona[] personas) {
		TreeSet<Persona> res = new TreeSet<Persona>();

		for (Persona p : personas) {
			res.add(p);
		}

		return res;
	}

	public static List<Persona> convertToList(Persona[] personas) {

		return asList(personas);
	}

	public static void pruebaMostrarPersonas(List<EmpleadoPublico> empleados) {
		for (Persona p : empleados) {
			System.out.println(p);
		}
		Collections.sort(empleados);
		System.out.println("-----------------------------------------------");
		for (Persona p : empleados) {
			System.out.println(p);
		}

	}

	public static void pruebaOrdenarPersonas(List<EmpleadoPublico> empleados) {
		Persona[] personas = new Persona[empleados.size()];
		TreeSet<Persona> ordenadas = ordenaPersonas(empleados.toArray(personas));
		ordenadas.stream().forEach(persona -> System.out.println(persona));
	}

	public static void pruebaImportStatic() {
		// Persona[] personas = list.toArray(list);
		// List<Persona> lista = convertToList(personas);
		// lista.stream()
		// .forEach(persona -> System.out.println(persona));
	}

	public static void pruebaSingleton() {
		GestorPersona gestorPersona = GestorPersona.getInstance();
		gestorPersona.añadeEmpleados(list);
		System.out.println(gestorPersona.edadMedia());
	}

	public static void pruebaClasesEInterfaces() {
		Cotizable c;
		try {
			c = new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, true);
			@SuppressWarnings("resource")
			Persona p = new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, false);
			@SuppressWarnings("resource")
			EmpleadoPublico ep = new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995,
					TipoContrato.INDEFINIDO, "Junta de Andalucía", 2, true);
			System.out.println("Imprime historial (Cotizable): \n" + c.imprimeHistorial());
			System.out.println("----------------");
			System.out.println("Años para jubilarse (Persona): " + p.añosParaJubilarse());
			System.out.println("----------------");
			System.out.println("Organismo público (EmpleadoPublico): " + ep.getOrganismoPublico());

		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}
	}

	public static void pruebaExcepcionDNI() {
		EmpleadoPublico emp;
		try {
			emp = new EmpleadoPublico("Pablo", "Rodriguez", 25, "23756473A", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, true);
			emp.setDNI("75905655");
			System.out.println(emp.toString());
		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}
	}

	public static void pruebaExcepcionDNIDuplicado() {
		List<EmpleadoPublico> plantilla = new ArrayList<>();
		try {
			plantilla.add(new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, true));
			plantilla.add(new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, false));
			GestorPersona.getInstance().añadeEmpleados(plantilla);
		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}

	}

	public static void pruebaEdadMediaStream() {
		GestorPersona.getInstance().añadeEmpleados(list);
		Double media = GestorPersona.getInstance().edadMedia();
		System.out.println("La edad media es: " + media);
		GestorPersona.getInstance().getPersonas(p -> p.getEdad() <= media).forEach(p -> System.out.println(
				"Las personas con edad menor o igual a la media son: " + p + " con " + p.getEdad() + " años."));
		GestorPersona.getInstance().getPersonas(p -> p.getEdad() > media).forEach(p -> System.out
				.println("Las personas con edad mayor a la media son: " + p + " con " + p.getEdad() + " años."));
	}

	public static void pruebaSupplier() {
		GestorPersona.getInstance().añadeEmpleados(list);
		List<Persona> puedenJubilarse = GestorPersona.getInstance().getPersonas(p -> p.puedeJubilarse());
		Supplier<Stream<Persona>> streamSupplier = () -> puedenJubilarse.stream();
		streamSupplier.get().forEach(p -> System.out.println("La edad de " + p + " en otra llamada a stream es: "));
		streamSupplier.get().map(p -> {
			System.out.println(p.getEdad());
			return p.getEdad();
		}).collect(Collectors.toList());

	}

	public static void pruebaCollectStream() {
		List<Persona> personas = new ArrayList<>();

		try {
			personas.add(new EmpleadoPublico("Pablo", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, false));
			personas.add(new EmpleadoPublico("Maite", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
					"Junta de Andalucía", 2, false));
		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}

		personas.stream().collect(Collectors.toCollection(() -> new TreeSet<Persona>())).forEach(System.out::println);
	}

	public static void pruebaGroupBy() {
		GestorPersona.getInstance().añadeEmpleados(list);
		Map<Character, List<Persona>> map = GestorPersona.getInstance().plantillaPorApellido();
		map.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
	}

	public static void pruebaCollectorJoin() {
		GestorPersona.getInstance().añadeEmpleados(list);
		Map<Character, String> map = GestorPersona.getInstance().dniPlantillaPorApellido();
		map.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
	}

	public static void pruebaJubilaMasMayor() {
		GestorPersona.getInstance().añadeEmpleados(list);
		Persona masMayor = GestorPersona.getInstance().getPersonas(p -> true).stream()
				.filter(p -> p.getEstaJubilado() == false).reduce((p1, p2) -> p1.getEdad() > p2.getEdad() ? p1 : p2)
				.get();
		System.out.println("¿Estaba antes jubilado?: " + masMayor.getEstaJubilado());
		GestorPersona.getInstance().jubilaMasMayor();
		System.out.println("¿Y ahora?: " + masMayor.getEstaJubilado());
	}

	public static void pruebaParallelStream() {
		try {
			for (int i = 0; i < 1000000; i++) {
				if (i % 2 == 0)
					list.add(new EmpleadoPublico("Maite", "Rodriguez", 25, "53283151V", 1995, TipoContrato.INDEFINIDO,
							"Junta de Andalucía", 2, false));
				else
					list.add(new EmpleadoPublico("Pablo", "Rodriguez", 45, "53283151V", 1995, TipoContrato.INDEFINIDO,
							"Junta de Andalucía", 2, false));
			}
			
			long time = System.currentTimeMillis();

			list.stream()
					.filter(p -> p.getEdad() > 40).collect(Collectors.toList());

			System.out.println("Tiempo pasado sin parallel: " + (System.currentTimeMillis() - time) + "ms");
			
			time = System.currentTimeMillis();
			list.parallelStream()
					.filter(p -> p.getEdad() > 40).collect(Collectors.toList());

			System.out.println("Tiempo pasado con parallel: " + (System.currentTimeMillis() - time) + "ms");

		} catch (DNINoValidoException e) {
			e.printStackTrace();
		}
	}

}
