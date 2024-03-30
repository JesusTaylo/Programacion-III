package eescenariomariobross;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EscenarioMarioBros extends JPanel {

   
 
       @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

       
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0, 0, getWidth(), getHeight());

        
        g.setColor(new Color(139, 69, 19));
        g.fillRect(0, 400, getWidth(), getHeight() - 400);

       
        int tuberiaX = 450; 
        int tuberiaY = 200; 
        int tuberiaAncho = 100;
        int tuberiaAlto = 400; 

        
        g.setColor(new Color(56, 139, 49)); 
        g.fillRect(tuberiaX, tuberiaY, tuberiaAncho, tuberiaAlto);
        
        g.setColor(new Color(34, 177, 76));
        g.fillRect(tuberiaX + 10, tuberiaY + 10, tuberiaAncho - 20, tuberiaAlto - 20);

        
        g.setColor(Color.BLACK);
        g.drawRect(tuberiaX, tuberiaY, tuberiaAncho, tuberiaAlto);
        g.drawLine(tuberiaX, tuberiaY + 40, tuberiaX + tuberiaAncho, tuberiaY + 40);
        g.drawLine(tuberiaX, tuberiaY + tuberiaAlto - 40, tuberiaX + tuberiaAncho, tuberiaY + tuberiaAlto - 40);
        
        g.setColor(new Color(102, 102, 102));
        g.drawLine(tuberiaX + tuberiaAncho, tuberiaY, tuberiaX + tuberiaAncho, tuberiaY + tuberiaAlto);
        g.drawLine(tuberiaX + tuberiaAncho + 1, tuberiaY, tuberiaX + tuberiaAncho + 1, tuberiaY + tuberiaAlto);
        
        
        int cuadradoX = 90; 
        int cuadradoY = 170; 
        int cuadradoAncho = 180;
        int cuadradoAlto = 230; 
        int cuadradoProfundidad = 70;

        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(30, 144, 255));
        RoundRectangle2D.Double rect1 = new RoundRectangle2D.Double(cuadradoX, cuadradoY, cuadradoAncho, cuadradoAlto, 20, 20);
        g2d.fill(rect1);

       
        g.setColor(Color.GRAY);
        g.fillOval(cuadradoX + 10, cuadradoY + 10, 20, 20); 
        g.fillOval(cuadradoX + cuadradoAncho - 30, cuadradoY + 10, 20, 20); 
        g.fillOval(cuadradoX + 10, cuadradoY + cuadradoAlto - 30, 20, 20); 
        g.fillOval(cuadradoX + cuadradoAncho - 30, cuadradoY + cuadradoAlto - 30, 20, 20); 
        
        int cuadradoX2 = 50; 
        int cuadradoY2 = 200; 

     
        g2d.setColor(new Color(250, 128, 114));
        RoundRectangle2D.Double rect2 = new RoundRectangle2D.Double(cuadradoX2, cuadradoY2, cuadradoAncho, cuadradoAlto, 20, 20);
        g2d.fill(rect2);

       
        g.setColor(Color.GRAY);
        g.fillOval(cuadradoX2 + 10, cuadradoY2 + 10, 20, 20); 
        g.fillOval(cuadradoX2 + cuadradoAncho - 30, cuadradoY2 + 10, 20, 20);
        g.fillOval(cuadradoX2 + 10, cuadradoY2 + cuadradoAlto - 30, 20, 20); 
        g.fillOval(cuadradoX2 + cuadradoAncho - 30, cuadradoY2 + cuadradoAlto - 30, 20, 20); 
        
      
        int cuadradoX3 = 150; 
        int cuadradoY3 = 90; 
        int cuadradoAncho3 = 50;
        int cuadradoAlto3 = 50; 
        
        
       
        GradientPaint gradient = new GradientPaint(cuadradoX3, cuadradoY3, new Color(255, 215, 0, 150), cuadradoX3 + cuadradoAncho3, cuadradoY3 + cuadradoAlto3, new Color(255, 215, 0, 0));
        g2d.setPaint(gradient);
        RoundRectangle2D.Double rect3 = new RoundRectangle2D.Double(cuadradoX3 - 10, cuadradoY3 - 10, cuadradoAncho3 + 20, cuadradoAlto3 + 20, 20, 20);
        g2d.fill(rect3);
        
        
        g2d.setColor(new Color(139, 69, 19));
        RoundRectangle2D.Double rect4 = new RoundRectangle2D.Double(cuadradoX3, cuadradoY3, cuadradoAncho3, cuadradoAlto3, 20, 20);
        g2d.fill(rect4);

        
         
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        g2d.drawString("?", cuadradoX3 + 12, cuadradoY3 + 40);
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Escenario de Mario Bros Estilizado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EscenarioMarioBros());
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
