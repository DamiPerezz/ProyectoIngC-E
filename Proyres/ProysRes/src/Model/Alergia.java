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

	public static ArrayList<Plato> filtrarPlatos(String[] alergiasElegidas) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> arrayListAlergias = new ArrayList<String>();
		ArrayList<Plato> listaPlatos = new ArrayList<Plato>();
		int opcionUsuario;
		String opcionesUsuario;
		int h = 0; // usado para ir guardando con un nº asociado cada plato
		boolean contieneAlergia = false;
		

		String texto = "";
		String alergiasFiltradas = "";
		

			try {

				File Platos = new File("listaPlatos.json");
				Scanner sc = new Scanner(Platos);

				while (sc.hasNextLine()) {
					texto += sc.nextLine();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			JSONArray platosArr = new JSONArray(texto);

			for (int i = 0; i < platosArr.length(); i++) {
				contieneAlergia = false;
				JSONObject plato = platosArr.getJSONObject(i);
				for (int q = 0; q < alergiasElegidas.length; q++) {
					System.out.println(plato.get("alergia").toString().toLowerCase());
					System.out.println(alergiasElegidas[q]);

					if (plato.get("alergia").toString().toLowerCase().equals(alergiasElegidas[q])) {
						contieneAlergia = true;
					}
				}
					if (contieneAlergia == false) {

						Pattern patron = Pattern.compile(plato.getString("nombrePlato"));

						Matcher matchPlato = patron.matcher(alergiasFiltradas);

						if (matchPlato.find()) {

						} else {

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

							alergiasFiltradas += "- " + plato.get("nombrePlato") + '\n';

						
					}
				}

			}
			

		
			return listaPlatos;
		

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
