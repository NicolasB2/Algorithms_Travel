package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

import estructuras.*;
import metodos.Recorridos;

public class testRecorridos {

	private IGrafo<Integer> grafo;
	private Recorridos<Integer> r;
	private int a;
	ArrayList<Integer> listaEsperada;

	public void setUpEscenario1() {
		grafo = new GrafoLista<Integer>(true);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 2;

		grafo.agregarArista(new Arista<Integer>(0, 1));
		grafo.agregarArista(new Arista<Integer>(0, a));
		grafo.agregarArista(new Arista<Integer>(1, a));
		grafo.agregarArista(new Arista<Integer>(a, 0));
		grafo.agregarArista(new Arista<Integer>(a, 3));
		grafo.agregarArista(new Arista<Integer>(3, 3));

		listaEsperada.add(2);
		listaEsperada.add(0);
		listaEsperada.add(3);
		listaEsperada.add(1);
	}

	public void setUpEscenario2() {
		grafo = new GrafoLista<Integer>();
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 1;

		grafo.agregarArista(new Arista<Integer>(a, 2));
		grafo.agregarArista(new Arista<Integer>(a, 3));
		grafo.agregarArista(new Arista<Integer>(2, 4));
		grafo.agregarArista(new Arista<Integer>(2, 5));
		grafo.agregarArista(new Arista<Integer>(3, 5));
		grafo.agregarArista(new Arista<Integer>(4, 5));
		grafo.agregarArista(new Arista<Integer>(4, 6));
		grafo.agregarArista(new Arista<Integer>(5, 6));

		listaEsperada.add(1);
		listaEsperada.add(2);
		listaEsperada.add(3);
		listaEsperada.add(4);
		listaEsperada.add(5);
		listaEsperada.add(6);

	}

	public void setUpEscenario3() {
		grafo = new GrafoLista<Integer>();
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 2;

		grafo.agregarArista(new Arista<Integer>(1, a));
		grafo.agregarArista(new Arista<Integer>(1, 4));
		grafo.agregarArista(new Arista<Integer>(a, 6));
		grafo.agregarArista(new Arista<Integer>(6, 3));
		grafo.agregarArista(new Arista<Integer>(6, 8));
		grafo.agregarArista(new Arista<Integer>(3, 8));
		grafo.agregarArista(new Arista<Integer>(3, 7));
		grafo.agregarArista(new Arista<Integer>(8, 7));
		grafo.agregarArista(new Arista<Integer>(8, 5));
		grafo.agregarArista(new Arista<Integer>(5, 7));

		listaEsperada.add(2);
		listaEsperada.add(1);
		listaEsperada.add(6);
		listaEsperada.add(4);
		listaEsperada.add(3);
		listaEsperada.add(8);
		listaEsperada.add(7);
		listaEsperada.add(5);

	}

	public void setUpEscenario4() {
		grafo = new GrafoLista<Integer>(true);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 3;

		grafo.agregarArista(new Arista<Integer>(1, 6));
		grafo.agregarArista(new Arista<Integer>(1, a));
		grafo.agregarArista(new Arista<Integer>(2, 0));
		grafo.agregarArista(new Arista<Integer>(a, 7));
		grafo.agregarArista(new Arista<Integer>(0, a));
		grafo.agregarArista(new Arista<Integer>(0, 4));
		grafo.agregarArista(new Arista<Integer>(5, 1));
		grafo.agregarArista(new Arista<Integer>(6, 2));
		grafo.agregarArista(new Arista<Integer>(6, 5));
		grafo.agregarArista(new Arista<Integer>(7, 6));

		listaEsperada.add(3);
		listaEsperada.add(7);
		listaEsperada.add(6);
		listaEsperada.add(2);
		listaEsperada.add(5);
		listaEsperada.add(0);
		listaEsperada.add(1);
		listaEsperada.add(4);
	}

	public void setUpEscenario5() {
		grafo = new GrafoLista<Integer>(false);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 10;

		grafo.agregarArista(new Arista<Integer>(0, 7));
		grafo.agregarArista(new Arista<Integer>(0, 4));
		grafo.agregarArista(new Arista<Integer>(1, 4));
		grafo.agregarArista(new Arista<Integer>(1, 2));
		grafo.agregarArista(new Arista<Integer>(2, 3));
		grafo.agregarArista(new Arista<Integer>(3, 17));
		grafo.agregarArista(new Arista<Integer>(4, 7));
		grafo.agregarArista(new Arista<Integer>(5, 8));
		grafo.agregarArista(new Arista<Integer>(5, 9));
		grafo.agregarArista(new Arista<Integer>(6, 9));
		grafo.agregarArista(new Arista<Integer>(6, a));
		grafo.agregarArista(new Arista<Integer>(7, 8));
		grafo.agregarArista(new Arista<Integer>(7, 11));
		grafo.agregarArista(new Arista<Integer>(7, 14));
		grafo.agregarArista(new Arista<Integer>(8, 11));
		grafo.agregarArista(new Arista<Integer>(8, 12));
		grafo.agregarArista(new Arista<Integer>(9, a));
		grafo.agregarArista(new Arista<Integer>(9, 13));
		grafo.agregarArista(new Arista<Integer>(11, 12));
		grafo.agregarArista(new Arista<Integer>(11, 14));
		grafo.agregarArista(new Arista<Integer>(11, 15));
		grafo.agregarArista(new Arista<Integer>(12, 13));
		grafo.agregarArista(new Arista<Integer>(12, 16));
		grafo.agregarArista(new Arista<Integer>(14, 15));
		grafo.agregarArista(new Arista<Integer>(15, 16));
		grafo.agregarArista(new Arista<Integer>(15, 17));
		grafo.agregarArista(new Arista<Integer>(16, 17));

		listaEsperada.add(10);
		listaEsperada.add(6);
		listaEsperada.add(9);
		listaEsperada.add(5);
		listaEsperada.add(13);
		listaEsperada.add(8);
		listaEsperada.add(12);
		listaEsperada.add(7);
		listaEsperada.add(11);
		listaEsperada.add(16);
		listaEsperada.add(0);
		listaEsperada.add(4);
		listaEsperada.add(14);
		listaEsperada.add(15);
		listaEsperada.add(17);
		listaEsperada.add(1);
		listaEsperada.add(3);
		listaEsperada.add(2);

	}

	public void setUpEscenario6() {
		grafo = new GrafoLista<Integer>(true);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 6;

		grafo.agregarArista(new Arista<Integer>(0, 4));
		grafo.agregarArista(new Arista<Integer>(2, 1));
		grafo.agregarArista(new Arista<Integer>(2, 3));
		grafo.agregarArista(new Arista<Integer>(3, 17));
		grafo.agregarArista(new Arista<Integer>(5, 1));
		grafo.agregarArista(new Arista<Integer>(5, a));
		grafo.agregarArista(new Arista<Integer>(5, 9));
		grafo.agregarArista(new Arista<Integer>(a, 10));
		grafo.agregarArista(new Arista<Integer>(7, 8));
		grafo.agregarArista(new Arista<Integer>(7, 11));
		grafo.agregarArista(new Arista<Integer>(8, 9));
		grafo.agregarArista(new Arista<Integer>(9, 12));
		grafo.agregarArista(new Arista<Integer>(10, 9));
		grafo.agregarArista(new Arista<Integer>(10, 3));
		grafo.agregarArista(new Arista<Integer>(12, 11));
		grafo.agregarArista(new Arista<Integer>(12, 9));
		grafo.agregarArista(new Arista<Integer>(12, 15));
		grafo.agregarArista(new Arista<Integer>(13, 16));
		grafo.agregarArista(new Arista<Integer>(14, 7));
		grafo.agregarArista(new Arista<Integer>(15, 11));
		grafo.agregarArista(new Arista<Integer>(15, 16));
		grafo.agregarArista(new Arista<Integer>(16, 15));
		grafo.agregarArista(new Arista<Integer>(17, 13));
		grafo.agregarArista(new Arista<Integer>(17, 16));

		listaEsperada.add(6);
		listaEsperada.add(10);
		listaEsperada.add(3);
		listaEsperada.add(9);
		listaEsperada.add(17);
		listaEsperada.add(12);
		listaEsperada.add(16);
		listaEsperada.add(13);
		listaEsperada.add(11);
		listaEsperada.add(15);

	}

	public void setUpEscenario7() {
		grafo = new GrafoMatriz<>(false);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 1;

		grafo.agregarArista(new Arista<Integer>(a, 2));
		grafo.agregarArista(new Arista<Integer>(a, 3));
		grafo.agregarArista(new Arista<Integer>(a, 5));
		grafo.agregarArista(new Arista<Integer>(2, 4));
		grafo.agregarArista(new Arista<Integer>(2, 5));

		listaEsperada.add(1);
		listaEsperada.add(5);
		listaEsperada.add(3);
		listaEsperada.add(2);
		listaEsperada.add(4);
	}

	public void setUpEscenario8() {
		grafo = new GrafoMatriz<>(true);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 2;

		grafo.agregarArista(new Arista<Integer>(1, 3));
		grafo.agregarArista(new Arista<Integer>(2, 3));
		grafo.agregarArista(new Arista<Integer>(2, 4));
		grafo.agregarArista(new Arista<Integer>(3, 5));
		grafo.agregarArista(new Arista<Integer>(4, 5));

		listaEsperada.add(2);
		listaEsperada.add(4);
		listaEsperada.add(5);
		listaEsperada.add(3);
	}

	public void setUpEscenario9() {
		grafo = new GrafoMatriz<>(false);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 0;

		grafo.agregarArista(new Arista<Integer>(0, 1));
		grafo.agregarArista(new Arista<Integer>(1, 2));
		grafo.agregarArista(new Arista<Integer>(1, 5));
		grafo.agregarArista(new Arista<Integer>(1, 3));
		grafo.agregarArista(new Arista<Integer>(3, 5));
		grafo.agregarArista(new Arista<Integer>(4, 6));
		grafo.agregarArista(new Arista<Integer>(4, 7));
		grafo.agregarArista(new Arista<Integer>(5, 6));
		grafo.agregarArista(new Arista<Integer>(5, 7));
		grafo.agregarArista(new Arista<Integer>(6, 7));

		listaEsperada.add(0);
		listaEsperada.add(1);
		listaEsperada.add(5);
		listaEsperada.add(7);
		listaEsperada.add(4);
		listaEsperada.add(6);
		listaEsperada.add(3);
		listaEsperada.add(2);
	}

	public void setUpEscenario10() {
		grafo = new GrafoMatriz<>(false);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 0;

		grafo.agregarArista(new Arista<Integer>(0, 3));
		grafo.agregarArista(new Arista<Integer>(0, 4));
		grafo.agregarArista(new Arista<Integer>(2, 4));
		grafo.agregarArista(new Arista<Integer>(2, 5));
		grafo.agregarArista(new Arista<Integer>(4, 6));
		grafo.agregarArista(new Arista<Integer>(4, 7));
		grafo.agregarArista(new Arista<Integer>(5, 6));
		grafo.agregarArista(new Arista<Integer>(5, 7));
		grafo.agregarArista(new Arista<Integer>(6, 7));
		grafo.agregarArista(new Arista<Integer>(7, 6));

		listaEsperada.add(0);
		listaEsperada.add(4);
		listaEsperada.add(7);
		listaEsperada.add(5);
		listaEsperada.add(6);
		listaEsperada.add(2);
		listaEsperada.add(3);

	}

	public void setUpEscenario11() {
		grafo = new GrafoMatriz<>(false);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 17;

		grafo.agregarArista(new Arista<Integer>(0, 2));
		grafo.agregarArista(new Arista<Integer>(1, 2));
		grafo.agregarArista(new Arista<Integer>(1, 5));
		grafo.agregarArista(new Arista<Integer>(2, 5));
		grafo.agregarArista(new Arista<Integer>(2, 3));
		grafo.agregarArista(new Arista<Integer>(3, 10));
		grafo.agregarArista(new Arista<Integer>(4, 7));
		grafo.agregarArista(new Arista<Integer>(4, 5));
		grafo.agregarArista(new Arista<Integer>(5, 6));
		grafo.agregarArista(new Arista<Integer>(6, 10));
		grafo.agregarArista(new Arista<Integer>(7, 8));
		grafo.agregarArista(new Arista<Integer>(7, 14));
		grafo.agregarArista(new Arista<Integer>(7, 11));
		grafo.agregarArista(new Arista<Integer>(8, 9));
		grafo.agregarArista(new Arista<Integer>(8, 11));
		grafo.agregarArista(new Arista<Integer>(9, 10));
		grafo.agregarArista(new Arista<Integer>(9, 12));
		grafo.agregarArista(new Arista<Integer>(10, 17));
		grafo.agregarArista(new Arista<Integer>(11, 14));
		grafo.agregarArista(new Arista<Integer>(11, 15));
		grafo.agregarArista(new Arista<Integer>(11, 12));
		grafo.agregarArista(new Arista<Integer>(12, 13));
		grafo.agregarArista(new Arista<Integer>(14, 15));
		grafo.agregarArista(new Arista<Integer>(16, 17));

		listaEsperada.add(17);
		listaEsperada.add(10);
		listaEsperada.add(9);
		listaEsperada.add(12);
		listaEsperada.add(13);
		listaEsperada.add(11);
		listaEsperada.add(15);
		listaEsperada.add(14);
		listaEsperada.add(7);
		listaEsperada.add(4);
		listaEsperada.add(5);
		listaEsperada.add(2);
		listaEsperada.add(0);
		listaEsperada.add(1);
		listaEsperada.add(8);
		listaEsperada.add(6);
		listaEsperada.add(3);
		listaEsperada.add(16);

	}

	public void setUpEscenario12() {
		grafo = new GrafoMatriz<>(true);
		listaEsperada = new ArrayList<>();
		r = new Recorridos<>();
		a = 6;

		grafo.agregarArista(new Arista<Integer>(0, 7));
		grafo.agregarArista(new Arista<Integer>(1, 4));
		grafo.agregarArista(new Arista<Integer>(1, 5));
		grafo.agregarArista(new Arista<Integer>(2, 1));
		grafo.agregarArista(new Arista<Integer>(2, 3));
		grafo.agregarArista(new Arista<Integer>(5, 2));
		grafo.agregarArista(new Arista<Integer>(6, 2));
		grafo.agregarArista(new Arista<Integer>(7, 0));
		grafo.agregarArista(new Arista<Integer>(7, 4));
		grafo.agregarArista(new Arista<Integer>(8, 5));
		grafo.agregarArista(new Arista<Integer>(8, 11));
		grafo.agregarArista(new Arista<Integer>(9, 6));
		grafo.agregarArista(new Arista<Integer>(9, 10));
		grafo.agregarArista(new Arista<Integer>(9, 12));
		grafo.agregarArista(new Arista<Integer>(11, 8));
		grafo.agregarArista(new Arista<Integer>(11, 7));
		grafo.agregarArista(new Arista<Integer>(11, 15));
		grafo.agregarArista(new Arista<Integer>(12, 8));
		grafo.agregarArista(new Arista<Integer>(12, 13));
		grafo.agregarArista(new Arista<Integer>(14, 11));
		grafo.agregarArista(new Arista<Integer>(15, 16));
		grafo.agregarArista(new Arista<Integer>(16, 17));

		listaEsperada.add(6);
		listaEsperada.add(2);
		listaEsperada.add(3);
		listaEsperada.add(1);
		listaEsperada.add(5);
		listaEsperada.add(4);
	}

	// ----------------------------------------------------------------
	// ---------------------------BFS----------------------------------
	// ----------------------------------------------------------------

	/**
	 * Test caso base con grafo dirigido
	 */
	@Test
	public void testRecorridoBFSBaseDirigido() {
		setUpEscenario1();
		ArrayList<Integer> lista = r.bfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	/**
	 * Test caso base con grafo no dirigido
	 */
	@Test
	public void testRecorridoBFSBaseNoDirigido() {
		setUpEscenario2();
		ArrayList<Integer> lista = r.bfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	/**
	 * Test caso medio con grafo no dirigido
	 */
	@Test
	public void testRecorridoBFSMedioNoDirigido() {
		setUpEscenario3();
		ArrayList<Integer> lista = r.bfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	/**
	 * Test caso medio con grafo dirigido
	 */
	@Test
	public void testRecorridoBFSMedioDirigido() {
		setUpEscenario4();
		ArrayList<Integer> lista = r.bfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	/**
	 * Test caso interesante con grafo no dirigido
	 */
	@Test
	public void testRecorridoBFSInteresanteNoDirigido() {
		setUpEscenario5();
		ArrayList<Integer> lista = r.bfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	/**
	 * Test caso interesante con grafo dirigido
	 */
	@Test
	public void testRecorridoBFSInteresanteDirigido() {
		setUpEscenario6();
		ArrayList<Integer> lista = r.bfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	// ----------------------------------------------------------------
	// ---------------------------DFS----------------------------------
	// ----------------------------------------------------------------

	/**
	 * Test caso base no dirigido
	 */
	@Test
	public void testRecorridoDFSBaseNoDirigido() {
		setUpEscenario7();
		ArrayList<Integer> lista = r.dfs(grafo, a);
		assertEquals(listaEsperada, lista);

	}

	/**
	 * Test caso base dirigido
	 */
	@Test
	public void testRecorridoDFSBaseDirigido() {
		setUpEscenario8();
		ArrayList<Integer> lista = r.dfs(grafo, a);
		assertEquals(listaEsperada, lista);

	}

	/**
	 * Test caso medio no dirigido
	 */
	@Test
	public void testRecorridoDFSMedioNoDirigido() {
		setUpEscenario9();
		ArrayList<Integer> lista = r.dfs(grafo, a);
		assertEquals(listaEsperada, lista);
	}

	/**
	 * Test caso medio dirigido
	 */
	@Test
	public void testRecorridoDFSMedioDirigido() {
		setUpEscenario10();
		ArrayList<Integer> lista = r.dfs(grafo, a);
		assertEquals(listaEsperada, lista);

	}

	/**
	 * Test caso interesante no dirigido
	 */
	@Test
	public void testRecorridoDFSInteresanteNoDirigido() {
		setUpEscenario11();
		ArrayList<Integer> lista = r.dfs(grafo, a);
		assertEquals(listaEsperada, lista);

	}

	/**
	 * Test caso interesante dirigido
	 */
	@Test
	public void testRecorridoDFSInteresanteDirigido() {
		setUpEscenario12();
		ArrayList<Integer> lista = r.dfs(grafo, a);
		assertEquals(listaEsperada, lista);

		System.out.println(lista);
	}

}
