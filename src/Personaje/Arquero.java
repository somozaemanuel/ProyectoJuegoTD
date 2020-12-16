package Personaje;

import java.awt.Point;
import javax.swing.ImageIcon;
import Disparos.DisparoArquero;
import Juego.Juego;
import Visitor.Visitor;

public class Arquero extends Personaje {

	public Arquero(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_ARQUERO_1.gif"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/ESTATICO_ARQUERO_1.gif"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/zImagenes/Jugador/DIE_ARQUERO_1.gif"));
		this.imagen[3] = null;
		this.puntosVida = 1000;
		this.precioPersonaje = 1000;
		this.danioImpacto = 40;
		this.alcance = 350;
		this.tiempoRealDisparos = 20;
	}

	public void accionar() {
		Juego juego = Juego.getInstance();
		if (tiempoEntreDisparo == 0) {
			Point point = new Point(this.getPosition());
			disparo = new DisparoArquero(point, 50, 50, danioImpacto, alcance);
			juego.agregarEntidad(disparo, true);
			tiempoEntreDisparo = tiempoRealDisparos;
		}
		tiempoEntreDisparo--;

	}

	public void morir() {
	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}

}
