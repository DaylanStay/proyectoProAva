package proyecto;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public abstract class  Persona {
    private String nombre;
    private String rut;
    private String edad;

    /**
     * Constructor de la clase Persona que sirve para instanciar una variable mediante variables
     * @param nombre nombre de la Persona
     * @param rut rut de la Persona
     * @param edad edad de la Persona
     */
    public Persona(String nombre, String rut, String edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
    }
    
    /**
     * Constructor de la clase Persona que sirve para instanciar una variable
     */
    public Persona(){
    }

    /**
     * Metodo getter que obtiene el nombre de la persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setter que ingresa el nombre de la persona
     * @param nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getter que obtiene el rut de la persona
     * @return rut de la persona
     */
    public String getRut() {
        return rut;
    }

    /**
     * Metodo setter que ingresa el rut de la persona
     * @param rut de la persona
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Metodo getter que obtiene la edad de la persona
     * @return edad de la persona
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Metodo setter que ingresa la edad de la persona
     * @param edad de la persona
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    /**
     * Metodo que muestra a las personas por rut.
     */
    public abstract void mostrarPersonaPorRut();
}
