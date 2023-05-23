package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAñadirPlato implements ActionListener {

	
	public AñadirPlatoVentana ventana;
	
	
	
	public ControladorAñadirPlato(AñadirPlatoVentana ventana) {
		super();
		this.ventana = ventana;
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object causa = e.getSource();
		if (causa == ventana.atras) {
           ventana.dispose();
			// Aquí hacemos la acción correspondiente al botón añadirPlato
        }
		
		       }
}