
package CTaxi;

import java.util.Date;

/**
 *  Clase para los dueños de autos con RFC
 * @author wozr
 * @version 0.1
 */
public class Dueño extends MiembroAsociacion{
    private String RFC; //Esto es solo de los dueños
    
    
    /**
     * Constructor de dueños de los taxis
     * @param nombre nombre del dueño
     * @param domicilio domicilio del dueño
     * @param licencia numero de licencia del dueño
     * @param ingreso fecha de ingresos del dueño a la associacion
     * @param email email del dueño
     * @param telefono numero de telefono del dueño
     * @param RFC rfc del dueño
     */
    public Dueño(String nombre, String domicilio, double licencia,
                Date ingreso, String email, double telefono, String RFC) {
        super(nombre, domicilio, licencia, ingreso, email, telefono);
        this.RFC = RFC; //aqui la diferecia de dueño y chofer en la version 0.1
    }

    /* Metodos de acceso y modificaion de su rfc*/
    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    @Override
    public String toString() {
        String infBasica = super.toString();
        return "Due\u00f1o:\n" 
                + infBasica 
                + "RFC= " + RFC + "\n";
    }

    
    
    
}
