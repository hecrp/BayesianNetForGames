/**
 * Panel para declarar la acción que se está realizando en este preciso instante
 */
package bayesianNetwork;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccionActual extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final String TEXTO_LABEL = "Seleccione la accion actual";	// Texto que aparecerá en el label
	/*
	public static final int ROWS = 2;		// Filas para el gridlayout
	public static final int COLUMNS = 1;	// Columnas para el gridlayout
	*/
	
	private JComboBox comboAccionActual; // ComboBox para las acciones actuales
	
	public AccionActual() {
		this.setLayout(new FlowLayout());
		
		Vector<String> auxVector = new Vector<String>();
		RellenaAcciones(auxVector);
		setComboAccionActual(new JComboBox(auxVector));
		
		JLabel etiqueta = new JLabel(TEXTO_LABEL);
		
		this.add(etiqueta);
		this.add(getComboAccionActual());
	}
	
	private void RellenaAcciones(Vector<String> a) {
		a.add("Atacar");
		a.add("BuscarArmas");
		a.add("BuscarEnergia");
		a.add("Explorar");
		a.add("Huir");
		a.add("DetectarPeligro");		
	}

	public JComboBox getComboAccionActual() {
		return comboAccionActual;
	}

	public void setComboAccionActual(JComboBox comboAccionActual) {
		this.comboAccionActual = comboAccionActual;
	}
}
