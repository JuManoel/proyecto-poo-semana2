package main.java.edu.prog2.models;

public enum EstadoPQR {

    ANALIZADO("En análisis"),
    ASIGNADO("Asignado para estudio"),
    CERRADO("Cerrado"),
    RADICADO("Radicado"),
    RECIBIDO("Recibido"),
    RESPONDIDO("Respondido"),
    TRASLADADO("Trasladado");

    private String value;
    private EstadoPQR(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoPQR getEnum(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (EstadoPQR v : values()) {
            if (value.equalsIgnoreCase(v.value)) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return value;
    }

}