package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Menu;
import Model.Plato;

import javax.swing.JLabel;

import java.util.ArrayList;

//QUE EST ESOBIHGFJDSKLFJ

public class VentanaCarrito extends JFrame {
	public ControladorCarrito controlador;

	public JButton bep;
	private static boolean abierta = false;
	public JButton cp;
	private static ArrayList<String> pedidoActualPlatos = new ArrayList<>();
	private static ArrayList<String> pedidoActualMenus = new ArrayList<>();
	private static float precioTotal = 0;
	

	public static void actualizarPedido(Plato p) {

		pedidoActualPlatos.add(p.getNombrePlato() + "," + p.getPrecio() + '\n');
		precioTotal += p.getPrecio();

	}

	public static void actualizarPedido(Menu m) {
		ArrayList<Plato> listado = new ArrayList<>();
		listado = m.getListaPlatos();
		String texto = "";
		texto += ("Menú del día: " + m.getPrecio());
		for (Plato p : listado) {

			texto += "- " + p.getNombrePlato() + '\n';

		}
		pedidoActualMenus.add(texto);
		precioTotal += m.getPrecio();
	}

//	public static void actualizarPedido(String texto, float precio) {
//
//		pedidoActualPlatos += texto;
//		precioTotal += precio;
//	}

	public VentanaCarrito() {

	}

	public void asegurarVentana() {
		pedidoActualPlatos.clear();
		pedidoActualMenus.clear();
		precioTotal = 0;
		abierta = false;
	}

	public void initialize() {

		if (abierta) {
			System.out.println("esta abierta melon");
		} else {

			abierta = true;

			this.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent e) {
					abierta = false;

				}
			}
//se activa cuando se cierra.

			);

			JPanel panelCarrito = new JPanel();

			panelCarrito.setLayout(new FlowLayout());

			bep = new JButton("Finalizar pedido");

			JLabel texto = new JLabel("Pedido actual:");

			for (String s : pedidoActualPlatos) {
				JLabel listado = new JLabel("<html>" + s + "</html>");
				panelCarrito.add(listado, BorderLayout.CENTER);

				JButton platos = new JButton("X");
				platos.setBounds(45, 140, 194, 46);
				platos.setVisible(true);
				panelCarrito.add(platos);
				platos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panelCarrito.remove(listado);
						panelCarrito.remove(platos);
						panelCarrito.repaint();

						controlador.borrarPlato(pedidoActualPlatos.indexOf(s));
						pedidoActualPlatos.remove(pedidoActualPlatos.indexOf(s));
						System.out.println("No xd");
					}
				});
			}
			
			for (String m : pedidoActualMenus) {
				JLabel listado = new JLabel("<html>" + m + "</html>");
				panelCarrito.add(listado, BorderLayout.CENTER);

				JButton platos = new JButton("Quitar menú");
				platos.setBounds(45, 140, 194, 46);
				platos.setVisible(true);
				panelCarrito.add(platos);
				platos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						panelCarrito.remove(listado);
						panelCarrito.remove(platos);
						panelCarrito.repaint();

						controlador.borrarMenu(pedidoActualMenus.indexOf(m));
						pedidoActualMenus.remove(pedidoActualMenus.indexOf(m));
						
						
						System.out.println("No xd");
					}
				});
			}

			JLabel precioFinal = new JLabel("Importe Total:" + precioTotal);

			bep.setPreferredSize(new Dimension(100, 50));

			panelCarrito.add(texto, BorderLayout.NORTH);
			panelCarrito.add(bep, BorderLayout.SOUTH);

			panelCarrito.add(precioFinal, BorderLayout.EAST);
			this.getContentPane().add(panelCarrito);
			this.setResizable(false);
			this.setSize(new Dimension(450, 450));

			bep.addActionListener(controlador);
			this.setVisible(true);
		}
		
		
	}
	public void actualizarPrecio(float d) {
		
		precioTotal -= d;
		
	}
	

}
