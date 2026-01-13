package _1_test_260113;

public class Exam_1_2 {
    public static void main(String[] args) {
        String name = "오태흔";
        int age = 35;
        System.out.println("이름 : " + name + ", 나이 : " + age);

        int x = 100;
        int y = 200;
        Exam_1_2 e = new Exam_1_2();
        System.out.println("x * y = " + e.multi(x, y));
    }

    private int multi(int a, int b) {
        return a * b;
    }
}
