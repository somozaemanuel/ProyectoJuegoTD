package TiendaPersonaje;

import java.awt.Insets;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.Temporizador;

public class Temp extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static  Temp instance;

	public Temp(GUI gui) {
		super(gui);
		contadorPremio=3;
		this.setEnabled(true);
		this.setIconTextGap(0);
		this.setBounds(510, 35, 95, 45);
		this.setText("Temporizador ");
		this.setIcon(this.getIconoBoton());
		this.setMargin(new Insets(1, 8, -1, -1));

	}
	
	public static Temp getInstance() {
		if (instance == null)
			instance = new Temp(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/CongelarMain.png"));
	}

	protected void accionarBoton() {
		Temporizador t = new Temporizador(null,0,0);
		this.setEnabled(false);
		t.activarPowerUp();
	}


	
}
