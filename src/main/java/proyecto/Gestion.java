package proyecto;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.*;
import java.util.*;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public class Gestion implements Reporte{
    private final Map<String,Conductor> mapConductores;
    private final Map<Integer,Bus> mapBuses;
    private final ArrayList<Bus> listaBuses;
    private final Map<String,Pasajero> mapPasajeros;
    private final ArrayList<Conductor> listaConductores;
    
    /**
     * Constructor de la clase Gestion, instancia una variable con colecciones
     */
    public Gestion() {
        mapConductores = new HashMap();
        mapBuses = new HashMap();
        listaBuses = new ArrayList();
        mapPasajeros = new HashMap();
        listaConductores = new ArrayList();
    }
    
    //METODOS

    /**
     * Metodo que llena la coleccion de Buses (Arraylist y MapBuses)
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void llenadoBus() throws FileNotFoundException, IOException{
        BufferedReader lector = new BufferedReader(new FileReader(("./Archivos/Buses.csv")));
        String linea;
        String datos[];
        
            while((linea = lector.readLine()) != null){
             datos = linea.split(",");
             int nBus = Integer.parseInt(datos[0]);
             Bus buses = new Bus(nBus,datos[1],datos[2],datos[3]);
             mapBuses.put(buses.getNumeroBus(), buses); //Guardamos datos en un mapa
             listaBuses.add(buses);
             asignarConductores(nBus);
             asignarPasajeros(nBus);
            }
            lector.close();
    }
    
    /**
     * Metodo que llena la coleccion de Pasajeros.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void llenarPasajeros() throws FileNotFoundException, IOException{
        BufferedReader lector = new BufferedReader(new FileReader(("./Archivos/Pasajeros.csv")));
        String linea;
        String datos[];
        
        while((linea = lector.readLine()) != null){    
             datos = linea.split(",");
             int nBus = Integer.parseInt(datos[0]);
             Pasajero pasajero = new Pasajero(datos[1],datos[2],datos[3],datos[4],datos[5],nBus);
             mapPasajeros.put(pasajero.getRut(),pasajero);
        }
        lector.close();
    }
    
    /**
     * Metodo que llena la coleccion de Conductores (MapConductores)
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void llenadoConductores() throws FileNotFoundException, IOException{
        BufferedReader lector = new BufferedReader(new FileReader(("./Archivos/Conductores.csv")));
        String linea;
        String datos[];
            
        while((linea = lector.readLine()) != null){     
             datos = linea.split(",");
             int numero = Integer.parseInt(datos[2]);
             Conductor conductor = new Conductor(datos[0],datos[1],datos[3],numero);
            //Guardamos datos en un mapa
             mapConductores.put(conductor.getRut() ,conductor);
             listaConductores.add(conductor);
        }
        lector.close();
    }
    
    /**
     * Metodo que anida ambas colecciones (conductores y buses)
     * @param numeroBus Numero del bus correspondiente
     */
    public void asignarConductores(int numeroBus){
        for(int i = 0 ; i < listaConductores.size() ; i++){
            if((listaConductores.get(i).getNumero()) != mapBuses.get(numeroBus).getNumeroBus()){
                for(int j = 0 ; j < listaBuses.size() ; j++){
                    if(listaBuses.get(j).getNumeroBus() == numeroBus){
                        listaBuses.get(j).agregarConductor(listaConductores.get(i));
                    }
}
            }
            
        }
    }
    
    /**
     * Metodo que asigna a un Pasajero a un bus
     * @param numeroBus Numero del bus correspondiente
     */
    public void asignarPasajeros(int numeroBus){
        int i=0;
        for(String rut : mapPasajeros.keySet()){
            if(mapBuses.get(numeroBus).getNumeroBus() == mapPasajeros.get(rut).getBus()){
                for(int j = 0 ; j < listaBuses.size() ; j++){
                    if(listaBuses.get(j).getNumeroBus() == numeroBus){
                        listaBuses.get(j).agregarPasajero(mapPasajeros.get(rut));
                    }
}
            }
            i++;
        }
    }
    
    /**
     * Metodo que agrega un conductor a un Map de conductores
     * @param nombre nombre del conductor
     * @param rut rut del conductor
     * @param edad edad del conductor
     * @param numeroBus numero del bus ingresado
     * @throws IOException
     */
    public void AgregarConductor(String nombre, String rut, String edad, int numeroBus) throws IOException{
        if(numeroBus > 0){
            Conductor nuevoConductor = new Conductor(nombre,rut,edad, numeroBus);
            mapConductores.put(nuevoConductor.getRut(),nuevoConductor);
            listaConductores.add(nuevoConductor);
            Bus bus = new Bus(numeroBus,"No tiene","No tiene","No tiene");
            mapBuses.put(numeroBus, bus);
            listaBuses.add(bus);
            asignarConductores(numeroBus);
        }else{
            Conductor nuevoConductor = new Conductor(nombre,rut,edad,0);
            mapConductores.put(nuevoConductor.getRut(),nuevoConductor);
            listaConductores.add(nuevoConductor);
            Bus bus = new Bus(0,null,null,null);
            mapBuses.put(0, bus);
            listaBuses.add(bus);
            asignarConductores(0);
        } 
    }
    
    /**
     * Metodo que agrega los buses a la coleccion de Buses 
     * @param nBus numero de bus
     * @param matricula valor de la matricula del bus
     * @param ciudadInicio ciudad de inicio del bus
     * @param ciudadDestino ciudad destino del bus
     * @throws IOException
     */
    public void AgregarBus(int nBus,String matricula, String ciudadInicio, String ciudadDestino) throws IOException{
        Bus bus = new Bus(nBus,matricula,ciudadInicio,ciudadDestino);
        mapBuses.put(bus.getNumeroBus(), bus);
        listaBuses.add(bus);
    }
    
    /**
     * Metodo que verifica si el número de bus se encuentra disponible.
     * @param nBus numero del bus.
     * @return booleano que dice si está ocupado o no.
     */
    public boolean verificarBus(int nBus){
        Bus comp = mapBuses.get(nBus);
        
        if(comp == null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Metodo que muestra por pantalla los datos de los Buses
     * @return cadena que contiene la informacion de los Buses
     * @throws IOException
     */
    public String mostrarBuses() throws IOException{
        String cadena="";
        for(int i = 0 ; i < listaBuses.size() ; i++){
            if(listaBuses.get(i).getNumeroBus() != 0){
                cadena += listaBuses.get(i).cadenaDatos();
                listaBuses.get(i).mostrarDatos();
            }
        }
        
        
        return cadena;
    }
    
    /**
     * Metodo que muestra por pantalla a los Pasajeros
     * @return cadena que contiene la informacion de cada Pasajero
     * @throws IOException
     */
    public String mostrarPasajeros() throws IOException{
        String cadena="";
        for(int i=0 ; i < listaBuses.size() ; i++){
            cadena += listaBuses.get(i).mostrarPasajeros();
        }
        return cadena;
    }
    
    /**
     * Metodo que muestra por pantalla los datos de los Conductores
     * @return cadena que contiene la informacion de los conductores
     * @throws IOException
     */
    public String mostrarConductores() throws IOException{
        String cadena="";
        for(int i=0 ; i < listaBuses.size() ; i++){
            cadena += listaBuses.get(i).mostrarConductores();
        }
        return cadena;
    }
    
    /**
     * Metodo que muestra por pantalla la informacion de los conductores y los buses 
     * @return
     */
    public String mostrarBusesConConductores(){
        String cadena = "";
        for(int i=0 ; i < listaBuses.size() ; i++){
            if(listaBuses.get(i).getNumeroBus() != 0){
                Bus auxBus = listaBuses.get(i);
                cadena += listaBuses.get(i).cadenaDatos();
                cadena += auxBus.mostrarConductores() + "\n";
                cadena += "-----------------------------------------------------------------\n";
            }
        }
        return cadena;
    }
    
    /**
     * Metodo que busca a los conductores por RUT
     * @throws IOException
     */
    public void BuscarConductoresRut() throws IOException{
        
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        String rut;
        System.out.println("Ingrese el rut del conductor que quiere mostrar: ");
        rut = opc.readLine();
        for(int i = 0 ; i < listaBuses.size() ; i++){
            listaBuses.get(i).mostrarConductorPorRut(rut);
        }
    }
    
    /**
     * Metodo que elimina a un conductor de su coleccion
     * @throws IOException
     */
    public void eliminarConductor() throws IOException{
        // Lectura
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Ingrese el Rut del conductor");
        String key;
        key = opc.readLine();

        // Eliminación
        for(int i = 0 ; i < listaBuses.size() ; i++){
            listaBuses.get(i).eliminarConductores(key);
        }
    }

    /**
     * Metodo que elimina a un Bus de su coleccion
     * @throws IOException
     */
    public void eliminarBus() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        int opc;
        System.out.println("Eliminar por: \nOpcion 1: numero bus\nOpcion 2: matricula");
        opc = Integer.parseInt(leer.readLine()); 

        if(opc == 1) {
            int nBus;
            System.out.println("Ingrese el numero del bus que desea eliminar");
            nBus = Integer.parseInt(leer.readLine()); 

            for(int i = 0 ; i < listaBuses.size() ; i++){
                if(listaBuses.get(i).getNumeroBus() == nBus){
                    listaBuses.remove(i);
                } 
            }
            
        } else if(opc == 2) {
            String matricula;
            System.out.println("Ingrese el numero de la matrícula del bus que desea eliminar");
            matricula = leer.readLine();

            for(int i = 0 ; i < listaBuses.size() ; i++){
                if(listaBuses.get(i).getMatricula().equals(matricula)){
                    listaBuses.remove(i);
                } 
            }
        }
    }
    
    /**
     * Metodo que edita a un Conductor de la coleccion 
     * @throws IOException
     */
    public void editarConductor() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Ingrese rut del conductor que desea modificar");
        String rut = leer.readLine();   // Reestriccion si no existe el rut
        for(int i = 0 ; i < listaBuses.size() ; i++){
            listaBuses.get(i).editarConductor(rut);
        }
    }
    
    /**
     * Metodo que edita a un Bus de su coleccion
     * @throws IOException
     */
    public void editarBus() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Ingrese el numero del bus que desea modificar");
        int nBus = Integer.parseInt(leer.readLine()); 
        
        for(int i = 0 ; i < listaBuses.size() ; i++){
            if(listaBuses.get(i).getNumeroBus() == nBus) {
                String aux;
                int opc;

                System.out.println("Ingrese la opcion que desea cambiar:");
                System.out.println("Opcion 1: Ciudad inicial");
                System.out.println("Opcion 2: Ciudad final");
                System.out.println("Opcion 3: Matrícula");
                opc = Integer.parseInt(leer.readLine());

                switch(opc){
                    case 1:
                    {
                        System.out.println("Ingrese la ciudad inicial");
                        aux = leer.readLine();
                        listaBuses.get(i).setCiudadInicio(aux);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Ingrese la ciudad final");
                        aux = leer.readLine();
                        listaBuses.get(i).setCiudadFinal(aux);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Ingrese la nueva matrícula");
                        aux = leer.readLine();
                        listaBuses.get(i).setMatricula(aux);
                        break;
                    }
                    default: 
                    {
                        System.out.println("Invalido");
                        break;
                    }
                }
                break;
            }
        }
    }
    
    //Interface Reporte

    /**
     * Metodo que exporta un archivo CSV
     * @throws IOException
     */
    @Override
    public void exportar() throws IOException{
        try{
            File archivo = new File("reporte.txt");
            FileWriter aux = new FileWriter(archivo);
            try (BufferedWriter output = new BufferedWriter(aux)) {
                output.write(mostrarBuses());
                output.write("---------------------------------------------------\n");
                output.write(mostrarConductores());
            }
        }catch(IOException e){
            e.getStackTrace();   
        }
    }
    
    /**
     * Metodo que actualiza el Mapa de buses con nuevos datos
     * @throws IOException
     */
    public void actualizarMapaBuses() throws IOException{
        mapBuses.clear();
        for(int i = 0 ; i < listaBuses.size() ; i++){
            mapBuses.put(listaBuses.get(i).getNumeroBus(), listaBuses.get(i));
        }
    }
    
    /**
     * Metodo que exporta un archivo Excel.xls 
     * @throws IOException
     */
    @Override
    public void exportarExcel() throws IOException {
        File archivo = new File("Excel.xls");
        Workbook libro = new HSSFWorkbook();  
        Sheet pagina = libro.createSheet("Pagina Buses");
        int contador = listaBuses.size();
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
    
    /**
     * Metodo que llena las columnas del archivo Excel
     * @param i columna del Excel
     * @return informacion de los buses (numero de bus, matricula, comienza (ciudad de inicio) y final (ciudad de termino))
     */
    @Override
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
    
    /**
     * Metodo que llena el archivo Excel
     * @param i columna del Excel
     * @param j filas del Excel
     * @return 0 si no es la fila que corresponde al llenado
     */
    @Override
    public int llenadoExcelI(int i, int j){
        if (i == 0){
            return mapBuses.get(j+1).getNumeroBus();
        }
        return 0;
    }
    
    /**
     * Metodo que llena el Archivo Excel
     * @param i columna del Excel
     * @param j fila del Excel
     * @return informacion del mapa Buses (Matricula,Ciudad donde inicia el Bus, ciudad donde termina el bus)
     */
    @Override
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
                return mapBuses.get(j+1).getCiudadFinal();
            }
            case 4:
            {
                return  mapBuses.get(j+1).getCiudadInicio();
            }
        }
        return null;
    }
    //Fin Interface Reporte
    //Entrega P4
    
    /**
     * Metodo que busca y muestra al conductor con menor edad de la coleccion.
     */
     public String conductorMenor(){
        String cadena = "";
        int edadMenor = 200;
        int edad;
        String clave = null;
        for(String key: mapConductores.keySet()){
            edad = Integer.parseInt(mapConductores.get(key).getEdad());
            if(edadMenor > edad){
                edadMenor = edad;
                clave = key;
            }
        }
        
        cadena += "Nombre: " + mapConductores.get(clave).getNombre() + "\n";
        cadena += "RUT: " + mapConductores.get(clave).getRut() + "\n";
        cadena += "Edad: " + mapConductores.get(clave).getEdad() + "\n";
       
        return cadena;
    }
    
    /**
     * Metodo que muestra por pantalla un conjunto de ciudades donde empieza el recorrido del bus
     * @throws IOException
     */
    public void BusesPorViaje() throws IOException {
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        
        System.out.println("Ingrese la ciudad de salida");
        System.out.println("Opciones: ");
        System.out.println("***************************");
        MostrarCiudades();
        System.out.println("***************************");
        String partida = opc.readLine();
        System.out.println("***************************");
        System.out.println("Ciudad De Partida: "+partida);
        for(String key: mapConductores.keySet()){
            mapConductores.get(key).BusesPorViaje(partida,0);
        }
    }
    
    /**
     * Metodo que muestra por pantalla un conjunto de ciudades donde termina el recorrido del bus
     * @throws IOException
     */
    public void BusesPorViajeDestino() throws IOException {
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        
        System.out.println("Ingrese la ciudad de Destino");
        System.out.println("Opciones: ");
        System.out.println("***************************");
        MostrarCiudades();
        System.out.println("***************************");
        String ciudad = opc.readLine();
        System.out.println("***************************");
        System.out.println("Ciudad De Llegada: " +ciudad);
        for(String key: mapConductores.keySet()){
            mapConductores.get(key).BusesPorViaje(ciudad,1);
        }
    }
    
    /**
     * Metodo que muestra todas las ciudades donde empiezan y/o terminan los buses.
     */
    public void MostrarCiudades(){
        System.out.println("Valparaiso");
        System.out.println("Santiago");
        System.out.println("Concepcion");
        System.out.println("Copiapo");
        System.out.println("Iquique");
        System.out.println("Temuco");
        System.out.println("Concepcion");
        System.out.println("Rancagua");
        System.out.println("PuertoMontt");
        System.out.println("Chillan");
        System.out.println("ViñaDelMar");
        System.out.println("Atacama");
        System.out.println("Talca");
        System.out.println("Talcahuano");
    }
   
    /**
     * Metodo que muestra a personas por RUT ( en este caso conductores).
     */
    public String mostrarPersonas(){
        String cadena = "";
        for(int i = 0 ; i < listaBuses.size() ; i++){
            cadena += listaBuses.get(i).mostrarConductoresPorRut();
            cadena += listaBuses.get(i).mostrarPasajerosPorRut();
        }
        return cadena;
    }
}