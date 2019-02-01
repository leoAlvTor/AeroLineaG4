package vistaLeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormaPago extends JFrame{
    private JButton btn1, btn2;

    public FormaPago(){

        // SE SELECCIONA LA FORMA DE PAGO
        Object botones[] = {"Efectivo", "Tarjeta de credito"};
        int i = JOptionPane.showOptionDialog(null,
                "Seleccione una forma de pago", "AeroLinea Don Pancho",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                botones, botones[0]);


    }

    public void init(){
        //JLabel = lbl1
    }


}
