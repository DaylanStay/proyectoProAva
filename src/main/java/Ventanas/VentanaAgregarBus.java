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
public final class VentanaAgregarBus extends JFrame implements ActionListener {
    
    private JTextField numeroBusField;
    private JButton volverBtn, verificarBtn;
    private JLabel numeroBusLabel, avisoLabel;
    
    
    /**
     * Constructor de la ventana Agregar Bus, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales y campo de llenado.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public VentanaAgregarBus(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Agregar Bus");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Agregar Bus, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public void componentes(Gestion gestion) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 200);
            
            avisoLabel = new JLabel();
            avisoLabel.setBounds(10, 10, 350, 25);
            avisoLabel.setText("En caso de no poner un numero, el programa se caerá.");
            add(avisoLabel);
            
            verificarBtn = new JButton();
            verificarBtn.setBounds(270,50, 100, 25);
            verificarBtn.setText("Verificar");
            add(verificarBtn);
            
            numeroBusLabel = new JLabel();
            numeroBusLabel.setBounds(15, 50, 180, 25);
            numeroBusLabel.setText("Numero de Bus");
            add(numeroBusLabel);
            numeroBusField = new JTextField();
            numeroBusField.setBounds(110, 50, 150, 25);
            add(numeroBusField);
            
            verificarBtn.addActionListener(e -> {
                int nBus = Integer.parseInt(numeroBusField.getText());
                if(gestion.verificarBus(nBus) == true){
                    try {
                        new VentanaAgregarBusVerificado(gestion, nBus);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaAgregarBus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                }else{
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, "El número de bus se encuentra ocupado, intente con otro");
                    
                    try {
                        new VentanaAgregarBus(gestion);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaAgregarBus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.dispose();
            });
            
            volverBtn = new JButton();
            volverBtn.setBounds(15,100, 100, 20);
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