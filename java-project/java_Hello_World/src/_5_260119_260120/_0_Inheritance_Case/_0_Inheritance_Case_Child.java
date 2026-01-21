package _5_260119_260120._0_Inheritance_Case;

public class _0_Inheritance_Case_Child extends _0_Inheritance_Case_Parent{
    _0_Inheritance_Case_Child() { // 매개변수가 없는 , 기본 생성자.
        // 매개변수가 없는 , 기본 생성자.
        super(); // 생략 가능 //부모가 기본생성자일 경우 생략해도 부모생성자가 호출된다.
        System.out.println("자식 생성자 호출");
    }
}
