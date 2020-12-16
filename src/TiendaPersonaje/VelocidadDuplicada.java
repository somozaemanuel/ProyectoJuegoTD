package TiendaPersonaje;

import java.awt.Insets;

import javax.swing.ImageIcon;
import GUI.GUI;
import PowerUps.DuplicarVelocidadAtaque;

public class VelocidadDuplicada extends BotonPwup {
	
	private static final long serialVersionUID = 1L;
	private static  VelocidadDuplicada instance;


	public VelocidadDuplicada(GUI gui) {
		super(gui);
		contadorPremio=3;
		this.setEnabled(true);
		this.setIconTextGap(0);
		this.setBounds(605, 35, 95, 45);
		this.setText("Temporizador ");
		this.setIcon(this.getIconoBoton());
		this.setMargin(new Insets(1, 8, -1, -1));

	}
	
	public static VelocidadDuplicada getInstance() {
		if (instance == null)
			instance = new VelocidadDuplicada(GUI.getInstance());
		return instance;

	}


	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/DuplicarVelocidadMain.png"));
	}

	protected void accionarBoton() {
		 DuplicarVelocidadAtaque m = new DuplicarVelocidadAtaque(null,0,0);
		   m.activarPowerUp();
		
	}


	
}
