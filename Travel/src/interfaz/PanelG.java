package interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JPanel;

import estructuras.Arista;
import estructuras.IGrafo;
import modelo.Mundo;
import modelo.Nodo;

public class PanelG extends JPanel implements MouseListener {

	private InterfazPrincipal p;
	private boolean caminoEntreCiudades;
	private boolean caminoEntreDestinos;
	private Graphics2D g2d;
	private boolean calculado;

	public PanelG(InterfazPrincipal p) {

		caminoEntreCiudades = caminoEntreDestinos = false;
		this.p = p;
		setPreferredSize(new Dimension(400, 500));
		setVisible(true);
		addMouseListener(this);
		calculado = false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		Image i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/creditosFondo.jpg");
		IGrafo<Nodo> grafo = null;

		if (p.getMundo().getEstado().equals(Mundo.INICIO)) {
			i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/giphy.gif");
			g2d.drawImage(i, 50, 10, this);
			setOpaque(false);
		} else if (p.getMundo().getEstado().equals(Mundo.CREDITOS)) {
			setOpaque(true);
			setBackground(Color.WHITE);
			i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/creditos_fondo.jpg");
			g2d.drawImage(i, 0, 0, this);
			i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/creditosAA.png");
			g2d.drawImage(i, 150, 50, this);
			
			
		} else if (p.getMundo().getEstado().equals(Mundo.PAISES)) {

			if (p.getMundo().getPaisActual() == null) {
				int x = 70;
				int y = 100;

				i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/" + Mundo.JAPON + ".png");
				g2d.drawImage(i, x, y, this);

				i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/" + Mundo.FRANCIA + ".png");
				g2d.drawImage(i, x + 155, y, this);

				i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/" + Mundo.NORUEGA + ".png");
				g2d.drawImage(i, x, y + 200, this);

				i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/" + Mundo.COLOMBIA + ".png");
				g2d.drawImage(i, x + 155, y + 200, this);

			} else {
				i = Toolkit.getDefaultToolkit()
						.getImage("./recursos/imagenes/poster_" + p.getMundo().getPaisActual() + ".jpg");
				g2d.drawImage(i, 0, 0, this);

				if (caminoEntreCiudades) {
					dibujarMapaPais(i);

					grafo = p.getMundo().darGrafo(p.getMundo().getPaisActual());
					if (grafo != null) {
						dibujarAristas(grafo.darAristas());
						dibujarVertices(grafo);

					}
				}
			}

		} else if (p.getMundo().getEstado().equals(Mundo.CIUDADES)) {

			if (p.getMundo().getCiudadActual() == null) {
				i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/fondo_color.jpg");
				g2d.drawImage(i, 0, 0, this);

				int x = 70;
				int y = 100;

				if (p.getMundo().getPaisActual().equals(Mundo.JAPON)) {

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.TOKYO + ".png");
					g2d.drawImage(i, x, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.TOKYO + ".png");
					g2d.drawImage(i, x, y + 100, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.KYOTO + ".png");
					g2d.drawImage(i, x + 155, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.KYOTO + ".png");
					g2d.drawImage(i, x + 150, y + 100, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/osaka.png");
					g2d.drawImage(i, x, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.OSAKA + ".png");
					g2d.drawImage(i, x, y + 300, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/kumamoto.png");
					g2d.drawImage(i, x + 155, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.KUMAMOTO + ".png");
					g2d.drawImage(i, x + 115, y + 300, this);

				} else if (p.getMundo().getPaisActual().equals(Mundo.FRANCIA)) {

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/paris.png");
					g2d.drawImage(i, x, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.PARIS + ".png");
					g2d.drawImage(i, x - 5, y + 100, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.DORDOGNE + ".png");
					g2d.drawImage(i, x + 150, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.DORDOGNE + ".png");
					g2d.drawImage(i, x + 105, y + 100, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.ORNE + ".png");
					g2d.drawImage(i, x, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.ORNE + ".png");
					g2d.drawImage(i, x, y + 300, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.SARTHE + ".png");
					g2d.drawImage(i, x + 150, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.SARTHE + ".png");
					g2d.drawImage(i, x + 130, y + 300, this);

				} else if (p.getMundo().getPaisActual().equals(Mundo.NORUEGA)) {

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.AKERSHUS + ".png");
					g2d.drawImage(i, x, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.AKERSHUS + ".png");
					g2d.drawImage(i, x - 35, y + 100, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.OSLO + ".png");
					g2d.drawImage(i, x + 150, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.OSLO + ".png");
					g2d.drawImage(i, x + 150, y + 100, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.BUSKERUD + ".png");
					g2d.drawImage(i, x, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.BUSKERUD + ".png");
					g2d.drawImage(i, x - 45, y + 300, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.VESTFOLD + ".png");
					g2d.drawImage(i, x + 150, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.VESTFOLD + ".png");
					g2d.drawImage(i, x + 125, y + 300, this);

				} else if (p.getMundo().getPaisActual().equals(Mundo.COLOMBIA)) {

					x -= 15;
					y -= 15;
					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.HUILA + ".png");
					g2d.drawImage(i, x - 20, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.HUILA + ".png");
					g2d.drawImage(i, x - 35, y + 100, this);

					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/ciudad/" + Mundo.CUNDINAMARCA + ".png");
					g2d.drawImage(i, x + 160, y, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.CUNDINAMARCA + ".png");
					g2d.drawImage(i, x + 70, y + 100, this);

					x += 15;
					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.VALLE + ".png");
					g2d.drawImage(i, x - 10, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.VALLE + ".png");
					g2d.drawImage(i, x - 60, y + 300, this);

					i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/ciudad/" + Mundo.AMAZONAS + ".png");
					g2d.drawImage(i, x + 150, y + 200, this);
					i = Toolkit.getDefaultToolkit()
							.getImage("./recursos/imagenes/titulo/titulo_" + Mundo.AMAZONAS + ".png");
					g2d.drawImage(i, x + 110, y + 300, this);

				}
			} else {

				dibujarMapaCiudad(i);
				grafo = p.getMundo().darGrafo(p.getMundo().getCiudadActual());
				dibujarAristas(grafo.darAristas());
				dibujarVertices(grafo);
			}

		}

		if (calculado) {

			dibujarCamino(p.darAlgo(), grafo);
		}
	}

	public void dibujarMapaCiudad(Image i) {
		i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/fondo_blanco.png");
		g2d.drawImage(i, 0, 0, this);
		i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/mapa_" + p.getMundo().getCiudadActual() + ".png");

		if (p.getMundo().getCiudadActual().equals(Mundo.TOKYO)) {
			g2d.drawImage(i, 0, 150, this);
		} else if (p.getMundo().getCiudadActual().equals(Mundo.OSLO)) {
			g2d.drawImage(i, 50, 40, this);
		} else if (p.getMundo().getCiudadActual().equals(Mundo.OSAKA)) {
			g2d.drawImage(i, 40, 40, this);
		} else if (p.getMundo().getCiudadActual().equals(Mundo.PARIS)
				|| p.getMundo().getCiudadActual().equals(Mundo.ORNE)) {
			g2d.drawImage(i, 0, 130, this);
		} else if (p.getMundo().getCiudadActual().equals(Mundo.AKERSHUS)) {
			g2d.drawImage(i, 20, 0, this);
		} else if (p.getMundo().getCiudadActual().equals(Mundo.VESTFOLD)) {
			g2d.drawImage(i, 50, 0, this);
		} else if (p.getMundo().getCiudadActual().equals(Mundo.AMAZONAS)) {
			g2d.drawImage(i, 0, 70, this);
		} else {
			g2d.drawImage(i, 0, 40, this);
		}
	}

	public void dibujarMapaPais(Image i) {
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 10, 4 }, 0));
		i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/fondo_azul.jpg");
		g2d.drawImage(i, 0, 0, this);
		i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/mapa_" + p.getMundo().getPaisActual() + ".png");

		if (p.getMundo().getPaisActual().equals(Mundo.COLOMBIA)) {
			g2d.drawImage(i, 20, 10, this);
		} else {
			g2d.drawImage(i, 0, 40, this);
		}

	}

	public void dibujarVertices(IGrafo<Nodo> grafo) {
		if (grafo != null) {

			Set<Nodo> vertices = grafo.darVertices();
			for (Nodo nodo : vertices) {

				Image i = Toolkit.getDefaultToolkit().getImage(nodo.getRuta());
				g2d.drawImage(i, nodo.getX() - 10, nodo.getY() - 25, this);
				g2d.setFont(new Font("Arial", Font.BOLD, 15));
				if (nodo.getNombre().equals("Takahata Fudoson")) {
					g2d.drawString(nodo.getNombre(), 175, 336);
				} else if (nodo.getNombre().equals("Meguro")) {
					g2d.drawString(nodo.getNombre(), 298, 300);
				} else if (nodo.getNombre().equals("Sea Life Park")) {
					g2d.drawString(nodo.getNombre(), 295, 193);
				} else if (nodo.getNombre().equals("Inokashira")) {
					g2d.drawString(nodo.getNombre(), 215, 195);
				} else if (nodo.getNombre().equals("Hamura")) {
					g2d.drawString(nodo.getNombre(), 150, 190);
				} else if (nodo.getNombre().equals("Caen")) {
					g2d.drawString(nodo.getNombre(), 92, 77);
				} else if (nodo.getNombre().equals("Burdeaux")) {
					g2d.drawString(nodo.getNombre(), 56, 370);
				} else if (nodo.getNombre().equals("Nantes")) {
					g2d.drawString(nodo.getNombre(), 20, 217);
				} else if (nodo.getNombre().equals("Limoges")) {
					g2d.drawString(nodo.getNombre(), 163, 287);
				} else if (nodo.getNombre().equals("Orleans")) {
					g2d.drawString(nodo.getNombre(), 209, 206);
				} else if (nodo.getNombre().equals("Bergen")) {
					g2d.drawString(nodo.getNombre(), 19, 327);
				} else if (nodo.getNombre().equals("Dalen")) {
					g2d.drawString(nodo.getNombre(), 49, 392);
				} else if (nodo.getNombre().equals("Tromso")) {
					g2d.drawString(nodo.getNombre(), 21, 77);
				} else if (nodo.getNombre().equals("Sapporo")) {
					g2d.drawString(nodo.getNombre(), 200, 95);
				} else if (nodo.getNombre().equals("Nikko")) {
					g2d.drawString(nodo.getNombre(), 189, 245);
				} else if (nodo.getNombre().equals("Mitake")) {
					g2d.drawString(nodo.getNombre(), 90, 155);
				} else if (nodo.getNombre().equals("Sapporo")) {
					g2d.drawString(nodo.getNombre(), 214, 99);
				} else if (nodo.getNombre().equals("Paris")) {
					g2d.drawString(nodo.getNombre(), 206, 90);
				} else if (nodo.getNombre().equals("Montpellier")) {
					g2d.drawString(nodo.getNombre(), 270, 339);
				} else if (nodo.getNombre().equals("Hachioji")) {
					g2d.drawString(nodo.getNombre(), 105, 304);
				} else if (nodo.getNombre().equals("Kazuma")) {
					g2d.drawString(nodo.getNombre(), 18, 243);
				} else if (nodo.getNombre().equals("Arashiyana")) {
					g2d.drawString(nodo.getNombre(), 150, 58);
				} else if (nodo.getNombre().equals("Kinkaku")) {
					g2d.drawString(nodo.getNombre(), 75, 115);
				} else if (nodo.getNombre().equals("Hokanji")) {
					g2d.drawString(nodo.getNombre(), 156, 177);
				} else if (nodo.getNombre().equals("Shugakuin")) {
					g2d.drawString(nodo.getNombre(), 30, 246);
				} else if (nodo.getNombre().equals("International Manga")) {
					g2d.drawString(nodo.getNombre(), 243, 194);
				} else if (nodo.getNombre().equals("Fushimi Inari-taisha")) {
					g2d.drawString(nodo.getNombre(), 258, 467);
				} else if (nodo.getNombre().equals("Sanzen-in")) {
					g2d.drawString(nodo.getNombre(), 117, 275);
				} else if (nodo.getNombre().equals("Arashiyama")) {
					g2d.drawString(nodo.getNombre(), 152, 66);
				} else if (nodo.getNombre().equals("Heian Shrine")) {
					g2d.drawString(nodo.getNombre(), 269, 292);
				} else if (nodo.getNombre().equals("Boyaca")) {
					g2d.drawString(nodo.getNombre(), 205, 204);
				}else if (nodo.getNombre().equals("Huila")) {
					g2d.drawString(nodo.getNombre(), 175, 300);
				}else if (nodo.getNombre().equals("Caqueta")) {
					g2d.drawString(nodo.getNombre(), 121, 375);
				}else if (nodo.getNombre().equals("Nariño")) {
					g2d.drawString(nodo.getNombre(), 39, 330);
				}else if (nodo.getNombre().equals("Antioquia")) {
					g2d.drawString(nodo.getNombre(), 50, 155);
				}else if (nodo.getNombre().equals("Valle del cauca")) {
					g2d.drawString(nodo.getNombre(), 5, 236);
				}else if (nodo.getNombre().equals("Tatacoa")) {
					g2d.drawString(nodo.getNombre(), 206, 100);
				}else if (nodo.getNombre().equals("Colonial")) {
					g2d.drawString(nodo.getNombre(), 113, 172);
				}else if (nodo.getNombre().equals("SanAgustin")) {
					g2d.drawString(nodo.getNombre(), 108, 423);
				}else if (nodo.getNombre().equals("Ovnipuerto")) {
					g2d.drawString(nodo.getNombre(), 295, 199);
				}else if (nodo.getNombre().equals("Noe")) {
					g2d.drawString(nodo.getNombre(), 84, 289);
				}else if (nodo.getNombre().equals("Volcanes")) {
					g2d.drawString(nodo.getNombre(), 321,316);
				}else if (nodo.getNombre().equals("Macadamia")) {
					g2d.drawString(nodo.getNombre(), 31, 350);
				}else if (nodo.getNombre().equals("Santa Cruz")) {
					g2d.drawString(nodo.getNombre(), 138, 337);
				}else if (nodo.getNombre().equals("Finkana")) {
					g2d.drawString(nodo.getNombre(), 70, 232);
				}else if (nodo.getNombre().equals("Encantado")) {
					g2d.drawString(nodo.getNombre(), 70, 123);
				}else if (nodo.getNombre().equals("Zipaquira")) {
					g2d.drawString(nodo.getNombre(), 247, 159);
				}else if (nodo.getNombre().equals("Rayo")) {
					g2d.drawString(nodo.getNombre(), 269, 180);
				}else if (nodo.getNombre().equals("Ermita")) {
					g2d.drawString(nodo.getNombre(), 288, 205);
				}else if (nodo.getNombre().equals("Uramba")) {
					g2d.drawString(nodo.getNombre(), 69, 288);
				}else if (nodo.getNombre().equals("Amacuya")) {
					g2d.drawString(nodo.getNombre(), 211, 194);
				}else if (nodo.getNombre().equals("Pure")) {
					g2d.drawString(nodo.getNombre(), 334, 207);
				}else if (nodo.getNombre().equals("Indigen")) {
					g2d.drawString(nodo.getNombre(), 305, 389);
				}else {
					g2d.drawString(nodo.getNombre(), nodo.getX() + 7, nodo.getY() + 15);
				}

			}

		}

	}

	public void dibujarAristas(ArrayList<Arista<Nodo>> aristas) {

		for (int i = 0; i < aristas.size(); i++) {
			Arista<Nodo> arista = aristas.get(i);
			g2d.setStroke(
					new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 10, 4 }, 0));

			g2d.drawLine(arista.getOrigen().getX(), arista.getOrigen().getY(), arista.getDestino().getX(),
					arista.getDestino().getY());
		}

	}

	public void dibujarCamino(ArrayList<Arista<Nodo>> camino, IGrafo<Nodo> grafo) {
		removeAll();

		Image i = Toolkit.getDefaultToolkit().getImage("./recursos/imagenes/creditosFondo.jpg");
		if (isCaminoEntreCiudades()) {
			dibujarMapaPais(i);
		} else if (isCaminoEntreDestinos()) {
			dibujarMapaCiudad(i);
		}

		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 10, 4 }, 0));

		g2d.setColor(Color.RED);
		dibujarAristas(camino);
		dibujarVertices(grafo);
		revalidate();
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		p.getMundo();
		System.out.println(e.getX() + " " + e.getY());
		if (p.getMundo().getEstado().equals(Mundo.PAISES) && p.getMundo().getPaisActual() == null) {
			if (e.getX() >= 67 && e.getX() <= 160 && e.getY() >= 100 && e.getY() <= 190) {
				p.getMundo();
				p.explorarPais(Mundo.JAPON);
			} else if (e.getX() >= 224 && e.getX() <= 315 && e.getY() >= 100 && e.getY() <= 190) {
				p.explorarPais(Mundo.FRANCIA);
			} else if (e.getX() >= 65 && e.getX() <= 170 && e.getY() >= 298 && e.getY() <= 400) {
				p.explorarPais(Mundo.NORUEGA);
			} else if (e.getX() >= 224 && e.getX() <= 315 && e.getY() >= 298 && e.getY() <= 400) {
				p.explorarPais(Mundo.COLOMBIA);
			}
		} else if (p.getMundo().getEstado().equals(Mundo.CIUDADES) && p.getMundo().getPaisActual() != null
				&& caminoEntreCiudades == false && p.getMundo().getCiudadActual() == null) {
			if (p.getMundo().getPaisActual() == Mundo.JAPON) {
				if (e.getX() >= 70 && e.getX() <= 160 && e.getY() >= 102 && e.getY() <= 240) {
					p.explorarCiudad(Mundo.TOKYO);
				} else if (e.getX() >= 225 && e.getX() <= 315 && e.getY() >= 108 && e.getY() <= 227) {
					p.explorarCiudad(Mundo.KYOTO);
				} else if (e.getX() >= 65 && e.getX() <= 155 && e.getY() >= 298 && e.getY() <= 428) {
					p.explorarCiudad(Mundo.OSAKA);
				} else if (e.getX() >= 224 && e.getX() <= 314 && e.getY() >= 298 && e.getY() <= 428) {
					p.explorarCiudad(Mundo.KUMAMOTO);
				}
			} else if (p.getMundo().getPaisActual() == Mundo.FRANCIA) {
				if (e.getX() >= 70 && e.getX() <= 160 && e.getY() >= 102 && e.getY() <= 240) {
					p.explorarCiudad(Mundo.PARIS);
				} else if (e.getX() >= 225 && e.getX() <= 315 && e.getY() >= 108 && e.getY() <= 227) {
					p.explorarCiudad(Mundo.DORDOGNE);
				} else if (e.getX() >= 65 && e.getX() <= 155 && e.getY() >= 298 && e.getY() <= 428) {
					p.explorarCiudad(Mundo.ORNE);
				} else if (e.getX() >= 224 && e.getX() <= 314 && e.getY() >= 298 && e.getY() <= 428) {
					p.explorarCiudad(Mundo.SARTHE);
				}
			} else if (p.getMundo().getPaisActual() == Mundo.NORUEGA) {
				if (e.getX() >= 70 && e.getX() <= 160 && e.getY() >= 102 && e.getY() <= 240) {
					p.explorarCiudad(Mundo.AKERSHUS);
				} else if (e.getX() >= 225 && e.getX() <= 315 && e.getY() >= 108 && e.getY() <= 227) {
					p.explorarCiudad(Mundo.OSLO);
				} else if (e.getX() >= 65 && e.getX() <= 155 && e.getY() >= 298 && e.getY() <= 428) {
					p.explorarCiudad(Mundo.BUSKERUD);
				} else if (e.getX() >= 224 && e.getX() <= 314 && e.getY() >= 298 && e.getY() <= 428) {
					p.explorarCiudad(Mundo.VESTFOLD);
				}
			} else if (p.getMundo().getPaisActual() == Mundo.COLOMBIA) {
				if (e.getX() >= 37 && e.getX() <= 115 && e.getY() >= 83 && e.getY() <= 217) {
					p.explorarCiudad(Mundo.HUILA);
				} else if (e.getX() >= 165 && e.getX() <= 375 && e.getY() >= 83 && e.getY() <= 217) {
					p.explorarCiudad(Mundo.CUNDINAMARCA);
				} else if (e.getX() >= 35 && e.getX() <= 163 && e.getY() >= 285 && e.getY() <= 440) {
					p.explorarCiudad(Mundo.VALLE);
				} else if (e.getX() >= 224 && e.getX() <= 314 && e.getY() >= 285 && e.getY() <= 440) {
					p.explorarCiudad(Mundo.AMAZONAS);
				}
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isCaminoEntreCiudades() {
		return caminoEntreCiudades;
	}

	public void setCaminoEntreCiudades(boolean caminoEntreCiudades) {
		this.caminoEntreCiudades = caminoEntreCiudades;
	}

	public boolean isCaminoEntreDestinos() {
		return caminoEntreDestinos;
	}

	public void setCaminoEntreDestinos(boolean caminoEntreDestinos) {
		this.caminoEntreDestinos = caminoEntreDestinos;
	}

	public void setCalculado(boolean calculado) {
		this.calculado = calculado;
	}
}
