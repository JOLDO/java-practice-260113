package _8_260123._0_FlowLayout;

import javax.swing.*;
import java.awt.*;

public class _0_2_FlowWrap {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout 줄바꿈");
        JPanel panel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 6; i++) {
            panel.add(new JButton("버튼" + i));
        }
        frame.add(panel);
        frame.setSize(250, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
