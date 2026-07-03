package Factory;

import dominio.Energy;
import dominio.Item;
import dominio.Pokemon;
import dominio.Supporter;

public class FactoryCarta {
	/*NombreCarta;Rareza;Tipo;...

Dependiendo del Tipo de carta existen diferentes atributos:

Tipo: Pokemon -> Daño;CantEnergias
Tipo: Item -> Bonificacion
Tipo: Supporter -> EfectosPorTurno
Tipo: Energy -> Elemento
	 * 
	 */
	public static Carta crearCarta(String[] partes) {
		String nombre = partes[0];
		int rareza = Integer.parseInt(partes[1]);
		String tipo = partes[2];
		
		if(tipo.equalsIgnoreCase("Pokemon")) {
			int daño = Integer.parseInt(partes[3]);
			int cantE = Integer.parseInt(partes[4]);
			return new Pokemon(nombre, rareza, daño, cantE);
			
		}else if(tipo.equalsIgnoreCase("Item")) {
			int bonificacion = Integer.parseInt(partes[3]);
			return new Item(nombre, rareza, bonificacion);
			
		}else if(tipo.equalsIgnoreCase("Supporter")) {
			int efectos = Integer.parseInt(partes[3]);
			return new Supporter(nombre, rareza, efectos);
			
		}else if(tipo.equalsIgnoreCase("Energy")) {
			String elemento = partes[3];
			return new Energy(nombre, rareza, elemento);
		}
		else {
			 throw new IllegalArgumentException("No se pudo crear la carta");
		}
	}
	
}
