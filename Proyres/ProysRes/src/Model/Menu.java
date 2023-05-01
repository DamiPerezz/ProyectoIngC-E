package Model;

import java.util.ArrayList;

public class Menu {

	private String precio;
	private int numPlatos;
	private ArrayList<Plato> listaplatos;
	private ArrayList<Alergia> listaAlergias;

	public Menu(String precio, int numPlatos, ArrayList<Plato> listaplatos, ArrayList<Alergia> listaAlergias) {
		super();
		this.precio = precio;
		this.numPlatos = numPlatos;
		this.listaplatos = listaplatos;
		this.listaAlergias = listaAlergias;
	}

	public void addPlato(Plato plato) {

		listaplatos.add(plato);

	}


	
	
	
	
	
	

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public ArrayList<Plato> getListaplatos() {
		return listaplatos;
	}

	public void setListaplatos(ArrayList<Plato> listaplatos) {
		this.listaplatos = listaplatos;
	}

	public int getNumPlatos() {
		return numPlatos;
	}

	public ArrayList<Alergia> getListaAlergias() {
		return listaAlergias;
	}

}