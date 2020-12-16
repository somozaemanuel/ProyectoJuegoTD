package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;

public class KnightEspada extends Personaje {

	public KnightEspada(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_3.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_KNIGHT_3.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_KNIGHT_3.gif"));
		this.imagen[3] = null;
		this.puntosVida = 3000;
		this.precioPersonaje = 1000;
		this.danioImpacto = 20;
		this.alcance = 0;
	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}

}
