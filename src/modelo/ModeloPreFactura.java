package modelo;

public class ModeloPreFactura {
    private String Codigo;
    private String Origen;
    private String Destino;
    private String placaAvion;
    private Double costo;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getPlacaAvion() {
        return placaAvion;
    }

    public void setPlacaAvion(String placaAvion) {
        this.placaAvion = placaAvion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public ModeloPreFactura(){}

    public ModeloPreFactura(String codigo, String origen, String destino, String placaAvion, Double costo) {
        Codigo = codigo;
        Origen = origen;
        Destino = destino;
        this.placaAvion = placaAvion;
        this.costo = costo;
    }

}
