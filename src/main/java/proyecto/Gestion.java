package Proyecto;


import java.io.*;
import java.util.*;

public class Gestion {

    //Llenado de colecciones
    //(clase bus y conductor), y luego anidar colecciones
    private BufferedReader lector;
    private String linea;
    private String partes [];
    private Lectura leer;
    private Bus buses;
    private Conductor choferes;
    private Map<String,Conductor> mapConductores;
    private Map<Integer,Bus> mapBuses;
    private Gestion a;

    public Gestion() {
        mapConductores = new HashMap();
        mapBuses = new HashMap();
    }

    public BufferedReader getLector() {
        return lector;
    }

    public void setLector(BufferedReader lector) {
        this.lector = lector;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String[] getPartes() {
        return partes;
    }

    public void setPartes(String[] partes) {
        this.partes = partes;
    }

    public Lectura getLeer() {
        return leer;
    }

    public void setLeer(Lectura leer) {
        this.leer = leer;
    }

    public Bus getBuses() {
        return buses;
    }

    public void setBuses(Bus buses) {
        this.buses = buses;
    }

    public Conductor getChoferes() {
        return choferes;
    }

    public void setChoferes(Conductor choferes) {
        this.choferes = choferes;
    }
    
    
    
    public void llenadoBus() throws FileNotFoundException, IOException{
        
        lector = new BufferedReader(new FileReader(("./Archivos/Buses.csv")));
            //Bus buses;
            while((linea = lector.readLine()) != null){
             
             partes = linea.split(",");
             int nBus = Integer.parseInt(partes[0]);
             buses = new Bus(nBus,partes[1],partes[2],partes[3]);
             mapBuses.put(buses.getNumeroBus(), buses); //Guardamos datos en un mapa
                
            }
          
            
            //MostrarBuses();
            lector.close();
            
            linea = null;
            System.out.println("Buses size: "+mapBuses.size());
    }
    
    public void llenadoConductores() throws FileNotFoundException, IOException{
        lector = new BufferedReader(new FileReader(("./Archivos/Conductores.csv")));
            //Bus buses;
            int contLinea = 1;
            while((linea = lector.readLine()) != null){
                
             partes = linea.split(",");
             choferes = new Conductor(partes[0],partes[1],partes[3]);
             //Guardamos datos en un mapa
             mapConductores.put(choferes.getRut() ,choferes);
             ColeccionAnidada(choferes.getRut(),contLinea);
            
             contLinea = contLinea + 1;
            }
           
            
            //Mostrar();
            lector.close();
            linea = null;
    }
    
    public void ColeccionAnidada(String k, int linea){
       
        Conductor conductores;
        
        conductores = mapConductores.get(k);
       
        
        Bus agregar;
        for(int i = 1; i <= mapBuses.size();i++){
            if(i == linea){
                
                agregar = new Bus(mapBuses.get(i).getNumeroBus(),mapBuses.get(i).getMatricula(),mapBuses.get(i).getCiudadInicio(),mapBuses.get(i).getCiudadFinal());
                
                conductores.agregarBus(agregar);
            }
        }
        
        //conductores.MostrarBuses();
        //Como agrego?
    }
    
    public void AgregarConductor() throws IOException{
        
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        Conductor conductorNuevo;
        String nombre;
        String rut;
        String edad;
        int busPregunta;
        System.out.println("A continuacion ingrese los datos del nuevo conductor: ");
        System.out.println("");
        System.out.println("Nombre y Primer Apellido:");
        //leer
        nombre = opc.readLine();
        System.out.println("Rut: ");
        //leer
        rut = opc.readLine();
        System.out.println("Edad: ");
        //leer
        edad = opc.readLine();
        
        choferes = new Conductor(nombre,rut,edad);
        mapConductores.put(choferes.getRut() ,choferes);
        
        
        System.out.println("El conductor tiene bus?");
        System.out.println("Opcion 1 : SI");
        System.out.println("Opcion 2: NO");
        
        busPregunta = Integer.parseInt(opc.readLine());
        //Leer y hacer condicional
        
        
        
        if(busPregunta == 1){
            String aviso = "Conductor";
            AgregarBus(aviso);
        }else{
            System.out.println("Luego se le asignara uno");
        }
        
        
        
        
    }
    
    public void AgregarBus(String aviso) throws IOException{
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        int nBus;
        String matricula;
        String ciudadInicio;
        String ciudadFinal;
        int flag = 0;
        System.out.println("Llenado de bus");
        
        do{
        System.out.println("Ingrese numero de Bus: ");
        //Reestriccion ver si no hay un bus con el mismo numero
        nBus = Integer.parseInt(opc.readLine());
        
        
        Bus comp = mapBuses.get(nBus);
        
        if(comp == null){
            flag = 1;
        }else{
            flag = 0;
        }
        
        
        }while(flag == 0);
        
        System.out.println("Ingrese Matricula: ");
        
        matricula = opc.readLine();
        System.out.println("Ingrese Ciudad de inicio del bus");
        ciudadInicio = opc.readLine();
        
        System.out.println("Ingrese Ciudad de destino del bus");
        
        ciudadFinal = opc.readLine();
        
        buses = new Bus(nBus,matricula,ciudadInicio,ciudadFinal);
        mapBuses.put(buses.getNumeroBus(), buses);
        
        //Si viene con string aviso es porque hay que guardar el bus en la coleccion ya anidada
        
        if("Conductor".equals(aviso)){
            choferes.agregarBus(buses);
        }else{
            System.out.println("No hay persona para añadir");
        }
        
        
    }
    
    public String MostrarBuses() throws IOException{
        //System.out.println("Este es el valor del mapa size : "+mapBuses.size());
        String cadena="";
        for(int i = 1; i <= mapBuses.size(); i++){
            System.out.println("Numero Bus: "+mapBuses.get(i).getNumeroBus());
            System.out.println("Matricula: "+mapBuses.get(i).getMatricula());
            System.out.println("Ciudad Salida: "+mapBuses.get(i).getCiudadInicio());
            System.out.println("Ciudad Destino: "+mapBuses.get(i).getCiudadFinal());
            System.out.println("");
            cadena+= "Numero Bus: "+mapBuses.get(i).getNumeroBus()+"\n";
            cadena+= "Matricula: "+mapBuses.get(i).getMatricula()+"\n";
            cadena+= "Ciudad Salida: "+mapBuses.get(i).getCiudadInicio()+"\n";
            cadena+= "Ciudad Destino:  "+mapBuses.get(i).getCiudadFinal()+"\n";
        }
        //System.out.println("Este es el valor del mapa size : "+mapBuses.size());
        return cadena;
    }
    
    public void MostrarConductores() throws IOException{
        System.out.println("           Conductores         ");
        System.out.println("");
        System.out.println("Rut           Nombre            Edad");
        
        for(String key: mapConductores.keySet()){  
          System.out.println(key+ " - " + mapConductores.get(key).getNombre() +"  - " +mapConductores.get(key).getEdad());
        } 

        //Mostrar bus asociado al conductor, en el caso de no tener bus asociado
        //Buscar si se encuentra un bus disponible para asignarle 
    }
    
    public String retornarBuses() throws IOException{
        String cadena="";        
        for(int i = 1 ; i <= mapBuses.size() ; i++){
            cadena+= "Numero Bus: "+mapBuses.get(i).getNumeroBus()+"\n";
            cadena+= "Matricula: "+mapBuses.get(i).getMatricula()+"\n";
            cadena+= "Ciudad Salida: "+mapBuses.get(i).getCiudadInicio()+"\n";
            cadena+= "Ciudad Destino:  "+mapBuses.get(i).getCiudadFinal()+"\n"; 
        }
        System.out.println("Este es el valor del mapa size : "+mapBuses.size());
        return cadena;
    }
    
    public String retornarConductores() throws IOException{
        String cadena="";        
        for(String key: mapConductores.keySet()){  
            cadena+= "RUT Conductor: "+mapConductores.get(key).getRut()+"\n";
            cadena+= "Nombre: "+mapConductores.get(key).getNombre()+"\n";
            cadena+= "Edad: "+mapConductores.get(key).getEdad()+"\n";
        } 
       // System.out.println("Este es el valor del mapa size : "+mapBuses.size());
        return cadena;
    }
    
    public void BuscarConductoresRut() throws IOException{
        
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        String rut;
        String aa,bb,cc;
        System.out.println("Ingrese el rut del conductor que quiere mostrar: ");
        
        rut = opc.readLine();
        
        if(mapConductores.get(rut) == null){
            System.out.println("No existe el conductor");
        }else{
        
        //Conductor oo = mapConductores.get(rut);
            aa = mapConductores.get(rut).getNombre();
            bb = mapConductores.get(rut).getEdad();
            cc = mapConductores.get(rut).getRut();
        
            System.out.println("Nombre: "+aa);
            System.out.println("Edad: "+bb);
            System.out.println("Rut: "+cc);
            System.out.println("");
            Conductor oo = mapConductores.get(rut);
            oo.MostrarBuses();
        }
        
        
        
        //Mostrar bus asociado al conductor, en el caso de no tener bus asociado
        //Buscar si se encuentra un bus disponible para asignarle
    }
    
    public void MostrarBusesyConductores(){
        
        for(String key: mapConductores.keySet()){  
          System.out.println("");
          System.out.println("Rut           Nombre            Edad");
          System.out.println(key+ " - " + mapConductores.get(key).getNombre() +"  - " +mapConductores.get(key).getEdad());
          Conductor oo = mapConductores.get(key);
          oo.MostrarBuses();
        } 
    
    }

    public void exportar() throws IOException{
        //System.out.println("Este es el valor del mapa size : "+mapBuses.size());
        //Gestion a = new Gestion();
        try{
            File archivo = new File("reporte.txt");
           // if(archivo.exists() == false){
            FileWriter aux = new FileWriter(archivo);
            BufferedWriter output = new BufferedWriter(aux);
            output.write(retornarBuses());
            output.write("---------------------------------------------------\n");
            output.write(retornarConductores());
            System.out.println("Archivo creado");
            output.close();
        //}
        }catch(Exception e){
            e.getStackTrace();   
        }
    }

}
    
    /*public void salir() throws IOException{
            Gestion a = new Gestion();
            String mostrar = a.retornarDatosBuses();
            System.out.println("Algo: "+mostrar);
    }*/