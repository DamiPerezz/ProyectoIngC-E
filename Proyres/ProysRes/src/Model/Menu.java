package Model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        // Crear los 7 menús distintos
        List<JSONObject> menus = new ArrayList<>();

        // Lunes
        List<String> platosLunes = new ArrayList<>();
        platosLunes.add("Salmorejo");
        platosLunes.add("Empanada de atún");
        platosLunes.add("Bowl de frutas");

        // Ingredientes para el Salmorejo
        List<String> ingredientesSalmorejo = Arrays.asList("Tomate", "Pan", "Pepino", "Pimiento");

        // Ingredientes para la Empanada de atún
        List<String> ingredientesEmpanadaAtun = Arrays.asList("Hojaldre", "Tomate frito", "Atún", "Huevo cocido");

        // Ingredientes para el Bowl de frutas
        List<String> ingredientesBowlFrutas = Arrays.asList("Fresa", "Melón", "Plátano", "Naranja", "Manzana");

        JSONObject menuLunes = crearMenu("Lunes", platosLunes, ingredientesSalmorejo, ingredientesEmpanadaAtun, ingredientesBowlFrutas);
        menus.add(menuLunes);

        // Martes
        List<String> platosMartes = new ArrayList<>();
        platosMartes.add("Menestra de verduras");
        platosMartes.add("Fingers de pollo");
        platosMartes.add("Arroz con leche");

        // Ingredientes para la Menestra de verduras
        List<String> ingredientesMenestraVerduras = Arrays.asList("Calabacín", "Zanahoria", "Cebolla", "Pepino");

        // Ingredientes para los Fingers de pollo
        List<String> ingredientesFingersPollo = Arrays.asList("Pollo", "Pan rallado", "Huevo");

        // Ingredientes para el Arroz con leche
        List<String> ingredientesArrozLeche = Arrays.asList("Arroz", "Leche", "Azúcar", "Canela");

        JSONObject menuMartes = crearMenu("Martes", platosMartes, ingredientesMenestraVerduras, ingredientesFingersPollo, ingredientesArrozLeche);
        menus.add(menuMartes);

        
        // Miercoles
        List<String> platosMiercoles = new ArrayList<>();
        platosMartes.add("Sopa");
        platosMartes.add("Cocido");
        platosMartes.add("Tarta de queso");

        // Ingredientes para la sopa
        List<String> ingredientesSopa = Arrays.asList("Caldo de verduras", "Fideos", "Pollo");

        // Ingredientes para el cocido
        List<String> ingredientesCocido = Arrays.asList("Garbanzos", "Chorizo", "Tocino", "Repollo");

        // Ingredientes para la tarta de queso
        List<String> ingredientesTartadeQueso= Arrays.asList("Queso crema", "Leche", "Azúcar", "Mermelada"," Galletas", "Huevos");

        JSONObject menuMiercoles = crearMenu("Miércoles", platosMiercoles, ingredientesSopa, ingredientesCocido, ingredientesTartadeQueso);
        menus.add(menuMiercoles);

        
        // Jueves
        List<String> platosJueves = new ArrayList<>();
        platosMartes.add("Ensalada");
        platosMartes.add("Lubina al horno");
        platosMartes.add("Brownie");

        // Ingredientes para la ensalada
        List<String> ingredientesEnsalada = Arrays.asList("Brotes de espinacas", "Zanahoria", "Tomate", "Pepino", "Maíz", "Remolacha", "Atún");

        // Ingredientes para la lubina al horno
        List<String> ingredientesLubinaAlHorno = Arrays.asList("Lubina", "Patata", "Cebolla", "Salsa peregíl");

        // Ingredientes para el brownie
        List<String> ingredientesBrownie = Arrays.asList("Chocolate", "Leche", "Azúcar", "Huevos", "Harina", "Nueces");

        JSONObject menuJueves = crearMenu("Jueves", platosJueves, ingredientesEnsalada, ingredientesLubinaAlHorno, ingredientesBrownie);
        menus.add(menuJueves);

        
        // Viernes
        List<String> platosViernes = new ArrayList<>();
        platosMartes.add("Puré de calabacín");
        platosMartes.add("Solomillo con patatas");
        platosMartes.add("Bola de helado");

        // Ingredientes para el puré de calabacín
        List<String> ingredientesPureDeCalabacin = Arrays.asList("Calabacín", "Zanahoria", "Cebolla", "Patata", " Caldo de verduras");

        // Ingredientes para el solomillo con patatas
        List<String> ingredientesSolomilloConPatatas = Arrays.asList("Solomillo", "Patata", "Pimiento", "Salsa de vino");

        // Ingredientes para la bola de helado
        List<String> ingredientesBolaDeHelado = Arrays.asList( "Leche", "Azúcar", "Canela", "Vainilla");

        JSONObject menuViernes = crearMenu("Viernes", platosViernes, ingredientesPureDeCalabacin, ingredientesSolomilloConPatatas, ingredientesBolaDeHelado);
        menus.add(menuViernes);

        
        // Sábado
        List<String> platosSabado = new ArrayList<>();
        platosMartes.add("Puré de calabaza");
        platosMartes.add("Merluza en salsa");
        platosMartes.add("Flan");

        // Ingredientes para el puré de calabaza
        List<String> ingredientesPureDeCalabaza = Arrays.asList("Calabacín", "Zanahoria", "Cebolla", "Calabaza", "Caldo de verudras");

        // Ingredientes para la merluza en salsa
        List<String> ingredientesMerluzaEnSalsa = Arrays.asList("Merluza", "Almejas", "Salsa de marisco", "Chipirones");

        // Ingredientes para el flan
        List<String> ingredientesFlan = Arrays.asList("Huevo", "Leche", "Azúcar");

        JSONObject menuSabado = crearMenu("Sábado", platosSabado, ingredientesPureDeCalabaza, ingredientesMerluzaEnSalsa, ingredientesFlan);
        menus.add(menuSabado);

        
        // Domingo
        List<String> platosDomingo = new ArrayList<>();
        platosMartes.add("Judías con huevo y jamón");
        platosMartes.add("San jacobo");
        platosMartes.add("Fresas con nata");

        // Ingredientes para las jadías con huevo y jamón
        List<String> ingredientesJudiasHuevoJamon = Arrays.asList("Judías", "Jamón serrano", "Huevo cocido");

        // Ingredientes para el San jacobo
        List<String> ingredientesSanJacobo = Arrays.asList("Jamón cocido", "Queso", "Pan rallado");

        // Ingredientes para las fresas con nata
        List<String> ingredientesFresasConNata = Arrays.asList("Fresas", "Nata montada");

        JSONObject menuDomingo = crearMenu("Domingo", platosDomingo, ingredientesJudiasHuevoJamon, ingredientesSanJacobo, ingredientesFresasConNata);
        menus.add(menuDomingo);

  

        // Crear el JSONArray con todos los menús
        JSONArray jsonArray = new JSONArray(menus);

        // Guardar los menús en un archivo JSON
        guardarMenusEnArchivo(jsonArray);
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
}
