package _4_260116._1_AccessModifier.Exam;

public class _1_Exam_2 {
    public static void main(String[] args) {
        /*
        Phone` 클래스에서 **static 공유 멤버**를 활용한 설계 구조
        제조사 이름(manufacturer)
        모든 인스턴스가 공유해야 할 정보 : 예시)애플, 삼성,

        멤버, 접근 지정자 : private
        1) 모델 :String model
        2) 폰 넘버 :String phoneNumber
        3) 생성자는 , 매개변수가 2개인 생성자
        4) 인스턴스 정보를 출력 메서드 하나 필요함 : printInfo()
        5) static 메서드를 만들어서,
        제조사 이름을 변경하는 메서드, : changeManufacturer()

        샘플 제품 3개 등록하고,
        샘플 제품 3개 정보 출력,
        제조사 이름 변경 후 조회 까지."
        */
//        System.out.println("제조사 => " + _1_Exam_2_Manufacturer.manufacturer);
        new _1_Exam_2_Manufacturer("갤럭시", "010-7233-8179");
        new _1_Exam_2_Manufacturer("갤럭시", "010-1111-1111");
        new _1_Exam_2_Manufacturer("갤럭시", "010-2222-2222");

        System.out.println();
        _1_Exam_2_Manufacturer.changeManufacturer("애플");
        new _1_Exam_2_Manufacturer("아이폰", "010-3333-3333");
        new _1_Exam_2_Manufacturer("아이폰", "010-4444-4444");
        new _1_Exam_2_Manufacturer("아이폰", "010-5555-5555");
        System.out.println();
    }
}
