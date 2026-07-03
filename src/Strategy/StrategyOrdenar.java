package Strategy;

import Factory.Carta;

/**
 * Interfaz Strategy para las distintas formas de ordenar la colección.
 * Define un único método que indica si la primera carta debe ir
 * después de la segunda según el criterio de ordenamiento.
 */

public interface StrategyOrdenar {
	/**
	 * Indica si c1 debe ubicarse después de c2 en el orden deseado.
	 * @param c1 primera carta a comparar
	 * @param c2 segunda carta a comparar
	 * @return true si c1 debe ir después de c2
	 */
	boolean vaDespues(Carta c1, Carta c2);
}
