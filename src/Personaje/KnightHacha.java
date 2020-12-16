package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class KnightHacha extends Personaje {

	public KnightHacha(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_2.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_KNIGHT_2.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_KNIGHT_2.gif"));
		this.imagen[3] = null;
		this.puntosVida = 5000;
		this.precioPersonaje = 2500;
		this.danioImpacto = 90;
		this.alcance = 0;
	}

	public void morir() {

	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}

}
