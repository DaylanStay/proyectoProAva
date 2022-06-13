package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public class Bus implements Datos{
    //Variables de instancias
    private int numeroBus; 
    private String matricula;
    private String ciudadInicio;
    private String ciudadFinal;
    private final Map<String,Conductor> mapConductores;
    private final Map<String,Pasajero> mapPasajeros;
    //Metodo Constructor

    /**
     * Constructor de la clase Bus, usada para instanciar las variables
     * 
     * @param numeroBus numero del Bus
     * @param matricula matricula del Bus
     * @param ciudadInicio ciudad donde empieza el recorrido del Bus
     * @param ciudadFinal ciudad donde finaliza el recorrido del Bus
     */
    public Bus(int numeroBus, String matricula, String ciudadInicio, String ciudadFinal) {
        this.numeroBus = numeroBus;
        this.matricula = matricula;
        this.ciudadInicio = ciudadInicio;
        this.ciudadFinal = ciudadFinal;
        mapConductores = new HashMap();
        mapPasajeros = new HashMap();
    }
    
    //Metodos Getter & Setter
    //************************************************************************

    /**
     * Metodo getter que obtiene el numero de un bus
     * @return Numero del bus
     */
    public int getNumeroBus() {
        return numeroBus;
    }

    /**
     * Metodo setter que ingresa el numero de un bus
     * @param numeroBus numero del Bus
     */
    public void setNumeroBus(int numeroBus) {
        this.numeroBus = numeroBus;
    }

    /**
     * Metodo getter que obtiene la matricula del bus
     * @return Matricula del bus
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Metodo setter que ingresa la matricula del bus
     * @param matricula matricula del bus
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Metodo getter que obtiene la ciudad donde empieza el recorrido del Bus
     * @return Ciudad Inicial donde comienza el bus
     */
    public String getCiudadInicio() {
        return ciudadInicio;
    }

    /**
     * Metodo setter que ingresa la ciudad donde comienza el recorrido del Bus
     * @param ciudadInicio Ciudad Inicial donde comienza el bus
     */
    public void setCiudadInicio(String ciudadInicio) {
        this.ciudadInicio = ciudadInicio;
    }

    /**
     * Metodo getter que obtiene la ciudad donde termina el recorrido del bus
     * @return Ciudad final
     */
    public String getCiudadFinal() {
        return ciudadFinal;
    }

    /**
     * Metodo setter que ingresa la ciudad donde termina el recorrido del bus
     * @param ciudadFinal Ciudad final donde termina el bus
     */
    public void setCiudadFinal(String ciudadFinal) {
        this.ciudadFinal = ciudadFinal;
    }
    
    /**
     * Metodo que agrega al conductor al mapa anidado.
     * @param conductor Objeto conductor
     */
    public void agregarConductor(Conductor conductor){
        mapConductores.put(conductor.getRut(), conductor);
    }
    
    /**
     * Metodo que agrega al pasajero al mapa anidado.
     * @param pasajero Objeto pasajero
     */
    public void agregarPasajero(Pasajero pasajero){
        mapPasajeros.put(pasajero.getRut(), pasajero);
    }
    
    /**
     * Metodo que retorna una cadena con todos los conductores.
     * @return cadena con conductores
     */
    public String mostrarConductores(){
        String cadena = "";
        if(mapConductores.isEmpty()){
            for(String rut : mapConductores.keySet()){
                cadena += mapConductores.get(rut).cadenaDatos();
                cadena += "\n";
            }
        }else{
            for(String rut : mapConductores.keySet()){
                cadena += mapConductores.get(rut).cadenaDatos();
                cadena += "\n";
            }
        }
        return cadena;
    }
    
    /**
     * Metodo que retorna una cadena con todos los pasajeros.
     * @return cadena de pasajeros.
     */
    public String mostrarPasajeros(){
        String cadena = "";
        if(mapPasajeros.isEmpty()){
        }else{
            for(String rut : mapPasajeros.keySet()){
                cadena += mapPasajeros.get(rut).cadenaDatos();
            }
        }
        return cadena;
    }
    
    /**
     * Metodo que elimina conductores del mapa anidado.
     * @param rut rut del conductor.
     */
    public void eliminarConductores(String rut){
        if(mapConductores.containsKey(rut)) {
            mapConductores.remove(rut);
            System.out.println("El conductor ha sido eliminado correctamente");
        } else{
            System.out.println("El conductor no existe");
        }
    }
    
    /**
     * Metodo que retorna una cadena con todos los conductores.
     * @return cadena con conductores.
     */
    public String mostrarConductoresPorRut(){
        String cadena = "";
        for(String rut : mapConductores.keySet()){
            cadena += mapConductores.get(rut).mostrarPersonaPorRut();
        }
        return cadena;
    }

    /**
     * Metodo que muestra a los conductores por pantalla.
     * @param rut rut del conductor.
     */
    public void mostrarConductorPorRut(String rut, int nBus){
        if(mapConductores.get(rut) == null){
            System.out.println("El conductor no conduce el bus: " + nBus);
        }else{
            System.out.println("-----------------------------------------");
            System.out.println("El conductor conduce el bus: " + nBus);
            mapConductores.get(rut).mostrarPersonaPorRut();
        }
    }
    
    /**
     * Metodo que retorna una cadena con los pasajeros.
     * @return cadena de pasajeros.
     */
    public String mostrarPasajerosPorRut(){
       String cadena = "";
        for(String rut : mapPasajeros.keySet()){
            cadena += mapPasajeros.get(rut).mostrarPersonaPorRut();
        }
       return cadena;
    }
    
    /**
     * Metodo que permite editar al conductor elegido.
     * @param rut rut del conductor.
     * @throws java.io.IOException
     */
    public void editarConductor(String rut) throws IOException{
        if(mapConductores.containsKey(rut)){
            BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
            String nombreNuevo, edadNueva;
            int nBus;
            System.out.println("Ingrese la opcion que desea cambiar:");
            System.out.println("Opcion 1: Nombre");
            System.out.println("Opcion 2: Edad");
            int opc = Integer.parseInt(leer.readLine());

            switch(opc) {
                case 1:
                {
                    System.out.println("Ingrese nombre nuevo");
                    nombreNuevo = leer.readLine();
                    mapConductores.get(rut).setNombre(nombreNuevo); //Metodo verificador
                    break;
                }
                case 2:
                {
                    System.out.println("Ingrese edad nueva");
                    edadNueva = leer.readLine();
                    mapConductores.get(rut).setEdad(edadNueva); //Metodo verificador
                    break;
                }
                default: 
                {
                    System.out.println("Invalido");
                    break;
                } 
            }

        }
    }
    
         /**
     * Metodo que te retorna al conductor menor del mapa conductores.
     * @param edadMenorGestion
     * @param rut
     * @return cadena de String con la clave y la edad del conductor menor
     */
    
    public String[] conductorMenor(int edadMenorGestion,String rut){
        int edad;
        String clave = null;
        String edadCadena = String.valueOf(edadMenorGestion);
        for(String key: mapConductores.keySet()){
           
            edad = Integer.parseInt(mapConductores.get(key).getEdad());
            
            if(edadMenorGestion > edad){
                edadMenorGestion = edad;
                edadCadena = String.valueOf(edadMenorGestion);
                clave = key;
            }else{
                edadCadena = String.valueOf(edadMenorGestion);
            }   
        }   
        return new String[]{clave, edadCadena};
    }
    
     /**
     * Sobrecarga de metodo que entrega una cadena con el conductor menor
     * @param clave
     * @return cadena que almacena al conductor menor
     */
    
    public String conductorMenor(String clave){
        String cadena = "";
        cadena += "Nombre: " + mapConductores.get(clave).getNombre() + "\n";
        cadena += "RUT: " + mapConductores.get(clave).getRut() + "\n";
        cadena += "Edad: " + mapConductores.get(clave).getEdad() + "\n";
        return cadena;
    }

    //************************************************************************
   
    /**
     * Metodo que te muestra por pantalla los datos de los Buses.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("Bus: " + numeroBus + "\n");
        System.out.println("Matricula: " + matricula + "\n");
        System.out.println("Recorrido de " + ciudadInicio + " a " + ciudadFinal + "\n");
        System.out.println("------------------------------------------------\n");
    }
    
    /**
     * Metodo que te retorna los datos de los Buses
     * @return cadena que almacena la informacion de los buses
     */
    @Override
    public String cadenaDatos(){
        String cadena="";
        cadena+= "Numero Bus: "+numeroBus+"\n";
        cadena+= "Matricula: "+matricula+"\n";
        cadena+= "Ciudad Salida: "+ciudadInicio+"\n";
        cadena+= "Ciudad Destino:  "+ciudadFinal+"\n\n"; 
        return cadena;
    }
}
