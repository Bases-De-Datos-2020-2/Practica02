package CTaxi;

import java.util.ArrayList;
import java.util.Date;
/**
 * Clase test para probar los objetos y archivos
 * Habria que mejorar manejos de numeros de telefonos y licencia
 * tambien el manaejo de la fecha
 * 
 * La estategia sera recuperar la informacion de los archivos en una lista 
 * poder modificar esa lista y despues reescribir toda la informacion de la lista
 * al archivo, es pura fuerza bruta, pero es mas coñazo buscar directamente en
 * el archivo, ademas esto solo es prototipo para el ansias del Chuy, y vamos
 * a meterle duro a esto con una base de datos asi que no me cuestionen >:(
 * @author wozr
 * @version 0.1
 */
public class PrototipoTest {
    public static void main(String [] args){
        
        Date today = new Date();
        
        Chofer chofer1 = new Chofer("Jaime", "La wea Cuatica",
        "123456", today, "jaimeChofer@chofer.com", "55422311");
        
        //realmete los dueños necesitan un numero de licencia?
        Dueño dueño1 = new Dueño("Jose luis", "Fondo de bikini",
        "54321", today, "DonJoseLuis@dueño.com", "55112335", "JOKJ8902281TO");
        
        Taxi taxi1 = new Taxi("Mustang", "Ford", 2020, 4, 4, false, dueño1);
        
        Dueño dueño2 = new Dueño("Jose Alberto", "Fondo de bikini",
        "54432", today, "DonJoseAlberto@dueño.com", "5576545621", "JOKJ9003181TO");
        /*
        System.out.println("El chofer es:");
        System.out.println(chofer1);
        System.out.println("Y el taxi es:");
        System.out.println(taxi1);
        */
        
        
        System.out.println("Ahora provaremos con archivos");
        
        System.out.println("Los taxis");
        //objeto de archivos csv taxis
        TaxisCSV tcsv = new TaxisCSV();
        
        ArrayList<Taxi> taxis = new ArrayList();
        taxis.add(taxi1);
        taxis.add(new Taxi("Vampire", "Ferrary", 2021,8,4,false, dueño2));
        tcsv.exportarTaxisCSV(taxis);
        
        ArrayList taxisRecuperados = tcsv.importarTaxisCSV();
        tcsv.desplegarListaTaxis(taxisRecuperados);
        
        
        System.out.println("Los Choferes");
        //Los choferes
        ChoferesCSV ccsv = new ChoferesCSV();
        ArrayList<Chofer> choferes = new ArrayList();
        choferes.add(chofer1);
        Date dateChofer = new Date();
        choferes.add(new Chofer("Jaimico", "PeriNorte", "345678", dateChofer,
                "jaimico123@chofer.com", "55789878"));
        
        ccsv.exportarChoferesCSV(choferes);
        
        ArrayList choferesRecuperados = ccsv.importarChoferesCSV();
        ccsv.desplegarListaChofer(choferesRecuperados);
        
        System.out.println("Los Dueños");
        DueñosCSV dcsv = new DueñosCSV();
        ArrayList<Dueño> dueños = new ArrayList();
        dueños.add(dueño1);
        dueños.add(dueño2);
        dcsv.exportarDueñosCSV(dueños);
        
        ArrayList<Dueño> dueñosRecuperados = dcsv.importarDueñosCSV();
        dcsv.desplegarListaTaxis(dueñosRecuperados);
        
    }
}
