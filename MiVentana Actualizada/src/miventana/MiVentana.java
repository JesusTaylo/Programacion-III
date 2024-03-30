package miventana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MiVentana extends javax.swing.JFrame {

    public MiVentana() {
        initComponents();
    }

    private void initComponents() {

        botonPresionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana con botones");

        botonPresionar.setText("Clickea me");
        botonPresionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonPresionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(botonPresionar)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(botonPresionar)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
    }

    private void botonPresionarActionPerformed(ActionEvent evt) {
        Random rand = new Random();
        
        
        int ancho = rand.nextInt(100) + 50; 
        int alto = rand.nextInt(50) + 30;   
        
        
        Color colorAleatorio = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        
        
        int posX = rand.nextInt(this.getWidth() - ancho);
        int posY = rand.nextInt(this.getHeight() - alto);
        
        
        JButton nuevoBoton = new JButton();
        nuevoBoton.setText(String.format("#%02x%02x%02x", colorAleatorio.getRed(), colorAleatorio.getGreen(), colorAleatorio.getBlue())); // Texto aleatorio basado en el código de color
        nuevoBoton.setSize(new Dimension(ancho, alto));
        nuevoBoton.setBackground(colorAleatorio);
        nuevoBoton.setLocation(posX, posY);
        
        
        nuevoBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Texto del botón: " + nuevoBoton.getText());
            }
        });
        
       
        getContentPane().add(nuevoBoton);
        
      
        revalidate();
        repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiVentana().setVisible(true);
            }
        });
    }

    private javax.swing.JButton botonPresionar;
}