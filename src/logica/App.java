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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	}

	private static Component crearGUI(JFrame ventana) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.BLUE);
		JPanel botonera = new JPanel();
		botonera.setLayout(new BoxLayout(botonera, BoxLayout.Y_AXIS));
		
		JPanel panelVacio = new JPanel(new BorderLayout());
		
		JButton cargar = crearBotton1(panelVacio);
		JButton agregar = crearBotton2( panelVacio);
		
		botonera.add(cargar);
		botonera.add(agregar);
		
		mainPanel.add(botonera, BorderLayout.WEST);
		mainPanel.add(panelVacio, BorderLayout.CENTER);
		
		return mainPanel;
	}
	private static JButton crearBotton1(JPanel panelVacio) {
		JButton b1 = new JButton("Menú Administración");
		b1.addActionListener(e ->{
			menu_Administración();
		});
		return b1;
	}

	private static JButton crearBotton2(JPanel panelVacio) {
		JButton b2 = new JButton("Menú Colección");
		b2.addActionListener(e -> {

			panelVacio.removeAll();
			panelVacio.setLayout(new BorderLayout());

	        JLabel l = new JLabel("<html>"
	                + "Ordenar Cartas por:<br>"
	                + "1. Ordenar por Rareza<br>"
	                + "2. Ordenar por Nombre<br>"
	                + "3. Ordenar por Poder<br>"
	                + "4. Salir"
	                + "</html>");

	        JPanel inputPanel = new JPanel();

	        JTextField input = new JTextField(10);
	        JButton ok = new JButton("Aceptar");

	        JLabel resultado = new JLabel(" ");

	        inputPanel.add(new JLabel("Ingresa opción: "));
	        inputPanel.add(input);
	        inputPanel.add(ok);
	        
	        ok.addActionListener(ev -> {
	            String opcion = input.getText();
	            String texto = menu_Coleccion(opcion);

	            if (opcion.equals("4")) {
	                panelVacio.removeAll();
	                panelVacio.revalidate();
	                panelVacio.repaint();
	                return;
	            }

	            resultado.setText("<html>" + texto + "</html>");
	        });

	        panelVacio.add(l);
	        panelVacio.add(inputPanel);
	        panelVacio.add(resultado);

	        panelVacio.revalidate();
	        panelVacio.repaint();
	        });
		return b2;
	}
	private static String menu_Coleccion(String op) {
		switch (op) {
		    case "1":
		        sis.setEstrategia("Rareza");
		        sis.ordenar();
		        return sis.mostrarColeccion();
		
		    case "2":
		        sis.setEstrategia("Nombre");
		        sis.ordenar();
		        return sis.mostrarColeccion();
		
		    case "3":
		        sis.setEstrategia("Poder");
		        sis.ordenar();
		        return sis.mostrarColeccion();
		
		    case "4":
		        return "Saliendo del menú...";
		
		    default:
		        return "Opción inválida";
		}
			
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
