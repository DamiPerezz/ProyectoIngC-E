package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VentanaEstadistica extends JFrame {

	
	//private JFrame ventana;
	private Main controlador;
	//private JLabel estadisticas;
	private JTextArea textArea;
	
	public Main getControlador() {
		return controlador;
	}
	
	
	public void iniciar() {

		
	        setTitle("Estadísticas");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        textArea = new JTextArea();
	        textArea.setEditable(false);
	        getContentPane().add(textArea);
	    }
//
//	    public void mostrarTexto(String texto) {
//	        textArea.setText(texto);
//	    }
//	    
	    public void mostrarResultado(int totalPlatos) {
	        textArea.setText("Número total de platos pedidos: " + totalPlatos);
	    }
	}
