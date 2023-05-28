package Model;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Almacen {

	private int numTupper;
	
	public int getNumTupper() {
		return numTupper;
	}
	public void setNumTupper(int numTupper) {
		this.numTupper = numTupper;
	}
	public Almacen() {
		super();
		this.numTupper = SacarTupper();
	}	
	public int SacarTupper() {
		int n=0;
		String ntxt="";
		try {
			File fichero = new File("registroTupper.txt");
			Scanner lector = new Scanner(fichero);
			while(lector.hasNext()) {
				ntxt = lector.next();
				n=Integer.parseInt(ntxt);
			}
 			
			
		}catch(Exception ex) {
			ex.getMessage();
		}
		
		return n;
	}
	public void GuardarNTupper(int nTuppers) {
		try {
			FileWriter escritor = new FileWriter("registroTupper.txt");
			escritor.write(String.valueOf(nTuppers));
			escritor.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
		
	}

}
