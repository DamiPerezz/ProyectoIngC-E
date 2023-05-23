package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

//QUE EST ESOBIHGFJDSKLFJ

public class VentanaCarrito extends JFrame {
	public ControladorCarrito controlador;

	public JButton bep;
	private static boolean abierta = false;
	public JButton cp;

	private static String pedidoActual = "";
	private static float precioTotal = 0;
	
	
	
	public static void actualizarPedido(String texto, float precio) {

		pedidoActual += texto;
		precioTotal += precio;
	}

	public VentanaCarrito() {

	}
	
	public void asegurarVentana() {
		pedidoActual = "";
		precioTotal = 0;
		abierta = false;
	}

	public void initialize() {

		if(abierta) {
			System.out.println("esta abierta melon");
		}else {
		
			abierta = true;
			
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				abierta = false;
			
				
			}
		}
//se activa cuando se cierra.
		
				);

		JPanel panelCarrito = new JPanel();

		panelCarrito.setLayout(new BorderLayout());

		bep = new JButton("Finalizar pedido");

		JLabel texto = new JLabel("Pedido actual:");
		JLabel listado = new JLabel("<html>" + pedidoActual + "</html>");
		JLabel precioFinal = new JLabel("Importe Total:" + precioTotal);
		
		bep.setPreferredSize(new Dimension(100, 50));

		panelCarrito.add(texto, BorderLayout.NORTH);
		panelCarrito.add(bep, BorderLayout.SOUTH);
		panelCarrito.add(listado, BorderLayout.CENTER);
		panelCarrito.add(precioFinal, BorderLayout.EAST);
		this.getContentPane().add(panelCarrito);
		this.setResizable(false);
		this.setSize(new Dimension(450, 450));

		bep.addActionListener(controlador);
		this.setVisible(true);
		}
	}

}
