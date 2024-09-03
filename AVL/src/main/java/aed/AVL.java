package aed;

public class AVL <T>{
    private NodoAVL raiz;
    private int cardinal;
    private class NodoAVL {
        private NodoAVL _hijoizq;
        private NodoAVL _hijoder;
        public int _altura;
        private T _dato;
        public NodoAVL(T x){
            _hijoder = null;
            _hijoizq = null;
            _dato = x;
        }
        public T devolverDato(){
            return _dato;
        }
        public boolean tieneHijos(){
            return (_hijoder!= null && _hijoizq!= null);
        }
        public int altura(NodoAVL n){
            if (n == null){
                return -1;
            }else{
                return _altura;
            }
        }
        public void actualizarAltura(NodoAVL n){
            this._altura = 1 + Math.max(altura(n._hijoder), altura(n._hijoizq));
        }
        public int factorDeBalanceo(NodoAVL n){
            return altura(n._hijoder) - altura(n._hijoizq);
        }
        }
        public AVL(){
            raiz = null;
            cardinal = 0;
        }
        public int cantidad(){
            return cardinal;
        }
        public boolean pertenece(NodoAVL n){
            NodoAVL actual = raiz;
            while (actual.tieneHijos() != false && actual.devolverDato()!= n.devolverDato()){
                if (actual.devolverDato() > n.devolverDato()){
                    
                }
            }
            return true;
        }
    }

