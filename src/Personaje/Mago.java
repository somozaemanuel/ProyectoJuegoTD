package Personaje;

import java.awt.Point;

import javax.swing.ImageIcon;
import Disparos.DisparoMago;
import Juego.Juego;
import Sonidos.sonidosMp3;
import Visitor.Visitor;

public class Mago extends Personaje {
	sonidosMp3 mp3;

	public Mago(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_MAGO_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ATTACK_MAGO_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_MAGO_1.gif"));
		this.imagen[3] = null;
		this.puntosVida = 1000;
		this.precioPersonaje = 4000;
		this.danioImpacto = 200;
		this.alcance = 500;
		this.tiempoRealDisparos = 30;
		this.mp3 = new sonidosMp3();
	}

	public void accionar() {
		Juego juego = Juego.getInstance();
		if (tiempoEntreDisparo == 0) {
			Point point = new Point(this.getPosition());
			disparo = new DisparoMago(point, 50, 50, danioImpacto, alcance);
			juego.agregarEntidad(disparo, true);
			tiempoEntreDisparo = tiempoRealDisparos;
			mp3.abrirArchivo("battle015");

		}
		tiempoEntreDisparo--;

	}

	@Override
	public void morir() {

	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}

}
