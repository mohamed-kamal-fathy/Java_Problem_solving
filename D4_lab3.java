package src.Main;

import javax.swing.*;
import java.awt.*;

class Bouncing extends JPanel implements Runnable {

    private int x = 30, y = 30;
    private int radius = 15;
    private int dx = 4, dy = 4;

    public Bouncing() {
        setBackground(Color.CYAN);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, radius, radius);
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;

            if (x < 0 || x + radius > getWidth()) {
                dx *= -1;
            }
            if (y < 0 || y + radius > getHeight()) {
                dy *= -1;
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class D4_lab3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello World Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(350,350);
            frame.setLocationRelativeTo(null);
            frame.add(new Bouncing());
            frame.setVisible(true);});
    }
}
