package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparos.DisparoMago;
import Visitor.Visitor;

public class KnightLanza extends Personaje {

	public KnightLanza(Point p, int ancho, int alto) {
		super(p, ancho, alto);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_KNIGHT_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_KNIGHT_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_KNIGHT_1.gif"));
		this.imagen[3] = null;
		this.puntosVida = 2000;
		this.precioPersonaje = 500;
		this.danioImpacto = 40;
		this.alcance = 0;
	}

	public ImageIcon obtenerGrafico() {
		return new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/Steve1.png"));
	}

	public DisparoMago disparar() {
		DisparoMago nuevo = new DisparoMago(new Point(pos.x + 50, pos.y), 46, 16, 15, 15);
		return nuevo;
	}

	public void morir() {

	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}
}
