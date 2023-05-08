package Model;
import java.util.Scanner;

import Control.Administrador;

public class main {



	    public static void main(String[] args) {
	        String contrasenaCorrecta = "luis";
	        Administrador admin = new Administrador(contrasenaCorrecta);
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese la contraseña del administrador: ");
	        String contrasenaIngresada = scanner.nextLine();

	        if (admin.verificarContrasena(contrasenaIngresada)) {
	            System.out.println("Acceso concedido.");
	  
	            
	            // Lógica para mostrar las opciones del modo de administrador
	            // y permitir al usuario utilizar los métodos de la clase Administrador
	        } else {
	            System.out.println("Acceso denegado. Contraseña incorrecta.");
	        }

	        scanner.close();
	    }
	}

