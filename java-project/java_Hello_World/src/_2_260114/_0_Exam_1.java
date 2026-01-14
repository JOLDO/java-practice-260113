package _2_260114;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _0_Exam_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1)나이를 입력받아 65세 이상이면 "노년층" 출력
        System.out.println("나이를 입력하세요(숫자만): ");
        int age = scanner.nextInt();
        if(age >= 65) {
            System.out.println("노년층");
        } else {
            System.out.println("노년층 아님");
        }
        /*
        2) switch 문으로 메뉴 선택
        메뉴 번호에 따라서, 음식 메뉴 출력 하기.
                입력 화면은, 메뉴 화면
        1. 김밥 2. 국밥 3.칼국수 4.국수 등.
        예시
        case 1 김밥, 본인 원하는 메뉴 추가. 출력해보기.
        */
        System.out.println("메뉴를 입력하세요.");
        System.out.println("1. 김밥");
        System.out.println("2. 국밥");
        System.out.println("3. 칼국수");
        System.out.println("4. 국수");

        try {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1: {
                    System.out.println("김밥");
                    break;
                }
                case 2: {
                    System.out.println("국밥");
                    break;
                }
                case 3: {
                    System.out.println("칼국수");
                    break;
                }
                case 4: {
                    System.out.println("국수");
                    break;
                }
                default: {
                    System.out.println("없는 메뉴입니다.");
                }
            }
        } catch (InputMismatchException ime) {
            String menu = scanner.nextLine();
            switch (menu) {
                case "김밥": {
                    System.out.println("김밥");
                    break;
                }
                case "국밥": {
                    System.out.println("국밥");
                    break;
                }
                case "칼국수": {
                    System.out.println("칼국수");
                    break;
                }
                case "국수": {
                    System.out.println("국수");
                    break;
                }
                default: {
                    System.out.println("없는 메뉴입니다.");
                }
            }
        }

        /*
        3)점수에 따라 A~F 등급 출력, if 문 이용해보기.
        A: 90점이상
        B: 80점이상
        C: 70점이상
        D: 60점이상
        F: 나머지
        */
        System.out.println("점수를 입력하세요(숫자만): ");
        int score = scanner.nextInt();
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        scanner.close();
    }
}
