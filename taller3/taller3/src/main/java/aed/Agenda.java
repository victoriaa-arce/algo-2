package aed;

public class Agenda {
    Fecha _fecha;
    ArregloRedimensionableDeRecordatorios _recordatorios;
    public Agenda(Fecha fechaActual) {
        _fecha = new Fecha(fechaActual);
        _recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        _recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(_fecha.toString());
        sbuffer.append("\n");
        sbuffer.append("=====");
        sbuffer.append("\n");
        for (int i = 0; i <_recordatorios.longitud(); i++){
            if (_recordatorios.obtener(i).fecha().equals(_fecha) ){
            sbuffer.append(_recordatorios.obtener(i).toString());
            sbuffer.append("\n"); 
        }
        }
        return sbuffer.toString();



    }

    public void incrementarDia() {
        _fecha.incrementarDia();

    }

    public Fecha fechaActual() {
        Fecha fecha = new Fecha(_fecha);
        return fecha;
    }

}
