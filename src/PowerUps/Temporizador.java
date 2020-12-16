package PowerUps;

import java.awt.Point;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import Entidad.Entidad;

import TiendaPersonaje.Temp;
import Visitor.VisitorPremio;

public class Temporizador extends Premio {

	public Temporizador(Point p, int x, int y) {
		super(p, x, y);
		puntosVida = 1;
		miVisitor = new VisitorPremio(this);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/Reloj.png"));

	}

	private final void setInterval(int interval, java.util.Timer timer) {
		if (interval == 0) {
			Temp.getInstance().restarContador();
			Temp.getInstance().setText("Temporizador");
			for (Entidad e1 : juego.getEntidades()) {
				e1.detener(false);
			}
			timer.cancel();
		} else {
			Temp.getInstance().setText("" + interval);
		}
	}

	public void activarPowerUp() {
		for (Entidad e1 : juego.getEntidades()) {
			e1.detener(true);
		}

		long delay = 10;
		long period = 1000;
		java.util.Timer timer = new java.util.Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			int interval = 5;

			public void run() {

				setInterval(interval, timer);
				interval--;

			}
		}, delay, period);

	}

	public void fuisteClickeado() {
		if (!activado) {
			morir();
			Temp.getInstance().sumarContador();
		}

	}
}
