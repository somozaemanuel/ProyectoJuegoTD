package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

public class GolemHielo extends Enemigo {

	// Constructor
	public GolemHielo(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemHielo_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemHielo_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/GolemHielo_Dying.gif"));
		this.imagen[3] = null;
		this.velocidad = 5;
		this.puntosVida = 800;
		this.monedas = 300;
		this.puntaje = 5;
		this.danioImpacto=5;
		this.danioAJugador=2;
		this.velocidadInicial=velocidad;


	}


}
