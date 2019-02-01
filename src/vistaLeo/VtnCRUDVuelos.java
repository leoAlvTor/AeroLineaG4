package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloTablaVuelos;
import modelo.ModeloVuelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VtnCRUDVuelos extends JFrame implements ActionListener {

    private JLabel lblId, lblCapacidad, lblHoraSalida, lblHoraLlegada, lblTipo, lblCosto, lblAeroSalida, lblAeroLlegada,
    lblAvion, lblFechaSalida,lblFechaLlegada;
    private JTextField camId, camCapacidad, camHoraSalida, camHoraLlegada, camTipo, camCosto, camAeroSalida, camAeroLlegada,
            camAvion, camFechaSalida,camFechaLlegada;

    private  JPanel principal, pUno, pDos, pNorte,pBotones;
    //
    private JButton btnRegistrar, btnListar, btnActualizar, btnBorrar;
    //
    private JTable tablaVuelos;
    //
    private  String seleccion;

    public VtnCRUDVuelos(){
        lblId=new JLabel("Id:");
        lblCapacidad=new JLabel("Capacidad:");
        lblHoraSalida=new JLabel("Hora Salida:");
        lblHoraLlegada=new JLabel("Hora Llegada");
        lblTipo=new JLabel("Tipo: ");
        lblCosto=new JLabel("Costo:");
        lblAeroSalida=new JLabel("Aeropuerto Salida:");
        lblAeroLlegada =new JLabel("Aeropuerto Llegada:");
        lblAvion=new JLabel("Avion: ");
        lblFechaSalida=new JLabel("Fecha Salida:");
        lblFechaLlegada=new JLabel("Fecha Llegada:");
        ///campos de texto
        camId=new JTextField();
        camCapacidad=new JTextField();
        camHoraSalida=new JTextField();
        camHoraLlegada=new JTextField();
        camTipo=new JTextField();
        camCosto=new JTextField();
        camAeroSalida=new JTextField();
        camAeroLlegada =new JTextField();
        camAvion=new JTextField();
        camFechaSalida=new JTextField();
        camFechaLlegada=new JTextField();
        //
        btnRegistrar =new JButton("Registrar");
        btnListar=new JButton("Listar");
        btnActualizar=new JButton("Actualizar");
        btnBorrar=new JButton("Borrar");




        init();
    }

    private void init() {
        setTitle("CrudVuelos");
        setSize(400,430);
        setLayout(null);
        setVisible(true);

        tablaVuelos = new JTable();
        tablaVuelos.setModel(new ModeloTablaVuelos());

        JScrollPane jScrollPane = new JScrollPane(tablaVuelos);
        jScrollPane.setSize(1080, 500);
        jScrollPane.setLocation(10, 10);

        add(jScrollPane);

        pUno=new JPanel(new GridLayout(11,1,0,5));
        pUno.add(lblId);pUno.add(lblCapacidad);pUno.add(lblHoraSalida);pUno.add(lblHoraLlegada);pUno.add(lblTipo);
        pUno.add(lblCosto);pUno.add(lblAeroSalida);pUno.add(lblAeroLlegada);pUno.add(lblAvion);pUno.add(lblFechaSalida);
        pUno.add(lblFechaLlegada);
        //panel dos
        pDos=new JPanel(new GridLayout(11,1,0,5));
        pDos.add(camId);pDos.add(camCapacidad);pDos.add(camHoraSalida);pDos.add(camHoraLlegada);pDos.add(camTipo);
        pDos.add(camCosto);pDos.add(camAeroSalida);pDos.add(camAeroLlegada);pDos.add(camAvion);pDos.add(camFechaSalida);
        pDos.add(camFechaLlegada);
        //
        pNorte=new JPanel(new GridLayout(1,2,5,0));
        pNorte.add(pUno);
        pNorte.add(pDos);
        pNorte.setSize(400,340);
        pNorte.setLocation(5,5);
        ///
        pBotones=new JPanel(new GridLayout(1,4,5,0));
        pBotones.setBackground(Color.red);
        pBotones.add(btnRegistrar);
        pBotones.add(btnListar);
        pBotones.add(btnActualizar);
        pBotones.add(btnBorrar);
        pBotones.setSize(400 ,30);
        pBotones.setLocation(5,350);


        add(pNorte);
        add(pBotones);
        add(jScrollPane);

    }

    /**
     * Metodo que se encargara de cardar los datos necesarios en la tabla de vuelos, el metodo consiste en que se
     * conecta a la base de datos para obtener la lista de vuelos mas actualizada que pueda estar en ese momento recibe
     * como parametro el destino
     * @param destino
     */
    public void llenarTabla(String destino){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(destino);

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));
    }

    /**
     * Este metodo se conectara a la base de datos para carga los  vuelos disponibles en funcion al destino, los datos
     * seran adicionados a un comboBox
     */
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

    /**
     * Metodo escucha de los botones
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        String op=e.getActionCommand();


    }
}
