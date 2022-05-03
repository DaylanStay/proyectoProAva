package Proyecto;

public class Bus {
    private int numeroBus;
    private String matricula;
    private String ciudadInicio;
    private String ciudadFinal;
    
    //Metodo Constructor
    public Bus(int numeroBus, String matricula, String ciudadInicio, String ciudadFinal) {
        this.numeroBus = numeroBus;
        this.matricula = matricula;
        this.ciudadInicio = ciudadInicio;
        this.ciudadFinal = ciudadFinal;
    }
    
    //Metodos Getter & Setter
    //************************************************************************
    public int getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(int numeroBus) {
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
    
   
    
    //************************************************************************
    
}
