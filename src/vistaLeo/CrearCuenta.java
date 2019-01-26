package vistaLeo;
import controlador.GestionAeroLinea;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CrearCuenta  extends JFrame implements ActionListener{
    private JLabel lblCodigo;
    private JLabel lblCedula;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblContrasenia;
    private JLabel lblPregSeguridad;
    private JLabel lblRespuesta;
    private JLabel lblrol;

    private JTextField camCodigo;
    private JTextField camCedula;
    private JTextField camNombre;
    private JTextField camApellido;
    private JTextField camRespuesta;

    private JPasswordField camContrasenia;
    private JComboBox <String>  jcbPregSeguridad;
    private JComboBox <String> jcbRol;

    private JButton bntReguistrarNewUsuario;
    private JButton bntCancelar;

    public CrearCuenta() {

        setVisible(true);

        lblCodigo = new JLabel("Código:");
        lblCedula = new JLabel("Cédula:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblContrasenia = new JLabel("Contraseña:");
        lblPregSeguridad = new JLabel("Pregunta seguridad:");
        lblrol = new JLabel("Rol:");
        lblRespuesta=new JLabel("Respuesta:");

        camCodigo = new JTextField();
        camCedula = new JTextField();
        camNombre = new JTextField();
        camApellido = new JTextField();
        camContrasenia = new JPasswordField();
        camContrasenia.setEchoChar('*');
        camRespuesta=new JTextField();
        jcbPregSeguridad = new  JComboBox<String>();
        jcbPregSeguridad.addItem("Primer colegio");
        jcbPregSeguridad.addItem("Ciudad de nacimiento");
        jcbPregSeguridad.repaint();

        jcbRol = new JComboBox<String>();
        jcbRol.addItem("Agente");
        jcbRol.addItem("Administrador");
        jcbRol.repaint();

        bntReguistrarNewUsuario = new JButton("Crear nuevo Usuario");
        bntReguistrarNewUsuario.setActionCommand("btnRegUsuario");
        bntReguistrarNewUsuario.addActionListener(this);
        bntCancelar = new JButton("Cancelar");
        bntCancelar.setActionCommand("bntCancelar");
        bntCancelar.addActionListener(this);
        initComponentes();

    }

    private void initComponentes() {

        this.setTitle("Crear Cuenta");
        this.setSize( 400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container cont=getContentPane();
        cont.setLayout(new FlowLayout(0,10,10));

        GridLayout gc=new GridLayout(1,2);
        gc.setHgap(10);
        gc.setVgap(0);
        Panel mipaneG=new Panel(gc);

        GridLayout gmp=new GridLayout(9, 1);
        gmp.setHgap(0);
        gmp.setVgap(10);
        Panel mipanel=new Panel(gmp);
        //mipanel.setBackground(Color.red);

        GridLayout gmp2=new GridLayout(9, 1);
        gmp2.setHgap(0);
        gmp2.setVgap(10);
        Panel mipane2=new Panel(gmp2);
        //mipane2.setBackground(Color.CYAN);

       // mipanel.add(lblCodigo);
        mipanel.add(lblCedula);
        mipanel.add(lblNombre);
        mipanel.add(lblApellido);
        mipanel.add(lblContrasenia);
        mipanel.add(lblPregSeguridad);
        mipanel.add(lblRespuesta);
        mipanel.add(lblrol);
        mipanel.add(bntReguistrarNewUsuario);

       // mipane2.add(camCodigo);
        mipane2.add(camCedula);
        mipane2.add(camNombre);
        mipane2.add(camApellido);
        mipane2.add(camContrasenia);
        mipane2.add(jcbPregSeguridad);
        mipane2.add(camRespuesta);
        mipane2.add(jcbRol);
        mipane2.add(bntCancelar);


        mipaneG.add(mipanel);
        mipaneG.add(mipane2);

        cont.add(mipaneG);

    }


    public void actionPerformed(ActionEvent e) {
        String op=e.getActionCommand();
        //System.out.println("Opción: "+op);

        switch (op) {
            case "btnRegUsuario":
                System.out.println("btnRegUsuario");
                GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();

                String cedula = camCedula.getText();
                String nombre = camNombre.getText();
                String apellido = camApellido.getText();
                String password = String.valueOf(camContrasenia.getPassword());
                String pregunta = String.valueOf(jcbPregSeguridad.getSelectedItem());
                String respuesta = camRespuesta.getText();
                String rol = String.valueOf(jcbRol.getSelectedItem());


                gestionAeroLinea.crearUsuario(cedula, nombre, apellido, password, pregunta, respuesta, rol);

                break;

            case "bntCancelar":
                System.out.println("bntCancelar");
                break;



            default:
                break;

        }
    }

}