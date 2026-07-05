/*
 * Nombres: Diego Serrano Fuentes, Josselyn Barraza Yáñez
 * Rut(s): 22.105.561-6 | 22.246.539-7
 * Carrera: ICCI
 * Taller: Taller N° 4 POO
 */

package logica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Strategy.*;

public class App {
	private static Sistema sis = SistemaImple.getInstancia();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		leer_Arch();
		JFrame ventana = new JFrame("Sistema");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //2º
		ventana.setSize(600,500); //3º
		
		ventana.getContentPane().add(crearGUI(ventana));
		ventana.setVisible(true);
		
		menu_Administración();
		menu_Coleccion();

	}

	private static Component crearGUI(JFrame ventana) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.BLUE);
		JPanel botonera = new JPanel();
		botonera.setLayout(new BoxLayout(botonera, BoxLayout.Y_AXIS));
		
		JPanel panelVacio = new JPanel(new BorderLayout());
		
		JButton cargar = crearBotton1(panelVacio);
		JButton agregar = crearBotton2( panelVacio);
		JButton filtrar = crearBotton3(panelVacio);
		
		botonera.add(cargar);
		botonera.add(agregar);
		botonera.add(filtrar);
		
		mainPanel.add(botonera, BorderLayout.WEST);
		mainPanel.add(panelVacio, BorderLayout.CENTER);
		
		return mainPanel;
	}

	private static JButton crearBotton3(JPanel panelVacio) {
		JButton b3 = new JButton("boton 3");
		return b3;
	}

	private static JButton crearBotton2(JPanel panelVacio) {
		JButton b2 = new JButton("boton 2");
		return b2;
	}

	private static JButton crearBotton1(JPanel panelVacio) {
		JButton b1 = new JButton("boton 1");
		return b1;
	}

	private static void menu_Coleccion() {
		String op = "";
		do {
			System.out.println("Ordenar Cartas por: \n"
					+ "1. Ordenar por Rareza.\n"
					+ "2. Ordenar por Nombre.\n"
					+ "3. Ordenar por Poder.\n"
					+ "4. Salir");
			op = sc.next();
			switch(op) {
			case "1":
				sis.setEstrategia(new OrdenaRareza());
				sis.ordenar();
				System.out.println(sis.mostrarColeccion());
				break;
			case "2":
				sis.setEstrategia(new OrdenNombre());
				sis.ordenar();
				System.out.println(sis.mostrarColeccion());
				break;
			case "3":
				sis.setEstrategia(new OrdenPoder());
				sis.ordenar();
				System.out.println(sis.mostrarColeccion());
				break;
			}
		} while(!op.equalsIgnoreCase("4"));
	}
	private static void menu_Administración() {
		agregar_Carta();

	}

	private static void agregar_Carta() {
		System.out.println(
				"Que tipo de carta desea Agregar: \n" + "1. Pokemon\n" + "2. Item\n" + "3. Energy\n" + "4. Supporter");

	}

	private static void leer_Arch() throws IOException {
		File arch = new File("sobres.txt");
		Scanner lec = new Scanner(arch);
		while (lec.hasNextLine()) {
			String linea = lec.nextLine();
			String[] partes = linea.split(";");
			sis.crearCarta(partes);

		}
		lec.close();
	}

}
