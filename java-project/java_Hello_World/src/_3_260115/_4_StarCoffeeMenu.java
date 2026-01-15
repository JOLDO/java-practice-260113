package _3_260115;

public class _4_StarCoffeeMenu {
    String menuName = "디카페인 커피";
    String size = "Tall";
    boolean isHot = true;

    public _4_StarCoffeeMenu() {}

    public _4_StarCoffeeMenu(String menuName) {
        this(menuName, "Tall", true);
    }

    public _4_StarCoffeeMenu(String menuName, String size) {
        this(menuName, size, true);
    }

    public _4_StarCoffeeMenu(String menuName, String size, boolean isHot) {
        this.menuName = menuName;
        this.size = size;
        this.isHot = isHot;
    }

    public void showMenu() {
        System.out.println("주문한 메뉴 : " + menuName + "\n" + "사이즈 : " + size + "\n" + "핫 : " + isHot);
    }
}
