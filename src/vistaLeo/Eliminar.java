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
    //tabla y scroll pane
    private JTable tablaVuelos;
    private JScrollPane scrollPane;
    //etiquetas
    private JLabel lblCodigo;
    //campos de texto
    private JTextField txtCodigo;
    //botones
    private JButton btnEliminar, btnSalir, btnBuscar;
    //constructor
    public Eliminar(){
        ejecutar();
    }
    //Determina las caracteristicas de la ventana
    public void ejecutar(){
        setSize(950,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        buscar();
    }
    //inicializa los componentes de la ventana
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
           //Crea una tabla en la ventana Eliminar
        tablaVuelos.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tablaVuelos.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //captura el evento de seleccion de un dato en especifico de la tabla
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

    /**
     * Este metodo se conectara con la base de datos y realizara una consulta a la base de datos donde retornara una
     * cadena de tipo String especificando los destinos que dispone el sistema estos datos seran adicionados a un
     * jcomboBox.
     */
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

    /**
     * Este metodo realiza una consulta ala base de datos, luego de realizar la consulta retorna una lista de tipo
     * vuelos luego creamos un modelo para llenar los datos de la tabla a este metodo se el pasara como parametro el
     * destino
     * @param destino
     */
    public void llenarTabla(String destino){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(destino);

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));
    }

    /**
     * Para eliminar un vuelo en especifico de igual forma el sistema mostrara en pantalla el destino donde el usuario
     * debera elegir el vuelo a eliminar, luego de haber elegido el vuelo se pasa como parametro el id del vuelo para
     * realizar la eliminacion del vuelo este proceso se lo realizara mendiante un metodo eliminar vuelo del la clase
     * gestionAerolinea
     */
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
    /**
     * Metodo escucha de eventos que se accionara al monento de realizar una pulsacion internamente se filtran las
     * acciones para diferenciar el boton que se pulso.
     * @param e
     */
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
