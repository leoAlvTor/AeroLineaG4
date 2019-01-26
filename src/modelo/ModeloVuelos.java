package modelo;

public class ModeloVuelos {
    private String id, capacidad, Salida, Llegada, Tipo, Costo, AeropuertoSalida,
            AeropuertoLlegada, Avion, FechaSalida, FechaLLegada;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getSalida() {
        return Salida;
    }

    public void setSalida(String salida) {
        Salida = salida;
    }

    public String getLlegada() {
        return Llegada;
    }

    public void setLlegada(String llegada) {
        Llegada = llegada;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String costo) {
        Costo = costo;
    }

    public String getAeropuertoSalida() {
        return AeropuertoSalida;
    }

    public void setAeropuertoSalida(String aeropuertoSalida) {
        AeropuertoSalida = aeropuertoSalida;
    }

    public String getAeropuertoLlegada() {
        return AeropuertoLlegada;
    }

    public void setAeropuertoLlegada(String aeropuertoLlegada) {
        AeropuertoLlegada = aeropuertoLlegada;
    }

    public String getAvion() {
        return Avion;
    }

    public void setAvion(String avion) {
        Avion = avion;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public String getFechaLLegada() {
        return FechaLLegada;
    }

    public void setFechaLLegada(String fechaLLegada) {
        FechaLLegada = fechaLLegada;
    }

    public ModeloVuelos(){}

    @Override
    public String toString() {
        return "ModeloVuelos{" +
                "id='" + id + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", Salida='" + Salida + '\'' +
                ", Llegada='" + Llegada + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Costo='" + Costo + '\'' +
                ", AeropuertoSalida='" + AeropuertoSalida + '\'' +
                ", AeropuertoLlegada='" + AeropuertoLlegada + '\'' +
                ", Avion='" + Avion + '\'' +
                ", FechaSalida='" + FechaSalida + '\'' +
                ", FechaLLegada='" + FechaLLegada + '\'' +
                '}';
    }
}
