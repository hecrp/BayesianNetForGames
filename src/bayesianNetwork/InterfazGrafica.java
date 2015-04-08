/**
 * Clase para implementar el JFrame de la interfaz gráfica de la aplicación
 */
package bayesianNetwork;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.netica.NeticaException;
import norsys.netica.Node;

public class InterfazGrafica extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;		// Ancho del frame
	public static final int HEIGHT = 600;		// Alto del frame
	
	public static final int ROWS = 2;		// Filas para el gridlayout
	public static final int COLUMNS = 1;	// Columnas para el gridlayout
	
	public static final String NOMBRE_FRAME = "Bayesian Game";	// Nombre del frame
	
	private AccionActual actualAction; 	// Panel para establecer la acción actual
	private Sensores panelSensores;		// Panel para los sensores
	
	Net net;
	Environ env;
	
	Node ST;
	Node ST1;
	
	Node H;
	Node HN;
	Node PW;
	Node PH;
	Node W;
	Node OW;
	Node NE;
	JPanel panelDatos;
	
	public InterfazGrafica() throws NeticaException {
		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(6,1));
		this.setTitle(NOMBRE_FRAME);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		actualAction = new AccionActual(this);
		panelSensores = new Sensores(this);
		this.add(panelSensores, BorderLayout.SOUTH);
		this.add(actualAction, BorderLayout.NORTH);
		construyeRed();
		muestraResultado();
	}
	
	@SuppressWarnings("deprecation")
	public void construyeRed() {
		try {
			Node.setConstructorClass("norsys.neticaEx.aliases.Node");
			env = new Environ(null);
			net = new Net();
			net.setName("BayesianGame");
			
			ST = new Node("ST", "ATACAR, BUSCAR_ARMAS,BUSCAR_ENERGIA, EXPLORAR, HUIR, DETECTAR_PELIGRO", net);
			ST1 = new Node("ST1", "ATACAR, BUSCAR_ARMAS,BUSCAR_ENERGIA, EXPLORAR, HUIR, DETECTAR_PELIGRO", net);
			
			H = new Node("H", "ALTO, BAJO", net);
			HN = new Node("HN", "SI, NO", net);
			PW = new Node("PW", "SI, NO", net);
			PH = new Node("PH", "SI, NO", net);
			W = new Node("W", "ARMADO, DESARMADO", net);
			OW = new Node("OW", "ARMADO, DESARMADO", net);
			NE = new Node("NE", "MUCHOS, POCOS", net);
			
			ST.setTitle("Accion Actual");
			ST1.setTitle("Accion Siguiente");
			OW.setTitle("Enemigo Armado");
			W.setTitle("Bot Armado");
			HN.setTitle("Escuchar Ruido");
			NE.setTitle("Enemigos Cerca");
			PW.setTitle("Arma Cerca");
			PH.setTitle("Energia Cerca");
			H.setTitle("Vida");
			
			ST1.addLink(ST);
			H.addLink(ST1);
			HN.addLink(ST1);
			PW.addLink(ST1);
			PH.addLink(ST1);
			W.addLink(ST1);
			OW.addLink(ST1);
			NE.addLink(ST1);
			
			// ST1
			float [] a = {(float)0.95, (float)0.01, (float)0.01, (float)0.01, (float)0.01, (float)0.01};
			ST1.setCPTable("ATACAR", a);
			float [] b = {(float)0.48, (float)0.48, (float)0.01, (float)0.01, (float)0.01, (float)0.01};
			ST1.setCPTable("BUSCAR_ARMAS", b);
			float [] c = {(float)0.48, (float)0.01, (float)0.48, (float)0.01, (float)0.01, (float)0.01};
			ST1.setCPTable("BUSCAR_ENERGIA", c);
			float [] d = {(float)0.48, (float)0.01, (float)0.01, (float)0.48, (float)0.01, (float)0.01};
			ST1.setCPTable("EXPLORAR", d);
			float [] e = {(float)0.48, (float)0.01, (float)0.01, (float)0.01, (float)0.48, (float)0.01};
			ST1.setCPTable("HUIR", e);
			float [] f = {(float)0.48, (float)0.01, (float)0.01, (float)0.01, (float)0.01, (float)0.48};
			ST1.setCPTable("DETECTAR_PELIGRO", f);
			
			// OW
			float [] g = {(float)0.1, (float)0.9};
			OW.setCPTable("ATACAR", g);
			float [] h = {(float)0.4, (float)0.6};
			OW.setCPTable("BUSCAR_ARMAS", h);
			float [] i = {(float)0.5, (float)0.5};
			OW.setCPTable("BUSCAR_ENERGIA",i);
			float [] j = {(float)0.2, (float)0.8};
			OW.setCPTable("EXPLORAR", j);
			float [] s5 = {(float)0.8, (float)0.2};
			OW.setCPTable("HUIR", s5);
			float [] s6 = {(float)0.3, (float)0.7};
			OW.setCPTable("DETECTAR_PELIGRO", s6);
			
			// W
			float [] a1 = {(float)0.9, (float)0.1};
			W.setCPTable("ATACAR", a1);
			float [] a2 = {(float)0.0, (float)1.0};
			W.setCPTable("BUSCAR_ARMAS", a2);
			float [] a3 = {(float)0.2, (float)0.8};
			W.setCPTable("BUSCAR_ENERGIA", a3);
			float [] a4 = {(float)0.85, (float)0.15};
			W.setCPTable("EXPLORAR", a4);
			float [] a5 = {(float)0.0, (float)1.0};
			W.setCPTable("HUIR", a5);
			float [] a6 = {(float)0.4, (float)0.6};
			W.setCPTable("DETECTAR_PELIGRO", a6);
			
			// HN
			float [] a7 = {(float)0.3, (float)0.7};
			HN.setCPTable("ATACAR", a7);
			float [] a8 = {(float)0.5, (float)0.5};
			HN.setCPTable("BUSCAR_ARMAS", a8);
			float [] a9 = {(float)0.4, (float)0.6};
			HN.setCPTable("BUSCAR_ENERGIA", a9);
			float [] b1 = {(float)0.2, (float)0.8};
			HN.setCPTable("EXPLORAR", b1);
			float [] b2 = {(float)0.65, (float)0.35};
			HN.setCPTable("HUIR", b2);
			float [] b3 = {(float)0.8, (float)0.2};
			HN.setCPTable("DETECTAR_PELIGRO", b3);
			
			// NE
			float [] s1 = {(float)0.1, (float)0.9};
			NE.setCPTable("ATACAR", s1);
			float [] t1 = {(float)0.8, (float)0.2};
			NE.setCPTable("BUSCAR_ARMAS", t1);
			float [] u1 = {(float)0.72, (float)0.28};
			NE.setCPTable("BUSCAR_ENERGIA", u1);
			float [] v1 = {(float)0.15, (float)0.85};
			NE.setCPTable("EXPLORAR", v1);
			float [] w1 = {(float)0.9, (float)0.1};
			NE.setCPTable("HUIR", w1);
			float [] x1 = {(float)0.95, (float)0.05};
			NE.setCPTable("DETECTAR_PELIGRO", x1);
			
			// PW
			float [] y1 = {(float)0.5, (float)0.5};
			PW.setCPTable("ATACAR", y1);
			float [] z1 = {(float)0.95, (float)0.05};
			PW.setCPTable("BUSCAR_ARMAS", z1);
			float [] k = {(float)0.5, (float)0.5};
			PW.setCPTable("BUSCAR_ENERGIA", k);
			float [] l = {(float)0.4, (float)0.6};
			PW.setCPTable("EXPLORAR", l);
			float [] m = {(float)0.4, (float)0.6};
			PW.setCPTable("HUIR", m);
			float [] n = {(float)0.0, (float)1.0};
			PW.setCPTable("DETECTAR_PELIGRO", n);
			
			// PH
			float [] o = {(float)0.5, (float)0.5};
			PH.setCPTable("ATACAR", o);
			float [] p = {(float)0.5, (float)0.5};
			PH.setCPTable("BUSCAR_ARMAS", p);
			float [] q = {(float)0.95, (float)0.05};
			PH.setCPTable("BUSCAR_ENERGIA", q);
			float [] r = {(float)0.4, (float)0.6};
			PH.setCPTable("EXPLORAR", r);
			float [] s = {(float)0.4, (float)0.6};
			PH.setCPTable("HUIR", s);
			float [] t = {(float)0.5, (float)0.5};
			PH.setCPTable("DETECTAR_PELIGRO", t);
			
			// H
			float [] u = {(float)0.9, (float)0.1};
			H.setCPTable("ATACAR", u);
			float [] v = {(float)0.6, (float)0.4};
			H.setCPTable("BUSCAR_ARMAS", v);
			float [] w = {(float)0.1, (float)0.9};
			H.setCPTable("BUSCAR_ENERGIA", w);
			float [] x = {(float)0.8, (float)0.2};
			H.setCPTable("EXPLORAR", x);
			float [] y = {(float)0.1, (float)0.9};
			H.setCPTable("HUIR", y);
			float [] z = {(float)0.15, (float)0.85};
			H.setCPTable("DETECTAR_PELIGRO", z);
			
			net.compile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void muestraResultado() throws NeticaException {
		
		ST.enterFinding((String)getActualAction().getComboAccionActual().getSelectedItem());
		
		H.enterFinding((String)getPanelSensores().getSensorH().getSelectedItem());
		PH.enterFinding((String)getPanelSensores().getSensorPH().getSelectedItem());
		PW.enterFinding((String)getPanelSensores().getSensorPW().getSelectedItem());
		NE.enterFinding((String)getPanelSensores().getSensorNE().getSelectedItem());
		HN.enterFinding((String)getPanelSensores().getSensorHN().getSelectedItem());
		W.enterFinding((String)getPanelSensores().getSensorW().getSelectedItem());
		OW.enterFinding((String)getPanelSensores().getSensorOW().getSelectedItem());
		
		double probAtacar = ST1.getBelief("ATACAR");
		double probArmas = ST1.getBelief("BUSCAR_ARMAS");
		double probEnergia = ST1.getBelief("BUSCAR_ENERGIA");
		double probExplorar = ST1.getBelief("EXPLORAR");
		double probHuir = ST1.getBelief("HUIR");
		double probPeligro = ST1.getBelief("DETECTAR_PELIGRO");
		
		panelDatos.removeAll();
		
		panelDatos.add(new JLabel("Atacar = " + probAtacar));
		panelDatos.add(new JLabel("Buscar Armas = " + probArmas));
		panelDatos.add(new JLabel("Buscar Energia = " + probEnergia));
		panelDatos.add(new JLabel("Explorar = " + probExplorar));
		panelDatos.add(new JLabel("Huir = " + probHuir));
		panelDatos.add(new JLabel("Detectar Peligro = " + probPeligro));
		
		this.add(panelDatos, BorderLayout.CENTER);
		this.validate();
		
		ST.retractFindings();
		H.retractFindings();
		PH.retractFindings();
		PW.retractFindings();
		NE.retractFindings();
		HN.retractFindings();
		W.retractFindings();
		OW.retractFindings();
	}

	public AccionActual getActualAction() {
		return actualAction;
	}

	public void setActualAction(AccionActual actualAction) {
		this.actualAction = actualAction;
	}
	
	public Sensores getPanelSensores() {
		return panelSensores;
	}
	
	public void setPanelSensores(Sensores sensePanel) {
		this.panelSensores = sensePanel;
	}
	
}
