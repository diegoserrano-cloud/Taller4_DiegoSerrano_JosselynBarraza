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
	private static JFrame ventana;

	public static void main(String[] args) throws Exception {
		ventana = new JFrame("Sistema");
		leer_Arch();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 600);
		ventana.setLocationRelativeTo(null);

		ventana.getContentPane().add(crearGUI(ventana));
		ventana.setVisible(true);

	}

	private static Component crearGUI(JFrame ventana) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(new Color(245, 245, 250));
		JPanel botonera = new JPanel();
		botonera.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
		botonera.setBackground(new Color(245, 245, 250));
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
		b1.setMaximumSize(new java.awt.Dimension(200, 40));
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);
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

	        panelVacio.add(l, BorderLayout.NORTH);
	        panelVacio.add(inputPanel, BorderLayout.CENTER);
	        panelVacio.add(resultado, BorderLayout.SOUTH);
	        
	        panelVacio.revalidate();
	        panelVacio.repaint();
	        });
		b2.setMaximumSize(new java.awt.Dimension(200, 40));
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		Object[] opciones = {"Agregar Carta", "Eliminar Carta", "Modificar Carta"};
		int seleccion = JOptionPane.showOptionDialog(ventana, "¿Qué acción deseas realizar?",
				"Administración", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, opciones, opciones[0]);

		switch (seleccion) {
			case 0: 
				agregar_Carta(); 
				break;
			case 1: 
				eliminar_Carta(); 
				break;
			case 2: 
				modificar_Carta();
				break;
		}
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

		int resultado = JOptionPane.showConfirmDialog(ventana, panel, "Agregar Carta",
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
	
	private static void eliminar_Carta() {
		String coleccion = sis.mostrarColeccion();

		if (coleccion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay cartas en la colección.");
			return;
		}

		String indiceStr = JOptionPane.showInputDialog(null,
				coleccion + "\nIngresa el índice de la carta a eliminar:",
				"Eliminar Carta", JOptionPane.PLAIN_MESSAGE);

		if (indiceStr == null) return; // canceló

		try {
			int indice = Integer.parseInt(indiceStr.trim());
			boolean ok = sis.eliminarCarta(indice);

			if (ok) {
				JOptionPane.showMessageDialog(null, "Carta eliminada correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Índice inválido.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static void modificar_Carta() {
		String coleccion = sis.mostrarColeccion();

		if (coleccion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay cartas en la colección.");
			return;
		}

		String indiceStr = JOptionPane.showInputDialog(ventana,
				coleccion + "\nIngresa el índice de la carta a modificar:",
				"Modificar Carta", JOptionPane.PLAIN_MESSAGE);

		if (indiceStr == null) return;

		int indice;
		try {
			indice = Integer.parseInt(indiceStr.trim());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String tipo = sis.tipoDeCarta(indice);
		if (tipo == null) {
			JOptionPane.showMessageDialog(null, "Índice inválido.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTextField campo1 = new JTextField(10);
		JTextField campo2 = new JTextField(10);

		switch (tipo) {
			case "Pokemon":
				panel.add(new JLabel("Nuevo Daño:"));
				panel.add(campo1);
				panel.add(new JLabel("Nueva CantEnergias:"));
				panel.add(campo2);
				break;
			case "Item":
				panel.add(new JLabel("Nueva Bonificación:"));
				panel.add(campo1);
				break;
			case "Supporter":
				panel.add(new JLabel("Nuevos EfectosPorTurno:"));
				panel.add(campo1);
				break;
			case "Energy":
				panel.add(new JLabel("Nuevo Elemento:"));
				panel.add(campo1);
				break;
		}

		int resultado = JOptionPane.showConfirmDialog(ventana, panel, "Modificar Carta (" + tipo + ")",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (resultado == JOptionPane.OK_OPTION) {
			try {
				String[] nuevosDatos;
				if (tipo.equals("Pokemon")) {
					nuevosDatos = new String[] {campo1.getText(), campo2.getText()};
				} else {
					nuevosDatos = new String[] {campo1.getText()};
				}

				boolean ok = sis.modificarCarta(indice, nuevosDatos);
				if (ok) {
					JOptionPane.showMessageDialog(null, "Carta modificada correctamente.");
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo modificar.", "Error", JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
