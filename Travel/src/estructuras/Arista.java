package estructuras;

public class Arista<N> implements Comparable<Arista<N>>{

	private String relacion;
	private Double ponderacion;
	private N origen;
	private N destino;
	

	public Arista(String relacion, Double ponderacion, N origen, N destino) {
		this.relacion = relacion;
		this.ponderacion = ponderacion;
		this.origen = origen;
		this.destino = destino;
	}

	public Arista(String relacion, N origen, N destino) {
		this.relacion = relacion;
		this.ponderacion = (double) 1;
		this.origen = origen;
		this.destino = destino;
	}

	public Arista(Double ponderacion, N origen, N destino) {
		this.relacion = "";
		this.ponderacion = ponderacion;
		this.origen = origen;
		this.destino = destino;
	}

	public Arista(N origen, N destino) {
		this.relacion = "";
		this.ponderacion = (double) 1;
		this.origen = origen;
		this.destino = destino;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public Double getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Double ponderacion) {
		this.ponderacion = ponderacion;
	}

	public N getOrigen() {
		return origen;
	}

	public void setOrigen(N origen) {
		this.origen = origen;
	}

	public N getDestino() {
		return destino;
	}

	public void setDestino(N destino) {
		this.destino = destino;
	}

	@Override
	public int compareTo(Arista<N> arista) {
		if(ponderacion > arista.ponderacion) {
			return 1;
		}else {
			return -1;
		}
	}
}
