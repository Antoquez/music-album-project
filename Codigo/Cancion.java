package Codigo;

class Cancion {
    private String tituloCancion;
    private int duracionCancion; // duración en segundos

    public Cancion(String tituloCancion, int duracionCancion) {
        this.tituloCancion = tituloCancion;
        this.duracionCancion = duracionCancion;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public int getDuracionCancion() {
        return duracionCancion;
    }
}
