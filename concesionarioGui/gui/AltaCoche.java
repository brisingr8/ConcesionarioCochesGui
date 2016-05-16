package concesionarioGui.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

import concesionarioGui.Color;
import concesionarioGui.Gestionar;
import concesionarioGui.Marca;
import concesionarioGui.Modelo;

public class AltaCoche extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AltaCoche() {
		super();
		
		setTitle("Alta coche");

		buttonAtras.setVisible(false);
		buttonSiguiente.setVisible(false);
		buttonBuscar.setVisible(false);
		textFieldColor.setVisible(false);
		textFieldMarca.setVisible(false);
		textFieldModelo.setVisible(false);
		lblColor.setVisible(false);
		
		okButton.setText("Aceptar");

		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		{

			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Gestionar.getConcesionario().annadir(textFieldMatricula.getText(), getColor(),
								(Modelo) comboBoxModelo.getSelectedItem());
						Gestionar.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "Coche añadido con éxito.");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPanel, "Error. " + e.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
		}
	}

	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
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

	public void reset() {
		textFieldMatricula.setText("");
	}
}
