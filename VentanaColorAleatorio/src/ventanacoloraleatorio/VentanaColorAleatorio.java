package ventanacoloraleatorio;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class VentanaColorAleatorio extends javax.swing.JFrame {

    public VentanaColorAleatorio() {
        initComponents();
        iniciarTimer();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana con cambio de color aleatorio");
        setSize(400, 300);
        
        getContentPane().setBackground(Color.WHITE); 

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                cambiarColorAleatorio();
            }

            public void mouseExited(MouseEvent evt) {
                cambiarColorAleatorio(); 
            }
        });
    }

    private void iniciarTimer() {
        Timer timer = new Timer(1000, e -> {
            cambiarColorAleatorio(); 
        });
        timer.start();
    }

    private void cambiarColorAleatorio() {
       
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        
        getContentPane().setBackground(new Color(r, g, b));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaColorAleatorio().setVisible(true);
            }
        });
    }
}
