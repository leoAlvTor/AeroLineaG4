package vistaLeo;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controlador.*;

public class vntRegCliente extends JFrame implements ActionListener {

	private JLabel lblCedula,lblNombre, lblApellido, lblFecha_nac, lblDireccion;
	private JTextField camCedula, camNombre,camApellido, camFecha_nac,camDireccion;
	private JButton btnReg, btnCancel;
	public vntRegCliente() {

		lblCedula = new JLabel("Cedula:");
		lblNombre = new JLabel("Nombre:");
		lblApellido = new JLabel("Apellido:");
		lblDireccion=new JLabel("Direccion:");
		lblFecha_nac = new JLabel("Fecha Nacimiento:");
		/////////
		camCedula = new JTextField();
		camNombre=new JTextField();
		camApellido = new JTextField();
		camDireccion =new JTextField();
		camFecha_nac = new JTextField();
		////////
		btnCancel=new JButton("Cancelar");
		btnCancel.setActionCommand("btnCancel");
		btnCancel.addActionListener(this);
		btnReg=new JButton("Registrar");
		btnReg.setActionCommand("btnReg");
		btnReg.addActionListener(this);
		init();
		
	}

	private void init() {
	setTitle("Registrar Cliente");
	setSize(370,285);
	setLayout(null);
	setVisible(true);
	/**
	 * parametros de el gridLayout (numFilas , numColumnas , disHorizontal, disVertical)
	 */
	JPanel Prin=new JPanel(new GridLayout(1, 2, 10,0));
	JPanel pUno=new JPanel(new GridLayout(6, 1, 0,15 ));
	JPanel pDos=new JPanel(new GridLayout(6, 1, 0,15 ));
	///////
	pUno.add(lblCedula);
	pUno.add(lblNombre);
	pUno.add(lblApellido);
	pUno.add(lblDireccion);
	pUno.add(lblFecha_nac);
	pUno.add(btnReg);
	////////
	pDos.add(camCedula);
	pDos.add(camNombre);
	pDos.add(camApellido);
	pDos.add(camDireccion);
	pDos.add(camFecha_nac);
	pDos.add(btnCancel);
	/**
	 * parametros de el panel principal
	 * prin.setSize(ancho,alto);
	 * prin.setLocation(ubicacion X, ubicacion Y);
	 */
	Prin.add(pUno);
	Prin.add(pDos);
	Prin.setSize(300,200);
	Prin.setLocation(15,15);
	
	add(Prin);
	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String op=arg0.getActionCommand();
	
		switch (op) {
		case "btnReg":
			System.out.println(op);
			/**
			 * OJO AQUI FALTA CAPTURAR BIEN LOS DATOS DEL CLIENTE
			 */
			GestionAeroLinea gest=new GestionAeroLinea();
			String nombreApellido=camNombre.getText()+" ";
			nombreApellido=nombreApellido+camApellido.getText();
			
	        gest.ingresarCliente(nombreApellido,camCedula.getText(),
	        		
	        		camDireccion.getText(), camFecha_nac.getText());
			
			
			break;
		case "btnCancel":
			System.out.println(op);
			 MenuAdministrador menuAdministrador = new MenuAdministrador();
             menuAdministrador.setSize(600,500);
             menuAdministrador.ejecutar();
             dispose();
			break;

		default:
			break;
		}
		
	}
}
