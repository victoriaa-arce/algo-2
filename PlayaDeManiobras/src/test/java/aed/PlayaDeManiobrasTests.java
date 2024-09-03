package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlayaDeManiobrasTests{
    @Test 
    void PDM(){
        PlayaDeManiobras nuevo = new PlayaDeManiobras(3);
        assertEquals(nuevo.longitud(), 3);
        Tren tren = new Tren();
        Vagon ne = new Vagon("hola");
        tren.agregarVagon(ne);
        assertEquals(nuevo.recibirTren(tren), 0);
    }


    @Test
    void crearvagon(){
        Vagon nuevo = new Vagon("hola");
        assertEquals(nuevo.getVagon(), "hola");
    }
}