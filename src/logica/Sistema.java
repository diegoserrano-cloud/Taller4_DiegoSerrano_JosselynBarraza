package logica;

public interface Sistema {

	public void crearCarta(String[] partes);

	public void ordenar();

	public void setEstrategia(String e);

	public String mostrarColeccion();
	
	public boolean eliminarCarta(int indice);

	public boolean modificarCarta(int indice, String[] nuevosDatos);

	public void guardarArchivo();

}
