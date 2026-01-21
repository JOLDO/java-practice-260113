package _6_260121._0_Collections.MemberProject_HashMap;

public abstract class _0_MemberBase_HashMap {
    //메인클래스는 이 클래스의 상속을 받지 않아서 접근 변수에 접근 불가하기 때문에 getter로 접근
    protected String name;
    protected String email;
    protected String password;  //실습 수정2: 비밀번호 추가
    protected int age;

    // 생성자, 매개변수가 3개인 생성자 호출.
    public _0_MemberBase_HashMap(String name, String email, String password, int age){  //실습 수정3: 생성자 매개변수에 비밀번호 추가
        this.name = name;
        this.email = email;
        this.password = password;   //실습 수정4: 추가한 비밀번호 값 대입
        this.age = age;
    }

    public abstract void showInfo(); // 정보 출력용 추상 메서드

    //실습 수정5: 이메일, 패스워드 조회하는 기능 추가, getter

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
