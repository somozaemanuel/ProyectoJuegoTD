package PowerUps;

import java.awt.Point;
import java.util.TimerTask;

import Entidad.Entidad;
import TiendaPersonaje.FDuplicada;
import Visitor.VisitorPremio;

import javax.swing.ImageIcon;

public class FuerzaDuplicada extends Premio {

	public FuerzaDuplicada(Point p, int x, int y) {
		super(p, x, y);
		miVisitor = new VisitorPremio(this);
		puntosVida = 1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/zImagenes/Objetos/fuerza1.png"));

	}
	
	private final void setInterval(int interval, java.util.Timer timer) {
		if (interval == 0) {
			FDuplicada.getInstance().restarContador();
			FDuplicada.getInstance().setText("Fuerza Duplicada");
			FDuplicada.getInstance().setCooldown(false);
			for (Entidad e1 : juego.getEntidades()) {
				e1.setDanio(e1.getDanio()/2);
			}
			timer.cancel();
		} else {
			FDuplicada.getInstance().setText("" + interval);
		}
	}

	// por cada entidad de la lista le seteo un danioDuplicado
	public synchronized void activarPowerUp() {
		for (Entidad e : juego.getEntidades()) {
			e.setDanio(e.getDanio() * 2 );
		}
		
		FDuplicada.getInstance().setEnabled(false);

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
	
	public void fuisteClickeado(){
		if (!activado){
			morir();
			FDuplicada.getInstance().sumarContador();}
		
		}
}