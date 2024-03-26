package presentacion;

import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //agregamos el serviio
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
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
}