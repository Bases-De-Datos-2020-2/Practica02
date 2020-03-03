
package CTaxi;

import java.util.Date;

/**
 * Super clase para los Choferes y los Dueños
 * @author wozr
 * @version 0.1
 * A que hora se nos aparecio la ATUCU para encargarnos sus mamadas
 * a weyes que empiezan en este pedo y lo mas mamon es que quieren un 
 * portotipo XD
 */
public abstract class MiembroAsociacion {
    protected String nombre;
    protected String domicilio;
    protected String licenciaDeConducir;
    protected Date ingresoAsociacion;
    //foto como chingados?
    protected String email;
    protected String telefono;

    public MiembroAsociacion(String nombre, String domicilio, 
            String licenciaDeConducir, Date ingresoAsociacion, 
            String email, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.licenciaDeConducir = licenciaDeConducir;
        this.ingresoAsociacion = ingresoAsociacion;
        this.email = email;
        this.telefono = telefono;
    }
    
    
    
    /*Metodo de acceso aqui*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLicenciaDeConducir() {
        return licenciaDeConducir;
    }

    public void setLicenciaDeConducir(String licenciaDeConducir) {
        this.licenciaDeConducir = licenciaDeConducir;
    }

    public Date getIngresoAsociacion() {
        return ingresoAsociacion;
    }

    public void setIngresoAsociacion(Date ingresoAsociacion) {
        this.ingresoAsociacion = ingresoAsociacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //Fin de los metodos de modificacion y acceso

    @Override
    public String toString() {
        return "Nombre= " + nombre + "\n"
                +"Domicilio= " + domicilio + "\n"
                +"Numero de Licencia de Conducir= " + licenciaDeConducir + "\n"
                +"Fecha de ingreso a la Asociacion= " + ingresoAsociacion + "\n"
                +"Email= " + email + "\n"
                +"Numero de telefono= " + telefono + "\n";
    }
    
}
