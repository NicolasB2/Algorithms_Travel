package metodos;

import java.util.ArrayList;
import java.util.PriorityQueue;

import estructuras.Arista;
import estructuras.ConjuntoDisjunto;
import estructuras.NodoConjuntoDisjunto;
import estructuras.GrafoLista;
import estructuras.IGrafo;

public class ArbolGeneradorMinimo<N> {

	public IGrafo<N> kruskal(IGrafo<N> grafo) {

		IGrafo<N> retorno = new GrafoLista<N>();

		ConjuntoDisjunto<N> d = new ConjuntoDisjunto<>();
		for (N n : grafo.darVertices()) {

			NodoConjuntoDisjunto<N> nd = new NodoConjuntoDisjunto<N>(n);
			d.getDisjointSets().put(n, nd);
			

		}
		for (Arista<N> arista : grafo.darAristas()) {
			if (!d.find(arista.getOrigen()).equals(d.find(arista.getDestino()))) {
				retorno.agregarArista(arista);
				d.union(arista.getOrigen(), arista.getDestino());
			}

		}
		
		ArrayList<N> rep = new ArrayList<N>();
		for (N n : d.getDisjointSets().keySet()) {
			if(!rep.contains(d.find(n))) {
				rep.add(d.find(n)); 				
			}
		}
		
		
		//Prueba de conexividad grafo
//		System.out.println(rep.size());
//		if(rep.size() != 1 ) {
//			System.out.println("INCORRECTO");
//		}else {
//			System.out.println("CORRECTO");
//		}
		return retorno;
	}

	// Tiene que ser no dirigido
	public IGrafo<N> prim(IGrafo<N> grafo, N origen) {

		IGrafo<N> retorno = new GrafoLista<>();
		ArrayList<N> visitados = new ArrayList<>();
		PriorityQueue<Arista<N>> cola = new PriorityQueue<>();

		if (origen != null) {
			for (N n : grafo.darVertices()) {
				retorno.agregarVertice(n);
			}

			int vTotales = grafo.darVertices().size();
			int c = 0;

			visitados.add(origen);

			for (Arista<N> ar : grafo.darAristasVertice(origen)) {
				if (!visitados.contains(ar.getDestino())) {
					cola.add(ar);
				}
			}

			while (!cola.isEmpty() && c < vTotales) {
				Arista<N> arista = cola.poll();

				if (!visitados.contains(arista.getDestino())) {
					
					retorno.agregarArista(arista);
					visitados.add(arista.getDestino());
					c++;
					origen=arista.getDestino();
					
					for (Arista<N> ar : grafo.darAristasVertice(origen)) {
						if (!visitados.contains(ar.getDestino())) {
							cola.add(ar);
						}
					}
				}

			}
			return retorno;
		}

		return null;
	}

}
