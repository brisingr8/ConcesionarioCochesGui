package concesionarioGui.gui;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionarioGui.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Base extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textFieldMatricula;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JLabel lblColor;
	protected JPanel panelColor;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JRadioButton rdbtnPlata;
	protected JRadioButton rdbtnRojo;
	protected JRadioButton rdbtnAzul;
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton okButton;
	protected JButton buttonAtras;
	protected JButton buttonSiguiente;
	protected JButton cancelButton;
	private JPanel panel_1;
	protected JButton buttonBuscar = new JButton("Buscar");
	protected JTextField textFieldColor;
	protected JTextField textFieldMarca;
	protected JTextField textFieldModelo;

	/**
	 * Create the dialog.
	 */
	public Base() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(26, 11, 65, 30);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(90, 16, 108, 20);
		textFieldMatricula.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 52, 49, 14);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(26, 105, 49, 20);
		
		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBounds(90, 47, 108, 22);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 80, 49, 14);
		
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(90, 76, 108, 22);
		
		panelColor = new JPanel();
		panelColor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelColor.setBounds(245, 11, 172, 117);
		panelColor.setLayout(null);
		
		rdbtnPlata = new JRadioButton("Plata");
		rdbtnPlata.setBounds(61, 25, 65, 23);
		panelColor.add(rdbtnPlata);
		buttonGroup.add(rdbtnPlata);
		
		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(61, 51, 65, 23);
		panelColor.add(rdbtnRojo);
		buttonGroup.add(rdbtnRojo);
		
		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(61, 77, 65, 23);
		panelColor.add(rdbtnAzul);
		buttonGroup.add(rdbtnAzul);
		
		getContentPane().setLayout(null);
		getContentPane().add(textFieldMatricula);
		getContentPane().add(lblMarca);
		getContentPane().add(lblColor);
		getContentPane().add(lblModelo);
		getContentPane().add(lblMatricula);
		getContentPane().add(panelColor);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 238, 444, 33);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		okButton = new JButton();
		okButton.setBounds(250, 5, 88, 23);
		panel_1.add(okButton);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(348, 5, 86, 23);
		panel_1.add(cancelButton);
		
		buttonBuscar.setBounds(26, 146, 91, 23);
		getContentPane().add(buttonBuscar);
		
		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(90, 47, 108, 20);
		getContentPane().add(textFieldColor);
						
		textFieldMarca = new JTextField();
		textFieldMarca.setEditable(false);
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(90, 77, 108, 20);
		getContentPane().add(textFieldMarca);
		
				textFieldModelo = new JTextField();
		textFieldModelo.setEditable(false);
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(90, 109, 108, 20);
		getContentPane().add(textFieldModelo);
		
		buttonAtras = new JButton("<");
		buttonAtras.setBounds(346, 215, 43, 23);
		getContentPane().add(buttonAtras);
		
		buttonSiguiente = new JButton(">");
		buttonSiguiente.setBounds(391, 215, 43, 23);
		getContentPane().add(buttonSiguiente);
		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}
