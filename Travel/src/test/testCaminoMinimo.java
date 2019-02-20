package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import estructuras.Arista;
import estructuras.GrafoLista;
import estructuras.GrafoMatriz;
import estructuras.IGrafo;
import metodos.CaminoMinimo;

public class testCaminoMinimo {

	private static final double INF = Double.POSITIVE_INFINITY;

	private String inicio, fin;
	private CaminoMinimo<String> cmin;
	private ArrayList<Arista<String>> camino;
	private ArrayList<String> caminoEsperado, caminoOriginal;
	private int total;
	private double[][] mInicial, mEsperada;

	public void setUpEscenario1(IGrafo<String> grafo) {
		cmin = new CaminoMinimo<>();
		camino = new ArrayList<>();
		caminoEsperado = new ArrayList<>();
		total = 0;
		inicio = "A";
		fin = "D";

		grafo.agregarArista(new Arista<String>(7.0, inicio, "B"));
		grafo.agregarArista(new Arista<String>(10.0, inicio, "C"));
		grafo.agregarArista(new Arista<String>(2.0, "B", "C"));
		grafo.agregarArista(new Arista<String>(4.0, "C", "D"));

		caminoEsperado.add("A");
		caminoEsperado.add("B");
		caminoEsperado.add("C");
		caminoEsperado.add("D");
	}

	public void setUpEscenario2(IGrafo<String> grafo) {
		cmin = new CaminoMinimo<>();
		camino = new ArrayList<>();
		caminoEsperado = new ArrayList<>();
		total = 0;
		inicio = "A";
		fin = "E";

		grafo.agregarArista(new Arista<String>(8.0, inicio, "B"));
		grafo.agregarArista(new Arista<String>(3.0, inicio, "D"));
		grafo.agregarArista(new Arista<String>(2.0, "D", "B"));
		grafo.agregarArista(new Arista<String>(5.0, "B", "C"));
		grafo.agregarArista(new Arista<String>(4.0, "C", fin));
		grafo.agregarArista(new Arista<String>(2.0, "C", "G"));
		grafo.agregarArista(new Arista<String>(8.0, "G", "F"));
		grafo.agregarArista(new Arista<String>(1.0, "F", fin));

		caminoEsperado.add("A");
		caminoEsperado.add("D");
		caminoEsperado.add("B");
		caminoEsperado.add("C");
		caminoEsperado.add("E");

	}

	public void setUpEscenario3(IGrafo<String> grafo) {
		cmin = new CaminoMinimo<>();
		camino = new ArrayList<>();
		caminoEsperado = new ArrayList<>();
		total = 0;
		inicio = "A";
		fin = "Z";

		grafo.agregarArista(new Arista<String>(16.0, inicio, "B"));
		grafo.agregarArista(new Arista<String>(10.0, inicio, "C"));
		grafo.agregarArista(new Arista<String>(5.0, inicio, "D"));
		grafo.agregarArista(new Arista<String>(2.0, "B", "C"));
		grafo.agregarArista(new Arista<String>(4.0, "B", "F"));
		grafo.agregarArista(new Arista<String>(6.0, "B", "G"));
		grafo.agregarArista(new Arista<String>(4.0, "C", "D"));
		grafo.agregarArista(new Arista<String>(12.0, "C", "F"));
		grafo.agregarArista(new Arista<String>(10.0, "C", "E"));
		grafo.agregarArista(new Arista<String>(15.0, "D", "E"));
		grafo.agregarArista(new Arista<String>(3.0, "E", "F"));
		grafo.agregarArista(new Arista<String>(5.0, "E", "Z"));
		grafo.agregarArista(new Arista<String>(8.0, "F", "G"));
		grafo.agregarArista(new Arista<String>(16.0, "F", "Z"));
		grafo.agregarArista(new Arista<String>(7.0, "G", "Z"));

		caminoEsperado.add("A");
		caminoEsperado.add("D");
		caminoEsperado.add("C");
		caminoEsperado.add("B");
		caminoEsperado.add("F");
		caminoEsperado.add("E");
		caminoEsperado.add("Z");

	}


	public void setUpEscenario4() {
		cmin = new CaminoMinimo<>();
		mInicial = new double[][] { { 0, 9, 3, 4, INF, INF }, { INF, 0, 4, INF, INF, INF }, { INF, 5, 0, INF, 6, INF },
				{ INF, 2, INF, 0, INF, INF }, { INF, INF, INF, INF, 0, 7 }, { INF, INF, INF, 8, INF, 0 } };

		mEsperada = new double[][] { { 0, 6, 3, 4, 9, 16 }, { INF, 0, 4, 25, 10, 17 }, { INF, 5, 0, 21, 6, 13 },
				{ INF, 2, 6, 0, 12, 19 }, { INF, 17, 21, 15, 0, 7 }, { INF, 10, 14, 8, 20, 0 } };

	}

	public void setUpEscenario5() {

		cmin = new CaminoMinimo<>();
		mInicial = new double[][] { { 0, 4, INF, INF, INF, INF, 7, 4 }, { INF, 0, 9, INF, INF, 6, 8, 1 },
				{ INF, INF, 0, INF, 10, INF, INF, INF }, { INF, INF, INF, 0, INF, INF, INF, INF },
				{ INF, INF, 8, 6, 0, 5, INF, INF }, { INF, INF, INF, INF, 6, 0, INF, INF },
				{ INF, 4, INF, INF, INF, 7, 0, INF }, { INF, INF, 3, INF, INF, INF, INF, 0 } };

		mEsperada = new double[][] { { 0, 4, 7, 22, 16, 10, 7, 4 }, { INF, 0, 4, 18, 12, 6, 8, 1 },
				{ INF, INF, 0, 16, 10, 15, INF, INF }, { INF, INF, INF, 0, INF, INF, INF, INF },
				{ INF, INF, 8, 6, 0, 5, INF, INF }, { INF, INF, 14, 12, 6, 0, INF, INF },
				{ INF, 4, 8, 19, 13, 7, 0, 5 }, { INF, INF, 3, 19, 13, 18, INF, 0 } };
	}

	// ----------------------------------------------------------------
	// --------DIJKSTRA: Implementación lista de adyacencia------------
	// ----------------------------------------------------------------

	@Test
	public void testDijkstraBasicoLista() {
		IGrafo<String> grafo = new GrafoLista<>();
		setUpEscenario1(grafo);
		camino = cmin.dijkstra(grafo, inicio, fin);

		caminoOriginal = new ArrayList<>();

		for (int i = camino.size() - 1; i >= 0; i--) {
			total += camino.get(i).getPonderacion();
			caminoOriginal.add(camino.get(i).getOrigen());
			if (i == 0) {
				caminoOriginal.add(camino.get(i).getDestino());
			}
		}

		assertTrue(caminoOriginal.equals(caminoEsperado));
		assertTrue(total == 13);
	}

	@Test
	public void testDijkstraMedioLista() {
		IGrafo<String> grafo = new GrafoLista<>();
		setUpEscenario2(grafo);
		camino = cmin.dijkstra(grafo, inicio, fin);

		caminoOriginal = new ArrayList<>();

		for (int i = camino.size() - 1; i >= 0; i--) {
			total += camino.get(i).getPonderacion();
			caminoOriginal.add(camino.get(i).getOrigen());
			if (i == 0) {
				caminoOriginal.add(camino.get(i).getDestino());
			}
		}

		assertTrue(caminoOriginal.equals(caminoEsperado));
		assertTrue(total == 14);
	}

	@Test
	public void testDijkstraInteresanteLista() {
		IGrafo<String> grafo = new GrafoLista<>();
		setUpEscenario3(grafo);
		camino = cmin.dijkstra(grafo, inicio, fin);

		caminoOriginal = new ArrayList<>();

		for (int i = camino.size() - 1; i >= 0; i--) {
			total += camino.get(i).getPonderacion();
			caminoOriginal.add(camino.get(i).getOrigen());
			if (i == 0) {
				caminoOriginal.add(camino.get(i).getDestino());
			}
		}

		assertTrue(caminoOriginal.equals(caminoEsperado));
		assertTrue(total == 23);
	}

	// ----------------------------------------------------------------
	// --------DIJKSTRA: Implementación matriz de adyacencia-----------
	// ----------------------------------------------------------------

	@Test
	public void testDijkstraBasicoMatriz() {
		IGrafo<String> grafo = new GrafoMatriz<>();
		setUpEscenario1(grafo);
		camino = cmin.dijkstra(grafo, inicio, fin);

		caminoOriginal = new ArrayList<>();

		for (int i = camino.size() - 1; i >= 0; i--) {
			total += camino.get(i).getPonderacion();
			caminoOriginal.add(camino.get(i).getOrigen());
			if (i == 0) {
				caminoOriginal.add(camino.get(i).getDestino());
			}
		}

		assertTrue(caminoOriginal.equals(caminoEsperado));
		assertTrue(total == 13);
	}

	@Test
	public void testDijkstraMedioMatriz() {
		IGrafo<String> grafo = new GrafoMatriz<>();
		setUpEscenario2(grafo);
		camino = cmin.dijkstra(grafo, inicio, fin);

		caminoOriginal = new ArrayList<>();
		for (int i = camino.size() - 1; i >= 0; i--) {
			total += camino.get(i).getPonderacion();
			caminoOriginal.add(camino.get(i).getOrigen());
			if (i == 0) {
				caminoOriginal.add(camino.get(i).getDestino());
			}
		}

		assertTrue(caminoOriginal.equals(caminoEsperado));
		assertTrue(total == 14);
	}

	@Test
	public void testDijkstraInteresanteMatriz() {
		IGrafo<String> grafo = new GrafoMatriz<>();
		setUpEscenario3(grafo);
		camino = cmin.dijkstra(grafo, inicio, fin);

		caminoOriginal = new ArrayList<>();

		for (int i = camino.size() - 1; i >= 0; i--) {
			total += camino.get(i).getPonderacion();
			caminoOriginal.add(camino.get(i).getOrigen());
			if (i == 0) {
				caminoOriginal.add(camino.get(i).getDestino());
			}
		}

		assertTrue(caminoOriginal.equals(caminoEsperado));
		assertTrue(total == 23);
	}

	// ----------------------------------------------------------------
	// ------------------------FLOYD-WARSHALL--------------------------
	// ----------------------------------------------------------------

	// @Test
	public void testFloydWarshallBasico() {

	}

	@Test
	public void testFloydWarshallMedio() {

		setUpEscenario4();
		double[][] mObtenida = cmin.floyd(mInicial);

		for (int i = 0; i < mObtenida.length; i++) {
			for (int j = 0; j < mObtenida[0].length; j++) {
				assertTrue(mObtenida[i][j] == mEsperada[i][j]);
			}
		}

	}

	@Test
	public void testFloydWarshallInteresante() {

		setUpEscenario5();
		double[][] mObtenida = cmin.floyd(mInicial);

		for (int i = 0; i < mEsperada.length; i++) {
			for (int j = 0; j < mEsperada[0].length; j++) {
				assertTrue(mObtenida[i][j] == mEsperada[i][j]);
			}
		}
	}
}
