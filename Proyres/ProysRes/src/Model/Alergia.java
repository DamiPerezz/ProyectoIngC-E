package Model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

	// Metodo añadir
	// Saca información y la guarda (LEER FICHERO -> SACAR STRING -> PASARLO A
	// INSTANCIA -> PASARLA A JSON)
	// Hacer put al JSONARRAY QUE HAS SACADO DEL JSONOBJECT DEL PLATO QUE VAS A
	// METER

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

	public static void mostrarListaAlergias() { // muestra la lista de alergias disponibles al cliente
		ArrayList<String> arrayListAlergias = new ArrayList<String>();
		arrayListAlergias.add("gluten");
		arrayListAlergias.add("marisco");
		arrayListAlergias.add("frutosSecos");
		arrayListAlergias.add("lactosa");
		arrayListAlergias.add("huevos");
		arrayListAlergias.add("pescado");
		arrayListAlergias.add("soja");
		arrayListAlergias.add("vegetariano");

		System.out.println("Alergias disponibles:");

		for (int i = 0; i < arrayListAlergias.size(); i++) {

			System.out.println(i + ":" + arrayListAlergias.get(i));
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> arrayListAlergias = new ArrayList<String>();
		int opcionUsuario;
		int h = 0; // usado para ir guardando con un nº asociado cada plato

		String alergiaElegida = "";
		String alergiasTotales = "";
		String texto = "";
		String alergiasFiltradas = "";
		do {
			System.out.println("Seleccione una alergia: \n" + "1. Gluten \n" + "2. Marisco \n" + "3. Frutos Secos \n"
					+ "4. Lactosa \n" + "5. Huevos \n" + "6. Pescado \n" + "7. Soja \n" + "8. Vegetariano \n");

			// nota: crear un json con las alergias que existen en el restaurante. Éste
			// array es temporal, al igual que en mostrarListaAlergias

			do {
				try {
					opcionUsuario = in.nextInt();
				} catch (Exception e) {
					opcionUsuario = 0;
				}
				if (opcionUsuario < 1 || opcionUsuario > 8) {
					System.out.println("Eliga un nº entre 1 y 8.");
				}

			} while (opcionUsuario < 1 || opcionUsuario > 8);

			

			Pattern patronA = Pattern.compile(alergiaElegida);

			Matcher matchAlergia = patronA.matcher(alergiasTotales);
			
			switch (opcionUsuario) {

			case 1:
				alergiaElegida = "gluten";
				if(!matchAlergia.find()) alergiasTotales += ", gluten";
				break;
			case 2:
				alergiaElegida = "marisco";
				if(!matchAlergia.find()) alergiasTotales += ", marisco";
				break;
			case 3:
				alergiaElegida = "frutos secos";
				if(!matchAlergia.find()) alergiasTotales += ", frutos secos";
				break;
			case 4:
				alergiaElegida = "lactosa";
				if(!matchAlergia.find()) alergiasTotales += ", lactosa";
				break;
			case 5:
				alergiaElegida = "huevos";
				if(!matchAlergia.find()) alergiasTotales += ", huevos";
				break;
			case 6:
				alergiaElegida = "pescado";
				if(!matchAlergia.find()) alergiasTotales += ", pescado";
				break;
			case 7:
				alergiaElegida = "soja";
				if(!matchAlergia.find()) alergiasTotales += ", soja";
				break;
			case 8:
				alergiaElegida = "vegetariano";
				if(!matchAlergia.find()) alergiasTotales += ", (apto para) vegetarianos";
				break;

			}

			try {

				File Platos = new File("listaPlatos.json");
				Scanner sc = new Scanner(Platos);

				while (sc.hasNextLine()) {
					texto += sc.nextLine();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			JSONArray listaPlatos = new JSONArray(texto);

			
			for (int i = 0; i < listaPlatos.length(); i++) {
				JSONObject plato = listaPlatos.getJSONObject(i);
				if (plato.get("alergia").equals(alergiaElegida)) {

				} else {

					Pattern patron = Pattern.compile(plato.getString("nombrePlato"));

					
					Matcher matchPlato = patron.matcher(alergiasFiltradas);

					if (matchPlato.find()) {
						
					}else {
						alergiasFiltradas += "- " + plato.get("nombrePlato") + '\n';
						
					}

				}

			}
			System.out.println("Presione Y para añadir una nueva alergia");

		} while (in.next().toUpperCase().charAt(0) == 'Y');

		System.out.print("Menú apto para las siguientes alergias: \n" + alergiasFiltradas);

	}

	public String LeerAlergia() {

		Scanner in = new Scanner(System.in);

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
