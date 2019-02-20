package modelo;

import java.io.IOException;
import java.util.HashMap;

import estructuras.GrafoLista;
import estructuras.IGrafo;

public class Mundo {

	public final static String INICIO = "inicio";
	public final static String CREDITOS = "creditos";
	public final static String PAISES = "paises";
	public final static String CIUDADES = "ciudades";

	private String estado;
	private String paisActual, ciudadActual, destinoActual;
	HashMap<String, Nodo> diccionario;
	HashMap<String, IGrafo<Nodo>> grafos;

	public final static String JAPON = "japon";
	public final static String TOKYO = "tokyo";
	public final static String KYOTO = "kyoto";
	public final static String OSAKA = "osaka";
	public final static String KUMAMOTO = "kumamoto";
	public final static String FRANCIA = "francia";
	public final static String PARIS = "paris";
	public final static String NANTES = "nantes";
	public final static String DORDOGNE = "dordogne";
	public final static String SARTHE = "sarthe";
	public final static String NORUEGA = "noruega";
	public final static String AKERSHUS = "akershus";
	public final static String BUSKERUD = "buskerud";
	public final static String OSLO = "oslo";
	public final static String VESTFOLD = "vestfold";
	public final static String ORNE = "orne";
	public final static String COLOMBIA = "colombia";
	public final static String HUILA = "huila";
	public final static String AMAZONAS = "amazonas";
	public final static String VALLE = "valle";
	public final static String CUNDINAMARCA = "cundinamarca";

	private IGrafo<Nodo> japon, tokyo, kyoto, osaka, kumamoto, francia, paris, nantes, dordogne, sarthe, noruega,
			akershus, buskerud, oslo, vestfold, orne, colombia, huila, amazonas, valle, cundinamarca;

	public Mundo() {
		setEstado(INICIO);
		grafos = new HashMap<>();
		diccionario = new HashMap<>();

		inicializar();
		try {
			cargarGrafos();
		} catch (IOException e) {
		}
	}

	public void inicializar() {

		japon = new GrafoLista<>(false);
		tokyo = new GrafoLista<>(false);
		kyoto = new GrafoLista<>(false);
		osaka = new GrafoLista<>(false);
		kumamoto = new GrafoLista<>(false);
		francia = new GrafoLista<>(false);
		paris = new GrafoLista<>(false);
		orne = new GrafoLista<>(false);
		nantes = new GrafoLista<>(false);
		dordogne = new GrafoLista<>(false);
		sarthe = new GrafoLista<>(false);
		noruega = new GrafoLista<>(false);
		akershus = new GrafoLista<>(false);
		buskerud = new GrafoLista<>(false);
		oslo = new GrafoLista<>(false);
		vestfold = new GrafoLista<>(false);
		
		colombia = new GrafoLista<>(false);
		huila = new GrafoLista<>(false);
		amazonas = new GrafoLista<>(false);
		valle = new GrafoLista<>(false);
		cundinamarca = new GrafoLista<>(false);

		grafos.put(JAPON, japon);
		grafos.put(TOKYO, tokyo);
		grafos.put(KYOTO, kyoto);
		grafos.put(OSAKA, osaka);
		grafos.put(KUMAMOTO, kumamoto);
		grafos.put(FRANCIA, francia);
		grafos.put(PARIS, paris);
		grafos.put(ORNE, orne);
		grafos.put(NANTES, nantes);
		grafos.put(DORDOGNE, dordogne);
		grafos.put(SARTHE, sarthe);
		grafos.put(NORUEGA, noruega);
		grafos.put(AKERSHUS, akershus);
		grafos.put(BUSKERUD, buskerud);
		grafos.put(OSLO, oslo);
		grafos.put(VESTFOLD, vestfold);
		
		grafos.put(COLOMBIA,colombia);
		grafos.put(HUILA, huila);
		grafos.put(VALLE, valle);
		grafos.put(CUNDINAMARCA, cundinamarca);
		grafos.put(AMAZONAS,amazonas);
		
		
	}

	public void cargarGrafos() throws IOException {

		String ruta = "./recursos/archivos/";
		Mapa.cargarPrimeraVez(japon, diccionario, ruta + JAPON + ".txt");
		Mapa.cargarPrimeraVez(tokyo, diccionario, ruta + TOKYO + ".txt");
		Mapa.cargarPrimeraVez(kyoto, diccionario, ruta + KYOTO + ".txt");
		Mapa.cargarPrimeraVez(osaka, diccionario, ruta + OSAKA + ".txt");
		Mapa.cargarPrimeraVez(kumamoto, diccionario, ruta + KUMAMOTO + ".txt");
		Mapa.cargarPrimeraVez(francia, diccionario, ruta + FRANCIA + ".txt");
		Mapa.cargarPrimeraVez(paris, diccionario, ruta + PARIS + ".txt");
		Mapa.cargarPrimeraVez(orne, diccionario, ruta + ORNE + ".txt");
		Mapa.cargarPrimeraVez(dordogne, diccionario, ruta + DORDOGNE + ".txt");
		Mapa.cargarPrimeraVez(sarthe, diccionario, ruta + SARTHE + ".txt");
		Mapa.cargarPrimeraVez(noruega, diccionario, ruta + NORUEGA + ".txt");
		Mapa.cargarPrimeraVez(akershus, diccionario, ruta + AKERSHUS + ".txt");
		Mapa.cargarPrimeraVez(buskerud, diccionario, ruta + BUSKERUD + ".txt");
		Mapa.cargarPrimeraVez(oslo, diccionario, ruta + OSLO + ".txt");
		Mapa.cargarPrimeraVez(vestfold, diccionario, ruta + VESTFOLD + ".txt");
		
		Mapa.cargarPrimeraVez(colombia, diccionario, ruta + COLOMBIA + ".txt");
		Mapa.cargarPrimeraVez(huila, diccionario, ruta + HUILA + ".txt");
		Mapa.cargarPrimeraVez(amazonas, diccionario, ruta + AMAZONAS + ".txt");
		Mapa.cargarPrimeraVez(valle, diccionario, ruta + VALLE + ".txt");
		Mapa.cargarPrimeraVez(cundinamarca, diccionario, ruta + CUNDINAMARCA + ".txt");
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPaisActual() {
		return paisActual;
	}

	public void setPaisActual(String paisActual) {
		this.paisActual = paisActual;
	}

	public String getCiudadActual() {
		return ciudadActual;
	}

	public void setCiudadActual(String ciudadActual) {
		this.ciudadActual = ciudadActual;
	}

	public String getDestinoActual() {
		return destinoActual;
	}

	public void setDestinoActual(String destinoActual) {
		this.destinoActual = destinoActual;
	}

	public IGrafo<Nodo> darGrafo(String lugar) {
		return grafos.get(lugar);
	}

	public HashMap<String, Nodo> getDiccionario() {
		return diccionario;
	}

	public void setDiccionario(HashMap<String, Nodo> diccionario) {
		this.diccionario = diccionario;
	}

	public HashMap<String, IGrafo<Nodo>> getGrafos() {
		return grafos;
	}

	public void setGrafos(HashMap<String, IGrafo<Nodo>> grafos) {
		this.grafos = grafos;
	}
}
