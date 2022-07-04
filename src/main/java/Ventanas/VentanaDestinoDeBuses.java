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
public final class VentanaDestinoDeBuses extends JFrame implements ActionListener {
    private JButton volverBtn, valparaisoBtn, santiagoBtn, concepcionBtn;
    private JButton copiapoBtn, iquiqueBtn, temucoBtn, rancaguaBtn, puertoMonttBtn;
    private JButton chillanBtn, vinaBtn, atacamaBtn, talcaBtn, talcahuanoBtn;
    
    /**
     * Constructor de la ventana Destino de Buses, usado para construir una
     * de las ventanas que ofrece la ventana principal, con sus respectivos
     * valores iniciales.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public VentanaDestinoDeBuses(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Destino de Buses");
        setAlwaysOnTop(true);
    }
    
    /**
     * Metodo que inicializa los distintos componentes que pertenecen a la
     * ventana Destino de Buses, ya sean botones y
     * demás componentes.
     *
     * @param gestion almacena toda la información y la administra.
     * @throws IOException
     */
    public void componentes(Gestion gestion) throws IOException {
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
            
            valparaisoBtn = new JButton();
            valparaisoBtn.setBounds(20,20, 200, 20);
            valparaisoBtn.setText("Valparaiso");
            add(valparaisoBtn);
            
            valparaisoBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Valparaiso");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            santiagoBtn = new JButton();
            santiagoBtn.setBounds(20,60, 200, 20);
            santiagoBtn.setText("Santiago");
            add(santiagoBtn);
            
            santiagoBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Santiago");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            concepcionBtn = new JButton();
            concepcionBtn.setBounds(20,100, 200, 20);
            concepcionBtn.setText("Concepcion");
            add(concepcionBtn);
            
            concepcionBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Concepcion");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            copiapoBtn = new JButton();
            copiapoBtn.setBounds(20,140, 200, 20);
            copiapoBtn.setText("Copiapo");
            add(copiapoBtn);
            
            copiapoBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Copiapo");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            iquiqueBtn = new JButton();
            iquiqueBtn.setBounds(20,180, 200, 20);
            iquiqueBtn.setText("Iquique");
            add(iquiqueBtn);
            
            iquiqueBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Iquique");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            temucoBtn = new JButton();
            temucoBtn.setBounds(20,220, 200, 20);
            temucoBtn.setText("Temuco");
            add(temucoBtn);
            
            temucoBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Temuco");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            rancaguaBtn = new JButton();
            rancaguaBtn.setBounds(20,260, 200, 20);
            rancaguaBtn.setText("Rancagua");
            add(rancaguaBtn);
            
            rancaguaBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Rancagua");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            puertoMonttBtn = new JButton();
            puertoMonttBtn.setBounds(20,300, 200, 20);
            puertoMonttBtn.setText("Puerto Montt");
            add(puertoMonttBtn);
            
            puertoMonttBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("PuertoMontt");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            chillanBtn = new JButton();
            chillanBtn.setBounds(20,340, 200, 20);
            chillanBtn.setText("Chillan");
            add(chillanBtn);
            
            chillanBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Chillan");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            vinaBtn = new JButton();
            vinaBtn.setBounds(20,380, 200, 20);
            vinaBtn.setText("Viña Del Mar");
            add(vinaBtn);
            
            vinaBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Viña Del Mar");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            atacamaBtn = new JButton();
            atacamaBtn.setBounds(20,420, 200, 20);
            atacamaBtn.setText("Atacama");
            add(atacamaBtn);
            
            atacamaBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Atacama");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            talcaBtn = new JButton();
            talcaBtn.setBounds(20,460, 200, 20);
            talcaBtn.setText("Talca");
            add(talcaBtn);
            
            talcaBtn.addActionListener(e -> {
               try {
                    String cadena = gestion.BusesPorViaje("Talca");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            talcahuanoBtn = new JButton();
            talcahuanoBtn.setBounds(20,500, 200, 20);
            talcahuanoBtn.setText("Talcahuano");
            add(talcahuanoBtn);
            
            talcahuanoBtn.addActionListener(e -> {
                try {
                    String cadena = gestion.BusesPorViaje("Talcahuano");
                    JFrame avisoVerificador = new JFrame();
                    this.dispose();
                    JOptionPane.showMessageDialog(avisoVerificador, cadena); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new VentanaDestinoDeBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaDestinoDeBuses.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            volverBtn = new JButton();
            volverBtn.setBounds(20,540, 200, 20);
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