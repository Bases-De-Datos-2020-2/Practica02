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
 * CSV choferes
 * @author wozr
 */
public class ChoferesCSV {
    /**
     * Metodo para escribir en archivos csv la inf de los choferes
     * @param choferes manejo de una lista de objetos Taxi
     */
    public void exportarChoferesCSV(ArrayList<Chofer> choferes){
        String salidaArchivo = "Choferes.csv";
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
            //no necesitan los RFC
            
            salidaCSV.endRecord();
            
            //Recorremos la lista y lo insertamos en el archivo
            for (Chofer chofer : choferes) {//foreach sabrosongo
                salidaCSV.write(chofer.getNombre());
                salidaCSV.write(chofer.getDomicilio());
                salidaCSV.write(chofer.getLicenciaDeConducir());
                salidaCSV.write(chofer.getIngresoAsociacion().toString());
                salidaCSV.write(chofer.getEmail());
                salidaCSV.write(chofer.getTelefono());
                //sin RFC los choferes
               
                salidaCSV.endRecord(); //end esa fila
            }
            
            salidaCSV.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
         
    }//end exportar
    
    
    /**
     * Metodo para recuperar la inf de los archivos csv choferes
     * @return un arrayList de choferes
     */
    public ArrayList<Chofer> importarChoferesCSV() {
        ArrayList<Chofer> choferes = new ArrayList();
        try {
            
            CsvReader leeChofer = new CsvReader("Choferes.csv");
            leeChofer.readHeaders();

            //mientras tenga que leer obtiene choferes
            while (leeChofer.readRecord()) {
                //inf cruda del chofer
                String nombre = leeChofer.get(0);
                String domicilio = leeChofer.get(1);
                String numLicencia = leeChofer.get(2);
                String ingresoAsociasion = leeChofer.get(3);
                String email = leeChofer.get(4);
                String telefono = leeChofer.get(5);
                
                Date date = new Date(ingresoAsociasion);

                /*
                Aqui hay una perdida indirecta de informacion,
                estas tablas no estan relacionadas automaticamente
                se podria solucionar mas facilmente con objetos serializables,
                pero el ayudante y sus moños */
                
                Chofer actChofer = new Chofer(nombre, domicilio, numLicencia,
                date, email, telefono);
                //a la lista
                choferes.add(actChofer);

            }//end while

            leeChofer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();//un clasico
        } catch (IOException e) {
            e.printStackTrace();
        }
        //regresamos esta lista para multiples cosas
        return choferes;
    }
    
    /**
     * Un despliegue de choferes de la lista
     * @param choferes 
     */
    public void desplegarListaChofer(ArrayList<Chofer> choferes){
        for (Chofer chofer: choferes) {
            System.out.println(chofer);//ya tu sabhe tu estring(toString)
        }
    }
}
