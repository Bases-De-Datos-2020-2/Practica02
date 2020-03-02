
package CTaxi;

/**
 * Clase de los vehiculos de la associacion
 * @author wozr
 * @see Dueño
 */
public class Taxi {
    
    ////pues ya tu sabhe, atritubutos/inf. de los coches/taxis/pollaTaxis
    private String modelo; //modelo del coche claro
    private String marca; 
    private int añoVehicuo;
    private int numCilindros;
    private int numPuertas;
    private boolean llantaRefaccion;
    
    //Cada taxi tiene un dueño,pues si
    private Dueño dueño;

    /**
     * Constructor de los taxis
     * @param modelo modelo del auto
     * @param marca marca del auto
     * @param añoVehicuo año del auto
     * @param numCilindros numero de cilindros ¿pa k chingaos?
     * @param numPuertas numero de puertas
     * @param llantaRefaccion si tiene llanta de refaccion
     * @param dueño Quien es su dueño
     */
    public Taxi(String modelo, String marca, int añoVehicuo, int numCilindros, 
            int numPuertas, boolean llantaRefaccion, Dueño dueño) {
        this.modelo = modelo;
        this.marca = marca;
        this.añoVehicuo = añoVehicuo;
        this.numCilindros = numCilindros;
        this.numPuertas = numPuertas;
        this.llantaRefaccion = llantaRefaccion;
        this.dueño = dueño;
    }
 
    
    /* Metodos de acceso */
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAñoVehicuo() {
        return añoVehicuo;
    }

    public void setAñoVehicuo(int añoVehicuo) {
        this.añoVehicuo = añoVehicuo;
    }

    public int getNumCilindros() {
        return numCilindros;
    }

    public void setNumCilindros(int numCilindros) {
        this.numCilindros = numCilindros;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public boolean isLlantaRefaccion() {
        return llantaRefaccion;
    }

    public void setLlantaRefaccion(boolean llantaRefaccion) {
        this.llantaRefaccion = llantaRefaccion;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    //los toSting serviran para desplegar la informacion
    @Override
    public String toString() {
        
        return "Taxi:\n" 
                + "Modelo= " + modelo + "\n"
                + "Marca= " + marca + "\n"
                + "A\u00f1o del Vehicuo= " + añoVehicuo + "\n"
                +"Numero de Cilindros= " + numCilindros + "\n"
                +"Numero de Puertas= " + numPuertas + "\n"
                +"¿Tiene llanta de refaccion?= " + (llantaRefaccion? "Si" : "No") + "\n"
                + "Due\u00f1o:\n "
                + dueño + "\n";
                
    }
    
    
    
}
