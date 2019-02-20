package estructuras;

import java.util.HashMap;
import java.util.Map;

public final class ConjuntoDisjunto<E> {

	private Map<E, NodoConjuntoDisjunto<E>> disjointSets = new HashMap<E, NodoConjuntoDisjunto<E>>();

	public E find(E e) {
		NodoConjuntoDisjunto<E> node = find(getNodo(e));

		if (node == node.getRepresentante()) {
			return node.getElemento();
		}
		node.setRepresentante(find(node.getRepresentante()));
		return node.getRepresentante().getElemento();
	}

	private NodoConjuntoDisjunto<E> find(NodoConjuntoDisjunto<E> nodo) {
		if (nodo == nodo.getRepresentante()) {
			return nodo;
		}
		return find(nodo.getRepresentante());
	}

	public void union(E e1, E e2) {
		NodoConjuntoDisjunto<E> e1Raiz = find(getNodo(e1));
		NodoConjuntoDisjunto<E> e2Raiz = find(getNodo(e2));

		if (e1Raiz == e2Raiz) {
			return;
		}

		int comparison = e1Raiz.compareTo(e2Raiz);
		if (comparison < 0) {
			e1Raiz.setRepresentante(e2Raiz);
		} else if (comparison > 0) {
			e2Raiz.setRepresentante(e1Raiz);
		} else {
			e2Raiz.setRepresentante(e1Raiz);
			e1Raiz.incrementarRango();
		}
	}

	private NodoConjuntoDisjunto<E> getNodo(E e) {
		NodoConjuntoDisjunto<E> node = disjointSets.get(e);

		if (node == null) {
			node = new NodoConjuntoDisjunto<E>(e);
			disjointSets.put(e, node);
		}

		return node;
	}

	public Map<E, NodoConjuntoDisjunto<E>> getDisjointSets() {
		return disjointSets;
	}

}
