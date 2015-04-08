/**
 * Panel para declarar la acción que se está realizando en este preciso instante
 */
package bayesianNetwork;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import norsys.netica.NeticaException;

public class AccionActual extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static final String TEXTO_LABEL = "Seleccione la accion actual";	// Texto que aparecerá en el label
	InterfazGrafica ig;
	private JComboBox comboAccionActual; // ComboBox para las acciones actuales
	
	public AccionActual(InterfazGrafica ig_) {
		ig = ig_;
		this.setLayout(new FlowLayout());
		
		ArrayList<String> auxVector = new ArrayList<String>();
		RellenaAcciones(auxVector);
		setComboAccionActual(new JComboBox(auxVector.toArray()));
		comboAccionActual.addItemListener(new Oyente());
		this.add(getComboAccionActual());
	}
	
	private void RellenaAcciones(ArrayList<String> a) {
		//a.add("Accion actual");
		//a.add("------------");
		a.add("ATACAR");
		a.add("BUSCAR_ARMAS");
		a.add("BUSCAR_ENERGIA");
		a.add("EXPLORAR");
		a.add("HUIR");
		a.add("DETECTAR_PELIGRO");		
	}

	public JComboBox getComboAccionActual() {
		return comboAccionActual;
	}

	public void setComboAccionActual(JComboBox comboAccionActual) {
		this.comboAccionActual = comboAccionActual;
	}
	
	public class Oyente implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
				try {
					ig.muestraResultado();
				} catch (NeticaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	};
}
