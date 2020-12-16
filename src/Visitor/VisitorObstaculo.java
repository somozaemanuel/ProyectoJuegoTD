package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.Premio;

public class VisitorObstaculo extends Visitor{
	
	public VisitorObstaculo(Obstaculo o){
		super(o);
	}

	public void afectar(Personaje p) {
		p.setEstado(2);
		p.setGrafico(1);
	}

	public void afectar(Enemigo e) {
		e.setGrafico(1);
		e.setEstado(2);
		
	}

	public void afectar(Disparo d) {
		miEntidad.recibirDaño(d.getDanio());
		d.morir();
		
		
	}


	public void afectar(Premio p) {
		
	}

	public void afectar(ObstaculoTemporal p) {
		
	}

	public void afectar(Obstaculo o) {
		
	}

}
