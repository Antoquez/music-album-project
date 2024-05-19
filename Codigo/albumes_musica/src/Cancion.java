package Codigo.albumes_musica.src;

/**
 * La clase Cancion representa una canción con un título y una duración.
 * 
 * @see Album
 */
public class Cancion {
    private String tituloCancion;
    private int duracionCancion; // duración en segundos

    /**
     * Constructor para la clase Cancion.
     *
     * @param tituloCancion   El título de la canción.
     * @param duracionCancion La duración de la canción en segundos.
     */
    public Cancion(String tituloCancion, int duracionCancion) {
        this.tituloCancion = tituloCancion;
        this.duracionCancion = duracionCancion;
    }

    
    /**
     * Obtiene el título de la canción.
     *
     * @return El título de la canción.
     */
    public String getTituloCancion() {
        return tituloCancion;
    }

    /**
     * Obtiene la duración de la canción.
     *
     * @return La duración de la canción en segundos.
     */
    public int getDuracionCancion() {
        return duracionCancion;
    }
}
