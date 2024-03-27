package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //agregamos el serviio
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir){
            try {
                mostrarMenu();
               salir = ejecutarOpciones(consola,servicioPeliculas);
            }catch (Exception e){
                System.out.println("ocurrio un error: "+ e.getMessage());
            }
            System.out.println();
        }//fin while
    }
    private  static  void  mostrarMenu(){
        System.out.print("""
                ***Catalogo de peliculas ***
                1. agregar pelicula
                2. listar pelicula
                3. buscar pelicula
                4. salir
                elige una opcion: """);


    }

    private  static boolean ejecutarOpciones(Scanner consola,IServicioPeliculas servicioPeliculas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir= false;
        switch (opcion){
            case 1->{
                System.out.println("introduce el nombre de la pelicula");
                var nombrePelicual = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicual));
            }
            case 2 ->servicioPeliculas.listarPeliculas();
            case 3->{
                System.out.println("introduce la pelicula a buscar");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 ->{
                System.out.println("hasta pronto");
                salir = true;
            }
            default -> System.out.println("opcion no reconocida: "+ opcion);
        }
        return salir;
    }
}