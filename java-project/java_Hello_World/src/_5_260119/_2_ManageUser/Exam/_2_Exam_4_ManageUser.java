package _5_260119._2_ManageUser.Exam;

import java.util.Scanner;

public class _2_Exam_4_ManageUser {
    public static void main(String[] args) {
        /*
        실습4
        위의 기능에, 3 종료 4번으로 이동하고,
        3번 기능을 로그인 추가해서,
        email: , 기존 정보
        클래스 _3_MemberBasepassword(멤버를 추가해서)
        이메일과 패스워드 2개가 일치시, 로그인 성공이라는 콘솔 출력하고,
        불일치, 정보가 불일치해서, 로그인 안됩니다. (
        배열에 저장된 회원 이메일가 일치 해야하고,
        이메일과 패스워드과 일치해야함.)
        */


        //최대 5명까지 저장 가능한 배열 생성.
        _2_Exam_4_MemberBase[] members = new _2_Exam_4_MemberBase[5];
        int count = 0;	//현재 저장된 회원 수(배열 인덱스 관리용)
        //콘솔에 입력 내용 불러오는 도구.
        Scanner sc = new Scanner(System.in);

        //메뉴 반복문 이용해서 그려보기.
        while(true) {
            System.out.println("\n=======회원 관리 시스템 ver 1.0=======");
            System.out.println("1.회원가입 2.목록조회 3.로그인 4.종료");
            System.out.println("메뉴 선택>>");

            //숫자를 입력 받을 준비 및 처리.
            int choice;
            try {
                //콘솔에 입력된 내용은 모두 타입이 문자열입니다.
                //그래서 입력 받은 문자열을 숫자형태로 변경해야함.
                //Integer.parseInt :문자열 -> 숫자로 타입 변경해주는 기능
                choice = Integer.parseInt(sc.nextLine());
            } catch(Exception e) {
                System.out.println("숫자만 입력해주세요.");
                //콘솔에 숫자가 아닌 다른 문자등을 입력시에는 반복문이 종료되지 않고, 계속 동작하게끔 설정
                continue;
            }
            switch (choice) {
                case 1:	//회원가입
                    //count, 현재 가입된 회원 숫자
                    //members.length : 5개 고정 길이, 왜? 배열이라서, 고정.
                    if(count >= members.length) {
                        System.out.println("정원초과, 가입 불가입니다.");
                        break;
                    }
                    System.out.println("이름 : ");
                    String name = sc.nextLine();

                    System.out.println("이메일 : ");
                    String email = sc.nextLine();

                    //비밀번호 받기
                    System.out.println("비밀번호 : ");
                    String password = sc.nextLine();

                    System.out.println("나이 : ");
                    int age = Integer.parseInt(sc.nextLine());

                    //다형성 활용 : 부모 타입 배열에 자식 객체 저장.
                    _2_Exam4_NormalMember newMember = new _2_Exam4_NormalMember(name, email, password, age);
                    //배열에 저장.
                    members[count] = newMember;
                    //인터페이스 메서드 호출
                    newMember.join();

                    //인덱스 증가, 현재 가입할 인원 증가
                    count++;
                    break;

                case 2:
                    if(count == 0) {
                        System.out.println("가입된 회원이 없습니다.");
                    } else {
                        System.out.println("\n 총 회원수 : " + count + "명입니다.");
                        for(int i = 0; i < count; i++) {
                            members[i].showInfo();  //다형성(오버라이딩된 메서드 실행)
                        }
                    }
                    break;

                case 3:
                    //로그인 하는 구문
                    System.out.println("아이디 : ");
                    String loginId = sc.nextLine();
                    System.out.println("비밀번호 : ");
                    String loginPw = sc.nextLine();
                    boolean isUser = false;
                    for(int i = 0; i < count; i++) {
                        if(members[i].email.equals(loginId) && members[i].password.equals(loginPw)) {
                            isUser = true;
                            _2_Exam_4_MemberBasePassword user = new _2_Exam_4_MemberBasePassword(members[i].name, loginId, loginPw, members[i].age);
                            user.showInfo();
                        }
                    }
                    if(!isUser) System.out.println("로그인 실패");
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); //스캐너 자원반납
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }
}
