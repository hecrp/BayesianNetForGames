/**
 * Clase para implementar el JFrame de la interfaz gráfica de la aplicación
 */
package bayesianNetwork;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class InterfazGrafica extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;		// Ancho del frame
	public static final int HEIGHT = 600;		// Alto del frame
	
	public static final int ROWS = 1;		// Filas para el gridlayout
	public static final int COLUMNS = 1;	// Columnas para el gridlayout
	
	public static final String NOMBRE_FRAME = "Bayesian Game";	// Nombre del frame
	
	private AccionActual actualAction; 	// Panel para establecer la acción actual
	private Sensores panelSensores;		// Panel para los sensores
	
	public InterfazGrafica() {
		this.setTitle(NOMBRE_FRAME);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new GridLayout(ROWS, COLUMNS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		actualAction = new AccionActual();
		panelSensores = new Sensores();
		this.add(panelSensores);
		this.add(actualAction);
		this.setVisible(true);
		
	}

	public AccionActual getActualAction() {
		return actualAction;
	}

	public void setActualAction(AccionActual actualAction) {
		this.actualAction = actualAction;
	}
}
