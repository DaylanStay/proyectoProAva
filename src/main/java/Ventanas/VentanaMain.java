package Ventanas;

import proyecto.Gestion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author cesar
 */
public final class VentanaMain extends JFrame implements ActionListener {
    
    private JLabel subtitulo;
    private JButton mostrarConductores, mostrarBuses, mostrarBusesConductores, salirBtn;
    
    /**
     *
     * @param gestion
     */
    public VentanaMain(Gestion gestion) {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Menu Principal");
        setAlwaysOnTop(true);
    }
    
    /**
     *
     * @param gestion
     */
    public void componentes(Gestion gestion) {
            subtitulo = new JLabel();
            subtitulo.setBounds(125, 25, 180, 20);
            subtitulo.setText("Seleccione  una  opción");
            add(subtitulo);
           
            mostrarConductores = new JButton();
            mostrarConductores.setBounds(100, 50, 180, 20);
            mostrarConductores.setText("Mostrar Conductores");
            add(mostrarConductores);
            
            mostrarConductores.addActionListener(e -> {
                try {
                    new VentanaMostrarConductores(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            mostrarBuses = new JButton();
            mostrarBuses.setBounds(100, 90, 180, 20);
            mostrarBuses.setText("Mostrar Buses");
            add(mostrarBuses);
            
            mostrarBuses.addActionListener(e -> {
                try {
                    new VentanaMostrarBuses(gestion);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            });
            
            mostrarBusesConductores = new JButton();
            mostrarBusesConductores.setBounds(70, 130, 240, 20);
            mostrarBusesConductores.setText("Mostrar Buses y sus Conductores");
            add(mostrarBusesConductores);
            
            mostrarBusesConductores.addActionListener(e -> {
                new VentanaMostrarBusesConductores(gestion);
                this.dispose();
            });
            
            salirBtn = new JButton();
            salirBtn.setBounds(120,400, 150, 20);
            salirBtn.setText("Cerrar Interfaz");
            add(salirBtn);

            salirBtn.addActionListener(e -> {
                this.dispose();
            });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
