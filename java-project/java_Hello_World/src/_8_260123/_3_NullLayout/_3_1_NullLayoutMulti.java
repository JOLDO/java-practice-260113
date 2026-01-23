package _8_260123._3_NullLayout;

import javax.swing.*;

public class _3_1_NullLayoutMulti {
    public static void main(String[] args) {
        JFrame frame = new JFrame("여러 컴포넌트");
        frame.setLayout(null);

        JLabel label = new JLabel("이름:");
        label.setBounds(20, 30, 40, 25);
        JTextField tf = new JTextField();
        tf.setBounds(70, 30, 100, 25);

        JButton btn = new JButton("확인");
        btn.setBounds(180, 30, 70, 25);

        frame.add(label);
        frame.add(tf);
        frame.add(btn);

        frame.setSize(300, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
