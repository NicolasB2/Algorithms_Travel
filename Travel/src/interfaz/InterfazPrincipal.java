package interfaz;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import estructuras.Arista;
import estructuras.IGrafo;
import hilo.HiloMusica;
import modelo.Mundo;
import modelo.Nodo;

public class InterfazPrincipal extends JFrame {

	private HiloMusica musica;
	private Mundo mundo;
	private PanelBotones panelBotones;
	private PanelG panelg;
	private DialogoMetodos dialogoM;
	private DialogoCaminos dialogoC;
	ArrayList<Arista<Nodo>> camino;

	public InterfazPrincipal() {

		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Travel - by NCS");
		mundo = new Mundo();
		musica = new HiloMusica(mundo);
		panelBotones = new PanelBotones(this);
		panelg = new PanelG(this);

		add(panelg, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

		setVisible(true);
		pack();
	}

	public Mundo getMundo() {
		return mundo;
	}

	public void irAMenu() {
		mundo.setEstado(Mundo.INICIO);

		panelg.setCaminoEntreCiudades(false);
		panelg.repaint();

		panelBotones.agregarbotones(mundo.getEstado());
		panelBotones.repaint();

		repaint();

		if (musica.isAlive()) {
			musica.detener();
			musica = new HiloMusica(mundo);
		}
	}

	public void irACreditos() {
		mundo.setEstado(Mundo.CREDITOS);
		mundo.setPaisActual(null);

		panelg.setCaminoEntreCiudades(false);
		panelg.repaint();

		panelBotones.agregarbotones(mundo.getEstado());
		panelBotones.repaint();

		repaint();

		if (musica.isAlive()) {
			musica.detener();
			musica = new HiloMusica(mundo);
		}
	}

	public void irAPaises() {
		mundo.setEstado(Mundo.PAISES);
		mundo.setPaisActual(null);

		panelg.setCaminoEntreCiudades(false);
		panelg.repaint();

		panelBotones.repaint();

		repaint();

		if (musica.isAlive()) {
			musica.detener();
			musica = new HiloMusica(mundo);
		}
	}

	public void irACaminoCiudades() {
		mundo.setEstado(Mundo.PAISES);
		panelg.setCaminoEntreCiudades(true);
		panelBotones.agregarbotones(Mundo.PAISES);
		
		revalidate();
		repaint();		
	}

	public void irACiudades() {
		mundo.setEstado(Mundo.CIUDADES);
		panelg.setCaminoEntreCiudades(false);
		mundo.setCiudadActual(null);
		panelBotones.agregarbotones(Mundo.CIUDADES);

		
		panelg.repaint();

		panelBotones.repaint();

		repaint();
		
	

	}

	public void explorarPais(String paisActual) {
		mundo.setEstado(Mundo.PAISES);
		mundo.setPaisActual(paisActual);

		panelg.setCaminoEntreCiudades(false);
		panelg.repaint();

		panelBotones.agregarbotones(mundo.getEstado());
		panelBotones.repaint();
		repaint();

		musica.start();
	}

	
	public void explorarCiudad(String ciudadActual) {
		mundo.setEstado(Mundo.CIUDADES);
		mundo.setCiudadActual(ciudadActual);
		
		panelg.setCaminoEntreDestinos(false);
		panelg.repaint();
		
		panelBotones.agregarbotones(mundo.getEstado());
		panelBotones.repaint();
		repaint();
	}
	
	public void dialogoMetodos(){
		if(mundo.getEstado().equals(Mundo.PAISES) && mundo.getPaisActual() != null){
			dialogoM = new DialogoMetodos(this,mundo.darGrafo(mundo.getPaisActual()));
			
		}else if(mundo.getEstado().equals(Mundo.CIUDADES) && mundo.getCiudadActual() != null){
			dialogoM = new DialogoMetodos(this,mundo.darGrafo(mundo.getCiudadActual()));
		}
		 dialogoM.setVisible( true );
	}
	public void dialogoCaminos() {
		
		
		if(mundo.getEstado().equals(Mundo.PAISES) && mundo.getPaisActual() != null){
			dialogoC = new DialogoCaminos(this,mundo.darGrafo(mundo.getPaisActual()));
			
		}else if(mundo.getEstado().equals(Mundo.CIUDADES) && mundo.getCiudadActual() != null){
			dialogoC = new DialogoCaminos(this,mundo.darGrafo(mundo.getCiudadActual()));
		}
		
		dialogoM.setVisible(false);
         dialogoC.setVisible( true );
	}
	
	
	public PanelG getPanelg() {
		return panelg;
	}

	public static void main(String[] args) {
		InterfazPrincipal principal = new InterfazPrincipal();
	}
	
	public void repintarCamino(ArrayList<Arista<Nodo>> camino,IGrafo<Nodo> grafo){
		panelg.setCalculado(true);
		this.camino=camino;
		repaint();
		revalidate();
	}
	public ArrayList<Arista<Nodo>> darAlgo(){
		return camino;
	}
}
