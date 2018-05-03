package ficheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		leeFichero("timelog.huevofrito");
		//claseGenerica();
	}
	
	@SuppressWarnings("unused")
	private static void leeFichero(String route) {
		Path path = Paths.get(route);
		Boolean exists = Files.exists(path);
		System.out.println("¿Existe el fichero? " + exists);
		if(exists) {
			File file = path.toFile();
			String isRegularFile = Files.isRegularFile(path)? "fichero" : "directorio";
			System.out.println("¿Es fichero o directorio? " + isRegularFile);
			System.out.println("¿Se puede leer?: " + Files.isReadable(path));
			System.out.println("¿Se puede escribir?: " + Files.isWritable(path));
			System.out.println("¿Se puede ejecutar?: " + Files.isExecutable(path));
			try {
				System.out.println("Número de entradas: " + Files.readAllLines(path).size());
				List<LogEntry> entries = new ArrayList<LogEntry>();
				for(String entryText : Files.readAllLines(path)) {
					try {
						entries.add(new LogEntry(entryText));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				List<LogEntry> errors = entries.stream()
							.filter(entry -> entry.getResponse().toString().charAt(0) == '4'
										|| entry.getResponse().toString().charAt(0) == '5')
							.collect(Collectors.toList());
				System.out.println("Número de errores: " + errors.size());
				
				Map<LocalDate, Integer> map = new HashMap<LocalDate, Integer>();
				for (LogEntry entry : entries) {
					if(map.containsKey(entry.getDateTime().toLocalDate())) {
						map.put(entry.getDateTime().toLocalDate(), map.get(entry.getDateTime().toLocalDate())+1);
					}
					else {
						map.put(entry.getDateTime().toLocalDate(), 1);
					}
				}
				int max = 0;
				LocalDate mostVisited = LocalDate.now();
				for(Map.Entry<LocalDate, Integer> entry : map.entrySet()) {
					if(max == 0 || max < entry.getValue()) {
						max = entry.getValue();
						mostVisited = entry.getKey();
					}
				}
				
				System.out.println("Día con más visitas: " + mostVisited + " con " 
						+ map.get(mostVisited) + " visitas.");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void claseGenerica() {
		Puesto<Integer> puesto1 = new Puesto<>("ubicación1", 2);
		Puesto<Integer> puesto2 = new Puesto<>("ubicación2", 3);
		List<Puesto<Integer>> puestos = new ArrayList<>();
		puestos.add(puesto1);
		puestos.add(puesto2);
		Conserjeria<Integer> conserjeria = new Conserjeria<>(puestos);
		
		conserjeria.getPuestos().stream()
									.forEach(puesto -> System.out.println("Ubicación: " + puesto.getUbicacion()
															+ "; elemento: " + puesto.getElemento()));
		System.out.println("Encuentra ubicación de puesto1: " + conserjeria.findElement(puesto1.getElemento()));
	}
}
