package aed;

public class Tren {
    public ListaEnlazada<Vagon> tren;
    public int longitud(){
        return tren.longitud();
    }
    public Tren(){
        tren = new ListaEnlazada<>();
    }
    public void agregarVagon(Vagon v){
        tren.agregarAtras(v);
    }
    public boolean estaVacio(){
        if (this.longitud() == 0){
            return true;
        } else {
            return false;
        }
    }
}
