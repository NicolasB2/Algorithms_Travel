package estructuras;

import java.util.*;

public class GrafoMatriz<N> implements IGrafo<N> {

	private boolean dirigido;
	private Arista<N>[][] matrizAdyacencia;
	private Map<N, Integer> indices; // posición en la que está en la matriz
	private Stack<Integer> espacio;

	public GrafoMatriz() {
		espacio = new Stack<>();
		dirigido = false;
		matrizAdyacencia = new Arista[100][100];
		indices = new Hashtable<>();
		for (int i = matrizAdyacencia.length; i > 0; i--) {
			espacio.push(i);
		}
	}

	public GrafoMatriz(boolean dirigido) {
		espacio = new Stack<>();
		this.dirigido = dirigido;
		matrizAdyacencia = new Arista[100][100];
		indices = new Hashtable<>();
		for (int i = matrizAdyacencia.length - 1; i > -1; i--) {
			espacio.push(i);
		}
	}

	@Override
	public boolean esDirigido() {
		return dirigido;
	}

	@Override
	public void agregarVertice(N vertice) {

		if (vertice != null && !indices.containsKey(vertice)) {
			if (espacio.peek() == matrizAdyacencia[0].length - 1) {
				matrizAdyacencia = volcado();
			}
			indices.put(vertice, espacio.pop());
		}
	}

	private Arista<N>[][] volcado() {
		Arista<N>[][] matrizAuxiliar = new Arista[matrizAdyacencia[0].length * 2][matrizAdyacencia[0].length * 2];

		for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAuxiliar[0].length; j++) {
				matrizAuxiliar[i][j] = matrizAdyacencia[i][j];
			}
		}

		return matrizAuxiliar;
	}

	@Override
	public boolean eliminarVertice(N vertice) {

		if (indices.containsKey(vertice)) {
			int valor = indices.get(vertice);
			indices.remove(vertice);

			for (int i = 0; i < matrizAdyacencia.length; i++) {
				matrizAdyacencia[valor][i] = null;
				matrizAdyacencia[i][valor] = null;
			}
			espacio.push(valor);

			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean containsVertice(N vertice) {
		if (vertice != null) {
			return indices.containsKey(vertice);
		}
		return false;
	}

	@Override
	public Set<N> darAdyacentes(N vertice) {
		Set<N> salida = new HashSet<>();

		if (indices.containsKey(vertice)) {
			int pos = indices.get(vertice);
			for (int i = 0; i < matrizAdyacencia.length; i++) {
				if (matrizAdyacencia[pos][i] != null) {
					salida.add((N) matrizAdyacencia[pos][i].getDestino());
				}
			}
		}

		return salida;
	}

	@Override
	public Set<N> darVertices() {
		return indices.keySet();
	}

	@Override
	public void agregarArista(Arista<N> arista) {
		agregar(arista.getOrigen(), arista.getDestino());
		matrizAdyacencia[indices.get(arista.getOrigen())][indices.get(arista.getDestino())] = arista;

		if (!dirigido) {
			Arista<N> temp = new Arista<N>(arista.getRelacion(), arista.getPonderacion(), arista.getDestino(),
					arista.getOrigen());
			matrizAdyacencia[indices.get(temp.getOrigen())][indices.get(temp.getDestino())] = temp;
		}
	}

	private void agregar(N origen, N destino) {
		agregarVertice(origen);
		agregarVertice(destino);
	}

	// revisar
	@Override
	public boolean eliminarArista(N origen, N destino) {

		if (indices.containsKey(origen) && indices.containsKey(destino)) {
			Integer posOrigen = indices.get(origen);
			Integer posDestino = indices.get(destino);

			if (matrizAdyacencia[posOrigen][posDestino] == null) {
				return false;
			} else {
				matrizAdyacencia[posOrigen][posDestino] = null;
				if (!dirigido) {
					matrizAdyacencia[posDestino][posOrigen] = null;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public Double darPonderacion(N origen, N destino) {
		if (indices.containsKey(origen) && indices.containsKey(destino)) {

			Arista<N> retorno = matrizAdyacencia[indices.get(origen)][indices.get(destino)];
			if(retorno!=null){
				return retorno.getPonderacion();
			}
		}
		return 0.0;
	}

	@Override
	public String darRelacion(N origen, N destino) {
		if (indices.containsKey(origen) && indices.containsKey(destino)) {
			Arista<N> retorno = matrizAdyacencia[indices.get(origen)][indices.get(destino)];
			if(retorno!=null){
				return retorno.getRelacion();
			}
		}
		return "";
	}

	@Override
	public boolean existeArista(N origen, N destino) {
		if (indices.containsKey(origen) && indices.containsKey(destino)) {
			if (matrizAdyacencia[indices.get(origen)][indices.get(destino)] != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arista<N> darArista(N origen, N destino) {
		if (existeArista(origen, destino)) {
			return matrizAdyacencia[indices.get(origen)][indices.get(destino)];
		}
		return null;
	}

	@Override
	public ArrayList<Arista<N>> darAristasVertice(N vertice) {
		int indice = indices.get(vertice);
		ArrayList<Arista<N>> aristas = new ArrayList<>();
		for (int i = 0; i < matrizAdyacencia.length; i++) {
			Arista<N> aris = matrizAdyacencia[indice][i];
			if (aris != null) {
				aristas.add(aris);
			}

		}
		Collections.sort(aristas);

		return aristas;
	}

	@Override
	public ArrayList<Arista<N>> darAristas() {
		ArrayList<Arista<N>> aristas = new ArrayList<>();

		for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAdyacencia.length; j++) {
				Arista<N> arista = matrizAdyacencia[i][j];
				if (arista != null) {
					aristas.add(arista);
				}

			}
		}
		Collections.sort(aristas);

		return aristas;
	}

}
