package proyecto;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public class Pasajero extends Persona implements Datos{
    private int bus;
    private String destino, inicio;
    
    /**
     * Constructor de la clase Pasajero, que sirve para instanciar una variable mediante variables
     * @param bus
     * @param rut RUT del Pasajero (este tiene un valor unico)
     * @param nombre Nombre del Pasajero
     * @param edad Edad del Pasajero
     * @param destino
     * @param inicio
     */
    public Pasajero(String nombre, String rut, String edad, String inicio, String destino, int bus){
        super(nombre, rut, edad);
        this.bus = bus;
        this.destino = destino;
        this.inicio = inicio;
    }
    
    /**
     * Metodo getter que obtiene el asiento del pasajero
     * @return asiento que ocupara el pasajero en el bus
     */
    public int getBus() {
        return bus;
    }
    
    /**
     *  Metodo setter que ingresa el asiento del pasajero
     * @param asiento asiento que ocupa el pasajero
     */
    public void setBus(int asiento) {
        this.bus = asiento;
    }

    /**
     * Metodo getter que obtiene el destino del pasajero.
     * @return destino del pasajero
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Metodo setter que modifica el destino del pasajero.
     * @param destino destino del pasajero
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Metodo getter que obtiene el destino inicial que posee el pasajero.
     * @return destino inicial del pasajero.
     */
    public String getInicio() {
        return inicio;
    }
    
    /**
     * Metodo setter que modifica el destino inicial del pasajero.
     * @param inicio destino inicial del pasajero.
     */
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    /**
     * Metodo que muestra por pantalla los datos de los pasajeros mediante el numero de RUT.
     */
    @Override
    public String mostrarPersonaPorRut() {
        String cadena = "";
        cadena += "RUT del Pasajero: " + getRut() + "\n";
        cadena += "Nombre del Pasajero: " + getNombre() + "\n\n";
        
        return cadena;
    }

    /**
     * Metodo que muestra por pantalla los datos de los pasajeros.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("RUT del pasajero: " + getRut() + "\n");
        System.out.println("Nombre del pasajero: " +getNombre() + "\n");
        System.out.println("Edad del pasajero: " +getEdad() + "\n");
        System.out.println("Bus del pasajero: N° " +bus + "\n");
        System.out.println("------------------------------------------------");
    }

    /**
     * Metodo que retorna una cadena con la informacion de los pasajero
     * @return cadena con la informacion del pasajero
     */
    @Override
    public String cadenaDatos() {
        String cadena="";
        cadena+= "RUT del pasajero: "+getRut()+"\n";
        cadena+= "Nombre del pasajero: "+getNombre()+"\n";
        cadena+= "Edad del pasajero: "+getEdad()+"\n";
        cadena+= "Bus del pasajero:  "+bus+"\n\n"; 
        return cadena;
    }    
}
