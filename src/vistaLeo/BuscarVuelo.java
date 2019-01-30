package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloTablaKardex;
import modelo.ModeloTablaVuelos;
import modelo.ModeloVuelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscarVuelo extends JFrame implements ActionListener {
    //botones
    private JButton btnRegresar, btnOtroVuelo;
    //tablas
    private JTable tablaVuelos;
    //String
    private String seleccion;
    //boolean rol
    private boolean rol;        // En caso de que sea administrador |true| o agente |false|

    public BuscarVuelo(){
        ejecutar();
    }

    /**
     * metodo que es llamado desde el constructor de la clase el cual determina las caracteristicas de la vetana
     */
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

    /**
     * Inicion de las variables entre ellas encontramos a los botones junto con las dimensiones, tablas, Scroll
     * que forman parte de la ventana
     */
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
     * El metodo regresara al menu que le corresponda segun desde donde lo esten llamando puede si es llamado desde el
     * menu agente de ventas regresara a este del mismo modo con el menu de administrador
     */
    public void regresarMenu(){
        dispose();
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        menuAdministrador.setSize(600,500);
        menuAdministrador.ejecutar();
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
     * Metodo escucha de eventos que se accionara al monento de realizar una pulsacion internamente se filtran las
     * acciones para diferenciar el boton que se pulso.
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("mostrar"))
            mostrarVuelos();
        else if(e.getActionCommand().equals("salir"))
            regresarMenu();
    }
}
