/**
 * Panel para introducir los sensores
 */
package bayesianNetwork;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public Sensores() {
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
		
		this.add(new JLabel(TEXTO_LABEL));
		this.add(conjuntoSensores);
	}
	
	private void rellenaSensores() {
		Vector<String> auxVector = new Vector<String>();
		JComboBox dummyComboBox;
		
		// Rellenando sensor H
		auxVector.add("Alto");
		auxVector.add("Bajo");
		dummyComboBox = new JComboBox(auxVector);
		setSensorH(dummyComboBox);
		
		// Rellenando sensores HN, PW y PH
		auxVector.clear();
		auxVector.add("Si");
		auxVector.add("No");
		dummyComboBox = new JComboBox(auxVector);
		setSensorHN(dummyComboBox);
		setSensorPW(dummyComboBox);
		setSensorPH(dummyComboBox);
		
		// Rellenando sensores W y OW
		auxVector.clear();
		auxVector.add("Armado");
		auxVector.add("Desarmado");
		dummyComboBox = new JComboBox(auxVector);
		setSensorW(dummyComboBox);
		setSensorOW(dummyComboBox);
		
		// Rellenando sensor NE
		auxVector.clear();
		auxVector.add("Muchos");
		auxVector.add("Pocos");
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
}
