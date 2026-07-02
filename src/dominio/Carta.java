package dominio;

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
	@Override
	public String toString() {
		return "Carta: "+nombreCarta + "| rareza: " + rareza;
	}
	
}
