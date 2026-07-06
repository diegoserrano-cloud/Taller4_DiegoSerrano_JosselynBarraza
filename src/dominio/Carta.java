package dominio;

import Visitor.*;

public abstract class Carta {
//NombreCarta;Rareza;Tipo;...
	private String nombreCarta;
	private int rareza;
	private String rutaImagen;
	public Carta(String nombreCarta, int rareza) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.rutaImagen = "imagenes/" + nombreCarta + ".png";
		
	}
	public String getNombreCarta() {
		return nombreCarta;
	}
	public int getRareza() {
		return rareza;
	}
	public String getRutaImagen() {
	    return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
	    this.rutaImagen = rutaImagen;
	}
	public abstract double accept(Visitor visitor);
	
	public abstract String aLinea();
	
	@Override
	public abstract String toString();
	public abstract String tipo();
	
}
