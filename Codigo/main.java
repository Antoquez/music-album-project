package Codigo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ListaAlbum listaAlbum = new ListaAlbum();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar un nuevo álbum");
            System.out.println("2. Agregar una canción a un álbum existente");
            System.out.println("3. Ver la lista de canciones de un álbum específico");
            System.out.println("4. Buscar álbumes por año de lanzamiento");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int anioLanzamiento=0; 
            switch (opcion) {
                case 1:
                    // HU1: Agregar un nuevo álbum
                    System.out.println("Ingrese el nombre del álbum:");
                    String nombreAlbum = scanner.nextLine();
                    System.out.println("Ingrese el año de lanzamiento del álbum:");
                    anioLanzamiento = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Ingrese la disquera del álbum:");
                    String disquera = scanner.nextLine();
                    System.out.println("Ingrese los artistas del álbum (separados por comas):");
                    String artistas = scanner.nextLine();
                    List<String> listaArtistas = Arrays.asList(artistas.split(","));

                    Album nuevoAlbum = new Album(nombreAlbum, anioLanzamiento, disquera, listaArtistas);
                    listaAlbum.addAlbum(nuevoAlbum);
                    System.out.println("Álbum agregado exitosamente.");
                    break;

                case 2:
                    // HU2: Agregar una canción a un álbum existente
                    System.out.println("Ingrese el nombre del álbum al que desea agregar la canción:");
                    String nombreAlbumExistente = scanner.nextLine();
                    Album albumExistente = listaAlbum.obtenerAlbumPorNombre(nombreAlbumExistente);

                    if (albumExistente != null) {
                        System.out.println("Ingrese el título de la canción:");
                        String tituloCancion = scanner.nextLine();
                        System.out.println("Ingrese la duración de la canción en minutos:");
                        int duracionMinutos = scanner.nextInt();
                        int duracionSegundos = duracionMinutos * 60;
                        scanner.nextLine(); // Consume newline

                        Cancion nuevaCancion = new Cancion(tituloCancion, duracionSegundos);
                        try {
                            albumExistente.addCancion(nuevaCancion);
                            System.out.println("Canción agregada exitosamente.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());;
                        }                        

                    } else {
                        System.out.println("Álbum no encontrado.");
                    }
                    break;

                case 3:
                    // HU4: Ver la lista de canciones de un álbum específico
                    System.out.println("Ingrese el nombre del álbum del que desea ver las canciones:");
                    String nombreAlbumParaVer = scanner.nextLine();
                    List<Cancion> canciones = listaAlbum.visualizarAlbum(nombreAlbumParaVer);

                    if (!canciones.isEmpty()) {
                        System.out.println("Lista de canciones del álbum " + nombreAlbumParaVer + ":");
                        for (Cancion cancion : canciones) {
                            System.out.println("Título: " + cancion.getTituloCancion() + ", Duración: " + cancion.getDuracionCancion() + " segundos");
                        }
                    } else {
                        System.out.println("Álbum no encontrado o no tiene canciones.");
                    }
                    break;

                case 4:
                    // HU5: Buscar álbumes por año de lanzamiento
                    System.out.println("Ingrese el año de lanzamiento para buscar álbumes:");
                    int anioParaBuscar = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    List<Album> albumsPorAnio = listaAlbum.buscarAlbumPorAnio(anioParaBuscar);

                    if (!albumsPorAnio.isEmpty()) {
                        System.out.println("Álbumes lanzados en el año " + anioParaBuscar + ":");
                        for (Album album : albumsPorAnio) {
                            System.out.println("Nombre: " + album.getNombreAlbum() + ", Disquera: " + album.getDisqueraAlbum() + ", Artistas: " + String.join(", ", album.getArtistasAlbum()));
                        }
                    } else {
                        System.out.println("No se encontraron álbumes para el año especificado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }
}
