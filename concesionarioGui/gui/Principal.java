package concesionarioGui.gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionarioGui.Concesionario;
import concesionarioGui.Fichero;
import concesionarioGui.Gestionar;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * CONCESIONARIO DE COCHES CON GUI
 * 
 * @author alvaro
 * @version 1.0
 */

public class Principal {

	private JFrame frame;

	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");

	/**
	 * 
	 * @param args
	 *            argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Concesionario IES Gran Capitán");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		fileChooser.setFileFilter(filtro);

		AltaCoche alta = new AltaCoche();
		BajaCoche baja = new BajaCoche();
		MostrarCoche mostrarCoche = new MostrarCoche();
		MostrarConcesionario mostrarConcesionario = new MostrarConcesionario();
		MostrarConcesionarioColor mostrarConcesionarioColor = new MostrarConcesionarioColor();
		ModificarCoche modificar = new ModificarCoche();
		Acerca acerca = new Acerca();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 444, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo concesionario");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarCambios();
				Gestionar.setConcesionario(new Concesionario());
				Gestionar.setFile(new File("Sin título"));
				Gestionar.setModificado(false);
				frame.setTitle(Gestionar.getFile().getPath());
			}
		});
		mntmNuevoConcesionario
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevoConcesionario);

		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir concesionario...");
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mnArchivo.add(mntmAbrirConcesionario);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnCoche = new JMenu("Coche");
		mnCoche.setMnemonic('C');
		menuBar.add(mnCoche);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta.reset();
				alta.setVisible(true);
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCoche.add(mntmAlta);

		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bajaCoche(baja);
			}

			private void bajaCoche(BajaCoche baja) {
				if (Gestionar.getConcesionario().size() == 0) {
					JOptionPane.showMessageDialog(mostrarConcesionario.getContentPane(), "Concesionario vacío ",
							"Concesionario vacío", JOptionPane.INFORMATION_MESSAGE);
				} else {
					baja.reset();
					// mostrarConcesionario.refrescarBotones();
					baja.setVisible(true);
				}
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnCoche.add(mntmBaja);

		JMenuItem menuModificar = new JMenuItem("Modificar");
		menuModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar.reset();
				modificar.setVisible(true);
			}
		});

		JSeparator separator_3 = new JSeparator();
		mnCoche.add(separator_3);
		mnCoche.add(menuModificar);

		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setMnemonic('M');
		menuBar.add(mnMostrar);

		JMenuItem menuItemMostrarCoche = new JMenuItem("Mostrar coche");
		menuItemMostrarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		menuItemMostrarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(mostrarCoche);
			}

			private void mostrarCoche(MostrarCoche mostrarCoche) {
				if (Gestionar.getConcesionario().size() == 0) {
					JOptionPane.showMessageDialog(mostrarConcesionario.getContentPane(), "Concesionario vacío ",
							"Concesionario vacío", JOptionPane.INFORMATION_MESSAGE);
				} else {
					mostrarCoche.reset();
					// mostrarConcesionario.refrescarBotones();
					mostrarCoche.setVisible(true);
				}
			}
		});
		mnMostrar.add(menuItemMostrarCoche);

		JMenuItem menuItemConcesionario = new JMenuItem("Mostrar concesionario");
		menuItemConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuItemConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionario(mostrarConcesionario);
			}

			private void mostrarConcesionario(MostrarConcesionario mostrarConcesionario) {
				if (Gestionar.getConcesionario().size() == 0) {
					JOptionPane.showMessageDialog(mostrarConcesionario.getContentPane(), "Concesionario vacío ",
							"Concesionario vacío", JOptionPane.INFORMATION_MESSAGE);
				} else {
					mostrarConcesionario.refrescar(Gestionar.getConcesionario().get(0));
					// mostrarConcesionario.refrescarBotones();
					mostrarConcesionario.setVisible(true);
				}
			}
		});
		mnMostrar.add(menuItemConcesionario);

		JMenuItem menuItemMostrarColor = new JMenuItem("Mostrar concesionario por color");
		menuItemMostrarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionarioColor.reset();
				mostrarConcesionarioColor(mostrarConcesionarioColor);
			}

			private void mostrarConcesionarioColor(MostrarConcesionarioColor mostrarConcesionarioColor) {
				if (Gestionar.getConcesionario().size() == 0) {
					JOptionPane.showMessageDialog(mostrarConcesionarioColor.getContentPane(), "Concesionario vacío ",
							"Concesionario vacío", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// mostrarConcesionario.refrescarBotones();
					mostrarConcesionarioColor.setVisible(true);
				}
			}
		});
		mnMostrar.add(menuItemMostrarColor);

		JSeparator separator_2 = new JSeparator();
		mnMostrar.add(separator_2);

		JMenuItem menuItemTamanoConcesionario = new JMenuItem("Mostrar tamaño concesionario");
		menuItemTamanoConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		menuItemTamanoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTamano();
			}

			/**
			 * METODO PARA MOSTRAR TAMAÑO DEL CONCESIONARIO
			 */
			private void mostrarTamano() {
				if (Gestionar.getConcesionario().size() == 0) {
					JOptionPane.showMessageDialog(mostrarConcesionario.getContentPane(), "Concesionario vacío ",
							"Concesionario vacío", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(mostrarConcesionario.getContentPane(),
							"Número de coches: " + Gestionar.getConcesionario().size(), "Tamaño concesionario",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnMostrar.add(menuItemTamanoConcesionario);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('Y');
		menuBar.add(mnAyuda);

		JMenuItem mntmJavadoc = new JMenuItem("Javadoc");
		mntmJavadoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String url =
				// "file:///C:/Users/alvaro/workspace/TRIMESTRE%203/src/concesionarioGui/doc/index.html";
				try {
					URL url = new URL(
							"file:///C:/Users/alvaro/workspace/TRIMESTRE%203/src/concesionarioGui/doc/index.html");
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error. No se puede acceder a Javadoc", "Error.",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnAyuda.add(mntmJavadoc);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acerca.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
	}

	/**
	 * METODO QUE COMPRUEBA LOS CAMBIOS
	 */
	private void comprobarCambios() {
		if (Gestionar.modificado()) {
			switch (JOptionPane.showOptionDialog(frame.getContentPane(), "Concesionario modificado. ¿Guardar cambios?",
					"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null)) {
			case JOptionPane.YES_OPTION:
				guardar();
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}
	}

	/**
	 * METODO ABRIR
	 */
	private void abrir() {
		comprobarCambios();
		int seleccion = fileChooser.showOpenDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				Gestionar.setConcesionario(Fichero.abrir(file));
				Gestionar.setFile(file);
				frame.setTitle(Gestionar.getFile().getPath());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Fichero no contiene concesionarios.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "No se puede abrir el fichero.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * METODO GUARDAR COMO
	 */
	private void guardarComo() {
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				if (Fichero.existe(file)) {
					switch (JOptionPane.showOptionDialog(frame.getContentPane(),
							"El fichero ya existe. ¿Desea sobreescribirlo?", "Confirmar", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null)) {
					case JOptionPane.NO_OPTION:
						return;
					case JOptionPane.YES_OPTION:
						rutina(file);
						return;
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "El sistema no puede guardar el fichero.",
						"Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * METODO GUARDAR
	 */
	private void guardar() {
		if (Gestionar.getFile().getName().equals("Sin título")) {
			guardarComo();
		} else {
			try {
				File file = fileChooser.getSelectedFile();
				rutina(file);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "El sistema no puede guardar el fichero.",
						"Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void rutina(File file) throws IOException {
		Fichero.guardar(file, Gestionar.getConcesionario());
		Gestionar.setModificado(false);
		Gestionar.setFile(file);
		frame.setTitle(Gestionar.getFile().getPath());
	}
}
