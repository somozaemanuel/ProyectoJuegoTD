package PowerUps;

import java.awt.Point;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import Entidad.Entidad;
import TiendaPersonaje.VelocidadDuplicada;
import Visitor.VisitorPremio;

public class DuplicarVelocidadAtaque extends Premio {

	public DuplicarVelocidadAtaque(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida = 1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/VelocidadAtaque.png"));
		
	}

	private final void setInterval(int interval, java.util.Timer timer) {
		if (interval == 0) {
			VelocidadDuplicada.getInstance().restarContador();
			VelocidadDuplicada.getInstance().setText("VA");
			for (Entidad e1 : juego.getEntidades()) {
				e1.setTiempoDisparo(e1.getTiempoDisparos() * 2);
				
			}
			timer.cancel();
		} else {
			VelocidadDuplicada.getInstance().setText("" + interval);
		}
	}

	public void activarPowerUp() {
		
		for (Entidad e1 : juego.getEntidades())
			e1.setTiempoDisparo(e1.getTiempoDisparos() / 2 );
		VelocidadDuplicada.getInstance().setEnabled(false);
		VelocidadDuplicada.getInstance().setText("5");
		
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
		morir();
		VelocidadDuplicada.getInstance().sumarContador();
	}
}
