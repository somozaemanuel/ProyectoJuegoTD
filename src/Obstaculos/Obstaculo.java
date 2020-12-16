package Obstaculos;

import java.awt.Point;
import Entidad.Entidad;
import Visitor.Visitor;
import Visitor.VisitorObstaculo;

public abstract class Obstaculo extends Entidad {

	public Obstaculo(Point p, int width, int height) {
		super(p, width, height);
		miVisitor = new VisitorObstaculo(this);
	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}

}
