package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloTablaVuelos;
import modelo.ModeloVuelos;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscarVuelo extends JFrame implements ActionListener {

    private JButton btnRegresar, btnOtroVuelo;
    private JTable tablaVuelos;

    public BuscarVuelo(){
        ejecutar();
    }

    public void ejecutar(){
    	
    	this.setTitle("Buscar Vuelos");
    	btnRegresar=new JButton("Regresar");
    	btnRegresar.setActionCommand("btnRegreasar");
    	btnRegresar.addActionListener(this);
    	//////////
    	btnOtroVuelo=new JButton("Nueva Busqueda");
    	btnOtroVuelo.setActionCommand("btnOtroVuelo");
    	/////
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        List<String> lista= new ArrayList<>();
        lista = gestionAeroLinea.destinos();


        String[] destinos = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            destinos[i] = lista.get(i);
        }

        String seleccion = (String) JOptionPane.showInputDialog(this,
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

        llenarTabla(seleccion);
    }

    public void init(){
        tablaVuelos = new JTable();
        tablaVuelos.setModel(new ModeloTablaVuelos());

        JScrollPane jScrollPane = new JScrollPane(tablaVuelos);
        jScrollPane.setSize(1080, 500);
        jScrollPane.setLocation(10, 10);

        btnRegresar.setSize(100,30);
        btnRegresar.setLocation(10,520);

        btnOtroVuelo.setSize(150,30);
        btnOtroVuelo.setLocation(120,520);

		add(jScrollPane);
		add(btnRegresar);
		//add(btnOtroVuelo);

    }

    public void llenarTabla(String destino){
        List<ModeloVuelos> modeloTablaVuelos;

        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        modeloTablaVuelos = gestionAeroLinea.listarVuelosPorDestino(destino);

        tablaVuelos.setModel(new ModeloTablaVuelos(modeloTablaVuelos));
    }

	/**
	 * metodo escucha de eventos del teclado
	 */
	public void actionPerformed(ActionEvent e) {
		String op=e.getActionCommand();
		
		switch (op) {
		case "btnRegreasar":
			/**
			 * Leo estas creando objetos a lo loco
			 */
			MenuAdministrador menuAdministrador = new MenuAdministrador();
            menuAdministrador.setSize(600,500);
            menuAdministrador.ejecutar();
            dispose();
			break;
		case"btnOtroVuelo":
			
			break;
		default:
			break;
		}		
	}
}
