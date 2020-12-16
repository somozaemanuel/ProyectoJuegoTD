package Tienda;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Entidad.Entidad;
import Juego.Juego;

public class TiendaJuego {
	private Juego juego;
	private Entidad nextToAdd;

	private static TiendaJuego instance;
	private LinkedList<JButton> buttons;

	public static TiendaJuego getInstance() {
		if (instance == null)
			instance = new TiendaJuego(Juego.getInstance());
		return instance;
	}

	private TiendaJuego(Juego juego) {
		this.juego = juego;
		buttons = new LinkedList<JButton>();
		this.nextToAdd = null;
	}

	public void setNextToAdd(Entidad toAdd) {
		this.nextToAdd = toAdd;
	}

	public boolean puedoAgregar(Entidad toAdd) {
		boolean toReturn = false;
		if (toAdd != null) {
			int cantMonedas = this.juego.getCantMonedas();
			int precio = toAdd.getPrecioPersonaje();
			toReturn = cantMonedas >= precio;
		}
		return toReturn;
	}

	public void agregarEntidad(int x, int y) {
		if (this.nextToAdd != null ) {
			this.nextToAdd.setPosition(new Point(x-32, y-32));
			boolean pude = this.juego.agregarEntidad(this.nextToAdd,false);
			this.nextToAdd = null;
			if (!pude){
				JOptionPane optionPane = new JOptionPane(
						"Agrega la unidad en otra posición! Esa ya está ocupada.",
						JOptionPane.ERROR_MESSAGE);
				JDialog dialog = optionPane.createDialog("Error");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				
			}
		}
	}

	public void setBoton(JButton b) {
		buttons.add(b);
	}

	public LinkedList<JButton> getBoton() {
		return buttons;
	}

}
