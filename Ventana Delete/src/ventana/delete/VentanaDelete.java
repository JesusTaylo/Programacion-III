
package ventana.delete;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaDelete extends javax.swing.JFrame {
    
    private final ArrayList<JButton> botones = new ArrayList<>();

    public VentanaDelete() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana con botones dinámicos");
        setSize(400, 300);
        
        getContentPane().setLayout(null); 

        
        getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ventanaMouseClicked(evt);
            }
            
            public void mouseEntered(MouseEvent evt) {
                getContentPane().setBackground(generarColorAleatorio()); 
            }
            
            public void mouseExited(MouseEvent evt) {
                getContentPane().setBackground(generarColorAleatorio()); 
            }
        });
        
    
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                    borrarBotones();
                }
            }
        });
        
       
        setFocusable(true);
        requestFocus();
    }

    private void ventanaMouseClicked(MouseEvent evt) {
       
        int x = evt.getX();
        int y = evt.getY();
        
      
        JButton nuevoBoton = new JButton("Botón " + x + ", " + y);
        nuevoBoton.setBounds(x, y, 100, 30);
        
        
        nuevoBoton.addActionListener((ActionEvent e) -> {
            mostrarCoordenadasCompletas(x, y);
        });
        
        
        getContentPane().add(nuevoBoton);
        botones.add(nuevoBoton);
        

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private Color generarColorAleatorio() {
        
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

       
        return new Color(r, g, b);
    }
    
    private void mostrarCoordenadasCompletas(int x, int y) {
       
        JFrame ventanaCoordenadas = new JFrame("Coordenadas completas");
        ventanaCoordenadas.setSize(200, 100);
        ventanaCoordenadas.setLocationRelativeTo(null);
        
        String mensaje = "Coordenadas: (" + x + ", " + y + ")";
        
        JOptionPane.showMessageDialog(ventanaCoordenadas, mensaje);
    }
    
    private void borrarBotones() {
        for (JButton boton : botones) {
            getContentPane().remove(boton);
        }
        botones.clear();
        
     
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaDelete().setVisible(true);
        });
    }
}