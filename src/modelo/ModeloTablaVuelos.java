package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaVuelos extends AbstractTableModel {
    private String[] columnas = {"id", "capacidad", "Salida", "Llegada", "Tipo", "Costo", "AeropuertoSalida",
            "AeropuertoLlegada", "Avion", "FechaSalida", "FechaLLegada"};


    private Class[] tipos = {String.class, String.class, String.class, String.class, String.class, String.class,
            String.class, String.class, String.class, String.class, String.class};

    private List<ModeloVuelos> datos;



    public ModeloTablaVuelos(){


        super();
        datos = new ArrayList<ModeloVuelos>();
    }

    public ModeloTablaVuelos(List<ModeloVuelos> datoss){
        super();
        this.datos = datoss;
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
        return tipos[col];
    }

    public void setValueAt(Object value, int row, int col){
        ModeloVuelos modeloVuelos = (ModeloVuelos) (datos.get(row));

        switch (col){
            case 0:
                modeloVuelos.setId((String) value);
                break;
            case 1:
                modeloVuelos.setCapacidad((String) value);
                break;
            case 2:
                modeloVuelos.setSalida((String) value);
                break;
            case 3:
                modeloVuelos.setLlegada((String) value);
                break;
            case 4:
                modeloVuelos.setTipo((String) value);
                break;
            case 5:
                modeloVuelos.setCosto((String) value);
                break;
            case 6:
                modeloVuelos.setAeropuertoSalida((String) value);
                break;
            case 7:
                modeloVuelos.setAeropuertoLlegada((String) value);
                break;
            case 8:
                modeloVuelos.setAvion((String) value);
                break;
            case 9:
                modeloVuelos.setFechaSalida((String) value);
                break;
            case 10:
                modeloVuelos.setFechaLLegada((String) value);
                break;

            default:
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloVuelos dato = (ModeloVuelos) (datos.get(rowIndex));
        switch (columnIndex){
            case 0:
                return dato.getId();
            case 1:
                return dato.getCapacidad();
            case 2:
                return dato.getSalida();
            case 3:
                return dato.getLlegada();
            case 4:
                return dato.getTipo();
            case 5:
                return dato.getCosto();
            case 6:
                return dato.getAeropuertoSalida();
            case 7:
                return dato.getAeropuertoLlegada();
            case 8:
                return dato.getAvion();
            case 9:
                return dato.getFechaSalida();
            case 10:
                return dato.getFechaLLegada();
            default:
                break;
        }
        return new String();
    }
}
