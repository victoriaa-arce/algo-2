package aed;

public class Recordatorio {
    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _mensaje = mensaje;
        _fecha = new Fecha(fecha);
        _horario = horario;
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        Fecha fecha = new Fecha(_fecha);
        return fecha;
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(mensaje().toString());
        sbuffer.append(" @ ");
        sbuffer.append(fecha().toString());
        sbuffer.append(" ");
        sbuffer.append(horario().toString());
        return sbuffer.toString(); 
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = (otro == null);
        boolean cd = otro.getClass() != this.getClass();
        if (oen || cd){
            return false;
        } else {
            Recordatorio OtroRecordatorio = (Recordatorio) otro;
            return _mensaje.equals(OtroRecordatorio.mensaje())  && _horario.equals(OtroRecordatorio.horario())&& _fecha.equals(OtroRecordatorio.fecha());
        }
    }

}
