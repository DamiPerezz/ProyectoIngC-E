package Model;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class Alergia {

	private JSONObject jsonAlergias = new JSONObject();

	public Alergia() {

		try {

			
			FileWriter file = new FileWriter("listaAlergias.json");

			file.write(jsonAlergias.toString());
			file.flush();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	



}
