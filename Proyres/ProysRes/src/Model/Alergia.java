package Model;

pimport java.util.ArrayList;

public class Alergia {
	
	private String nombre;
	private ArrayList <Plato> listaPlatos;
	
    
    public Alergia(String nombre, Plato plato) {
    	
    	this.nombre = nombre;
    	this.listaPlatos =new ArrayList<Plato>();
    	
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Plato> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(ArrayList<Plato> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}
	
	public void mostrar() {
		System.out.println("Nombre:" + this.getNombre());
		for (Plato p : listaPlatos) {
			if ( p != null) {
				p.mostrar();
			}
		}
	}
	
	public void addPlato ( Plato plato) {
		listaPlatos.add(plato);
		}
	
	
    
	
}

