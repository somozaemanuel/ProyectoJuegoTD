package Tienda;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Entidad.Entidad;
import GUI.GUI;

public class BotonSiguiente extends Boton {

	private static final long serialVersionUID = 1L;
	private int cont = 0;// se utiliza solo para cambiar la iamgen
	private ImageIcon icon;

	public BotonSiguiente(TiendaJuego tienda, GUI gui) {
		super(tienda, gui);
		this.setBounds(0, 500, 200, 100);
		//this.setBorder(null);
		this.setEnabled(false);
		icon = new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BotonAnterior.png"));
	}

	// Accion del boton Siguiente
	protected void accionarBoton() {
		LinkedList<JButton> buttons = tienda.getBoton();

		if (cont == 0) {
			this.setIcon(icon);
			cont++;
		} else {
			this.setIcon(this.getIconoBoton());
			cont--;
		}
		for (JButton b : buttons) {
			if (!b.isVisible()) {
				b.setVisible(true);
				b.setEnabled(true);
			}

			else {
				if (!b.equals(this) && b.getBounds().y != 600) {
					b.setVisible(false);
				}
			}
		}
	}

	protected ImageIcon getIconoBoton() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/BotonSiguiente.png"));

	}

	protected Entidad crearEntidad() {
		return null;
	}

}
