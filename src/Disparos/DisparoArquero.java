package Disparos;

import java.awt.Point;
import javax.swing.ImageIcon;

import Visitor.Visitor;

public class DisparoArquero extends Disparo {

	public DisparoArquero(Point p, int x, int y, int daño, int alcance) {
		super(p, x, y);
		danioImpacto = daño;
		this.alcance = this.pos.x + alcance;
		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Disparo/flecha.png"));
		this.imagen[2] = null;
		this.imagen[3] = null;
		puntosVida = 1;
		velocidad = 10;

	}

	public void accionar() {
		this.pos.x += velocidad;
		setGrafico(MOVIMIENTO);
		if (this.pos.x >= alcance) {
			this.morir();
		}
	}


	public void morir() {
		this.puntosVida = 0;
	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}


}
