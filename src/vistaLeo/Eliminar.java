package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloTablaKardex;
import modelo.ModeloTablaVuelos;
import modelo.ModeloVuelos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Eliminar extends JFrame implements ActionListener {

    private JTable tablaVuelos;
    private JScrollPane scrollPane;

    private JLabel lblCodigo;

    private JTextField txtCodigo;

    private JButton btnEliminar, btnSalir, btnBuscar;

    public Eliminar(){
        ejecutar();
    }

    public void ejecutar(){
        setSize(950,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        buscar();
    }

    public void init(){
           lblCodigo = new JLabel("Codigo del vuelo: ");
           txtCodigo = new JTextField(10);

           btnEliminar = new JButton("Eliminar vuelo");
           btnEliminar.setActionCommand("eliminar");
           btnEliminar.addActionListener(this);

           btnSalir = new JButton("Salir");
           btnSalir.setActionCommand("salir");
           btnSalir.addActionListener(this);

           btnBuscar = new JButton("Buscar vuelo");
           btnBuscar.setActionCommand("buscar");
           btnBuscar.addActionListener(this);

           JPanel pnlPrincipal = new JPanel(new BorderLayout(0,10));
           JPanel pnlSur = new JPanel(new FlowLayout(1));

           pnlSur.add(lblCodigo);
           pnlSur.add(txtCodigo);
           pnlSur.add(btnEliminar);
           pnlSur.add(btnBuscar);
           pnlSur.add(btnSalir);

           tablaVuelos = new JTable();
           tablaVuelos.setModel(new ModeloTablaKardex());
           scrollPane = new JScrollPane(tablaVuelos);

           pnlPrincipal.add(scrollPane, BorderLayout.CENTER);
           pnlPrincipal.add(pnlSur, BorderLayout.NORTH);

           add(pnlPrincipal);
           setSize(946,600);

           txtCodigo.setEditable(false);

        tablaVuelos.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tablaVuelos.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if(!e.getValueIsAdjusting() && tablaVuelos.getSelectedRow()!= -1) {
                    int fila = 0;
                    fila = tablaVuelos.getSelectedRow();
                    int columna = 0;
                    String datos;
                    datos = (String) tablaVuelos.getValueAt(fila, columna);
                    datos = (String) tablaVuelos.getValueAt(fila, columna);
                    txtCodigo.setText(datos);
                }
            }
        });

    }


    public void buscar(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        lista = gestionAeroLinea.destinos();
        String seleccion;

        String[] destinos = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            destinos[i] = lista.get(i);
        }

        seleccion = (String) JOptionPane.showInputDialog(this,
                "Cual es el destino deseado?",
                "Destinos disponibles",
                JOptionPane.QUESTION_MESSAGE,
                null,
                destinos,
                destinos[0]);

        llenarTabla(seleccion);
    }

    public void llenarTabla(String destino){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(destino);

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));
    }

    public void eliminar(){
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun vuelo");
        }else{
            System.out.println("ALV+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Esta seguro que desea eliminar el vuelo?","Eliminar un vuelo", JOptionPane.YES_NO_OPTION);

            if(opcion == 0){
                GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
                gestionAeroLinea.eliminarVuelos(txtCodigo.getText());
                txtCodigo.setText("");
                btnBuscar.requestFocus();

            }else if(opcion == 1){
                System.out.println("No pasa nada");
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch(comando){
            case "buscar":
                buscar();
                break;
            case "salir":
                MenuAdministrador menuAdministrador = new MenuAdministrador();
                menuAdministrador.setSize(600,500);
                menuAdministrador.ejecutar();
                dispose();
                break;
            case "eliminar":
                eliminar();
        }
    }
}
