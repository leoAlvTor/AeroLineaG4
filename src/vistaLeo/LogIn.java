package vistaLeo;

import controlador.GestionAeroLinea;
import modelo.ModeloEmpleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;



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

        btnRecuperar = new JButton("Recuperar password");
        btnRecuperar.setActionCommand("recuperar");
        btnRecuperar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("login")){
            GestionAeroLinea gestionAeroLinea= new GestionAeroLinea();
            List<ModeloEmpleado> modeloEmpleados = new ArrayList<>();
            modeloEmpleados = gestionAeroLinea.obtenerEmpleados();
            boolean bandera = false;
            boolean banderaRol = false;
            for (int i = 0; i < modeloEmpleados.size(); i++) {
                String cedula = modeloEmpleados.get(i).getCedula();
                String password = modeloEmpleados.get(i).getPassword();
                String rol = modeloEmpleados.get(i).getRol();

                if(cedula.equals(txtCedula.getText()) && password.equals(txtPass.getText()) ){
                    bandera = true;

                    if(rol.equals("Agente"))
                        banderaRol = true;
                    else if (rol.equals("Administrador"))
                            banderaRol = false;

                    break;
                }else{
                    bandera = false;
                }
            }

            if(bandera == true){
                if(banderaRol == true) {
                    System.out.println("Agente");
                    MenuAgente menu = new MenuAgente();
                    menu.setSize(500,500);
                    menu.ejectuar();
                    this.setVisible(false);
                }else if(banderaRol == false) {
                    System.out.println("Administrador");
                    MenuAdministrador menuAdministrador = new MenuAdministrador();
                    menuAdministrador.setSize(400,400);
                    menuAdministrador.ejecutar();
                    this.setVisible(false);
                }
            }else {
                Object[] options = {"Aceptar"};
                int n = JOptionPane.showOptionDialog(this,
                        "El usuario ingresado no existe", "Error",
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                txtCedula.setText("");
                txtPass.setText("");
                txtCedula.requestFocus();
            }
        }

        String accion = e.getActionCommand();
        switch (accion) {
            case "recuperar":
                System.out.println("recuperar...");
                setVisible(false);
                RecuperarPass recuperarPass = new RecuperarPass();

                break;
                default:
                    break;
        }
    }
}
