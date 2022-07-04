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
public final class VentanaModificarConductorOpcion extends JFrame implements ActionListener {
    
    private JButton volverBtn, eliminarMatriculaBtn, eliminarNumeroBtn;
    
    /**
     * Constructor de la ventana Modificar Conductor Opcion, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales.
     *
     * @param gestion almacena toda la información y la administra.
     * @param rut rut del conductor.
     * @throws IOException
     */
    public VentanaModificarConductorOpcion(Gestion gestion, String rut) throws IOException {
        componentes(gestion, rut);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270,190);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Modificar Conductor");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Modificar Conductor Opcion, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @param rut rut del conductor.
     * @throws IOException
     */
    public void componentes(Gestion gestion, String rut) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            eliminarMatriculaBtn = new JButton();
            eliminarMatriculaBtn.setBounds(20,20, 200, 20);
            eliminarMatriculaBtn.setText("Modificar Nombre");
            add(eliminarMatriculaBtn);
            
            eliminarMatriculaBtn.addActionListener(e -> {
                try {
                    new VentanaModificarConductorNombre(gestion, rut);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaEliminarBus.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            eliminarNumeroBtn = new JButton();
            eliminarNumeroBtn.setBounds(20,60, 200, 20);
            eliminarNumeroBtn.setText("Modificar Edad");
            add(eliminarNumeroBtn);
            
            eliminarNumeroBtn.addActionListener(e -> {
                try {
                    new VentanaModificarConductorEdad(gestion, rut);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaEliminarBus.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            volverBtn = new JButton();
            volverBtn.setBounds(20,100, 200, 20);
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