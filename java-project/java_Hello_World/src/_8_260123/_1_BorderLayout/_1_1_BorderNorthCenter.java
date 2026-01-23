package _8_260123._1_BorderLayout;

import javax.swing.*;
import java.awt.*;

public class _1_1_BorderNorthCenter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout 북,중앙 배치");
//        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());

        //글 가운데 정렬
        panel.add(new JLabel("제목", SwingConstants.CENTER), BorderLayout.NORTH);
        panel.add(new JTextArea(5, 30), BorderLayout.CENTER);

        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
