package vistaLeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MenuAdministrador extends JFrame implements MouseListener {
    private JLabel lblBuscar, lblActualizar, lblEliminar, lblSalir, lblRegistrar;
    private JLabel txtBuscar, txtActualizar, txtEliminar, txtSalir, txtRegistrar;

    public void ejecutar(){
        componentes();
        init();
        repaint();
    }

    public void init(){
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Menu Administrador");
        setLayout(null);

        lblBuscar.setSize(130,100);
        lblBuscar.setLocation(50, 30);
        add(lblBuscar);

        txtBuscar.setLocation(55,140);
        txtBuscar.setSize(txtBuscar.getPreferredSize());
        add(txtBuscar);

        lblActualizar.setSize(lblBuscar.getSize());
        lblActualizar.setLocation(370, 30);
        add(lblActualizar);

        txtActualizar.setLocation(360, 140);
        txtActualizar.setSize(txtActualizar.getPreferredSize());
        add(txtActualizar);

        lblEliminar.setSize(lblBuscar.getSize());
        lblEliminar.setLocation(50,190);
        add(lblEliminar);

        txtEliminar.setSize(txtEliminar.getPreferredSize());
        txtEliminar.setLocation(42, 295);
        add(txtEliminar);

        lblSalir.setSize(lblBuscar.getSize());
        lblSalir.setLocation(370, 190);
        add(lblSalir);

        txtSalir.setSize(txtSalir.getPreferredSize());
        txtSalir.setLocation(395,295);
        add(txtSalir);

        lblRegistrar.setSize(lblBuscar.getPreferredSize());
        lblRegistrar.setLocation(220, 250);
        add(lblRegistrar);

        txtRegistrar.setSize(txtRegistrar.getPreferredSize());
        txtRegistrar.setLocation(210, 345);
        add(txtRegistrar);

    }

    public void componentes(){
        lblRegistrar = new JLabel();
        lblRegistrar.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/registrar.png")));
        lblRegistrar.addMouseListener(this);

        lblBuscar = new JLabel();
        lblBuscar.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Buscar.png")));
        lblBuscar.addMouseListener(this);

        lblActualizar = new JLabel();
        lblActualizar.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Actualizar.png")));
        lblActualizar.addMouseListener(this);

        lblEliminar = new JLabel();
        lblEliminar.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Borrar.png")));
        lblEliminar.addMouseListener(this);

        lblSalir = new JLabel();
        lblSalir.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Salir.png")));
        lblSalir.addMouseListener(this);

        txtRegistrar = new JLabel("Registrar usuario");
        txtRegistrar.setToolTipText("Registrar un nuevo empleado");

        txtActualizar = new JLabel("Actualizar vuelos");
        txtActualizar.setToolTipText("Actualizar los datos de un vuelo");

        txtBuscar = new JLabel("Buscar vuelos");
        txtBuscar.setToolTipText("Buscar un vuelo dentro del registro");

        txtEliminar = new JLabel("Eliminar vuelos");
        txtEliminar.setToolTipText("Eliminar un vuelo ya vendido");

        txtSalir = new JLabel("Salir");
        txtSalir.setToolTipText("Regresar a la ventana de LogIn");
    }

    public void llamarRegistro(){
        dispose();
        CrearCuenta  crearCuenta = new CrearCuenta();
    }

    public void llamarBuscarVuelos(){
        dispose();
        BuscarVuelo buscarVuelo = new BuscarVuelo(true,0);
    }

    public void logOut(){
        LogIn logIn = new LogIn();
        logIn.init();
        logIn.setSize(300,350);
        logIn.setLocation(870,270);
        dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object event = e.getSource();
        JLabel label = (JLabel) event;
        Actualizar actualizar;
        Eliminar eliminar;


        if(label == lblBuscar)
            llamarBuscarVuelos();
        else if(label == lblActualizar) {
            actualizar = new Actualizar();
            dispose();
        }else if(label == lblEliminar) {
            eliminar = new Eliminar();
            dispose();
        }
        else if(label == lblSalir)
            logOut();
        else if(label == lblRegistrar)
            llamarRegistro();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
