package Tienda;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import GUI.GUI;
import Personaje.KnightLanza;

public class BotonT3 extends Boton{
	
	private static final long serialVersionUID = 1L;
	
	
	public BotonT3(TiendaJuego tienda,GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 200, 200, 100);
		this.setEnabled(false);

	}




	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton3.png"));
	}

	protected Entidad crearEntidad() {
		Entidad entidad = new KnightLanza(new Point(-32, -32), 70, 70);
		return entidad;
	}


}
