package src.Main;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

class Date_Time extends JPanel implements Runnable {

    private JLabel dateTimeLabel;

    public Date_Time() {
        setBackground(Color.BLUE);
        setLayout(new GridBagLayout());
        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        dateTimeLabel.setForeground(Color.BLACK);
        add(dateTimeLabel);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
        while (true) {
            String currentTime = sdf.format(new java.util.Date());
            dateTimeLabel.setText(currentTime);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class D4_lab1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello World Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.add(new Date_Time());
            frame.setVisible(true);});
    }
}
