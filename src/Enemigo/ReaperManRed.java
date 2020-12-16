package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

public class ReaperManRed extends Enemigo {

	// Constructor
	public ReaperManRed(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperManRed_Dying.gif"));
		this.imagen[3] = null;
		this.velocidad = 5;
		this.puntosVida = 2000;
		this.monedas = 10;
		this.puntaje = 10;
		this.danioImpacto=35;
		this.danioAJugador=10;
		this.velocidadInicial=velocidad;

	}
}
