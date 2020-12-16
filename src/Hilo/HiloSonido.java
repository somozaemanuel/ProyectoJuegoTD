package Hilo;

import Mapa.Nivel;
import Sonidos.sonidosMp3;

public class HiloSonido extends Thread {
	private Nivel nivel;
	private boolean ejecutar;
	private sonidosMp3 sonidosMp3;
	private int soudtrack;
	protected boolean noTerminedeJugar;

	private static HiloSonido instanceHiloOleadas;

	public static HiloSonido getInstace() {
		if (instanceHiloOleadas == null)
			instanceHiloOleadas = new HiloSonido();
		return instanceHiloOleadas;
	}

	private HiloSonido() {
		nivel = Nivel.getInstance();
		ejecutar = true;
		sonidosMp3 = new sonidosMp3();
		soudtrack = 0;
		noTerminedeJugar = true;

	}

	public void run() {
		while (ejecutar) {
			try {
				Thread.sleep(50);
				soudtrackNivel();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void setEjecutar(boolean b) {
		ejecutar = b;
	}

	public sonidosMp3 getSoudtrack() {
		return sonidosMp3;
	}

	public void stopSoudtrack() {
		sonidosMp3.stop();
		noTerminedeJugar = false;
	}

	private void soudtrackNivel() {
		if (noTerminedeJugar) {
			if (nivel.obtenerNivelActual() != soudtrack) {
				if (soudtrack > 2) {
					sonidosMp3.abrirArchivo("bsound" + 1);
				} else {
					soudtrack = nivel.obtenerNivelActual();
					sonidosMp3.stop();
					sonidosMp3.abrirArchivo("bsound" + nivel.obtenerNivelActual());
				}
			} else {
				sonidosMp3.loop();
			}
		}
	}
}
