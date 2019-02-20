package estructuras;

import java.util.*;

public class GrafoLista<N> implements IGrafo<N> {

	private boolean dirigido;
	private Map<N, Map<N, Arista<N>>> listaAdyacencia;

	public GrafoLista() {
		listaAdyacencia = new HashMap<>();
		dirigido = false;
	}

	public GrafoLista(boolean dirigido) {
		listaAdyacencia = new HashMap<>();
		this.dirigido = dirigido;
		
	}

	@Override
	public boolean esDirigido() {
		return dirigido;
	}

	@Override
	public void agregarVertice(N vertice) {
		if (vertice != null && (!containsVertice(vertice))) {
			listaAdyacencia.put(vertice, new HashMap<>());
		}
	}

	@Override
	public boolean eliminarVertice(N vertice) {

		if (listaAdyacencia.containsKey(vertice)) {
			listaAdyacencia.remove(vertice);
			for (Map<N, Arista<N>> adyacencias : listaAdyacencia.values()) {
				if (adyacencias.containsKey(vertice))
					adyacencias.remove(vertice);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean containsVertice(N vertice) {
		if (listaAdyacencia.containsKey(vertice)) {
			return true;
		}
		return false;
	}

	@Override
	public Set<N> darAdyacentes(N vertice) {
		if (containsVertice(vertice)) {
			return listaAdyacencia.get(vertice).keySet();
		}
		return null;
	}

	@Override
	public Set<N> darVertices() {
		return listaAdyacencia.keySet();
	}
	
	@Override
	public void agregarArista(Arista<N> arista) {
		agregar(arista.getOrigen(), arista.getDestino());
		
		listaAdyacencia.get(arista.getOrigen()).put(arista.getDestino(), arista);
		
		if (!dirigido) {

			Arista<N> temp = new Arista<N>
			(arista.getRelacion(), arista.getPonderacion(), arista.getDestino(), arista.getOrigen());
			listaAdyacencia.get(arista.getDestino()).put(arista.getOrigen(), temp);
			
		}
	}

	private void agregar(N origen, N destino) {
			agregarVertice(origen);
			agregarVertice(destino);
	}

	@Override
	public boolean eliminarArista(N origen, N destino) {

		if (containsVertice(origen) && containsVertice(destino)) {
			listaAdyacencia.get(origen).remove(destino);
			if (!dirigido) {
				listaAdyacencia.get(destino).remove(origen);
			}
			return true;
		}
		return false;
	}

	@Override
	public Double darPonderacion(N origen, N destino) {
		if(listaAdyacencia.get(origen).get(destino)==null){
			return 0.0;
		}
		return listaAdyacencia.get(origen).get(destino).getPonderacion();
	}

	@Override
	public String darRelacion(N origen, N destino) {
		if(listaAdyacencia.get(origen).get(destino)==null){
			return "";
		}
		return listaAdyacencia.get(origen).get(destino).getRelacion();
	}

	@Override
	public boolean existeArista(N origen, N destino) {

		if (containsVertice(origen) && containsVertice(destino)) {
			if (listaAdyacencia.get(origen).containsKey(destino)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arista<N> darArista(N origen, N destino){
		if (existeArista(origen, destino)) {
			return listaAdyacencia.get(origen).get(destino);
		}
		return null;
	}
	@Override
	public ArrayList<Arista<N>> darAristasVertice(N vertice){
		ArrayList<Arista<N>> aristas = new ArrayList<>();
		
		for (Arista<N> a : listaAdyacencia.get(vertice).values()) {
			aristas.add(a);
		}
		
		Collections.sort(aristas);
		return aristas;
	}
	
	@Override
	public ArrayList<Arista<N>> darAristas() {
		ArrayList<Arista<N>> aristas = new ArrayList<>();
		ArrayList<N> contenidos = new ArrayList<>();
		
		for (N nodo : listaAdyacencia.keySet()) {
			
			for (Arista<N> arista : listaAdyacencia.get(nodo).values()) {
				if(dirigido){
					aristas.add(arista);
				}else if(!contenidos.contains(arista.getDestino())){
					aristas.add(arista);
				}
			}
			contenidos.add(nodo);
		}
		Collections.sort(aristas);
		return aristas;
	}
}
