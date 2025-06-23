package src.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class D5_lab3_1 extends JFrame {
    public D5_lab3_1() {
        setTitle("Hello World Frame");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Lab5c1 panel = new Lab5c1();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new D5_lab3_1().setVisible(true);});
    }
}

class Lab5c1 extends JPanel {
    private int startX, startY, endX, endY;
    private boolean drawing = false;

    public Lab5c1() {
        setBackground(Color.CYAN);
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                drawing = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawing = false;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawing || (startX != endX || startY != endY)) {
            g.setColor(Color.BLACK);
            g.drawLine(startX, startY, endX, endY);
        }
    }
}
