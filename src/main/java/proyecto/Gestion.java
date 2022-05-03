package Proyecto;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

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
    private final Map<String,Conductor> mapConductores;
    private final Map<Integer,Bus> mapBuses;

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
            while((linea = lector.readLine()) != null){
             
             partes = linea.split(",");
             int nBus = Integer.parseInt(partes[0]);
             buses = new Bus(nBus,partes[1],partes[2],partes[3]);
             mapBuses.put(buses.getNumeroBus(), buses); //Guardamos datos en un mapa
                
            }
          
            lector.close();
            
            linea = null;
    }
    
    public void llenadoConductores() throws FileNotFoundException, IOException{
        lector = new BufferedReader(new FileReader(("./Archivos/Conductores.csv")));
            int contLinea = 1;
            while((linea = lector.readLine()) != null){
                
             partes = linea.split(",");
             choferes = new Conductor(partes[0],partes[1],partes[3]);
             //Guardamos datos en un mapa
             mapConductores.put(choferes.getRut() ,choferes);
             ColeccionAnidada(choferes.getRut(),contLinea);
            
             contLinea = contLinea + 1;
            }
           
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
        String cadena="";
        for(String rut : mapConductores.keySet()){
            cadena += "----------------------------------------------- \n";
            cadena += mapConductores.get(rut).MostrarBuses();
        }

        return cadena;
    }
    
    public String MostrarConductores() throws IOException{
        
        String cadena="";
        for(String rut : mapConductores.keySet()){
            cadena += "--------------------------------------- \n";
            cadena += "Nombre: " + mapConductores.get(rut).getNombre() + "\n";
            cadena += "Edad: " + mapConductores.get(rut).getEdad() + "\n";
            cadena += "RUT: " + mapConductores.get(rut).getRut() + "\n";
            
        }

        return cadena;
    }
    
    public String retornarBuses() throws IOException{
        String cadena="";        
        for(int i = 1 ; i <= mapBuses.size() ; i++){
            cadena+= "Numero Bus: "+mapBuses.get(i).getNumeroBus()+"\n";
            cadena+= "Matricula: "+mapBuses.get(i).getMatricula()+"\n";
            cadena+= "Ciudad Salida: "+mapBuses.get(i).getCiudadInicio()+"\n";
            cadena+= "Ciudad Destino:  "+mapBuses.get(i).getCiudadFinal()+"\n"; 
        }
        
        
        return cadena;
    }
    
    public String retornarConductores() throws IOException{
        String cadena="";        
        for(String key: mapConductores.keySet()){  
            cadena+= "RUT Conductor: "+mapConductores.get(key).getRut()+"\n";
            cadena+= "Nombre: "+mapConductores.get(key).getNombre()+"\n";
            cadena+= "Edad: "+mapConductores.get(key).getEdad()+"\n";
        } 
        
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
    }
    
    public String MostrarBusesyConductores(){
        String cadena = "";
        for(String key: mapConductores.keySet()){  
          Conductor oo = mapConductores.get(key);
          
            cadena += "Nombre: " + mapConductores.get(key).getNombre() + "\n";
            cadena += "Edad: " + mapConductores.get(key).getEdad() + "\n";
            cadena += "RUT: " + mapConductores.get(key).getRut() + "\n";
          
          cadena += oo.MostrarBuses() + "\n";
        } 
        return cadena;
    }

    public void exportar() throws IOException{
        try{
            File archivo = new File("reporte.txt");
            FileWriter aux = new FileWriter(archivo);
            try (BufferedWriter output = new BufferedWriter(aux)) {
                output.write(MostrarBuses());
                output.write("---------------------------------------------------\n");
                output.write(MostrarConductores());
            }
        }catch(IOException e){
            e.getStackTrace();   
        }
    }
    
   public void eliminarConductor() throws IOException{
        // Lectura
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Ingrese el Rut del conductor");
        String key;
        key = opc.readLine();

        // Eliminación
        if(mapConductores.containsKey(key)) {
            mapConductores.remove(key);
            System.out.println("El conductor ha sido eliminado correctamente");
        } else{
            System.out.println("El conductor no existe");
        }
    }

    public void eliminarBus() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        int opc;
        System.out.println("Eliminar por: \nOpcion 1: numero bus\nOpcion 2: matricula");
        opc = Integer.parseInt(leer.readLine()); 

        if(opc == 1) {
            int nBus;
            System.out.println("Ingrese el numero del bus que desea eliminar");
            nBus = Integer.parseInt(leer.readLine()); 

            for(String key: mapConductores.keySet()){
                mapConductores.get(key).eliminarBuses(nBus); 
            }

        } else if(opc == 2) {
            String matricula;
            System.out.println("Ingrese el numero de la matrícula del bus que desea eliminar");
            matricula = leer.readLine();

            for(String key: mapConductores.keySet()){
                mapConductores.get(key).eliminarBuses(matricula); 
            }
        }
    }
    
    public void editarConductor() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        String rut, nombreNuevo, edadNueva;
        int nBus;

        System.out.println("Ingrese rut del conductor que desea modificar");
        int opc;
        rut = leer.readLine();   // Reestriccion si no existe el rut
        if(mapConductores.containsKey(rut)){
            System.out.println("Ingrese la opcion que desea cambiar:");
            System.out.println("Opcion 1: Nombre");
            System.out.println("Opcion 2: Edad");
            System.out.println("Opcion 3: Bus Conductor");
            opc = Integer.parseInt(leer.readLine());

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
                case 3:
                {
                    System.out.println("Ingrese el numero del bus que desea modificar");
                    nBus = Integer.parseInt(leer.readLine());
                    mapConductores.get(rut).editarBuses(nBus);
                    break;
                }
                default: 
                {
                    System.out.println("Invalido");
                    break;
                } 
            }

        }else{
            System.out.println("Rut mal ingresado intente de nuevo");
            editarConductor();
        }
    }
    
    public void editarBus() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        int nBus;

        System.out.println("Ingrese el numero del bus que desea modificar");
        nBus = Integer.parseInt(leer.readLine()); 

        for(String key: mapConductores.keySet()){
            mapConductores.get(key).editarBuses(nBus); 
        }
    }
    
    public int contar() throws IOException{
        int cont=0;
        
        for(String key: mapConductores.keySet()){
            cont += mapConductores.get(key).getBuses().size();
        }
        
        return cont;
    }
    
    public void actualizarMapaBuses() throws IOException{
        mapBuses.clear();
        for(String key: mapConductores.keySet()){
            for(int i = 0 ; i < mapConductores.get(key).getBuses().size() ; i++){
            mapBuses.put(mapConductores.get(key).getBuses().get(i).getNumeroBus(), mapConductores.get(key).getBuses().get(i));
            }
        }
    }
    
    public void exportarExcel() throws IOException {
        actualizarMapaBuses();
        File archivo = new File("Excel.xls");
        Workbook libro = new HSSFWorkbook();
        
        Sheet pagina = libro.createSheet("Pagina Buses");
        int contador = contar();
        System.out.println("Ese es el contador: "+contador);
        int numFila=contador ,numColumna=4;
        try{
            for(int i = -1 ; i < numFila ; i++){
                Row fila = pagina.createRow(i+1);
                for(int j=0 ; j < numColumna ; j++){
                    Cell celda = fila.createCell(j);
                    if(i == -1){
                        celda.setCellValue(llenadoExcel(j));
                    }else{
                        if(j==0){
                            celda.setCellValue(llenadoExcelI(j,i));
                        }else{
                            celda.setCellValue(llenadoExcel(j,i));
                        }
                    }
                    libro.write(new FileOutputStream(archivo));
                }
            }
            System.out.println("Exportación exitosa");
        }catch(IOException e){
        }
    }
    
    public String llenadoExcel(int i){
        switch(i){
            case 0:
            {
                return "Numero Bus";
            }
            
            case 1:
            {
                return "Matricula";
            }
            
            case 2:
            {
               return "Comienzo";
            }
            
            case 3:
            {
                return "Final";
            }
        }
        return null;
    }
    
    public int llenadoExcelI(int i, int j){
        if (i == 0){
            return mapBuses.get(j+1).getNumeroBus();
        }
        return 0;
    }
    
    public String llenadoExcel(int i, int j){
        switch(i){
            case 1:
            {
                return  mapBuses.get(j+1).getMatricula();
            }
            
            case 2:
            {
                return  mapBuses.get(j+1).getCiudadInicio();
            }
            
            case 3:
            {
                    return  mapBuses.get(j+1).getCiudadFinal();
            }
            
            case 4:
            {
                return  mapBuses.get(j+1).getCiudadInicio();
            }
        }
        return null;
    }

}