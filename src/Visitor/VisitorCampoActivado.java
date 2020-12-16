package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.Premio;

public class VisitorCampoActivado extends Visitor {

	public VisitorCampoActivado(Entidad e) {
		super(e);
		
	}

	@Override
	public void afectar(Personaje p) {
		

	}

	@Override
	public void afectar(Enemigo e) {
		e.morir();
		miEntidad.morir();

	}

	@Override
	public void afectar(Disparo d) {
	

	}

	@Override
	public void afectar(Obstaculo o) {
	

	}

	@Override
	public void afectar(Premio p) {
		

	}

	@Override
	public void afectar(ObstaculoTemporal p) {
		
	}

}
