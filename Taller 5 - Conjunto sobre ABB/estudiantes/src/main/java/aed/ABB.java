package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    private int _altura;
    private int _cardinal;

    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        Nodo (T v, Nodo izquierda, Nodo derecha, Nodo padr){
            valor = v;
            izq = izquierda;
            der = derecha;
            padre = padr;
        }
    }

    public ABB() {
        _raiz = null;
        _altura = 0;
        _cardinal = 0;
    }

    public int cardinal() {
        int cardinal = _cardinal;
        return cardinal;
    }

    public T minimo(){
        Nodo actual = _raiz;
        while(actual.izq != null){
            actual = actual.izq;
        }
        return actual.valor;
    }
    private Nodo _minimo (){
        Nodo actual = _raiz;
        while(actual.izq != null){
            actual = actual.izq;
        }
        return actual;
    }


    public T maximo(){
        Nodo actual = _raiz;
        while(actual.der != null){
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem){
        Nodo n = _raiz;
        Nodo padre = null;
        if (!pertenece(elem)){
        while (n != null){
            padre = n;
            if (elem.compareTo(n.valor) > 0){
                n = n.der;
            }else{
                n = n.izq;
            }
        }
        Nodo nuevoNodo = new Nodo(elem, null, null, padre);
        if (padre == null){
            this._raiz= nuevoNodo;
            _cardinal += 1;
        }else{
            if (elem.compareTo(padre.valor) > 0){
                padre.der = nuevoNodo;
                _cardinal += 1;
            }else if (elem.compareTo(padre.valor) < 0){
                padre.izq= nuevoNodo;
                _cardinal += 1;
            } 
        }
        
    }
}

    public boolean pertenece(T elem){
       Nodo actual =_raiz;
    
       while (actual != null){
        if (elem.compareTo(actual.valor) > 0){
            actual = actual.der;
        } else if (elem.compareTo(actual.valor) < 0){
            actual = actual.izq;
        } else{
            return true;
        }
       }
       return false;
    }

    public void eliminar(T elem){
        Nodo nodoAEliminar = obtener(elem);
        if (nodoAEliminar != null){
        if (nodoAEliminar.der == null && nodoAEliminar.izq == null){
            if (cardinal() == 1){
                _raiz = null;
            }else {
            nodoAEliminar = nodoAEliminar.padre;
            if (nodoAEliminar.valor.compareTo(elem) > 0){
                nodoAEliminar.izq = null;
                
            }else{
                nodoAEliminar.der = null;
                
            }}
        } else if(nodoAEliminar.der != null && nodoAEliminar.izq == null){
            if (nodoAEliminar.padre == null){
                _raiz = nodoAEliminar.der;
                _raiz.padre = null;
            }else if (nodoAEliminar.padre.valor.compareTo(elem) > 0){
                nodoAEliminar.padre.izq = nodoAEliminar.der;
                nodoAEliminar.der.padre = nodoAEliminar.padre;
            }else{
                nodoAEliminar.padre.der = nodoAEliminar.der;
                nodoAEliminar.der.padre = nodoAEliminar.padre;
            }

        }else if(nodoAEliminar.izq != null && nodoAEliminar.der == null){
            if (nodoAEliminar.padre == null){
                _raiz = nodoAEliminar.izq;
                _raiz.padre = null;
            }else if (nodoAEliminar.padre.valor.compareTo(elem) > 0){
                nodoAEliminar.padre.izq = nodoAEliminar.izq;
                nodoAEliminar.izq.padre = nodoAEliminar.padre;
            }else{
                nodoAEliminar.padre.der = nodoAEliminar.izq;
                nodoAEliminar.izq.padre = nodoAEliminar.padre;
            }

        } else if (nodoAEliminar.izq != null && nodoAEliminar.der != null){
            Nodo predeNodo = predecesorNod(nodoAEliminar);
            eliminar(predeNodo.valor);
            nodoAEliminar.valor = predeNodo.valor;
            _cardinal +=1;
        }
    _cardinal -=1;
    }

        
    }
    private Nodo obtener(T elem){
        Nodo actual = _raiz;
        while (elem.compareTo(actual.valor) != 0){
            if (elem.compareTo(actual.valor) > 0){
                actual = actual.der;
            }else{
                actual = actual.izq;
            }
        }
        return actual;
    }
    private Nodo predecesorNod(Nodo eliminar){
        eliminar = eliminar.izq;
        while(eliminar.der != null){
            eliminar = eliminar.der;
        }
        return eliminar;
    }

    public String toString(){
        Nodo actual = _raiz;
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("{");
        sbuffer.append(inOrder(_raiz));
        sbuffer.deleteCharAt(sbuffer.length()-1);
        sbuffer.append("}");
        return sbuffer.toString();
    }
    private String inOrder(Nodo raiz){
        StringBuffer nuevo = new StringBuffer();
        if (raiz != null){
            nuevo.append(inOrder(raiz.izq));
            nuevo.append(raiz.valor);
            nuevo.append(",");
            nuevo.append(inOrder(raiz.der));
        }
        return nuevo.toString();
    }
    

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _siguiente;

        ABB_Iterador(){
            _siguiente = _minimo();
        }
        public boolean haySiguiente() {            
            return _siguiente !=  null;
        }
    
        public T siguiente() {
            Nodo anterior = _siguiente;
            if (_siguiente.valor == maximo()){
                _siguiente = null;
            }else if (_siguiente.der == null){
                _siguiente = _siguiente.padre;
                while(_siguiente.valor.compareTo(anterior.valor) < 0){
                    _siguiente = _siguiente.padre;
                }
            } else {
                _siguiente = _siguiente.der;
                while(_siguiente.izq != null){
                    _siguiente = _siguiente.izq;
                }
            }
            return anterior.valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
