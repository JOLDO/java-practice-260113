package _8_260123._3_NullLayout.Exam;

import javax.swing.*;
import java.awt.*;

public class _3_Exam_4 {
    public static void main(String[] args) {
        /*
        setLayout(null)로
        "이름", "나이" 라벨과 입력란, "확인" 버튼을
        각각
        좌표 (x,y) : (15,15), (15,50), (70,15), (70,50), (110,90)에
        크기 (50,25), (100,25) (고정)
        크기 (50,30), (100,30) (고정)

        가로 50, 100, 세로 25/30 크기로 배치하세요.
         */
        JFrame frame = new JFrame("실습4");
        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);
//        panel.setBounds(0, 0, 700, 700);
        panel.setPreferredSize(new Dimension(700, 700));

        JLabel labelName = new JLabel("이름");
        labelName.setBounds(15, 15, 50, 25);

        JLabel labelAge = new JLabel("나이");
        labelAge.setBounds(15, 50, 50, 25);

        JTextField textFieldName = new JTextField(5);
        textFieldName.setBounds(70, 15, 100, 25);

        JTextField textFieldAge = new JTextField(5);
        textFieldAge.setBounds(70, 50, 100, 25);

        JButton button = new JButton("확인");
        button.setBounds(100, 90, 70, 25);

        panel.add(labelName);
        panel.add(labelAge);
        panel.add(textFieldName);
        panel.add(textFieldAge);
        panel.add(button);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.BLUE);
//        panel2.setBounds(0, 0, 700, 700);
        panel2.setPreferredSize(new Dimension(700, 700));

        JLabel labelName2 = new JLabel("이름");
        labelName2.setBounds(15, 15, 50, 25);

        JLabel labelAge2 = new JLabel("나이");
        labelAge2.setBounds(15, 50, 50, 25);

        JTextField textFieldName2 = new JTextField(5);
        textFieldName2.setBounds(70, 15, 100, 25);

        JTextField textFieldAge2 = new JTextField(5);
        textFieldAge2.setBounds(70, 50, 100, 25);

        JButton button2 = new JButton("확인");
        button2.setBounds(100, 90, 70, 25);

        panel2.add(labelName2);
        panel2.add(labelAge2);
        panel2.add(textFieldName2);
        panel2.add(textFieldAge2);
        panel2.add(button2);

        frame.add(panel);
        frame.add(panel2);

        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
