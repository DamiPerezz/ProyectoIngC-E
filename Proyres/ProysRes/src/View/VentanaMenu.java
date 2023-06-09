package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class VentanaMenu extends JFrame {
	
	public static ControladorMenu controladormenu;
	private ArrayList <String> listaNombres = new ArrayList<>();
	
	
	public static void main(String[] args) {
		VentanaMenu ventana = new VentanaMenu();
		controladormenu = new ControladorMenu(ventana);
		ventana.Iniciar();
		ventana.setSize(300, 400);
		ventana.setVisible(true);
	}

	public JButton añadir;	
	public JLabel texto; 
	public JButton atras;
	public ControladorMenu controlador;
	
	public void setPlatosDelDia(ArrayList<String> listaNombres) {
		
		this.listaNombres = listaNombres;
		
	}
	
	
	public void Iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		
		//JLabel
		
		JLabel etiqueta = new JLabel("Menú del día ");
		add(etiqueta);
		//add(texto);
	
		//JTextPane
		JTextPane textPane = new JTextPane();
		StyledDocument doc = textPane.getStyledDocument();
		for (String nombre : listaNombres) {
		    try {
				doc.insertString(doc.getLength(), nombre + "\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		add(textPane);
		
		// JButton
		añadir = new JButton("Añadir");
		añadir.setMnemonic(KeyEvent.VK_M); // activar el boton para poder pulsarle
		añadir.setPreferredSize(new Dimension(170, 50));
		add(añadir);
		
		
		  JMenuBar menuBar = new JMenuBar();
	        setJMenuBar(menuBar);
	        
	        //Añade OPCION a la barra
	        JMenu mnNewMenu = new JMenu("Opcion");
	        menuBar.add(mnNewMenu);
	        
	        //Añade el salir a la barra con el action listener incorporado para que salga del sistema 
	        
	        JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
	        mntmNewMenuItem.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		setVisible(false);
	        	}
	        });
	        
	        
	        
	        mnNewMenu.add(mntmNewMenuItem);
	        
	        	
		
	    añadir.addActionListener(controlador);
	  
	    
	  
        
	    
	
		pack(); // Ajusta automáticamente el tamaño de la ventana
	}
}

