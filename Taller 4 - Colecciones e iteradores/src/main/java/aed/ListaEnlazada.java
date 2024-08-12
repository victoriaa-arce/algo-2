package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    int longitud;
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        T valor;
        Nodo anterior;
        Nodo siguiente;
        public Nodo(T v){
            valor = v;
            this.anterior = null;
            this.siguiente = null;
        }
        public void añadirSiguiente(Nodo nuevoSiguiente){
            this.siguiente = nuevoSiguiente;
            nuevoSiguiente.anterior = this;
        }
        public void añadirAnterior (Nodo nuevoAnterior){
            this.anterior = nuevoAnterior;
            nuevoAnterior.siguiente = this; 
        }
        
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
       Nodo nuevo = new Nodo(elem);
       if (primero == null){
        primero = nuevo;
        ultimo = nuevo;
       } else{
        nuevo.siguiente = primero;
        nuevo.anterior = null;
        primero = nuevo;
       }
       longitud += 1;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
        } else{
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo; // necesito que sea asi para poder usar el obtener que usa actual.siguiente
            ultimo = nuevo;
        }
        longitud += 1;
    }

    public T obtener(int i) {
        Nodo actual = primero;
        for(int k = 0; k < i; k++){
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo previo = primero;
        if (i == 0 && longitud == 1){
            primero = null;
            
        } else if(i == 0){
             primero = primero.siguiente;
            
        } else if(i == longitud - 1){
            ultimo = ultimo.anterior;
        } else{
            int k  = 0;
            while (i != k) {
                previo = actual;
                actual = actual.siguiente; 
                k += 1;
                
            }
            previo.siguiente = actual.siguiente;
            actual = actual.siguiente;
            actual.anterior = previo ;
        }

        longitud -= 1;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        int k = 0;
        while (k != indice){
            actual = actual.siguiente;
            k += 1;
        }
         actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<>();
        Nodo actual = this.primero;
        for (int i = 0; i < this.longitud; i++){
            copia.agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
        
        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        for (int k = 0; k < lista.longitud(); k++){
            this.agregarAtras(actual.valor);
            actual = actual.siguiente;         
        }
    }
    
    @Override
    public String toString() {
        StringBuffer sbuffer= new StringBuffer();
        sbuffer.append("[");
        for (int k = 0; k < this.longitud(); k++){
            sbuffer.append(this.obtener(k));
            if (k != this.longitud() - 1){ 
            sbuffer.append(", " );
            }
        }
        sbuffer.append("]");
        return sbuffer.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	Nodo actual;
        Nodo anterior;
        ListaIterador() {
            actual = primero;
        }

        public boolean haySiguiente() {
	        return actual != null;
        }
        
        public boolean hayAnterior() {
	        return anterior != null;
        }

        public T siguiente() {
	        anterior = actual;
            actual = actual.siguiente;
            return anterior.valor;
        }
        

        public T anterior() {
	        actual = anterior;
            anterior = actual.anterior;
            return actual.valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
