package Codigo;

import java.util.ArrayList;
import java.util.List;

class Album {
    private String nombreAlbum;
    private int anioLanzamientoAlbum;
    private String disqueraAlbum;
    private List<String> artistasAlbum;
    private List<Cancion> canciones;

    public Album(String nombreAlbum, int anioLanzamientoAlbum, String disqueraAlbum, List<String> artistasAlbum) {
        this.nombreAlbum = nombreAlbum;
        this.anioLanzamientoAlbum = anioLanzamientoAlbum;
        this.disqueraAlbum = disqueraAlbum;
        this.artistasAlbum = artistasAlbum;
        this.canciones = new ArrayList<>();
    }

    //Devuelve true si se añade la cancion correctamente
    public void addCancion(Cancion cancion) throws Exception{
        for (Cancion c : canciones) {
            if (tieneTituloRepetido(cancion, c)) {
                throw new Exception("No se puede agregar canciones con título repetido");
            }
        }
        canciones.add(cancion);
    }

    private boolean tieneTituloRepetido(Cancion cancion, Cancion c) {
        return c.getTituloCancion().equalsIgnoreCase(cancion.getTituloCancion());
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public int getAnioLanzamientoAlbum() {
        return anioLanzamientoAlbum;
    }

    public String getDisqueraAlbum() {
        return disqueraAlbum;
    }

    public List<String> getArtistasAlbum() {
        return artistasAlbum;
    }
}