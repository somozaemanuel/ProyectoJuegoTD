package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import Entidad.Entidad;
import GUI.GUI;
import Hilo.HiloOleadas;
import Hilo.HiloPrincipal;
import Hilo.HiloSonido;
import Mapa.Mapa;
import Mapa.Nivel;

public class Juego {
	protected int cantMonedas;
	public int vidaJugador;
	protected Mapa map;
	protected int puntaje;
	private HiloPrincipal tiempoPrincipal;
	private HiloOleadas tiempoOleadas;
	private HiloSonido tiempoSonido;
	private Nivel nivel;

	private int multiplicadorOro;

	private GUI gui;
	private LinkedList<Entidad> entidades;
	private LinkedList<Entidad> aEliminar;
	private LinkedList<Entidad> aAgregar;

	private static Juego instance;

	private Juego() {
		vidaJugador = 100;
		cantMonedas = 10000;
		puntaje = 0;
		multiplicadorOro = 1;
	}

	public static Juego getInstance() {
		if (instance == null)
			instance = new Juego();
		return instance;

	}

	public void establecerGrafica(GUI g) {
		if (gui == null)
			gui = g;
	}

	public void iniciarJuego() {

		map = new Mapa();
		nivel = Nivel.getInstance();
		entidades = new LinkedList<Entidad>();
		aAgregar = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();

		LogManager.getLogManager().reset();
		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(java.util.logging.Level.WARNING);

		tiempoPrincipal = HiloPrincipal.getInstace();
		tiempoPrincipal.start();
		tiempoOleadas = HiloOleadas.getInstace();
		tiempoOleadas.start();
		tiempoSonido = HiloSonido.getInstace();
		tiempoSonido.start();

	}

	public synchronized void accionar() {
		if (!entidades.isEmpty()) {
			for (Entidad e1 : entidades) {
				if (!e1.estoyMuerto()) {
					boolean choco = false;
					for (Entidad e2 : entidades) {
						if (e1 != e2 && e1.chocan(e2)) {
							e1.aceptar(e2.getVisitor());
							choco = true;
						}
					}
					if (nivel.getCantEnemigos() > 0)
						e1.accionar();
					if (!choco) {
						e1.setEstado(1);
					}
				} else {
					e1.morir();
					aEliminar.addLast(e1);
				}
			}
		}

		if (!aAgregar.isEmpty()) {
			for (Entidad e : aAgregar) {
				if (e != null) {
					entidades.addFirst(e);
					gui.actualizarEstadisticas(puntaje, cantMonedas, vidaJugador);
					gui.agregarAlJuego(e.getGrafico(0));
				}
			}
			aAgregar = new LinkedList<Entidad>();
		}
		if (!aEliminar.isEmpty()) {
			for (Entidad e : aEliminar) {
				e.setGrafico(2);
				entidades.remove(e);
				cantMonedas = cantMonedas + e.getMonedas() * multiplicadorOro;
				puntaje = puntaje + e.getPuntaje();
				gui.actualizarEstadisticas(puntaje, cantMonedas, vidaJugador);
				gui.eliminarEntidad(e.getGrafico(2));
			}
			aEliminar = new LinkedList<Entidad>();
		}
	}

	public void enemigoMuerto() {
		nivel.sumarEnemigosMuertos();
	}

	public void setMultiplicador(int m) {
		multiplicadorOro = m;
	}

	public synchronized boolean agregarEntidad(Entidad e, boolean agregar) {
		boolean toRet = map.puedoAgregar(e, entidades);
		if (agregar)
			aAgregar.add(e);
		else {
			if (e != null) {
				if (map.puedoAgregar(e, entidades)) {
					aAgregar.add(e);
					cantMonedas -= e.getPrecioPersonaje();
				}

			}
		}
		return toRet;
	}

	public int getCantMonedas() {
		return cantMonedas;
	}

	public void setCantMonedas(int monedas) {
		cantMonedas = monedas;
	}

	public int getPuntaje() {
		return cantMonedas;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public synchronized LinkedList<Entidad> getEntidades() {
		return entidades;
	}

	public void setVida(int i, boolean sumar) {
		if (vidaJugador < 100 && sumar) {
			vidaJugador += i;
			if (vidaJugador > 100) {
				vidaJugador = 100;
			}
		} else {
			if (vidaJugador > 0 && !sumar) {
				vidaJugador -= i;
				if (vidaJugador <= 0) {
					this.terminarJuego(false);
				}
			}
		}
	}

	public void terminarJuego(boolean gane) {
		tiempoPrincipal.setEjecutar(false);
		tiempoOleadas.setEjecutar(false);
		tiempoSonido.setEjecutar(false);
		tiempoSonido.stopSoudtrack();
		aAgregar = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
		entidades = new LinkedList<Entidad>();
		if (!gane) {
			gui.perder();
		} else {
			gui.ganar();
		}
	}

	public synchronized void clickEnEntidades(Point punto) {
		for (Entidad e : entidades) {
			if (e.getRectangle().contains(punto))
				e.fuisteClickeado();
		}

	}

	public synchronized boolean clickEnJugadores(Point punto) {
		boolean toRet = false;
		for (Entidad e : entidades)
			if (e.getRectangle().contains(punto)) {
				if (e.addCampo())
					toRet = true;
			}
		return toRet;
	}

}
