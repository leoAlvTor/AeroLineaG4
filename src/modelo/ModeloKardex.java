package modelo;

public class ModeloKardex {

    private  String Fecha, Detalle, E_cantidad, E_costo_unitario, E_total, S_cantidad,
            S_costo_unitario, S_total, EX_cantidad, EX_costo_unitario, EX_total;

    public ModeloKardex( String Fecha,String Detalle,String E_cantidad,String E_costo_unitario,String E_total,
                         String S_cantidad, String S_costo_unitario, String S_total,String EX_cantidad,
                         String EX_costo_unitario, String EX_total){
        this.Fecha=Fecha;
        this.Detalle=Detalle;
        this.E_cantidad=E_cantidad;
        this.E_costo_unitario=E_costo_unitario;
        this.E_total=E_total;
        this.S_cantidad=S_cantidad;
        this.S_costo_unitario=S_costo_unitario;
        this.S_total=S_total;
        this.EX_cantidad=EX_cantidad;
        this.EX_costo_unitario=EX_costo_unitario;
        this.EX_total=EX_total;
    }


    public ModeloKardex() {
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public String getE_cantidad() {
        return E_cantidad;
    }

    public void setE_cantidad(String e_cantidad) {
        E_cantidad = e_cantidad;
    }

    public String getE_costo_unitario() {
        return E_costo_unitario;
    }

    public void setE_costo_unitario(String e_costo_unitario) {
        E_costo_unitario = e_costo_unitario;
    }

    public String getE_total() {
        return E_total;
    }

    public void setE_total(String e_total) {
        E_total = e_total;
    }

    public String getS_cantidad() {
        return S_cantidad;
    }

    public void setS_cantidad(String s_cantidad) {
        S_cantidad = s_cantidad;
    }

    public String getS_costo_unitario() {
        return S_costo_unitario;
    }

    public void setS_costo_unitario(String s_costo_unitario) {
        S_costo_unitario = s_costo_unitario;
    }

    public String getS_total() {
        return S_total;
    }

    public void setS_total(String s_total) {
        S_total = s_total;
    }

    public String getEX_cantidad() {
        return EX_cantidad;
    }

    public void setEX_cantidad(String EX_cantidad) {
        this.EX_cantidad = EX_cantidad;
    }

    public String getEX_costo_unitario() {
        return EX_costo_unitario;
    }

    public void setEX_costo_unitario(String EX_costo_unitario) {
        this.EX_costo_unitario = EX_costo_unitario;
    }

    public String getEX_total() {
        return EX_total;
    }

    public void setEX_total(String EX_total) {
        this.EX_total = EX_total;
    }


    @Override
    public String toString() {
        return "ModeloKardex{" +
                "Fecha='" + Fecha + '\'' +
                ", Detalle='" + Detalle + '\'' +
                ", E_cantidad='" + E_cantidad + '\'' +
                ", E_costo_unitario='" + E_costo_unitario + '\'' +
                ", E_total='" + E_total + '\'' +
                ", S_cantidad='" + S_cantidad + '\'' +
                ", S_costo_unitario='" + S_costo_unitario + '\'' +
                ", S_total='" + S_total + '\'' +
                ", EX_cantidad='" + EX_cantidad + '\'' +
                ", EX_costo_unitario='" + EX_costo_unitario + '\'' +
                ", EX_total='" + EX_total + '\'' +
                '}';
    }
}
