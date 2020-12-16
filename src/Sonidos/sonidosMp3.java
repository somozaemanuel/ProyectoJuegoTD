package Sonidos;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class sonidosMp3 {
	private BasicPlayer player;
	private static boolean reproducir;

	public sonidosMp3() {
		player = new BasicPlayer();
		reproducir = true;
	}

	public void playMp3() {
		try {
			if (reproducir) {
				player.play();
			}
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void abrirArchivo(String url) {
		File fileNAct = new File(this.getClass().getResource("/zMusica/" + url + ".mp3").getPath());
		try {
			if (player.getStatus() == BasicPlayer.PLAYING) {
				player.stop();
			}
			player.open(fileNAct);
			playMp3();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void setReproducir(boolean r) {
		reproducir = r;

	}

	public void pausa() {
		try {
			if (player.getStatus() == BasicPlayer.PAUSED) {
				reproducir = true;
				player.resume();
			} else {
				player.pause();
				reproducir = false;
			}
			if (player.getStatus() == BasicPlayer.OPENED && !reproducir) {
				reproducir = true;
				playMp3();
			}

		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void loop() {
		if (player.getStatus() != BasicPlayer.PLAYING) {
			playMp3();
		}

	}

	public void continuar() {
		try {
			player.resume();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			player.stop();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
}
