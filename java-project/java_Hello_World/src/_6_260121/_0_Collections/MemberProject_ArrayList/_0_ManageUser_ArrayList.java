package _6_260121._0_Collections.MemberProject_ArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _0_ManageUser_ArrayList {
    //임시저장파일 추가(파일 이름 미리 지정, 정적(static))
    //파일이름을 미리 지정
    private static final String FILE_NAME = "members.txt";  //회원가입한 유저 데이터 저장팔 파일 이름(고정)
    public static void main(String[] args) {
        //다형성 적용 : List(인터페이스) 큰 타입으로 선선, = ArrayList 생성    //map과 set로 list의 하위라서 다형성을 위해
        List<_0_MemberBase_ArrayList> members = new ArrayList<>();
        loadMembers(members);

        //프로그램 시작시 회원 정보 불러오기
        _0_MemberBase_ArrayList loginMemeber = null;  //실습2 수정1: 로그인한 유저가 있는지 확인할 변수를 처음에 없으므르 null로 설정
        //콘솔에 입력 내용 불러오는 도구.
        Scanner sc = new Scanner(System.in);

        //메뉴 반복문 이용해서 그려보기.
        while(true) {
            System.out.println("\n=======회원 관리 시스템 ver 1.0=======");
            if(loginMemeber != null) {  //실습2 수정2: 로그인 한 유저 데이터가 있으면
                System.out.println("로그인한 유저 : " + loginMemeber.getEmail());
                System.out.println("1.회원가입 2.목록조회 3.로그아웃 4.종료");
            } else {
//                System.out.println("1.회원가입 2.목록조회 3.종료");
                System.out.println("1.회원가입 2.목록조회 3.로그인 4.종료"); //실습 수정1: 메뉴 변경
            }
            System.out.println("메뉴 선택>>");

            //숫자를 입력 받을 준비 및 처리.
            int choice;
            try {
                //콘솔에 입력된 내용은 모두 타입이 문자열입니다.
                //그래서 입력 받은 문자열을 숫자형태로 변경해야함.
                //Integer.parseInt :문자열 -> 숫자로 타입 변경해주는 기능
                choice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                //콘솔에 숫자가 아닌 다른 문자등을 입력시에는 반복문이 종료되지 않고, 계속 동작하게끔 설정
                continue;
            }
            switch (choice) {
                case 1:	//회원가입
                    System.out.println("이름 : ");
                    String name = sc.nextLine();

                    System.out.println("이메일 : ");
                    String email = sc.nextLine();

                    System.out.println("비밀번호 : ");  //실습 수정7: 비밀번호 정보 받기
                    String password = sc.nextLine();

                    System.out.println("나이 : ");
                    try {
                        int age = Integer.parseInt(sc.nextLine());

                        //다형성 활용 : 부모 타입 배열에 자식 객체 저장.
                        _0_NormalMember_ArrayList newMember = new _0_NormalMember_ArrayList(name, email, password, age);    //실습 수정8: 생성자의 매개변수에 password 추가

                        members.add(newMember);
                        //인터페이스 메서드 호출
                        newMember.join();
                        //인덱스 증가, 현재 가입할 인원 증가

                        //회원가입시, 메모리상의 내용을 파일에 저장하는 메서드를 이용
                        saveMembers(members);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자를 입력하세요.");
                    } finally {
                        break;
                    }

                case 2:
                    if(members.size() == 0) {
                        System.out.println("가입된 회원이 없습니다.");
                    } else {
                        System.out.println("\n 총 회원수 : " + members.size() + "명입니다.");
                        for(_0_MemberBase_ArrayList member : members) {
                            member.showInfo();  //다형성(오버라이딩된 메서드 실행)
                        }
                    }
                    break;

                //실습 수정9: 로그인 기능 추가
                case 3:
                    if(loginMemeber == null) {
                        System.out.println("\n=====로그인=====");
                        //이메일과 패스워드 정보 받아서 배열에 등록된 이메일로 유저 찾고 비밀번호가 일치하면 로그인, 불일치하면 로그인 불가
                        System.out.println("이메일 : ");
                        String inputEmail = sc.nextLine();

                        System.out.println("패스워드 : ");
                        String inputPassword = sc.nextLine();

                        //상태변수, 로그인 성공여부 체크
                        boolean isLogin = false;

                        //회원정보가 들어있는 배열 전체 순회
                        for(_0_MemberBase_ArrayList member : members) {
                            //임시 메모리에 저장된 회원의 이메일과 패스워드 확인 절차
                            //저장된 회원 한명씩 꺼내서, member에 담아두고, 입력된 이메일, 패스워드와 불러운 이메일, 패스워드를 비교
                            //수정
                            //주의 사항, 문자열 비교시에는 문자열.equals(비교문자열) 사용
                            if (member.getEmail().equals(inputEmail) && member.getPassword().equals(inputPassword)) {
                                isLogin = true;
                                loginMemeber = member;  //실습2 수정3: 로그인 성공시 그 맴버의 데이터를 로그인 한 멤버 데이터에 넣어줌
                                System.out.println("로그인 성공!! 환영합니다.~" + member.name + "님");
                                break;
                            }
                        }
                        //로그인 실패인 경우
                        if (!isLogin) System.out.println("로그인 실패: 정보가 일치하지 않습니다.");
                    } else {
                        System.out.println("로그아웃 되었습니다.");
                        loginMemeber = null;    //실습2 수정4: 로그아웃을 할때 로그인한 유저 데이터를 비워준다.
                    }
                    break;

                //실습 수정10: 종료 기능 3에서 4로 변경
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); //스캐너 자원반납
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    //임시저장파일 추가(저장하는 기능 메서드 만들기, 정적(static)
    //준비물:
    //1)메모리 상에 저장된 멤버들 배열 members
    //2)가입된 인원수 count

    //임시저장파일 추가(불러오는 기능 메서드 만들기, 정적(static)
    //준비물:
    //1)메모리에 저장된 배열
    public static void saveMembers(List<_0_MemberBase_ArrayList> members) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (_0_MemberBase_ArrayList member : members) {
                String line = member.getName() + "," + member.getEmail() + "," + member.getPassword() + "," + member.getAge();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("파일 저장 완료 " + FILE_NAME);

        } catch (IOException ioe) {
            System.out.println("오류가 발생했습니다. 원인은: " + ioe.getMessage());
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe) {
                    System.out.println("오류 발생, 파일 닫기 실패.");
                }
            }
        }
    }

    public static void loadMembers(List<_0_MemberBase_ArrayList> members) {
        File file = new File(FILE_NAME);

        if(!file.exists()) {
            return;
        }
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while((line = br.readLine()) != null) {

                String[] data = line.split(",");
                if(data.length == 4) {
                    String name = data[0];
                    String email = data[1];
                    String password = data[2];
                    int age = Integer.parseInt(data[3]);
                    members.add(new _0_NormalMember_ArrayList(name, email, password, age));
                }
            }
            System.out.println("파일 불러오기 완료: " + members.size() + "명의 회원정보를 불러옴.");
        } catch (IOException ioe) {
            System.out.println("파일 불러오기 실패, 원인은: " + ioe.getMessage());
        } finally {
            //자원 반납
            if(br != null) {
                try {
                    br.close();
                } catch (IOException ioe) {
                    System.out.println("파일 닫기 실패");
                }
            }
        }
    }
}
