package _4_260116._2_Inheritance.Exam;

public class _2_Exam_3 {
    public static void main(String[] args) {
        /*
        부모클래스
        Employee` 클래스를 부모로 하여
        1) protected String department ;
        2) 생성자 : 매개변수 1개인

        자식클래스
        `Manager` 클래스를 만들고, `protected` 필드를 상속받아 출력하시오.
        1) 부모 클래스 상속 받기.
        2) 생성자를 호출, 매개변수 1개이고,
        주의, 자식의 생성자에서 호출할 때, 반드시 부모 클래스 생성자를 먼저 호출해야함.
        힌트) super 사용하기.
        3) 메서드 , printDept() ,
        출력 : 소속 부서 : 개발팀

        메인 클래스
        샘플 Manager 2개 정도 만들고,
        부서를 출력 해보기.
        */

        _2_Exam_3_Manager manager1 = new _2_Exam_3_Manager("개발팀");
        _2_Exam_3_Manager manager2 = new _2_Exam_3_Manager("개발팀2");
        manager1.printDept();
        manager2.printDept();
    }
}
