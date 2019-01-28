package modelo;

public class ModeloMiniVuelos {
    private String id, capacidad, salida, llegada, tipo;

    public ModeloMiniVuelos(){};

    public ModeloMiniVuelos(String id, String capacidad, String salida, String llegada, String tipo) {
        this.id = id;
        this.capacidad = capacidad;
        this.salida = salida;
        this.llegada = llegada;
        this.tipo = tipo;
    }

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
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ModeloMiniVuelos{" +
                "id='" + id + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", salida='" + salida + '\'' +
                ", llegada='" + llegada + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
