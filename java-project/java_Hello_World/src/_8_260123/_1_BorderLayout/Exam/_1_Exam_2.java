package _8_260123._1_BorderLayout.Exam;

import javax.swing.*;
import java.awt.*;

public class _1_Exam_2 {
    public static void main(String[] args) {
        /*
        BorderLayout의 각 영역(NORTH, SOUTH, EAST, WEST, CENTER)에
        모두 다른 컴포넌트(버튼, 라벨, 텍스트필드 등)를 배치해보세요.
        - 북 : 라벨 , 헤더
        - 남 : 버튼, 확인
        - 동 : 텍스트필드 , 입력
        - 서 : JCheckBox , 선택
        - 중앙 : JTextArea(4,12) 정도,

        크기 , 가로 350, 높이 180
        기본옵션 사용.
        */
        JFrame frame = new JFrame("실습2");
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new JLabel("헤더", SwingConstants.CENTER), BorderLayout.NORTH);
        panel.add(new Button("확인"), BorderLayout.SOUTH);
        panel.add(new JTextField("입력", 8), BorderLayout.EAST);
        panel.add(new JCheckBox("선택"), BorderLayout.WEST);
        panel.add(new JScrollPane(new JTextArea(4, 12)), BorderLayout.CENTER);

        frame.add(panel);

        frame.setSize(350, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
