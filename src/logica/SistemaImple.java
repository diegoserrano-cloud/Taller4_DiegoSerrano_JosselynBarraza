package logica;

import java.util.ArrayList;


import Factory.FactoryCarta;
import Strategy.*;
import dominio.*;

public class SistemaImple implements Sistema {
	private static SistemaImple instancia;
	private ArrayList<Carta> cartas = new ArrayList<>();

	private SistemaImple() {
	}

	public static SistemaImple getInstancia() {
		if (instancia == null)
			instancia = new SistemaImple();
		return instancia;
	}

	@Override
	public void crearCarta(String[] partes) {
		Carta c = FactoryCarta.crearCarta(partes);
		cartas.add(c);
	}

	

	private StrategyOrdenar estrategia;

	/**
	 * Define la estrategia de ordenamiento se va a usar.
	 * 
	 * @param estrategia estrategia concreta a aplicar
	 */

	public void setEstrategia(String e) {
		if(e.equalsIgnoreCase("Rareza")) {
			this.estrategia = new OrdenaRareza();
		}else if (e.equalsIgnoreCase("Nombre")) {
			this.estrategia = new OrdenNombre();
		}else if (e.equalsIgnoreCase("Poder")) {
			this.estrategia = new OrdenPoder();
		}
	}
	/**
	 * Ordena la colección de cartas usando la estrategia actualmente asignada.
	 * (Ordenamiento Burbuja)
	 */

	public void ordenar() {
		int n = cartas.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				Carta actual = cartas.get(j);
				Carta siguiente = cartas.get(j + 1);
				if (estrategia.elSiguiente(actual, siguiente)) {
					cartas.set(j, siguiente);
					cartas.set(j + 1, actual);
				}
			}
		}
	}
	
	/**
	 * Devuelve una representación en texto de la colección actual de cartas.
	 * @return String con todas las cartas, una por línea
	 */
	public String mostrarColeccion() {
		String msg = "";
		for (Carta c : cartas) {
			msg += c.toString() + "\n";
		}
		return msg;
	}
}
