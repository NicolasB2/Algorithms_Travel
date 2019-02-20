package modelo;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import estructuras.Arista;
import estructuras.IGrafo;

public class Mapa {

	public static void cargarPrimeraVez(IGrafo<Nodo> lugar, HashMap<String, Nodo> diccionario, String ruta)
			throws IOException {
		File archivo = new File(ruta);
		if (archivo.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			
			if (!linea.equals("#")) {

				int cantVertices = Integer.parseInt(linea);

				for (int j = 0; j < cantVertices; j++) {
					linea = br.readLine();
					String[] nodo = linea.split(";");
					Point p = new Point(Integer.parseInt(nodo[1]), Integer.parseInt(nodo[2]));
					Nodo v = new Nodo(p, nodo[0]);
					diccionario.put(nodo[0], v);
					lugar.agregarVertice(v);
				}
			} else {

				linea = br.readLine();
				int cantVertices = Integer.parseInt(linea);
				for (int j = 0; j < cantVertices; j++) {
					linea = br.readLine();
					String[] nodo = linea.split(";");
					Point p = new Point(Integer.parseInt(nodo[2]), Integer.parseInt(nodo[3]));
					Nodo v = new Nodo(p, nodo[0], nodo[1]);
					diccionario.put(nodo[0], v);
					lugar.agregarVertice(v);
				}

			}

			linea = br.readLine();
			int cantAristas = Integer.parseInt(linea);

			for (int j = 0; j < cantAristas; j++) {
				linea = br.readLine();
				String[] lectura = linea.split(";");

				Arista<Nodo> arista = new Arista<Nodo>(Double.parseDouble(lectura[2]), diccionario.get(lectura[0]),
						diccionario.get(lectura[1]));
				lugar.agregarArista(arista);
			}

			br.close();
		}
	}

}
