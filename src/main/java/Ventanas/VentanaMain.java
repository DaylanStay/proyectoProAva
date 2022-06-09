package Ventanas;

import proyecto.Gestion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public final class VentanaMain extends JFrame implements ActionListener {
    
    private JLabel subtitulo;
    private JButton mostrarConductores, mostrarBuses, mostrarBusesConductores, salirBtn;
    private JButton agregarConductorBtn, agregarBusBtn, buscarConductoresRutBtn, eliminarBusBtn;
    private JButton eliminarConductorBtn, modificarConductorBtn, modificarBusBtn, exportarExcelBtn;
    private JButton buscarConductorMenorBtn, salidaBusesBtn, destinoBusesBtn, mostrarPersonasPorRutBtn;
    private JButton mostrarPasajerosBtn;
    
    /**
     * Constructor de la clase VentanaMain, usado para construir la ventana
     * principal y conectando todas las funciones de mostrar datos.
     *
     * @param gestion almacena toda la información y la administra.
     */
    public VentanaMain(Gestion gestion) {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,800);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Menu Principal");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa todos los componentes de la ventana principal con sus
     * respectivos botones funcionales, dimensiones y lugares.
     *
     * @param gestion almacena toda la información y la administra.
     */
    public void componentes(Gestion gestion) {
            subtitulo = new JLabel();
            subtitulo.setBounds(125, 20, 180, 20);
            subtitulo.setText("Seleccione  una  opción");
            add(subtitulo);
            
            mostrarConductores = new JButton();
            mostrarConductores.setBounds(70, 50, 240, 20);
            mostrarConductores.setText("Mostrar Conductores");
            add(mostrarConductores);
            
            mostrarConductores.addActionListener(e -> {
                try {
                    //Falta Modificar
                    new VentanaMostrarConductores(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            mostrarBuses = new JButton();
            mostrarBuses.setBounds(70, 90, 240, 20);
            mostrarBuses.setText("Mostrar Buses");
            add(mostrarBuses);
            
            mostrarBuses.addActionListener(e -> {
                try {
                    new VentanaMostrarBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            mostrarBusesConductores = new JButton();
            mostrarBusesConductores.setBounds(70, 130, 240, 20);
            mostrarBusesConductores.setText("Mostrar Buses y sus Conductores");
            add(mostrarBusesConductores);
            
            mostrarBusesConductores.addActionListener(e -> {
                new VentanaMostrarBusesConductores(gestion);
                this.dispose();
            });
            
            agregarConductorBtn = new JButton();
            agregarConductorBtn.setBounds(70, 170, 240, 20);
            agregarConductorBtn.setText("Agregar Conductor");
            add(agregarConductorBtn);
            
            agregarConductorBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.AgregarConductor();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            agregarBusBtn = new JButton();
            agregarBusBtn.setBounds(70, 210, 240, 20);
            agregarBusBtn.setText("Agregar Bus");
            add(agregarBusBtn);
            
            agregarBusBtn.addActionListener(e -> {   
                try {
                    setVisible(false);
                    gestion.AgregarBus();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            eliminarConductorBtn = new JButton();
            eliminarConductorBtn.setBounds(70, 250, 240, 20);
            eliminarConductorBtn.setText("Eliminar Conductor");
            add(eliminarConductorBtn);
            
            eliminarConductorBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.eliminarConductor();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            eliminarBusBtn = new JButton();
            eliminarBusBtn.setBounds(70, 290, 240, 20);
            eliminarBusBtn.setText("Eliminar Bus");
            add(eliminarBusBtn);
            
            eliminarBusBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.eliminarBus();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            modificarConductorBtn = new JButton();
            modificarConductorBtn.setBounds(70, 330, 240, 20);
            modificarConductorBtn.setText("Modificar Conductor");
            add(modificarConductorBtn);
            
            modificarConductorBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.editarConductor();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            modificarBusBtn = new JButton();
            modificarBusBtn.setBounds(70, 370, 240, 20);
            modificarBusBtn.setText("Modificar Bus");
            add(modificarBusBtn);
            
            modificarBusBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.editarBus();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            buscarConductorMenorBtn = new JButton();
            buscarConductorMenorBtn.setBounds(70, 410, 240, 20);
            buscarConductorMenorBtn.setText("Buscar Conductor Menor");
            add(buscarConductorMenorBtn);
            
            buscarConductorMenorBtn.addActionListener(e -> {
                setVisible(false);
                gestion.conductorMenor();
                setVisible(true);
            });
            
            buscarConductoresRutBtn = new JButton();
            buscarConductoresRutBtn.setBounds(70, 450, 240, 20);
            buscarConductoresRutBtn.setText("Buscar Conductores por Rut");
            add(buscarConductoresRutBtn);
            
            buscarConductoresRutBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.BuscarConductoresRut();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            mostrarPersonasPorRutBtn = new JButton();
            mostrarPersonasPorRutBtn.setBounds(70, 490, 240, 20);
            mostrarPersonasPorRutBtn.setText("Mostrar Personas por Rut");
            add(mostrarPersonasPorRutBtn);
            
            mostrarPersonasPorRutBtn.addActionListener(e -> {
                setVisible(false);
                gestion.mostrarPersonas();
                setVisible(true);
            });
            
            destinoBusesBtn = new JButton();
            destinoBusesBtn.setBounds(70, 530, 240, 20);
            destinoBusesBtn.setText("Destino de Buses");
            add(destinoBusesBtn);
            
            destinoBusesBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.BusesPorViajeDestino();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            salidaBusesBtn = new JButton();
            salidaBusesBtn.setBounds(70, 570, 240, 20);
            salidaBusesBtn.setText("Salida de Buses");
            add(salidaBusesBtn);
            
            salidaBusesBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.BusesPorViaje();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            mostrarPasajerosBtn = new JButton();
            mostrarPasajerosBtn.setBounds(70, 610, 240, 20);
            mostrarPasajerosBtn.setText("Mostrar Pasajeros");
            add(mostrarPasajerosBtn);
            
            mostrarPasajerosBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.mostrarPasajeros();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            exportarExcelBtn = new JButton();
            exportarExcelBtn.setBounds(70, 650, 240, 20);
            exportarExcelBtn.setText("Exportar Excel");
            add(exportarExcelBtn);
            
            exportarExcelBtn.addActionListener(e -> {
                try {
                    setVisible(false);
                    gestion.exportarExcel();
                    setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            salirBtn = new JButton();
            salirBtn.setBounds(70,690, 240, 20);
            salirBtn.setText("Salir y Exportar");
            add(salirBtn);

            salirBtn.addActionListener(e -> {
                try {
                    gestion.exportar();
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
