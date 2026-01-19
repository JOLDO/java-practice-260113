package _5_260119._2_ManageUser.Exam;


public class _2_Exam_4_MemberBasePassword extends _2_Exam_4_MemberBase {
    public _2_Exam_4_MemberBasePassword(String name, String email, String password, int age) {
        super(name, email, password, age);
    }

    @Override
    public void showInfo() {
        System.out.println("로그인 성공");
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("나이 : " + age);
    }
}
