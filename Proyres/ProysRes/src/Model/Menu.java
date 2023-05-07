package Model;


import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Menu {

	 public static void main(String[] args) {


	    

	      // Crear un objeto JSON para el primer menú
	      JSONObject menu1 = new JSONObject();
	      JSONArray platos1 = new JSONArray();
	      platos1.put("Salmorejo");
	      platos1.put("Empanada de atún");
	      platos1.put("Bowl con fruta");
	      menu1.put("platos", platos1);
	      menu1.put("precio", "12 euros");



	      // Crear un objeto JSON para el segundo menú
	      JSONObject menu2 = new JSONObject();
	      JSONArray platos2 = new JSONArray();
	      platos2.put("Menestra de verduras");
	      platos2.put("Fingers de pollo");
	      platos2.put("Arroz con leche");
	      menu2.put("platos", platos2);
	      menu2.put("precio", "12 euros");


	     
	      
	      // Crear un objeto JSON para el segundo menú
	      JSONObject menu3 = new JSONObject();
	      JSONArray platos3 = new JSONArray();
	      platos3.put("Sopa");
	      platos3.put("Cocido");
	      platos3.put("Tarta de queso");
	      menu3.put("platos", platos3);
	      menu3.put("precio", "12 euros");

	      
	   // Crear un objeto JSON para el cuarto menú
	      JSONObject menu4 = new JSONObject();
	      JSONArray platos4 = new JSONArray();
	      platos4.put("Ensalada");
	      platos4.put("Lubina al horno");
	      platos4.put("Brownie");
	      menu4.put("platos", platos4);
	      menu4.put("precio", "12 euros");


	      
	      // Crear un objeto JSON para el quinto menú
	      JSONObject menu5 = new JSONObject();
	      JSONArray platos5 = new JSONArray();
	      platos5.put("Puré de calabacín");
	      platos5.put("Solomillo con patatas");
	      platos5.put("Bola de helado");
	      menu5.put("platos", platos5);
	      menu5.put("precio", "12 euros");


	      
	      // Crear un objeto JSON para el sexto menú
	      JSONObject menu6 = new JSONObject();
	      JSONArray platos6 = new JSONArray();
	      platos6.put("Puré de calabaza");
	      platos6.put("Merluza en salsa");
	      platos6.put("Flan");
	      menu6.put("platos", platos6);
	      menu6.put("precio", "12 euros");


	      // Crear un objeto JSON para el septimo menú
	      JSONObject menu7 = new JSONObject();
	      JSONArray platos7 = new JSONArray();
	      platos7.put("Judias con huevo y jamón");
	      platos7.put("San jacobo");
	      platos7.put("Fresas con nata");
	      menu7.put("platos", platos7);
	      menu7.put("precio", "12 euros");

	      JSONArray menuArray = new JSONArray();
	        menuArray.put(menu1);
	        menuArray.put(menu2);
	        menuArray.put(menu3);
	        menuArray.put(menu4);
	        menuArray.put(menu5);
	        menuArray.put(menu6);
	        menuArray.put(menu7);

	      try (FileWriter file = new FileWriter("menus.json")) {
		         file.write(menuArray.toString());
		       
		         System.out.println("Menús guardados en el archivo menus.json");
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
	   }
	}



