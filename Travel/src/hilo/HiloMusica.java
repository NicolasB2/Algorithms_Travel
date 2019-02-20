package hilo;

import javazoom.jl.player.Player;
import modelo.Mundo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class HiloMusica extends Thread {

	public static Player player;
	public static Mundo mundo;
	public static File file;

	public HiloMusica(Mundo m) {
		mundo = m;

	}

	public void setPais(String pais) {
		file = new File("./recursos/musica/" + pais + ".mp3");
	}

	@Override
	public void run() {
		try {
			File file = new File("./recursos/musica/" + mundo.getPaisActual() + ".mp3");
			FileInputStream ruta = new FileInputStream(file.getAbsolutePath());
			BufferedInputStream br = new BufferedInputStream(ruta);

			while (mundo.getEstado().equals(Mundo.PAISES)) {
				player = new Player(br);
				player.play();
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
		super.run();
	}

	public void detener() {
		player.close();
	}
}
