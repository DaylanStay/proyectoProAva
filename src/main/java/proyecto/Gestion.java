package Proyecto;


import java.io.*;
import java.util.*;

public class Gestion {
   
    //Llenado de colecciones
    //(clase bus y conductor), y luego anidar colecciones
    private BufferedReader lector;
    private String linea;
    private String partes [];
    private Bus buses;
    private Conductor choferes;
    private Map<String,Conductor> mapConductores = new HashMap();
    private Map<Integer,Bus> mapBuses = new HashMap();
    
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
        
        
        
        if("Conductor".equals(aviso)){
            choferes.agregarBus(buses);
        }else{
            System.out.println("No hay persona para añadir");
        }
        
        
    }
    
    public void MostrarBuses(){
        for(int i = 1; i <= mapBuses.size(); i++){
            
            System.out.println("Numero Bus: "+mapBuses.get(i).getNumeroBus());
            System.out.println("Matricula: "+mapBuses.get(i).getMatricula());
            System.out.println("Ciudad Salida: "+mapBuses.get(i).getCiudadInicio());
            System.out.println("Ciudad Destino: "+mapBuses.get(i).getCiudadFinal());
            System.out.println("");
        }
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
    
    
}
