package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.BombaExplosion;
import PowerUps.CampoProteccionActivado;
import PowerUps.Premio;

public abstract class Visitor {
	
	protected Entidad miEntidad;
	
	protected Visitor(Entidad e){
		miEntidad=e;
	}
	
	public abstract void afectar(Personaje p);
	public abstract void afectar(Enemigo e);
	public abstract void afectar(Disparo d);
	public abstract void afectar(Obstaculo o);
	public abstract void afectar(Premio p);
	public abstract void afectar(ObstaculoTemporal p);
	public void afectar(CampoProteccionActivado c){
	}

	public void afectar(BombaExplosion bombaExplosion) {
		
	}

}
