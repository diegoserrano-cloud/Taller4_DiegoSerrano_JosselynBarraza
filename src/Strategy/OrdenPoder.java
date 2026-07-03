package Strategy;

import Visitor.CalculadorPoder;
import dominio.Carta;


/*
 * Ordena de mayor a menor poder calculado.
*/
public class OrdenPoder implements StrategyOrdenar {
	
	
	private CalculadorPoder calculadora = new CalculadorPoder();
	@Override
	public boolean elSiguiente(Carta c1, Carta c2) {
		double poder1 = c1.accept(calculadora);
		double poder2 = c2.accept(calculadora);
		return poder1 < poder2;
	}

}
