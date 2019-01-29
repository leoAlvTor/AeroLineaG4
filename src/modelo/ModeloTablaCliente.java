package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaCliente extends AbstractTableModel {

    private String[] columnas = {"ID", "Nombre Completo", "Cedula", "Direccion", "Fecha de nacimiento"};


    private Class[] tipos = {String.class, String.class, String.class, String.class, String.class};

    private List<ModeloCliente> datos;

    public ModeloTablaCliente(){
        super();
        datos = new ArrayList<ModeloCliente>();
    }

    public ModeloTablaCliente(List<ModeloCliente> datoss){
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
        ModeloCliente modeloCliente = (ModeloCliente) (datos.get(row));

        switch (col){
            case 0:
                modeloCliente.setId((String) value);
                break;
            case 1:
                modeloCliente.setNombre((String) value);
                break;
            case 2:
                modeloCliente.setCedula((String) value);
                break;
            case 3:
                modeloCliente.setDireccion((String) value);
                break;
            case 4:
                modeloCliente.setFecha_nac((String) value);
                break;

            default:
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloCliente dato = (ModeloCliente) (datos.get(rowIndex));
        switch (columnIndex){
            case 0:
                return dato.getId();
            case 1:
                return dato.getNombre();
            case 2:
                return dato.getCedula();
            case 3:
                return dato.getDireccion();
            case 4:
                return dato.getFecha_nac();
            default:
                break;
        }
        return new String();
    }

}
