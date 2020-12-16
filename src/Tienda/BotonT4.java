package Tienda;

import java.awt.Point;
import javax.swing.ImageIcon;
import Entidad.Entidad;
import GUI.GUI;
import Personaje.Mago;

public class BotonT4 extends Boton{
	
	private static final long serialVersionUID = 1L;
	
	public BotonT4(TiendaJuego tienda,GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 300, 200, 100);
		this.setEnabled(false);

	}
	

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Boton4.png"));
	}
	
	protected Entidad crearEntidad() {
		Entidad entidad =new Mago(new Point(-32, -32),70,70);
		return entidad;
	}


}
