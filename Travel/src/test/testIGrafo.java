package test;

import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;
import estructuras.*;

public class testIGrafo {

	private IGrafo<String> grafo;
	private String[] nodos;

	private void setUp() {
		grafo = new GrafoMatriz<>();
		nodos = new String[10];
	}

	private void setUp2() {
		grafo = new GrafoMatriz<>();
		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";
		String s4 = "Beycker";
		String s5 = "Juan";

		nodos = new String[6];
		nodos[0] = s0;
		grafo.agregarVertice(s0);
		nodos[1] = s1;
		grafo.agregarVertice(s1);
		nodos[2] = s2;
		grafo.agregarVertice(s2);
		nodos[3] = s3;
		grafo.agregarVertice(s3);
		nodos[4] = s4;
		grafo.agregarVertice(s4);
		nodos[5] = s5;
		grafo.agregarVertice(s5);

	}

	private void setUp3() {
		grafo = new GrafoMatriz<>(true);

		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";
		String s4 = "Beycker";
		String s5 = "Juan";

		nodos = new String[6];
		nodos[0] = s0;
		grafo.agregarVertice(s0);
		nodos[1] = s1;
		grafo.agregarVertice(s1);
		nodos[2] = s2;
		grafo.agregarVertice(s2);
		nodos[3] = s3;
		grafo.agregarVertice(s3);
		nodos[4] = s4;
		grafo.agregarVertice(s4);
		nodos[5] = s5;
		grafo.agregarVertice(s5);

		Arista<String> a1 = new Arista<String>(s0, s1);
		Arista<String> a2 = new Arista<String>(s1, s5);
		Arista<String> a3 = new Arista<String>(s2, s5);
		Arista<String> a4 = new Arista<String>(s3, s5);
		Arista<String> a5 = new Arista<String>(s2, s3);
		Arista<String> a6 = new Arista<String>(s4, s5);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);
		grafo.agregarArista(a5);
		grafo.agregarArista(a6);

	}

	@Test
	public void testAgregarVerticeGrafoVacio() {

		setUp();
		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";

		nodos[0] = s0;
		grafo.agregarVertice(s0);
		nodos[1] = s1;
		grafo.agregarVertice(s1);
		nodos[2] = s2;
		grafo.agregarVertice(s2);
		nodos[3] = s3;
		grafo.agregarVertice(s3);

		grafo.agregarVertice(nodos[0]);
		grafo.agregarVertice(nodos[1]);
		grafo.agregarVertice(nodos[2]);
		grafo.agregarVertice(nodos[3]);

		assertTrue(grafo.containsVertice(nodos[0]));
		assertTrue(grafo.containsVertice(nodos[1]));
		assertTrue(grafo.containsVertice(nodos[2]));
		assertTrue(grafo.containsVertice(nodos[3]));

	}

	@Test
	public void testAgregarVerticeGrafoConVertices() {
		setUp2();
		String s1 = "Alejandra";
		String s2 = "Isabella";
		String s3 = "Juan Carlos";

		grafo.agregarVertice(s1);
		grafo.agregarVertice(s2);
		grafo.agregarVertice(s3);

		assertTrue(grafo.containsVertice(s1));
		assertTrue(grafo.containsVertice(s2));
		assertTrue(grafo.containsVertice(s3));

	}

	@Test
	public void testAgregarVerticeNull() {
		setUp2();
		grafo.agregarVertice(null);
		assertFalse(grafo.containsVertice(null));
	}

	@Test
	public void testEliminarVerticeNoAgregado() {
		setUp();
		String s1 = "Daniela";
		assertFalse(grafo.eliminarVertice(s1));
	}

	@Test
	public void testElimarVerticeGrafoConVertices() {
		setUp2();
		grafo.eliminarVertice(nodos[0]);
		grafo.eliminarVertice(nodos[1]);
		grafo.eliminarVertice(nodos[2]);
		grafo.eliminarVertice(nodos[3]);
		grafo.eliminarVertice(nodos[4]);

		assertFalse(grafo.containsVertice(nodos[0]));
		assertFalse(grafo.containsVertice(nodos[1]));
		assertFalse(grafo.containsVertice(nodos[2]));
		assertFalse(grafo.containsVertice(nodos[3]));
		assertFalse(grafo.containsVertice(nodos[4]));

	}

	@Test
	public void testContainsVerticeExistente() {
		setUp2();
		assertTrue(grafo.containsVertice(nodos[5]));
		assertTrue(grafo.containsVertice(nodos[4]));
		assertTrue(grafo.containsVertice(nodos[3]));
		assertTrue(grafo.containsVertice(nodos[2]));
		assertTrue(grafo.containsVertice(nodos[1]));
	}

	@Test
	public void testContainsVerticeInexistente() {
		setUp2();
		assertFalse(grafo.containsVertice("hola"));
		assertFalse(grafo.containsVertice("bye"));
		assertFalse(grafo.containsVertice("hello"));
	}

	@Test
	public void testDarVertices() {
		setUp2();
		Set<String> vertices = grafo.darVertices();
		assertTrue(vertices.size() == 6);
		for (String n : vertices) {
			assertTrue(grafo.containsVertice(n));
		}
	}

	@Test
	public void testDarVerticesGrafoVacio() {
		setUp();
		Set<String> vertices = grafo.darVertices();
		assertTrue(vertices.size() == 0);
	}

	@Test
	public void testagregarAristaGrafoVacio() {
		setUp();

		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";
		String s4 = "Beycker";

		Arista<String> a1 = new Arista<String>(s0, s1);
		Arista<String> a2 = new Arista<String>(s0, s2);
		Arista<String> a3 = new Arista<String>(s1, s3);
		Arista<String> a4 = new Arista<String>(s4, s1);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);

		assertTrue(grafo.containsVertice(s0));
		assertTrue(grafo.containsVertice(s1));
		assertTrue(grafo.containsVertice(s2));
		assertTrue(grafo.containsVertice(s3));
		assertTrue(grafo.containsVertice(s4));

		assertTrue(grafo.existeArista(s0, s1));
		assertTrue(grafo.existeArista(s0, s2));
		assertTrue(grafo.existeArista(s1, s3));
		assertTrue(grafo.existeArista(s4, s1));
	}

	@Test
	public void testagregarAristaGrafoConVertices() {
		setUp2();

		Arista<String> a1 = new Arista<String>(nodos[0], nodos[1]);
		Arista<String> a2 = new Arista<String>(nodos[0], nodos[2]);
		Arista<String> a3 = new Arista<String>(nodos[1], nodos[3]);
		Arista<String> a4 = new Arista<String>(nodos[4], nodos[1]);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);

		assertTrue(grafo.existeArista(nodos[0], nodos[1]));
		assertTrue(grafo.existeArista(nodos[0], nodos[2]));
		assertTrue(grafo.existeArista(nodos[1], nodos[3]));
		assertTrue(grafo.existeArista(nodos[4], nodos[1]));
	}

	@Test
	public void testagregarAristaPonderadaGrafoVacio() {
		setUp();

		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";
		String s4 = "Beycker";

		Arista<String> a1 = new Arista<String>(5.0, s0, s1);
		Arista<String> a2 = new Arista<String>(8.0, s0, s2);
		Arista<String> a3 = new Arista<String>(4.0, s1, s3);
		Arista<String> a4 = new Arista<String>(10.0, s4, s1);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);

		assertTrue(grafo.containsVertice(s0));
		assertTrue(grafo.containsVertice(s1));
		assertTrue(grafo.containsVertice(s2));
		assertTrue(grafo.containsVertice(s3));
		assertTrue(grafo.containsVertice(s4));

		assertTrue(grafo.existeArista(s0, s1));
		assertTrue(grafo.existeArista(s0, s2));
		assertTrue(grafo.existeArista(s1, s3));
		assertTrue(grafo.existeArista(s4, s1));

		assertTrue(5.0 == grafo.darPonderacion(s0, s1));
		assertTrue(8.0 == grafo.darPonderacion(s0, s2));
		assertTrue(4.0 == grafo.darPonderacion(s1, s3));
		assertTrue(10.0 == grafo.darPonderacion(s4, s1));

		assertEquals("", grafo.darRelacion(s0, s1));
		assertEquals("", grafo.darRelacion(s0, s2));
		assertEquals("", grafo.darRelacion(s1, s3));
		assertEquals("", grafo.darRelacion(s4, s1));

	}

	@Test
	public void testagregarAristaPonderadaGrafoConVertices() {
		setUp2();

		Arista<String> a1 = new Arista<String>(5.0, nodos[0], nodos[1]);
		Arista<String> a2 = new Arista<String>(8.0, nodos[0], nodos[2]);
		Arista<String> a3 = new Arista<String>(4.0, nodos[1], nodos[3]);
		Arista<String> a4 = new Arista<String>(10.0, nodos[4], nodos[1]);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);

		assertTrue(grafo.existeArista(nodos[0], nodos[1]));
		assertTrue(grafo.existeArista(nodos[0], nodos[2]));
		assertTrue(grafo.existeArista(nodos[1], nodos[3]));
		assertTrue(grafo.existeArista(nodos[4], nodos[1]));

		assertTrue(5.0 == grafo.darPonderacion(nodos[0], nodos[1]));
		assertTrue(8.0 == grafo.darPonderacion(nodos[0], nodos[2]));
		assertTrue(4.0 == grafo.darPonderacion(nodos[1], nodos[3]));
		assertTrue(10.0 == grafo.darPonderacion(nodos[4], nodos[1]));

		assertEquals("", grafo.darRelacion(nodos[0], nodos[1]));
		assertEquals("", grafo.darRelacion(nodos[0], nodos[2]));
		assertEquals("", grafo.darRelacion(nodos[1], nodos[3]));
		assertEquals("", grafo.darRelacion(nodos[4], nodos[1]));
	}

	@Test
	public void testagregarAristaRelacionGrafoVacio() {
		setUp();

		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";
		String s4 = "Beycker";

		Arista<String> a1 = new Arista<String>("Amigos", s0, s1);
		Arista<String> a2 = new Arista<String>("Conocidos", s0, s2);
		Arista<String> a3 = new Arista<String>("Enemigos", s1, s3);
		Arista<String> a4 = new Arista<String>("Extraños", s4, s1);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);

		assertTrue(grafo.containsVertice(s0));
		assertTrue(grafo.containsVertice(s1));
		assertTrue(grafo.containsVertice(s2));
		assertTrue(grafo.containsVertice(s3));
		assertTrue(grafo.containsVertice(s4));

		assertTrue(grafo.existeArista(s0, s1));
		assertTrue(grafo.existeArista(s0, s2));
		assertTrue(grafo.existeArista(s1, s3));
		assertTrue(grafo.existeArista(s4, s1));

		assertTrue(1 == grafo.darPonderacion(s0, s1));
		assertTrue(1 == grafo.darPonderacion(s0, s2));
		assertTrue(1 == grafo.darPonderacion(s1, s3));
		assertTrue(1 == grafo.darPonderacion(s4, s1));

		assertTrue("Amigos" == grafo.darRelacion(s0, s1));
		assertTrue("Conocidos" == grafo.darRelacion(s0, s2));
		assertTrue("Enemigos" == grafo.darRelacion(s1, s3));
		assertTrue("Extraños" == grafo.darRelacion(s4, s1));

	}

	@Test
	public void testagregarAristaRealacionGrafoConVertices() {
		setUp2();

		Arista<String> a1 = new Arista<String>("Amigos", nodos[0], nodos[1]);
		Arista<String> a2 = new Arista<String>("Conocidos", nodos[0], nodos[2]);
		Arista<String> a3 = new Arista<String>("Enemigos", nodos[1], nodos[3]);
		Arista<String> a4 = new Arista<String>("Extraños", nodos[4], nodos[1]);

		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);

		assertTrue(grafo.existeArista(nodos[0], nodos[1]));
		assertTrue(grafo.existeArista(nodos[0], nodos[2]));
		assertTrue(grafo.existeArista(nodos[1], nodos[3]));
		assertTrue(grafo.existeArista(nodos[4], nodos[1]));

		assertTrue(1 == grafo.darPonderacion(nodos[0], nodos[1]));
		assertTrue(1 == grafo.darPonderacion(nodos[0], nodos[2]));
		assertTrue(1 == grafo.darPonderacion(nodos[1], nodos[3]));
		assertTrue(1 == grafo.darPonderacion(nodos[4], nodos[1]));

		assertEquals("Amigos", grafo.darRelacion(nodos[0], nodos[1]));
		assertEquals("Conocidos", grafo.darRelacion(nodos[0], nodos[2]));
		assertEquals("Enemigos", grafo.darRelacion(nodos[1], nodos[3]));
		assertEquals("Extraños", grafo.darRelacion(nodos[4], nodos[1]));
	}

	@Test
	public void testeliminarArista() {
		setUp3();

		String s0 = "Andres";
		String s1 = "Sara";
		String s2 = "Christian";
		String s3 = "Nicolas";
		String s4 = "Beycker";
		String s5 = "Juan";

		assertTrue(grafo.eliminarArista(s0, s1));
		assertTrue(grafo.eliminarArista(s1, s5));
		assertTrue(grafo.eliminarArista(s2, s3));
		assertTrue(grafo.eliminarArista(s4, s5));
		assertTrue(!grafo.eliminarArista(s3, s4));
		assertTrue(!grafo.eliminarArista(s0, s2));
		assertTrue(!grafo.eliminarArista(s1, s3));
	}

	// hasta aqui esta el metodo eliminar arista
}
