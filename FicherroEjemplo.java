import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class FicherroEjemplo<var> {
    // HMaria estuvo aquí
    // nada que ver aquídddd


  
        public static void main(String[] args) {
            Gson gson = new Gson();
            try (FileReader reader = new FileReader("datos.json")) {
                // Leer el archivo JSON en un objeto Java
                Data data = gson.fromJson(reader, Data.class);
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
      }
    


}


class Data {
    private int id;
    private String nombre;
    private String descripcion;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}