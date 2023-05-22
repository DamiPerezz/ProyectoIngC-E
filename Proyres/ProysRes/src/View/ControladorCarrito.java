package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCarrito implements ActionListener{

	
	VentanaCarrito v; 
	
	public String nombreUsuario;
	
	public ControladorCarrito(VentanaCarrito v) {
		
		this.v = v;
		
		
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		v.asegurarVentana();
		v.dispose();
		
		
		
		
	}

}
