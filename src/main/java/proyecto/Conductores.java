/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.HashMap;
import java.util.Map;

public class Conductores {
    private String nombre;
    private String rut;
    private String edad;
    private String nBus;
   

    public Conductores(String nombre, String rut, String edad, String nBus) {
    this.nombre = nombre;
    this.rut = rut;
    this.edad = edad;
    this.nBus = nBus;
    }
    
    public Conductores(){
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

    public String getnBus() {
        return nBus;
    }

    public void setnBus(String nBus) {
        this.nBus = nBus;
    }
    
   
    
}
