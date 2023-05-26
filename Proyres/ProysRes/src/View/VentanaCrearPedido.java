package View;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class VentanaCrearPedido extends JFrame {

	public static void main(String[] args) {
		VentanaCrearPedido ventana = new VentanaCrearPedido();
		
		ventana.setSize(300, 400);
		ventana.setVisible(true);
	}

	
	
	// esto es para
	
	public JFrame ventana;
	public JButton añadirPlato;
	public JButton menuDelDia;
	public JButton carrito;
	
	public JMenuBar menuBar;
	public JMenu menu;
	public ControladorCrearPedido controlador;
	
	public VentanaCrearPedido() {
		
	}
	
	public void Iniciar() {
		ventana = new JFrame();
		ventana.setSize(300, 400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setVisible(true);
		
		
		  JMenuBar menuBar = new JMenuBar();
	        setJMenuBar(menuBar);
	        
	        //Añade OPCION a la barra
	        JMenu mnNewMenu = new JMenu("Opcion");
	        menuBar.add(mnNewMenu);
	        
	        //Añade el salir a la barra con el action listener incorporado para que salga del sistema 
	        
	        JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
	        mntmNewMenuItem.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ventana.setVisible(false);
	        	}
	        });
	        
	        
	        
	        mnNewMenu.add(mntmNewMenuItem);
		
	        ventana.add(menuBar);
	
		
		
		//LOS 3 BOTONES
		añadirPlato = new JButton ("Añadir Plato");
		menuDelDia = new JButton ("Menu del Día");
		carrito = new JButton ("Carrito");
		
		
		//BOTON AÑADIR PLATO		 		
		añadirPlato.setMnemonic(KeyEvent.VK_M); //activar el boton para poder pulsarle
		añadirPlato.setBounds(45, 140, 194, 46);
		setLayout(new FlowLayout()); // Se utiliza FlowLayout como administrador de diseño
        add(añadirPlato);
		ventana.add(añadirPlato);
		ventana.setVisible(true);
        añadirPlato.addActionListener(controlador);
		
        //boton Menu del Dia
        menuDelDia.setMnemonic(KeyEvent.VK_M); //activar el boton para poder pulsarle
        menuDelDia.setBounds(45, 140, 194, 46);
		setLayout(new FlowLayout()); // Se utiliza FlowLayout como administrador de diseño
        add(menuDelDia);
        ventana.add(menuDelDia);
        menuDelDia.setVisible(true);
        menuDelDia.addActionListener(controlador);
        
        
        //boton Carrito
        carrito.setMnemonic(KeyEvent.VK_M); //activar el boton para poder pulsarle
        carrito.setBounds(45, 140, 194, 46);
		setLayout(new FlowLayout()); // Se utiliza FlowLayout como administrador de diseño
        add(carrito);
		ventana.add(carrito);
		carrito.setVisible(true);
		carrito.addActionListener(controlador);
		
		

	}

}
