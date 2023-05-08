package Control;

public class Administrador {
    private String contrasena;

	    public Administrador(String contrasena) {
	        this.contrasena = contrasena;
	    }

	    public void anadirPlato() {
	        // Lógica para añadir un plato
	    }

	    public void anadirIngrediente() {
	        // Lógica para añadir un ingrediente
	    }

	    public void cambiarMenu() {
	        // Lógica para cambiar el menú
	    }

	    public void gestionarTupper() {
	        // Lógica para gestionar tuppers
	    }

	    public boolean verificarContrasena(String contrasenaIngresada) {
	        return this.contrasena.equals(contrasenaIngresada);
	    }
	}


