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

import javax.swing.*;

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
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JComboBox<String> tipoCombo = new JComboBox<>(new String[] {"Pokemon", "Item", "Supporter", "Energy"});
		JTextField nombreField = new JTextField(10);
		JTextField rarezaField = new JTextField(10);

		JTextField campo1 = new JTextField(10); // Daño / Bonificacion / Efectos / Elemento
		JTextField campo2 = new JTextField(10); // CantEnergias (solo Pokemon)

		JLabel label1 = new JLabel("Daño:");
		JLabel label2 = new JLabel("CantEnergias:");

		panel.add(new JLabel("Tipo de carta:"));
		panel.add(tipoCombo);
		panel.add(new JLabel("Nombre:"));
		panel.add(nombreField);
		panel.add(new JLabel("Rareza:"));
		panel.add(rarezaField);
		panel.add(label1);
		panel.add(campo1);
		panel.add(label2);
		panel.add(campo2);

		// Cambia las etiquetas y muestra/oculta campo2 según el tipo elegido
		tipoCombo.addActionListener(e -> {
			String tipo = (String) tipoCombo.getSelectedItem();
			switch (tipo) {
				case "Pokemon":
					label1.setText("Daño:");
					label2.setText("CantEnergias:");
					campo2.setVisible(true);
					label2.setVisible(true);
					break;
				case "Item":
					label1.setText("Bonificación:");
					label2.setVisible(false);
					campo2.setVisible(false);
					break;
				case "Supporter":
					label1.setText("EfectosPorTurno:");
					label2.setVisible(false);
					campo2.setVisible(false);
					break;
				case "Energy":
					label1.setText("Elemento:");
					label2.setVisible(false);
					campo2.setVisible(false);
					break;
			}
		});

		int resultado = JOptionPane.showConfirmDialog(null, panel, "Agregar Carta",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (resultado == JOptionPane.OK_OPTION) {
			try {
				String tipo = (String) tipoCombo.getSelectedItem();
				String nombre = nombreField.getText();
				String rareza = rarezaField.getText();

				String[] partes;
				if (tipo.equals("Pokemon")) {
					partes = new String[] {nombre, rareza, tipo, campo1.getText(), campo2.getText()};
				} else {
					partes = new String[] {nombre, rareza, tipo, campo1.getText()};
				}

				sis.crearCarta(partes);
				JOptionPane.showMessageDialog(null, "Carta agregada correctamente.");

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Error: ingresa números válidos en Rareza/Daño/etc.",
						"Error de datos", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
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
