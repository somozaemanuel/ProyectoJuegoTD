package PowerUps;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidad.Entidad;
import Visitor.Visitor;
import Visitor.VisitorCampoActivado;

public class CampoProteccionActivado extends Entidad {

	public CampoProteccionActivado(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorCampoActivado(this);
		puntosVida = 1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Campo.png"));
	}

	public void accionar() {

	}


	public void aceptar(Visitor v) {
		v.afectar(this);

	}
}