package aed;

public class Horario {
    private int _hora;
    private int _minutos;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _minutos = minutos;

    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(hora());
        sbuffer.append(":");
        sbuffer.append(minutos());
        return sbuffer.toString();       
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = (otro == null); // pregunta si es nulo
        boolean cd = otro.getClass() != this.getClass(); // pregunta si es clase distinta
        if (oen || cd) { 
            return false; // este if es para asegurarse que el objeto es de clase Fecha pq sino a continuacion no se 
                          //podria hacer la comparacion
        } 
        else{
            Horario OtroHorario = (Horario) otro; 
            return _minutos == OtroHorario._minutos && _hora == OtroHorario._hora;
            
        }
    }

}
