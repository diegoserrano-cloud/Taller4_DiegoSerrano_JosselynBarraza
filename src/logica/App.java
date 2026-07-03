/*
 * Nombres: Diego Serrano Fuentes, Josselyn Barraza Yáñez
 * Rut(s): 22.105.561-6 | 22.246.539-7
 * Carrera: ICCI
 * Taller: Taller N° 4 POO
 */

package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
	private static Sistema sis = SistemaImple.getInstancia();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("Hola soy la App");
		leer_Arch();
		menu_Administración();
		menu_Coleccion();
		
	
	}
	private static void menu_Coleccion() {
		String op = "";
		do {
		System.out.println("Ordenar Cartas por: \n"+"1. Ordenar por Rareza.\n"
				+ "2. Ordenar por Nombre."
				+ "3. Ordenar por Poder.\n"+"3.Salir");
		op = sc.next();
		switch(op) {
		case "1":
			System.out.println(sis.ordenarRareza());
		}
		
		}while(!op.equalsIgnoreCase("3"));
		
	}
	private static void menu_Administración() {
		agregar_Carta();
		
	}
	private static void agregar_Carta() {
		System.out.println("Que tipo de carta desea Agregar: \n"+
							"1. Pokemon\n"+"2. Item\n"+"3. Energy\n"+"4. Supporter");
		
	}
	private static void leer_Arch() throws IOException {
		File arch = new File("sobres.txt");
		Scanner lec= new Scanner(arch);
		while(lec.hasNextLine()) {
			String linea = lec.nextLine();
			String[] partes = linea.split(";");
			sis.crearCarta(partes);
			
		}lec.close();
	}

}
