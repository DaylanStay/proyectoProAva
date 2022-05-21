package Ventanas;

import proyecto.Gestion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public final class VentanaMostrarConductores extends JFrame implements ActionListener {
    
    private JTextArea subtitulo;
    private JButton salirBtn, volverBtn;
    private JScrollPane barraVertical;
    
    public VentanaMostrarConductores(Gestion gestion) throws IOException {
        componentes(gestion);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Mostrar Conductores");
        setAlwaysOnTop(true);
    }
    
    public void componentes(Gestion gestion) throws IOException {
        
            JPanel panel = new JPanel();
            panel.setLayout( new BorderLayout());
            panel.setBounds(15, 15, 350, 360);
        
            subtitulo = new JTextArea();
            subtitulo.setBounds(15, 15, 350, 360);
            subtitulo.setText(gestion.MostrarConductores());
            subtitulo.setEditable(false);
            
            barraVertical = new JScrollPane(subtitulo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panel.add( barraVertical, BorderLayout.CENTER);
            add(panel);

            salirBtn = new JButton();
            salirBtn.setBounds(265,400, 100, 20);
            salirBtn.setText("Salir");
            add(salirBtn);
            
            salirBtn.addActionListener(e -> {
                this.dispose();
            });
            
            volverBtn = new JButton();
            volverBtn.setBounds(15,400, 100, 20);
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