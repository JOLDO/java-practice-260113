package _3_260115;

public class _4_Overloads {
    public static void main(String[] args) {
        OverloadCar overloadCar = new OverloadCar();
        System.out.println(overloadCar.model);
    }
}
 class OverloadCar {// 클래스명 //이렇게 하면 문제는 같은 패키지 폴더 내에서만 사용 가능
    // 멤버, 변수
    String model = "Avante!";   //이런식으로 기본값 넣어도 됨
    String color;
    int maxSpeed;

    // 1. 기본 생성자 (매개변수 없음)
    public OverloadCar() {
        this.model = "Avante"; // 기본값 설정
        this.color = "White";
        this.maxSpeed = 150;
//        this("aaa");
    }

    // 2. 모델명만 받는 생성자
    public OverloadCar(String model) {
//        this.model = model;
//        this.color = "White"; // 나머지는 기본값
//        this.maxSpeed = 150;
        this(model, "White", 150);  //이건 말그대로 public OverloadCar(String model, String color, int maxSpeed)를 쓰는 것
    }

    // 3. 모든 정보를 다 받는 생성자
    public OverloadCar(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
