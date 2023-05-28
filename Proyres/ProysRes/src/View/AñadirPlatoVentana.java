package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.*;

public class AñadirPlatoVentana extends JFrame {

	public ControladorAñadirPlato controlador;
	private JFrame marco;
	private JPanel panel;

	private JMenu menu;

	public static void main(String[] args) {

		AñadirPlatoVentana v = new AñadirPlatoVentana();

	}

	public AñadirPlatoVentana() {

		IniciarVentana();
	}

	public void IniciarVentana() {
		controlador = new ControladorAñadirPlato(this);
		ArrayList<Plato> TotalPlatos = new ArrayList<>();
		marco = new JFrame();
		marco.setBounds(100, 100, 600, 500);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.getContentPane().setLayout(new FlowLayout());
		marco.setResizable(false);
		marco.setVisible(true);

		setLayout(new FlowLayout()); // Se utiliza FlowLayout como administrador de diseño

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// Añade OPCION a la barra
		JMenu mnNewMenu = new JMenu("Opcion");
		menuBar.add(mnNewMenu);

		// Añade el salir a la barra con el action listener incorporado para que salga
		// del sistema

		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setVisible(false);
			}
		});

		mnNewMenu.add(mntmNewMenuItem);

		marco.add(menuBar);

		int respuesta = JOptionPane.showConfirmDialog(null, "¿Tienes alguna alergia?", "Atención, lea atentamente",
				JOptionPane.YES_NO_OPTION);

		if (respuesta == JOptionPane.YES_OPTION) {

			String[] alergias = JOptionPane
					.showInputDialog(
							"Escriba las alergias separado por comas: \n - Gluten \n - Marisco \n - Frutos Secos \n"
									+ "- Lactosa \n - Huevos \n - Pescado \n - Soja \n - Vegetariano \n")
					.toLowerCase().replaceAll("\\s", "").split(",");

			if (!alergias[0].equals("")) {
				TotalPlatos = Alergia.filtrarPlatos(alergias);
			} else {

				String aux[] = new String[1];
				aux[0] = "ninguna";
				TotalPlatos = Alergia.filtrarPlatos(aux);
			}
		}

		// Bucle que baya creando botones y añadiendolos al carrito
		else {
			TotalPlatos = Pedido.SacarInstanciasPlato();
		}

		// Aqui genera botones en funcion del Plato que saca del arrayList de platos
		// Cada plato tiene su actionPerformed interno al crearse, es decir
		// al crearse ya incorpora el metodo que coje del controlador del carrito
		// Los platos que tiene y añade a este carrito el nuevo plato

		for (Plato p : TotalPlatos) {
			JButton platos = new JButton(p.getNombrePlato() + " : " + p.getPrecio() + "€");
			platos.setBounds(45, 140, 250, 46);
			platos.setVisible(true);
			marco.add(platos);
			platos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Plato> lista = ControladorCarrito.getListaPlatos();
					lista.add(p);
					ControladorCarrito.actualizarPedido(p);
					System.out.println("xd");
				}
			});

		}
		pack();

		marco.setVisible(true);
	}
}
