
package proyecto;

import java.io.IOException;

//Clase encargada de la interface

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public interface Reporte {

    /**
     * Metodo que exporta un archivo Excel
     * @throws IOException
     */
    public void exportarExcel() throws IOException; 

    /**
     * Metodo que exporta un archivo txt
     * @throws IOException
     */
    public void exportar() throws IOException;

    /**
     * Metodo que sirve para rellenar el archivo excel
     * @param i columna del excel
     * @return
     */
    public String llenadoExcel(int i);

    /**
     * Metodo que sirve para rellenar el archivo excel
     * @param i columna del excel
     * @param j fila del excel 
     * @return
     */
    public int llenadoExcelI(int i, int j);

    /**
     * Metodo que sirve para rellanar el archivo excel
     * @param i columna del excel
     * @param j fila del excel
     * @return
     */
    public String llenadoExcel(int i, int j);
}
