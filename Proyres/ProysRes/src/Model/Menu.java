package Model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String DiaSemana;
	private int precio;
	private ArrayList<Plato> listaPlatos;
	
	
	
	public Menu(String DiaSemana,int precio,ArrayList<Plato> listaPlatos  ) {
		super();
		this.DiaSemana=DiaSemana;
		this.precio=precio;
		this.listaPlatos=listaPlatos;
	}
	

	public Menu(ArrayList<Plato> listaPlatos  ) {
		super();
		
		this.listaPlatos=listaPlatos;
	}
	
	
	public String getDiaSemana() {
		return DiaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		DiaSemana = diaSemana;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public ArrayList<Plato> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(ArrayList<Plato> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	public Menu() {
		super();
		
	}



	public static void main(String[] args) {
		Menu m = new Menu();
		m = m.CrearMenu();
		m.AñadirMenuAFichero(m);
		
		
//        // Crear los 7 menús distintos
//        List<JSONObject> menus = new ArrayList<>();
//
//        // Lunes
//        List<String> platosLunes = new ArrayList<>();
//        platosLunes.add("Salmorejo");
//        platosLunes.add("Empanada de atún");
//        platosLunes.add("Bowl de frutas");
//
//        // Ingredientes para el Salmorejo
//        List<String> ingredientesSalmorejo = Arrays.asList("Tomate", "Pan", "Pepino", "Pimiento");
//
//        // Ingredientes para la Empanada de atún
//        List<String> ingredientesEmpanadaAtun = Arrays.asList("Hojaldre", "Tomate frito", "Atún", "Huevo cocido");
//
//        // Ingredientes para el Bowl de frutas
//        List<String> ingredientesBowlFrutas = Arrays.asList("Fresa", "Melón", "Plátano", "Naranja", "Manzana");
//
//        JSONObject menuLunes = crearMenu("Lunes", platosLunes, ingredientesSalmorejo, ingredientesEmpanadaAtun, ingredientesBowlFrutas);
//        menus.add(menuLunes);
//
//        // Martes
//        List<String> platosMartes = new ArrayList<>();
//        platosMartes.add("Menestra de verduras");
//        platosMartes.add("Fingers de pollo");
//        platosMartes.add("Arroz con leche");
//
//        // Ingredientes para la Menestra de verduras
//        List<String> ingredientesMenestraVerduras = Arrays.asList("Calabacín", "Zanahoria", "Cebolla", "Pepino");
//
//        // Ingredientes para los Fingers de pollo
//        List<String> ingredientesFingersPollo = Arrays.asList("Pollo", "Pan rallado", "Huevo");
//
//        // Ingredientes para el Arroz con leche
//        List<String> ingredientesArrozLeche = Arrays.asList("Arroz", "Leche", "Azúcar", "Canela");
//
//        JSONObject menuMartes = crearMenu("Martes", platosMartes, ingredientesMenestraVerduras, ingredientesFingersPollo, ingredientesArrozLeche);
//        menus.add(menuMartes);
//
//        
//        // Miercoles
//        List<String> platosMiercoles = new ArrayList<>();
//        platosMartes.add("Sopa");
//        platosMartes.add("Cocido");
//        platosMartes.add("Tarta de queso");
//
//        // Ingredientes para la sopa
//        List<String> ingredientesSopa = Arrays.asList("Caldo de verduras", "Fideos", "Pollo");
//
//        // Ingredientes para el cocido
//        List<String> ingredientesCocido = Arrays.asList("Garbanzos", "Chorizo", "Tocino", "Repollo");
//
//        // Ingredientes para la tarta de queso
//        List<String> ingredientesTartadeQueso= Arrays.asList("Queso crema", "Leche", "Azúcar", "Mermelada"," Galletas", "Huevos");
//
//        JSONObject menuMiercoles = crearMenu("Miércoles", platosMiercoles, ingredientesSopa, ingredientesCocido, ingredientesTartadeQueso);
//        menus.add(menuMiercoles);
//
//        
//        // Jueves
//        List<String> platosJueves = new ArrayList<>();
//        platosMartes.add("Ensalada");
//        platosMartes.add("Lubina al horno");
//        platosMartes.add("Brownie");
//
//        // Ingredientes para la ensalada
//        List<String> ingredientesEnsalada = Arrays.asList("Brotes de espinacas", "Zanahoria", "Tomate", "Pepino", "Maíz", "Remolacha", "Atún");
//
//        // Ingredientes para la lubina al horno
//        List<String> ingredientesLubinaAlHorno = Arrays.asList("Lubina", "Patata", "Cebolla", "Salsa peregíl");
//
//        // Ingredientes para el brownie
//        List<String> ingredientesBrownie = Arrays.asList("Chocolate", "Leche", "Azúcar", "Huevos", "Harina", "Nueces");
//
//        JSONObject menuJueves = crearMenu("Jueves", platosJueves, ingredientesEnsalada, ingredientesLubinaAlHorno, ingredientesBrownie);
//        menus.add(menuJueves);
//
//        
//        // Viernes
//        List<String> platosViernes = new ArrayList<>();
//        platosMartes.add("Puré de calabacín");
//        platosMartes.add("Solomillo con patatas");
//        platosMartes.add("Bola de helado");
//
//        // Ingredientes para el puré de calabacín
//        List<String> ingredientesPureDeCalabacin = Arrays.asList("Calabacín", "Zanahoria", "Cebolla", "Patata", " Caldo de verduras");
//
//        // Ingredientes para el solomillo con patatas
//        List<String> ingredientesSolomilloConPatatas = Arrays.asList("Solomillo", "Patata", "Pimiento", "Salsa de vino");
//
//        // Ingredientes para la bola de helado
//        List<String> ingredientesBolaDeHelado = Arrays.asList( "Leche", "Azúcar", "Canela", "Vainilla");
//
//        JSONObject menuViernes = crearMenu("Viernes", platosViernes, ingredientesPureDeCalabacin, ingredientesSolomilloConPatatas, ingredientesBolaDeHelado);
//        menus.add(menuViernes);
//
//        
//        // Sábado
//        List<String> platosSabado = new ArrayList<>();
//        platosMartes.add("Puré de calabaza");
//        platosMartes.add("Merluza en salsa");
//        platosMartes.add("Flan");
//
//        // Ingredientes para el puré de calabaza
//        List<String> ingredientesPureDeCalabaza = Arrays.asList("Calabacín", "Zanahoria", "Cebolla", "Calabaza", "Caldo de verudras");
//
//        // Ingredientes para la merluza en salsa
//        List<String> ingredientesMerluzaEnSalsa = Arrays.asList("Merluza", "Almejas", "Salsa de marisco", "Chipirones");
//
//        // Ingredientes para el flan
//        List<String> ingredientesFlan = Arrays.asList("Huevo", "Leche", "Azúcar");
//
//        JSONObject menuSabado = crearMenu("Sábado", platosSabado, ingredientesPureDeCalabaza, ingredientesMerluzaEnSalsa, ingredientesFlan);
//        menus.add(menuSabado);
//
//        
//        // Domingo
//        List<String> platosDomingo = new ArrayList<>();
//        platosMartes.add("Judías con huevo y jamón");
//        platosMartes.add("San jacobo");
//        platosMartes.add("Fresas con nata");
//
//        // Ingredientes para las jadías con huevo y jamón
//        List<String> ingredientesJudiasHuevoJamon = Arrays.asList("Judías", "Jamón serrano", "Huevo cocido");
//
//        // Ingredientes para el San jacobo
//        List<String> ingredientesSanJacobo = Arrays.asList("Jamón cocido", "Queso", "Pan rallado");
//
//        // Ingredientes para las fresas con nata
//        List<String> ingredientesFresasConNata = Arrays.asList("Fresas", "Nata montada");
//
//        JSONObject menuDomingo = crearMenu("Domingo", platosDomingo, ingredientesJudiasHuevoJamon, ingredientesSanJacobo, ingredientesFresasConNata);
//        menus.add(menuDomingo);
//
//  
//
//        // Crear el JSONArray con todos los menús
//        JSONArray jsonArray = new JSONArray(menus);
//
//        // Guardar los menús en un archivo JSON
//        guardarMenusEnArchivo(jsonArray);
    }
	
	
	public Menu CrearMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escoje un dia de la semana para el menu" + "\n" + "Lunes/Martes/Miercoles/Jueves/Viernes/Sabado/Domingo");
		String dia= sc.next();
		if (dia=="Lunes" ||dia=="Martes" || dia=="Miercoles" || dia=="Jueves" || dia=="Viernes" || dia=="Sabado" || dia=="Domingo") {
			this.DiaSemana=dia;
		}else {
			//Crear Excepcion
			
		}
		ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();
		boolean SeguirPedido = true;
		ArrayList<Plato> PlatosMenu = new ArrayList<Plato>();
		do {
			PlatosMenu.add(añadirPlatoAlMenu());
			System.out.println("¿Quieres seguir añadiendo platos? (y/n)");
			char resp=sc.next().charAt(0);
			if(resp=='y'||resp=='n' ) {
				if(resp=='n') {
					SeguirPedido=false;
				}
				if(resp=='y') {
					System.out.println("Sigamos!!");
				}
			} else {
				System.out.println("Respuesta invalida");
			}
		}while(SeguirPedido==true);
		System.out.println("Introduce precio del menu");
		int precio=sc.nextInt();
		
		Menu m = new Menu(dia, precio, PlatosMenu);
		
		return m;
		
	}
	public Plato añadirPlatoAlMenu() {
		
		System.out.println("¿Que platos quieres añadir al menu?");
		System.out.println("Disclaimer: INTRODUCIR NOMBRE EXACTAMENTE IGUAL QUE EN LAS OPCIONES");
		ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();
		for (Plato p : PlatosDisponibles) {
			System.out.println("- " + p.getNombrePlato());
		}
		Scanner sc = new Scanner(System.in);
		// Falta metodo filtrar añadir
		String nombrePlato = sc.nextLine();
		return AgregarPlato(nombrePlato);	
	}
	
	public Plato AgregarPlato(String nombrePlato) {
		
	ArrayList<Plato> PlatosDisponibles = SacarInstanciasPlato();

	Plato p = null;

	for (Plato plato : PlatosDisponibles) {
		if (plato.getNombrePlato().equals(nombrePlato)) {
			p = plato;
			break;
		} else {
			
		}
	}

	return p;

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
	
    public void AñadirMenuAFichero(Menu m) {
    	
    JSONObject menu = new JSONObject();
    menu.put("DiaSemana", this.DiaSemana);
    menu.put("precio", this.precio);
    //Crea el JSONArray que contiene los platos
    
    JSONArray platos = new JSONArray();
   //Saca de cada menu un JSONARRAY de JSONObject de platos
    for (Plato p: this.listaPlatos) {
    	JSONObject plato = new JSONObject();
    	//Guarda atributos de la instancia de plato en JSON
    	plato.put("precio", p.getPrecio());
    	plato.put("nombrePlato", p.getNombrePlato());
    	plato.put("NOPlato", p.getNOPlato());
    	plato.put("Alergia", p.getAlergia());
    	JSONArray Ingredientes = new JSONArray();
    	for(Ingrediente i: p.getListaIngredientes()) {
    		Ingredientes.put(i);
    	}
    	plato.put("listaIngredientes", Ingredientes);
    	platos.put(plato);
    }
    //Este es el JSONObject de Menu que queremos
    	menu.put("listaPlatos", platos);
    
    //Como esta guardado en un JSONArray de los JSONObjects de menu
    	
    	
    	
    //Guarda en fichero la instancia de menus creada
    
    	try {
		File file = new File("menusSemana/menu"+ m.DiaSemana+".json");

		// Crear el objeto FileWriter
		FileWriter writer = new FileWriter(file);

		// Escribir el objeto JSON en el archivo
		writer.write(menu.toString());

		// Cerrar el objeto FileWriter
		writer.close();
	}catch(Exception ex) {
		System.out.println("ODIO EL JSON");
	}
     
    	
    }
    
    
    private static JSONObject crearMenu(String diaSemana, List<String> platos, List<String> ingredientesPlato1, List<String> ingredientesPlato2, List<String> ingredientesPlato3) {
        JSONObject menu = new JSONObject();
        menu.put("dia_semana", diaSemana);

        // Crear una lista de platos
        List<JSONObject> platosJson = new ArrayList<>();
        for (int i = 0; i < platos.size(); i++) {
            String plato = platos.get(i);
            List<String> ingredientes = new ArrayList<>();
            if (plato.equals("Salmorejo")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("Empanada de atún")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Bowl de frutas")) {
                ingredientes = ingredientesPlato3;
            } else if (plato.equals("Menestra de verduras")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("Fingers de pollo")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Arroz con leche")) {
                ingredientes = ingredientesPlato3;
            }else if (plato.equals("Sopa")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("Cocido")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Tarta de queso")) {
                ingredientes = ingredientesPlato3;
            }else if (plato.equals("Ensalada")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("Lubina al horno")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Brownie")) {
                ingredientes = ingredientesPlato3;
            }else if (plato.equals("Puré de calabacín")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("Solomillo con patatas")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Bola de helado")) {
                ingredientes = ingredientesPlato3;
            }else if (plato.equals("Puré de calabaza")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("Merluza en salsa")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Flan")) {
                ingredientes = ingredientesPlato3;
            }else if (plato.equals("Judías con huevo y jamón")) {
                ingredientes = ingredientesPlato1;
            } else if (plato.equals("San jacobo")) {
                ingredientes = ingredientesPlato2;
            } else if (plato.equals("Fresas con nata")) {
                ingredientes = ingredientesPlato3;
            }
            platosJson.add(crearPlato(plato, ingredientes));
        }

        menu.put("platos", new JSONArray(platosJson));
        return menu;
    }

    private static JSONObject crearPlato(String nombre, List<String> ingredientes) {
        JSONObject plato = new JSONObject();
        plato.put("nombre", nombre);
        plato.put("ingredientes", new JSONArray(ingredientes));
        return plato;
    }

    private static void guardarMenusEnArchivo(JSONArray jsonArray) {
        try (FileWriter file = new FileWriter("menus.json")) {
            file.write(jsonArray.toString());
            System.out.println("Los menús se han guardado correctamente en el archivo 'menus.json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    public String toString() {
    	
    	return this.listaPlatos + "\n" + this.precio + "$";
    }
}
