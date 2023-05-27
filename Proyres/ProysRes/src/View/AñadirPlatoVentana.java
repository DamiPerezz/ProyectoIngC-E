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
import javax.swing.JPanel;

import Model.*;

public class AñadirPlatoVentana extends JFrame{

	public ControladorAñadirPlato controlador;
	private JFrame marco;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu menu;
	public JButton atras;

	
	public static void main(String[] args) {
		
		AñadirPlatoVentana v = new AñadirPlatoVentana();
		
	}
	
	public AñadirPlatoVentana() {
		
		IniciarVentana();
	}
	
	
	public void IniciarVentana( ) {
		controlador = new ControladorAñadirPlato(this);
		
		marco = new JFrame();
		marco.setBounds(100, 100, 499, 322);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.getContentPane().setLayout(new FlowLayout());
        marco.setVisible(true);
        
        atras = new JButton("atras");
        atras.setMnemonic(KeyEvent.VK_M); //activar el boton para poder pulsarle
		atras.setBounds(45, 140, 194, 46);
		setLayout(new FlowLayout()); // Se utiliza FlowLayout como administrador de diseño
        add(atras);
		marco.add(atras);
		marco.setVisible(true);
        atras.addActionListener(controlador);
		
        
		//Bucle que baya creando botones y añadiendolos al carrito
		ArrayList<Plato> TotalPlatos = Pedido.SacarInstanciasPlato();
		
		//Aqui genera botones en funcion del Plato que saca del arrayList de platos
		//Cada plato tiene su actionPerformed interno al crearse, es decir
		//al crearse ya incorpora el metodo que coje del controlador del carrito
		//Los platos que tiene y añade a este carrito el nuevo plato
		
		for (Plato p : TotalPlatos) {
			JButton platos  = new JButton (p.getNombrePlato()+ " : " + p.getPrecio() + "$");
			platos.setBounds(45, 140, 194, 46);
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
		
	        
		
		
		
		
	}
}
