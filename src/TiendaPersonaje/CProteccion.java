package TiendaPersonaje;

import java.awt.Insets;

import javax.swing.ImageIcon;
import GUI.GUI;

public class CProteccion extends BotonPwup {

	private static final long serialVersionUID = 1L;
	private int estadoBoton;
	private static CProteccion instance;

	private CProteccion(GUI gui) {
		super(gui);
		graficosBotones = new ImageIcon[2];
		graficosBotones[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/CampoMain.png"));
		graficosBotones[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BotonCancelar.png"));
		contadorPremio = 3;
		this.setEnabled(true);
		this.setIconTextGap(0);
		this.setBounds(227, 35, 95, 45);
		this.setText("Temporizador ");
		this.setIcon(this.getIconoBoton());
		this.setMargin(new Insets(1, 8, -1, -1));
		estadoBoton = 1;

	}

	public void habilitarBoton() {
		if (contadorPremio > 0)
			this.setEnabled(true);
	}

	public static CProteccion getInstance() {
		if (instance == null)
			instance = new CProteccion(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/CampoMain.png"));
	}

	protected void accionarBoton() {
		if (estadoBoton == 1) {
			GUI.getInstance().triggerBotones();
			GUI.getInstance().setCampoActivado(true);
			this.siguienteGrafico();
			BombaBoton.getInstance().setEnabled(false);
			estadoBoton = 2;
		} else {
			GUI.getInstance().triggerBotones2();
			GUI.getInstance().setCampoActivado(false);
			this.siguienteGrafico();
			estadoBoton = 1;
			BombaBoton.getInstance().setEnabled(true);
		}

	}

	public void estadoCampo(int estado) {
		estadoBoton = estado;
	}

}
