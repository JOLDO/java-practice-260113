package _5_260119._0_Inheritance_Case.Exam;

public class _0_Exam_2_Animal {
    public static int animal_count = 0;
    private String name;

    public _0_Exam_2_Animal(String name) {
        this.name = name;
        System.out.println("현재 동물 수 : " + (++animal_count));
    }

    public void namePrint() {
        System.out.println("이름 :" + name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
