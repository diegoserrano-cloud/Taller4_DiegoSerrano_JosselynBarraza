package logica;

import java.util.ArrayList;

import dominio.*;

public class SistemaImple implements Sistema {
	private static SistemaImple instancia;
	private ArrayList<Carta> cartas = new ArrayList<>();
	private SistemaImple() {}
	public static SistemaImple getInstancia() {
		if(instancia == null) instancia = new SistemaImple();
		return instancia;
	}
	@Override
	public void crearCarta(String[] partes) {
		Carta c = FactoryCarta.crearCarta(partes);
		cartas.add(c);
	}
	@Override
	public String ordenarRareza() {
		String out = "";
		cartas.sort(null);
		return out;
	}
}
