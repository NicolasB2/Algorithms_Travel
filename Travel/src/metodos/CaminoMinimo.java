package metodos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import estructuras.Arista;
import estructuras.IGrafo;

public class CaminoMinimo<N> {

	/**
	 * 
	 * @param grafo
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public ArrayList<Arista<N>> dijkstra(IGrafo<N> grafo, N inicio, N fin) {

		//se verifica que el grafo contenga los vertices de l parametro
		if (!grafo.containsVertice(inicio) || !grafo.containsVertice(fin)) {
			return null;
		}

		//una hash con el retice "N" como key y la distancia que tiene al inicio
		HashMap<N, Double> distancias = new HashMap<>();
		//cola de prioridad con aristas, la mayor prioridad es la arista con menor ponderacion
		PriorityQueue<Arista<N>> cola = new PriorityQueue<>();
		//hash que contiene la arista por la cual se llega a la key
		//ej:A-->B-->C-->D
		//camino.get(C) = Arista con origen B y destino C
		HashMap<N, Arista<N>> camino = new HashMap<>();
		//arraylist que contine las aristas que componen el camino mas corto de inicio a fin
		ArrayList<N> visitados = new ArrayList<>();

		//for que llena el hash de distancias con infinitos
		for (N nodo : grafo.darVertices()) {
			distancias.put(nodo, Double.MAX_VALUE);
			camino.put(nodo, null);
		}
		
		//al nodo de inicio se le pone distancia 0
		distancias.put(inicio, 0.0);

		//for que llena la cola de prioridad con las aristas adyacentes al vertice de inicio
		for (Arista<N> arista : grafo.darAristasVertice(inicio)) {
			Arista<N> temp = new Arista<>(arista.getPonderacion(), arista.getOrigen(), arista.getDestino());
			cola.add(temp);
		}

		distancias.put(inicio, 0.0);
		visitados.add(inicio);

		while (!cola.isEmpty()) {
			
			//se saca la arista de menor ponderacion de la cola 
			Arista<N> arista = cola.poll();
			
			//si la distancia de la arista "arista" es menor a la distancia almacenada en el hash entra al if
			if (distancias.get(arista.getDestino()) > arista.getPonderacion()) {
				
				//actualiza la distancia de la hash pos la distancia de la arista arista
				distancias.put(arista.getDestino(), arista.getPonderacion());
				//agrega al hash de caminos la arista "arista"
				camino.put(arista.getDestino(), grafo.darArista(arista.getOrigen(), arista.getDestino()));
				
				//se aagragan  la cola las aristas adyacentes al destino de la arista "Arista"
				for (Arista<N> ari : grafo.darAristasVertice(arista.getDestino())) {
					
						//la arista "temp" es una arista que contiene la ponderacion total desde el inicio hasta en vertice actual
						//NOTA: el vertice actual es el destino de "arista"
						Arista<N> temp = new Arista<>(ari.getPonderacion() + arista.getPonderacion(), ari.getOrigen(),
								ari.getDestino());
						cola.add(temp);
						visitados.add(ari.getDestino());
				}
			}
		}

		N temp = fin;
		
		//"retorno" es el arraylist que contiene las aristas que comforman el camino mas corto 
		ArrayList<Arista<N>> retorno = new ArrayList<>();
		
		//while que itera todos los vertices de la hash de camino
		while (temp != inicio) {
			
			//"aux" es la arista que esta en la hash de cammino correspondiente al vertice temp
			//ej:A-->B-->C-->D
			//si "temp" es C,  "aux" es una arista con origen B y destino C
			Arista<N> aux = camino.get(temp);
			
			//se actualizael vertice temp por el origen del vertice "aux"
			temp = aux.getOrigen();
			retorno.add(aux);
		}
		
		//NOTA: el arraylist empieza con el fin y termina en inicio
		//EJ:A-->B-->C-->D
		//Dijkstra(A,D)----> retorna:
		//D,C,B,A
		return retorno;
	}
//	/**
//	 * 
//	 * @param grafo
//	 * @return
//	 */
//	public double[][] floydWarshall(IGrafo<N> grafo){
//		Set<N> nodos=grafo.darVertices();
//		double[][] pesos = new double[nodos.size()][nodos.size()];
//		llenarMatriz(pesos, grafo);
//		return floyd(pesos);
//	}
	/**
	 * 
	 * @param matrizDistancias
	 * @return
	 */
	public double[][] floyd(double[][] matrizDistancias) {

		int INF = Integer.MAX_VALUE;
		
		double distancia[][] = new double[matrizDistancias.length][matrizDistancias.length];
		double camino[][] = new double[matrizDistancias.length][matrizDistancias.length];

		for (int i = 0; i < matrizDistancias.length; i++) {
			for (int j = 0; j < matrizDistancias[i].length; j++) {
				distancia[i][j] = matrizDistancias[i][j];
				if (matrizDistancias[i][j] != INF && i != j) {
					camino[i][j] = i;
				} else {
					camino[i][j] = -1;
				}
			}
		}

		for (int k = 0; k < matrizDistancias.length; k++) {
			for (int i = 0; i < matrizDistancias.length; i++) {
				for (int j = 0; j < matrizDistancias.length; j++) {
					if (distancia[i][k] == INF || distancia[k][j] == INF) {
						continue;
					}
					if (distancia[i][j] > distancia[i][k] + distancia[k][j]) {
						distancia[i][j] = distancia[i][k] + distancia[k][j];
						camino[i][j] = camino[k][j];
					}
				}
			}
		}

		return distancia;
	}

//	/**
//	 * 
//	 * @param pesos
//	 * @param grafo
//	 */
//	public void llenarMatriz(double[][] pesos, IGrafo<N> grafo) {
//
//		int INF = Integer.MAX_VALUE;
//
//		Set<N> datos = grafo.darVertices();
//		int i = 0;
//		int j = 0;
//		
//		for (N n1 : datos) {
//
//			for (N n2 : datos) {
//				double peso = grafo.darPonderacion(n2, n2);
//				if (peso == 0) {
//					peso = INF;
//				}
//				pesos[i][j] = peso;
//				j++;
//			}
//			i++;
//			j=0;
//		}
//
//		for (i = 0; i < pesos.length; j++) {
//			pesos[i][i] = 0;
//		}
//
//	}
}
