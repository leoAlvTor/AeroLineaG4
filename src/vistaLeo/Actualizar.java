package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloTablaKardex;
import modelo.ModeloTablaVuelos;
import modelo.ModeloVuelos;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Actualizar extends JFrame implements ActionListener{
    //botones
    private JButton btnBuscar, btnActualizar, btnCancelar, btnSalir;
    //etiquetas
    private JLabel lblId, lblCapacidad, lblSalida, lblLlegada, lblTipo, lblCosto, lblAeroSalida, lblAeroLlegada,
    lblAvion, lblFechaSalida, lblFechaLlegada;
    //campos de texto
    private JTextField txtId, txtCapacidad, txtSalida, txtLlegada, txtTipo, txtCosto,
    txtAvion, txtFechaSalida, txtFechaLlegada;
    //cuadros de opciones comboBox
    private JComboBox comboAeroSalida, comboAeroLlegada;
    //tabla donde se cargaran los vuelos
    private JTable tableMiniVuelos;
    //Scroll permitira visualizar los datos que no quepan en la tabla
    private JScrollPane scrollPane;

    public Actualizar(){
        ejecutar();
    }

    public void ejecutar(){
        //descripcion de la ventana
        setTitle("Actualizar vuelos");
        setSize(1100,900);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();
        addLayouts();
        pack();
        repaint();
    }

    public void init(){
        // Inicializar variblaes ,
        lblId = new JLabel("Id:");
        txtId = new JTextField(45);
        txtId.setEditable(false);

        lblCapacidad = new JLabel("Capacidad");
        txtCapacidad = new JTextField(45);

        lblSalida = new JLabel("Hora Salida:");
        txtSalida = new JTextField(45);

        lblLlegada = new JLabel("Hora Llegada:");
        txtLlegada = new JTextField(45);

        lblTipo = new JLabel("Tipo:");
        txtTipo = new JTextField(45);

        lblCosto = new JLabel("Costo:");
        txtCosto = new JTextField(45);

        lblAeroSalida = new JLabel("Aeropuerto Salida:");
        comboAeroSalida = new JComboBox();

        lblAeroLlegada = new JLabel("Aeropuerto Llegada:");
        comboAeroLlegada = new JComboBox();

        lblAvion = new JLabel("Avion:");
        txtAvion = new JTextField(45);

        lblFechaSalida = new JLabel("Fecha Salida (d/m/y):");
        txtFechaSalida = new JTextField(45);

        lblFechaLlegada = new JLabel("Fecha Llegada (d/m/y):");
        txtFechaLlegada = new JTextField(45);

        // Botones
        btnBuscar = new JButton("Buscar por destino");
        btnBuscar.setActionCommand("buscar");
        btnBuscar.addActionListener(this);

        btnActualizar = new JButton("Actualizar datos");
        btnActualizar.setActionCommand("actualizar");
        btnActualizar.addActionListener(this);

        btnCancelar = new JButton("Cancelar actualizacion");
        btnCancelar.setActionCommand("cancelar");
        btnCancelar.addActionListener(this);

        btnSalir = new JButton("Regresar al menu");
        btnSalir.setActionCommand("salir");
        btnSalir.addActionListener(this);

        cargarDestinos();
    }

    public void addLayouts(){
        JPanel pnlLbl = new JPanel();
        //en caso de agregar mas campos de texto solamente editar el numero de cols del gridLayout
        pnlLbl.setLayout(new GridLayout(11,2));

        pnlLbl.add(lblId);
        pnlLbl.add(txtId);
        pnlLbl.add(lblCapacidad);
        pnlLbl.add(txtCapacidad);
        pnlLbl.add(lblSalida);
        pnlLbl.add(txtSalida);
        pnlLbl.add(lblLlegada);
        pnlLbl.add(txtLlegada);
        pnlLbl.add(lblTipo);
        pnlLbl.add(txtTipo);
        pnlLbl.add(lblCosto);
        pnlLbl.add(txtCosto);
        pnlLbl.add(lblAeroSalida);
        pnlLbl.add(comboAeroSalida);
        pnlLbl.add(lblAeroLlegada);
        pnlLbl.add(comboAeroLlegada);
        pnlLbl.add(lblAvion);
        pnlLbl.add(txtAvion);
        pnlLbl.add(lblFechaSalida);
        pnlLbl.add(txtFechaSalida);
        pnlLbl.add(lblFechaLlegada);
        pnlLbl.add(txtFechaLlegada);
        Border border, border1;
        border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        border1 = BorderFactory.createCompoundBorder(border,border);
        pnlLbl.setBorder(border1);
        //creacion de la tabla
        tableMiniVuelos = new JTable();
        tableMiniVuelos.setModel(new ModeloTablaKardex());
        scrollPane = new JScrollPane(tableMiniVuelos);
        scrollPane.setBorder(border1);
        //Panel Principal
        JPanel pnlPrincipal = new JPanel(new GridLayout(1,2,20,200));
        pnlPrincipal.add(pnlLbl);
        pnlPrincipal.add(scrollPane);
        pnlPrincipal.setBorder(border1);

        JPanel pnlPrueba = new JPanel(new BorderLayout());
        pnlPrueba.add(pnlPrincipal, BorderLayout.CENTER);

        JPanel pnlBotones = new JPanel(new FlowLayout());
        pnlBotones.add(btnBuscar);
        pnlBotones.add(btnActualizar);
        pnlBotones.add(btnCancelar);
        pnlBotones.add(btnSalir);

        pnlPrueba.add(pnlBotones, BorderLayout.SOUTH);

        add(pnlPrueba);

    }

    /**
     * Este metodo entra en ejecucion en antes de aparecen esta ventana la cual se
     * conectara con la clase gestion y ralizara una consulta sobre los vuelos y los mostrara en ventana para
     * que el usuario pueda elejir la descripcion del vuelo mediante el destino que se especifiquen
     */
    public void buscarVuelos(){
        String seleccion;
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        lista = gestionAeroLinea.destinos();

        String[] destinos = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++)
            destinos[i] = lista.get(i);

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
     * Metodo que camtura los datos que esten en ese monento en los campos de texto de la interfaz y luego hace uso del
     * metodo de Actializar vuelos de la clase gestion aerolinea
     */
    public void actualizarVuelos(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        String id = txtId.getText();
        String capacidad = txtCapacidad.getText();
        String hSalida = txtSalida.getText();
        String hLlegada = txtLlegada.getText();
        String tipo = txtTipo.getText();
        String costo = txtCosto.getText();
        String areoSalida = (String) comboAeroSalida.getSelectedItem();
        String aeroLlegada = (String) comboAeroLlegada.getSelectedItem();
        String avion = txtAvion.getText();
        String fechaSalida = txtFechaSalida.getText();
        String fechaLlegada = txtFechaLlegada.getText();

        gestionAeroLinea.actualizarVuelos(id, capacidad, hSalida, hLlegada, tipo, costo, areoSalida, aeroLlegada,
                avion, fechaSalida, fechaLlegada);


    }

    /**
     * Este metodo se le pasa como parametro el destino del cual se desea conocer los vuelos disponibles hara uso del
     * metodo listarVuelosPorDestino donde obtiene los vuelos correspondientes en una lista de tipo modelo vuelos luego
     * esta lista de modelos es pasada como parametro a la clase modelo tabla de esa forma se llena la tabla con la
     * informacion requerida
     * @param seleccion
     */
    public void llenarTabla(String seleccion){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(seleccion);

        tableMiniVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));

        tableMiniVuelos.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tableMiniVuelos.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if(!e.getValueIsAdjusting() && tableMiniVuelos.getSelectedRow()!= -1) {

                    int fila = 0;
                    fila = tableMiniVuelos.getSelectedRow();
                    int columna = 0;
                    String datos;
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna);
                    System.out.println(datos);

                    datos = (String) tableMiniVuelos.getValueAt(fila, columna);
                    txtId.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 1);
                    txtCapacidad.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 2);
                    txtSalida.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 3);
                    txtLlegada.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 4);
                    txtTipo.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 5);
                    txtCosto.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 6);
                    comboAeroSalida.setSelectedIndex(Integer.parseInt(datos));
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 7);
                    comboAeroLlegada.setSelectedIndex(Integer.parseInt(datos));
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 8);
                    txtAvion.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 9);
                    txtFechaSalida.setText(datos);
                    datos = (String) tableMiniVuelos.getValueAt(fila, columna + 10);
                    txtFechaLlegada.setText(datos);
                }
            }
        });

    }

    public void cargarDestinos(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> listaDestinos = new ArrayList<>();
        listaDestinos = gestionAeroLinea.destinos();


        for (int i = 0; i < listaDestinos.size(); i++) {
            comboAeroSalida.addItem(listaDestinos.get(i));
            comboAeroLlegada.addItem(listaDestinos.get(i));
        }
    }

    public void cancelar(){
        txtFechaLlegada.setText("");
        txtFechaSalida.setText("");
        txtAvion.setText("");
        txtCosto.setText("");
        txtTipo.setText("");
        txtLlegada.setText("");
        txtSalida.setText("");
        txtCapacidad.setText("");
        txtId.setText("");
    }

    public void vtnAdministrador(){
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        menuAdministrador.setSize(600,500);
        menuAdministrador.ejecutar();
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();

        switch (accion){
            case "buscar":
                buscarVuelos();
                break;
            case "actualizar":
                actualizarVuelos();
                break;
            case "cancelar":
                cancelar();
                break;
            case "salir":
                vtnAdministrador();
                break;
                default:
                    break;
        }


    }
}
