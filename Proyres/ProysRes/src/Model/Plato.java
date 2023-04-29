package Model;

import java.util.ArrayList;

public class Plato {

	private int precio;
	private ArrayList<Ingrediente> listaIngredientes = new ArrayList();
	private String nombrePlato;

	public Plato(int precio, Ingrediente ingrediente, String nombrePlato) {
		super();
		this.precio = precio;
		listaIngredientes.add(ingrediente);
		this.nombrePlato = nombrePlato;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getIngrediente() {
		return null;
	}

	public void setIngrediente(String ingrediente) {
		
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