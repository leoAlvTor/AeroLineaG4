package vistaLeo;

import controlador.GestionAeroLinea;
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

public class BuscarVuelo extends JFrame implements ActionListener {

    private JButton btnRegresar, btnOtroVuelo;
    private JTable tablaVuelos;
    private String seleccion;
    private boolean rol;        // En caso de que sea administrador |true| o agente |false|

    public BuscarVuelo(boolean pRol){
        rol = pRol;
        ejecutar();
    }

    public void ejecutar(){
        setLayout(null);
        setTitle("Listado de vuelos por destino");
        setVisible(true);
        setSize(1100,650);

        // Ventana centrada
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth())/2);
        int y = (int) ((dimension.getHeight()) - this.getHeight())/2;
        this.setLocation(x,y);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();

        mostrarVuelos();

    }

    public void init(){
        tablaVuelos = new JTable();
        tablaVuelos.setModel(new ModeloTablaVuelos());

        JScrollPane jScrollPane = new JScrollPane(tablaVuelos);
        jScrollPane.setSize(1080, 500);
        jScrollPane.setLocation(10, 10);

        add(jScrollPane);

        btnOtroVuelo = new JButton("Mostrar destinos disponibles");
        btnOtroVuelo.setActionCommand("mostrar");
        btnOtroVuelo.addActionListener(this);
        btnOtroVuelo.setSize(250,30);
        btnOtroVuelo.setLocation(275, 550);
        add(btnOtroVuelo);

        btnRegresar = new JButton("Regresar al menu principal");
        btnRegresar.setActionCommand("salir");
        btnRegresar.addActionListener(this);
        btnRegresar.setSize(250,30);
        btnRegresar.setLocation(550, 550);
        add(btnRegresar);

        repaint();


        if (rol == true){
            PreFactura preFactura = new PreFactura();

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
                        System.out.println(datos);

                        datos = (String) tablaVuelos.getValueAt(fila, columna);
                        preFactura.txtCodigo.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 1);
                        preFactura.txt.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 2);
                        txtSalida.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 3);
                        txtLlegada.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 4);
                        txtTipo.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 5);
                        txtCosto.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 6);
                        comboAeroSalida.setSelectedIndex(Integer.parseInt(datos));
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 7);
                        comboAeroLlegada.setSelectedIndex(Integer.parseInt(datos));
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 8);
                        txtAvion.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 9);
                        txtFechaSalida.setText(datos);
                        datos = (String) tablaVuelos.getValueAt(fila, columna + 10);
                        txtFechaLlegada.setText(datos);
                    }
                }
            });

        }
    }

    public void llenarTabla(String destino){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(destino);

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));
    }

    public void regresarMenu(){
        dispose();
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        menuAdministrador.setSize(600,500);
        menuAdministrador.ejecutar();
    }

    public void mostrarVuelos(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        lista = gestionAeroLinea.destinos();


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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("mostrar"))
            mostrarVuelos();
        else if(e.getActionCommand().equals("salir"))
            regresarMenu();
    }
}
