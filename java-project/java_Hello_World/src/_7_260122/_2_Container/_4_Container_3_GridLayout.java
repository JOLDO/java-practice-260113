package _7_260122._2_Container;

import javax.swing.*;
import java.awt.*;

public class _4_Container_3_GridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Demo");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        frame.add(panel);
        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
