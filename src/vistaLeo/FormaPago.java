package vistaLeo;

import controlador.GestionAeroLinea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;

public class FormaPago extends JFrame{
    private JButton btn1, btn2;
    private JTextField txtForma;
    private JLabel lbl1;

    public FormaPago(){
        ejecutar();
    }

    public void ejecutar(){
        setSize(350,200);
        setVisible(true);
        setTitle("Tarjeta de credito");
        init();
    }

    public void init(){
        JPanel pnl1 = new JPanel(new FlowLayout());
        lbl1 = new JLabel("Ingrese el numero de tarjeta:");
        pnl1.add(lbl1);
        txtForma = new JTextField(20);
        pnl1.add(txtForma);

        JPanel pnl2 = new JPanel(new FlowLayout());
        btn1 = new JButton("Confirmar Pago");
        pnl2.add(btn1);
        btn2 = new JButton("Cancelar Pago");
        pnl2.add(btn2);

        JPanel pnl3 = new JPanel(new GridLayout(2,1));
        pnl3.add(pnl1);
        pnl3.add(pnl2);

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

        int b = gestionAeroLinea.comprobarTarjeta(BigInteger.valueOf(Long.parseLong(txtForma.getText())));


    }


}
