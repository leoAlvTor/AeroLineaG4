package controlador;

import modelo.ModeloCliente;
import modelo.ModeloEmpleado;
import modelo.ModeloVuelos;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;


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


    public int comprobarTarjeta(BigInteger numero) {
        String cmp = String.valueOf(numero);

        char val1 = cmp.charAt(0);
        if(cmp.length() >0) {
            switch (val1) {
                case '4':
                    return 1;
                case '5':
                    return 2;
                case '6':
                    return 3;
                case '3':
                    return 4;
                default:
                    return 0;
            }
        }else
            return 0;
    }

    public int tipoPasajero(String fechaAct, String fechaNac){
        int years = 0;
        try {
            Date fechaActual = new SimpleDateFormat("dd/MM/yyyy").parse(fechaAct);
            Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);

            long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();
            years = (int) ((diferencia/(24*60*60*1000))/365);
            System.out.println("Cantidad de dias transcurridos: "+ years);
        }catch (Exception e) {
            e.printStackTrace();

        }

        if(years  <= 2){
            return 1;
        }else if(years >= 65){
            return 2;
        }else if(years > 2 && years < 18){
            return 3;
        }else if(years >=18 && years < 65) {
            return 4;
        }
        return years;
    }

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

    public void reporteFecha(){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();
        List<String> reporte = new ArrayList<>();
        if(conexionAgente.getConnection() != null){
            System.out.println("Conexion agente para reporte");
            sentenciasAgente = new SentenciasAgente();
            reporte = sentenciasAgente.reporteFecha(conexionAgente);

            for (int i = 0; i < reporte.size(); i++) {
                System.out.println(reporte.get(i));
            }



        }else{
            System.out.println("Error conexion agente para rporte");
        }
        conexionAgente.Desconectar();
    }

    public void insertarCabeceraDetalle(String fecha, double costo, int cliente, int empleado,
                                         String asiento, String tipoPasajero, int codigoVuelos){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();
        if(conexionAgente.getConnection()!= null){
            System.out.println("Conexion agente correcta");
            sentenciasAgente = new SentenciasAgente();
            sentenciasAgente.insertarCabeceraDetalle(conexionAgente, fecha, costo, cliente, empleado, asiento,
                    tipoPasajero, codigoVuelos);
        }else
            System.out.println("error cabecera detalle");
        conexionAgente.Desconectar();
    }

    public List<String> asientosDisponibles(int idVuelo){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();
        List<String> asientos = new ArrayList<>();

        if(conexionAgente.getConnection() != null){
            System.out.println("Conexion agente correcta (Asientos disponibles)");
            sentenciasAgente = new SentenciasAgente();
           asientos = sentenciasAgente.asientosDisponibles(conexionAgente, idVuelo);
        }else
            System.out.println("Error al conectar con agente (Asientos disponibles)");
        conexionAgente.Desconectar();
        return asientos;
    }

    public void borrarCliente(int id){
        conexionAgente = new ConexionAgente();
        conexionAgente.Conectar();

        if(conexionAgente.getConnection()!=null) {
            System.out.println("Conexion agente correcta (Borrado)");
            sentenciasAgente = new SentenciasAgente();
            sentenciasAgente.borrarCliente(conexionAgente, id);
        }else
            System.out.println("Error al conectar con agente (Borrado)");
        conexionAgente.Desconectar();
    }

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
        conexionAgente.Desconectar();
    }

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
