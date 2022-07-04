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
public final class VentanaModificarBus extends JFrame implements ActionListener {
    
    private JTextField numeroBusField;
    private JButton volverBtn, aceptarBtn;
    private JLabel numeroBusLabel;
    
    /**
     * Constructor de la ventana Modificar Bus, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales y campos de llenado.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public VentanaModificarBus(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,170);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Modificar Bus");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Modificar Bus, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public void componentes(Gestion gestion) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            numeroBusLabel = new JLabel();
            numeroBusLabel.setBounds(15, 20, 180, 25);
            numeroBusLabel.setText("Numero Bus");
            add(numeroBusLabel);
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
            aceptarBtn.setText("Aceptar");
            add(aceptarBtn); 
            
            aceptarBtn.addActionListener(e -> {
                int numeroBus = Integer.parseInt(numeroBusField.getText());
                if(gestion.editarBusVerificar(numeroBus) == true){
                    try {
                        this.dispose();
                        new VentanaModificarBusOpcion(gestion, numeroBus);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaModificarBus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, "El bus no existe");
                    try {
                        new VentanaModificarBus(gestion);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaModificarBus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}