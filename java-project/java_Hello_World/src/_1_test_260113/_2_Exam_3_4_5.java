package _1_test_260113;

import java.util.Scanner;

public class _2_Exam_3_4_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        1)
        오늘 저녁 먹고 싶은 메뉴(문자열)?(변수명: dinnerMenu)
        어디서 먹을까요(문자열)? (변수명: dinnerLoc)
        저녁 가격은 얼마 예상하나요(숫자로만)? (변수명: dinnerPri)
        출력 :
        오늘은 [먹고싶은 메뉴 이름][ 어디서 먹을지] 예상가격: [가격] 원입니다.
        */
        System.out.println("오늘 저녁 먹고 싶은 메뉴?");
        String dinnerMenu = scanner.nextLine();

        System.out.println("어디서 먹을까요?");
        String dinnerLoc = scanner.nextLine();

        System.out.println("저녁 가격은 얼마 예상하나요?");
        int dinnerPri = scanner.nextInt();

        System.out.println("오늘은 " + dinnerMenu + " " + dinnerLoc + " 예상가격 : " + dinnerPri + " 원입니다.");

        /*
        2)
        정수 두 개를 입력받아 합과 평균 출력
        정수1 (숫자,int):
        정수2 (숫자,int):
        출력 :
        합: [] ,
        평균 []
        */
        System.out.println("정수1 (숫자,int): ");
        int num1 = scanner.nextInt();

        System.out.println("정수2 (숫자,int): ");
        int num2 = scanner.nextInt();

        System.out.println("합: " + (num1 + num2) + ",");
        System.out.println("평균: " + ((num1 + num2) / 2.0));
        /*
        3)
        char 타입(하나의 문자만 의미)으로 성별 입력 받고 출력
        ex) char gender =
                성별(M/F) :
        출력 :
        입력한 성별은: M
        */
        System.out.println("성별(M/F): ");
        char gender =  scanner.next().toUpperCase().charAt(0);
//        String gend = scanner.next().toUpperCase().substring(0, 1);
//        char gend = (char) scanner.nextByte();  //바이트는 숫자로 받아야 함다.
//        char gen = (char) scanner.next().getBytes()[0];   //이게 되는 이유는 next()로 글자 읽어오고, getByte()로 바이트로 만들어서 그걸 (char)로 바꿔줘서 되는 거

        System.out.println("입력한 성별은: " + gender);

        scanner.close();
    }
}
