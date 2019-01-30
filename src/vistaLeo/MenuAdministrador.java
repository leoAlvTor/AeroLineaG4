package vistaLeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase esta programada en su mayoria etiquetas, las que comienzan con lbl contendran una imagen
 * las que comienzen con txt mostraran la descripcion ala que hace referencia la imagen
 */

public class MenuAdministrador extends JFrame implements MouseListener {
    //etiquetas con imagen
    private JLabel lblBuscar, lblActualizar, lblEliminar, lblSalir, lblRegistrar;
    //etiquetas con texto
    private JLabel txtBuscar, txtActualizar, txtEliminar, txtSalir, txtRegistrar;
    //metodo que puede ser llamado desde otra clase
    public void ejecutar(){
        componentes();
        init();
        repaint();
    }

    /**
     * Metodo donde determinan los componentes que son parte de esta ventana internamente se establece el color de
     * fondo el titulo de la ventana la ubicacion de los lbl con imagen en conjunto con las dimensiones
     */
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

    /**
     * En este metodo se inicializan los respectivos componentes y se agregan las ubicaciones path de las imagenes,
     * tambien se agrega una funcionalidad que estara en escucha cuando se pulse click sobre la imajen
     */
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

    /**
     * metodo llamado desde el bloque de escucha de eventos, cuando este entre en ejecucion el sistema mostrara en
     * pantalla la interfaz de crear cuenta
     */
    public void llamarRegistro(){
        dispose();
        CrearCuenta  crearCuenta = new CrearCuenta();
    }

    /**
     * Cuando el metodo sea llamado el sistema mostrara en pantalla la interfaz que se encarga de la busqueda de vuelos
     */
    public void llamarBuscarVuelos(){
        dispose();
        BuscarVuelo buscarVuelo = new BuscarVuelo();
    }
    //En el momento que el metodo se llamado el sistema pasara del la ventana que se encuentra actualmente a la ventana
    //de login
    public void logOut(){
        System.out.println();
        LogIn logIn = new LogIn();
        logIn.init();
        logIn.setSize(300,350);
        logIn.setLocation(870,270);
        dispose();
    }

    /**
     * metodo encarcado en el escucha de los click que el usuario pulsara dependiendo la opcion que se elija
     * @param e
     */
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
