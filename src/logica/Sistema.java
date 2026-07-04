package logica;


import Strategy.StrategyOrdenar;

public interface Sistema {

	void crearCarta(String[] partes);

	void ordenar();

	void setEstrategia(StrategyOrdenar estrategia);

	String mostrarColeccion();

}
