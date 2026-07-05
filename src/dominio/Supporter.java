package dominio;

import Visitor.Visitor;

public class Supporter extends Carta {
	//Supporter -> EfectosPorTurno
	private int efectos;
	public Supporter(String nombreCarta, int rareza, int efectos) {
		super(nombreCarta, rareza);
		this.efectos = efectos;
	}
	public int getEfectos() {
		return efectos;
	}
	@Override
	public String toString() {
		return "Supporter: "+ super.getNombreCarta() + "| rareza: " + super.getRareza()+"| efectos: " + efectos;
	}
	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visitar(this);
	}
	
	public void setEfectos(int efectos) {
		this.efectos = efectos;
	}
	@Override
	public String aLinea() {
		return getNombreCarta() + ";" + getRareza() + ";Supporter;" + efectos;
	}
}
