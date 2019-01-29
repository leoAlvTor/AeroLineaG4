package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.Java2sAutoTextField;
import modelo.ModeloCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;


public class PreFactura extends JFrame {

    GestionAeroLinea gestionAeroLinea;
    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lblImagen;

    private JLabel lblCodigo, lblOrigen, lblDestino, lblFechaSalida, lblHoraSalida, lblAsiento, lblVuelo, lblCosto,
            lblTipoPer, lblPlaca;
    private JComboBox comboAsientos, comboVuelo, comboTipoPersona;

    private JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7; // 5,6,7 son calculos

    public JTextField txtCodigo, txtOrigen, txtDestino, txtFechaSalida, txtHoraSalida, txtCosto, txtPlaca;

    private JButton btn1, btn2, btn3, btnVuelo;

    private ArrayList<String> stringsNombres;
    private Java2sAutoTextField txtAutoComplete;
    private List<ModeloCliente> modeloClienteList;

    public PreFactura(){
        ejecutar();
    }

    public void ejecutar(){
        getContentPane().setBackground(Color.WHITE);
        setSize(750,900);
        setTitle("PreFactura");
        setVisible(true);
        setLayout(null);

        init();
    }

    public void init(){
        JPanel pnl1 = new JPanel(new GridLayout(10, 2));

        lbl1 = new JLabel("Fecha:");
        pnl1.add(lbl1);
        txt1 = new JTextField(40);
        txt1.setText("Aqui debe ir la fecha");
        pnl1.add(lbl1);

        lbl2 = new JLabel("Cedula del cliente:");
        pnl1.add(lbl2);
        txt2 = new JTextField(40);
        pnl1.add(txt2);

        lbl3 = new JLabel("Precio del vuelo:");
        pnl1.add(lbl3);
        txt3 = new JTextField(40);
        pnl1.add(txt3);

        lbl4 = new JLabel("Tipo de pasajero");
        pnl1.add(lbl4);
        txt4 = new JTextField(40);
        pnl1.add(txt4);

        lbl5 = new JLabel("Asientos disponibles:");
        pnl1.add(lbl5);
        comboAsientos = new JComboBox();
        pnl1.add(comboAsientos);

        lbl6 = new JLabel("Origen:");
        pnl1.add(lbl6);
        txt6 = new JTextField(40);
        pnl1.add(txt6);

        lbl7 = new JLabel("Destino:");
        pnl1.add(lbl7)

    }





}
