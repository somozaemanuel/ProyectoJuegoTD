package Obstaculos;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class Roca extends Obstaculo {

	public Roca(Point p, int width, int height) {
		super(p, width, height);
		puntosVida = 300;

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Roca.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Roca.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;

	}

	public void accionar() {

	}

	public void aceptar(Visitor v) {
		v.afectar(this);

	}

}
