package _1_test_260113;

public class Exam_1_2 {
    public static void main(String[] args) {
        String name = "오태흔";
        int age = 35;
        System.out.println("이름 : " + name + ", 나이 : " + age);

        int x = 100;
        int y = 200;
        System.out.println("x * y = " + multi(x, y));

        Person person_1 = new Person("aaa", 111, "bbb");
        Person person_2 = new Person("ccc", 222, "ddd");
        System.out.println(introduce(person_1));

        person_1.setName("eee");
        System.out.println(introduce(person_1));
        System.out.println(introduce(person_2));

    }

    private static int multi(int a, int b) {
        return a * b;
    }

    private static String introduce(Person person) {
        return "이름: " + person.getName() + " 나이 : " + person.getAge() + " 주소 : " + person.getAddress();
    }
}
