package _8_260123._3_NullLayout;

import javax.swing.*;

public class _3_0_NullLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("좌표 배치");
        frame.setLayout(null);

        JButton btn = new JButton("버튼");
        btn.setBounds(60, 40, 100, 30); //위치(60, 40)에 크기(100, 30)으로 생

        frame.add(btn);
        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
