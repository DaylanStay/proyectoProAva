package proyecto;
    
import java.util.ArrayList;

public class Pasajero extends Persona{
    private int asiento;
    private ArrayList<Bus> buses;
    
    public Pasajero(int asiento, ArrayList<Bus> buses, String rut, String nombre, String edad) {
        super(rut, nombre, edad);
        this.asiento = asiento;
        this.buses = buses;
    }
    
    public int getAsiento() {
        return asiento;
    }
    
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    
    public ArrayList<Bus> getBuses() {
        return buses;
    }
    
    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    @Override
    public void mostrarPersonaPorRut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
