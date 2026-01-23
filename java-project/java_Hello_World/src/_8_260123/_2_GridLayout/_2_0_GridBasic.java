package _8_260123._2_GridLayout;

import javax.swing.*;
import java.awt.*;

public class _2_0_GridBasic {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2x2 Grid");
        JPanel panel = new JPanel(new GridLayout(2, 2));
//        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 20));  //간격추가

        panel.add(new JButton("A"));
        panel.add(new JButton("B"));
        panel.add(new JButton("C"));
        panel.add(new JButton("D"));

        frame.add(panel);
        frame.setSize(200, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
