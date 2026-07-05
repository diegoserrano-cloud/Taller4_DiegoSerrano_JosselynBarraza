package dominio;

import Visitor.Visitor;

public class Pokemon extends Carta {
	//Pokemon ->Daño;CantEnergias
	private int daño;
	private int CantEnergias;

	public Pokemon(String nombreCarta, int rareza, int daño, int CantEnergias ) {
		super(nombreCarta, rareza);
		this.CantEnergias = CantEnergias;
		this.daño = daño;
	}
	public int getDaño() {
		return daño;
	}
	public int getCantEnergias() {
		return CantEnergias;
	}
	@Override
	public String toString() {
		return "Pokemon: "+ super.getNombreCarta()+ "| rareza: "+ super.getRareza()+"| daño: "+daño+"| CantEnergias: " + CantEnergias;
	}
	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visitar(this);
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public void setCantEnergias(int cantEnergias) {
		this.CantEnergias = cantEnergias;
	}
	@Override
	public String aLinea() {
		return getNombreCarta() + ";" + getRareza() + ";Pokemon;" + daño + ";" + CantEnergias;
	}

}
