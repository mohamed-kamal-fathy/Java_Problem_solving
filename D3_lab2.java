package src.Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;


public class D3_lab2 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(.8f));
        int panelWidth = getWidth();
        int centerX = panelWidth / 2;
        Color lampYellow = new Color(255, 255, 153);
        setBackground(Color.WHITE);
        int topW = 220, topH = 40;
        int topX = centerX - topW / 2;
        int topY = 50;
        Ellipse2D topEllipse = new Ellipse2D.Double(topX, topY, topW, topH);

        int bodyTopY = topY + topH / 2;
        int bodyBottomY = 230;
        int bodyWTop = 220;
        int bodyWBottom = 340;

        GeneralPath body = new GeneralPath();
        int topLeftX = centerX - bodyWTop / 2;
        int topRightX = centerX + bodyWTop / 2;
        int bottomLeftX = centerX - bodyWBottom / 2;
        int bottomRightX = centerX + bodyWBottom / 2;

        body.moveTo(topLeftX, bodyTopY);
        body.lineTo(bottomLeftX, bodyBottomY);
        body.curveTo(bottomLeftX, bodyBottomY + 40, bottomRightX, bodyBottomY + 40, bottomRightX, bodyBottomY);
        body.lineTo(topRightX, bodyTopY);
        body.append(new Arc2D.Double(topX, topY, topW, topH, 0, -180, Arc2D.OPEN), true);
        body.closePath();

        g2.setColor(Color.WHITE);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);

        g2.setColor(lampYellow);
        g2.fill(topEllipse);
        g2.setColor(Color.BLACK);
        g2.draw(topEllipse);

        g2.setColor(lampYellow);
        g2.fillOval(centerX - 130, 140, 45, 85);
        g2.fillOval(centerX - 45, 115, 90, 135);
        g2.fillOval(centerX + 85, 140, 45, 85);

        g2.setColor(Color.BLACK);
        g2.drawOval(centerX - 130, 140, 45, 85);
        g2.drawOval(centerX - 45, 115, 90, 135);
        g2.drawOval(centerX + 85, 140, 45, 85);

        int legTopY = 260;
        int legBottomLeftX = centerX - 30;
        int legBottomRightX = centerX + 30;
        int legBottomY = 340;

        g2.drawLine(centerX - 10, legTopY, legBottomLeftX, legBottomY);
        g2.drawLine(centerX + 10, legTopY, legBottomRightX, legBottomY);

        int baseWidth = 240, baseHeight = 25;
        int baseX = centerX - baseWidth / 2;
        int baseY = legBottomY;

        g2.setColor(Color.WHITE);
        g2.fillRect(baseX, baseY, baseWidth, baseHeight);
        g2.setColor(Color.BLACK);
        g2.drawRect(baseX, baseY, baseWidth, baseHeight);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Lamp");
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new D3_lab2());
        f.setVisible(true);
    }
}