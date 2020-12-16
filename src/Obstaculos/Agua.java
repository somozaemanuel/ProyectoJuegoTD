	package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Agua extends ObstaculoTemporal {

	public Agua(Point p, int x, int y) {
		super(p, x, y);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Agua.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Agua.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		this.puntosVida = 100;
		this.danioImpacto = 0;
		this.slow = 3;

	}

	public void accionar() {
		tiempo++;
		if (tiempo == 500) {
			this.setGrafico(MUERTE);
			this.morir();
		}
	}

	public int getslow() {
		return slow;
	}

}
