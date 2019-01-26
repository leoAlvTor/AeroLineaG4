package modelo;

public class ModeloEmpleado extends ModeloPersona{
    private String rol, password, pregunta, respuesta;

    public ModeloEmpleado(){}

    public ModeloEmpleado(String rol, String password, String pregunta, String respuesta) {
        this.rol = rol;
        this.password = password;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public ModeloEmpleado(int codigo, String nombre, String apellido, String cedula, String fecha_nac, String rol, String password, String pregunta, String respuesta) {
        super(codigo, nombre, apellido, cedula, fecha_nac);
        this.rol = rol;
        this.password = password;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "ModeloEmpleado{" +
                "rol='" + rol + '\'' +
                ", password='" + password + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                "} " + super.toString();
    }
}
