package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;

public class FormaPago extends JPanel{
    private JButton btn1, btn2;
    private IconTextField txtForma;
    private JLabel lbl1;
    private Icon icon1, icon2, icon3, icon4, icon5;

    public FormaPago(){
        ejecutar();
    }

    public void ejecutar(){
        setSize(349,199);
        setVisible(true);
        init();

        System.out.println("Tamano de esa cosa: "+txtForma.getSize());

        setSize(350, 100);
    }

    public void init(){
        icon1 = new ImageIcon(this.getClass().getResource("Imagenes/tarjetas/Vacio.png"));
        icon2 = new ImageIcon(this.getClass().getResource("Imagenes/tarjetas/American.png"));
        icon3 = new ImageIcon(this.getClass().getResource("Imagenes/tarjetas/Discover.png"));
        icon4 = new ImageIcon(this.getClass().getResource("Imagenes/tarjetas/Master.png"));
        icon5 = new ImageIcon(this.getClass().getResource("Imagenes/tarjetas/Visa.png"));



        JPanel pnl1 = new JPanel(new FlowLayout());
        lbl1 = new JLabel("Ingrese el numero de tarjeta:");
        pnl1.add(lbl1);
        txtForma = new IconTextField();
        txtForma.setmIcon(icon1);
        txtForma.setBorder(txtForma.getBorder());
        txtForma.setColumns(19);
        pnl1.add(txtForma);

        JPanel pnl3 = new JPanel(new GridLayout(2,1));
        pnl3.add(pnl1);

        add(pnl3);

        txtForma.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                determinarTarjeta();
            }
        });
    }

    public void determinarTarjeta(){
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();
        int b = 0;
        if(txtForma.getText().length() > 0) {
            b = gestionAeroLinea.comprobarTarjeta(BigInteger.valueOf(Long.parseLong(txtForma.getText())));
        }
        if(b == 1)
            txtForma.setmIcon(icon5);
        else if(b==2)
            txtForma.setmIcon(icon4);
        else if(b==3)
            txtForma.setmIcon(icon3);
        else if(b==4)
            txtForma.setmIcon(icon2);
        else
            txtForma.setmIcon(icon1);
    }


}
