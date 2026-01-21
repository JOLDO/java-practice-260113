package _5_260119_260120._0_Inheritance_Case.Exam;

public class _0_Exam_2_Dog extends _0_Exam_2_Animal {
    public static int dogCount = 0;
    public _0_Exam_2_Dog(String dogName) {
        super(dogName);
        System.out.println("개 수 : " + (++dogCount));
    }

    @Override
    public void namePrint() {
        super.namePrint();
        System.out.println("\t" + "멍멍");
    }
}
