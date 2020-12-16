package Personaje;

import java.awt.Point;

import Disparos.Disparo;
import Entidad.Entidad;
import PowerUps.*;
import Visitor.VisitorPersonaje;

public abstract class Personaje extends Entidad {

	protected int tiempoEntreDisparo = 0;
	protected int tiempoRealDisparos;
	protected Disparo disparo;

	protected Personaje(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		this.miVisitor = new VisitorPersonaje(this);
	}

	public void setTiempoDisparo(int t) {
		tiempoRealDisparos = t;
	}

	public void resetTiempo() {
		tiempoRealDisparos = 20;
	}

	public int getTiempoDisparos() {
		return tiempoRealDisparos;
	}

	public void accionar() {
	}

	public boolean addCampo() {
		Point nuevoPunto = new Point((pos.x - 5), pos.y);
		CampoProteccionActivado campo = new CampoProteccionActivado(nuevoPunto, 80, 80);
		juego.agregarEntidad(campo, true);
		return true;
	}

	public void danioDuplicado() {
		danioImpacto = danioImpacto * 2;

	}

}
