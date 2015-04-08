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
			float [] a = {(float)0.95, (float)0.1, (float)0.1, (float)0.1, (float)0.1, (float)0.1};
			ST1.setCPTable("ATACAR", a);
			float [] b = {(float)0.48, (float)0.48, (float)0.1, (float)0.1, (float)0.1, (float)0.1};
			ST1.setCPTable("BUSCAR ARMAS", b);
			float [] c = {(float)0.48, (float)0.1, (float)0.48, (float)0.1, (float)0.1, (float)0.1};
			ST1.setCPTable("BUSCAR ENERGIA", c);
			float [] d = {(float)0.48, (float)0.1, (float)0.1, (float)0.48, (float)0.1, (float)0.1};
			ST1.setCPTable("EXPLORAR", d);
			float [] e = {(float)0.48, (float)0.1, (float)0.1, (float)0.1, (float)0.48, (float)0.1};
			ST1.setCPTable("HUIR", e);
			float [] f = {(float)0.48, (float)0.1, (float)0.1, (float)0.1, (float)0.1, (float)0.48};
			ST1.setCPTable("DETECTAR PELIGRO", f);
			
			// OW
			float [] g = {(float)0.1, (float)0.9};
			OW.setCPTable("ATACAR", g);
			float [] h = {(float)0.4, (float)0.6};
			OW.setCPTable("BUSCAR ARMAS", h);
			float [] i = {(float)0.5, (float)0.5};
			OW.setCPTable("BUSCAR ENERGIA",i);
			float [] j = {(float)0.2, (float)0.8};
			OW.setCPTable("EXPLORAR", j);
			float [] s5 = {(float)0.8, (float)0.2};
			OW.setCPTable("HUIR", s5);
			float [] s6 = {(float)0.3, (float)0.7};
			OW.setCPTable("DETECTAR PELIGRO", s6);
			
			// W
			float [] a1 = {(float)0.9, (float)0.1};
			W.setCPTable("ATACAR", a1);
			float [] a2 = {(float)0.0, (float)1.0};
			W.setCPTable("BUSCAR ARMAS", a2);
			float [] a3 = {(float)0.2, (float)0.8};
			W.setCPTable("BUSCAR ENERGIA", a3);
			float [] a4 = {(float)0.85, (float)0.15};
			W.setCPTable("EXPLORAR", a4);
			float [] a5 = {(float)0.0, (float)1.0};
			W.setCPTable("HUIR", a5);
			float [] a6 = {(float)0.4, (float)0.6};
			W.setCPTable("DETECTAR PELIGRO", a6);
			
			// HN
			float [] a7 = {(float)0.3, (float)0.7};
			HN.setCPTable("ATACAR", a7);
			float [] a8 = {(float)0.5, (float)0.6};
			HN.setCPTable("BUSCAR ARMAS", a8);
			float [] a9 = {(float)0.4, (float)0.6};
			HN.setCPTable("BUSCAR ENERGIA", a9);
			float [] b1 = {(float)0.2, (float)0.8};
			HN.setCPTable("EXPLORAR", b1);
			float [] b2 = {(float)0.65, (float)0.35};
			HN.setCPTable("HUIR", b2);
			float [] b3 = {(float)0.8, (float)0.2};
			HN.setCPTable("DETECTAR PELIGRO", b3);
			
			// NE
			float [] s1 = {(float)0.1, (float)0.9};
			NE.setCPTable("ATACAR", s1);
			float [] t1 = {(float)0.8, (float)0.2};
			NE.setCPTable("BUSCAR ARMAS", t1);
			float [] u1 = {(float)0.72, (float)0.28};
			NE.setCPTable("BUSCAR ENERGIA", u1);
			float [] v1 = {(float)0.15, (float)0.85};
			NE.setCPTable("EXPLORAR", v1);
			float [] w1 = {(float)0.9, (float)0.1};
			NE.setCPTable("HUIR", w1);
			float [] x1 = {(float)0.95, (float)0.05};
			NE.setCPTable("DETECTAR PELIGRO", x1);
			
			// PW
			float [] y1 = {(float)0.5, (float)0.5};
			PW.setCPTable("ATACAR", y1);
			float [] z1 = {(float)0.95, (float)0.05};
			PW.setCPTable("BUSCAR ARMAS", z1);
			float [] k = {(float)0.5, (float)0.5};
			PW.setCPTable("BUSCAR ENERGIA", k);
			float [] l = {(float)0.4, (float)0.6};
			PW.setCPTable("EXPLORAR", l);
			float [] m = {(float)0.4, (float)0.6};
			PW.setCPTable("HUIR", m);
			float [] n = {(float)0.0, (float)1.0};
			PW.setCPTable("DETECTAR PELIGRO", n);
			
			// PH
			float [] o = {(float)0.5, (float)0.5};
			PH.setCPTable("ATACAR", o);
			float [] p = {(float)0.5, (float)0.5};
			PH.setCPTable("BUSCAR ARMAS", p);
			float [] q = {(float)0.95, (float)0.05};
			PH.setCPTable("BUSCAR ENERGIA", q);
			float [] r = {(float)0.4, (float)0.6};
			PH.setCPTable("EXPLORAR", r);
			float [] s = {(float)0.4, (float)0.6};
			PH.setCPTable("HUIR", s);
			float [] t = {(float)0.5, (float)0.5};
			PH.setCPTable("DETECTAR PELIGRO", t);
			
			// H
			float [] u = {(float)0.9, (float)0.1};
			H.setCPTable("ATACAR", u);
			float [] v = {(float)0.6, (float)0.4};
			H.setCPTable("BUSCAR ARMAS", v);
			float [] w = {(float)0.1, (float)0.9};
			H.setCPTable("BUSCAR ENERGIA", w);
			float [] x = {(float)0.95, (float)0.1};
			H.setCPTable("EXPLORAR", x);
			float [] y = {(float)0.95, (float)0.1};
			H.setCPTable("HUIR", y);
			float [] z = {(float)0.95, (float)0.1};
			H.setCPTable("DETECTAR PELIGRO", z);
			
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
