package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La clase ListaAlbum maneja una colección de álbumes.
 * 
 * @see Album
 */
class ListaAlbum {
    private List<Album> listaAlbum;

    /**
     * Constructor para la clase ListaAlbum.
     */
    public ListaAlbum() {
        this.listaAlbum = new ArrayList<>();
    }

    /**
     * Obtiene la lista de canciones de un álbum específico.
     *
     * @param nombreAlbum El nombre del álbum.
     * @return La lista de canciones del álbum.
     * @see Cancion
     * @see Album
     */
    public List<Cancion> visualizarAlbum(String nombreAlbum) {
        for (Album album : listaAlbum) {
            if (album.getNombreAlbum().equalsIgnoreCase(nombreAlbum)) {
                return album.getCanciones();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Busca álbumes por año de lanzamiento.
     *
     * @param anioLanzamiento El año de lanzamiento.
     * @return La lista de álbumes lanzados en ese año.
     * @see Album
     */
    public List<Album> buscarAlbumPorAnio(int anioLanzamiento) {
        return listaAlbum.stream()
                .filter(album -> album.getAnioLanzamientoAlbum() == anioLanzamiento)
                .collect(Collectors.toList());
    }

    /**
     * Agrega un álbum a la lista.
     *
     * @param album El álbum a agregar.
     * @see Album
     */
    public void addAlbum(Album album) {
        listaAlbum.add(album);
    }

    /**
     * Obtiene un álbum por su nombre.
     *
     * @param nombreAlbum El nombre del álbum.
     * @return El álbum si se encuentra, null en caso contrario.
     * @see Album
     */
    public Album obtenerAlbumPorNombre(String nombreAlbum) {
        Album albumExistente = null;
        for (Album album : listaAlbum) {
            if (album.getNombreAlbum().equalsIgnoreCase(nombreAlbum)) {
                albumExistente = album;
            }
        }
        return albumExistente;
    }
}