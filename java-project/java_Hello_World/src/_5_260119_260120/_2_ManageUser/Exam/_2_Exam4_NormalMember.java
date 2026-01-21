package _5_260119_260120._2_ManageUser.Exam;

public class _2_Exam4_NormalMember extends _2_Exam_4_MemberBase implements _2_Exam_4_Joinable {
    //매개변수가 3개인 생성자
    public _2_Exam4_NormalMember(String name, String email, int age) {
        super(name, email, age);
    }
    //Joinable 인터페이스의 메서드를 재정의
    @Override
    public void join() {
        System.out.println(name + "님 회원가입 완료.");
    }

    //추상 클래스의 추상 메서드를 반드시 구현하기.
    @Override
    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("나이 : " + age);
    }
}
