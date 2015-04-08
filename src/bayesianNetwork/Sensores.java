/**
 * Panel para introducir los sensores
 */
package bayesianNetwork;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import norsys.netica.NeticaException;

public class Sensores extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final String TEXTO_LABEL = "Introduzca el valor de los sensores";
	// Conjunto de sensores
	private JComboBox sensorH;
	private JComboBox sensorHN;
	private JComboBox sensorPW;
	private JComboBox sensorPH;
	private JComboBox sensorW;
	private JComboBox sensorOW;
	private JComboBox sensorNE;
	InterfazGrafica ig;
	
	public Sensores(InterfazGrafica ig_) {
		ig = ig_;
		this.setLayout(new GridLayout(2,1));
		JPanel conjuntoSensores = new JPanel();
		conjuntoSensores.setLayout(new FlowLayout());
		rellenaSensores();
		
		conjuntoSensores.add(sensorH);
		conjuntoSensores.add(sensorHN);
		conjuntoSensores.add(sensorPW);
		conjuntoSensores.add(sensorPH);
		conjuntoSensores.add(sensorW);
		conjuntoSensores.add(sensorOW);
		conjuntoSensores.add(sensorNE);
		
		this.add(conjuntoSensores);
	}
	
	private void rellenaSensores() {
		Vector<String> auxVector = new Vector<String>();
		JComboBox dummyComboBox;
		
		// Rellenando sensor H
		//auxVector.add("H");
		//auxVector.add("---");
		auxVector.add("ALTO");
		auxVector.add("BAJO");
		dummyComboBox = new JComboBox(auxVector);
		setSensorH(dummyComboBox);
		
		// Rellenando sensor HN
		auxVector.clear();
		//auxVector.add("HN");
		//auxVector.add("---");
		auxVector.add("SI");
		auxVector.add("NO");
		dummyComboBox = new JComboBox(auxVector);
		setSensorHN(dummyComboBox);
		
		// Rellenando sensor PW
		auxVector.clear();
		//auxVector.add("PW");
		//auxVector.add("---");
		auxVector.add("SI");
		auxVector.add("NO");
		dummyComboBox = new JComboBox(auxVector);
		setSensorPW(dummyComboBox);

		// Rellenando sensor PH
		auxVector.clear();
		//auxVector.add("PH");
		//auxVector.add("---");
		auxVector.add("SI");
		auxVector.add("NO");
		dummyComboBox = new JComboBox(auxVector);
		setSensorPH(dummyComboBox);
		
		// Rellenando sensor W
		auxVector.clear();
		//auxVector.add("W");
		//auxVector.add("--------");
		auxVector.add("ARMADO");
		auxVector.add("DESARMADO");
		dummyComboBox = new JComboBox(auxVector);
		setSensorW(dummyComboBox);
		
		// Rellenando sensor OW
		auxVector.clear();
		//auxVector.add("OW");
		//auxVector.add("--------");
		auxVector.add("ARMADO");
		auxVector.add("DESARMADO");
		dummyComboBox = new JComboBox(auxVector);
		setSensorOW(dummyComboBox);
		
		// Rellenando sensor NE
		auxVector.clear();
		//auxVector.add("NE");
		//auxVector.add("------");
		auxVector.add("MUCHOS");
		auxVector.add("POCOS");
		dummyComboBox = new JComboBox(auxVector);
		setSensorNE(dummyComboBox);
	}

	public JComboBox getSensorH() {
		return sensorH;
	}

	public void setSensorH(JComboBox sensorH) {
		this.sensorH = sensorH;
	}

	public JComboBox getSensorHN() {
		return sensorHN;
	}

	public void setSensorHN(JComboBox sensorHN) {
		this.sensorHN = sensorHN;
	}

	public JComboBox getSensorPW() {
		return sensorPW;
	}

	public void setSensorPW(JComboBox sensorPW) {
		this.sensorPW = sensorPW;
	}

	public JComboBox getSensorPH() {
		return sensorPH;
	}

	public void setSensorPH(JComboBox sensorPH) {
		this.sensorPH = sensorPH;
	}

	public JComboBox getSensorW() {
		return sensorW;
	}

	public void setSensorW(JComboBox sensorW) {
		this.sensorW = sensorW;
	}

	public JComboBox getSensorOW() {
		return sensorOW;
	}

	public void setSensorOW(JComboBox sensorOW) {
		this.sensorOW = sensorOW;
	}

	public JComboBox getSensorNE() {
		return sensorNE;
	}

	public void setSensorNE(JComboBox sensorNE) {
		this.sensorNE = sensorNE;
	}
	
	public class Oyente implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			try {
				ig.muestraResultado();
			} catch (NeticaException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
