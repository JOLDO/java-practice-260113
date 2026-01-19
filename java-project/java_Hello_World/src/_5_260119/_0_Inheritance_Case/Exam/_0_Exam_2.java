package _5_260119._0_Inheritance_Case.Exam;

public class _0_Exam_2 {
    public static void main(String[] args) {
        /*
        실습2
        배열에서 instanceof로 타입 구별 출력
        1) Animal 클래스 부모 타입으로 배열 = aniList 을 생성함.
        2) Animal 클래스를 상속 받은 자식 클래스 : Dog, Cat,
        aniList 배열에, 요소로, Dog 타입도,Cat 타입도, Animal 타입도 요소를 담기.
        3) 반복문을 이용하고, instanceof를 이용해서,
        각 타입을 확인 후, 각 타입에 맞는 내용을 호출하기.
        */

        _0_Exam_2_Animal animal1 = new _0_Exam_2_Cat("민수냥");
        _0_Exam_2_Animal animal2 = new _0_Exam_2_Dog("민수멍");
        _0_Exam_2_Animal animal3 = new _0_Exam_2_Animal("철수냥");
        _0_Exam_2_Animal animal4 = new _0_Exam_2_Dog("철수멍");
        _0_Exam_2_Animal animal5 = new _0_Exam_2_Cat("광록냥");
        _0_Exam_2_Animal animal6 = new _0_Exam_2_Animal("광록멍");

        _0_Exam_2_Animal[] aniList = {
                animal1, animal2, animal3, animal4, animal5, animal6
        };

        for(_0_Exam_2_Animal ani: aniList) {
            ani.namePrint();
            if(ani instanceof _0_Exam_2_Cat) {
                _0_Exam_2_Cat cat = (_0_Exam_2_Cat) ani;
                System.out.println(ani.getClass().getSimpleName() + ", 고양이, " + cat.getName());
            } else if(ani instanceof _0_Exam_2_Dog) {
                _0_Exam_2_Dog dog = (_0_Exam_2_Dog) ani;
                System.out.println(ani.getClass().getSimpleName() + ", 개, " + dog.getName());
            } else if(ani instanceof _0_Exam_2_Animal) {
                System.out.println(ani.getClass().getSimpleName() + ", 동물, " + ani.getName());
            }
        }
    }
}
