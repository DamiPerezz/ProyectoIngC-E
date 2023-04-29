package Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;
import com.google.gson.*;

public class Ingrediente {
	
	private String nombre;
	
	public Ingrediente(String nombre) {
		super();
		this.nombre = nombre;
		
	}
	public Ingrediente() {
		super();
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int GetIndex() {
		String texto= " ";
		try {
			
			FileReader fichero = new FileReader("listaIngredientes.txt");
			 Scanner scanner = new Scanner(fichero);
	            while (scanner.hasNextLine()) {
	                texto = scanner.nextLine();
	                System.out.println(texto);
	            }
	            scanner.close();
				
		}catch(Exception ex) {
			ex.getMessage();
		}
		String[] ingredientes = texto.split(":");
		int index= ingredientes.length;
		
		return index;
	}

	public Ingrediente[] MostrarIngredientes() {
		String texto= " ";
		try {
			
			FileReader fichero = new FileReader("listaIngredientes.txt");
			 Scanner scanner = new Scanner(fichero);
	            while (scanner.hasNextLine()) {
	                texto = scanner.nextLine();
	                System.out.println(texto);
	            }
	            scanner.close();
				
		}catch(Exception ex) {
			ex.getMessage();
		}
		String[] ingredientes = texto.split(":");
		Ingrediente[] listaIngredientes = new Ingrediente[ingredientes.length];
		
		for(int i=0;i<ingredientes.length;i++) {
			Ingrediente ing = new Ingrediente(ingredientes[i]);
			listaIngredientes[i] = ing;
		}
		return listaIngredientes;
	}
	
	public void AñadirIngrediente() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre del nuevo ingrediente:");
		String nombre= sc.next();
		
		
		try {
			FileWriter file = new FileWriter("listaIngredientes.txt",true);	
			
			file.write(nombre + ":");
			file.flush();
			file.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String toString() {
		
		return this.nombre ;
	}
	
}
