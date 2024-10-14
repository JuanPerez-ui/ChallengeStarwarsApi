import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaApi consulta = new ConsultaApi();
        GuardarJson guardar = new GuardarJson();

        Scanner lectura = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            while (true) {
                System.out.println("Escriba el número de la pelicula");
                var numeroDePelicula = lectura.nextLine();

                if (numeroDePelicula.equalsIgnoreCase("salir")) {
                    break;
                }

                Pelicula pelicula = consulta.buscaPelicula(Integer.valueOf(numeroDePelicula));
                System.out.println(pelicula);
                peliculas.add(pelicula);
            }
        }catch (NumberFormatException e) {
            System.out.println("numero no encontrado " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("finalizando la aplicacion");
        }
        
        guardar.guardarArchivoJson(peliculas);
        System.out.println(peliculas);
    }
}