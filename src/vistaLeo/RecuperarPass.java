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

    private JLabel lblcedula;
    private JLabel lblpregunta;
    private JLabel lblrespuesta;

    private JTextField camCedula;
    private JTextField camPregunta;
    private JTextField camRespuesta;

    private JButton bntconsultar;

    private JComboBox comboPreguntas;

    private String[] preguntas = {"Ciudad de nacimiento", "Primer colegio"};


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
        ///

        initComponentes();
    }

    private void initComponentes() {
        setVisible(true);
        this.setTitle("Recuperar Contraseña");
        this.setResizable(false);//  310,339
        this.setSize(385,175);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //
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


        pInter.add(pUno);
        pInter.add(pDos);

        Panel p=new Panel(new BorderLayout());
        p.setSize(345,120);
        p.setLocation(10,10);
        p.add(pInter);
        add(p);


    }


    public void actionPerformed(ActionEvent e) {
        String op=e.getActionCommand();
        GestionAeroLinea gestionAeroLinea = new GestionAeroLinea();

        System.out.println(String.valueOf(comboPreguntas.getSelectedItem()));
        System.out.println("Se termino la impresion............................");
        switch (op) {
            case "bntconsultar":
                System.out.println("bntconsultar");
                List<String> datos = new ArrayList<>();
                datos = gestionAeroLinea.recuperarPassword(camCedula.getText(),
                        String.valueOf(comboPreguntas.getSelectedItem()),camRespuesta.getText());

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

            default:
                break;

        }

    }

}