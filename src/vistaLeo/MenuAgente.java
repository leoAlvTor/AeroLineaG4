package vistaLeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase esta programada en su mayoria etiquetas, las que comienzan con lbl contendran una imagen
 * las que comienzen con txt mostraran la descripcion ala que hace referencia la imagen
 */
public class MenuAgente extends JFrame implements MouseListener {
    //etiquetas con imagen
    private JLabel lblMostrar, lblComprar, lblReporte, lblSalir, lblAyuda;
    //etiquetas con texto
    private JLabel txtMostrar, txtComprar, txtReporte, txtSalir, txtAyuda;
    //metodo que puede ser llamado desde otra clase
    public void ejectuar(){
        pack();
        componentes();
        init();
        setSize(500,500);
    }
    /**
     * Metodo donde determinan los componentes que son parte de esta ventana internamente se establece el color de
     * fondo el titulo de la ventana la ubicacion de los lbl con imagen en conjunto con las dimensiones
     */
    public void init(){
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Menu Agente");
        setLayout(null);

        lblMostrar.setSize(130,100);
        lblMostrar.setLocation(65, 30);
        add(lblMostrar);

        txtMostrar.setSize(txtMostrar.getPreferredSize());
        txtMostrar.setLocation(60,140);
        add(txtMostrar);

        lblComprar.setSize(lblComprar.getPreferredSize());
        lblComprar.setLocation(360, 30);
        add(lblComprar);

        txtComprar.setSize(txtComprar.getPreferredSize());
        txtComprar.setLocation(350, 140);
        add(txtComprar);

        lblAyuda.setSize(lblComprar.getPreferredSize());
        lblAyuda.setLocation(215,180);
        add(lblAyuda);

        txtAyuda.setSize(txtAyuda.getPreferredSize());
        txtAyuda.setLocation(235,280);
        add(txtAyuda);

        lblReporte.setSize(lblReporte.getPreferredSize());
        lblReporte.setLocation(50,270);
        add(lblReporte);

        txtReporte.setSize(txtReporte.getPreferredSize());
        txtReporte.setLocation(42, 375);
        add(txtReporte);

        lblSalir.setSize(lblSalir.getPreferredSize());
        lblSalir.setLocation(360, 270);
        add(lblSalir);

        txtSalir.setSize(txtSalir.getPreferredSize());
        txtSalir.setLocation(385,370);
        add(txtSalir);
    }
    /**
     * En este metodo se inicializan los respectivos componentes y se agregan las ubicaciones path de las imagenes,
     * tambien se agrega una funcionalidad que estara en escucha cuando se pulse click sobre la imajen
     */
    public void componentes(){
        lblMostrar = new JLabel();
        lblMostrar.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Mostrar.png")));
        lblMostrar.addMouseListener(this);

        lblComprar = new JLabel();
        lblComprar.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Dollar.png")));
        lblComprar.addMouseListener(this);

        lblReporte = new JLabel();
        lblReporte.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Reporte.png")));
        lblReporte.addMouseListener(this);

        lblSalir = new JLabel();
        lblSalir.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Salir.png")));
        lblSalir.addMouseListener(this);

        lblAyuda = new JLabel();
        lblAyuda.setIcon(new ImageIcon(this.getClass().getResource("Imagenes/Ayuda.png")));
        lblAyuda.addMouseListener(this);

        txtMostrar = new JLabel("Mostrar vuelos");
        txtMostrar.setToolTipText("Lista los vuelos vendidos");

        txtComprar = new JLabel("Comprar boleto");
        txtComprar.setToolTipText("Permite la compra de un nuevo boleto");

        txtReporte = new JLabel("Reporte de ventas");
        txtReporte.setToolTipText("Muestra el reporte de venta actual");

        txtSalir = new JLabel("Salir");
        txtSalir.setToolTipText("Cierra sesion");

        txtAyuda = new JLabel("Ayuda");
        txtAyuda.setToolTipText("Muestra informacion del sistema");

    }
    /**
     * metodo encarcado en el escucha de los click que el usuario pulsara dependiendo la opcion que se elija
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        Object event = e.getSource();
        JLabel label = (JLabel) event;

        if(label == lblAyuda)
            System.out.println("auxilio");
        else if (label == lblComprar)
            System.out.println("Compras");
        else if (label == lblMostrar)
            System.out.println("Mostrar vuelos");
        else if(label == lblReporte)
            System.out.println("Reporte de ventas");
        else if(label == lblSalir)
            System.out.println("Log out");
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
