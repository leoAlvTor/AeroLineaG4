package modelo;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaKardex extends AbstractTableModel {
    private String[] columnas = {"Fecha", "Detalle", "E.cantidad", "E.costo unitario", "E.total", "S.cantidad",
            "S.costo unitario", "S.total", "EX.cantidad", "EX.costo unitario", "EX.total"};


    private Class[] tipos = {String.class, String.class, String.class, String.class, String.class, String.class,
            String.class, String.class, String.class, String.class, String.class};

    private List<ModeloKardex> datos;



    public ModeloTablaKardex(){


        super();
        datos = new ArrayList<ModeloKardex>();
    }

    public ModeloTablaKardex(List<ModeloKardex> datoss){
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
        ModeloKardex modeloKardex = (ModeloKardex) (datos.get(row));

        switch (col){
            case 0:
                modeloKardex.setFecha((String) value);
                break;
            case 1:
                modeloKardex.setDetalle((String) value);
                break;
            case 2:
                modeloKardex.setE_cantidad((String) value);
                break;
            case 3:
                modeloKardex.setE_costo_unitario((String) value);
                break;
            case 4:
                modeloKardex.setE_total((String) value);
                break;
            case 5:
                modeloKardex.setS_cantidad((String) value);
                break;
            case 6:
                modeloKardex.setS_costo_unitario((String) value);
                break;
            case 7:
                modeloKardex.setS_total((String) value);
                break;
            case 8:
                modeloKardex.setEX_cantidad((String) value);
                break;
            case 9:
                modeloKardex.setEX_costo_unitario((String) value);
                break;
            case 10:
                modeloKardex.setEX_total((String) value);
                break;

            default:
                break;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloKardex dato = (ModeloKardex) (datos.get(rowIndex));
        switch (columnIndex){
            case 0:
                return dato.getFecha();
            case 1:
                return dato.getDetalle();
            case 2:
                return dato.getE_cantidad();
            case 3:
                return dato.getE_costo_unitario();
            case 4:
                return dato.getE_total();
            case 5:
                return dato.getS_cantidad();
            case 6:
                return dato.getS_costo_unitario();
            case 7:
                return dato.getS_total();
            case 8:
                return dato.getEX_cantidad();
            case 9:
                return dato.getEX_costo_unitario();
            case 10:
                return dato.getEX_total();
            default:
                break;
        }
        return new String();
    }

}
