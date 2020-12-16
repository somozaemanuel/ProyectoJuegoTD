package Enemigo;

import java.awt.Point;

import javax.swing.ImageIcon;

import Visitor.Visitor;
import Visitor.VisitorEnemigoSuicida;



public class ReaperMan extends Enemigo {

	// Constructor
	public ReaperMan(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[MOVIMIENTO] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperMan_Running.gif"));
		this.imagen[ATAQUE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/ReaperMan_Attack.gif"));
		this.imagen[MUERTE] = new ImageIcon(this.getClass().getResource("/zImagenes/Enemigo/Explosion.gif"));
		this.imagen[3] = null;
		this.velocidad = 6;
		this.puntosVida = 1000;
		this.monedas = 10;
		this.puntaje = 10;
		this.danioImpacto=35;
		this.danioAJugador=15;
		this.velocidadInicial=velocidad;
		this.miVisitor = new VisitorEnemigoSuicida(this);

	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}
}
