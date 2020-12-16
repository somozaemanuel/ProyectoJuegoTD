package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

public class FallenAngel extends Enemigo {
	
	public FallenAngel(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		
		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/FallenAngel0_die.gif"));
		this.imagen[3] = null;
		this.velocidad=5;
		this.puntosVida=5000;
		this.monedas=2000;
		this.danioAJugador=15;
		this.puntaje=40;
		this.danioImpacto = 40;
		this.velocidadInicial=velocidad;

	}

}
