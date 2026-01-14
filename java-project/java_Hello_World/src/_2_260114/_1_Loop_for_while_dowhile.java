package _2_260114;

public class _1_Loop_for_while_dowhile {
    public static void main(String[] args) {
        //1)
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        //2)
        //1~10 중 홀수만 출력
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println(i);
        }
        //3)
        //1~10 중 6에서 멈추기
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;
            System.out.println(i);
        }
    }
}
