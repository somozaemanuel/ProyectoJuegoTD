package TiendaPersonaje;

import java.awt.Insets;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.*;

public class BombaBoton extends BotonPwup {

	private static final long serialVersionUID = 1L;
	private static BombaBoton instance;
	private int estadoBoton;

	private BombaBoton(GUI gui) {
		super(gui);
		estadoBoton = 1;
		contadorPremio = 3;
		graficosBotones = new ImageIcon[2];
		graficosBotones[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BombaMain.png"));
		graficosBotones[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BotonCancelar.png"));
		this.setEnabled(true);
		this.setIconTextGap(0);
		this.setBounds(322, 35, 95, 45);
		this.setText("Temporizador ");
		this.setIcon(graficosBotones[0]);
		this.setMargin(new Insets(1, 8, -1, -1));
	}

	public static BombaBoton getInstance() {
		if (instance == null)
			instance = new BombaBoton(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BombaMain.png"));
	}

	protected void accionarBoton() {
		if (estadoBoton == 1) {
			GUI.getInstance().triggerBotones();
			GUI.getInstance().setBombaActivada(true);
			GUI.getInstance().agregarBomba(new BombaExplosion(null, 80, 80));
			this.siguienteGrafico();
			CProteccion.getInstance().setEnabled(false);
			estadoBoton = 2;
		} else {
			GUI.getInstance().triggerBotones2();
			GUI.getInstance().setBombaActivada(false);
			this.siguienteGrafico();
			CProteccion.getInstance().setEnabled(true);
			estadoBoton = 1;
		}

	}

	public void estadoBomba(int estado) {
		estadoBoton = estado;
	}

}
