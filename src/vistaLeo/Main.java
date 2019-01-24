package vistaLeo;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] leo){
        /*
        System.out.println();
        LogIn logIn = new LogIn();
        logIn.init();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        logIn.setLocation(dimension.width/2-logIn.getSize().width/2, dimension.height/2-logIn.getSize().height/2);

        logIn.setSize(290,340);


        MenuAgente menu = new MenuAgente();
        menu.setSize(500,500);
        menu.ejectuar();
*/
        PreFactura preFactura = new PreFactura();


        //VuelosVendidos vuelosVendidos = new VuelosVendidos();

       // FormaPago formaPago= new FormaPago();


            Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int a = calendar.get(Calendar.YEAR);
        int b = calendar.get(Calendar.MONTH);
        int c = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(a + " mes: " + b + " dia: "+ c);

    }
}
