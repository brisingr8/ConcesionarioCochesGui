package concesionarioGui.gui;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import concesionarioGui.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarConcesionario extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	

	void refrescar(Coche coche) {
		textFieldMatricula.setText(coche.getMatricula());
		textFieldColor.setText(String.valueOf(coche.getColor().name()));
		textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
		textFieldModelo.setText(String.valueOf(coche.getModelo().name()));
		// buttonBuscar.setVisible(false);
		refrescarBotones(Gestionar.getConcesionario(), Gestionar.getConcesionario().index(coche));
	}

	private void refrescarBotones(Concesionario concesionario, int index) {
		if (index == 0) {
			buttonAtras.setEnabled(false);
		} else {
			buttonAtras.setEnabled(true);
		}
		if (index == concesionario.size() - 1) {
			buttonSiguiente.setEnabled(false);
		} else {
			buttonSiguiente.setEnabled(true);
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarConcesionario() {
		super();

		buttonBuscar.setVisible(false);
		panelColor.setVisible(false);
		comboBoxMarca.setVisible(false);
		comboBoxModelo.setVisible(false);
		textFieldMatricula.setEditable(false);
		okButton.setVisible(false);
		
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coche coche = Gestionar.getConcesionario().get(textFieldMatricula.getText());
					int index = Gestionar.getConcesionario().index(coche);

					coche = Gestionar.getConcesionario().posterior(index);
					textFieldMatricula.setText(coche.getMatricula());
					textFieldColor.setText(String.valueOf(coche.getColor().name()));
					textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(coche.getModelo().name()));

					index = Gestionar.getConcesionario().index(coche);

					refrescarBotones(Gestionar.getConcesionario(), index);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Coche coche = Gestionar.getConcesionario().get(textFieldMatricula.getText());
					int index = Gestionar.getConcesionario().index(coche);

					coche = Gestionar.getConcesionario().anterior(index);
					textFieldMatricula.setText(coche.getMatricula());
					textFieldColor.setText(String.valueOf(coche.getColor().name()));
					textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(coche.getModelo().name()));

					index = Gestionar.getConcesionario().index(coche);

					refrescarBotones(Gestionar.getConcesionario(), index);
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

	}
}
