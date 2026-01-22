package _7_260122._1_Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _1_Event_1_AnonymousClass {
    public _1_Event_1_AnonymousClass() {
        JFrame frame = new JFrame("실습1, 오늘 점심메뉴");

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton button = new JButton("메뉴");
        JButton exitBtn = new JButton("나가기");
        panel.add(button);
        panel.add(exitBtn);

        /*
        - **클래스 이름이 없다**    //ActionListener action = new ActionListener()이런식이어야 하는데 new ActionListener()만 씀
        - **파일 분리 없이 즉석에서 작성한다**    //함수형 클래스와, 클래스사용이 가능하다고 함(오버라이해야할 함수가 있어야함)
        - **생성자 호출(클래스명) 없이 바로 구현한다**
        - **오버라이드 필요한 메서드만 구현한다**
        */
        exitBtn.addActionListener(new ActionListener() {    //익명 클래스(이름없는 클래스)(1회성)
            @Override
            public void actionPerformed(ActionEvent e) {
                //클릭시 동작할 기능 넣기. 창닫기
                frame.dispose();
            }
        });

        JLabel label = new JLabel("");
        JLabel nameLabel = new JLabel("이름 입력 : ");
        panel.add(label);
        panel.add(nameLabel);

        JTextField nameTextField = new JTextField(10);
        panel.add(nameTextField);

        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new _1_Event_1_AnonymousClass();
    }
}
