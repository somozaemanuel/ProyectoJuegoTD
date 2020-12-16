package Enemigo;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import Entidad.Entidad;
import Mapa.Nivel;
import PowerUps.*;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;

public abstract class Enemigo extends Entidad {

	protected int puntaje;
	protected int velocidadInicial;
	protected Nivel nivel;
	protected int danioAJugador;

	protected Enemigo(Point p, int ancho, int alto) {
		super(p, ancho, alto);
		miVisitor = new VisitorEnemigo(this);
		nivel = Nivel.getInstance();
		estado = 1;
	}

	public void slow(int v) {
		if (velocidad == velocidadInicial) {
			velocidad -= v;
			if (velocidad <= 0) {
				velocidad = 1;
			}
		}
	}

	public Rectangle getRectangle() {
		return new Rectangle(this.getPosition().x - this.velocidad, this.getPosition().y, this.anchoEntidad(),
				this.altoEntidad());
	}

	public void accionar() {
		if (estado == 1) {
			Point point = new Point(this.getPosition().x - velocidad, this.getPosition().y);
			pos = point;
			if (velocidad != 0)
				velocidad = velocidadInicial;
			setGrafico(0);
			if (this.getPosition().x < -100) {
				this.puntosVida = 0;
				juego.setVida(danioAJugador, false);
				Nivel.getInstance().sumarEnemigosMuertos();
			}
		}
	}

	public void morir() {
		juego.enemigoMuerto();
		Random rnd = new Random();
		int posibilidad = rnd.nextInt(4);
		this.puntosVida=0;
		if (posibilidad == 0) {
			generarPowerUp();
		}
		

	}

	private Premio generarPowerUp() {

		Premio nuevoPremio = null;
		Random rnd = new Random();
		int premioElegido = rnd.nextInt(5);
		switch (premioElegido) {
		case 0:
			nuevoPremio = new CampoProteccion(pos, 80, 80);
			break;
		case 1:
			nuevoPremio = new Bomba(pos, 70, 70);
			break;
		case 2:
			nuevoPremio = new FuerzaDuplicada(pos, 34, 34);
			break;
		case 3:
			nuevoPremio = new Temporizador(pos, 40, 39);
			break;
		case 4:
			nuevoPremio = new DuplicarVelocidadAtaque(pos, 70, 70);
			break;
		}

		juego.agregarEntidad(nuevoPremio, true);
		return nuevoPremio;

	}

	public int getPuntaje() {
		return puntaje;
	}

	public void aceptar(Visitor v) {
		v.afectar(this);
	}

	public boolean chocan(Entidad e2) {

		boolean colisionan = false;
		boolean salida = false;
		Rectangle rectangle = this.getRectangle();
		Rectangle rectangle2 = e2.getRectangle();
		colisionan = rectangle.intersects(rectangle2);
		if (rectangle2.x < rectangle.x && colisionan) {// Controlo si choca adelante
			salida = true;
		}
		return salida;
	}

	public void detener(boolean d) {
		if (d)
			velocidad = 0;
		else {
			velocidad = velocidadInicial;
		}
	}

}
