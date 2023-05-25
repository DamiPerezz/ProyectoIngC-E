package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

public class VentanaMenu extends JFrame {
	
	public ControladorMenu controladormenu;
	
	public static void main(String[] args) {
		VentanaMenu ventana = new VentanaMenu();
		ventana.Iniciar();
		ventana.setSize(300, 400);
		ventana.setVisible(true);
	}

	public JButton añadir;	
	public JLabel texto; 
    public JList lista; 
	public JButton atras;
	public ControladorMenu controlador;
	
	public void Iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// JList
		
		lista = new JList();
		
		
		
		//JLabel
		
		JLabel etiqueta = new JLabel("Menú del día ");
		add(etiqueta);
		add(texto);
	
		
		// JButton
		añadir = new JButton("Añadir");
		añadir.setMnemonic(KeyEvent.VK_M); // activar el boton para poder pulsarle
		añadir.setPreferredSize(new Dimension(170, 50));
		add(añadir);
		
		atras = new JButton("Atrás");
		atras.setMnemonic(KeyEvent.VK_A);
		atras.setPreferredSize(new Dimension(170, 50));
		add(atras);
		
		
	    añadir.addActionListener(controlador);
	    atras.addActionListener(controlador);
		
		//pack(); // Ajusta automáticamente el tamaño de la ventana
	}
}

