
package CTaxi;

import java.util.Date;

/**
 * Prototipo todo aqui
 * @author wozr
 * @version 0.1
 */
public class Chofer extends MiembroAsociacion{

    /**
     * MAmes, constructor de un chofer
     * @param nombre Nombre completo del chofer
     * @param domicilio Domicilio del chofer
     * @param licencia Numero de licencia del chofer
     * @param ingreso Fecha (Date) en que ingreso a la associacion
     * @param email Email del chofer
     * @param telefono numero de telefono
     */
    public Chofer(String nombre, String domicilio, String licencia,
                Date ingreso, String email, String telefono) {
        super(nombre, domicilio, licencia, ingreso, email, telefono);
    }

    @Override
    public String toString() {
        String infBasica = super.toString();
        return "Chofer:\n"+
                infBasica;
    }
    
    
    
}
