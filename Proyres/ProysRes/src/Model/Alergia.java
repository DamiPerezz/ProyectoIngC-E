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

	public void filtrarPlatos(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> arrayListAlergias = new ArrayList<String>();
		int opcionUsuario;
		int h = 0; // usado para ir guardando con un nº asociado cada plato
		JSONObject listaPlatos = new JSONObject();
		String texto = "";
		String platosFiltrados = "";
		String alergiasFiltradas = "";
		do {
			System.out.println("Seleccione una alergia:");

			arrayListAlergias.add("gluten");
			arrayListAlergias.add("marisco");
			arrayListAlergias.add("frutosSecos");
			arrayListAlergias.add("lactosa");
			arrayListAlergias.add("huevos");
			arrayListAlergias.add("pescado");
			arrayListAlergias.add("soja");
			arrayListAlergias.add("vegetariano");
			// nota: crear un json con las alergias que existen en el restaurante. Éste
			// array es temporal, al igual que en mostrarListaAlergias

			mostrarListaAlergias();

			opcionUsuario = in.nextInt();

			try {

				File Platos = new File("listaAlergias.json");
				Scanner sc = new Scanner(Platos);

				while (sc.hasNextLine()) {
					texto += sc.nextLine();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			listaPlatos = new JSONObject();

			JSONArray listaAlergias = new JSONArray(texto);

			JSONObject alergiaJson = listaAlergias.getJSONObject(opcionUsuario);

			listaPlatos = alergiaJson.getJSONObject(arrayListAlergias.get(opcionUsuario));

			System.out.println("Presione Y para añadir una nueva alergia");

			Pattern alergiaExpresion = Pattern.compile((arrayListAlergias.get(opcionUsuario)));
			Matcher alergiaMatcher = alergiaExpresion.matcher(alergiasFiltradas);

			if (alergiaMatcher.find()) {

			} else {

				alergiasFiltradas += ", " + listaPlatos.getString("nombre");

			}

			for (int i = 0; i < listaPlatos.length() - 1; i++) {

				Pattern expresion = Pattern.compile(listaPlatos.getString("p" + (i + 1)) + '\n');
				Matcher matcher = expresion.matcher(platosFiltrados);
				if (matcher.find()) {

				} else {
					platosFiltrados += h + 1 + ". " + listaPlatos.getString("p" + (i + 1)) + '\n';
					h++;
				}
			}
		} while (in.next().toUpperCase().charAt(0) == 'Y');

		System.out.print("Menú apto para las siguientes alergias: ");

		System.out.println(alergiasFiltradas);// Esto en un futuro será un for de todas las alergias
												// elegidas

		System.out.println(platosFiltrados);

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
