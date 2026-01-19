package _3_260115._2_OOP;

public class _2_Oop_car {
    String model;
    int speed;

    // 생성자, 클래스명과 동일하게 사용.
    // 활요 : 해당 클래스의 객체(인스턴스) 생성하는 도구.

    // 기본 생성자
    public _2_Oop_car() {

    }
    // 매개변수 2개인, 생성자
    public _2_Oop_car(String m, int s) {
        model = m;
        speed = s;
    }

    void drive() {
        System.out.println(model + " is driving at " + speed + " km/h");
    }
}
