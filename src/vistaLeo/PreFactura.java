package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class PreFactura extends JFrame implements  ActionListener{

    GestionAeroLinea gestionAeroLinea;
    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11;

    private JComboBox comboAsientos, comboTipoPersona;

    private JTextField txtFecha, txtPrecio, txtOrigen, txtDestino, txtFechaS, txtFechaL, txt10, txt11;

    private JButton btnCrearFactura, btnCancelar, btnCerrar, btnVueloDestino;

    private JTable tablaVuelos;
    private JScrollPane scrollPane;

    int codigoVuelo;
    String fechaNac;
    int tipoPasajero;

    private ArrayList<String> stringsCedulas;
    private Java2sAutoTextField txtAutoComplete;
    private List<ModeloCliente> modeloClienteList;

    public PreFactura(){
        ejecutar();
    }

    public void ejecutar(){
        getContentPane().setBackground(Color.WHITE);
        setSize(799,899);
        setTitle("PreFactura");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        cargarCedulas();
        init();
        setSize(800,900);
    }

    public void init(){
        JPanel pnl1 = new JPanel(new GridLayout(10, 2));


        lbl1 = new JLabel("Fecha:");
        pnl1.add(lbl1);
        txtFecha = new JTextField(40);
        pnl1.add(txtFecha);

        lbl2 = new JLabel("Cedula del cliente:");
        pnl1.add(lbl2);
        txtAutoComplete = new Java2sAutoTextField(stringsCedulas);
        txtAutoComplete.setStrict(false);
        txtAutoComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosUsuario(txtAutoComplete.getText());
                btnVueloDestino.requestFocus();
                gestionAeroLinea = new GestionAeroLinea();
                tipoPasajero = gestionAeroLinea.tipoPasajero(txtFecha.getText(), fechaNac);
                determinarPasajero(tipoPasajero);
            }
        });
        pnl1.add(txtAutoComplete);


        lbl3 = new JLabel("Precio del vuelo:");
        pnl1.add(lbl3);
        txtPrecio = new JTextField(40);
        pnl1.add(txtPrecio);

        lbl4 = new JLabel("Tipo de pasajero");
        pnl1.add(lbl4);
        comboTipoPersona = new JComboBox();
        pnl1.add(comboTipoPersona);
        cargarTiposP();

        lbl5 = new JLabel("Asientos disponibles:");
        pnl1.add(lbl5);
        comboAsientos = new JComboBox();
        pnl1.add(comboAsientos);

        lbl6 = new JLabel("Origen:");
        pnl1.add(lbl6);
        txtOrigen = new JTextField(40);
        pnl1.add(txtOrigen);

        lbl7 = new JLabel("Destino:");
        pnl1.add(lbl7);
        txtDestino = new JTextField(40);
        pnl1.add(txtDestino);

        lbl8 = new JLabel("Fecha salida:");
        pnl1.add(lbl8);
        txtFechaS = new JTextField(40);
        pnl1.add(txtFechaS);

        lbl9 = new JLabel("Fecha llegada");
        pnl1.add(lbl9);
        txtFechaL = new JTextField(40);
        pnl1.add(txtFechaL);

        pnl1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createRaisedBevelBorder()));

        JPanel pnlPrincipal = new JPanel(new BorderLayout(0,10));

        tablaVuelos = new JTable();
        tablaVuelos.setModel(new ModeloTablaVuelos());
        scrollPane = new JScrollPane(tablaVuelos);

        pnlPrincipal.add(pnl1, BorderLayout.PAGE_START);
        pnlPrincipal.add(scrollPane, BorderLayout.CENTER);

        JPanel pnlBotones = new JPanel();

        btnCrearFactura = new JButton("Crear factura");
        btnCrearFactura.setActionCommand("crear");
        btnCrearFactura.addActionListener(this);
        pnlBotones.add(btnCrearFactura);

        btnVueloDestino = new JButton("Buscar vuelos por destino");
        btnVueloDestino.setActionCommand("buscar");
        btnVueloDestino.addActionListener(this);
        pnlBotones.add(btnVueloDestino);

        btnCancelar = new JButton("Cancelar compra de boleto");
        btnCancelar.setActionCommand("cancelar");
        btnCancelar.addActionListener(this);
        pnlBotones.add(btnCancelar);

        btnCerrar = new JButton("Regresar al menu principal");
        btnCerrar.setActionCommand("cerrar");
        btnCerrar.addActionListener(this);
        pnlBotones.add(btnCerrar);

        pnlPrincipal.add(pnlBotones, BorderLayout.SOUTH);

        add(pnlPrincipal);

        obtenerFecha();

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                txtAutoComplete.setText("");
            }
        });


    }

    public void cargarTiposP(){
        comboTipoPersona.addItem("Seleccione un campo");
        comboTipoPersona.addItem("Bebe");
        comboTipoPersona.addItem("Adulto Mayor");
        comboTipoPersona.addItem("Joven < 18");
        comboTipoPersona.addItem("Adulto");
        comboTipoPersona.addItem("Discapacitado");

    }

    public void cargarCedulas(){
        modeloClienteList = new ArrayList<>();
        stringsCedulas = new ArrayList<>();

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloClienteList = gestionAeroLinea.clienteList();

        for (int i = 0; i < modeloClienteList.size(); i++)
            stringsCedulas.add(modeloClienteList.get(i).getCedula());
    }

    public void cargarDatosUsuario(String cedula){
        boolean bandera = false;
        for (int i = 0; i < modeloClienteList.size(); i++)
            if(modeloClienteList.get(i).getCedula().equals(cedula)) {
                bandera = true;
                fechaNac = modeloClienteList.get(i).getFecha_nac();
            }
            CrearCliente crearCliente;

        if(bandera == false){
            int i = JOptionPane.showConfirmDialog(this, "Al parecer la cedula ingresada no existe,\n" +
                    "Desea crear un nuevo usuario?", "Usuario inexistente",
                    JOptionPane.YES_NO_OPTION );
            if(i == 0 ) {
                crearCliente = new CrearCliente();
                dispose();
            }else
                JOptionPane.showMessageDialog(this, "No se creara el usuario");
        }
    }

    public void obtenerFecha(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String a = String.valueOf(calendar.get(Calendar.YEAR));
        String b = String.valueOf(calendar.get(Calendar.MONTH)+1);
        if(Integer.parseInt(b) < 10)
            b = "0"+b;
        String c = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        String fecha = c + "/"+ b + "/" + a;
        txtFecha.setText(fecha);
        txtAutoComplete.requestFocus();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String opciones = e.getActionCommand();

        switch (opciones){
            case "crear":
                System.out.println("Aqui deberia ir mi metodo que creara cosas cheveres :v");
                break;
            case "buscar":
                buscar();
                break;
            case "cancelar":
                cancelar();
                break;
            case "cerrar":
                cerrar();
                break;
        }
    }

    public void buscar(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        lista = gestionAeroLinea.destinos();


        String[] destinos = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            destinos[i] = lista.get(i);
        }

        String seleccion;

        seleccion = (String) JOptionPane.showInputDialog(this,
                "Cual es el destino deseado?",
                "Destinos disponibles",
                JOptionPane.QUESTION_MESSAGE,
                null,
                destinos,
                destinos[0]);

        llenarTabla(seleccion);

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
                    String datos="";
                    datos = (String) tablaVuelos.getValueAt(fila, columna + 8);
                    codigoVuelo = Integer.parseInt(datos);
                    datos = (String) tablaVuelos.getValueAt(fila, columna + 5);
                    txtPrecio.setText(datos);
                    datos = (String) tablaVuelos.getValueAt(fila, columna + 6);
                    txtOrigen.setText(datos);
                    datos = (String) tablaVuelos.getValueAt(fila, columna + 7);
                    txtDestino.setText(datos);
                    datos = (String) tablaVuelos.getValueAt(fila, columna + 9);
                    txtFechaS.setText(datos);
                    datos = (String) tablaVuelos.getValueAt(fila, columna + 10);
                    txtFechaL.setText(datos);
                    cargarAsientos();
                }
            }
        });

    }

    public void llenarTabla(String destino){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(destino);

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));


    }

    public void cerrar(){
        MenuAgente menu = new MenuAgente();
        menu.setSize(500,500);
        menu.ejectuar();
        dispose();
    }

    public void cancelar(){
        txtAutoComplete.setText("");
        txtPrecio.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtFechaS.setText("");
        txtFechaL.setText("");
    }

    public void cargarAsientos(){

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> asientosDisponibles = gestionAeroLinea.asientosDisponibles(codigoVuelo);
        comboAsientos.removeAllItems();
        for (int i = 0; i < asientosDisponibles.size(); i++) {
            comboAsientos.addItem(asientosDisponibles.get(i));
        }
    }

    public void determinarPasajero(int tipo){
        if(tipo == 1)
            comboTipoPersona.setSelectedIndex(1);
        else if (tipo == 2)
            comboTipoPersona.setSelectedIndex(2);
        else if (tipo == 3)
            comboTipoPersona.setSelectedIndex(3);
        else if (tipo == 4)
            comboTipoPersona.setSelectedIndex(4);
        else
            comboTipoPersona.setSelectedIndex(5);
    }
}