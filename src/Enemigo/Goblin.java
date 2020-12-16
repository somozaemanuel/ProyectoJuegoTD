package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Goblin extends Enemigo {

	public Goblin(Point p, int x, int y) {
		super(p, x, y);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/WALKING_GOBLIN_1.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ATTACK_GOBLIN_1.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/DYING_GOBLIN_1.gif"));
		this.imagen[3] = null;
		this.velocidad = 10;
		this.puntosVida = 1000;
		this.monedas = 500;
		this.danioAJugador=3;
		this.puntaje = 10;
		this.danioImpacto=15;
		this.velocidadInicial=velocidad;

	}

}
