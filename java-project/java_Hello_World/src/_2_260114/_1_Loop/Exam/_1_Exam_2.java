package _2_260114._1_Loop.Exam;

import java.util.Scanner;

public class _1_Exam_2 {
    public static void main(String[] args) {
        /*
        1)1~100까지의 합 출력
        힌트 for 문 활용
        */
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
        /*
        2)사용자로부터 양수만 입력받고 음수가 입력되면 종료
        힌트 do-while 문 활용
        */
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("숫자를 입력하세요.");
        } while (scanner.nextInt() > 0);
        scanner.close();

        /*
        3)1~50 사이에서 7의 배수만 출력하되, 30이 넘으면 종료
        힌트 for 문 활용
        */
        for (int i = 1; i <= 50; i++) {
            if (i > 30)  break;
            else if(i % 7 != 0)  continue;
            System.out.println(i);
        }
    }
}
