package _1_test_260113;

import java.util.Scanner;

public class _2_Scanner {
    public static void main(String[] args) {
        int count = 100;

        Scanner scanner = new Scanner(System.in);    //System.in(표준입력) , sc는 인스턴스, 콘솔에서 치면 됨
        System.out.println("반지름 입력: ");
        double radius = scanner.nextDouble();
        System.out.println("원의 넓이 : " + (3.14 * radius * radius));

        scanner.nextLine(); //버퍼 내용 비우기, 엔터입력 이후에 엔터를 제거하는 목적
        System.out.println("=========================");
        System.out.println("Scanner로 문자열 입력 받기");
        System.out.println("이름 입력: ");
        String name = scanner.nextLine();
        System.out.println("당신의 이름은 : " + name + "입니다.!!");
        scanner.close();
    }
}
