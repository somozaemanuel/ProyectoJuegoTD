package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Lava extends ObstaculoTemporal {

	public Lava(Point p, int x, int y) {
		super(p, x, y);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Lava.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Lava.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		this.puntosVida = 100;
		this.danioImpacto = 50;
		this.precioPersonaje = 3000;

	}

}
