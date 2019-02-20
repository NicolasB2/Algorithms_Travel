package test;

import static org.junit.Assert.*;

import java.io.LineNumberInputStream;

import org.junit.Test;
import estructuras.*;
import metodos.ArbolGeneradorMinimo;

public class testArbolGeneradorMinimo {

	private IGrafo<Integer> grafo, g;
	private ArbolGeneradorMinimo<Integer> agm;
	private int a, pesoEsperado, po;

	public void setUpEscenario1() {
		grafo = new GrafoMatriz<>();
		agm = new ArbolGeneradorMinimo<>();
		pesoEsperado = 11;
		po = 0;
		a = 1;

		grafo.agregarArista(new Arista<Integer>(8.0, a, 2));
		grafo.agregarArista(new Arista<Integer>(4.0, a, 3));
		grafo.agregarArista(new Arista<Integer>(2.0, a, 4));
		grafo.agregarArista(new Arista<Integer>(9.0, a, 5));
		grafo.agregarArista(new Arista<Integer>(6.0, 2, 3));
		grafo.agregarArista(new Arista<Integer>(6.0, 2, 4));
		grafo.agregarArista(new Arista<Integer>(5.0, 2, 5));
		grafo.agregarArista(new Arista<Integer>(4.0, 3, 4));
		grafo.agregarArista(new Arista<Integer>(1.0, 3, 5));
		grafo.agregarArista(new Arista<Integer>(3.0, 4, 5));

	}

	public void setUpEscenario2() {
		grafo = new GrafoLista<>();
		agm = new ArbolGeneradorMinimo<>();
		pesoEsperado = 21;
		po = 0;
		a = 2;

		grafo.agregarArista(new Arista<Integer>(8.0, 0, 3));
		grafo.agregarArista(new Arista<Integer>(6.0, 0, 1));
		grafo.agregarArista(new Arista<Integer>(6.0, 0, a));
		grafo.agregarArista(new Arista<Integer>(8.0, 1, a));
		grafo.agregarArista(new Arista<Integer>(7.0, a, 5));
		grafo.agregarArista(new Arista<Integer>(1.0, a, 6));
		grafo.agregarArista(new Arista<Integer>(6.0, a, 4));
		grafo.agregarArista(new Arista<Integer>(3.0, 3, 5));
		grafo.agregarArista(new Arista<Integer>(2.0, 4, 6));
		grafo.agregarArista(new Arista<Integer>(2.0, 5, 6));
		grafo.agregarArista(new Arista<Integer>(1.0, 5, 7));

	}

	public void setUpEscenario3() {
		grafo = new GrafoLista<>();
		agm = new ArbolGeneradorMinimo<>();
		pesoEsperado = 63;
		po = 0;
		a = 7;

		grafo.agregarArista(new Arista<Integer>(4.0, 0, 1));
		grafo.agregarArista(new Arista<Integer>(4.0, 0, 4));
		grafo.agregarArista(new Arista<Integer>(2.0, 0, 7));
		grafo.agregarArista(new Arista<Integer>(9.0, 1, 2));
		grafo.agregarArista(new Arista<Integer>(7.0, 1, 5));
		grafo.agregarArista(new Arista<Integer>(4.0, 2, 5));
		grafo.agregarArista(new Arista<Integer>(3.0, 2, 6));
		grafo.agregarArista(new Arista<Integer>(8.0, 3, 10));
		grafo.agregarArista(new Arista<Integer>(7.0, 4, 7));
		grafo.agregarArista(new Arista<Integer>(1.0, 4, 8));
		grafo.agregarArista(new Arista<Integer>(3.0, 6, 9));
		grafo.agregarArista(new Arista<Integer>(4.0, 6, 10));
		grafo.agregarArista(new Arista<Integer>(6.0, 7, 11));
		grafo.agregarArista(new Arista<Integer>(5.0, 7, 14));
		grafo.agregarArista(new Arista<Integer>(5.0, 8, 9));
		grafo.agregarArista(new Arista<Integer>(1.0, 9, 12));
		grafo.agregarArista(new Arista<Integer>(2.0, 9, 13));
		grafo.agregarArista(new Arista<Integer>(3.0, 10, 13));
		grafo.agregarArista(new Arista<Integer>(9.0, 10, 17));
		grafo.agregarArista(new Arista<Integer>(6.0, 11, 14));
		grafo.agregarArista(new Arista<Integer>(3.0, 12, 16));
		grafo.agregarArista(new Arista<Integer>(2.0, 13, 16));
		grafo.agregarArista(new Arista<Integer>(9.0, 13, 17));
		grafo.agregarArista(new Arista<Integer>(1.0, 14, 15));
		grafo.agregarArista(new Arista<Integer>(9.0, 15, 17));

	}

	// ----------------------------------------------------------------
	// --------------------------Kruskal-------------------------------
	// ----------------------------------------------------------------

	/**
	 * Test base con matriz de adyacencia
	 */
	@Test
	public void testKruskalBase() {
		setUpEscenario1();
		g = agm.kruskal(grafo);

		for (Arista<Integer> i : g.darAristas()) {
			po += i.getPonderacion();
		}
		assertTrue(pesoEsperado == po);
	}

	/**
	 * Test medio con lista de adyacencia
	 */
	@Test
	public void testKruskalMedio() {
		setUpEscenario2();
		g = agm.kruskal(grafo);

		for (Arista<Integer> i : g.darAristas()) {
			po += i.getPonderacion();
		}

		assertTrue(pesoEsperado == po);
	}

	/**
	 * Test medio con lista de adyacencia
	 */
	@Test
	public void testKruskalInteresante() {
		setUpEscenario3();
		g = agm.kruskal(grafo);

		for (Arista<Integer> i : g.darAristas()) {
			po += i.getPonderacion();
		}
		assertTrue(pesoEsperado == po);
	}

	// ----------------------------------------------------------------
	// ----------------------------Prim--------------------------------
	// ----------------------------------------------------------------

	/**
	 * Test base con matriz de adyacencia
	 */
	@Test
	public void testPrimBase() {
		setUpEscenario1();
		g = agm.prim(grafo, a);

		for (Arista<Integer> i : g.darAristas()) {
			po += i.getPonderacion();
		}
		System.out.println(po);
		assertTrue(pesoEsperado == po);
	}

	/**
	 * Test medio con lista de adyacencia
	 */
	@Test
	public void testPrimMedio() {
		setUpEscenario2();
		g = agm.prim(grafo, a);

		for (Arista<Integer> i : g.darAristas()) {
			po += i.getPonderacion();
		}
		assertTrue(pesoEsperado == po);
	}

	/**
	 * Test interesnate con lista de adyacencia
	 */
	@Test
	public void testPrimInteresante() {
		setUpEscenario3();
		g = agm.prim(grafo, a);

		for (Arista<Integer> i : g.darAristas()) {
			po += i.getPonderacion();
		}
		assertTrue(pesoEsperado == po);
	}

}
