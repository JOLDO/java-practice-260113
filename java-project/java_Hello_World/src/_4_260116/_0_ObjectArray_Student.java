package _4_260116;

public class _0_ObjectArray_Student {
    private String name;
    private int age;

    public _0_ObjectArray_Student() {
        name = "이름 없음";
        age = 35;
    }
    public _0_ObjectArray_Student(String name) {
        this.name = name;
        age = 35;
    }
    public _0_ObjectArray_Student(int age) {
        name = "이름 없음";
        this.age = age;
    }
    public _0_ObjectArray_Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printStudent(_0_ObjectArray_Student student) {
        System.out.println("학생이름 : " + student + "\t" + "학생나이 : " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
