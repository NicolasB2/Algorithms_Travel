package metodos;

import java.util.*;
import estructuras.IGrafo;

public class Recorridos<N>{
	
	public ArrayList<N> bfs(IGrafo<N> grafo, N s) {
		HashMap<N, Boolean> estado = new HashMap<>();
		Queue<N> cola = new LinkedList<>();
		ArrayList<N> devolver = new ArrayList<N>();

		estado.put(s, false);
		cola.add(s);

		while (!cola.isEmpty()) {
			N u = cola.poll();
			devolver.add(u);

			for (N n : grafo.darAdyacentes(u)) {

				if (!estado.containsKey(n)) {
					estado.put(n, false);
					cola.add(n);

				}
			}

			estado.replace(u, true);
		}
		return devolver;
	}

	public ArrayList<N> dfs(IGrafo<N> grafo, N s) {
		HashMap<N, Boolean> estado = new HashMap<>();
		Stack<N> pila = new Stack<>();
		ArrayList<N> devolver = new ArrayList<N>();

		estado.put(s, false);
		pila.push(s);

		while (!pila.isEmpty()) {

			N v = pila.pop();
			devolver.add(v);

			for (N n : grafo.darAdyacentes(v)) {
				if (!estado.containsKey(n)) {
					estado.put(n, false);

					pila.push(n);
				}
			}
			estado.replace(v, true);
		}
		return devolver;
	}

	
}
