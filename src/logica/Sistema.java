package logica;

public interface Sistema {

	public void crearCarta(String[] partes);

	public void setEstrategia(String e);
	public void ordenar();

	public String mostrarColeccion();
	
	public boolean eliminarCarta(int indice);

	public boolean modificarCarta(int indice, String[] nuevosDatos);

	public void guardarArchivo();

	public String tipoDeCarta(int indice);
}
