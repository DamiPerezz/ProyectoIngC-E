package Model;

import java.util.ArrayList;

public class Ingrediente {

	private String nombre;
	private String nutriente;
	private ArrayList<Plato> listaPlatos;
	private ArrayList<Alergia> listaAlergias;

	public Ingrediente(String nombre, String nutriente) {
		super();

		this.nombre = nombre;
		this.nutriente = nutriente;
		this.listaPlatos = new ArrayList<Plato>();
		this.listaAlergias = new ArrayList<Alergia>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNutrinete(String nutriente) {
		return nutriente;
	}

	public void setNutrinete(String nutriente) {
		this.nutriente = nutriente;
	}

	public ArrayList<Plato> getListaPlatos() {
		return listaPlatos;
	}

	public ArrayList<Alergia> getListaAlergia() {
		return listaAlergias;
	}
}
