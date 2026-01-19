package _4_260116._2_Inheritance;

public class _2_Inheritance_Dog extends _2_Inheritance_Animal {
    // Animal 상속 받아서,
    // 사용 가능한 변수 : name, 사용 가능한 메서드 : speak()
    public void bark() {
        System.out.println(name + "가 짖습니다!");
    }
}
