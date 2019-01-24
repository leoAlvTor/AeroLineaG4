package modelo;


public class ModeloBoletos {
    private String codigo, origen, placaAvion, destino, fechaSalida, horaSalida, fechaLlegada, horaLlegada, precio;

    public ModeloBoletos(){}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getavion() {
        return placaAvion;
    }

    public void setavion(String avion) {
        this.placaAvion = avion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ModeloBoletos{" +
                "codigo='" + codigo + '\'' +
                ", origen='" + origen + '\'' +
                ", placaAvion='" + placaAvion + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", fechaLlegada='" + fechaLlegada + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

    public ModeloBoletos(String codigo, String origen, String avion, String destino, String fechaSalida,
                         String horaSalida, String fechaLlegada, String horaLlegada, String precio) {
        this.codigo = codigo;
        this.origen = origen;
        this.placaAvion = avion;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaLlegada = horaLlegada;
        this.precio = precio;
    }
}
