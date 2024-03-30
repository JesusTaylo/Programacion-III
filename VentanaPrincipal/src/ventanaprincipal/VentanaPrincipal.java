package ventanaprincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana con botones");
        setSize(400, 300);
        getContentPane().setLayout(null); 
        
        
        getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ventanaMouseClicked(evt);
            }
        });
    }

    private void ventanaMouseClicked(MouseEvent evt) {
        Random rand = new Random();
        
       
        int cantidadBotones = rand.nextInt(5) + 1;
        
       
        int anchoBoton = 50; 
        int altoBoton = 30;   
        
        for (int i = 0; i < cantidadBotones; i++) {
            
            Color colorAleatorio = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

            
            int posX = rand.nextInt(getContentPane().getWidth() - anchoBoton);
            int posY = rand.nextInt(getContentPane().getHeight() - altoBoton);

           
            JButton nuevoBoton = new JButton();
            nuevoBoton.setText("Botón " + rand.nextInt(1000)); 
            nuevoBoton.setSize(new Dimension(anchoBoton, altoBoton));
            nuevoBoton.setBackground(colorAleatorio);
            nuevoBoton.setLocation(posX, posY);

           
            nuevoBoton.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Coordenadas del botón: (" + posX + ", " + posY + ")");
            });

            
            getContentPane().add(nuevoBoton);
        }
        
        
        revalidate();
        repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}