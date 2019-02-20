
package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import estructuras.Arista;
import estructuras.GrafoLista;
import estructuras.IGrafo;
import metodos.ArbolGeneradorMinimo;
import metodos.CaminoMinimo;
import modelo.DestinoTuristico;
import modelo.Nodo;

public class DialogoCaminos extends JDialog implements ActionListener {

	private static final String OK = "ok";

	private InterfazPrincipal principal;
	private IGrafo<Nodo> grafo;
	private JButton btnOk;
	private JComboBox<String> lugarOrigen;
	private JComboBox<String> lugarDestino;
	private JLabel lblOrigen;
	private JLabel lblDestino;

	public DialogoCaminos(InterfazPrincipal principal, IGrafo<Nodo> grafo) {
		super(principal, true);
		this.principal = principal;
		this.grafo = grafo;
		Set<Nodo> vertices = grafo.darVertices();
		String[] lista = new String[vertices.size()];
		int c = 0;

		for (Nodo nodo : vertices) {
			lista[c] = nodo.getNombre();
			c++;
		}

		setSize(280, 230);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel panelLugares = new JPanel();
		panelLugares.setLayout(new GridLayout(5, 1));
		panelLugares.setBorder(new TitledBorder("Camino minimo"));
		panelLugares.setBackground(Color.WHITE);

		lugarOrigen = new JComboBox<>(new DefaultComboBoxModel<>(lista));
		lugarDestino = new JComboBox<>(new DefaultComboBoxModel<>(lista));
		lblOrigen = new JLabel("Selecione lugar de origen:");
		lblDestino = new JLabel("Seleccione lugar de desitno: ");

		btnOk = new JButton("Ok");
		btnOk.setActionCommand(OK);
		btnOk.addActionListener(this);

		panelLugares.add(lblOrigen);
		panelLugares.add(lugarOrigen);
		panelLugares.add(lblDestino);
		panelLugares.add(lugarDestino);
		panelLugares.add(btnOk);

		add(panelLugares, BorderLayout.NORTH);

		setModal(true);
		setLocationRelativeTo(principal);
		setResizable(false);
	}

	public void limpiar() {

		lugarOrigen.setSelectedIndex(0);
		lugarDestino.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent pEvento) {
		String comando = pEvento.getActionCommand();
		if (OK.equals(comando)) {
			try {
				String origenSeleccionado = (String) lugarOrigen.getSelectedItem();
				String destinoSeleccionado = (String) lugarDestino.getSelectedItem();

				Nodo origen = principal.getMundo().getDiccionario().get(origenSeleccionado);
				Nodo destino = principal.getMundo().getDiccionario().get(destinoSeleccionado);

				System.out.println(grafo.containsVertice(origen) + "  " + grafo.containsVertice(destino));

				CaminoMinimo<Nodo> cm = new CaminoMinimo<>();
				ArrayList<Arista<Nodo>> caminoMinimo = cm.dijkstra(grafo, origen, destino);

				int km = 0;
				String m = "EL camino que se deb seguir es el siguiente:\n";
				for (int i = caminoMinimo.size() - 1; i >= 0; i--) {
					m += "De: " + caminoMinimo.get(i).getOrigen().getNombre() + " a: "
							+ caminoMinimo.get(i).getDestino().getNombre() + "\n";

					km += caminoMinimo.get(i).getPonderacion();
				}

				principal.repintarCamino(caminoMinimo, grafo);
				setVisible(false);
				String mensaje = "Lugar de origen: " + origenSeleccionado + "\nLugar de destino: " + destinoSeleccionado
						+ "\n\n" + m + "\nTotal de km: " + km;
				JOptionPane.showMessageDialog(this, mensaje);
			} catch (Exception e) {
				System.out.println("b");
			}
		}
	}

}