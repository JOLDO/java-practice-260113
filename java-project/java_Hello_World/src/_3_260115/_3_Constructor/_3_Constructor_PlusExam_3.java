package _3_260115._3_Constructor;

public class _3_Constructor_PlusExam_3 {
    public static void main(String[] args) {
        ConstructorBook constructorBook1 = new ConstructorBook("제목!", 10000, "오태흔!");
        constructorBook1.introduceBook();

        ConstructorBook constructorBook2 = new ConstructorBook("제목!!", 20000, "오태흔!!");
        constructorBook2.introduceBook();

        ConstructorBook constructorBook3 = new ConstructorBook("제목!!!", 30000, "오태흔!!!");
        constructorBook3.introduceBook();
    }
}

class ConstructorBook {
    String name;
    int price;
    String writer;

    //직접 적어도 되고 클래스 내부에서 우클릭 -> 생성 -> 생성자 선택해서 생성
    public ConstructorBook(String name, int price, String wrieter) {
        this.name = name;
        this.price = price;
        this.writer = wrieter;
    }

    void introduceBook() {
        System.out.println("제목-" + name + ", 가격-" + price + ", 작가-" + writer);
    }
}
