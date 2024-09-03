package aed;

public class Diccionario<K, V> {
    public NodoDic primero;
    public NodoDic ultimo;
    public int longitud;
    private class NodoDic {
        public K clave ;
        public V val;
        public NodoDic sig;
        public NodoDic(K key, V valor){
            clave = key;
            val = valor;
            sig = null;
        }
        public void añadirSiguiente (NodoDic n ){
            this.sig = n;
        }
    }
    public Diccionario(){
        primero = null;
        ultimo = null;
        longitud = 0;

    }
    public int longitud(){
        return longitud;
    }
    public void añadirClave(K key, V valor){
        if (longitud == 0){
            NodoDic nuevo = new NodoDic(key, valor);
            primero = nuevo;
            ultimo = nuevo;
            this.longitud += 1;
        }else if (!this.esta(key)){
            NodoDic nuevo = new NodoDic(key, valor);
            ultimo.añadirSiguiente(nuevo);
            ultimo = nuevo;
            this.longitud += 1;
        } else {
            NodoDic nuevo = obtener(key);
            nuevo.val = valor;
        }
    }
    public boolean esta(K key){
        NodoDic actual = primero;
        int j = 0;
        while (j <this.longitud && actual.clave != key){
            actual = actual.sig;
            j++;
        }
        if (j == longitud){
            return false;
        }else {
            return true;
        }
    }
    public NodoDic obtener(K key){
        NodoDic actual = primero;
        int j = 0;
        while (j <longitud && actual.clave != key){
            actual = actual.sig;
            j++;
        }
        return actual;
    }
    public V obtenerValor(K key){
        NodoDic actual = primero;
        int j = 0;
        while (j <longitud && actual.clave != key){
            actual = actual.sig;
            j++;
        }
        return actual.val;
    }

    
}
