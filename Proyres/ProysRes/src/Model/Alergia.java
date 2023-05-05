package Model;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class Alergia {

	private JSONObject jsonAlergias = new JSONObject();
	
	private ArrayList<Alergia> listaAlergias = new ArrayList<Alergia>();
	private Alergia nombreAlergia;
	

	public Alergia(JSONObject jsonAlergias, ArrayList<Alergia> listaAlergias, Alergia nombreAlergia) {
		super();
		this.jsonAlergias = jsonAlergias;
		this.listaAlergias = listaAlergias;
		this.nombreAlergia = nombreAlergia;
	}



	//Metodo añadir 
	//Saca información y la guarda (LEER FICHERO -> SACAR STRING -> PASARLO A INSTANCIA -> PASARLA A JSON)
	//Hacer put al JSONARRAY QUE HAS SACADO DEL JSONOBJECT DEL PLATO QUE VAS A METER
	

	public void setNombre(Alergia alergia) {
		this.nombreAlergia = alergia;
	}

	

	public void AñadirAlergia() {

		try {

			File fichero = new File("listaAlergias.json");
			FileWriter writer = new FileWriter(fichero);

			writer.write(jsonAlergias.toString()); // escribir en el fichero

			writer.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void mostrarListaAlergias() { // muestra la lista de alergias disponibles al cliente
		String texto = " ";
		try {

			File fichero = new File("listaAlergias.json");

			Scanner scanner = new Scanner(fichero);

			while (scanner.hasNextLine()) {
				texto = scanner.nextLine();
				JSONObject jsonAlergias = new JSONObject(texto);
				JSONArray listaAlergias = jsonAlergias.getJSONArray("alergias");

				System.out.println("Alergias disponibles:");

				for (int i = 0; i < listaAlergias.length(); i++) {
					JSONObject alergiaJson = listaAlergias.getJSONObject(i);
					String nombreAlergia = alergiaJson.getString("nombre");
					System.out.println((i + 1) + ". " + nombreAlergia);

					// System.out.println(texto);s
				}
			}
			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarPlatosAlergia() {
		Scanner in = new Scanner(System.in);
		System.out.println("Seleccione una alergia:");

		mostrarListaAlergias();

		int opcionUsuario = in.nextInt();

		try {

			File Platos = new File("listaPlatos.json");
			Scanner sc = new Scanner(Platos);
			String texto = "";

			while (sc.hasNextLine()) {
				texto += sc.nextLine();
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String LeerAlergia() {
		
		Scanner in = new Scanner (System.in);
		
		String texto = " ";
	    try {

	        File fichero = new File("listaAlergias.json");

	        Scanner scanner = new Scanner(fichero);

	        while (scanner.hasNextLine()) {
	             texto = scanner.nextLine();
	            
	        }

	        scanner.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return texto;
	}

	}
