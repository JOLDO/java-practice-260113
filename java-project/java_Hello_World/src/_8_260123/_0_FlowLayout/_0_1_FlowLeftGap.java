package _8_260123._0_FlowLayout;

import javax.swing.*;
import java.awt.*;

public class _0_1_FlowLeftGap {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout 왼쪽정렬+간격");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 30));

        panel.add(new JButton("하나"));
        panel.add(new JButton("둘"));
        panel.add(new JButton("셋"));

        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
