package Visitor;

import dominio.Energy;
import dominio.Item;
import dominio.Pokemon;
import dominio.Supporter;

/*
 * Interfaz Visitor. 
 *  Permite añadir nuevas operaciones sobre las cartas sin modificar sus clases.
 */

public interface Visitor {
	public double visitar(Pokemon p);
	public double visitar(Item i);
	public double visitar(Supporter s);
	public double visitar(Energy e);
}
