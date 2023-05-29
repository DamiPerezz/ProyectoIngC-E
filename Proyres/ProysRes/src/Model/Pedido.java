package Model;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import View.ControladorCarrito;
import View.Main;
import View.VentanaCarrito;

public class Pedido {
	private String textoCarrito = "";
	private int NIdentificacion;
	private ArrayList<Menu> listaMenus;
	private ArrayList<Plato> listaPlatos = new ArrayList<Plato>();
	private static JSONObject listaPedidos = new JSONObject();

	public static void main(String[] args) {

		// Pedido r = new Pedido();

		// r.CrearPedido();

		AlergiaMasRepetida();

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

	public void CrearPedido() {

		// Preguntar opcion 1,2 o 3
		int opcion;
		boolean SeguirPedido = true;
		ArrayList<Plato> PlatosPedido = new ArrayList<Plato>();
		ArrayList<Menu> MenusPedido = new ArrayList<Menu>();
		// Bucle de pedir plato/Menu

		while (SeguirPedido == true) {
			opcion = OpcionesDePedido();
			switch (opcion) {
			case 1:
				// Añadir Plato
				PlatosPedido.add(AñadirPlatoAlPedido());
				break;
			case 2:
				MenusPedido.add(AñadirMenuAlPedido());
				break;
			case 3:
				SeguirPedido = false;
			}// Preguntar si ha termiando de pedir
				// SeguirPedido=FinDelPedido();

		}

		// Terminar pedido, guardalo e imprimir recibo

		int NIdentificacion = sacarIDPedido() + 1;
		// Crear instancia del pedido y guardarla en JSON

		Pedido p = new Pedido(NIdentificacion, PlatosPedido, MenusPedido);

		// Opciones extra

		AñadirPedidoAJSON(p);

		System.out.println("Pedido realizado con exito!!!!");

	}

	public Menu SacarInstanciasMenu(String dia) {
		String text = "";
		textoCarrito = "";
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

	public static ArrayList<Plato> SacarInstanciasPlato() {
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
		for (int i = 0; i < platosArr.length(); i++) {
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
			String Alergia = platoJSON.getString("alergia");
			Plato p = new Plato(nombrePlato, precio, listaIngredientes, NOPlato, Alergia);
			listaPlatos.add(p);
		}
		return listaPlatos;
	}

	public boolean FinDelPedido() {
		System.out.println("¿Quieres continuar con el pedido?" + "\n" + "[Y]/[N]");
		Scanner teclado = new Scanner(System.in);
		String resp = teclado.next();
		char respuesta = resp.charAt(0);
		boolean respBool = false;
		if (respuesta == 'Y' || respuesta == 'N') {
			if (respuesta == 'Y')
				respBool = true;
			if (respuesta == 'N')
				System.out.println("Gracias por tu visita ;)");
			respBool = false;
		} else {
			System.out.println("Respuesta invalida");
		}

		return respBool;
	}

	public int OpcionesDePedido() {

		System.out.println("Opciones");
		System.out.println("[1] Añadir Plato");
		System.out.println("[2] Añadir Menu");
		System.out.println("[3] Finalizar pedido");
		Scanner teclado = new Scanner(System.in);
		int respuesta = teclado.nextInt();

		return respuesta;

	}

	public Plato AñadirPlatoAlPedido() {

		System.out.println("¿Que platos quieres añadir al pedido?");
		ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();

		for (Plato p : PlatosDisponibles) {
			System.out.println("- " + p.getNombrePlato());
		}
		Scanner sc = new Scanner(System.in);
		// Falta metodo filtrar añadir
		String nombrePlato = sc.nextLine();

		return AgregarPlato(nombrePlato);

	}

	public Menu AñadirMenuAlPedido() {

		System.out.println("El menu del dia es:");

		Scanner sc = new Scanner(System.in);
		Date date = new Date();
		int dia = 0; // date.getDay();
		Menu m = new Menu();
		m = SacarInstanciasMenu("Lunes");
//		switch (dia) {
//			case 0:
//				//Sacar instacia Lunes
//				m =SacarInstanciasMenu("Lunes");
//			case 1:
//				m =SacarInstanciasMenu("Martes");
//			case 2:
//				m =SacarInstanciasMenu("Miercoles");
//			case 3:
//				m =SacarInstanciasMenu("Jueves");
//			case 4:
//				m =SacarInstanciasMenu("Viernes");
//			case 5:
//				m =SacarInstanciasMenu("Sabado");
//			case 6:
//				m =SacarInstanciasMenu("Domingo");
//		}
		System.out.println(m);

		System.out.println("¿Quieres añadirlo al pedido? (y/n)");
		char resp = sc.next().charAt(0);
		if (resp == 'y' || resp == 'n') {
			if (resp == 'n') {
				System.out.println("Operacion cancelada");
				m = null;
			}
			if (resp == 'y') {

				String texto = "Menú del día: " + m.getPrecio() + "€<br>" + textoCarrito;

				VentanaCarrito.actualizarPedido(m);
				ControladorCarrito.actualizarPedido(m);

				System.out.println("Menu añadido!!");
			}
		} else {
			System.out.println("Respuesta invalida");
			m = null;
		}

		return m;
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

		JSONArray PedidosJSONArr = new JSONArray(txt);
		int index = PedidosJSONArr.length() - 1;
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
		// Sacamos los pedidos JSON guardados
		JSONArray JSONPedidos = new JSONArray(texto);

		// Creamos el objeto JSON de la instancia
		JSONObject jsonPedido = new JSONObject();
		jsonPedido.put("NIdentificacion", p.NIdentificacion);
		jsonPedido.put("listaPlatos", p.listaPlatos);
		jsonPedido.put("listaMenus", p.listaMenus);
		// añadimos el JSONObject al JSON Array
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
	}

	public Plato AgregarPlato(String nombrePlato) {
		ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();

		Plato p = null;

		for (Plato plato : PlatosDisponibles) {
			if (plato.getNombrePlato().equals(nombrePlato)) {
				p = plato;
				break;
			}
		}
		VentanaCarrito.actualizarPedido(p);
		ControladorCarrito.actualizarPedido(p);

		return p;

	}

	public static void AlergiaMasRepetida() {
		String txt = "";
		try {
			FileReader fichero = new FileReader("listaPedidos.json");
			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				txt += sc.nextLine();
			}

			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		JSONArray jsonArray = new JSONArray(txt);
	
		// Recorrer cada objeto en el JSONArray
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			
			// Obtener la lista de platos
			JSONArray listaPlatos = jsonObject.getJSONArray("listaPlatos");
			
			// Recorrer cada plato en la lista
			for (int j = 0; j < listaPlatos.length(); j++) {

				try {
					JSONObject plato = listaPlatos.getJSONObject(j);
					String alergia = plato.getString("alergia");
					System.out.println("Alergia: " + alergia);

				} catch (Exception e) {
					System.out.println("null");
				}

				// Obtener el valor de la alergia

			}
		}

	}

	public String toString() {

		return "----------------------" + "\n" + "- " + this.NIdentificacion + "\n" + "- " + this.listaPlatos + "- "
				+ this.listaMenus + "\n" + "----------------------";
	}

	public int getNIdentificacion() {

		return NIdentificacion;
	}

	public ArrayList<Plato> getListaPlatos() {

		return listaPlatos;
	}

	public ArrayList<Menu> getListaMenus() {

		return listaMenus;
	}

}
