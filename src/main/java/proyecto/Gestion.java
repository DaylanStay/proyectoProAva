package proyecto;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.*;

/**
 *
 * @author cesar
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
     * Metedo que llena la coleccion de Buses (Arraylist y MapBuses)
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
     * Metedo que llena la coleccion de Conductores (MapConductores)
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
     * Metedo que anida ambas colecciones (conductores y buses)
     * @param numeroBus
     */
    public void asignarConductores(int numeroBus){
        
        for(int i = 0 ; i < listaConductores.size() ; i++){
            if((listaConductores.get(i).getNumero()) != mapBuses.get(numeroBus).getNumeroBus()){
            } else {
                mapBuses.get(numeroBus).agregarConductor(listaConductores.get(i));
            }
        }
    }
    
    public void asignarPasajeros(int numeroBus){
        int i=0;
        for(String rut : mapPasajeros.keySet()){
            if(mapBuses.get(numeroBus).getNumeroBus() == mapPasajeros.get(rut).getBus()){
                mapBuses.get(numeroBus).agregarPasajero(mapPasajeros.get(rut));
            }
            i++;
        }
    }
    
    /**
     * Metedo que agrega un conductor a un Map de conductores
     * @throws IOException
     */
    public void AgregarConductor() throws IOException{
        
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        String nombre,rut,edad;
        int busPregunta;
        System.out.println("A continuacion ingrese los datos del nuevo conductor: ");
        System.out.println("");
        System.out.println("Nombre y Primer Apellido:");
        nombre = opc.readLine();
        System.out.println("Rut: ");
        rut = opc.readLine();
        System.out.println("Edad: ");
        edad = opc.readLine(); 
        System.out.println("El conductor tiene bus?");
        System.out.println("Opcion 1 : SI");
        System.out.println("Opcion 2: NO");
        
        busPregunta = Integer.parseInt(opc.readLine());
        //Leer y hacer condicional
       
        if(busPregunta == 1){
            System.out.println("¿Cual es el numero de bus asociado del conductor?");
            int numeroBus = Integer.parseInt(opc.readLine());
            Conductor nuevoConductor = new Conductor(nombre,rut,edad,numeroBus);
            mapConductores.put(nuevoConductor.getRut(),nuevoConductor);
            listaConductores.add(nuevoConductor);
            asignarConductores(numeroBus);
        }else{
            Conductor nuevoConductor = new Conductor(nombre,rut,edad,0);
            mapConductores.put(nuevoConductor.getRut(),nuevoConductor);
            listaConductores.add(nuevoConductor);
            System.out.println("Luego se le asignara uno");
        } 
    }
    
    /**
     * Metodo que agrega los buses a la coleccion de Buses 
     * @param aviso String que usa para ver si existe conductor asociado al bus o no
     * @throws IOException
     */
    public void AgregarBus() throws IOException{
        BufferedReader opc = new BufferedReader(new InputStreamReader (System.in));
        int nBus;
        String matricula, ciudadInicio, ciudadFinal;
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
        
        Bus bus = new Bus(nBus,matricula,ciudadInicio,ciudadFinal);
        mapBuses.put(bus.getNumeroBus(), bus);
        listaBuses.add(bus);
    }
    
    /**
     * Metodo que muestra por pantalla los datos de los Buses
     * @return cadena que contiene la informacion de los Buses
     * @throws IOException
     */
 
    public String mostrarBuses() throws IOException{
        String cadena="";
        for(int i = 0 ; i < listaBuses.size() ; i++){
            cadena += listaBuses.get(i).cadenaDatos();
            listaBuses.get(i).mostrarDatos();
        }
        return cadena;
    }
    
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
            Bus auxBus = listaBuses.get(i);
            cadena += listaBuses.get(i).cadenaDatos();
            listaBuses.get(i).mostrarDatos();
            cadena += auxBus.mostrarConductores() + "\n";
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
     * Metedo que llena las columnas del archivo Excel
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
     * Metedo que llena el archivo Excel
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
     * Metedo que busca y muestra al conductor con menor edad de la coleccion
     */
     public void conductorMenor(){
        //System.out.println("Entro");
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
       System.out.println("--------------------------------------- \n");
       System.out.println("Nombre: " +mapConductores.get(clave).getNombre());
       System.out.println("Rut: " +mapConductores.get(clave).getRut());
       System.out.println("Edad: " +mapConductores.get(clave).getEdad());
       System.out.println("--------------------------------------- \n");
    }
    
    /**
     * Metedo que muestra por pantalla un conjunto de ciudades donde empieza el recorrido del bus
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
     * Metodo que muestra todas las ciudades donde empiezan y/o terminan los buses
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
     * Metodo que muestra a personas por RUT ( en este caso conductores)
     */
    public void mostrarPersonas(){
        for(int i = 0 ; i < listaBuses.size() ; i++){
            listaBuses.get(i).mostrarConductoresPorRut();
            listaBuses.get(i).mostrarPasajerosPorRut();
        }
    }
}

