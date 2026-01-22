package _7_260122._1_Event._1_Exam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _1_Exam_2 {
    public static void main(String[] args) {
        /*
        "간단한 메모장" 형태의 GUI를 만들어보세요.
        윈도우 창, JTextArea(글 입력 창), "저장" 버튼을 포함하고,
        "저장" 버튼을 클릭하면 입력된 내용을 콘솔에 출력하도록 하세요.
        힌트)
        이벤트 리스너의 기능:
        sout 콘솔에 출력하기.
        대신에 내용을 가져오는 기능 : textArea.getText() 기능.

        화면 준비물 )
        frame, panel, button , textArea(10,30)
        */
        JFrame frame = new JFrame("실습2");
        JButton button = new JButton("저장");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(10, 30);

        frame.add(panel);
        panel.add(new JScrollPane(textArea));   //스크롤팬에 텍스트에어리어 붙여서 페널에 붙임
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea.getText());
            }
        });

        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
