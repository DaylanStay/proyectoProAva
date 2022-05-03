
package Proyecto;

import java.io.*;
import javax.swing.*;

public class Lectura {
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    
    //Metodo leer
     public void leerArchivo(String name){
        String c = "Conductores";
         
        try{
            lector = new BufferedReader(new FileReader(("./Archivos/"+name+".csv")));
            while((linea = lector.readLine()) != null){
                partes = linea.split(",");
            }
            lector.close();
            linea = null;
            partes= null;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,e);
        }
    } 
}
