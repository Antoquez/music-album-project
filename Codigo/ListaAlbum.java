package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ListaAlbum {
    private List<Album> listaAlbum;

    public ListaAlbum() {
        this.listaAlbum = new ArrayList<>();
    }

    public List<Cancion> visualizarAlbum(String nombreAlbum) {
        for (Album album : listaAlbum) {
            if (album.getNombreAlbum().equalsIgnoreCase(nombreAlbum)) {
                return album.getCanciones();
            }
        }
        return new ArrayList<>();
    }

    public List<Album> buscarAlbumPorAnio(int anioLanzamiento) {
        return listaAlbum.stream()
                .filter(album -> album.getAnioLanzamientoAlbum() == anioLanzamiento)
                .collect(Collectors.toList());
    }

    public void addAlbum(Album album) {
        listaAlbum.add(album);
    }
}