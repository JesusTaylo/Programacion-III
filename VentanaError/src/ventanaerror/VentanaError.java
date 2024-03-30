package ventanaerror;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaError extends javax.swing.JFrame {

    public VentanaError() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana con botones");
        setSize(400, 300);

       
        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

       
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
    }

    private void panelMouseClicked(MouseEvent evt) {
       
        JButton nuevoBoton = new JButton();
        nuevoBoton.setText("Botón " + panel.getComponentCount()); 
        nuevoBoton.setSize(new Dimension(50, 30)); 

        
        Color colorAleatorio = generarColorAleatorio();
        nuevoBoton.setBackground(colorAleatorio);

        nuevoBoton.setLocation(evt.getX(), evt.getY()); 

       
        nuevoBoton.addActionListener(e -> {
            JButton botonClicado = (JButton) e.getSource(); 
            panel.remove(botonClicado); 
            panel.revalidate();
            panel.repaint();
        });

        
        panel.add(nuevoBoton);

        
        panel.revalidate();
        panel.repaint();
    }

    private Color generarColorAleatorio() {
   
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        
        return new Color(r, g, b);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaError().setVisible(true);
            }
        });
    }

                   
    private javax.swing.JPanel panel;
                 
}