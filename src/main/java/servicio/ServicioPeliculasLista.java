package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }
   @Override
    public void listarPeliculas() {
       System.out.println("Listado de peliculas...");
       peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("se agrego la pelicula "+ pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // regresa el indice de la pelicula encontrada n la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice==-1){
            System.out.println("pelicual no existe" + pelicula);
        }else {
            System.out.println("pelicula encontrada en el indice " + indice);
        }

    }

    public static void main(String[] args) {
        // cramos algunos objetos tipo pelicual
        var pelicula1 = new Pelicula("batman");
        var pelicula2 = new Pelicula("superman");
        //cramos el servicio patron de disenio service
        IServicioPeliculas servicioPeliculas =new ServicioPeliculasLista();
        //agrefamos las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        //listarmos las peliculas
        servicioPeliculas.listarPeliculas();
        //buscar pelicula implementar equals y hashcode
        servicioPeliculas.buscarPelicula(pelicula1);
    }
}
