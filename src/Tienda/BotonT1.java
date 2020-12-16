package Tienda;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import GUI.GUI;
import Personaje.KnightEspada;

public class BotonT1 extends Boton {
	
	private static final long serialVersionUID = 1L;

	public BotonT1(TiendaJuego tienda,GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 0, 200, 100);
		this.setEnabled(false);

	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton1.png"));
	}

	protected Entidad crearEntidad() {
		Entidad entidad =new KnightEspada(new Point(-32, -32),70,70);
		return entidad;
	}

}
