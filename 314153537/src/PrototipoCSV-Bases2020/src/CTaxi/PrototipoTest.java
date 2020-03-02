package CTaxi;

import java.util.Date;

/**
 * Clase test para probar los objetos y archivos
 * Habria que mejorar manejos de numeros de telefonos y licencia
 * tambien el manaejo de la fecha
 * @author wozr
 */
public class PrototipoTest {
    public static void main(String [] args){
        
        Date today = new Date();
        
        Chofer chofer = new Chofer("Jaime", "La wea Cuatica",
        123456, today, "jaimeChofer@chofer.com", 55422311);
        
        //realmete los dueños necesitan un numero de licencia?
        Dueño dueño = new Dueño("Jose luis", "Fondo de bikini",
        54321, today, "joseLuisChofer@dueño.com", 55112335, "JOKJ8902281TO");
        
        Taxi taxi = new Taxi("Mustang", "Ford", 2020, 4, 4, false, dueño);
        
        
        System.out.println("El chofer es:");
        System.out.println(chofer);
        System.out.println("Y el taxi es:");
        System.out.println(taxi);
    }
}
