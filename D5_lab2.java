package src.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class D5_lab2 extends JFrame implements KeyListener {
    private int x = 200;
    private int y = 150;
    private final int STEP = 10;
    private DrawPanel panel;

    public D5_lab2() {
        setTitle("Hello World Frame");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new DrawPanel();
        panel.setBackground(Color.CYAN);
        add(panel);
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                y -= STEP;
                break;
            case KeyEvent.VK_DOWN:
                y += STEP;
                break;
            case KeyEvent.VK_LEFT:
                x -= STEP;
                break;
            case KeyEvent.VK_RIGHT:
                x += STEP;
                break;
        }
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawString("Hello Java", x, y);
        }
    }

    public static void main(String[] args) {
        new D5_lab2();
    }
}



