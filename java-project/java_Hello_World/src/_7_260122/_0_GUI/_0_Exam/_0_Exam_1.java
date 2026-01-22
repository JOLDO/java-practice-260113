package _7_260122._0_GUI._0_Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _0_Exam_1 {
    public _0_Exam_1() {
        JFrame frame = new JFrame("실습1, 오늘 점심메뉴");
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton button = new JButton("메뉴");
        panel.add(button);

        JLabel label = new JLabel("");
        panel.add(label);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(label.getText().equals("")) {
                    label.setText("피카츄 돈까스");
                } else {
                    label.setText("");
                }
            }
        });
    }
    public static void main(String[] args) {
        /*
        1)창을 띄우고, 버튼과 라벨을 동시에 추가해보세요.
        내용은 오늘 먹을 점심 관련 아무 글.
        힌트)
        버튼, 라벨을 패널에 추가하기
        panel.add(button);

        JPanel panel = new JPanel(); 추가 해주고,
        panel 을 프레임(창) 에 추가하고,

        frame.add(panel);
        */
        new _0_Exam_1();
    }
}
