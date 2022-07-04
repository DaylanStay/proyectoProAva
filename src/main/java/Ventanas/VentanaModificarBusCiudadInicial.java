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
public final class VentanaModificarBusCiudadInicial extends JFrame implements ActionListener {
    
    private JTextField ciudadInicialField;
    private JButton volverBtn, aceptarBtn;
    private JLabel ciudadInicialLabel;
    
    /**
     * Constructor de la ventana Modificar Bus Ciudad Inicial, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales y campos de llenado.
     *
     * @param gestion almacena toda la información y la administra.
     * @param numeroBus numero del bus.
     * @throws IOException
     */
    public VentanaModificarBusCiudadInicial(Gestion gestion, int numeroBus) throws IOException {
        componentes(gestion, numeroBus);
        
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
     * ventana Modificar Bus Ciudad Inicial, ya sean botones, zona de texto y
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
            
            ciudadInicialLabel = new JLabel();
            ciudadInicialLabel.setBounds(15, 20, 180, 25);
            ciudadInicialLabel.setText("Nueva Ciudad Inicial");
            add(ciudadInicialLabel);
            ciudadInicialField = new JTextField();
            ciudadInicialField.setBounds(130, 20, 150, 25);
            add(ciudadInicialField);
            
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
                try {
                    String ciudadInicial = ciudadInicialField.getText();
                    
                    gestion.editarBus(numeroBus, 1, ciudadInicial, "", "");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, "El bus fue modificado con exito."); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaAgregarConductor.class.getName()).log(Level.SEVERE, null, ex);
                }
                new VentanaMain(gestion);
            });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}