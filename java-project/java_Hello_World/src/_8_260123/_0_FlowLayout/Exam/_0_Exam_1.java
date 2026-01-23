package _8_260123._0_FlowLayout.Exam;

import javax.swing.*;
import java.awt.*;

public class _0_Exam_1 {
    public static void main(String[] args) {
        /*
        FlowLayout(왼쪽정렬)로
        JLabel("이름"), JTextField(8글자), JButton("검색")을
        순서대로 배치하세요.
        JTextField 입력된 내용을, 검색 버튼을 클릭시, 이벤트 리스너를 이용해서,
        콘솔에 출력해보기.
        */
        JFrame frame = new JFrame("실습1");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel label = new JLabel("오태흔");
        JTextField textField = new JTextField(8);
        JButton button = new JButton("검색");

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        button.addActionListener(e -> {
            System.out.println(textField.getText());
        });

        frame.add(panel);

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
