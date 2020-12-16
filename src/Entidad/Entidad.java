package Entidad;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JLabel;

import GUI.GUI;
import Juego.Juego;
import Visitor.Visitor;

public abstract class Entidad {

	protected int width;
	protected int height;
	protected int monedas;
	protected int puntosVida;
	protected int danioImpacto;
	protected int velocidad;
	protected int precioPersonaje;
	protected int alcance;
	protected boolean puedoAvanzar;
	protected Point pos;
	protected JLabel grafico;
	protected GUI gui;
	protected Juego juego;
	protected Visitor miVisitor;
	protected Icon imagen[];
	protected int estado;
	protected final int MOVIMIENTO = 0;
	protected final int ATAQUE = 1;
	protected final int MUERTE = 2;

	protected Entidad(Point p, int width, int height) {// Recibe todos los componentes del enemigo no recive velocidad
		pos = p;
		this.width = width;
		this.height = height;
		this.imagen = new Icon[4];
		juego = Juego.getInstance();
	}

	public int getMonedas() {
		return monedas;
	}

	public void fuisteClickeado() {

	}

	public boolean addCampo() {
		return false;
	}

	public int getVida() {
		return puntosVida;
	}

	public boolean estoyMuerto() {
		return puntosVida <= 0;
	}

	public Point getPosition() {
		return pos;
	}

	public void setPosition(Point p) {
		pos = p;
	}

	public JLabel getGrafico(int i) {
		if (this.grafico == null) {
			this.grafico = new JLabel(imagen[i]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);

		}
		return grafico;
	}

	public void setGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.imagen[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}

	public int getDanio() {
		return danioImpacto;
	}

	public void setDanio(int d) {
		danioImpacto = d;
	}

	public int altoEntidad() {
		return height;
	}

	public int anchoEntidad() {
		return width;
	}

	public abstract void accionar();

	public abstract void aceptar(Visitor v);

	public void morir() {
		puntosVida = 0;
	}

	public int getPrecioPersonaje() {
		return precioPersonaje;
	}

	public void setPrecioPersonaje(int precio) {
		precioPersonaje = precio;
	}

	public int getPuntaje() {
		return 0;
	}

	public void recibirDaño(int daño) {
		puntosVida = puntosVida - daño;

	}

	public Visitor getVisitor() {
		return miVisitor;
	}

	public Rectangle getRectangle() {
		return new Rectangle(this.getPosition().x, this.getPosition().y, this.anchoEntidad(), this.altoEntidad());
	}

	public int getAlcance() {
		return alcance;
	}

	public boolean chocan(Entidad e2) {
		boolean colisionan;
		Rectangle rectangle = this.getRectangle();
		Rectangle rectangle2 = e2.getRectangle();
		colisionan = rectangle.intersects(rectangle2);

		return colisionan;
	}

	public void setEstado(int e) {
		estado = e;
	}

	public void danioDuplicado() {

	}

	public void detener(boolean d) {

	}

	public int getslow() {
		return 0;
	}

	public void setTiempoDisparo(int t) {
	}

	public int getTiempoDisparos() {
		return 0;
	}

	public void resetTiempo() {

	}

}
