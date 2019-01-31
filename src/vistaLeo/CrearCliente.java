package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloCliente;
import modelo.ModeloTablaCliente;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class CrearCliente extends JFrame implements ActionListener {

    private JLabel lblNombre, lblCedula, lblDireccion, lblFecha;

    private JTextField txtNombre, txtCedula, txtDireccion, txtFecha;

    private JButton btnCreate, btnRead, btnUpdate, btnDelete, btnSalir, btnLimpiar;

    private JTable tablaClientes;
    private JScrollPane scrollPane;

    private int codigoCliente;

    public CrearCliente(){
        ejecutar();
    }

    public void ejecutar(){
        setSize(250,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();
    }

    public void  init(){
        lblNombre = new JLabel("Nombre completo:");
        lblCedula = new JLabel("Numero de cedula:");
        lblDireccion = new JLabel("Direccion:");
        lblFecha = new JLabel("Fecha de nacimiento:");

        txtCedula = new JTextField(25);
        txtDireccion = new JTextField(25);
        txtNombre = new JTextField(25);
        txtFecha = new JTextField(25);

        btnCreate = new JButton("Crear usuario");
        btnCreate.setActionCommand("create");
        btnCreate.addActionListener(this);

        btnRead = new JButton("Listar");
        btnRead.setActionCommand("read");
        btnRead.addActionListener(this);

        btnUpdate = new JButton("Actualizar");
        btnUpdate.setActionCommand("update");
        btnUpdate.addActionListener(this);

        btnDelete = new JButton("Eliminar");
        btnDelete.setActionCommand("delete");
        btnDelete.addActionListener(this);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setActionCommand("limpiar");
        btnLimpiar.addActionListener(this);

        btnSalir = new JButton("PreFactura");
        btnSalir.setActionCommand("salir");
        btnSalir.addActionListener(this);

        tablaClientes = new JTable();
        tablaClientes.setModel(new ModeloTablaCliente());
        scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setBorder(new TitledBorder("Tabla de usuarios"));

        JPanel pnl1 = new JPanel(new GridLayout(6,2));
        pnl1.add(lblNombre);
        pnl1.add(txtNombre);
        pnl1.add(lblCedula);
        pnl1.add(txtCedula);
        pnl1.add(lblDireccion);
        pnl1.add(txtDireccion);
        pnl1.add(lblFecha);
        pnl1.add(txtFecha);
        pnl1.setBorder(new TitledBorder("Datos del usuario"));

        JPanel pnl2 = new JPanel(new FlowLayout(5));
        pnl2.add(btnCreate);
        pnl2.add(btnRead);
        pnl2.add(btnLimpiar);
        pnl1.add(pnl2);

        JPanel pnl3 = new JPanel(new FlowLayout(5));
        pnl3.add(btnUpdate);
        pnl3.add(btnDelete);
        pnl3.add(btnSalir);
        pnl1.add(pnl3);


        JPanel pnlP = new JPanel(new BorderLayout(10,0));
        pnlP.add(pnl1, BorderLayout.CENTER);
        pnlP.add(scrollPane, BorderLayout.PAGE_END);

        setSize(680,680);

        add(pnlP);

        tablaClientes.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tablaClientes.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if(!e.getValueIsAdjusting() && tablaClientes.getSelectedRow()!= -1) {

                    int fila = 0;
                    fila = tablaClientes.getSelectedRow();
                    int columna = 0;
                    String datos;
                    codigoCliente = Integer.parseInt((String)  tablaClientes.getValueAt(fila, columna));

                    datos = (String) tablaClientes.getValueAt(fila, columna+1);
                    txtNombre.setText(datos);
                    datos = (String) tablaClientes.getValueAt(fila, columna + 2);
                    txtCedula.setText(datos);
                    datos = (String) tablaClientes.getValueAt(fila, columna + 3);
                    txtDireccion.setText(datos);
                    datos = (String) tablaClientes.getValueAt(fila, columna + 4);
                    txtFecha.setText(datos);
                }
            }
        });

    }

    public void listarClientes(){
        List<ModeloCliente> modeloClienteList = new ArrayList<>();
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloClienteList = gestionAeroLinea.clienteList();

        tablaClientes.setModel(new ModeloTablaCliente(modeloClienteList));
    }

    public void limpiar(){
        txtFecha.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCedula.setText("");
    }

    public void crearUsuario(){
        boolean bandera = new GestionAeroLinea().validarFecha(txtFecha.getText());
        if(bandera == false) {
            JOptionPane.showMessageDialog(this, "La fecha ingresada es incorrecta," +
                    " por favor revise el ingreso");
            txtFecha.setText("");
            txtFecha.grabFocus();
            txtFecha.requestFocus();
        }else{
            GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
            gestionAeroLinea.crearCliente(txtNombre.getText(), txtCedula.getText(), txtDireccion.getText(),
                    txtFecha.getText());
        }
    }

    public void borrarCliente(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();

        gestionAeroLinea.borrarCliente(codigoCliente);
    }

    public void acualizarCliente(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();

        if(gestionAeroLinea.validarFecha(txtFecha.getText()) == true){
            gestionAeroLinea.actualizarCliente(codigoCliente, txtNombre.getText(), txtCedula.getText(),
                    txtDireccion.getText(), txtFecha.getText());
        }else{
            JOptionPane.showMessageDialog(this, "La fecha ingresada es invalida");
            txtFecha.requestFocus();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        PreFactura preFactura;
        switch (opcion){
            case "read":
                listarClientes();
                break;
            case "limpiar":
                limpiar();
                break;
            case"salir":
                preFactura = new PreFactura(1);
                dispose();
                break;
            case "create":
                crearUsuario();
                break;
            case "update":
                acualizarCliente();
                break;
            case "delete":
                borrarCliente();
                break;
        }
    }
}
