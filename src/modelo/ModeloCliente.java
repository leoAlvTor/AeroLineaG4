package modelo;

public class ModeloCliente extends ModeloPersona{
    private String direccion;
    private String nombreCompleto;

    public ModeloCliente(){}

    public ModeloCliente(String direccion, String nombreCompleto) {
        this.direccion = direccion;
        this.nombreCompleto = nombreCompleto;
    }

    public ModeloCliente(int codigo, String nombre, String apellido, String cedula, String fecha_nac, String direccion,
                         String nombreCompleto) {
        super(codigo, nombre, apellido, cedula, fecha_nac);
        this.direccion = direccion;
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "ModeloCliente{" +
                "direccion='" + direccion + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
