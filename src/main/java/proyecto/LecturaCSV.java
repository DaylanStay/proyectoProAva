package proyecto;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class LecturaCSV {
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    //HashMap mapa = new HashMap();
    private Conductores persona = new Conductores();
    private Buses bus = new Buses();
    private Map<String, Conductores> mapaConductores = new HashMap<>();
    private Map<String, Buses> mapaBuses = new HashMap<>();
    private ArrayList <Buses> listBuses = new ArrayList<Buses>();
    private ArrayList<Conductores> listConductores = new ArrayList<Conductores>();
    
    //constructor, inicializar la variable
    public LecturaCSV(){
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

    public Conductores getPersona() {
        return persona;
    }

    public void setPersona(Conductores persona) {
        this.persona = persona;
    }

    public Buses getBus() {
        return bus;
    }

    public void setBus(Buses bus) {
        this.bus = bus;
    }

    //metodos
    public void leerArchivo(String name){
        String c = "Conductores";
        try{
            lector = new BufferedReader(new FileReader(("./Archivos/"+name+".csv")));
            while((linea = lector.readLine()) != null){
                partes = linea.split(",");
                
                //GuardarListBuses(partes);
                //GuardarListConductores(partes);
                
                if(c.equals(name)) 
                   GuardarListConductores(partes);
                else {
                    GuardarListBuses(partes);
                }
            }
            lector.close();
            linea = null;
            partes=null;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        System.out.println(bus.getListBuses());
        

    }
    
    
    
    public void GuardarListBuses(String partes[]){
       //listBuses.add();
        bus = new Buses(partes[0],partes[1],partes[2],partes[3],partes[4],listConductores);
        listBuses.add(bus);
        
    }
    public void GuardarListConductores(String partes[]){
       //listBuses.add();
        persona = new Conductores(partes[0],partes[1],partes[2],partes[3]);
        listConductores.add(persona);
    }   
     
    
    
    /* public void llenarMapaConductores(String partes[]){
        Conductores persona = new Conductores(partes[0],partes[1],partes[2],partes[3]);
        mapaConductores.put(partes[1],persona);
    }
     
     public void llenarMapaBuses(String partes[]){
        Buses bus = new Buses(partes[0],partes[1],partes[2],partes[3],partes[4]);
        mapaBuses.put(partes[0],bus);
    }*/
    
    
    
    
}
