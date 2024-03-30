import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CasaConCerco extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        g.setColor(new Color(135, 206, 250)); 
        g.fillRect(0, 0, getWidth(), getHeight());

        
        g.setColor(new Color(0, 128, 0)); 
        g.fillRect(0, 400, getWidth(), getHeight() - 400);

        
        g.setColor(new Color(255, 102, 102)); 
        g.fillRect(100, 300, 200, 150); 
        g.setColor(Color.BLACK);
        g.drawRect(100, 300, 200, 150); 
        g.drawLine(100, 300, 200, 200); 
        g.drawLine(300, 300, 200, 200);

       
        g.setColor(new Color(139, 69, 19)); 
        g.fillRect(180, 390, 40, 60); 
        g.setColor(Color.BLACK);
        g.drawRect(180, 390, 40, 60); 

    
        g.setColor(Color.YELLOW);
        g.fillRect(120, 330, 40, 40);
        g.fillRect(240, 330, 40, 40); 

       
        g.setColor(new Color(139, 69, 19)); 
        for (int i = 0; i < 10; i++) {
            g.fillRect(50 * i, 400, 2, 100);
        }
        g.fillRect(0, 400, getWidth(), 2); 
        g.fillRect(0, 500, getWidth(), 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Casa con Cerco");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CasaConCerco());
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
