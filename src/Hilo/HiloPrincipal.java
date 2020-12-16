package Hilo;

import Juego.Juego;
import Mapa.Nivel;

public class HiloPrincipal extends Thread {
	// Atributos

	private static HiloPrincipal instaceHiloPrincipal;
	private Juego juego;
	private boolean ejecutar;
	private Nivel nivel;

	public static HiloPrincipal getInstace() {
		if (instaceHiloPrincipal == null)
			instaceHiloPrincipal = new HiloPrincipal();
		return instaceHiloPrincipal;
	}

	private HiloPrincipal() {
		nivel = Nivel.getInstance();
		juego = Juego.getInstance();
		ejecutar = true;
	}

	public void run() {

		while (ejecutar) {
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.accionar();

		}
	}

	public void setEjecutar(boolean b) {
		ejecutar = b;

	}
}
