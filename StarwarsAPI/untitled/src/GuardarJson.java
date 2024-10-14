import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuardarJson {
    void guardarArchivoJson (List peliculas) {
        FileWriter escritura;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            escritura = new FileWriter("peliculas.json");
            escritura.write(gson.toJson(peliculas));
            escritura.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
