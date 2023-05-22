package Model;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Plato {
	
	//Alergia
	private int precio;
	private ArrayList <Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
	private String nombrePlato;
	private int NOPlato;
	private String Alergia;

	public static void main(String[] args) {
		
		AñadirPlato();
		
	}
	
	public String getAlergia() {
		return Alergia;
	}

	public void setAlergia(String alergia) {
		Alergia = alergia;
	}

	public Plato(String nombrePlato, int precio, Ingrediente[] ingrediente,int NOPlato , String Alergia) {
		super();
		this.precio = precio;
		for(Ingrediente i: ingrediente) {
		this.listaIngredientes.add(i);
		}
		this.nombrePlato = nombrePlato;
		this.NOPlato= NOPlato;
		this.Alergia=Alergia;
	}
	
	public Plato(String nombrePlato, int precio,int NOPlato ) {
		super();
		this.precio = precio;
		this.nombrePlato = nombrePlato;
		this.NOPlato= NOPlato;
	}
	public Plato() {
		super();
	}
	
	
	
	
	public int getNOPlato() {
		return NOPlato;
	}

	public void setNOPlato(int nOPlato) {
		NOPlato = nOPlato;
	}

	public ArrayList<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public void addIngrediente(Ingrediente ingrediente) {
		
		listaIngredientes.add(ingrediente);
		
	}


	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getIngrediente() {
		return null;
	}

	public void setIngrediente(String ingrediente) {
		
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public static void AñadirPlato() {
		Plato aux = new Plato();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre del nuevo plato:");
		String plato= sc.nextLine();									//Nombre del Plato
		System.out.println("Introduzca el precio del nuevo plato:" + "\n" + "SOLO EL NUMERO ENTERO");
		int precio= sc.nextInt();									//Precio
		
		Ingrediente ingrediente = new Ingrediente(); 
		
		Ingrediente[] listaIngredientes = ingrediente.MostrarIngredientes();
		
		
		ArrayList<Plato> TotalPlatos = aux.SacarInstanciasPlato();
		int index = TotalPlatos.size() -1;
		Plato ultPlato= TotalPlatos.get(index);
		int ultNum = ultPlato.getNOPlato();
		int NOPlato = ultNum + 1; //NumeroPlato
	
		//Añadir ingredientes
		System.out.println("¿Cuantos ingredientes tiene tu plato?");
		int numIng= sc.nextInt();
		
		Ingrediente[] ingredientesPlato = new Ingrediente[numIng]; //listaIngredientes
		
		
		
		for(int i=0;i<numIng;i++) {
			System.out.println("Añade un ingrediente");
			String nombreIng= sc.next();
			Ingrediente ing = new Ingrediente(nombreIng);
			ingredientesPlato[i]  = ing;
			
		}
		
		System.out.println("¿Que alergia tiene asociada el plato?");
		String alergia= sc.next();
		
		Plato p = new Plato(plato,precio,ingredientesPlato,NOPlato, alergia);
		//Saca toda la lista de platos del fichero y añade el nuevo plato
		
		JSONObject PlatJSON = new JSONObject(p);
		
		TotalPlatos.add(p);
		//Lo convertimos a JSONArray
		
		
		JSONArray ArrayPlatos = new JSONArray(TotalPlatos);
		
//		JSONArray JSONIng = new JSONArray(); //JSONARRAY de Ingredientes
//		
//		for (Ingrediente ing:ingredientesPlato) {
//			JSONObject auxING = new JSONObject();
//			auxING.put("nombre", ing);
//			JSONIng.put(auxING);
//		}
//		
//		JSONObject Plato = new JSONObject(); //JSONObject del Plato
//		Plato.put("nombrePlato",plato);
//		Plato.put("precio",precio);
//		Plato.put("NOPlato",NOPlato);
//		Plato.put("listaIngredientes", JSONIng);
//		Plato.put("Alergia",alergia);
		
		
		
		try {
			File file = new File("listaPlatos.json");

			// Crear el objeto FileWriter
			FileWriter writer = new FileWriter(file);

			// Escribir el objeto JSON en el archivo
			writer.write(ArrayPlatos.toString());

			// Cerrar el objeto FileWriter
			writer.close();
		}catch(Exception ex) {
			System.out.println("ODIO EL JSON");
		}
		
	}
	public  ArrayList<Plato> SacarInstanciasPlato() {
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
	
	public String toString() {
		return "Nombre:" + this.getNombrePlato() + "Ingrediente: "+ this.getIngrediente()+ "Precio: " +  this.getPrecio() ;
		
	}

}