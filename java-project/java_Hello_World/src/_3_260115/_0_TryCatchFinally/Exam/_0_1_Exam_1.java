package _3_260115._0_TryCatchFinally.Exam;

import java.util.Scanner;

public class _0_1_Exam_1 {
    public static void main(String[] args) {
        /*
        숫자 입력 예외 처리,
        사용자가 문자를 입력했을 때 예외 처리
        (스캐너 도구를 이용하고, 숫자를 가져와서 사용하는 구조이고,
                거기에 사용자가, 문자를 입력했을 때 처리하는 경우)

        힌트) try-catch` 구문을 이용하기.
        예외처리 방식 1) 큰범위로 합니다.
        catch (Exception e) {
        */
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("숫자입력");
            int num = scanner.nextInt();
            System.out.println(num);
        } catch (Exception e) {
            System.out.println("숫자이외의 입력이 있습니다.");
            e.printStackTrace();    //이력조회(예외를 사용해서 원래 에러 이력이 안나오지만 이걸 넣으면 볼수 있다.
        } finally {
            scanner.close();
        }
    }
}
