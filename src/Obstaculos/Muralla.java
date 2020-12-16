package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Muralla extends Obstaculo {

	public Muralla(Point p, int width, int height) {
		super(p, width, height);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Barricada.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Barricada.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		this.puntosVida = 300;
		this.danioImpacto = 0;
		this.precioPersonaje = 1000;
	}

	public void accionar() {

	}

}
