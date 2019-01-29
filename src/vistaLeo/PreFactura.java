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

    private JTextField txt2, txt3, txt4, txt5, txt6, txt7;

    private JTextField txtCodigo, txtOrigen, txtDestino, txtFechaSalida, txtHoraSalida, txtCosto, txtPlaca;

    private JButton btn1, btn2, btn3, btnVuelo;

    private ArrayList<String> stringsNombres;
    private Java2sAutoTextField txt1;
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
        //crearTabla();
        
        lblImagen = new JLabel();
        lblImagen.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/avionsito.jpg")));
        lblImagen.setSize(128,128);
        lblImagen.setLocation(10,10);
        add(lblImagen);

        lbl1 = new JLabel("Señor(a): ");
        lbl1.setSize(lbl1.getPreferredSize());
        lbl1.setLocation(10,155);
        add(lbl1);

        lbl2 = new JLabel("Direccion: ");
        lbl2.setSize(lbl2.getPreferredSize());
        lbl2.setLocation(10,185);
        add(lbl2);

        lbl3 = new JLabel("Cedula: ");
        lbl3.setSize(lbl3.getPreferredSize());
        lbl3.setLocation(10,215);
        add(lbl3);

        lbl4 = new JLabel("Fecha: ");
        lbl4.setSize(lbl4.getPreferredSize());
        lbl4.setLocation(10,245);
        add(lbl4);

        llenarCombo(); // x 10 y 275
        lblVuelo = new JLabel("Vuelo #: ");
        lblVuelo.setSize(lblVuelo.getPreferredSize());
        lblVuelo.setLocation(10,275);
        add(lblVuelo);

        lblHoraSalida = new JLabel("Hora Salida:");
        lblHoraSalida.setSize(lblHoraSalida.getPreferredSize());
        lblHoraSalida.setLocation(10,305);
        add(lblHoraSalida);

        txtHoraSalida = new JTextField();
        txtHoraSalida.setSize(174,25);
        txtHoraSalida.setLocation(160, 305);
        add(txtHoraSalida);

        // Segundo combo x 10 y 335

        lblAsiento = new JLabel("Asiento #: ");
        lblAsiento.setSize(lblAsiento.getPreferredSize());
        lblAsiento.setLocation(10,335);
        add(lblAsiento);

        lblOrigen = new JLabel("Origen:");
        lblOrigen.setSize(lblOrigen.getPreferredSize());
        lblOrigen.setLocation(10,365);
        add(lblOrigen);

        txtOrigen = new JTextField();
        txtOrigen.setSize(txtHoraSalida.getSize());
        txtOrigen.setLocation(160, 365);
        add(txtOrigen);

        lblDestino = new JLabel("Destino:");
        lblDestino.setSize(lblDestino.getPreferredSize());
        lblDestino.setLocation(10,395);
        add(lblDestino);

        txtDestino = new JTextField();
        txtDestino.setSize(txtHoraSalida.getSize());
        txtDestino.setLocation(160, 395);
        add(txtDestino);

        lblCosto = new JLabel("Costo:");
        lblCosto.setSize(lblCosto.getPreferredSize());
        lblCosto.setLocation(10,425);
        add(lblCosto);

        txtCosto = new JTextField();
        txtCosto.setSize(txtHoraSalida.getSize());
        txtCosto.setLocation(160, 425);
        add(txtCosto);

        lblFechaSalida = new JLabel("Fecha Salida:");
        lblFechaSalida.setSize(lblFechaSalida.getPreferredSize());
        lblFechaSalida.setLocation(10, 455);
        add(lblFechaSalida);

        txtFechaSalida = new JTextField();
        txtFechaSalida.setSize(txtHoraSalida.getSize());
        txtFechaSalida.setLocation(160, 455);
        add(txtFechaSalida);

        lblTipoPer = new JLabel("Tipo de persona:");
        lblTipoPer.setSize(lblTipoPer.getPreferredSize());
        lblTipoPer.setLocation(10,485);
        add(lblTipoPer);

        lblPlaca = new JLabel("Placa del avion:");
        lblPlaca.setSize(lblPlaca.getPreferredSize());
        lblPlaca.setLocation(10,515);
        add(lblPlaca);

        txtPlaca = new JTextField();
        txtPlaca.setSize(txtHoraSalida.getSize());
        txtPlaca.setLocation(160, 515);
        add(txtPlaca);

        lbl5 = new JLabel("Subtotal: ");
        lbl5.setSize(lbl5.getPreferredSize());
        lbl5.setLocation(480,675);
        add(lbl5);

        lbl6 = new JLabel("IVA 12%: ");
        lbl6.setSize(lbl6.getPreferredSize());
        lbl6.setLocation(480,705);
        add(lbl6);

        lbl7 = new JLabel("Total: ");
        lbl7.setSize(lbl7.getPreferredSize());
        lbl7.setLocation(480,735);
        add(lbl7);

        btn1 = new JButton("Limpiar texto");
        btn1.setSize(200,25);
        btn1.setLocation(10, 675);
        add(btn1);

        btn2 = new JButton("Confirmar factura");
        btn2.setSize(200,25);
        btn2.setLocation(10, 705);
        add(btn2);

        btn3 = new JButton("Cancelar");
        btn3.setSize(200,25);
        btn3.setLocation(10, 735);
        add(btn3);

        btnVuelo = new JButton("Listar Vuelos");
        btnVuelo.setSize(200,25);
        btnVuelo.setLocation(10, 765);
        add(btnVuelo);

        txt2 = new JTextField();
        txt2.setSize(txtHoraSalida.getSize());
        txt2.setLocation(160, 185);
        add(txt2);

        txt3 = new JTextField();
        txt3.setSize(txtHoraSalida.getSize());
        txt3.setLocation(160, 215);
        add(txt3);

        txt4 = new JTextField();
        txt4.setSize(txtHoraSalida.getSize());
        txt4.setLocation(160,245);
        add(txt4);

        //Textos del resto
        txt5 = new JTextField();
        txt5.setSize(txtHoraSalida.getSize());
        txt5.setLocation(550,675);
        add(txt5);

        txt6 = new JTextField();
        txt6.setSize(txtHoraSalida.getSize());
        txt6.setLocation(550,705);
        add(txt6);

        txt7 = new JTextField();
        txt7.setSize(txtHoraSalida.getSize());
        txt7.setLocation(550,735);
        add(txt7);


        repaint();

        obtenerClientes();

        txt1 = new Java2sAutoTextField(stringsNombres);
        txt1.setSize(175,25);
        txt1.setLocation(160,155);
        txt1.setText("");
        add(txt1);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                txt1.setText("");
                txt1.grabFocus();
                txt1.requestFocus();
                txt1.setText("");
                txt1.selectAll();
                txt1.setStrict(false);
            }
        });

        txt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                boolean bandera = false;

                for (int i = 0; i < modeloClienteList.size(); i++) {
                    if (modeloClienteList.get(i).getNombre().equals(txt1.getText())) {
                        txt1.setText(modeloClienteList.get(i).getNombre());
                        txt2.setText(modeloClienteList.get(i).getDireccion());
                        txt3.setText(modeloClienteList.get(i).getCedula());
                        bandera = true;
                        break;
                    }
                }
                if(bandera == false)
                    crearCliente();
            }
        });
    }

    public void crearCliente(){
        int opcion = JOptionPane.showConfirmDialog(this, "El usuario ingresado no existe, \n desea crear uno nuevo?",
                "Usuario inexistente", JOptionPane.YES_NO_OPTION);
        CrearCliente crearCliente;
        if(opcion==0) {
            crearCliente = new CrearCliente();
            dispose();
        }else
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un usuario" +
                    " para la prefactura");
    }

    public void llenarCombo(){
      //  List<Asiento> asientoList = new ArrayList<>();
    //    List<Vuelos> vuelosList = new ArrayList<>();
        String tiposPer[] = {"Seleccione una opcion","Tercera edad/Ninos", "Discapacitados"};

        comboTipoPersona = new JComboBox(tiposPer);
        comboTipoPersona.setSize(174,25);
        comboTipoPersona.setLocation(160,485);
        add(comboTipoPersona);
    }

    public void obtenerClientes(){
        modeloClienteList = new ArrayList<>();
        stringsNombres = new ArrayList<>();


        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloClienteList = gestionAeroLinea.clienteList();

        for (int i = 0; i < modeloClienteList.size(); i++) {
            stringsNombres.add(modeloClienteList.get(i).getNombre());
        }
    }



}
