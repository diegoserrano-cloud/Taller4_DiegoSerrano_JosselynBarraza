package Visitor;

import dominio.Energy;
import dominio.Item;
import dominio.Pokemon;
import dominio.Supporter;

public class CalculadorPoder implements Visitor{

	@Override
	public double visitar(Pokemon p) {
		double poder = ((double) p.getDaño() / p.getCantEnergias()) * 100;
		return poder;
	}

	@Override
	public double visitar(Item i) {
		double poder = i.getBonificacion() * 20;
		return poder;
	}

	@Override
	public double visitar(Supporter s) {
		double poder = s.getEfectos() * 50;
		return poder;
	}

	@Override
	public double visitar(Energy e) {
		double poder = 1;
		return poder;
	}

}
