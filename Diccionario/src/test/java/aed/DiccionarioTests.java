package aed;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class DiccionarioTests {
    @Test
    void crearDic(){
        Diccionario<Integer, Integer> lista = new Diccionario<>();
        assertEquals(0, lista.longitud());
    }
    @Test
    void existeClave(){
        Diccionario<Integer, Integer> lista = new Diccionario<>();
        lista.añadirClave(2, 8);
        assertTrue(lista.esta(2));
        assertEquals(1, lista.longitud());
    }
    @Test 
    void noExiste(){
        Diccionario<Integer, Integer> lista = new Diccionario<>();
        lista.añadirClave(2, 8);
        assertFalse(lista.esta(1));
    }
    @Test 
    void cambiarClave(){
        Diccionario<Integer, Integer> lista = new Diccionario<>();
        lista.añadirClave(2, 8);
        assertTrue(lista.esta(2));

        lista.añadirClave(2, 4);
        assertEquals(1, lista.longitud());
        assertEquals(lista.obtenerValor(2), 4);
    }
    @Test
    void añadirMuchasClaves(){
        Diccionario<Integer, Integer> lista = new Diccionario<>();
        lista.añadirClave(2, 8);
        lista.añadirClave(4, 3);
        lista.añadirClave(8, 2);
        assertEquals(3, lista.longitud());
        assertTrue(lista.esta(2));
        assertTrue(lista.esta(4));
        assertTrue(lista.esta(8));
    }
}
