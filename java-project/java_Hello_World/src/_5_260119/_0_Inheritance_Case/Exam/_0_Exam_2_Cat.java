package _5_260119._0_Inheritance_Case.Exam;

public class _0_Exam_2_Cat extends _0_Exam_2_Animal{
    public static int catCount = 0;
    public _0_Exam_2_Cat(String catName) {
        super(catName);
        System.out.println("고양이 수 : " + (++catCount));
    }

    @Override
    public void namePrint() {
        super.namePrint();
        System.out.println("\t" + "야옹");
    }
}
