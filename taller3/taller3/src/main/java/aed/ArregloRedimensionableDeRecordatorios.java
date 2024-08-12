package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio elems[];

    public ArregloRedimensionableDeRecordatorios() {
        elems = new Recordatorio[0];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        elems = new Recordatorio[vector.longitud()];
        for (int i = 0; i < elems.length; i++){
            elems[i] = vector.obtener(i);
        }
    }

    public int longitud() {
        int longitud = elems.length;
        return longitud;
    }

    public void agregarAtras(Recordatorio i) {
       Recordatorio[] nuevoelems = new Recordatorio[(this.elems.length)+ 1];
       if (elems.length == 0){
        nuevoelems[0] = i;
       } else {
        for (int j = 0 ; j < elems.length; j++){
            nuevoelems[j] = elems[j];
        }
        nuevoelems[nuevoelems.length - 1] = i;
       }
       elems = nuevoelems;
    }

    public Recordatorio obtener(int i) {
        return this.elems[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevoelems = new Recordatorio[(this.elems.length) - 1];
        if (elems.length > 0){
         for (int j = 0 ; j < nuevoelems.length; j++){
             nuevoelems[j] = elems[j];
        }
        elems = nuevoelems;
        } 
        
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        elems[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios nuevo = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < elems.length; i++){
            nuevo.agregarAtras(elems[i]);
        }
        return nuevo;

    }

}
