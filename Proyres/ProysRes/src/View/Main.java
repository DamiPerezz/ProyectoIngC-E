package View;

import javax.swing.*;

import Model.Alergia;
import Model.Almacen;
import Model.Menu;
import Model.Plato;

import java.awt.*;
import java.awt.event.*;

public class Main {

	private JFrame frame;
	private JPanel UserPanel, adminPanel, HomePanel;
	private JPanel pedidoPanel;
	private static final String ADMIN_PASSWORD = "Thebest"; // La contraseña del administrador.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		HomePanel = new JPanel();
		frame.getContentPane().add(HomePanel, "Home");
		HomePanel.setLayout(null);

		UserPanel = new JPanel();
		frame.getContentPane().add(UserPanel, "User");
		UserPanel.setLayout(null);

		adminPanel = new JPanel();
		frame.getContentPane().add(adminPanel, "Admin");
		adminPanel.setLayout(null);

		pedidoPanel = new JPanel();
		frame.getContentPane().add(pedidoPanel, "Pedido");
		pedidoPanel.setLayout(null);

		JButton btnHomeFromAdmin_2 = new JButton("Go Home");
		btnHomeFromAdmin_2.setBounds(10, 10, 100, 23);
		pedidoPanel.add(btnHomeFromAdmin_2);

		JButton btnExitFromAdmin_1 = new JButton("Exit");
		btnExitFromAdmin_1.setBounds(375, 10, 100, 23);
		pedidoPanel.add(btnExitFromAdmin_1);

		JButton btnUser = new JButton("Cliente");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "User");
			}
		});
		btnUser.setBounds(150, 119, 150, 23);
		HomePanel.add(btnUser);

		JButton btnHomeFromUser = new JButton("Go Home");
		btnHomeFromUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Home");
			}
		});
		btnHomeFromUser.setBounds(10, 10, 100, 23);
		UserPanel.add(btnHomeFromUser);

		JButton btnExitFromUser = new JButton("Exit");
		btnExitFromUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitFromUser.setBounds(375, 10, 100, 23);
		UserPanel.add(btnExitFromUser);

		JButton btnNewButton_1 = new JButton("Crear Pedido");
		btnNewButton_1.setBounds(175, 130, 136, 36);
		UserPanel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				VentanaCrearPedido ventanaPedido = new VentanaCrearPedido();
				ControladorCrearPedido controladorPedido = new ControladorCrearPedido(ventanaPedido);
				ventanaPedido.controlador = controladorPedido;
				ventanaPedido.Iniciar();

			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\aguir\\OneDrive\\Imágenes\\Screenshots\\Captura de pantalla 2023-05-21 154342.png"));
		lblNewLabel.setBounds(92, 0, 298, 263);
		UserPanel.add(lblNewLabel);

		JButton btnHomeFromAdmin = new JButton("Go Home");
		btnHomeFromAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Home");
			}
		});
		btnHomeFromAdmin.setBounds(0, 10, 100, 23);
		adminPanel.add(btnHomeFromAdmin);

		JButton btnExitFromAdmin = new JButton("Exit");
		btnExitFromAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitFromAdmin.setBounds(375, 10, 100, 23);
		adminPanel.add(btnExitFromAdmin);

		// ¿PORQUE EXISTE ESTE METODO?
		// LA CLASE SE LLAMA CREAR PEDIDO NO AÑADIR PEDIDO, PARA QUE SIRVE ESTE?

//	        JButton btnHomeFromAdmin_1 = new JButton("Añadir Pedido");
//	        btnHomeFromAdmin_1.addActionListener(new ActionListener() {
//	        	public void actionPerformed(ActionEvent e) {
//	        		
//	        	}
//	        });
//	        btnHomeFromAdmin_1.setBounds(45, 56, 194, 46);
//	        adminPanel.add(btnHomeFromAdmin_1);

		// BOTON PEDIDO ADMIN

		JButton btnHomeFromAdmin_1_1 = new JButton("Añadir Plato");
		btnHomeFromAdmin_1_1.setBounds(262, 56, 194, 46);
		adminPanel.add(btnHomeFromAdmin_1_1);
		btnHomeFromAdmin_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VentanaCrearPedido ventanaPedido = new VentanaCrearPedido();
//				ControladorCrearPedido controladorPedido = new ControladorCrearPedido(ventanaPedido);
//				ventanaPedido.controlador = controladorPedido;
//				ventanaPedido.Iniciar();
				Plato.AñadirPlato(); 

			}
		});

		// BOTON INGREDIENTE DESDE ADMIN

		JButton btnHomeFromAdmin_1_2 = new JButton("Añadir Menú");
		btnHomeFromAdmin_1_2.setBounds(45, 140, 194, 46);
		adminPanel.add(btnHomeFromAdmin_1_2);
		btnHomeFromAdmin_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VentanaCrearPedido ventanaPedido = new VentanaCrearPedido();
//				ControladorCrearPedido controladorPedido = new ControladorCrearPedido(ventanaPedido);
//				ventanaPedido.controlador = controladorPedido;
//				ventanaPedido.Iniciar();
				Menu m = new Menu();
				m = m.CrearMenu();
				m.AñadirMenuAFichero(m);
			}
		});

		// BOTON AÑADIR TAPER DESDE ADMIN

		JButton btnHomeFromAdmin_1_3 = new JButton("Añadir Taper");
		btnHomeFromAdmin_1_3.setBounds(262, 140, 194, 46);
		adminPanel.add(btnHomeFromAdmin_1_3);

		// Crea barra de menu

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// Añade OPCION a la barra
		JMenu mnNewMenu = new JMenu("Opcion");
		menuBar.add(mnNewMenu);

		// Añade el salir a la barra con el action listener incorporado para que salga
		// del sistema

		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmAdmin = new JMenuItem("Admin");
		mntmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
				}

				String password = JOptionPane.showInputDialog(frame, "Enter admin password:");
				if (ADMIN_PASSWORD.equals(password)) {
					((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Admin");
				} else {
					JOptionPane.showMessageDialog(frame, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu.add(mntmAdmin);
		
		JMenuItem botonAlmacen = new JMenuItem("Almacen");
		botonAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
				}

				String password = JOptionPane.showInputDialog(frame, "Enter password:");
				if (ADMIN_PASSWORD.equals(password)) {
					Almacen a= new Almacen();
					VentanaAlmacen aWindow = new VentanaAlmacen();
					ControladorAlmacen aCtrl = new ControladorAlmacen(aWindow);
					aWindow.setControlador(aCtrl);
					aCtrl.setAlmacen(a);
					aWindow.Iniciar();
					
				} else {
					JOptionPane.showMessageDialog(frame, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu.add(botonAlmacen);

	}
}
