package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import estructuras.IGrafo;
import metodos.ArbolGeneradorMinimo;
import metodos.Recorridos;
import modelo.Nodo;

public class DialogoMetodos  extends JDialog implements ActionListener {

	private static final String CANCELAR = "Cancelar";
	private static final String ARBOL = "Arbol";
	private static final String CAMINO = "Camino"; 
	private static final String BFS = "BFS";
	
	private JButton btnCancelar;
	private JButton btnArbol;
	private JButton btnCamino;
	private JButton btnBFS;
	
	private DialogoCaminos dc;
	private InterfazPrincipal principal;
	private IGrafo<Nodo> grafo;
	
	public DialogoMetodos(InterfazPrincipal principal, IGrafo<Nodo> grafo) {
		this.principal=principal;
		this.grafo=grafo;
		inicializar();
		
		dc=new DialogoCaminos(principal, grafo);
				
		setSize(250, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		
		inicializar();
		add(btnBFS);
		add(btnArbol);
		add(btnCamino);
		add(btnCancelar);
		
	}
	
	public void inicializar(){
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);

		
		btnArbol = new JButton("<html>   Tour<br>Completo</html>");
		btnArbol.setActionCommand(ARBOL);
		btnArbol.addActionListener(this);
		
		btnBFS = new JButton("<html>Listado por <br>anchura</html>");
		btnBFS.setActionCommand(BFS);
		btnBFS.addActionListener(this);

		
		btnCamino = new JButton("<html>Ruta minima<br>entre dos lugares</html>");
		btnCamino.setActionCommand(CAMINO);
		btnCamino.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		String comando = a.getActionCommand();
		if (CANCELAR.equals(comando)) {
			this.setVisible(false);
		}
		else if (ARBOL.equals(comando)) {
			ArbolGeneradorMinimo<Nodo> arb = new ArbolGeneradorMinimo<>();
			IGrafo<Nodo> ret= arb.kruskal(grafo);
			principal.repintarCamino(ret.darAristas(), ret);
			this.setVisible(false);
		}else if (BFS.equals(comando)) {
			Recorridos<Nodo> reco = new Recorridos<>();
			String j= "Listado por anchura:\n";
			Set<Nodo> vertices =  grafo.darVertices();
			Nodo p = null;
			for (Nodo n : vertices) {
				p=n;
			}
			ArrayList<Nodo> ret = reco.bfs(grafo, p);
			for (int i = 0; i < ret.size(); i++) {
				j+=ret.get(i).getNombre()+"\n";
			}
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, j);
			
		}else if(CAMINO.equals(comando)) {
			this.setVisible(false);
			dc.setVisible(true);
			
		}
	}
	
}
