package Tienda;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidad.Entidad;
import GUI.GUI;
import Obstaculos.Muralla;

public class BotonMuralla extends Boton{
	
private static final long serialVersionUID = 1L;
	
	public BotonMuralla(TiendaJuego tienda, GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 100, 200, 100);
		this.setBorder(null);
		this.setEnabled(false);
		this.setVisible(false);

	}


	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BotonRoca.png"));

	}

	protected Entidad crearEntidad() {
		Entidad entidad =new Muralla(new Point(0,0),70,65);
		return entidad;
	}

}


