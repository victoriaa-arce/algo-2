package aed;

public class Fecha {
    private int _mes;
    private int _dia;

    public Fecha(int dia, int mes) {
        _mes = mes;
        _dia = dia;
    }

    public Fecha(Fecha fecha) {
        _mes = fecha.mes();
        _dia = fecha.dia();
    }

    public Integer dia() {
       return _dia ;
    }

    public Integer mes() {
        return _mes;
    }
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(dia().toString());
        sbuffer.append("/");
        sbuffer.append(mes().toString());
        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = (otra == null); // pregunta si es nulo
        boolean cd = otra.getClass() != this.getClass(); // pregunta si es clase distinta
        if (oen || cd) { 
            return false; // este if es para asegurarse que el objeto es de clase Fecha pq sino a continuacion no se 
                          //podria hacer la comparacion
        } 
        else{
            Fecha OtraFecha = (Fecha) otra; 
            return _mes == OtraFecha._mes && _dia == OtraFecha._dia;
        }}

    public void incrementarDia() {
        if (dia() == diasEnMes(mes()) && mes() == 12){
            _dia = 1;
            _mes = 1;
        }else if (dia() == diasEnMes(mes())){
            _dia = 1;
            _mes = _mes +1;
        } else{
            _dia = _dia + 1 ; 
        };
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
