package _5_260119_260120._2_ManageUser.Exam;


public class _2_Exam_4_MemberBasePassword extends _2_Exam4_NormalMember {
    private String password;
    public _2_Exam_4_MemberBasePassword(String name, String email, String password, int age) {
        super(name, email, age);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void showInfo() {
        System.out.println("로그인한 유저의 정보는");
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("나이 : " + age);
    }
}
