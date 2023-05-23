package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.*;

public class AñadirPlatoVentana extends JFrame{

	private JFrame marco;
	private JPanel panel;
	private ControladorCarrito controlador;
	
	public static void main(String[] args) {
		
		AñadirPlatoVentana v = new AñadirPlatoVentana();
		
	}
	
	public AñadirPlatoVentana() {
		
		IniciarVentana();
	}
	
	
	public void IniciarVentana( ) {
		marco = new JFrame();
		marco.setBounds(100, 100, 499, 322);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.getContentPane().setLayout(new FlowLayout());
        marco.setVisible(true);
        
        
        
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
	               ArrayList<Plato> lista = controlador.getListaPlatos();
	               lista.add(p);
	               controlador.setListaPlatos(lista);
	               
	            }
	        });
	}
		
	        
		
		
		
		
	}
}
