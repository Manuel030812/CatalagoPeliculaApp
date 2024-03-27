package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{
    private final String Nombre_Archivo = "peliculas.txt";
    public ServicioPeliculasArchivo(){
        var archivo = new File(Nombre_Archivo);
        try {
            // si ya existe el archivo no se vuelva a crear
            if (archivo.exists()){
                System.out.println("el archivo ya existe");
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("se a creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrur el archivo "+ e.getMessage());
        }
    }
    @Override
    public void listarPeliculas() {
        // volvemos abrir el archivo
        var archivo = new File(Nombre_Archivo);
        try {
            System.out.println("listado de peliculas");
            // abrir archivo
            var entrada = new BufferedReader(new FileReader(archivo));
            // leemos linea a  linea el archivo
            String linea;
            linea = entrada.readLine();
            //leeemos todas las linneas disponibles
            while (linea != null){
                var pelicual = new Pelicula(linea);
                System.out.println(pelicual);
                /// antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            // cerrar el arvhivo
            entrada.close();
        }catch (Exception e){
            System.out.println("ocurrio un error al abrir el archivo "+ e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        // volvemos abrir el archivo
        Boolean anexar = false;
        var archivo = new File(Nombre_Archivo);
        try {
            // revisamos si exxiste el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            // agreagamos la pelicual toString
            salida.println(pelicula);
            salida.close();
            System.out.println("se agrego al archivo la pelicula");

        }catch (Exception e){
            System.out.println("ocurrio un error a agregar la pelicula "+ e.getMessage());
        }

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
            var archivo = new File(Nombre_Archivo);
            try {
                //abrimos el archivo para lectura liea a linea
                var entrada = new BufferedReader(new FileReader(archivo));
                String lineaTexto;
                lineaTexto = entrada.readLine();
                var indice = 1;
                var encontrada = false;
                var peliculaBuscar = pelicula.getNombre();
                while (lineaTexto != null){
                    // buscamos sin importar mayusculas miniculas
                    if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                        encontrada = true;
                        break;
                    }
                    //
                    //leemos la siguiente liea antes de la siguiente interacion
                    lineaTexto = entrada.readLine();
                    indice++;
                }
                // imprimimos los resultados de la busqueda
                if (encontrada){
                    System.out.println("Pelicual: "+lineaTexto + " encontada - linea: "+ indice );
                }else {
                    System.out.println("no se a ecntontado la pelicual: "+pelicula.getNombre());
                }
                entrada.close();
            }catch (Exception e){
                System.out.println("error al buscar el archivo "+ e.getMessage());
            }
    }
}
