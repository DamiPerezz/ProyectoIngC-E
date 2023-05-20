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

		Pedido r = new Pedido();
		r.CrearPedido();
	}

	public  void imprimirRecibo() {

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
		public  void CrearPedido() {
		
		//Preguntar opcion 1,2 o 3
	int opcion;
	boolean SeguirPedido = true;
	ArrayList<Plato> PlatosPedido = new ArrayList<Plato>();
	ArrayList<Menu> MenusPedido = new ArrayList<Menu>();
		//Bucle de pedir plato/Menu
	
		while(SeguirPedido==true) {
			opcion=OpcionesDePedido();
			switch(opcion) {
			case 1:
	//Añadir Plato
				PlatosPedido.add(AñadirPlatoAlPedido());
				break;
			case 2:
				MenusPedido.add(AñadirMenuAlPedido());
				break;
			case 3:	
				SeguirPedido=false;
			}//Preguntar si ha termiando de pedir
			//SeguirPedido=FinDelPedido();
			
		}
		
		//Terminar pedido, guardalo e imprimir recibo
		
				int NIdentificacion = sacarIDPedido() + 1;
				// Crear instancia del pedido y guardarla en JSON

				Pedido p = new Pedido(NIdentificacion, PlatosPedido,MenusPedido);
		
				AñadirPedidoAJSON(p);

				System.out.println("Pedido realizado con exito!!");

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
			JSONArray Platos = m.getJSONArray("platos");
			String[] listaPlatos = new String[Platos.length()];

			for (int j = 0; j < listaPlatos.length; j++) {
				String p = Platos.getString(j);
				listaPlatos[j] = p;
			}
			Menu menu = new Menu(precio, listaPlatos);
			menus[i] = menu;
			
			
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

			Plato p = new Plato(nombrePlato, precio, listaIngredientes, NOPlato);
			listaPlatos.add(p);

		}
		return listaPlatos;
	}
	public boolean FinDelPedido() {
		System.out.println("¿Quieres continuar con el pedido?" + "\n" + "[Y]/[N]");
		Scanner teclado = new Scanner(System.in);
		String resp= teclado.next();
		char respuesta= resp.charAt(0);
		boolean respBool=false;
		if (respuesta== 'Y' || respuesta== 'N') {
			if(respuesta== 'Y')
				respBool=true;
			if(respuesta=='N')
				System.out.println("Gracias por tu visita ;)");
				respBool=false;
		}else {	
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
		int respuesta= teclado.nextInt();
		
		
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
		String nombrePlato = sc.next();

		return AgregarPlato(nombrePlato);
		
		
	}
	public Menu AñadirMenuAlPedido() {
		Menu[] MenusDisponibles = SacarInstanciasMenu();
		int i=0;
		Menu MenuSeleccionado = null;
		for (Menu m : MenusDisponibles) {
			System.out.println("["+ i + "]" + " Precio: " + m.precio + "Platos : ");
			for(int j=0;j<m.platos.length;j++) {
				System.out.println(m.platos[j] + ", ");
				
			}
			i++;
		}
		
		System.out.println("\n" + "Selecciona el menu: ");
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		if(num>MenusDisponibles.length || num<0) {
			System.out.println("Numero invalido");
		} else {
			MenuSeleccionado= MenusDisponibles[num];
		}
		
		
		return MenuSeleccionado;
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

		JSONObject jsonPedido = new JSONObject();
		jsonPedido.put("NIdentificacion", p.NIdentificacion);
		jsonPedido.put("listaPlatos", p.listaPlatos);
		jsonPedido.put("listaMenus", p.listaMenus);

		JSONArray jsonArrayNew = new JSONArray(texto);  

		jsonArrayNew.put(jsonPedido);

		

		try {

			FileWriter writer = new FileWriter("listaPedidos.json");

			// Escribir el objeto JSON en el archivo

			writer.write(jsonArrayNew.toString());
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
