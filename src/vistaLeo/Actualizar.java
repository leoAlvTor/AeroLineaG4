package vistaLeo;

import modelo.ModMiniTablaVuelos;
import modelo.ModeloMiniVuelos;
import modelo.ModeloTablaVuelos;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Actualizar extends JFrame {

    private JButton btnBuscar, btnActualizar, btnCancelar, btnSalir;

    private JLabel lblId, lblCapacidad, lblSalida, lblLlegada, lblTipo, lblCosto, lblAeroSalida, lblAeroLlegada,
    lblAvion, lblFechaSalida, lblFechaLlegada;

    private JTextField txtId, txtCapacidad, txtSalida, txtLlegada, txtTipo, txtCosto,
    txtAvion, txtFechaSalida, txtFechaLlegada;

    private JComboBox comboAeroSalida, comboAeroLlegada;

    private JTable tableMiniVuelos;
    private JScrollPane scrollPane;

    public Actualizar(){
        ejecutar();
    }

    public void ejecutar(){
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
        // Inicializar variblaes
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
        btnActualizar = new JButton("Actualizar datos");
        btnCancelar = new JButton("Cancelar actualizacion");
        btnSalir = new JButton("Regresar al menu");

    }

    public void addLayouts(){
        JPanel pnlLbl = new JPanel();
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

        tableMiniVuelos = new JTable();
        tableMiniVuelos.setModel(new ModMiniTablaVuelos());
        scrollPane = new JScrollPane(tableMiniVuelos);
        scrollPane.setBorder(border1);

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
}
