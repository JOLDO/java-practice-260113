package _7_260122._2_Container;

import javax.swing.*;
import java.awt.*;

public class _4_Container_1_FlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Demo");
        JPanel panel = new JPanel();
        //패널에 정렬 규칙 : 나란히 배치
        panel.setLayout(new FlowLayout());
        //패널에 버튼 붙이기
        panel.add(new JButton("A"));
        panel.add(new JButton("B"));
        panel.add(new JButton("C"));
        //프레임에 패널 붙이기
        frame.add(panel);
        frame.setSize(300, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
