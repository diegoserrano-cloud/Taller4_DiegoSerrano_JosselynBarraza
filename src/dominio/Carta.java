package dominio;

import Visitor.*;

public abstract class Carta {
//NombreCarta;Rareza;Tipo;...
	private String nombreCarta;
	private int rareza;
	public Carta(String nombreCarta, int rareza) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
	}
	public String getNombreCarta() {
		return nombreCarta;
	}
	public int getRareza() {
		return rareza;
	}
	
	public abstract double accept(Visitor visitor);
	
	@Override
	public String toString() {
		return "Carta: "+nombreCarta + "| rareza: " + rareza;
	}
	
}
