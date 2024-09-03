package aed;

import java.util.ArrayList;

public class PlayaDeManiobras {
    private ArrayList<Tren> trenes;
    public PlayaDeManiobras(int cantidad){
        this.trenes = new ArrayList<Tren>(cantidad);
        for (int i = 0; i < cantidad; i++){
            Tren trenVacio = new Tren();
            trenes.add(trenVacio);
        }
    }
    public int longitud(){
        return this.trenes.size();
    }
    public int recibirTren(Tren t){
        int i = 0;
        while(!trenes.get(i).estaVacio()){
            i ++;
        }
        trenes.add(i, t);
        return i;
    }
    public void unirTrenes(int via1, int via2){
        Tren tren1 = trenes.get(via1);
        Tren tren2 = trenes.get(via2);
        tren1.
    }

}
