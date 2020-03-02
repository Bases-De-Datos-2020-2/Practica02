
package CTaxi;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Manejo csv de dueños, podria haber una interfaz en estos metodos
 * pero este prototipo no lo vamos a seguir desarrollando con archivos
 * @author wozr
 */
public class DueñosCSV {
    /**
     * Metodo para escribir en archivos csv la inf de los dueños
     * @param dueños manejo de una lista de objetos Taxi
     */
    public void exportarDueñosCSV(ArrayList<Dueño> dueños){
        String salidaArchivo = "Dueños.csv";
        boolean existe = new File(salidaArchivo).exists();
        
        
        //si ya existe el archivo lo borrara
        if (existe) {
            File archivoTaxis = new File(salidaArchivo);
            archivoTaxis.delete();
        }
        
        //creamos el archivo
        try{
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true),
                    ',');
            
            
            //identificamos las columnas
            
            
            salidaCSV.write("Nombre");
            salidaCSV.write("Domicilio");
            salidaCSV.write("Numero de licencia");
            salidaCSV.write("Fecha de ingreso a la asociacion");
            salidaCSV.write("Email");
            salidaCSV.write("telefono");
            salidaCSV.write("RFC");
            
            salidaCSV.endRecord();
            
            //Recorremos la lista y lo insertamos en el archivo
            for (Dueño dueño : dueños) {//foreach sabrosongo
                salidaCSV.write(dueño.getNombre());
                salidaCSV.write(dueño.getDomicilio());
                salidaCSV.write(dueño.getLicenciaDeConducir());
                salidaCSV.write(dueño.getIngresoAsociacion().toString());
                salidaCSV.write(dueño.getEmail());
                salidaCSV.write(dueño.getTelefono());
                salidaCSV.write(dueño.getRFC());
               
                salidaCSV.endRecord(); //end esa fila
            }
            
            salidaCSV.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
         
    }//end exportar
    
    
    /**
     * Metodo para recuperar la inf de los archivos csv dueños
     * @return un arrayList de dueños
     */
    public ArrayList<Dueño> importarDueñosCSV() {
        ArrayList<Dueño> dueños = new ArrayList();
        try {
            
            CsvReader leeDueño = new CsvReader("Dueños.csv");
            leeDueño.readHeaders();

            //mientras tenga que leer obtiene dueños
            while (leeDueño.readRecord()) {
                //inf cruda del dueño
                String nombre = leeDueño.get(0);
                String domicilio = leeDueño.get(1);
                String numLicencia = leeDueño.get(2);
                String ingresoAsociasion = leeDueño.get(3);
                String email = leeDueño.get(4);
                String telefono = leeDueño.get(5);
                String RFC = leeDueño.get(6);
                
                Date date = new Date(ingresoAsociasion);

                /*
                Aqui hay una perdida indirecta de informacion,
                estas tablas no estan relacionadas automaticamente
                se podria solucionar mas facilmente con objetos serializables,
                pero el ayudante y sus moños */
                
                Dueño actDueño = new Dueño(nombre, domicilio, numLicencia,
                date, email, telefono, RFC);
                //a la lista
                dueños.add(actDueño);

            }//end while

            leeDueño.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();//un clasico
        } catch (IOException e) {
            e.printStackTrace();
        }
        //regresamos esta lista para multiples cosas
        return dueños;
    }
    
    /**
     * Un despliegue de dueños de la lista
     * @param dueños 
     */
    public void desplegarListaDueños(ArrayList<Dueño> dueños){
        for (Dueño dueño: dueños) {
            System.out.println(dueño);//ya tu sabhe tu estring(toString)
        }
    }
}
