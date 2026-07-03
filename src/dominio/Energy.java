package dominio;

import Visitor.Visitor;

public class Energy extends Carta {
	//Energy -> Elemento
	private String elemento;
	public Energy(String nombreCarta, int rareza, String elemento) {
		super(nombreCarta, rareza);
		this.elemento = elemento;
	}
	public String getElemento() {
		return elemento;
	}
	@Override
	public String toString() {
		return "Energy: "+ super.getNombreCarta() + "| rareza: " + super.getRareza()+"| elemento: " + elemento;
	}
	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return 0;
	}
}
