package Codigo.albumes_musica.src;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Album representa un álbum con canciones.
 * 
 * @see Cancion
 * @see ListaAlbum
 */
public class Album {
    private String nombreAlbum;
    private int anioLanzamientoAlbum;
    private String disqueraAlbum;
    private List<String> artistasAlbum;
    private List<Cancion> canciones;


    /**
     * Constructor para la clase Album.
     *
     * @param nombreAlbum         El nombre del álbum.
     * @param anioLanzamientoAlbum El año de lanzamiento del álbum.
     * @param disqueraAlbum       La disquera del álbum.
     * @param artistasAlbum       Los artistas del álbum.
     */    
    public Album(String nombreAlbum, int anioLanzamientoAlbum, String disqueraAlbum, List<String> artistasAlbum) {
        this.nombreAlbum = nombreAlbum;
        this.anioLanzamientoAlbum = anioLanzamientoAlbum;
        this.disqueraAlbum = disqueraAlbum;
        this.artistasAlbum = artistasAlbum;
        this.canciones = new ArrayList<>();
    }


    /**
     * Agrega una canción al álbum si el título no está repetido.
     *
     * @param cancion La canción a agregar.
     * @throws Exception Si la canción tiene un título repetido.
     * @see Cancion
     */
    public void addCancion(Cancion cancion) throws Exception{
        for (Cancion c : canciones) {
            if (tieneTituloRepetido(cancion, c)) {
                throw new Exception("No se puede agregar canciones con título repetido");
            }
        }
        canciones.add(cancion);
    }

    /**
     * Verifica si la canción tiene un título repetido.
     *
     * @param cancion La nueva canción a verificar.
     * @param c       Una canción existente en el álbum.
     * @return True si el título está repetido, False en caso contrario.
     * @see Cancion
     */
    private boolean tieneTituloRepetido(Cancion cancion, Cancion c) {
        return c.getTituloCancion().equalsIgnoreCase(cancion.getTituloCancion());
    }

    /**
     * Obtiene la lista de canciones del álbum.
     *
     * @return La lista de canciones.
     * @see Cancion
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Obtiene el nombre del álbum.
     *
     * @return El nombre del álbum.
     */
    public String getNombreAlbum() {
        return nombreAlbum;
    }

    /**
     * Obtiene el año de lanzamiento del álbum.
     *
     * @return El año de lanzamiento del álbum.
     */
    public int getAnioLanzamientoAlbum() {
        return anioLanzamientoAlbum;
    }

    /**
     * Obtiene la disquera del álbum.
     *
     * @return La disquera del álbum.
     */
    public String getDisqueraAlbum() {
        return disqueraAlbum;
    }

    /**
     * Obtiene los artistas del álbum.
     *
     * @return La lista de artistas del álbum.
     */
    public List<String> getArtistasAlbum() {
        return artistasAlbum;
    }
}