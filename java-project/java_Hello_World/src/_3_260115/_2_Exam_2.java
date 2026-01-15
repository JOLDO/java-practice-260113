package _3_260115;

public class _2_Exam_2 {
    public static void main(String[] args) {
        /*
        1) 클래스 설계(정의)
        클래스명 : Book
        멤버 변수 1) name 2) price 3) writer
        기능 :책소개 메서드 이름 : introduceBook()
        기능 내부에는 , 현재 책의 이름과, 가격과 저자를 소개하는 출력 기능이 있습니다.

        2)클래스 사용(샘플 책3권 만들기)
        3) 메인 메서드가 있는 클래스에서,
        책 3권의 소개 기능을 구현 하기.

        생성할 클래스
        1) Book -> Ex2_Book
        2) 실행할 클래스 : BookTest -> Ex2_BookTest
        */
        Book book = new Book();
        book.name = "책제목!";
        book.price = 10000;
        book.writer = "오태흔!";
        book.introduceBook();

        _2_Exam_2 outer = new _2_Exam_2();
        InnerBook innerBook = outer.new InnerBook();
        innerBook.name = "책제목!!";
        innerBook.price = 20000;
        innerBook.writer = "오태흔!!";
        innerBook.introduceBook();

        StaticInnerBook staticInnerBook = new StaticInnerBook();
        staticInnerBook.name = "책제목!!!";
        staticInnerBook.price = 30000;
        staticInnerBook.writer = "오태흔!!!";
        staticInnerBook.introduceBook();
    }

    class InnerBook {
        String name;
        int price;
        String writer;

        void introduceBook() {
            System.out.println("제목-" + name + ", 가격-" + price + ", 작가-" + writer);
        }
    }

    static class StaticInnerBook {
        String name;
        int price;
        String writer;

        void introduceBook() {
            System.out.println("제목-" + name + ", 가격-" + price + ", 작가-" + writer);
        }
    }
}

 class Book {
    String name;
    int price;
    String writer;

    void introduceBook() {
        System.out.println("제목-" + name + ", 가격-" + price + ", 작가-" + writer);
    }
}