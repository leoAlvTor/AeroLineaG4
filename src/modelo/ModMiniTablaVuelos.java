package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModMiniTablaVuelos extends AbstractTableModel {
    private String[] columnas = {"id", "capacidad", "Salida", "Llegada", "Tipo"};


    private Class[] tipos = {String.class, String.class, String.class, String.class, String.class};

    private List<ModeloMiniVuelos> datos;



    public ModMiniTablaVuelos(){
        super();
        datos = new ArrayList<ModeloMiniVuelos>();
    }

    public ModMiniTablaVuelos(List<ModeloMiniVuelos> datoss){
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
        ModeloMiniVuelos modeloVuelos = (ModeloMiniVuelos) (datos.get(row));

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
            default:
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloMiniVuelos dato = (ModeloMiniVuelos) (datos.get(rowIndex));
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
            default:
                break;
        }
        return new String();
    }
}
