package _1_test_260113;

import java.util.Scanner;

public class _3_Operator {
    public static void main(String[] args) {
        //기본 예시
        //정수 2개 입력 받아서, 몫과 나머지 출력

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 1 : ");
        int num1 = scanner.nextInt();

        System.out.println("정수 2 : ");
        int num2 = scanner.nextInt();

        System.out.println("몫 : " + (num1 / num2));

        System.out.println("나머지 : " + (num1 % num2));

        scanner.close();
    }
}
