package View;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;



public class VentanaCrearPedido extends JFrame {

	
	
	// esto es para
	
	public JFrame ventana;
	public JButton añadirPlato;
	public JButton menuDelDia;
	public JButton carrito;
	public JMenuBar menuBar;
	public JMenu menu;
	public ControladorCrearPedido controlador;
	
	public VentanaCrearPedido() {
		Iniciar();
	}
	
	public void Iniciar() {
		ventana = new JFrame();
		ventana.setSize(300, 400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(new FlowLayout());
		ventana.setVisible(true);
		
		
		//MENU BAR
		menuBar = new JMenuBar();
		menu = new JMenu("Atrás");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu); // añadimos boton de "Atras" al menubar
		setJMenuBar(menuBar);
		
		
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
