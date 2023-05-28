package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaTapper extends JFrame{
	
	private ControladorCarrito controlador;
	public JFrame ventanaDeTapper;
	public JButton BotonSiTapper;
	public JButton BotonNoTapper;
	
	
	
	public ControladorCarrito getControlador() {
		return controlador;
	}

	public void setControlador(ControladorCarrito controlador) {
		this.controlador = controlador;
	}

	public VentanaTapper() {
		
	}
	
	public void IniciarVentanaTupper() {
		ventanaDeTapper = new JFrame ();
		ventanaDeTapper.setSize(400,400);
		ventanaDeTapper.setLayout(new FlowLayout());
		BotonSiTapper = new JButton("Agregar Tupper");
		BotonSiTapper.setSize(100,100);	
		BotonSiTapper.addActionListener(controlador);
		ventanaDeTapper.add(BotonSiTapper);
		BotonNoTapper = new JButton("NO Agregar Tupper");
		BotonNoTapper.setSize(100,100);
		BotonNoTapper.addActionListener(controlador);
		ventanaDeTapper.add(BotonNoTapper);
		ventanaDeTapper.setVisible(true);
		
		
		  JMenuBar menuBar = new JMenuBar();
	        setJMenuBar(menuBar);
	        
	        //Añade OPCION a la barra
	        JMenu mnNewMenu = new JMenu("Opción");
	        menuBar.add(mnNewMenu);
	        
	        //Añade el salir a la barra con el action listener incorporado para que salga del sistema 
	        
	        JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
	        mntmNewMenuItem.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ventanaDeTapper.dispose();
	        		setVisible(false);
	        	}
	        });
	        
	        mnNewMenu.add(mntmNewMenuItem);
	        ventanaDeTapper.setJMenuBar(menuBar);
	        ventanaDeTapper.setVisible(true);
	        
	}
	
	
}
