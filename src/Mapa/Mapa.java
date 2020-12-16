package Mapa;

import java.awt.Rectangle;
import java.util.LinkedList;

import Entidad.Entidad;

public class Mapa {

	public Mapa() {
	}

	public boolean puedoAgregar(Entidad entidad, LinkedList<Entidad> listaEntidades) {
		boolean toReturn = true;
		if (entidad != null) {
			Rectangle rectangle = entidad.getRectangle();
			Rectangle rectangle2;
			for (Entidad e : listaEntidades) {
				rectangle2 = e.getRectangle();
				if (rectangle.intersects(rectangle2)) {
					toReturn = false;
				}
			}
		} else
			toReturn = false;
		return toReturn;
	}

}
