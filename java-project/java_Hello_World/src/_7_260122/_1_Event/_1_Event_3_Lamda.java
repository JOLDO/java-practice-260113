package _7_260122._1_Event;

import javax.swing.*;

public class _1_Event_3_Lamda {
    public static void main(String[] args) {
        JFrame frame = new JFrame("람다식 예시");
        JButton button = new JButton("Exit");

//    public interface ActionListener extends EventListener {
//
//        /**
//         * Invoked when an action occurs.
//         * @param e the event to be processed
//         */
//        public void actionPerformed(ActionEvent e);
//
//    }
//        함수형 인터페이스(인터페이스에 함수 1개만 있는것))만 사용가능
        button.addActionListener(e -> frame.dispose());

        frame.add(button);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
