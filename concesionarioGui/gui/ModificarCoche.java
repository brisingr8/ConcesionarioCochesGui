package concesionarioGui.gui;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import concesionarioGui.Coche;
import concesionarioGui.Color;
import concesionarioGui.Gestionar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCoche extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ModificarCoche() {
		super();
		
		buttonBuscar.setVisible(false);
		comboBoxMarca.setVisible(false);
		comboBoxModelo.setVisible(false);
		
		okButton.setText("Modificar");
		
		setTitle("Modificar coche");

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coche coche = Gestionar.getConcesionario().get(textFieldMatricula.getText());
					Gestionar.getConcesionario().modificar(coche, getColor());
					textFieldColor.setText(String.valueOf(coche.getColor().name()));
					textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(coche.getModelo().name()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e1.getMessage(), "Error",
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
