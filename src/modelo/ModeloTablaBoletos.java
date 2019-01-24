package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaBoletos extends AbstractTableModel {
    private String[] columnas = {"codigo", "origen", "aerolinea", "destino", "fechaSalida", "horaSalida",
            "fechaLlegada", "horaLlegada", "Precio"};

    public Class[] tiposColumnas = {String.class,String.class,String.class,String.class,String.class,String.class,
            String.class,String.class,String.class};

    private List<ModeloBoletos> datos;

    public ModeloTablaBoletos(){
        super();
        datos = new ArrayList<ModeloBoletos>();
    }

    public ModeloTablaBoletos(List<ModeloBoletos> datos){
        super();
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    public String getColumnName(int col){
        return columnas[col];
    }

    public Class getColumnClass(int col){
        return tiposColumnas[col];
    }

    public void setValueAt(Object value, int row, int col){
        ModeloBoletos modeloBoletos = (ModeloBoletos) (datos.get(row));

        switch (col){
            case 0:
                modeloBoletos.setCodigo((String) value);
                break;
            case 1:
                modeloBoletos.setOrigen((String) value);
                break;
            case 2:
                modeloBoletos.setavion((String) value);
                break;
            case 3:
                modeloBoletos.setDestino((String) value);
                break;
            case 4:
                modeloBoletos.setFechaSalida((String) value);
                break;
            case 5:
                modeloBoletos.setHoraSalida((String) value);
                break;
            case 6:
                modeloBoletos.setFechaLlegada((String) value);
                break;
            case 7:
                modeloBoletos.setHoraLlegada((String) value);
                break;
            case 8:
                modeloBoletos.setPrecio((String) value);
                break;
            default:
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloBoletos dato = (ModeloBoletos) (datos.get(rowIndex));
        switch (columnIndex){
            case 0:
                return dato.getCodigo();
            case 1:
                return dato.getOrigen();
            case 2:
                return dato.getavion();
            case 3:
                return dato.getDestino();
            case 4:
                return dato.getFechaSalida();
            case 5:
                return dato.getHoraSalida();
            case 6:
                return dato.getFechaLlegada();
            case 7:
                return dato.getHoraLlegada();
            case 8:
                return dato.getPrecio();
            default:
                break;
        }
        return new String();
    }
}
