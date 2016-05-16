package concesionarioGui.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import concesionarioGui.Coche;
import concesionarioGui.Gestionar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaCoche extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public BajaCoche() {
		super();

		panelColor.setVisible(false);
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		buttonAtras.setVisible(false);
		buttonSiguiente.setVisible(false);
		comboBoxMarca.setVisible(false);
		comboBoxModelo.setVisible(false);

		okButton.setText("Eliminar");

		setTitle("Baja coche");
		
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Coche coche = Gestionar.getConcesionario().get(textFieldMatricula.getText());
					textFieldColor.setText(String.valueOf(coche.getColor().name()));
					textFieldMarca.setText(String.valueOf(coche.getModelo().getMarca().name()));
					textFieldModelo.setText(String.valueOf(coche.getModelo().name()));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					Coche coche = Gestionar.getConcesionario().get(textFieldMatricula.getText());
					Gestionar.getConcesionario().eliminar(textFieldMatricula.getText());
					Gestionar.setModificado(true);
					JOptionPane.showMessageDialog(contentPanel, "Coche eliminado con éxito.");
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
}
