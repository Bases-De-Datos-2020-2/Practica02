
package CTaxi;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que guardara la informacion de los taxis en archivos csv
 * @author wozr
 * @version 0.1
 */
public class TaxisCSV {
    
    
    /**
     * Metodo para escribir en archivos csv la inf de los taxis
     * @param taxis manejo de una lista de objetos Taxi
     */
    public void exportarTaxisCSV(ArrayList<Taxi> taxis){
        String salidaArchivo = "Taxis.csv";
        boolean existe = new File(salidaArchivo).exists();
        
        
        //si ya existe el archivo lo borrara
        if (existe) {
            File archivoTaxis = new File(salidaArchivo);
            archivoTaxis.delete();
        }
        
        //creamos el archivo
        try{
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            
            //identificamos las columnas
            salidaCSV.write("Modelo");
            salidaCSV.write("Marca");
            salidaCSV.write("Año del vehiculo");
            salidaCSV.write("Numero de cilindros");
            salidaCSV.write("Numero de puertas");
            salidaCSV.write("¿Tiene llanta de refaccion?");
            salidaCSV.write("Dueño");//Aqui solo desplegara el nombre del dueño
            
            salidaCSV.endRecord();
            
            //Recorremos la lista y lo insertamos en el archivo
            for (Taxi taxi : taxis) {//foreach sabrosongo
                salidaCSV.write(taxi.getModelo());
                salidaCSV.write(taxi.getMarca());
                salidaCSV.write(String.valueOf(taxi.getAñoVehicuo()));
                salidaCSV.write(String.valueOf(taxi.getNumCilindros()));
                salidaCSV.write(String.valueOf(taxi.getNumPuertas()));
                salidaCSV.write(String.valueOf(taxi.isLlantaRefaccion()));
                salidaCSV.write(taxi.getDueño().getNombre());
                //la modificacion aqui es por objetos
                //suguie la estategia de fuerza fruta
                
                salidaCSV.endRecord(); //end
            }
            
            salidaCSV.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
         
    }//end exportar
    
    
    /**
     * Metodo para recuperar la inf de los archivos csv taxis
     * @return un arrayList de taxis
     */
    public ArrayList<Taxi> importarTaxisCSV() {
        ArrayList<Taxi> taxis = new ArrayList();
        try {
            
            CsvReader leeTaxi = new CsvReader("Taxis.csv");
            leeTaxi.readHeaders();

            //mientras tenga que leer obtiene taxis
            while (leeTaxi.readRecord()) {
                //inf cruda del taxi
                String modelo = leeTaxi.get(0);
                String marca = leeTaxi.get(1);
                String añoVehiculo = leeTaxi.get(2);
                String numCilindros = leeTaxi.get(3);
                String numPuertas = leeTaxi.get(4);
                String hasRefraccion = leeTaxi.get(5);
                String nomDueño = leeTaxi.get(6);

                boolean refraccion = Boolean.valueOf(hasRefraccion);

                /*
                Aqui hay una perdida indirecta de informacion,
                estas tablas no estan relacionadas automaticamente
                se podria solucionar mas facilmente con objetos serializables,
                pero el ayudante y sus moños */
                Taxi actTaxi = new Taxi(modelo, marca, Integer.valueOf(añoVehiculo),
                        Integer.valueOf(numCilindros),
                        Integer.valueOf(numPuertas), refraccion, new Dueño(nomDueño));

                //a la lista
                taxis.add(actTaxi);

            }//end while

            leeTaxi.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();//un clasico
        } catch (IOException e) {
            e.printStackTrace();
        }
        //regresamos esta lista para multiples cosas
        return taxis;
    }
    
    /**
     * Un despliegue de taxis de la lista
     * @param taxis 
     */
    public void desplegarListaTaxis(ArrayList<Taxi> taxis){
        for (Taxi taxi: taxis) {
            System.out.println(taxi);//ya tu sabhe tu estring(toString)
        }
    }
    
}
