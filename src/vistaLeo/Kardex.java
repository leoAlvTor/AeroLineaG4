package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloKardex;
import modelo.ModeloTablaKardex;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Kardex extends JFrame implements ActionListener {
    //tabla
    private JTable tablaKardex;
    private String seleccion;
    //botones
    private JButton btnRegresar, btnOtroVuelo;
    //rol de verificacion
    private boolean rol; // En caso de que sea administrador |true| o agente |false|
    //constructor
    public Kardex(){
        ejecutar();
    }
    //metodo que sera llamado desde el constructor
    public void ejecutar(){
        setLayout(null);
        setTitle("Kardex Producto");
        setVisible(true);
        setSize(1100,650);

        // Ventana centrada
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth())/2);
        int y = (int) ((dimension.getHeight()) - this.getHeight())/2;
        this.setLocation(x,y);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();

        mostrarInfoKardex();

    }

    /**
     * Inicializacion de todos los componentes que pertenecen a esta clase
     */
    public void init(){
        tablaKardex = new JTable();
        tablaKardex.setModel(new ModeloTablaKardex());
        //la ventana sera añadida a un Scroll pane en caso de que los datos sobre pasen la tabla
        JScrollPane jScrollPane = new JScrollPane(tablaKardex);
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
     * Cuando este metodo sea llamado se pasara como parametro el destino donde la consulta que esta alojada en la base
     * de datos realizara los calculos correspondientes de el kardex
     * @param destino
     */
    public void llenarTabla(String destino){
        List<ModeloKardex> modeloTablaKardex;
        //conexion con la base de datos mediante la clase gestion aerolinea
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaKardex = gestionAeroLinea.listarKardex(destino);//ATENTO AQUI PUEDE IR PARAMETROS
        //se pasa la lista de objetos de tipo modelo kardex a las respactivas tablas
        tablaKardex.setModel(new ModeloTablaKardex(modeloTablaKardex));
    }

    //metodo encargado de regresar al menu adminstrador
    public void regresarMenu(){
        dispose();
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        menuAdministrador.setSize(600,500);
        menuAdministrador.ejecutar();
    }

    /**
     * obtener informacion de la base de datos
     */
    public void mostrarInfoKardex(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        //Extraemos la informacion del kardex del la base de datos  en funcion de los destinos
        lista = gestionAeroLinea.destinos();

        String[] destinos = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            destinos[i] = lista.get(i);
        }
        //cargamos los destinos que tienen sus respctivos registros en la entidad kerdex
        seleccion = (String) JOptionPane.showInputDialog(this,
                "Seleccione el destino para conocer su kardex?",
                "Ingrese el destino",
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
            mostrarInfoKardex();
        else if(e.getActionCommand().equals("salir"))
            regresarMenu();
    }
}
