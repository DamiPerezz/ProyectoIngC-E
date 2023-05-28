package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Ingrediente;
import Model.Menu;
import Model.Pedido;
import Model.Plato;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import Model.Plato;

public class ControladorMenu implements ActionListener {
    private VentanaMenu ventana;
    private VentanaCrearPedido ventanaCrearPedido;
    private String diaSemana;
    private ArrayList <String> listaNombres = new ArrayList<>();
    
    
	public void setPlatosDelDia(ArrayList<String> listaNombres) {
		
		this.listaNombres = listaNombres;
		
	}
	
    public ControladorMenu(VentanaMenu ventana, VentanaCrearPedido ventanaCrearPedido) {
        this.ventana = ventana;
        this.ventanaCrearPedido = ventanaCrearPedido;
    }
    
    public ControladorMenu(VentanaMenu ventana) {
        this.ventana = ventana;
        String diaSemana = obtenerDiaSemanaActual();
        String nombreFichero = "menusSemana/menu" + "Lunes" + ".json";
        String menu = leerMenu(nombreFichero);
    }

    public void actionPerformed(ActionEvent e) {
      
    	if (e.getSource() == ventana.añadir) {
    		
    		
    		
//    		
//            String diaSemana = obtenerDiaSemanaActual();
//            String nombreFichero = "menusSemana/menu" + "Lunes" + ".json";
//            String menu = leerMenu(nombreFichero);
         //  ventana.texto.setText(menu);
            JOptionPane.showMessageDialog(ventana, "¡Menú añadido correctamente!");         
           
          //  String[] platosArray = {"Plato 1", "Plato 2", "Plato 3"};
           
            
            //------------------------------------------
            
            
            
        	//JSONArray platosArr = new JSONArray(txt);
            
            
            String nombreFichero = "menusSemana/menu" + "Lunes" + ".json";
            String dia = "Lunes";
            Menu men= SacarInstanciasMenu(dia);
//            String menu = leerMenu(nombreFichero);
//            System.out.println(menu);
//            String[] arrayStrings = menu.split(",");
//            ArrayList<Plato> platos = new ArrayList<>();
//           
//            for (String nombrePlato : arrayStrings) {
//                Plato plato = new Plato(nombrePlato);
//                platos.add(plato);
//            }
//
//            Menu m = new Menu(platos);
            ControladorCarrito.actualizarPedido(men);
            
         
            ventana.setVisible(true);
           
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
//______________________________________________________________
    
    public String leerMenu(String nombreFichero) {
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
        JSONArray platos = menuJSON.getJSONArray("listaPlatos");
        double precioMenu = menuJSON.getDouble("precio");
        
        ArrayList<String> listaNombres = new ArrayList<String>();
        
		for (int i = 0; i < platos.length(); i++) {
			JSONObject platoJSON = platos.getJSONObject(i);
			String nombrePlato = platoJSON.getString("nombrePlato");
			// Creamos el JSONArray para sacar los valores de INgrediente
			listaNombres.add(nombrePlato);
			}
		
		ventana.setPlatosDelDia(listaNombres);	
		
		ventana.enviarArray(listaNombres);
		//System.out.print(listaNombres);	
			
        
        StringBuilder menu = new StringBuilder();
        menu.append("Menú del día:\n");
        menu.append("Precio: ").append(precioMenu).append("€\n");
       
        menu.append("Platos:\n").append(platos);
        
        
        
////        for (int i = 0; i < platos.length(); i++) {
////            String plato = platos.getString(i);
////            menu.append("- ").append(plato).append("\n");
////        }
////System.out.println(platos);
       return menu.toString();
    }
    
    //---------------------------------------------------------//
    // hora de hacerlo a lo Damiano----------------------------//
    
    public Menu SacarInstanciasMenu(String dia) {
		String text = "";
		String textoCarrito = "";
		// Leer listaPlatos
		try {
			FileReader fichero = new FileReader("menusSemana/menu" + dia + ".json");

			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				text = sc.nextLine();
				sc.close();
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		String txt = text;
		JSONObject menuJSON = new JSONObject(txt);
		int price = menuJSON.getInt("precio");
		String DiaSemana = menuJSON.getString("DiaSemana");
		JSONArray listaPla = menuJSON.getJSONArray("listaPlatos");

		ArrayList<Plato> listaPlatos = new ArrayList<Plato>();

		// Bucle de instanciar JSONPlato a ArrayList Plato
		for (int i = 0; i < listaPla.length(); i++) {
			JSONObject platoJSON = listaPla.getJSONObject(i);
			int precio = platoJSON.getInt("precio");
			String nombrePlato = platoJSON.getString("nombrePlato");
			textoCarrito += "- " + nombrePlato + "<br>";

			int NOPlato = platoJSON.getInt("NOPlato");
			// Creamos el JSONArray para sacar los valores de INgrediente

			JSONArray lisIng = platoJSON.getJSONArray("listaIngredientes");
			Ingrediente[] listaIngredientes = new Ingrediente[lisIng.length()];

			for (int j = 0; j < listaIngredientes.length; j++) {
				String nombre = lisIng.getString(j);
				Ingrediente ingrediente = new Ingrediente(nombre);
				listaIngredientes[j] = ingrediente;
			}

			String Alergia = platoJSON.getString("Alergia");

			Plato p = new Plato(nombrePlato, precio, listaIngredientes, NOPlato, Alergia);
			listaPlatos.add(p);
		}
		Menu menu = new Menu();
		menu.setDiaSemana(DiaSemana);
		menu.setPrecio(price);
		menu.setListaPlatos(listaPlatos);

		return menu;

	}
    
    
}
