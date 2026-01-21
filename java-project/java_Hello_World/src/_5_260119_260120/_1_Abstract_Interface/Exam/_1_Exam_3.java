package _5_260119_260120._1_Abstract_Interface.Exam;

public class _1_Exam_3 {
    public static void main(String[] args) {
        /*
        1)
        추상 클래스 `Shape`을 만들고, `draw()`를 추상 메서드로 선언하세요.
        구현하는 클래스 : Circle(원), Rentangle(사각형), Oval(타원)
        실행하는 클래스 : 각 구현하는 클래스 인스턴스를 만들어서,각 모양만 맞게 그림그리기
        그림그리기, sout ,
        출력물로 , :
        "원을 그립니다."
        "사각형을 그립니다."
        "타원을 그립니다."
        */
        _1_Exam_3_Circle circle = new _1_Exam_3_Circle();
        _1_Exam_3_Rectangle rectangle = new _1_Exam_3_Rectangle();
        _1_Exam_3_Oval oval = new _1_Exam_3_Oval();
        circle.draw();
        rectangle.draw();
        oval.draw();

        /*
        2)
        인터페이스 `Playable`을 정의하고,
        메소드는 : play(), 간단히 메서드명만 정의,
        `MusicPlayer` 클래스가 이를 구현하세요.
        재정의해서, 구현해보기,
        실행하는 클래스 , 인스턴스 만들어서 구현해보기.
        */
        _1_Exam_3_MusicPlayer musicPlayer = new _1_Exam_3_MusicPlayer();
        musicPlayer.play();

        /*
        3)
        추상 클래스에서 구현 메서드와 추상 메서드를 동시에 사용해보세요.
        추상클래스 : Vehicle 정의,
        추상메서드 : move() 정의,
        구현 메서드 : fuel() ,내용은 sout, "연료 충전"
        구현 클래스 : Car , 상속 받고, 추상메서드 move() 재정의해서 사용해보기.
        */
        _1_Exam_3_Car car = new _1_Exam_3_Car();
        car.move();

    }
}
