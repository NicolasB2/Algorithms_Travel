package modelo;

import java.awt.Point;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Nodo {

	public final static String PUNTERO = "./recursos/imagenes/vertice.png";
	
	private String nombre;
	private Point ubicacion;
	private String ruta; 

	public Nodo(Point ubicacion, String nombre) {
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		this.ruta = PUNTERO;
	}
	
	public Nodo(Point ubicacion, String nombre, String ruta) {
		this.ubicacion = ubicacion;
		this.nombre = nombre;
		this.setRuta("./recursos/imagenes/destinoTuristico/"+ruta+".png"); 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Point getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getX() {
		return (int) ubicacion.getX();
	}

	public int getY() {
		return (int) ubicacion.getY();
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
