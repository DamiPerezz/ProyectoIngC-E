package View;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaTapper extends JFrame{
	
	private ControladorCarrito controlador;
	private JFrame ventanaDeTapper;
	public JButton BotonSiTapper;
	public JButton BotonNoTapper;
	
	
	
	public ControladorCarrito getControlador() {
		return controlador;
	}

	public void setControlador(ControladorCarrito controlador) {
		this.controlador = controlador;
	}

	public VentanaTapper() {
		
	}
	
	public void IniciarVentanaTupper() {
		ventanaDeTapper = new JFrame ();
		ventanaDeTapper.setSize(400,400);
		ventanaDeTapper.setLayout(new FlowLayout());
		BotonSiTapper = new JButton("Agregar Tapper");
		BotonSiTapper.setSize(100,100);	
		BotonSiTapper.addActionListener(controlador);
		ventanaDeTapper.add(BotonSiTapper);
		BotonNoTapper = new JButton("NO Agregar Tapper");
		BotonNoTapper.setSize(100,100);
		BotonNoTapper.addActionListener(controlador);
		ventanaDeTapper.add(BotonNoTapper);
		ventanaDeTapper.setVisible(true);
		
	}
	
	
}
