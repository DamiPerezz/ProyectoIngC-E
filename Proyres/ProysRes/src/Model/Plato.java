package Model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.util.Scanner;

public class Plato {

	String nombre;
	int precio;
	JSONObject listaIngredientes;

	public Plato(String nombre, int precio, JSONObject listaIngredientes) {

		this.nombre = nombre;
		this.precio = precio;
		this.listaIngredientes = listaIngredientes;

		/*try {

			FileWriter file = new FileWriter("nombredelarchivo");

			file.write(obj.toString());
			file.flush();

		} catch (Exception e) {

			e.printStackTrace();
		}
	*/	
	}

}