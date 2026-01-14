package _2_260114;

import java.util.Scanner;

public class _0_Condition_if_switch {
    //순서1, main -> 코드 스니펫으로 메인 메서드 자동 생성
    public static void main(String[] args) {
        //순서2, sout -> 코드 스니펫으로 출력 메서드 자동 생ㅇ성
        //순서3, 실행, 단축키 : cntl + r
        //or 재성 버튼으로 실행
        System.out.println("수업 준비 확인");
        int score = 70;
        if(score >= 90) {
            System.out.println("A");
        } else if(score >= 80) {
            System.out.println("B");
        } else {
            System.out.println("C이하");
        }

        int month = 6;
        switch (month) {
            case 3: case 4: case 5: {
                System.out.println("봄");
                break;
            }
            case 6: case 7: case 8: {
                System.out.println("여름");
                break;
            }
            default: {
                System.out.println("기타 계절");
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("온도를 입력하세요(숫자만) : ");
        int temp = scanner.nextInt();
        if (temp >= 30) {
            System.out.println(temp + "도는 더음");
        } else if (temp <= 30 && temp >= 22) {
            System.out.println(temp + "도는 적당함");
        } else {
            System.out.println(temp + "도는 쌀쌀함");
        }

        System.out.println("월 1 ~ 12 입력하세요(숫자만) : ");
        int month2 = scanner.nextInt();

        switch (month2) {

            case 3: case 4: case 5:
                System.out.println("봄");
                break;
            case 6: case 7: case 8:
                System.out.println("여름");
                break;
            case 12: case 1: case 2:
                System.out.println("겨울");
                break;
            default:
                System.out.println("가을");
        } // switch

        scanner.close();
    }
}
