package PowerUps;

import java.awt.Point;

import Entidad.Entidad;
import Visitor.Visitor;

public class Premio extends Entidad {

	protected boolean activado;

	public Premio(Point p, int x, int y) {
		super(p, x, y);
		activado = false;
	}

	public void accionar() {

	}

	public void fuisteClickeado() {
	}

	public void aceptar(Visitor v) {
		v.afectar(this);

	}

	public void activarPowerUp() {

	}

}