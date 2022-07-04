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
public final class VentanaEliminarBusNumero extends JFrame implements ActionListener {
    
    private JTextField numeroBusField;
    private JButton volverBtn, aceptarBtn;
    private JLabel rutLabel;
    
    /**
     * Constructor de la ventana Eliminar Bus Numero, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales y campos de llenado.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public VentanaEliminarBusNumero(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,170);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Eliminar Bus");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Eliminar Bus Numero, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public void componentes(Gestion gestion) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            rutLabel = new JLabel();
            rutLabel.setBounds(15, 20, 180, 25);
            rutLabel.setText("Numero Bus");
            add(rutLabel);
            numeroBusField = new JTextField();
            numeroBusField.setBounds(130, 20, 150, 25);
            add(numeroBusField);
            
            volverBtn = new JButton();
            volverBtn.setBounds(15,80, 100, 20);
            volverBtn.setText("Volver");
            add(volverBtn); 
            
            volverBtn.addActionListener(e -> {
                new VentanaMain(gestion);
                this.dispose();
            });
            
            aceptarBtn = new JButton();
            aceptarBtn.setBounds(150,80, 100, 20);
            aceptarBtn.setText("Eliminar");
            add(aceptarBtn); 
            
            aceptarBtn.addActionListener(e -> {
                try {
                    String dato = numeroBusField.getText();
                    
                    if(gestion.eliminarBus(dato, 2)){
                        JFrame avisoVerificador = new JFrame();
                        this.dispose();
                        JOptionPane.showMessageDialog(avisoVerificador, "El bus ha sido eliminado correctamente.");
                        new VentanaMain(gestion);
                        this.dispose();
                    }else{
                        JFrame avisoVerificador = new JFrame();
                        this.dispose();
                        JOptionPane.showMessageDialog(avisoVerificador, "El bus no existe.");
                        new VentanaEliminarBusMatricula(gestion);
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(VentanaAgregarConductor.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}