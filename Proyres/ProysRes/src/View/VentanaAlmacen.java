package View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaAlmacen extends JFrame {

	private ControladorAlmacen controlador;
	private JFrame ventana;
	private JLabel numTaper;
	private JButton recargarStock;
	
	
	
	public ControladorAlmacen getControlador() {
		return controlador;
	}
	public void setControlador(ControladorAlmacen controlador) {
		this.controlador = controlador;
	}

	
	public void Iniciar() {
		
		ventana = new JFrame();
		ventana.setLayout(new BorderLayout());
		ventana.setSize(300, 200);
	    ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    ventana.setLocationRelativeTo(null);
	        
	        
	    numTaper = new JLabel("Stock Tupper: "+String.valueOf(controlador.getAlmacen().getNumTupper()));
	    
		   
	    numTaper.setBounds(50, 50, 200, 30);
	    ventana.add(numTaper,BorderLayout.CENTER);
	        
	        
	    recargarStock = new JButton("Recargar stock tapper");
	    recargarStock.setBounds(50, 50, 200, 30);
	    recargarStock.addActionListener(controlador);
	    ventana.add(recargarStock,BorderLayout.SOUTH);
	    ventana.setVisible(true);
		
	}
	
}
