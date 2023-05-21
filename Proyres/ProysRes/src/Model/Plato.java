package Model;
import java.io.File;
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

	public static void main(String[] args) {
		
		AñadirPlato();
		
	}
	
	public Plato(String nombrePlato, int precio, Ingrediente[] ingrediente,int NOPlato ) {
		super();
		this.precio = precio;
		for(Ingrediente i: ingrediente) {
		this.listaIngredientes.add(i);
		}
		this.nombrePlato = nombrePlato;
		this.NOPlato= NOPlato;
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
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre del nuevo plato:");
		String plato= sc.next();									//Nombre del Plato
		System.out.println("Introduzca el precio del nuevo plato:");
		int precio= sc.nextInt();									//Precio
		
		Ingrediente ingrediente = new Ingrediente(); 
		
		Ingrediente[] listaIngredientes = ingrediente.MostrarIngredientes();
		
		System.out.println("Ingredientes disponibles:");
		for(int i=0;i<listaIngredientes.length;i++) {
			System.out.println(listaIngredientes[i]);
		}
		
		int NOPlato = 0; //NumeroPlato
	
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
		
		
		Plato p = new Plato(plato,precio,ingredientesPlato,NOPlato);
		
		
		
		JSONArray JSONIng = new JSONArray(); //JSONARRAY de Ingredientes
		
		for (Ingrediente ing:ingredientesPlato) {
			JSONObject auxING = new JSONObject();
			auxING.put("nombre", ing);
			JSONIng.put(auxING);
		}
		
		JSONObject Plato = new JSONObject(); //JSONObject del Plato
		Plato.put("nombrePlato",plato);
		Plato.put("precio",precio);
		Plato.put("NOPlato",NOPlato);
		Plato.put("listaIngredientes", JSONIng);
		
		try {
			File file = new File("listaPlatos.json");

			// Crear el objeto FileWriter
			FileWriter writer = new FileWriter(file,true);

			// Escribir el objeto JSON en el archivo
			writer.write(Plato.toString());

			// Cerrar el objeto FileWriter
			writer.close();
		}catch(Exception ex) {
			System.out.println("ODIO EL JSON");
		}
		
	}
	
	
	public String toString() {
		return "Nombre:" + this.getNombrePlato() + "Ingrediente: "+ this.getIngrediente()+ "Precio: " +  this.getPrecio() ;
		
	}

}