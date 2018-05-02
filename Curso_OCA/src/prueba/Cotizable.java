package prueba;

import java.util.List;

public interface Cotizable {
	public String imprimeHistorial();

	public default Boolean puedeTrabajar(List<Boolean> condiciones) {
		for (Boolean bool : condiciones) {
			if (!bool) {
				return false;
			}
		}
		return true;
	}
}
