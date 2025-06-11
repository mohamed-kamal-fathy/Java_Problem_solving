package src.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class D3_lab1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("قائمة الخطوط");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        // الحصول على جميع أسماء الخطوط المتاحة
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        Arrays.sort(fontNames);

        // إضافة كل خط إلى اللوحة بنفس الخط
        for (String fontName : fontNames) {
            try {
                JLabel label = new JLabel(fontName);
                label.setFont(new Font(fontName, Font.PLAIN, 16));
                panel.add(label);
                panel.add(Box.createRigidArea(new Dimension(0, 5)));
            } catch (Exception e) {
                // إذا كان الخط غير مدعوم، استخدم الخط الافتراضي
                JLabel label = new JLabel(fontName + " (غير مدعوم)");
                panel.add(label);
                panel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }

        frame.setVisible(true);
    }
}
