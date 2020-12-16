package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.CampoProteccionActivado;
import PowerUps.Premio;

public class VisitorEnemigoSuicida extends Visitor {
	
	public VisitorEnemigoSuicida(Entidad e) {
		super(e);
	}

	public void afectar(Personaje p) {
		p.recibirDaño(miEntidad.getDanio());
		miEntidad.morir();
	}

	public void afectar(Enemigo e) {
		e.setEstado(2);
	}

	public void afectar(Disparo d) {
		miEntidad.accionar();
	}
	
	public void afectar(Premio p) {
	}

	public void afectar(ObstaculoTemporal p) {
		
	}

	public void afectar(Obstaculo o) {
		o.recibirDaño(miEntidad.getDanio());		
	}
	
	public void afectar(CampoProteccionActivado c){
		c.morir();
		miEntidad.morir();
	}

}
