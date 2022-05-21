package proyecto;

public abstract class  Persona {
    private String nombre;
    private String rut;
    private String edad;

    public Persona(String nombre, String rut, String edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
    }
    
    public Persona(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public abstract void mostrarPersonaPorRut();
}
