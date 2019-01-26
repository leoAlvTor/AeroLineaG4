package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloTablaVuelos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuscarVuelo extends JFrame {

    private JButton btnRegresar, btnOtroVuelo;
    private JTable table;

    public BuscarVuelo(){
        ejecutar();
    }

    public void ejecutar(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        lista = gestionAeroLinea.destinos();


        String[] destinos = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            destinos[i] = lista.get(i);
        }

        String favoritePizza = (String) JOptionPane.showInputDialog(this,
                "What is your favorite pizza?",
                "Favorite Pizza",
                JOptionPane.QUESTION_MESSAGE,
                null,
                destinos,
                destinos[0]);

        setVisible(true);
        setSize(1100,600);

        setLayout(null);

        init();
    }

    public void init(){
        table = new JTable();
        table.setModel(new ModeloTablaVuelos());

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setSize(1080, 500);
        jScrollPane.setLocation(10, 10);

        add(jScrollPane);

    }
}
