package _5_260119._0_Inheritance_Case.Exam;

public class _0_Exam_1 {
    public static void main(String[] args) {
        /*
        실습
        1)
        부모 → 자식 생성자 호출 순서를 출력
        부모 클래스 : A
        자식 클래스 : B
        각각의 생성자를 만들기,
        실행 클래스 : Main ,
        */
//        _0_Exam_1_B b1 = new _0_Exam_1_B();

        /*
        2)
        업캐스팅된 객체에서 자식 메소드 호출을 오버라이딩으로 처리해보기
        부모 클래스 : A
        자식 클래스 : B
        부모 클래스의 인스턴스 메서드 : show() , 내용, 각 클래스명 이름 출력.
        실행 클래스 : Main ,
        */
//        _0_Exam_1_A a2 = new _0_Exam_1_B(); //업캐스팅
//        a2.show();

        /*
        3)
        instanceof로 객체 타입 검사 후 캐스팅
        부모 클래스 : A
        자식 클래스 : B
        실행 클래스 : Main ,
        업캐스팅 후, instanceof 로 검사 후, 다운 캐스팅 해보기.
        */
        _0_Exam_1_A a = new _0_Exam_1_B(); //a타입으로 업캐스팅
        a.show();   //자식 클래스의 쇼를 호출: 가상메서드 호출이라고 함
        if(a instanceof _0_Exam_1_B) {
            _0_Exam_1_B b = (_0_Exam_1_B) a;  //b타입으로 다운 캐스팅
            System.out.println("b타입입니다.");
        }
    }
}
