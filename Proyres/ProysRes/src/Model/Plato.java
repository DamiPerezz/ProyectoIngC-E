package Model;

public class Plato {

	private int precio;
	private String Ingrediente;
	private String nombrePlato;

	public Plato(int precio, String ingrediente, String nombrePlato) {
		super();
		this.precio = precio;
		Ingrediente = ingrediente;
		this.nombrePlato = nombrePlato;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getIngrediente() {
		return Ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		Ingrediente = ingrediente;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public void mostrar() {
		System.out.println("Nombre:" + this.getNombrePlato() + "Ingrediente: "+ this.getIngrediente()+ "Precio: " +  this.getPrecio()  );
		
	}

}