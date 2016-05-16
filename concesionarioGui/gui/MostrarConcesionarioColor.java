package concesionarioGui.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import concesionarioGui.Coche;
import concesionarioGui.Color;
import concesionarioGui.Gestionar;

public class MostrarConcesionarioColor extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ArrayList<Coche> listaCoches = new ArrayList<Coche>();
	private int cuentaCocheColor;

	private void refrescarBotones(ArrayList<Coche> listaCoches, int index) {
		if (index == 0) {
			buttonAtras.setEnabled(false);
		} else {
			buttonAtras.setEnabled(true);
		}
		if (index == listaCoches.size() - 1) {
			buttonSiguiente.setEnabled(false);
		} else {
			buttonSiguiente.setEnabled(true);
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarConcesionarioColor() {
		super();
		setTitle("Mostrar concesionario color");
		
		okButton.setText("Buscar");
		buttonBuscar.setVisible(false);
		comboBoxMarca.setVisible(false);
		comboBoxModelo.setVisible(false);
		textFieldMatricula.setEditable(false);
		buttonAtras.setEnabled(false);
		buttonSiguiente.setEnabled(false);

		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coche coche = listaCoches.get(cuentaCocheColor);
					int index = listaCoches.indexOf(coche);

					coche = listaCoches.get(index + 1);
					textFieldMatricula.setText(coche.getMatricula());
					textFieldColor.setText(String.valueOf(coche.getColor().name()));
					textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(coche.getModelo().name()));

					index = listaCoches.indexOf(coche);
					cuentaCocheColor = index;

					refrescarBotones(listaCoches, index);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Coche coche = listaCoches.get(cuentaCocheColor);
					int index = listaCoches.indexOf(coche);

					coche = listaCoches.get(index - 1);
					textFieldMatricula.setText(coche.getMatricula());
					textFieldColor.setText(String.valueOf(coche.getColor().name()));
					textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(coche.getModelo().name()));

					index = listaCoches.indexOf(coche);
					cuentaCocheColor = index;

					refrescarBotones(listaCoches, index);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listaCoches = Gestionar.getConcesionario().getCochesColor(getColor());

					textFieldMatricula.setText(listaCoches.get(0).getMatricula());
					textFieldColor.setText(String.valueOf(listaCoches.get(0).getColor().name()));
					textFieldMarca.setText(String.valueOf(listaCoches.get(0).getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(listaCoches.get(0).getModelo().name()));

					cuentaCocheColor = 0;
					refrescarBotones(listaCoches, cuentaCocheColor);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPanel, "No hay coches de ese color", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void reset() {
		textFieldMatricula.setText("");
		textFieldColor.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
	}

	private Color getColor() {
		if (rdbtnPlata.isSelected())
			return Color.PLATA;
		else if (rdbtnRojo.isSelected())
			return Color.ROJO;
		else if (rdbtnAzul.isSelected())
			return Color.AZUL;
		else
			return null;
	}
}
