package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.json.JSONArray;
import org.json.JSONObject;

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
		
		// JTextPane
		
		JTextPane textPane = new JTextPane();
		
		//JLabel
		
		JLabel etiqueta = new JLabel("Menú del día ");
		add(etiqueta);
		//add(texto);
	
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
		
		pack(); // Ajusta automáticamente el tamaño de la ventana
	}
	
	public void insertarTextoEnJTextPane(String texto) {
	   
		JTextPane JTextPane = new JTextPane();
		JTextPane.setText(texto);
	}

	
//	 private String leerMenu(String nombreFichero) {
//	        StringBuilder contenido = new StringBuilder();
//
//	        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
//	            String linea;
//	            while ((linea = reader.readLine()) != null) {
//	                contenido.append(linea);
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//
//	        JSONObject menuJSON = new JSONObject(contenido.toString());
//	        JSONArray platos = menuJSON.getJSONArray("listaPlatos");
//	        double precioMenu = menuJSON.getDouble("precio");
//	        
//	        ArrayList<String> listaNombres = new ArrayList<String>();
//			for (int i = 0; i < platos.length(); i++) {
//				JSONObject platoJSON = platos.getJSONObject(i);
//				String nombrePlato = platoJSON.getString("nombrePlato");
//				// Creamos el JSONArray para sacar los valores de INgrediente
//				listaNombres.add(nombrePlato);
//				}
//				System.out.print(listaNombres);		
//	        
//	        
//	        StringBuilder menu = new StringBuilder();
//	        menu.append("Menú del día:\n");
//	        menu.append("Precio: ").append(precioMenu).append("€\n");
//	       
//	        menu.append("Platos:\n").append(platos);
//	        
//	        
//	        
//
//	System.out.println(platos);
//	        return menu.toString();
//	    }
}

