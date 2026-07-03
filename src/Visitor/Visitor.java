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
	double visitar(Pokemon p);
	double visitar(Item i);
	double visitar(Supporter s);
	double visitar(Energy e);
}
