package Model;



import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Menu {

	 public static void main(String[] args) {


	      // Crear un objeto JSON para el restaurante
	      JSONObject menus = new JSONObject();

	      // Crear un objeto JSON para el primer menú
	      JSONObject menu1 = new JSONObject();
	      JSONArray platos1 = new JSONArray();
	      platos1.put("Salmorejo");
	      platos1.put("Empanada de atún");
	      platos1.put("Bowl con fruta");
	      menu1.put("platos", platos1);

	      // Agregar el primer menú al objeto JSON del restaurante
	      menus.put("menu 1-12 euros", menu1);

	      // Crear un objeto JSON para el segundo menú
	      JSONObject menu2 = new JSONObject();
	      JSONArray platos2 = new JSONArray();
	      platos2.put("Menestra de verduras");
	      platos2.put("Fingers de pollo");
	      platos2.put("Arroz con leche");
	      menu2.put("platos", platos2);

	      // Agregar el segundo menú al objeto JSON del restaurante
	      menus.put("menu 2-12 euros", menu2);
	      
	      // Crear un objeto JSON para el segundo menú
	      JSONObject menu3 = new JSONObject();
	      JSONArray platos3 = new JSONArray();
	      platos3.put("Sopa");
	      platos3.put("Cocido");
	      platos3.put("Tarta de queso");
	      menu3.put("platos", platos3);

	      // Agregar el segundo menú al objeto JSON del restaurante
	      menus.put("menu 3-12 euros", menu3);
	      
	   // Crear un objeto JSON para el cuarto menú
	      JSONObject menu4 = new JSONObject();
	      JSONArray platos4 = new JSONArray();
	      platos4.put("Ensalada");
	      platos4.put("Lubina al horno");
	      platos4.put("Brownie");
	      menu4.put("platos", platos4);

	      // Agregar el segundo menú al objeto JSON del restaurante
	      menus.put("menu 4-12 euros", menu4);
	      
	      // Crear un objeto JSON para el quinto menú
	      JSONObject menu5 = new JSONObject();
	      JSONArray platos5 = new JSONArray();
	      platos5.put("Puré de calabacín");
	      platos5.put("Solomillo con patatas");
	      platos5.put("Bola de helado");
	      menu5.put("platos", platos5);

	      // Agregar el segundo menú al objeto JSON del restaurante
	      menus.put("menu 5-12 euros", menu5);
	      
	      // Crear un objeto JSON para el sexto menú
	      JSONObject menu6 = new JSONObject();
	      JSONArray platos6 = new JSONArray();
	      platos6.put("Puré de calabaza");
	      platos6.put("Merluza en salsa");
	      platos6.put("Flan");
	      menu6.put("platos", platos6);

	      // Agregar el segundo menú al objeto JSON del restaurante
	      menus.put("menu 6-12 euros", menu6);
	      
	      // Crear un objeto JSON para el septimo menú
	      JSONObject menu7 = new JSONObject();
	      JSONArray platos7 = new JSONArray();
	      platos7.put("Judias con huevo y jamón");
	      platos7.put("San jacobo");
	      platos7.put("Fresas con nata");
	      menu7.put("platos", platos7);

	      // Agregar el segundo menú al objeto JSON del restaurante
	      menus.put("menu 7-12 euros", menu7);


	      // Guardar objeto JSON del restaurante en un archivo
	      try (FileWriter file = new FileWriter("menus.json")) {
	         file.write(menus.toString());
	         System.out.println("Menús guardados en el archivo menus.json");
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	}

