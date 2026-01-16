package _4_260116;

public class _2_Inheritance {
    public static void main(String[] args) {
        _2_Inheritance_Dog dog1 = new _2_Inheritance_Dog();
        dog1.name = "멍멍이";
        dog1.speak();
        dog1.bark();
        System.out.println("dog1의 이름 : " + dog1.name);

        _2_Inheritance_Child child1 = new _2_Inheritance_Child();
        child1.hello();
    }
}
