package dominio;

import Factory.Carta;
import Visitor.Visitor;

public class Item extends Carta {
	//Artículo ->Bonificacion
	private int bonificacion;
	public Item(String nombreCarta, int rareza, int bonificacion) {
		super(nombreCarta, rareza);
		this.bonificacion = bonificacion;
	}
	public int getBonificacion() {
		return bonificacion;
	}
	@Override
	public String toString() {
		return "Item: "+ super.getNombreCarta() + "| rareza: " + super.getRareza()+"| bonificacion" + bonificacion;
	}
	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return 0;
	}
}
