package Tienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Entidad.Entidad;
import GUI.GUI;
import TiendaPersonaje.BombaBoton;
import TiendaPersonaje.CProteccion;

public abstract class Boton extends JButton{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos 
	protected TiendaJuego tienda;
	private GUI gui;

	//Constructor
	protected Boton(TiendaJuego tienda,GUI gui) {
		this.tienda = tienda;
		this.gui=gui;
		this.setIcon(this.getIconoBoton());
		this.setFont(new java.awt.Font("cambria", 12, 33));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setContentAreaFilled( false );		
		this.setVisible(true);
		this.setLayout(null);
		this.setFocusable(false);
		this.tienda.setBoton(this);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionarBoton();
			}
		});
	}
	
	//Preguntar si es correcto dejarlo protected para poder redefinirlo(no tendria sentido dejarlo privado)?¡
	protected void accionarBoton() {
		BombaBoton.getInstance().setEnabled(false);
		CProteccion.getInstance().setEnabled(false);
		Entidad toAdd = this.crearEntidad();
		if(this.tienda.puedoAgregar(toAdd)){
			this.agregar(toAdd);
			gui.agregarTorre(toAdd);
			for (JButton b : tienda.getBoton()) {
				if (b.isEnabled())
					b.setEnabled(false);
				else {
					b.setEnabled(true);
				}
			}
		}
	}
	
	private void agregar(Entidad toAdd) {
		this.tienda.setNextToAdd(toAdd);;
	}
	
	protected abstract ImageIcon getIconoBoton();
	protected abstract Entidad crearEntidad();
}
