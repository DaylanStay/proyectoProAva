
package proyecto;

import java.io.IOException;

//Clase encargada de la interface

public interface Reporte {
    public void exportarExcel() throws IOException; 
    public void exportar() throws IOException;
    public String llenadoExcel(int i);
    public int llenadoExcelI(int i, int j);
    public String llenadoExcel(int i, int j);
}
