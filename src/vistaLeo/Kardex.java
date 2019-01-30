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

    private JTable tablaKardex;
    private String seleccion;

    private JButton btnRegresar, btnOtroVuelo;


    private boolean rol;        // En caso de que sea administrador |true| o agente |false|

    public Kardex(){
        ejecutar();
    }

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

    public void init(){
        tablaKardex = new JTable();
        tablaKardex.setModel(new ModeloTablaKardex());

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

    public void llenarTabla(String destino){
        List<ModeloKardex> modeloTablaKardex;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaKardex = gestionAeroLinea.listarKardex(destino);//ATENTO AQUI PUEDE IR PARAMETROS

        tablaKardex.setModel(new ModeloTablaKardex(modeloTablaKardex));
    }


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


        seleccion = (String) JOptionPane.showInputDialog(this,
                "Seleccione el destino para conocer su kardex?",
                "Ingrese el destino",
                JOptionPane.QUESTION_MESSAGE,
                null,
                destinos,
                destinos[0]);

        llenarTabla(seleccion);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("mostrar"))
            mostrarInfoKardex();
        else if(e.getActionCommand().equals("salir"))
            regresarMenu();
    }
}
