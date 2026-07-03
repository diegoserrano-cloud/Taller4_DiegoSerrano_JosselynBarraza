package Strategy;

import dominio.Carta;

public class OrdenaRareza implements StrategyOrdenar{

	@Override
	public boolean elSiguiente(Carta c1, Carta c2) {
		
		return c1.getRareza() < c2.getRareza();
	}

	
}
