package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt((x*x)+(y*y));
        return res;
    }

    boolean esPar(int n) {
        boolean res = n % 2 == 0;
        return res;
    }
    boolean divideA(int x, int y) {
        boolean res = x % y == 0;
        return res;
    }
    boolean esBisiesto(int n) {
        if (divideA(n, 4)&& !divideA(n, 100)){
            return true;
        }
        else if (divideA(n, 400)){
            return true;
        } else{
            return false;
        }
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1 ; i <= n; i++){
            res = res* i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n == 0){
            return res;
        }
        else {
            res = factorialRecursivo(n-1) * n ;
        }
        return res;
    }

    boolean esPrimo(int n) {
        int counter = 0;
        if (n == 0){
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                counter = counter + 1;
            }
        }
        if (counter == 2){
            return true;
        } else{
            return false;
        }
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0 ; i < numeros.length; i++){
            res = res + numeros[i];
        }
        return res;
    }



    int busqueda(int[] numeros, int buscado) {
        int indice = 0; 
        for (int i = 0; i < numeros.length ; i++){
            if (numeros[i] == buscado){
                indice = i;
            }
        }
        return indice;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++){
            if(esPrimo(numeros[i])){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i = 0; i < numeros.length; i++){
            if(!esPar(numeros[i])){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length()> s2.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        } else {
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i + s2.length() - s1.length())){
                    return false;
                }
            }
        }
        return true;
    }
}
