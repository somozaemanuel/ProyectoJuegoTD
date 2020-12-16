package TiendaPersonaje;

import java.awt.Insets;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.FuerzaDuplicada;

public class FDuplicada extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	
	private static  FDuplicada instance;

	public FDuplicada(GUI gui) {
		super(gui);
		contadorPremio=3;
		this.setEnabled(true);
		this.setIconTextGap(0);
		this.setBounds(415, 35, 95, 45);
		this.setText("Temporizador ");
		this.setIcon(this.getIconoBoton());
		this.setMargin(new Insets(1, 8, -1, -1));

	}
	
	public static FDuplicada getInstance() {
		if (instance == null)
			instance = new FDuplicada(GUI.getInstance());
		return instance;

	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/FAMain.png"));
	}

	protected void accionarBoton() {
		cooldown=true;
	    FuerzaDuplicada f = new FuerzaDuplicada(null,0,0);
	    f.activarPowerUp();
	}

	
}
