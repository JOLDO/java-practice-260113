package _6_260121._0_Collections.MemberProject_HashMap;

public class _0_NormalMember_HashMap extends _0_MemberBase_HashMap implements _0_Joinable_HashMap {
    //매개변수가 3개인 생성자
    public _0_NormalMember_HashMap(String name, String email, String password, int age) {   //실습 수정6: 부모의 생성자에 맞게 비밀번호 추가
        super(name, email, password, age);
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
