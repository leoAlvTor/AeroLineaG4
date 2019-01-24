package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaPreFactura extends AbstractTableModel
{
    public String[] columnas = {"Codigo", "Origen", "Destino", "Placa Avion",  "Costo"};

    public Class[] tiposColumnas = {String.class, String.class, String.class, String.class, Double.class};
    private List<ModeloPreFactura> datos;

    public ModeloTablaPreFactura(){
        super();
        datos = new ArrayList<ModeloPreFactura>();
    }

    public ModeloTablaPreFactura(List<ModeloPreFactura> datos){
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
        ModeloPreFactura modeloPreFactura = (ModeloPreFactura) (datos.get(row));

        switch (col){
            case 0:
                modeloPreFactura.setCodigo((String) value);
                break;
            case 1:
                modeloPreFactura.setOrigen((String) value);
                break;
            case 2:
                modeloPreFactura.setDestino((String) value);
                break;
            case 3:
                modeloPreFactura.setPlacaAvion((String) value);
                break;
            case 4:
                modeloPreFactura.setCosto((Double) value);
                break;

                default:
                    break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloPreFactura dato = (ModeloPreFactura) (datos.get(rowIndex));
        switch (columnIndex){
            case 0:
                return dato.getCodigo();
            case 1:
                return dato.getOrigen();
            case 2:
                return dato.getDestino();
            case 3:
                return dato.getPlacaAvion();
            case 4:
                return dato.getCosto();

                default:
                    break;
        }
        return new String();
    }
}
