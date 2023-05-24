package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public JTextArea texto;
	public JMenuBar menuBar;
	public JMenu atras;
	public ControladorCrearPedido controlador;
	
	public void Iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// MENU BAR
		menuBar = new JMenuBar();
		atras = new JMenu("Atrás");
		atras.setMnemonic(KeyEvent.VK_A);
		menuBar.add(atras); // añadimos boton de "Atras" al menubar
		setJMenuBar(menuBar);
		
		//JLabel
		
		JLabel etiqueta = new JLabel("Menú del día ");
		add(etiqueta);
		
		// JTextArea
		texto = new JTextArea(5, 25);
		add(texto);
		
		// JButton
		añadir = new JButton("Añadir");
		añadir.setMnemonic(KeyEvent.VK_M); // activar el boton para poder pulsarle
		añadir.setPreferredSize(new Dimension(170, 50));
		add(añadir);
		
	    añadir.addActionListener(controlador);
	    atras.addActionListener(controlador);
		
		pack(); // Ajusta automáticamente el tamaño de la ventana
	}
}

