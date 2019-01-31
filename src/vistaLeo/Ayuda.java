package vistaLeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ayuda extends JFrame implements ActionListener {

    private JLabel lblIntegrantes, lblInt1, lblInt2, lblInt3, lblVersion, lblGit;

    private JButton btnAceptar;

    private int codigoEmp;

    public Ayuda(int codigo){
        codigoEmp = codigo;
        ejecutar();
    }

    public void ejecutar(){
        setSize(325,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        init();
    }

    public void init(){

        JPanel jPanel= new JPanel(new GridLayout(6,1));

        lblIntegrantes = new JLabel("**********{Integrantes}");
        jPanel.add(lblIntegrantes);

        lblInt1 = new JLabel(" Leo Alvarado calvaradot1@est.ups.edu.ec");
        jPanel.add(lblInt1);

        lblInt2 = new JLabel("Pedro Illaisaca pillaisacat@est.ups.edu.ec");
        jPanel.add(lblInt2);

        lblInt3 = new JLabel("Paul Vizhnay dvizhnaym@est.ups.edu.ec");
        jPanel.add(lblInt3);

        lblVersion = new JLabel("**********{Version} \n1.0");
        jPanel.add(lblVersion);
        lblGit = new JLabel("https://github.com/leoAlvTor/AeroLineaG4.git");
        jPanel.add(lblGit);

        btnAceptar = new JButton("||~Aceptar~||");
        btnAceptar.setActionCommand("aceptar");
        btnAceptar.addActionListener(this);

        add(jPanel, BorderLayout.CENTER);
        add(btnAceptar, BorderLayout.SOUTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("aceptar"))
            llamarLog();
    }

    public void llamarLog(){
        System.out.println("Agente");
        MenuAgente menuAgente = new MenuAgente();
        menuAgente.ejectuar(codigoEmp);
        menuAgente.setSize(500,500);
        dispose();
    }
}
