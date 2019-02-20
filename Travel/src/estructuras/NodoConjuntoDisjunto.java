package estructuras;

public class NodoConjuntoDisjunto<E> implements Comparable<NodoConjuntoDisjunto<E>> {

	private final E elemento;
	private NodoConjuntoDisjunto<E> representante = this;
	private Integer rango = 0;

	public NodoConjuntoDisjunto(E elemento) {
		this.elemento = elemento;
	}

	public NodoConjuntoDisjunto<E> getRepresentante() {
		return representante;
	}

	public void setRepresentante(NodoConjuntoDisjunto<E> representante) {
		this.representante = representante;
	}

	public E getElemento() {
		return elemento;
	}

	
	public Integer getRango() {
		return rango;
	}

	public void setRango(Integer rango) {
		this.rango = rango;
	}

	public void incrementarRango() {
		rango++;
	}

	public int compareTo(NodoConjuntoDisjunto<E> o) {
		return rango.compareTo(o.getRango());
	}

}
