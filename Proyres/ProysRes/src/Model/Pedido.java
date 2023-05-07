package Model;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Pedido {

	private int NIdentificacion;

	private ArrayList<Menu> listaMenus;
	private ArrayList<Plato> listaPlatos = new ArrayList<Plato>();
	private static JSONObject listaPedidos = new JSONObject();

	public static void main(String[] args) {

		Pedido origen = new Pedido(0);
		AñadirPedidoAJSON(origen);

	}

	public void imprimirRecibo() {

		int factura = 0;

		System.out.println("Recibo:");
		System.out.println("Num. id: " + sacarIDPedido());

		for (int i = 0; i < listaPlatos.size(); i++) {

			System.out.print(listaPlatos.get(i).getNombrePlato() + ":" + listaPlatos.get(i).getPrecio() + "€ \n");

			factura += listaPlatos.get(i).getPrecio();
		}

		System.out.println("Total: " + factura + "€");

	}

	public Pedido(int NIdentificacion, ArrayList<Plato> listaPlatos, ArrayList<Menu> listaMenus) {
		super();
		this.NIdentificacion = NIdentificacion;
		this.listaPlatos = listaPlatos;
		this.listaMenus = listaMenus;
	}

	public Pedido(int NIdentificacion, ArrayList<Plato> listaPlatos) {
		super();
		this.NIdentificacion = NIdentificacion;
		this.listaPlatos = listaPlatos;
	}

	public Pedido(int NIdentificacion) {
		super();
	}
	public Pedido() {
		super();
	}
	
	public Menu[] SacarInstanciasMenu() {
		
		String txt = "";
		// Leer listaPlatos
		try {
			FileReader fichero = new FileReader("menus.json");

			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				txt += sc.nextLine();
				sc.close();
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		
		JSONArray MenusArr = new JSONArray(txt);
		Menu[] menus = new Menu[MenusArr.length()];
		String precio;
		for(int i=0;i<MenusArr.length();i++) {
			JSONObject m = MenusArr.getJSONObject(i);
			 precio = m.getString("precio");
			JSONArray Platos = new JSONArray("platos");
			String[] listaPlatos = new String[Platos.length()];

			for (int j = 0; j < listaPlatos.length; j++) {
				String p = Platos.getString(j);
				listaPlatos[j] = p;
			}
			try {
				Menu menu = new Menu(precio, listaPlatos);
				menus[i] = menu;
				
			}catch(Exception ex) {
				System.out.println("Error al crear menu");
			}
			
			
		}
		return menus;
		
	}

	public ArrayList<Plato> SacarInstanciasPlato() {
		String txt = "";
		// Leer listaPlatos
		try {
			FileReader fichero = new FileReader("listaPlatos.json");

			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				txt += sc.nextLine();
				sc.close();
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		// Creamos el JSON Array de los platos
		JSONArray platosArr = new JSONArray(txt);
		ArrayList<Plato> listaPlatos = new ArrayList<Plato>();
		for (int i = 0; i < txt.length(); i++) {
			JSONObject platoJSON = platosArr.getJSONObject(i);
			int precio = platoJSON.getInt("precio");
			String nombrePlato = platoJSON.getString("nombrePlato");
			int NOPlato = platoJSON.getInt("NOPlato");

			// Creamos el JSONArray para sacar los valores de INgrediente
			JSONArray lisIng = platoJSON.getJSONArray("listaIngredientes");
			Ingrediente[] listaIngredientes = new Ingrediente[lisIng.length()];

			for (int j = 0; j < listaIngredientes.length; j++) {
				JSONObject ing = lisIng.getJSONObject(j);
				String nombre = ing.getString("nombre");

				Ingrediente ingrediente = new Ingrediente(nombre);
				listaIngredientes[j] = ingrediente;

			}

			Plato p = new Plato(nombrePlato, precio, listaIngredientes, NOPlato);
			listaPlatos.add(p);

		}
		return listaPlatos;
	}

	public void CrearPedido() {

		System.out.println("¿Que platos quieres añadir al pedido?");
		ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();

		for (Plato p : PlatosDisponibles) {
			System.out.println("- " + p.getNombrePlato());
		}
		Scanner sc = new Scanner(System.in);
		// Falta metodo filtrar añadir
		String nombrePlato = sc.next();

		ArrayList<Plato> PlatosPedido = null;

		PlatosPedido.add(AgregarPlato(nombrePlato));

		// Sacar NOIdentificación
		int NIdentificacion = sacarIDPedido();
		// Crear instancia del pedido y guardarla en JSON

		Pedido p = new Pedido(NIdentificacion, PlatosPedido);

		AñadirPedidoAJSON(p);

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

		// JSONArray PedidosJSONArr = new JSONArray (txt);
		JSONObject ultimoObjeto = new JSONObject(txt);
		// JSONObject ultimoObjeto =
		// PedidosJSONArr.getJSONObject(PedidosJSONArr.length() -1);
		int num = ultimoObjeto.getInt("NIdentifiacion");

		// Saque todos pedidos JSON de la lista de objetos JSON
		// Damián, te recomiendo que los saque a través de otro método, pues voy a usar
		// este para imprimier el int de la id pal tiquet

		// Coja el ultimo objeto del arrayList y saca su atributo NPedido

		// Añade 1 al NPedido

		return num;
	}

	public static void AñadirPedidoAJSON(Pedido p) {

		JSONArray jsonArray = new JSONArray();

		String texto = "";
		String l;

		try {

			FileReader fr = new FileReader("listaPedidos.json");
			BufferedReader br = new BufferedReader(fr);

			while ((l = br.readLine()) != null) {

				texto = l;

			}

		} catch (Exception e) {

			System.out.println(e);

		}

		JSONObject jsonPedido = new JSONObject();
		jsonPedido.put("NIdentificacion", p.NIdentificacion);
		jsonPedido.put("listaPlatos", p.listaPlatos);
		jsonPedido.put("listaMenus", p.listaMenus);

		JSONObject pedidosAnteriores = new JSONObject(texto);
	
		jsonArray = pedidosAnteriores.getJSONArray("listaDeFacturas");

		jsonArray.put(jsonPedido);

		listaPedidos.put("listaDeFacturas", jsonArray);

		try {

			FileWriter writer = new FileWriter("listaPedidos.json", false);

			// Escribir el objeto JSON en el archivo

			writer.write(listaPedidos.toString());
			writer.flush();

			// Cerrar el objeto FileWriter
			writer.close();
		} catch (Exception ex) {
			ex.getMessage();
		}

	}

	public Plato AgregarPlato(String nombrePlato) {
		ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();

		Plato p = null;

		for (Plato plato : PlatosDisponibles) {
			if (plato.getNombrePlato().equals(nombrePlato)) {
				p = plato;
				break;
			} else {
				System.out.println("Lo sentimos, ese plato no lo tenemos");
			}
		}

		return p;

	}

	public String toString() {

		return "----------------------" + "\n" + "- " + this.NIdentificacion + "\n" + "- " + this.listaPlatos + "- "
				+ this.listaMenus + "\n" + "----------------------";
	}

}
