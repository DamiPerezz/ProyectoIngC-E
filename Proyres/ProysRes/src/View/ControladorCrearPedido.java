package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorCrearPedido implements ActionListener {

	VentanaCrearPedido ventana;

	public ControladorCrearPedido(VentanaCrearPedido ven) {
		this.ventana= ven;
	}

	
	
	public void actionPerformed(ActionEvent e) {
		
		 // Obtenemos el objeto de origen del evento
        Object accion = e.getSource();

        // Comparamos el objeto con los botones que tenemos usando ==
        if (accion == ventana.añadirPlato) {
        	AñadirPlatoVentana ventana = new AñadirPlatoVentana(); //Se crea la ventanaPrincipal
    		ControladorAñadirPlato controlador = new ControladorAñadirPlato(ventana); //Se crea el controladorPrincipal y se le asocia la ventanaPrincipal
    		//Le asociamos el controlador a la ventana
    		ventana.controlador = controlador; //A la ventanaPrincipal se le asocia su controladorPrincipal
    		ventana.setVisible(true);
        	
        	
        } else if (accion == ventana.menuDelDia) {
        	
        	
        } else if (accion == ventana.carrito) {

    		VentanaCarrito mainFrame = new VentanaCarrito(); //Se crea la ventanaPrincipal
    		ControladorCarrito mc = new ControladorCarrito(mainFrame); //Se crea el controladorPrincipal y se le asocia la ventanaPrincipal
    		//Le asociamos el controlador a la ventana
    		mainFrame.controlador = mc; //A la ventanaPrincipal se le asocia su controladorPrincipal
    		mainFrame.initialize();
    		mainFrame.setVisible(true);
        	
        } else {
            
        }   
	}	
}

