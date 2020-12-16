package Disparos;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class DisparoMago extends Disparo {

	public DisparoMago(Point p, int ancho, int alto, int daño, int alcance) {
		super(p, ancho, alto);
		danioImpacto = daño;
		this.alcance = alcance + this.pos.x;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/DisparoMago.gif"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		puntosVida = 1;
		velocidad = 6;
	}

	public void morir() {
		this.puntosVida = 0;
	}

	public void aceptar(Visitor v) {
		v.afectar(this);

	}

	public void accionar() {
		this.pos.x += velocidad;
		setGrafico(1);
		if (this.pos.x >= alcance) {
			this.morir();
		}
	}
}
