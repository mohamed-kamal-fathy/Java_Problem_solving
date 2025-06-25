package src.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class D5_lab3_2 extends JFrame {
    public D5_lab3_2() {
        setTitle("Hello World Frame");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Lab5d1 panel = new draw();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new D5_lab3_2().setVisible(true);
        });
    }
}

class Line {
    int x1, y1, x2, y2;
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

class  Lab5d1 extends JPanel {
    private int startX, startY, endX, endY;
    private java.util.List<Line> lines = new ArrayList<>();
    private boolean drawing = false;

    public Lab5d1() {
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
                lines.add(new Line(startX, startY, endX, endY));
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
        g.setColor(Color.BLACK);

        for (Line line : lines) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }

        if (drawing) {
            g.drawLine(startX, startY, endX, endY);
        }
    }
}

