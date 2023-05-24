package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class ControladorMenu implements ActionListener {
    private VentanaMenu ventana;
    private VentanaCrearPedido ventanaCrearPedido;

    public ControladorMenu(VentanaMenu ventana, VentanaCrearPedido ventanaCrearPedido) {
        this.ventana = ventana;
        this.ventanaCrearPedido = ventanaCrearPedido;
    }
    
    public ControladorMenu(VentanaMenu ventana) {
        this.ventana = ventana;
     
    }

    public void actionPerformed(ActionEvent e) {
      
    	if (e.getSource() == ventana.añadir) {
    		
            String diaSemana = obtenerDiaSemanaActual();
            String nombreFichero = "menu" + diaSemana + ".json";
            String menu = leerMenu(nombreFichero);
            ventana.texto.setText(menu);
            JOptionPane.showMessageDialog(ventana, "¡Menú añadido correctamente!");
            
        }  else if (e.getSource() == ventana.atras) {
            ventana.setVisible(false);
            ventanaCrearPedido.setVisible(true);
        }
    }

    private String obtenerDiaSemanaActual() {
    	Calendar calendar = Calendar.getInstance();
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

        String dia;
        switch (diaSemana) {
            case Calendar.MONDAY:
                dia = "Lunes";
                break;
            case Calendar.TUESDAY:
                dia = "Martes";
                break;
            case Calendar.WEDNESDAY:
                dia = "Miércoles";
                break;
            case Calendar.THURSDAY:
                dia = "Jueves";
                break;
            case Calendar.FRIDAY:
                dia = "Viernes";
                break;
            case Calendar.SATURDAY:
                dia = "Sábado";
                break;
            case Calendar.SUNDAY:
                dia = "Domingo";
                break;
            default:
                dia = "";
                break;
        }

        return dia;
    
    }

    private String leerMenu(String nombreFichero) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject menuJSON = new JSONObject(contenido.toString());
        JSONArray platos = menuJSON.getJSONArray("platos");
        double precioMenu = menuJSON.getDouble("precio");

        StringBuilder menu = new StringBuilder();
        menu.append("Menú del día:\n");
        menu.append("Precio: ").append(precioMenu).append("€\n");
        menu.append("Platos:\n");
        for (int i = 0; i < platos.length(); i++) {
            String plato = platos.getString(i);
            menu.append("- ").append(plato).append("\n");
        }

        return menu.toString();
    }
}
