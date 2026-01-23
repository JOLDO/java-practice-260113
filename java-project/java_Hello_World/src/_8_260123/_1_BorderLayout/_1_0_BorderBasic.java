package _8_260123._1_BorderLayout;

import javax.swing.*;
import java.awt.*;

public class _1_0_BorderBasic {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout 기본");
//        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new JButton("하나"), BorderLayout.NORTH);
        panel.add(new JButton("둘"), BorderLayout.WEST);
        panel.add(new JButton("셋"), BorderLayout.CENTER);
        panel.add(new JButton("넷"), BorderLayout.EAST);
        panel.add(new JButton("다섯"), BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
