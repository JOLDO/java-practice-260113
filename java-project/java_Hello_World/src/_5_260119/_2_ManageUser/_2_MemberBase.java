package _5_260119._2_ManageUser;

public abstract class _2_MemberBase {
    protected String name;
    protected String email;
    protected int age;

    // 생성자, 매개변수가 3개인 생성자 호출.
    public _2_MemberBase(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public abstract void showInfo(); // 정보 출력용 추상 메서드
}
