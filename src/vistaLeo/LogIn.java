package vistaLeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogIn extends JFrame implements ActionListener {
    private JPanel pnlP;
    private JPanel pnlS1, pnlS2, pnlS3, pnlS3_1, pnlS3_2;
    private JTextField txtCedula, txtPass;
    private JButton btnLog, btnCancelar, btnSalir, btnRegistrar, btnRecuperar;

    // Labels
    JLabel lblTitulo, lblCedula, lblPass;

    public void ejecutar(){
        init();
        pack();
    }

    public void init(){
        setTitle("leo In");
        componentes();
        setLayout(null);

        Font font = new Font("TimesRoman", Font.BOLD, 22);

        lblTitulo.setFont(font);
        lblTitulo.setSize(lblTitulo.getPreferredSize());
        lblTitulo.setLocation(115,33);
        lblCedula.setSize(lblCedula.getPreferredSize());
        lblCedula.setLocation(32,70);
        lblPass.setSize(lblPass.getPreferredSize());
        lblPass.setLocation(13,100);

        add(lblTitulo);
        add(lblCedula);
        add(lblPass);

        txtCedula.setSize(180, 22);
        txtCedula.setLocation(92,70);
        txtPass.setSize(180,22);
        txtPass.setLocation(92,100);

        add(txtCedula);
        add(txtPass);

        btnLog.setSize(100,30);
        btnCancelar.setSize(130, 30);
        btnSalir.setSize(100, 30);
        btnRegistrar.setSize(130, 30);
        btnRecuperar.setSize(250,30);

        btnLog.setLocation(20,158);
        add(btnLog);
        btnCancelar.setLocation(140, 158);
        add(btnCancelar);
        btnSalir.setLocation(20,200);
        add(btnSalir);
        btnRegistrar.setLocation(140,200);
        add(btnRegistrar);
        btnRecuperar.setLocation(20, 243);
        add(btnRecuperar);

        this.setDefaultCloseOperation(3);
        this.setBounds(0,0,360,480);
        this.add(pnlP);
        this.setVisible(true);
    }

    public void componentes(){
        // JPanel
        pnlP = new JPanel();

        pnlS1 = new JPanel();
        pnlS2 = new JPanel();

        pnlS3 = new JPanel();
        pnlS3_1 = new JPanel();
        pnlS3_2 = new JPanel();

        // Labels
        lblTitulo = new JLabel("Log In");
        lblCedula = new JLabel("Cedula: ");
        lblPass = new JLabel("Password: ");

        //JTextField
        txtCedula = new JTextField(20);
        txtPass = new JTextField(20);

        //JButton
        btnLog = new JButton("Log In");
        btnLog.setActionCommand("login");
        btnLog.addActionListener(this);
        btnCancelar = new JButton("Cancelar");
        btnSalir = new JButton("Salir");
        btnRegistrar = new JButton("Registrarse");
        btnRecuperar = new JButton("Recuperar contrasena");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        if(e.getActionCommand().equals("login")){
            MenuAdministrador menuAdministrador = new MenuAdministrador();
            menuAdministrador.setSize(400,400);
            menuAdministrador.ejecutar();
        }
    }
}
