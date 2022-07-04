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
public final class VentanaEliminarBus extends JFrame implements ActionListener {
    
    private JTextField rutField;
    private JButton volverBtn, eliminarMatriculaBtn, eliminarNumeroBtn;
    
    /**
     * Constructor de la ventana Eliminar Bus, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales y campos de llenado.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public VentanaEliminarBus(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270,190);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Eliminar Bus");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Eliminar Bus, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public void componentes(Gestion gestion) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            eliminarMatriculaBtn = new JButton();
            eliminarMatriculaBtn.setBounds(20,20, 200, 20);
            eliminarMatriculaBtn.setText("Eliminar por matricula");
            add(eliminarMatriculaBtn);
            
            eliminarMatriculaBtn.addActionListener(e -> {
                try {
                    new VentanaEliminarBusMatricula(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaEliminarBus.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            eliminarNumeroBtn = new JButton();
            eliminarNumeroBtn.setBounds(20,60, 200, 20);
            eliminarNumeroBtn.setText("Eliminar por numero de bus");
            add(eliminarNumeroBtn);
            
            eliminarNumeroBtn.addActionListener(e -> {
                try {
                    new VentanaEliminarBusNumero(gestion);
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