package TiendaPersonaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.GUI;

public abstract class BotonPwup extends JButton {

	private static final long serialVersionUID = 1L;

	protected int contadorPremio;
	protected boolean cooldown;
	protected ImageIcon[] graficosBotones;
	protected int indexGraficos;

	protected BotonPwup(GUI gui) {
		contadorPremio = 0;
		cooldown = false;
		indexGraficos = 0;
		this.setVisible(true);
		this.setLayout(null);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionarBoton();
			}
		});
	}

	public void habilitarBoton() {
		if (contadorPremio > 0)
			this.setEnabled(true);
	}

	public void siguienteGrafico() {
		indexGraficos++;
		if (indexGraficos == graficosBotones.length)
			indexGraficos = 0;
		this.setIcon(graficosBotones[indexGraficos]);
	}

	public int getContador() {
		return contadorPremio;

	}

	public void setCooldown(boolean c) {
		cooldown = c;
	}

	public synchronized void sumarContador() {
		contadorPremio++;
		if (!cooldown)
			setEnabled(true);

	}

	public void restarContador() {
		contadorPremio--;

		if (contadorPremio <= 0)
			this.setEnabled(false);
		else
			this.setEnabled(true);

	}

	protected abstract void accionarBoton();

	protected abstract ImageIcon getIconoBoton();
}
