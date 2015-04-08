/**
 * Clase para implementar el JFrame de la interfaz gráfica de la aplicación
 */
package bayesianNetwork;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InterfazGrafica extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;		// Ancho del frame
	public static final int HEIGHT = 600;		// Alto del frame
	
	public static final int ROWS = 2;		// Filas para el gridlayout
	public static final int COLUMNS = 1;	// Columnas para el gridlayout
	
	public static final String NOMBRE_FRAME = "Bayesian Game";	// Nombre del frame
	
	private AccionActual actualAction; 	// Panel para establecer la acción actual
	private Sensores panelSensores;		// Panel para los sensores
	
	public InterfazGrafica() {
		this.setTitle(NOMBRE_FRAME);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		actualAction = new AccionActual();
		panelSensores = new Sensores();
		this.add(panelSensores, BorderLayout.SOUTH);
		this.add(actualAction, BorderLayout.NORTH);
		construyeRed();
	}
	
	public void construyeRed() {
		try {
			NodeSetConstructorClass("norsys.neticaEx.aliases.Node");
			Environ env = new Environ(null);
			Net net = new Net();
			net.setName("Bayesian Game");
			
			Node ST = new Node("ST", "ATACAR, BUSCAR ARMAS, BUSCAR ENERGIA, EXPLORAR, HUIR, DETECTAR PELIGRO", net);
			Node ST1 = new Node("ST+1", "ATACAR, BUSCAR ARMAS, BUSCAR ENERGIA, EXPLORAR, HUIR, DETECTAR PELIGRO", net);
			
			Node H = new Node("H", "ALTO, BAJO", net);
			Node HN = new Node("HN", "SI, NO", net);
			Node PW = new Node("PW", "SI, NO", net);
			Node PH = new Node("PH", "SI, NO", net);
			Node W = new Node("W", "ARMADO, DESARMADO", net);
			Node OW = new Node("OW", "ARMADO, DESARMADO", net);
			Node NE = new Node("NE", "MUCHOS, POCOS", net);
			
			ST.setTitle("Accion Actual");
			ST1.setTitle("Accion Siguiente");
			OW.setTitle("Enemigo Armado");
			W.setTitle("Bot Armado");
			HN.setTitle("Escuchar Ruido");
			NE.setTitle("Enemigos Cerca");
			PW.setTitle("Arma Cerca");
			PH.setTitle("Energia Cerca");
			H.setTitle("Vida");
			
			ST.addLink(ST1);
			ST1.addLink(H);
			ST1.addLink(HN);
			ST1.addLink(PW);
			ST1.addLink(PH);
			ST1.addLink(W);
			ST1.addLink(OW);
			ST1.addLink(NE);
			
			// ST1
			ST1.setCPTable("ATACAR", 0.95, 0.1, 0.1, 0.1, 0.1, 0.1);
			ST1.setCPTable("BUSCAR ARMAS", 0.48, 0.48, 0.1, 0.1, 0.1, 0.1);
			ST1.setCPTable("BUSCAR ENERGIA", 0.48, 0.1, 0.48, 0.1, 0.1, 0.1);
			ST1.setCPTable("EXPLORAR", 0.48, 0.1, 0.1, 0.48, 0.1, 0.1);
			ST1.setCPTable("HUIR", 0.48, 0.1, 0.1, 0.1, 0.48, 0.1);
			ST1.setCPTable("DETECTAR PELIGRO", 0.48, 0.1, 0.1, 0.1, 0.1, 0.48);
			
			// OW
			OW.setCPTable("ATACAR", 0.1, 0.9);
			OW.setCPTable("BUSCAR ARMAS", 0.4, 0.6);
			OW.setCPTable("BUSCAR ENERGIA", 0.5, 0.5);
			OW.setCPTable("EXPLORAR", 0.2, 0.8);
			OW.setCPTable("HUIR", 0.8, 0.2);
			OW.setCPTable("DETECTAR PELIGRO", 0.3, 0.7);
			
			// W
			W.setCPTable("ATACAR", 0.9, 0.1);
			W.setCPTable("BUSCAR ARMAS", 0.0, 1.0);
			W.setCPTable("BUSCAR ENERGIA", 0.2, 0.8);
			W.setCPTable("EXPLORAR", 0.85, 0.15);
			W.setCPTable("HUIR", 0.0, 1.0);
			W.setCPTable("DETECTAR PELIGRO", 0.4, 0.6);
			
			// HN
			HN.setCPTable("ATACAR", 0.3, 0.7);
			.setCPTable("BUSCAR ARMAS", 0.5, 0.5);
			HN.setCPTable("BUSCAR ENERGIA", 0.4, 0.6);
			HN.setCPTable("EXPLORAR", 0.2, 0.8);
			HN.setCPTable("HUIR", 0.65, 0.35);
			HN.setCPTable("DETECTAR PELIGRO", 0.8, 0.2);
			
			// NE
			NE.setCPTable("ATACAR", 0.1, 0.9);
			NE.setCPTable("BUSCAR ARMAS", 0.8, 0.2);
			NE.setCPTable("BUSCAR ENERGIA", 0.72, 0.28);
			NE.setCPTable("EXPLORAR", 0.15, 0.85);
			NE.setCPTable("HUIR", 0.9, 0.1);
			NE.setCPTable("DETECTAR PELIGRO", 0.95, 0.05);
			
			// PW
			PW.setCPTable("ATACAR", 0.5, 0.5);
			PW.setCPTable("BUSCAR ARMAS", 0.95, 0.05);
			PW.setCPTable("BUSCAR ENERGIA", 0.5, 0.5);
			PW.setCPTable("EXPLORAR", 0.4, 0.6);
			PW.setCPTable("HUIR", 0.4, 0.6);
			PW.setCPTable("DETECTAR PELIGRO", 0.0, 1.0);
			
			// PH
			PH.setCPTable("ATACAR", 0.5, 0.5);
			PH.setCPTable("BUSCAR ARMAS", 0.5, 0.5);
			PH.setCPTable("BUSCAR ENERGIA", 0.95, 0.05);
			PH.setCPTable("EXPLORAR", 0.4, 0.6);
			PH.setCPTable("HUIR", 0.4, 0.6);
			PH.setCPTable("DETECTAR PELIGRO", 0.5, 0.5);
			
			// H
			H.setCPTable("ATACAR", 0.9, 0.1);
			H.setCPTable("BUSCAR ARMAS", 0.6, 0.4);
			H.setCPTable("BUSCAR ENERGIA", 0.1, 0.9);
			H.setCPTable("EXPLORAR", 0.8, 0.2);
			H.setCPTable("HUIR", 0.1, 0.9);
			H.setCPTable("DETECTAR PELIGRO", 0.15, 0.85);
			
			net.compile();
			
			ST.enterFinding(getActualAction().getComboAccionActual().getSelectedItem());
			H.enterFinding(getPanelSensores().getSensorH().getSelectedItem());
			PH.enterFinding(getPanelSensores().getSensorPH().getSelectedItem());
			PW.enterFinding(getPanelSensores().getSensorPW().getSelectedItem());
			NE.enterFinding(getPanelSensores().getSensorNE().getSelectedItem());
			HN.enterFinding(getPanelSensores().getSensorHN().getSelectedItem());
			W.enterFinding(getPanelSensores().getSensorW().getSelectedItem());
			OW.enterFinding(getPanelSensores().getSensorOW().getSelectedItem());
			
			double probAtacar = ST1.getBelief("ATACAR");
			double probArmas = ST1.getBelief("BUSCAR ARMAS");
			double probEnergia = ST1.getBelief("BUSCAR ENERGIA");
			double probExplorar = ST1.getBelief("EXPLORAR");
			double probHuir = ST1.getBelief("HUIR");
			double probPeligro = ST1.getBelief("DETECTAR PELIGRO");
			
			JPanel panelDatos = new JPanel();

			panelDatos.add(new JLabel("Atacar = " + probAtacar));
			panelDatos.add(new JLabel("Buscar Armas = " + probArmas)):
			panelDatos.add(new JLabel("Buscar Energia = " + probEnergia));
			panelDatos.add(new JLabel("Explorar = " + probExplorar));
			panelDatos.add(new JLabel("Huir = " + probHuir));
			panelDatos.add(new JLabel("Detectar Peligro = " + probPeligro));
			
			this.add(panelDatos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public AccionActual getActualAction() {
		return actualAction;
	}

	public void setActualAction(AccionActual actualAction) {
		this.actualAction = actualAction;
	}
	
	public void Sensores getPanelSensores() {
		return panelSensores;
	}
	
	public void setPanelSensores(Sensores sensePanel) {
		this.panelSensores = sensePanel;
	}
	
}
