package GUI;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import Entidad.Entidad;
import Hilo.HiloSonido;
import Juego.Juego;
import PowerUps.BombaExplosion;
import Sonidos.sonidosMp3;
import Tienda.Boton;
import Tienda.BotonComprar;
import Tienda.BotonLava;
import Tienda.BotonMuralla;
import Tienda.BotonSiguiente;
import Tienda.BotonT1;
import Tienda.BotonT2;
import Tienda.BotonT3;
import Tienda.BotonT4;
import Tienda.BotonT5;
import Tienda.TiendaJuego;
import TiendaPersonaje.*;

/**
 * Clase GUI .
 * 
 * @author Aldana Case(104870),Biernat Diego (105974) , Emanuel Somoza (112100).
 *
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame frameInicio, frameJuego, frameFinal;
	private JLayeredPane panel, panelPrincipal, panelJuego, panelTorres, panelJugador;
	private Juego j;
	private TiendaJuego tienda;
	private sonidosMp3 mp3;
	private HiloSonido h;
	private JLabel fondo;
	private JLabel fondo2;
	private JLabel fondo3;
	private JLabel Monedas;
	private JLabel Puntaje;
	private JLabel imagenganeButton;
	private JLabel vidaJugador;
	private boolean listenerCampoActivado;
	private boolean listenerBombaActivada;
	private LinkedList<JButton> botones;
	private boolean listenerMovimientoMouse;
	private java.awt.Font font;
	private JButton startButton;
	private JButton botonSonido;
	private JButton botonInstrucciones;
	private static GUI instance;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = GUI.getInstance();
					window.frameInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static GUI getInstance() {
		if (instance == null)
			instance = new GUI();
		return instance;

	}

	private GUI() {
		iniciar();
	}

	private void iniciar() {
		frameInicio = new JFrame();
		frameInicio.setBounds(0, 0, 800, 600);
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);
		frameInicio.setLocationRelativeTo(null);
		frameInicio.setResizable(false);
		frameInicio.setTitle("Proyecto de TDP 2019");
		frameInicio.setVisible(true);
		panel = new JLayeredPane();
		frameInicio.setContentPane(panel);

		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Fondo.png")));
		fondo.setSize(800, 570);
		frameInicio.add(fondo, -1);

		startButton = new JButton("Start");
		startButton.setBounds(300, 200, 180, 70);
		startButton.setForeground(new java.awt.Color(155, 017, 030));
		startButton.setBackground(new java.awt.Color(0, 0, 0));
		startButton.setIcon(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Play.png")));
		startButton.setMargin(new Insets(1, 36, -1, -1));
		startButton.setFont(new java.awt.Font("cambria", 15, 50));
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(true);
		frameInicio.add(startButton, 0);

		botonInstrucciones = new JButton("Instrucciones");
		botonInstrucciones.setBounds(300, 300, 180, 70);
		botonInstrucciones.setForeground(new java.awt.Color(155, 017, 030));
		botonInstrucciones.setBackground(new java.awt.Color(0, 0, 0));
		botonInstrucciones.setIcon(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Instrucciones.png")));
		botonInstrucciones.setMargin(new Insets(1, 36, -1, -1));
		botonInstrucciones.setFont(new java.awt.Font("cambria", 15, 50));
		botonInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		botonInstrucciones.setFocusPainted(false);
		botonInstrucciones.setBorderPainted(true);
		frameInicio.add(botonInstrucciones, 0);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameInicio.dispose();
				iniciarJuego();
				h = HiloSonido.getInstace();
				try {

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});

		botonInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(this.getClass().getResource("/zNiveles/Mapa/InstruccionesJuego.txt").getPath());
				try {
					java.awt.Desktop.getDesktop().open(file);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
	}

	public void iniciarJuego() {

		frameJuego = new JFrame();
		frameJuego.setBounds(0, 0, 1200, 720);
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.setLocationRelativeTo(null);
		frameJuego.setLayout(null);
		frameJuego.setResizable(false);
		frameJuego.setTitle("Proyecto de TDP 2019");
		frameJuego.setVisible(true);

		File fontFile = new File(this.getClass().getResource("/zImagenes/Mapa/Minecrafter.Alt.ttf").getPath());
		try {
			font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fontFile);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		listenerMovimientoMouse = false;

		panelPrincipal = new JLayeredPane();
		panelPrincipal.setBounds(0, 0, 1200, 700);
		panelPrincipal.setLayout(null);

		panelTorres = new JLayeredPane();
		panelTorres.setBounds(1000, 0, 200, 700);

		panelJugador = new JLayeredPane();
		panelJugador.setBounds(0, 600, 1000, 120);

		panelJuego = new JLayeredPane();
		panelJuego.setBounds(0, 0, 1000, 600);

		fondo = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/FondoTorres.png")));
		fondo.setBounds(0, 0, 200, 700);

		fondo2 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/FondoJugadorFinal.png")));
		fondo2.setBounds(0, 0, 1000, 120);

		fondo3 = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Path.png")));
		fondo3.setBounds(0, 0, 1000, 600);

		Puntaje = new JLabel("Puntaje : 0");
		Puntaje.setBounds(0, 15, 200, 50);
		Puntaje.setBackground(new java.awt.Color(255, 215, 0));
		Puntaje.setForeground(new java.awt.Color(255, 255, 255));
		Puntaje.setFont(font.deriveFont(20f));
		Puntaje.setVisible(true);

		Monedas = new JLabel("Monedas : 10000");
		Monedas.setBounds(0, -10, 200, 50);
		Monedas.setForeground(new java.awt.Color(255, 215, 0));
		Monedas.setBackground(new java.awt.Color(255, 215, 0));
		Monedas.setFont(font.deriveFont(20f));
		Monedas.setVisible(true);

		vidaJugador = new JLabel("Vida : 100");
		vidaJugador.setBounds(0, 40, 200, 50);
		vidaJugador.setForeground(new java.awt.Color(255, 0, 0));
		vidaJugador.setBackground(new java.awt.Color(255, 0, 0));
		vidaJugador.setFont(font.deriveFont(20f));
		vidaJugador.setVisible(true);

		botonSonido = new JButton("Sonido");
		botonSonido.setBounds(820, 0, 180, 50);
		botonSonido.setForeground(new java.awt.Color(155, 017, 030));
		botonSonido.setBackground(new java.awt.Color(0, 0, 0));
		botonSonido.setFont(new java.awt.Font("cambria", 10, 20));
		botonSonido.setIcon(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/Sonido.png")));
		botonSonido.setMargin(new Insets(1, 18, -1, -1));
		botonSonido.setHorizontalAlignment(SwingConstants.CENTER);
		botonSonido.setFocusPainted(false);
		botonSonido.setBorderPainted(true);

		botonSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mp3 = h.getSoudtrack();
				mp3.pausa();
			}
		});

		panelJugador.add(Puntaje, 0);
		panelJugador.add(Monedas, 0);
		panelJugador.add(vidaJugador, 0);
		panelTorres.add(fondo, -1);
		panelJugador.add(fondo2, -1);
		panelJuego.add(fondo3, -1);
		panelJugador.add(botonSonido, 0);

		frameJuego.setContentPane(panelPrincipal);
		panelPrincipal.add(panelTorres);
		panelPrincipal.add(panelJugador);
		panelPrincipal.add(panelJuego);

		panelJuego.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				j.clickEnEntidades(new Point(x, y));
			}
		});

		j = Juego.getInstance();
		j.establecerGrafica(this);
		j.iniciarJuego();

		tienda = TiendaJuego.getInstance();
		crearBotones();

		panelJuego.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (listenerCampoActivado) {
					int x = e.getX();
					int y = e.getY();
					Point nuevoPunto = new Point(x, y);
					boolean inserte = j.clickEnJugadores(nuevoPunto);
					if (inserte) {
						CProteccion.getInstance().restarContador();
						triggerBotones2();
						listenerCampoActivado = false;
						CProteccion.getInstance().estadoCampo(1);
						BombaBoton.getInstance().setEnabled(true);
						CProteccion.getInstance().siguienteGrafico();

					}

				}

			}
		});

		panelJuego.addMouseMotionListener(new MouseInputAdapter() {
			public void mouseMoved(MouseEvent e) {
				if (listenerMovimientoMouse) {
					int x = e.getX();
					int y = e.getY();
					if (!(((y <= 570 && y >= 540) || (y <= 365 && y >= 335) || (y <= 175 && y >= 145)) && x <= 500)) {
						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Image image = new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/CursorForbidden2.png"))
								.getImage();
						Cursor c = toolkit.createCustomCursor(image, new Point(16, 16), "img");
						frameJuego.setCursor(c);
					} else
						frameJuego.setCursor(Cursor.CROSSHAIR_CURSOR);
				} else
					frameJuego.setCursor(Cursor.DEFAULT_CURSOR);

			}
		});

	}

	public void agregarBomba(BombaExplosion b) {
		listenerMovimientoMouse = true;

		panelJuego.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (((y <= 570 && y >= 540) || (y <= 365 && y >= 335) || (y <= 175 && y >= 145)) && x <= 500) {
					if (listenerBombaActivada) {
						Point punto = new Point(x - 42, y - 42);
						b.setPosition(punto);
						j.agregarEntidad(b, true);
						listenerBombaActivada = false;
						triggerBotones2();
						BombaBoton.getInstance().restarContador();
						BombaBoton.getInstance().siguienteGrafico();
						BombaBoton.getInstance().estadoBomba(1);
						panelJuego.removeMouseListener(this);
						CProteccion.getInstance().setEnabled(true);
						listenerMovimientoMouse = false;

					}

				}

			}
		});

	}

	public void agregarTorre(Entidad ste) {

		listenerMovimientoMouse = true;

		panelJuego.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (((y <= 570 && y >= 540) || (y <= 365 && y >= 335) || (y <= 175 && y >= 145)) && x <= 500) {
					tienda.agregarEntidad(x, y);
					frameJuego.setCursor(Cursor.getDefaultCursor());
					panelJuego.removeMouseListener(this);
					BombaBoton.getInstance().habilitarBoton();
					CProteccion.getInstance().habilitarBoton();
					listenerMovimientoMouse = false;
				}
			}
		});

	}

	public void crearBotones() {

		botones = new LinkedList<>();

		Boton torre1 = new BotonT1(tienda, this);
		Boton torre2 = new BotonT2(tienda, this);
		Boton torre3 = new BotonT3(tienda, this);
		Boton torre4 = new BotonT4(tienda, this);
		Boton torre5 = new BotonT5(tienda, this);
		Boton Comprar = new BotonComprar(tienda, this);
		Boton lavaBoton = new BotonLava(tienda, this);
		Boton murallaBoton = new BotonMuralla(tienda, this);
		Boton siguienteBoton = new BotonSiguiente(tienda, this);

		BotonPwup pwup1 = CProteccion.getInstance();
		BotonPwup pwup2 = BombaBoton.getInstance();
		BotonPwup pwup3 = FDuplicada.getInstance();
		BotonPwup pwup4 = Temp.getInstance();
		BotonPwup pwup5 = VelocidadDuplicada.getInstance();

		agregarBotones(Comprar);
		agregarBotones(torre1);
		agregarBotones(torre2);
		agregarBotones(torre3);
		agregarBotones(torre4);
		agregarBotones(torre5);
		agregarBotones(lavaBoton);
		agregarBotones(siguienteBoton);
		agregarBotones(murallaBoton);

		panelJugador.add(pwup1, 1);
		panelJugador.add(pwup2, 1);
		panelJugador.add(pwup3, 1);
		panelJugador.add(pwup4, 1);
		panelJugador.add(pwup5, 1);

	}

	public void triggerBotones2() {
		botones.getFirst().setEnabled(true);
		listenerMovimientoMouse=false;

	}

	public void triggerBotones() {
		for (JButton b : botones)
			b.setEnabled(false);
	}

	public void agregarAlJuego(JLabel j) {
		if (j != null)
			panelJuego.add(j, 0);
	}

	public void eliminarEntidad(JLabel grafico) {
		panelJuego.repaint();
		Timer timer = new Timer(4000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelJuego.remove(grafico);
				panelJuego.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();

	}

	public void agregarBotones(JButton B) {
		panelTorres.add(B, 0);
		botones.add(B);
	}

	public void actualizarEstadisticas(int puntaje, int cantMonedas, int vidaActual) {
		Puntaje.setText("Puntaje : " + puntaje);
		Monedas.setText("Monedas : " + cantMonedas);
		vidaJugador.setText("Vida : " + vidaActual);

	}

	public void perder() {
		crearFrameFinal();

		imagenganeButton = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/gameOver.png")));
		imagenganeButton.setBounds(0, 0, 640, 480);
		frameFinal.add(imagenganeButton, 0);
		frameFinal.setTitle("Perdiste");
		frameFinal.setVisible(true);

		mp3 = new sonidosMp3();
		mp3.abrirArchivo("SadViolin");

	}

	public void ganar() {
		crearFrameFinal();

		imagenganeButton = new JLabel(new ImageIcon(this.getClass().getResource("/zImagenes/Mapa/youWin.jpg")));
		imagenganeButton.setBounds(0, 0, 600, 600);
		frameFinal.setTitle("Ganaste");
		frameFinal.setVisible(true);
		frameFinal.add(imagenganeButton, 0);

		mp3 = new sonidosMp3();
		mp3.abrirArchivo("smokeEvd");
	}

	private void crearFrameFinal() {
		frameJuego.dispose();
		frameFinal = new JFrame();
		frameFinal.setBounds(0, 0, 640, 600);
		frameFinal.getContentPane().setBackground(Color.BLACK);
		frameFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFinal.setLocationRelativeTo(null);
		frameFinal.setLayout(null);
		frameFinal.setResizable(false);

	}

	public void setCampoActivado(boolean valor) {
		listenerCampoActivado = valor;
	}

	public void setBombaActivada(boolean valor) {
		listenerBombaActivada = valor;
	}
}
