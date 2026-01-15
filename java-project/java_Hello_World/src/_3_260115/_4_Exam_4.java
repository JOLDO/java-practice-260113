package _3_260115;

public class _4_Exam_4 {
    public static void main(String[] args) {
        /*
        1) 설계 클래스 : StarCoffeeMenu(_4_StarCoffeeMenu)
                멤버, 변수
        메뉴이름 : menuName (String)
        사이즈 : size (String)
        핫?아? : isHot (boolean)

        - 생성자 메뉴만 정하면, 사이즈 기본 : "Tall" , 핫 : 기본 true
        - 생성자, 메뉴와 사이즈 따로 정하면, 기본 : 핫
        - 생성자, 메뉴, 사이즈, 핫 여부 따로 주문

        - 메서드는 , 주문한 내역을 보여주는 메서드 : showMenu
        예시) 주문한 메뉴 : 디카페인커피
        사이즈 : 그란데
        핫 : true
        주문 내역서 출력.
        */

        /*
        2) 실행 클래스 : StarCoffeeMain(_4_Exam_4)
        - 샘플 주문, 3개 주문을 하고,
        - 각각 매개변수 1개 생성자 호출
        - 매개변수 2개인 생성자 호출
        - 매개변수 3개인 생성자 호출
        각각의 주문 내역서 호출하기.
        */
        _4_StarCoffeeMenu coffeeMenu = new _4_StarCoffeeMenu();
        coffeeMenu.showMenu();

        _4_StarCoffeeMenu coffeeMenu1 = new _4_StarCoffeeMenu("디카페인 커피");
        coffeeMenu1.showMenu();

        _4_StarCoffeeMenu coffeeMenu2 = new _4_StarCoffeeMenu("디카페인 커피", "그란데");
        coffeeMenu2.showMenu();

        _4_StarCoffeeMenu coffeeMenu3 = new _4_StarCoffeeMenu("디카페인 커피", "그란데", false);
        coffeeMenu3.showMenu();
    }
}
