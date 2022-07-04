package Ventanas;

import proyecto.Gestion;
import java.awt.BorderLayout;
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
public final class VentanaModificarBusOpcion extends JFrame implements ActionListener {
    
    private JButton volverBtn, modificarCiudadIniBtn, modificarCiudadFinBtn, modificarMatriculaBtn;
    
    /**
     * Constructor de la ventana Modificar Bus Opcion, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales.
     *
     * @param gestion almacena toda la información y la administra.
     * @param numeroBus numero del bus.
     * @throws IOException
     */
    public VentanaModificarBusOpcion(Gestion gestion, int numeroBus) throws IOException {
        componentes(gestion, numeroBus);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270,250);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Modificar Bus");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Agregar Conductor, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @param numeroBus numero del bus.
     * @throws IOException
     */
    public void componentes(Gestion gestion, int numeroBus) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            modificarCiudadIniBtn = new JButton();
            modificarCiudadIniBtn.setBounds(20,20, 200, 20);
            modificarCiudadIniBtn.setText("Modificar Ciudad Inicial");
            add(modificarCiudadIniBtn);
            
            modificarCiudadIniBtn.addActionListener(e -> {
                try {
                    new VentanaModificarBusCiudadInicial(gestion, numeroBus);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaModificarBusOpcion.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            modificarCiudadFinBtn = new JButton();
            modificarCiudadFinBtn.setBounds(20,60, 200, 20);
            modificarCiudadFinBtn.setText("Modificar Ciudad Final");
            add(modificarCiudadFinBtn);
            
            modificarCiudadFinBtn.addActionListener(e -> {
                try {
                    new VentanaModificarBusCiudadFinal(gestion, numeroBus);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaModificarBusOpcion.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            modificarMatriculaBtn = new JButton();
            modificarMatriculaBtn.setBounds(20,100, 200, 20);
            modificarMatriculaBtn.setText("Modificar Matricula");
            add(modificarMatriculaBtn);
            
            modificarMatriculaBtn.addActionListener(e -> {
                try {
                    new VentanaModificarBusMatricula(gestion, numeroBus);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaModificarBusOpcion.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            volverBtn = new JButton();
            volverBtn.setBounds(20,140, 200, 20);
            volverBtn.setText("Volver");
            add(volverBtn); 
            
            volverBtn.addActionListener(e -> {
                new VentanaMain(gestion);
                this.dispose();
            });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}