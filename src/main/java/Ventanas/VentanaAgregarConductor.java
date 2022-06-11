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
public final class VentanaAgregarConductor extends JFrame implements ActionListener {
    
    private JTextField nombreApellidoField, rutField, edadField, busField;
    private JButton volverBtn, aceptarBtn;
    private JLabel nombreApellidoLabel, rutLabel, edadLabel, busLabel, tipLabel;
    
    /**
     * Constructor de la ventana Agregar Conductor, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales y campos de llenado.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public VentanaAgregarConductor(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Agregar Conductor");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Agregar Conductor, ya sean botones, zona de texto y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public void componentes(Gestion gestion) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            nombreApellidoLabel = new JLabel();
            nombreApellidoLabel.setBounds(15, 50, 180, 25);
            nombreApellidoLabel.setText("Nombre y Apellido");
            add(nombreApellidoLabel);
            nombreApellidoField = new JTextField();
            nombreApellidoField.setBounds(130, 50, 150, 25);
            add(nombreApellidoField);
            
            rutLabel = new JLabel();
            rutLabel.setBounds(15, 90, 180, 25);
            rutLabel.setText("RUT");
            add(rutLabel);
            rutField = new JTextField();
            rutField.setBounds(130, 90, 150, 25);
            add(rutField);
            
            edadLabel = new JLabel();
            edadLabel.setBounds(15, 130, 180, 25);
            edadLabel.setText("Edad");
            add(edadLabel);
            edadField = new JTextField();
            edadField.setBounds(130, 130, 150, 25);
            add(edadField);
            
            busLabel = new JLabel();
            busLabel.setBounds(15, 170, 180, 25);
            busLabel.setText("Numero Bus");
            add(busLabel);
            busField = new JTextField();
            busField.setBounds(130, 170, 150, 25);
            add(busField);
            
            tipLabel = new JLabel();
            tipLabel.setBounds(130, 195, 250, 25);
            tipLabel.setText("Ingrese 0 si el Conductor no posee un bus");
            add(tipLabel);
            
            volverBtn = new JButton();
            volverBtn.setBounds(15,400, 100, 20);
            volverBtn.setText("Volver");
            add(volverBtn); 
            
            volverBtn.addActionListener(e -> {
                new VentanaMain(gestion);
                this.dispose();
            });
            
            aceptarBtn = new JButton();
            aceptarBtn.setBounds(150,400, 100, 20);
            aceptarBtn.setText("Aceptar");
            add(aceptarBtn); 
            
            aceptarBtn.addActionListener(e -> {
                try {
                    String nombre = nombreApellidoField.getText();
                    String rut = rutField.getText();
                    String edad = edadField.getText();
                    int numeroBus = Integer.parseInt(busField.getText());
                    
                    gestion.AgregarConductor(nombre, rut, edad, numeroBus);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaAgregarConductor.class.getName()).log(Level.SEVERE, null, ex);
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