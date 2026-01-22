package _7_260122._0_GUI;

import javax.swing.*;

public class _0_GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello GUI"); //제목
        JButton button = new JButton("버튼"); //버튼 추가
        JLabel label = new JLabel("Hello, Swing!"); //라벨 추가
        frame.add(button);  //버튼그려지고
        frame.add(label);   //라벨그려져서 버튼이 가려짐
        frame.setSize(300, 200);    //창 크기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //닫기버튼
        frame.setVisible(true); //창보이게 할지
    }
}
