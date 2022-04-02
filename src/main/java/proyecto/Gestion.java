package proyecto;


import java.io.IOException;
import java.util.*;
import java.io.*;
/**
 *
 * @author cesar
 */

public class Gestion {
    
    public static void main(String[] args) throws IOException{
        LecturaCSV lec = new LecturaCSV();
        
        lec.leerArchivo("Conductores");
        
        lec.leerArchivo("Buses");
        
        //Buses a = new Buses();
        //a=a.getMapaBuses().get("7");
        //System.out.println(a.getNumeroBus());
        
    }
}