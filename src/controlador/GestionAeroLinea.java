package controlador;

import modelo.ModeloCliente;
import modelo.ModeloEmpleado;
import modelo.ModeloKardex;
import modelo.ModeloVuelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GestionAeroLinea {
    public GestionAeroLinea(){}

    private ConexionAgente conexionAgente;
    private ConexionAdministrador conexionAdministrador;

    private SentenciasAgente sentenciasAgente;
    private SentenciasAdministrador sentenciasAdministrador;

    /*
    |
    |
    |       METODOS DE COMPROBACION
    |
    |
     */

    public boolean validarFecha(String fecha){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try{
            dateFormat.parse(fecha.trim());

        }catch (ParseException pe){
            return false;
        }
        return true;
    }


    /*
    |
    |
    |   Empieza todas las sentencias del Agente de ventas
    |
    |
     */

    /**
     * para borrar a un cliente a este metodo se le pasa como parametro
     * el id del cliente que se va a borrar
     * @param id
     */
    public void borrarCliente(int id){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();

        if(conexionAgente.getConnection()!=null) {
            System.out.println("Conexion agente correcta (Borrado)");
            sentenciasAgente = new SentenciasAgente();
            sentenciasAgente.borrarCliente(conexionAgente, id);
        }else
            System.out.println("Error al conectar con agente (Borrado)");
    }

    /**
     * Los parametros para la actualizacion seran los siguientes:
     * @param id
     * @param nombre
     * @param cedula
     * @param direccion
     * @param fecha
     */
    public void actualizarCliente(int id, String nombre, String cedula, String direccion,
                                  String fecha){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();

        if(conexionAgente.getConnection()!=null){
            System.out.println("Conexion agente correcta (Actualizacion)");
            sentenciasAgente = new SentenciasAgente();
            sentenciasAgente.actualizarCliente(conexionAgente, id, nombre, cedula, direccion, fecha);
        }else
            System.out.println("Error al conectar con agente (Actualizacion)");
    }

    /**
     * Este metodo registra a un nuevo cliente en la base de datos y recibira los siguientes para metros
     * @param nombre
     * @param cedula
     * @param direccion
     * @param fecha
     */
    public void crearCliente(String nombre, String cedula, String direccion, String fecha){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();

        if(conexionAgente.getConnection()!= null){
            System.out.println("Conexion agente de ventas correcta");
            sentenciasAgente = new SentenciasAgente();
            sentenciasAgente.crearCliente(conexionAgente, nombre, cedula, direccion, fecha);
        }else
            System.out.println("Error al conectar Agente de ventas");
        conexionAgente.Desconectar();
    }

    /**
     * Metodo donde se otendra una lista de clientes es un metodo dinamico
     * donde se hara uso en el momento de comparar los poles en la ventana de login
     * @return
     */
    public List<ModeloCliente> clienteList(){
        List<ModeloCliente> modeloClientes = new ArrayList<>();
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();

        if(conexionAgente.getConnection()!= null){
            System.out.println("Conexion agente de ventas correcta");
            sentenciasAgente = new SentenciasAgente();
            modeloClientes = sentenciasAgente.clienteList(conexionAgente);
        }else{
            System.out.println("Error al conectar Agente de ventas");
        }
        conexionAgente.Desconectar();

        return modeloClientes;

    }


    /*
    |
    |
    |   ~~~~ Empieza todas las sentencias del Administrador del sistema
    |
    |
     */

    /**
     * Este metodo eliminara el vuelo espacificado mediante id que corresopnde al destino que
     * se selecciono el usuario por medio de la interfaz
     * @param vuelo
     */
    public void eliminarVuelos(String vuelo){
        int vueId = Integer.parseInt(vuelo);
        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();

        if(conexionAdministrador.getConnection() != null){
            System.out.println("Conexion administrador correcta");
            sentenciasAdministrador = new SentenciasAdministrador();
            sentenciasAdministrador.eliminarVuelo(conexionAdministrador, vueId);
        }else
            System.out.println("Error al momento de conexion con la base de datos");
    }

    /**
     * En este metodo se obtiene de la base de datos los vuelos disponible especificando
     * el destino donde el cliente desea viajar, este metodo retornara una lista de tipo vuelos
     * @param destino
     * @return
     */
    public List<ModeloVuelos> listarVuelosPorDestino(String destino) {
        List<ModeloVuelos> datos = new ArrayList<>();
        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();

        if(conexionAdministrador.getConnection()!= null){
            System.out.println("Conexion administrador correcta");
            sentenciasAdministrador = new SentenciasAdministrador();
            datos = sentenciasAdministrador.listarVuelosPorDestino(conexionAdministrador, destino);
        }else{
            System.out.println("Conexion amdinistrador incorrecta");
        }
        conexionAdministrador.Desconectar();
        return datos;
    }


    /**
     * Este metodo realizara la consulta de los datos que pertenecen al prpducto para conocer su respectivo kardex, para
     * realizar la consulta se enviara como parametro el destino y retornara la informacion respectiva
     * @param destino
     * @return
     */
    public List<ModeloKardex> listarKardex(String destino) {

        List<ModeloKardex> datos = new ArrayList<>();


        /*
        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();

        if(conexionAdministrador.getConnection()!= null){
            System.out.println("Conexion administrador correcta");
            sentenciasAdministrador = new SentenciasAdministrador();
            datos = sentenciasAdministrador.listarVuelosPorDestino(conexionAdministrador, destino);
        }else{
            System.out.println("Conexion amdinistrador incorrecta");
        }
        conexionAdministrador.Desconectar();
        */

        ModeloKardex k=new ModeloKardex();
        k.setFecha("12-21-1999");
        k.setDetalle("lorena");
        k.setE_cantidad("aiubvasdkn");

        ModeloKardex k1=new ModeloKardex();
        k1.setFecha("10-09-1200");
        k1.setDetalle("natalia");
        k1.setE_cantidad("KDUJFB");

        ModeloKardex k2=new ModeloKardex();
        k2.setFecha("21-02-2010");
        k2.setDetalle("POLITA");
        k2.setE_cantidad("EOA FHN");

        ModeloKardex k3=new ModeloKardex();
        k3.setFecha("21-12-2009");
        k3.setDetalle("ESTEBAN");
        k3.setE_cantidad("NNWEB234");

        ModeloKardex k4=new ModeloKardex();
        k4.setFecha("12-21-1278");
        k4.setDetalle("PEDRO Y LORENA ");
        k4.setE_cantidad("Q48TQHW");

        datos.add(k);
        datos.add(k1);
        datos.add(k2);
        datos.add(k3);
        datos.add(k3);
        datos.add(k4);

        return datos;
    }

    /**
     * Este metodo actualizara los vuelos esta funcionalidad es llamada desde el interfaz de menu administrador
     * ya que este tendra permisos para realizar esta actualizacion los parametros que reciben son los siguientes
     * parametros
     * @param id
     * @param capacidad
     * @param hSalida
     * @param hLlegada
     * @param tipo
     * @param costo
     * @param paeroSalida
     * @param paeroLlegada
     * @param avion
     * @param fSalida
     * @param fLlegada
     */
    public void actualizarVuelos(String id, String capacidad, String hSalida,
                                 String hLlegada, String tipo, String costo, String paeroSalida, String paeroLlegada,
                                 String avion, String fSalida, String fLlegada) {
        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();

        if(conexionAdministrador.getConnection()!=null){
            System.out.println("Conexion administrador correcta");
            sentenciasAdministrador = new SentenciasAdministrador();
            sentenciasAdministrador.actualizarVuelos(conexionAdministrador, id, capacidad, hSalida, hLlegada, tipo,
                    costo, paeroSalida, paeroLlegada, avion, fSalida, fLlegada);
        }else{
            System.out.println("Conexion administrador incorrecta");
        }
        conexionAdministrador.Desconectar();

    }

    /**
     * Metodo donde se realizara un regitro de usuario del sistema en este metodo se puede considerar que el atributo
     * mas importante es el rol que desempeñara el nuevo usuario los parametros seran los siguientes
     * @param pCedula
     * @param pNombre
     * @param pApellido
     * @param pPassword
     * @param pPregunta
     * @param pRespuesta
     * @param pRol
     */
    public void crearUsuario(String pCedula, String pNombre, String pApellido,
                             String pPassword, String pPregunta, String pRespuesta, String pRol){

        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();

        if(conexionAdministrador.getConnection()!= null){
            System.out.println("Conexion administrador correcta");
            sentenciasAdministrador = new SentenciasAdministrador();
            sentenciasAdministrador.crearUsuario(conexionAdministrador, pCedula, pNombre, pApellido, pPassword,
                    pPregunta, pRespuesta, pRol);
        }else{
            System.out.println("Conexion amdinistrador incorrecta");
        }
        conexionAdministrador.Desconectar();

    }

    /**
     * Metodo que obrendra de la base de datos los empleados que existen registrados en el sistema
     * se retornara una lista de tipo empleado
     * @return
     */
    public List<ModeloEmpleado> obtenerEmpleados(){
        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();
        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();
        sentenciasAdministrador = new SentenciasAdministrador();

        if(conexionAdministrador.getConnection() != null) {
            System.out.println("Conexion administrador correcta...");
            modeloEmpleadoList = sentenciasAdministrador.obtenerEmpleados(conexionAdministrador);
        }else{
            System.out.println("La conexion no se ha realizado correctamente");
        }
        conexionAdministrador.Desconectar();


        return modeloEmpleadoList;
    }

    /**
     * Metodo que retornara una lista donde se especifican los destinos que el sistema tiene registrados en su base de
     * datos
     * @return
     */
    public List<String> destinos(){

        List<String> datos = new ArrayList<>();

        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();
        sentenciasAdministrador = new SentenciasAdministrador();


        if(conexionAdministrador.getConnection() != null){
            System.out.println("Conexion administrador correcta...");
            datos = sentenciasAdministrador.listarDestinos(conexionAdministrador);
        }else{
            System.out.println("La conexion no se ha realizado correctamente");
        }
        conexionAdministrador.Desconectar();


        return datos;
    }

    /**
     * Este metodo realizara una conexion con la base de datos donde se obtendar las credenciales del usuario
     * que haya ingresado en la funcionalidad de recuperar la contraseña los parametros de entrada seran:
     * @param cedula
     * @param pregunta
     * @param respuesta
     * @return
     */
    public List<String> recuperarPassword(String cedula, String pregunta, String respuesta){
        List<ModeloEmpleado> modeloEmpleadoList = new ArrayList<>();
        List<String> datos = new ArrayList<>();

        conexionAdministrador = new ConexionAdministrador();
        conexionAdministrador.Conectar();
        sentenciasAdministrador = new SentenciasAdministrador();

        String retCedula = "";
        String retPassword = "";

        if(conexionAdministrador.getConnection() != null){
            System.out.println("Conexion administrador correcta...");
            modeloEmpleadoList = sentenciasAdministrador.recuperarPass(conexionAdministrador);
        }else{
            System.out.println("La conexion no se ha realizado correctamente");
        }
        conexionAdministrador.Desconectar();

        System.out.println(cedula + "<<" + pregunta + "<<"+ respuesta+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for (int i = 0; i < modeloEmpleadoList.size(); i++) {
            String password1 = modeloEmpleadoList.get(i).getPassword();
            String cedula1 = modeloEmpleadoList.get(i).getCedula();
            String pregunta1 = modeloEmpleadoList.get(i).getPregunta();
            String respuesta1 = modeloEmpleadoList.get(i).getRespuesta();

            if(cedula1.equals(cedula) && pregunta1.equals(pregunta) && respuesta1.equals(respuesta)) {
                retPassword = password1;
                retCedula = cedula1;
                break;
            }
        }

        datos.add(retCedula);
        datos.add(retPassword);

        return datos;
    }

}
