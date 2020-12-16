package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.BombaExplosion;
import PowerUps.Premio;

public class VisitorPersonaje extends Visitor{
	
	public VisitorPersonaje(Personaje p){
		super(p);
	}

	public void afectar(Personaje p) {
	}

	public void afectar(Enemigo e) {
		e.recibirDaño(miEntidad.getDanio());
		miEntidad.setGrafico(1);
		e.setEstado(2);
		miEntidad.setEstado(2);
		if(e.getVida()<=0) {
			miEntidad.setGrafico(0);
		}
		
	}

	
	public void afectar(BombaExplosion b){
	}

	public void afectar(Disparo d) {
		
	}


	public void afectar(Premio p) {
		
	}

	public void afectar(ObstaculoTemporal p) {
		
	}

	public void afectar(Obstaculo o) {
		o.recibirDaño(miEntidad.getDanio());
		
	}

}
