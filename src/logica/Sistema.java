package logica;


import Strategy.StrategyOrdenar;

public interface Sistema {

	public void crearCarta(String[] partes);

	public void ordenar();

	public void setEstrategia(StrategyOrdenar estrategia);

	public String mostrarColeccion();

}
