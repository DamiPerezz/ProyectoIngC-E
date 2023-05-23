package View;


//HOLA

//Salutations
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Menu;
import Model.Pedido;
import Model.Plato;

public class ControladorCarrito implements ActionListener{

	
	VentanaCarrito v; 
	
	public String nombreUsuario;
	private static ArrayList<Plato> listaPlatos = new ArrayList<>();
	private static ArrayList<Menu> listaMenus = new ArrayList<>();
	
	
	
	public static ArrayList<Plato> getListaPlatos() {
		return listaPlatos;
	}


	public static void setListaPlatos(ArrayList<Plato> listaPlatos) {
		ControladorCarrito.listaPlatos = listaPlatos;
	}


	public ControladorCarrito(VentanaCarrito v) {
		
		this.v = v;
		
		
		
		
	}

	
	public static void actualizarPedido(Plato p) {
		listaPlatos.add(p);
	}
	public static void actualizarPedido(Menu m) {
		listaMenus.add(m);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		int NIdentificacion = sacarIDPedido() + 1;
		
		
		// Crear instancia del pedido y guardarla en JSON

		Pedido p = new Pedido(NIdentificacion, listaPlatos,listaMenus);

		//Opciones extra
		
		AñadirPedidoAJSON(p);

		
		
		
		v.asegurarVentana();
		v.dispose();

	}

	public static int sacarIDPedido() {
		String txt = "";
		try {
			FileReader fichero = new FileReader("listaPedidos.json");
			Scanner sc = new Scanner(fichero);
			BufferedReader bw = new BufferedReader(fichero);

			while (sc.hasNextLine()) {
				txt += sc.nextLine();
				sc.close();
			}

		} catch (Exception er) {
			er.getMessage();
		}

		JSONArray PedidosJSONArr = new JSONArray (txt);
		int index = PedidosJSONArr.length() -1;
		JSONObject ultimoObjeto = PedidosJSONArr.getJSONObject(index);
		int num = ultimoObjeto.getInt("NIdentificacion");

		// Saque todos pedidos JSON de la lista de objetos JSON
		// Damián, te recomiendo que los saque a través de otro método, pues voy a usar
		// este para imprimier el int de la id pal tiquet

		// Coja el ultimo objeto del arrayList y saca su atributo NPedido

		// Añade 1 al NPedido

		return num;
	}
	
	public static void AñadirPedidoAJSON(Pedido p) {
		String texto = "";
		
		try {
			FileReader fichero = new FileReader("listaPedidos.json");
			Scanner sc = new Scanner(fichero);
			while (sc.hasNextLine()) {
				texto += sc.nextLine();
				sc.close();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		//Sacamos los pedidos JSON guardados
		JSONArray JSONPedidos = new JSONArray (texto);
		
		//Creamos el objeto JSON de la instancia
		JSONObject jsonPedido = new JSONObject();
		jsonPedido.put("NIdentificacion", p.getNIdentificacion());
		jsonPedido.put("listaPlatos", p.getListaPlatos());
		jsonPedido.put("listaMenus", p.getListaMenus());
		//añadimos el JSONObject al JSON Array
		JSONPedidos.put(jsonPedido);
		
		try {
			FileWriter writer = new FileWriter("listaPedidos.json");
			// Escribir el objeto JSON en el archivo
			writer.write(JSONPedidos.toString());
			writer.flush();
			// Cerrar el objeto FileWriter
			writer.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		System.out.println("Pedido realizado con exito!!!!");
	}
	
	
}
