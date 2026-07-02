package dominio;

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
}
