package Hilo;

import Mapa.Nivel;

public class HiloOleadas extends Thread {
	// Atributos
	private Nivel nivel;
	private boolean ejecutar;

	private static HiloOleadas instanceHiloOleadas;

	public static HiloOleadas getInstace() {
		if (instanceHiloOleadas == null)
			instanceHiloOleadas = new HiloOleadas();
		return instanceHiloOleadas;
	}

	private HiloOleadas() {
		nivel = Nivel.getInstance();
		ejecutar = true;

	}

	public void run() {
		while (ejecutar) {
			try {
				nivel.agregarEnemigos();
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void setEjecutar(boolean b) {
		ejecutar = b;
	}

}