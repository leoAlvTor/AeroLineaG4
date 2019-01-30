package vistaLeo;

import controlador.ConexionAdministrador;
import controlador.GestionAeroLinea;
import controlador.SentenciasAdministrador;
import modelo.ModeloEmpleado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class RecuperarPass extends JFrame implements ActionListener{
    //etiquetas
    private JLabel lblcedula;
    private JLabel lblpregunta;
    private JLabel lblrespuesta;
    //campos de texto
    private JTextField camCedula;
    private JTextField camPregunta;
    private JTextField camRespuesta;
    //botones
    private JButton bntconsultar, btnSalir;
    //comboBox
    private JComboBox comboPreguntas;
    //Preuguntas de seguridad
    private String[] preguntas = {"Ciudad de nacimiento", "Primer colegio"};

    //constructor
    public RecuperarPass() {

        lblcedula = new JLabel("Cédula:");
        lblpregunta = new JLabel("Pregunta:");
        lblrespuesta = new JLabel("Respuesta:");

        camCedula=new JTextField();
        comboPreguntas = new JComboBox(preguntas);
        camRespuesta=new JTextField();

        bntconsultar=new JButton("Consultar");
        bntconsultar.setActionCommand("bntconsultar");
        bntconsultar.addActionListener(this);

        btnSalir = new JButton("Salir");
        btnSalir.setActionCommand("salir");
        btnSalir.addActionListener(this);
        ///

        initComponentes();
    }
    //En este metodo se inicialisan todos los componentes pertenecientes a esta clase
    private void initComponentes() {
        setVisible(true);
        this.setTitle("Recuperar Contraseña");
        this.setResizable(false);//  310,339
        this.setSize(385,175);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Contenedor con layout nulo
        Container cont=getContentPane();
        cont.setLayout(null);
        //
        GridLayout gInter=new GridLayout(1, 2);
        gInter.setHgap(10);
        gInter.setVgap(10);
        Panel pInter=new Panel(gInter);
        ////
        GridLayout gDos=new GridLayout(4, 1);
        gDos.setHgap(8);
        gDos.setVgap(8);
        Panel pDos=new Panel(gDos);
        /////
        GridLayout gUno=new GridLayout(4, 1);
        gUno.setHgap(8);
        gUno.setVgap(8);
        Panel pUno=new Panel(gUno);

        pUno.add(lblcedula);
        pUno.add(lblpregunta);
        pUno.add(lblrespuesta);
        pUno.add(bntconsultar);

        pDos.add(camCedula);
        pDos.add(comboPreguntas);
        pDos.add(camRespuesta);
        pDos.add(btnSalir);


        pInter.add(pUno);
        pInter.add(pDos);

        Panel p=new Panel(new BorderLayout());
        p.setSize(345,120);
        p.setLocation(10,10);
        p.add(pInter);
        add(p);


    }

    //evento escucha de las pulsaciones del teclado
    public void actionPerformed(ActionEvent e) {
        String op=e.getActionCommand();
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();

        System.out.println(String.valueOf(comboPreguntas.getSelectedItem()));
        System.out.println("Se termino la impresion............................");
        switch (op) {
            case "bntconsultar":
                //este bloque de codigo realiza las validaciones de los campos ingresados
                System.out.println("bntconsultar");
                List<String> datos = new ArrayList<>();
                //seleccion de los datos que se presentan el el comboBox
                datos = gestionAeroLinea.recuperarPassword(camCedula.getText(),
                        String.valueOf(comboPreguntas.getSelectedItem()),camRespuesta.getText());
                //comprobacion de la pregunta de seguridad
                if(datos.get(0).equals("")){
                    Object[] options = {"Aceptar"};
                    int n = JOptionPane.showOptionDialog(this,
                            "La cedula o la pregunta son incorrectas", "Error",
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                }else{
                    String imprimir = "Cedula: " + datos.get(0) + "\n Password: " + datos.get(1);

                    Object[] options = {"Aceptar"};
                    int n = JOptionPane.showOptionDialog(this,
                            imprimir, "Sus datos",
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                }

                break;
                //al pulsar salir volvera ala ventana de login
            case "salir":
                this.setVisible(false);
                LogIn logIn = new LogIn();
                logIn.init();
                logIn.setSize(300,350);
                logIn.setLocation(870,270);

            default:
                break;

        }

    }

}