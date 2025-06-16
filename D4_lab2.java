package src.Main;

import javax.swing.*;
import java.awt.*;

public class D4_lab2 extends JPanel implements Runnable {

    private String text = " Welcome to my Application (mohamed kamal)";
    private int x;
    private Thread thread;

    public D4_lab2() {
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        setFont(new Font("SansSerif", Font.BOLD, 50));
        x = getPreferredSize().width;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        g.drawString(text, x, getHeight() / 2 + getFont().getSize() / 2 -10);
    }

    @Override
    public void run() {
        while (true) {
            x -= 6;
            int textWidth = getFontMetrics(getFont()).stringWidth(text);
            if (x + textWidth < 0) {
                x = getWidth();
            }
            repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mohamed Kamal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new D4_lab2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
