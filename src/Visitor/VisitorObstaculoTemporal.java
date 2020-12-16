package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.Premio;

public class VisitorObstaculoTemporal extends Visitor{

	public VisitorObstaculoTemporal(Entidad e) {
		super(e);
	}

	public void afectar(Personaje p) {
	}

	public void afectar(Enemigo e) {
		e.recibirDaño(miEntidad.getDanio());
		e.slow(miEntidad.getslow());
		e.setEstado(1);
	}

	public void afectar(Disparo d) {
	}


	public void afectar(Premio p) {
	}
	
	public void afectar(ObstaculoTemporal p) {
	}

	public void afectar(Obstaculo o) {
		
	}

}
