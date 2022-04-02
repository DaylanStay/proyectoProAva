package proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Buses {
    private String numeroBus;
    private String matricula; 
    private String ciudadInicio;
    private String ciudadFinal;
    private String capacidad;
    private ArrayList <Conductores> listBuses = new ArrayList<Conductores>();
    //private String recorrido;

    public Buses(String numeroBus, String matricula, String ciudadInicio, String ciudadFinal, String capacidad/*, String recorrido*/, ArrayList aa) {
        this.numeroBus = numeroBus;
        this.matricula = matricula;
        this.ciudadInicio = ciudadInicio;
        this.ciudadFinal = ciudadFinal;
        this.capacidad = capacidad;
        listBuses = new ArrayList();
        listBuses.addAll(aa);
        //this.recorrido = recorrido;
    }
    
    public Buses(){
    }

    public ArrayList<Conductores> getListBuses() {
        return listBuses;
    }

    public void setListBuses(ArrayList<Conductores> listBuses) {
        this.listBuses = listBuses;
    }
   

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCiudadInicio() {
        return ciudadInicio;
    }

    public void setCiudadInicio(String ciudadInicio) {
        this.ciudadInicio = ciudadInicio;
    }

    public String getCiudadFinal() {
        return ciudadFinal;
    }

    public void setCiudadFinal(String ciudadFinal) {
        this.ciudadFinal = ciudadFinal;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    /*public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }*/

    
}
