package _8_260123._2_GridLayout.Exam;

import javax.swing.*;
import java.awt.*;

public class _2_Exam_3 {
    public static void main(String[] args) {
        /*
        3x2 GridLayout, 각 칸에 번갈아
        JLabel(“항목”)과 JTextField(5글자)를 배치해서
        3행 폼을 만들어보세요.
        */
        JFrame frame = new JFrame("실습");
        JPanel panel = new JPanel(new GridLayout(3, 2));

        for(int i = 1; i <= 3; i++) {
            panel.add(new JLabel("항목" + i, SwingConstants.CENTER));
            panel.add(new JTextField(5));
        }

        frame.add(panel);
        frame.setSize(200, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
