package _5_260119._2_ManageUser.Exam;

public abstract class _2_Exam_4_MemberBase {
    protected String name;
    protected String email;
    protected String password;
    protected int age;

    // 생성자, 매개변수가 3개인 생성자 호출.
    public _2_Exam_4_MemberBase(String name, String email, String password, int age){
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public abstract void showInfo(); // 정보 출력용 추상 메서드
}
