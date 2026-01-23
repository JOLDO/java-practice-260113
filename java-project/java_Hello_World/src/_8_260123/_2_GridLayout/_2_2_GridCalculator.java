package _8_260123._2_GridLayout;

import javax.swing.*;
import java.awt.*;

public class _2_2_GridCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("계산기 키패드");
        JPanel panel = new JPanel(new GridLayout(4, 3, 5, 5)); // 4행 3열, 간격 5px
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("" + i));
        }
        panel.add(new JButton("*"));
        panel.add(new JButton("0"));
        panel.add(new JButton("#"));

        frame.add(panel);
        frame.setSize(200, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
