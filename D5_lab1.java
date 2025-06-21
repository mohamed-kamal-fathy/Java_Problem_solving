package src.Main;

import javax.swing.*;
import java.awt.*;

public class D5_lab1 extends JFrame {
    private int counter = 0;
    private JLabel label;

    public D5_lab1() {
        setTitle("Hello World Frame");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Lab5a1 panel = new Lab5a1();
        add(panel);
    }

    private class Lab5a1 extends JPanel {
        public Lab5a1() {
            setBackground(Color.CYAN);
            setFocusable(true);
            setLayout(null);
            JButton incBtn = new JButton("++");
            JButton minBtn = new JButton("--");
            label = new JLabel("x = " + counter);
            label.setFont(new Font("SansSerif", Font.PLAIN, 18));
            incBtn.setBounds(140, 30, 80, 40);
            minBtn.setBounds(230, 30, 60, 40);
            label.setBounds(240, 200, 150, 50);
            incBtn.addActionListener(e -> {
                counter++;
                updateLabel();
            });

            minBtn.addActionListener(e -> {
                counter--;
                updateLabel();
            });

            add(incBtn);
            add(minBtn);
            add(label);
        }

        private void updateLabel() {
            label.setText("x = " + counter);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new D5_lab1().setVisible(true);
        });
    }
}

