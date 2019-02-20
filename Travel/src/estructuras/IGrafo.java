package estructuras;

import java.util.ArrayList;
import java.util.Set;

public interface IGrafo <N>{
	
	//metodos sobre los vertices
	
	/**
	 * Permita consultar la naturaleza de la direccion del grafo
	 * @return <b>true:</b> si el grafo es dirigido</br>
	 * 		   <b>false:</b> si el grafo es no dirigido
	 */
	public boolean esDirigido();
	
	/**
	 * Permitece agregar un nodo o vertice al grafo
	 * <pre> <b>Pre:</b> El vertice es distinto de null y no se encuentra agregado en el grafo</pre>
	 * @param vertice : nodo que se decea agregar
	 */
	public void agregarVertice(N vertice) ;
	
	/**
	 * Metodo que elimina el vertice del Grafo Y todas las aristas adyacentes a este
	 * @param vertice : Nodo que se desa elimininar
	 * @return <b>true:</b> en caso de eliminar todas las referencias del vertice con el grafo<br>
	 *		   <b>false:</b> en caso de no encontrar el vertice en el grafo
	 */
	public boolean eliminarVertice(N vertice);
	
	/**
	 * Metodo que te permite conocer si el grafo contiene el vertice que se ingresa por parametro
	 * @param vertice : Nodo al cual se le desea verificar su presencia en el grafo
	 * @return <b>true:</b> en caso de que el grafo contenga el vertice<br>
	 * 		   <b>false:</b> en caso de que el grafo no contenga el vertice
	 */
	public boolean containsVertice(N vertice);
	
	/**
	 * Permite conocer todos los vertices adyacentes al vertice ingresado por parametro
	 * @param vertice : Nodo al cual se le desea conocer sus adyacentes
	 * @return retorna un Set que contiene todos los vertices adyacentes en caso de que el vertice del parametro no se encuentre en el grafo retorna null
	 */
	public Set<N> darAdyacentes(N vertice);
	
	/**
	 * prmite conocer todos los vertices contenidos por el grafo
	 * @return retorna un Set que contiene todos los vertices del grafo 
	 */
	public Set<N> darVertices();
	
	
	//metodos sobre las aristas
	
	/**
	 * <pre> <b>Pre:</b> La arista debe ser del mismo tipo que el grafo</pre>
	 * Permite agregar una arista, si la arista es nula no hace nada<br>
	 * En caso del que el garfo sea dirigido tiene en cuenta la direccion<br>
	 * de lo contrario asigna la arista en ambos sentidos
	 * @param arista arista que se desea agregar al grafo, si los vertices de la arista no estan en el grafo se agregan
	 */
	public void agregarArista(Arista<N> arista);
	
	/**
	 * Metodo que elimina la arista del Grafo
	 * @param origen Vertice en el cual se origina la arista
	 * @param destino Vertice en el que termina la arista
	 * @return <b>true:</b> en caso de eliminar la arista del grafo<br>
	 *		   <b>false:</b> en caso de no encontrar la arista o los vertices
	 */
	public boolean eliminarArista(N origen, N destino);
	
	/**
	 * Permite conocer la ponderacion de la arisat que une los vertices del parametro
	 * @param origen Vertice en el cual se origina la arista
	 * @param destino Vertice en el que termina la arista
	 * @return retorna un Double con la ponderacion de la arista, En caso de que la arista no exista retorna cero
	 */
	public Double darPonderacion(N origen, N destino);

	/**
	 * Permite conocer la ponderacion de la arisat que une los vertices del parametro
	 * @param origen Vertice en el cual se origina la arista
	 * @param destino Vertice en el que termina la arista
	 * @return retorna un String con la relacion que representa la arista, En caso de que la arista no exista retorna una cadena vacia
	 */
	public String darRelacion(N origen, N destino);
	
	/**
	 * Permite conocer si existe una arista entre los vertices ingresados por parametro
	 * @param origen Vertice en el cual se origina la arista
	 * @param destino Vertice en el que termina la arista
	 * @return <b>true:</b> en caso de que la arista exista<br>
	 *		   <b>false:</b> en caso de que la arista o alguno de los vertices no exista
	 */
	public boolean existeArista(N origen, N destino); 
	
	/**
	 * retorna la arista entre los vertices ingresados por parametro
	 * @param origen Vertice en el cual se origina la arista
	 * @param destino Vertice en el que termina la arista
	 * @return La arista que une los vertices
	 */
	public Arista<N> darArista(N origen, N destino);
	/**
	 * Permite conocer todos las Aristas adyacentes al vertice ingresado por parametro
	 * @param vertice : Nodo al cual se le desea conocer sus Aristas adyacentes
	 * @return retorna un Set que contiene todas las Aristas adyacentes en caso de que el vertice del parametro no se encuentre en el grafo retorna null
	 */
	public ArrayList<Arista<N>> darAristasVertice(N vertice);
	
	/**
	 * Permite conocer todos las Aristas que comforman el grafo
	 * @return retorna un Set que contiene  todos las Aristas del grafo
	 */
	public ArrayList <Arista<N>> darAristas();
	
}
