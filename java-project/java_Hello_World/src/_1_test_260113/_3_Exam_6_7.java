package _1_test_260113;

import java.util.Scanner;

public class _3_Exam_6_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //시스템 인풋은 한번 닫히면 다시 열지 못함
        /*
        1)
        사용자 나이를 입력받아 성인 여부 판별 (19세 이상이면 true)
        입력 : 나이 입력 :
        출력 :
        성인입니까? true/false
        */
        System.out.println("나이 입력 : ");
        boolean isAdult;
        if(scanner.nextInt() >= 19) {
            isAdult = true;
        } else {
            isAdult = false;
        }

        System.out.println("성인입니까? " + isAdult);

        /*
        2)
        삼항 연산자 이용, 점수가 60점 이상이면 “합격” 아니면 “불합격”
        입력 : 점수 입력:
        출력 :
        합격/불합격 입니다.
        */
        System.out.println("점수 입력 : ");
        System.out.println((scanner.nextInt() >= 60 ? "합격" : "불합격") + " 입니다.");

        scanner.close();
    }
}
