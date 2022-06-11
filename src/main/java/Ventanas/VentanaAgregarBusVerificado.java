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
public final class VentanaAgregarBusVerificado extends JFrame implements ActionListener {
    
    private JTextField matriculaField, ciudadInicioField, ciudadDestinoField;
    private JButton volverBtn, aceptarBtn, verificarBtn;
    private JLabel matriculaLabel, ciudadInicioLabel, ciudadDestinoLabel;
    private String matricula, ciudadInicio, ciudadDestino;
    
    /**
     * Constructor de la ventana Agregar bus cuando ya se encuentra verificado, 
     * usado para construir una de las ventanas que sigue después de verificar si el número
     * de bus está ocupado o no, con sus respectivos valores iniciales.
     * @param gestion almacena toda la información y la administra.
     * @param nBus almacena el número del bus.
     * @throws IOException
     */
    public VentanaAgregarBusVerificado(Gestion gestion, int nBus) throws IOException {
        componentes(gestion, nBus);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Agregar Bus");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Agregar Bus Verificado, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @param numeroBus almacena el número del bus.
     * @throws IOException
     */
    public void componentes(Gestion gestion, int numeroBus) throws IOException {
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 200);
            
            matriculaLabel = new JLabel();
            matriculaLabel.setBounds(15, 50, 180, 25);
            matriculaLabel.setText("Matricula");
            add(matriculaLabel);
            matriculaField = new JTextField();
            matriculaField.setBounds(130, 50, 150, 25);
            add(matriculaField);
            
            ciudadInicioLabel = new JLabel();
            ciudadInicioLabel.setBounds(15, 90, 180, 25);
            ciudadInicioLabel.setText("Ciudad de Inicio");
            add(ciudadInicioLabel);
            ciudadInicioField = new JTextField();
            ciudadInicioField.setBounds(130, 90, 150, 25);
            add(ciudadInicioField);
            
            ciudadDestinoLabel = new JLabel();
            ciudadDestinoLabel.setBounds(15, 130, 180, 25);
            ciudadDestinoLabel.setText("Ciudad de Destino");
            add(ciudadDestinoLabel);
            ciudadDestinoField = new JTextField();
            ciudadDestinoField.setBounds(130, 130, 150, 25);
            add(ciudadDestinoField);
            
            volverBtn = new JButton();
            volverBtn.setBounds(15,300, 100, 20);
            volverBtn.setText("Volver");
            add(volverBtn); 
            
            volverBtn.addActionListener(e -> {
                new VentanaMain(gestion);
                this.dispose();
            });
            
            aceptarBtn = new JButton();
            aceptarBtn.setBounds(250,300, 100, 20);
            aceptarBtn.setText("Aceptar");
            add(aceptarBtn); 
            
            aceptarBtn.addActionListener(e -> {
                
                matricula = matriculaField.getText();
                ciudadInicio = ciudadInicioField.getText();
                ciudadDestino = ciudadDestinoField.getText();
                
                try {
                    gestion.AgregarBus(numeroBus, matricula, ciudadInicio, ciudadDestino);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaAgregarBusVerificado.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                new VentanaMain(gestion);
                this.dispose();
            });  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}