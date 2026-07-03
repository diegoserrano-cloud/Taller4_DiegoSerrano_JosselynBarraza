package Strategy;

import dominio.Carta;

/*
 * Ordena Alfabeticamente por nombre, es decir de la A hasta la Z.
 */

public class OrdenNombre implements StrategyOrdenar{

	@Override
	public boolean elSiguiente(Carta c1, Carta c2) {
		String nombre1 = c1.getNombreCarta();
		String nombre2 = c2.getNombreCarta();
		return nombre1.compareToIgnoreCase(nombre2) > 0;
	}

}
