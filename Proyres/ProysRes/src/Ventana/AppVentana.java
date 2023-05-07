package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppVentana {
    public static void main(String[] args) {
        // Crear un marco para la ventana
        JFrame frame = new JFrame("Restaurante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Hacer la ventana visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Crear botones
        JButton añadirPlatoButton = new JButton("Añadir Plato");
        JButton crearPedidoButton = new JButton("Crear Pedido");
        JButton añadirIngredientesButton = new JButton("Añadir Ingredientes");
        JButton añadirTaperButton = new JButton("Añadir Taper");

        // Posicionar botones
        añadirPlatoButton.setBounds(100, 50, 200, 30);
        crearPedidoButton.setBounds(100, 100, 200, 30);
        añadirIngredientesButton.setBounds(100, 150, 200, 30);
        añadirTaperButton.setBounds(100, 200, 200, 30);

        // Añadir acciones a los botones
        añadirPlatoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Plato
            }
        });

        crearPedidoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Pedido
            }
        });
        
        añadirIngredientesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Ingredientes
            }
        });

        añadirTaperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llamar al método de la clase Ingredientes
            }
        });

        // Añadir botones al panel
        panel.add(añadirPlatoButton);
        panel.add(crearPedidoButton);
        panel.add(añadirIngredientesButton);
        panel.add(añadirTaperButton);
    }
}

