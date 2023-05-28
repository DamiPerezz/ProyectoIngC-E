package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Almacen;

public class ControladorAlmacen implements ActionListener {

	private VentanaAlmacen ventana;
	private Almacen almacen;
	
	public VentanaAlmacen getVentana() {
		return ventana;
	}
	public void setVentana(VentanaAlmacen ventana) {
		this.ventana = ventana;
	}
	public Almacen getAlmacen() {
		return almacen;
	}
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
	
	
	public ControladorAlmacen(VentanaAlmacen ventana) {
		super();
		this.ventana = ventana;
	}
	public void actionPerformed(ActionEvent e) {
		String valor = JOptionPane.showInputDialog(ventana, "Ingrese un número:");
		if (valor != null && !valor.isEmpty()) {
			int numero = Integer.parseInt(valor);
			// Aquí puedes utilizar el número ingresado en tu lógica
			almacen.GuardarNTupper(numero);
		}
		
		
	}


}
