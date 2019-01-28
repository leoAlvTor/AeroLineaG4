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

public class BuscarVuelo extends JFrame implements ActionListener {

    private JButton btnRegresar, btnOtroVuelo;
    private JTable tablaVuelos;
    private String seleccion;

    public BuscarVuelo(){
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
