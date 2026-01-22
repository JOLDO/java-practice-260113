package _7_260122._1_Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _1_Event_2_InnerClass {
    JFrame frame = new JFrame("내부 클래스 예시");
    JButton button = new JButton("Exit");

    public _1_Event_2_InnerClass() {
        button.addActionListener(new ExitListener());   //이너클래스를 버튼에 리스너 등록(재사용 가능)
        frame.add(button);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // 내부 클래스
    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new _1_Event_2_InnerClass();
    }
}
