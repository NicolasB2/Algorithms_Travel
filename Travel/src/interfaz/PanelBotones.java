package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Mundo;

public class PanelBotones extends JPanel implements ActionListener {

	public final static String CREDITOS = "creditos";
	public final static String MENU = "menu";
	public final static String PAISES = "paises";
	public final static String CIUDADES = "ciudades";
	public final static String CAMINO_CIUDADES = "camino_ciudades";
	public final static String CAMINO_DESTINOS = "camino_destinos";

	private InterfazPrincipal principal;
	private JButton btnCreditos;
	private JButton btnMenu;
	private JButton btnPaises;
	private JButton btnCiudades;
	private JButton btnCaminoEntreCiudades;
	private JButton btnCaminoEntreDestinos;

	public PanelBotones(InterfazPrincipal principal) {

		this.principal = principal;
		setLayout(new GridLayout(1, 4));
		setPreferredSize(new Dimension(400, 100));

		inicializarBotones();
		agregarbotones(principal.getMundo().getEstado());

	}

	public void agregarbotones(String estado) {
		removeAll();
//		System.out.println(principal.getMundo().getEstado());
		if (estado.equals(Mundo.INICIO)) {
			add(btnPaises);
			add(btnMenu);
			add(btnCreditos);

		} else if (estado.equals(Mundo.CREDITOS)) {

			add(btnMenu);
			add(btnCreditos);
		} else if (estado.equals(Mundo.PAISES)) {

			add(btnCaminoEntreCiudades);
			if (!principal.getPanelg().isCaminoEntreCiudades()) {
				add(btnCiudades);
				add(btnMenu);
				add(btnCreditos);
			} else if (principal.getPanelg().isCaminoEntreCiudades()) {

				add(btnCiudades);
				add(btnCaminoEntreDestinos);
				add(btnMenu);
			}
		} else if (estado.equals(Mundo.CIUDADES)) {

			if(principal.getMundo().getCiudadActual() == null){
				add(btnCaminoEntreCiudades);
				add(btnCiudades);
				add(btnMenu);
				add(btnCreditos);
			}else{
				
				add(btnCiudades);
				add(btnCaminoEntreDestinos);
				add(btnMenu);
				add(btnCreditos);
			}
		}
		repaint();
		revalidate();
	}

	private void inicializarBotones() {

		btnCreditos = new JButton();
		btnCreditos.addActionListener(this);
		btnCreditos.setActionCommand(CREDITOS);
		btnCreditos.setIcon(new ImageIcon("./recursos/imagenes/creditos.png"));
		btnCreditos.setOpaque(false);
		btnCreditos.setContentAreaFilled(false);
		btnCreditos.setBorderPainted(false);
		btnCreditos.setToolTipText("CRÉDITOS");

		btnMenu = new JButton();
		btnMenu.addActionListener(this);
		btnMenu.setActionCommand(MENU);
		btnMenu.setIcon(new ImageIcon("./recursos/imagenes/menu.png"));
		btnMenu.setOpaque(false);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setToolTipText("MENÚ PRINCIPAL");

		btnPaises = new JButton();
		btnPaises.addActionListener(this);
		btnPaises.setActionCommand(PAISES);
		btnPaises.setIcon(new ImageIcon("./recursos/imagenes/paises.png"));
		btnPaises.setOpaque(false);
		btnPaises.setContentAreaFilled(false);
		btnPaises.setBorderPainted(false);
		btnPaises.setToolTipText("PAÍSES");

		btnCiudades = new JButton();
		btnCiudades.addActionListener(this);
		btnCiudades.setActionCommand(CIUDADES);
		btnCiudades.setIcon(new ImageIcon("./recursos/imagenes/ciudades.png"));
		btnCiudades.setOpaque(false);
		btnCiudades.setContentAreaFilled(false);
		btnCiudades.setBorderPainted(false);
		btnCiudades.setToolTipText("CIUDADES");

		btnCaminoEntreCiudades = new JButton();
		btnCaminoEntreCiudades.addActionListener(this);
		btnCaminoEntreCiudades.setActionCommand(CAMINO_CIUDADES);
		btnCaminoEntreCiudades.setIcon(new ImageIcon("./recursos/imagenes/camino_ciudades.png"));
		btnCaminoEntreCiudades.setOpaque(false);
		btnCaminoEntreCiudades.setContentAreaFilled(false);
		btnCaminoEntreCiudades.setBorderPainted(false);
		btnCaminoEntreCiudades.setToolTipText("MAPA");

		btnCaminoEntreDestinos = new JButton();
		btnCaminoEntreDestinos.addActionListener(this);
		btnCaminoEntreDestinos.setActionCommand(CAMINO_DESTINOS);
		btnCaminoEntreDestinos.setIcon(new ImageIcon("./recursos/imagenes/camino_destinos.png"));
		btnCaminoEntreDestinos.setOpaque(false);
		btnCaminoEntreDestinos.setContentAreaFilled(false);
		btnCaminoEntreDestinos.setBorderPainted(false);
		btnCaminoEntreDestinos.setToolTipText("INFORMACIÓN");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		principal.getPanelg().setCalculado(false);
		if (command.equals(CREDITOS)) {
			principal.irACreditos();

		} else if (command.equals(MENU)) {
			principal.irAMenu();

		} else if (command.equals(PAISES)) {
			principal.irAPaises();
		} else if (command.equals(CAMINO_CIUDADES)) {
			 principal.getMundo().setEstado(Mundo.PAISES);
			 principal.getPanelg().setCaminoEntreCiudades(true);
			 agregarbotones(Mundo.PAISES);
			 principal.revalidate();
			 principal.repaint();

			principal.irACaminoCiudades();

		} else if (command.equals(CIUDADES)) {
			principal.irACiudades();
		} else if (command.equals(CAMINO_DESTINOS)) {
			principal.dialogoMetodos();
		}

	}

}
