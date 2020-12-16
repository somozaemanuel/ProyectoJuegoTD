package Visitor;

import Disparos.Disparo;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Obstaculos.Obstaculo;
import Obstaculos.ObstaculoTemporal;
import Personaje.Personaje;
import PowerUps.BombaExplosion;
import PowerUps.Premio;

public class VisitorExplosion extends Visitor {

	public VisitorExplosion(Entidad e) {
		super(e);
	}

	@Override
	public void afectar(Personaje p) {
		BombaExplosion b = (BombaExplosion) miEntidad;
		b.actuar();
		
	}

	@Override
	public void afectar(Enemigo e) {
		BombaExplosion b = (BombaExplosion) miEntidad;
		b.actuar();
		
	}

	@Override
	public void afectar(Disparo d) {
		
		
		
	}

	public void afectar(ObstaculoTemporal p) {
		
	}

	@Override
	public void afectar(Premio p) {
		
		
	}

	@Override
	public void afectar(Obstaculo o) {
		
	}


}
