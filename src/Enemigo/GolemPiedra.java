package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;



public class GolemPiedra extends Enemigo {

	public GolemPiedra(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemPiedra_Dying.gif"));
		this.imagen[3] = null;
		this.velocidad = 2;
		this.puntosVida = 15000;
		this.monedas = 5000;
		this.puntaje = 500;
		this.danioAJugador=40;
		this.danioImpacto=120;
		this.velocidadInicial=velocidad;


	}
}
