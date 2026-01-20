package _5_260119_260120._2_ManageUser;

import java.io.*;
import java.util.Scanner;

public class _2_ManageUser {
    //임시저장파일 추가(파일 이름 미리 지정, 정적(static))
    //파일이름을 미리 지정
    private static final String FILE_NAME = "members.txt";
    public static void main(String[] args) {
        //최대 5명까지 저장 가능한 배열 생성.
        _2_MemberBase[] members = new _2_MemberBase[5];
        int count = 0;	//현재 저장된 회원 수(배열 인덱스 관리용)

        //프로그램 시작시 회원 정보 불러오기
        count = loadMembers(members);
        _2_MemberBase loginMemeber = null;  //실습2 수정1: 로그인한 유저가 있는지 확인할 변수를 처음에 없으므르 null로 설정
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

                    System.out.println("비밀번호 : ");  //실습 수정7: 비밀번호 정보 받기
                    String password = sc.nextLine();

                    System.out.println("나이 : ");
                    try {
                        int age = Integer.parseInt(sc.nextLine());

                        //다형성 활용 : 부모 타입 배열에 자식 객체 저장.
                        _2_NormalMember newMember = new _2_NormalMember(name, email, password, age);    //실습 수정8: 생성자의 매개변수에 password 추가
                        //배열에 저장.
                        members[count] = newMember;
                        //인터페이스 메서드 호출
                        newMember.join();

                        //인덱스 증가, 현재 가입할 인원 증가
                        count++;

                        //회원가입시, 메모리상의 내용을 파일에 저장하는 메서드를 이용
                        saveMembers(members, count);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자를 입력하세요.");
                    } finally {
                        break;
                    }

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
                        for (int i = 0; i < count; i++) {
                            //임시 메모리에 저장된 회원의 이메일과 패스워드 확인 절차
                            //저장된 회원 한명씩 꺼내서, member에 담아두고, 입력된 이메일, 패스워드와 불러운 이메일, 패스워드를 비교
                            _2_MemberBase member = members[i];
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
    public static void saveMembers(_2_MemberBase[] members, int count) {
        //BufferedWriter: 버퍼를 사용해서 파일 쓰기 속도를 높여줌
        BufferedWriter bw = null;
        //try ~ catch ~ finally 무조건 사용해야 함
        //1)파일 입출력
        //2)네트워크 통신
        try {
            //스트림 생성.
            //new FileWriter(FILE_NAME) : 우리가 지정한 파일에 쓰겠다.
            //new BufferedWriter(여기) : "여기" 라는 내용을 좀더 빠르게 쓰겠다.
            bw = new BufferedWriter(new FileWriter(FILE_NAME));

            //members[i] 배열이고, 메모리상에 저장된 멤버들
            //반복문을 이용해서, 메모리상에 저장된 멤버들을 members.txt 파일에 기록하는 과정
            for (int i = 0; i < count; i++) {
//                _2_MemberBase member = members[i];
                _2_MemberBase member = members[i];
                //파일에 저장 형식: 이름, 이메일, 패스워드, 나이(구분자: 쉼표로 구분, csv)
                //기존 _2_MemberBase클래스에 이름, 이메일, 패스워드, 나이의 getter 생성
                String line = member.getName() + "," + member.getEmail() + "," + member.getPassword() + "," + member.getAge();
                //파일에 한줄씩 기록
                bw.write(line);
                //줄바꿈
                bw.newLine();
            }
            System.out.println("파일 저장 완료 " + FILE_NAME);

        } catch (IOException ioe) {
            System.out.println("오류가 발생했습니다. 원인은: " + ioe.getMessage());
        } finally {
            //bw 자원 반납
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("오류 발생, 파일 닫기 실패.");
                }
            }
        }
    }

    //임시저장파일 추가(불러오는 기능 메서드 만들기, 정적(static)
    //준비물:
    //1)메모리에 저장된 배열
    public static int loadMembers(_2_MemberBase[] members) {
        //물리파일 : members.txt 파일에 접근하고, 가져오는 기능을 담당하는 클래스 이용
        //담당 클래스 : File
        //스캐너 도구를 사용하듯이 파일 도구를 사용
        File file = new File(FILE_NAME);

        //유효성 체크
        //파일이 없다면, 해당 기능 실행을 중지
        if(!file.exists()) {    //해당 파일이 없을때
            return 0;
        }

        //실제 불러올 멤버의 숫자(상태 변수)
        int loadCount = 0;
        //버퍼를 이용해서 빠르게 불러오기
        BufferedReader br = null;

        try {
            //new FileReader(file) : 물리 파일 읽는 도구
            //new BufferedReader : 빨리 읽어주는 도구
            //br : 파일에서 읽었던 내용이 모두 br에 들어가 있음(내용물)
            br = new BufferedReader(new FileReader(FILE_NAME));

            //파일에서 읽어온 내용을 한줄씩 임의로 담아둘 변수
            String line;
            //br.readLine() : 전체 내용중에서 한줄 읽음
            while((line = br.readLine()) != null) {
                //유효성 기본 체크, 읽을때 배열의 크기 이상을 읽지 못하게 막기
                //loadCount : 4, members : 회원가입된 인원 3명 이라면 문제가 생기기때문에 막음
                if(loadCount >= members.length) {
                    break;
                }
                //정상적으로 불러오는 경우
                //쉼표를 기준으로 데이터를 불러오기
                //예시) 이름,이메일,비밀번호,나이에서 ,를 제거후 배열로 담음
                //String[] data = { "이름", "이메일", "비밀번호", "나이" }
                String[] data = line.split(",");
                if(data.length == 4) {
                    String name = data[0];
                    String email = data[1];
                    String password = data[2];
                    //Integer.parseInt : 문자열 -> 숫자로 반환
                    int age = Integer.parseInt(data[3]);

                    //파일에서 읽어온 내용을 -> 메모리 상의 배열에 담기
                    //name, email, password, age -> 객체에 담기 -> 사람 수만큼 배열로 담기
                    members[loadCount] = new _2_NormalMember(name, email, password, age);
                    loadCount++;
                }
            }
            System.out.println("파일 불러오기 완료: " + loadCount + "명의 회원정보를 불러옴.");
        } catch (IOException ioe) {
            System.out.println("파일 불러오기 실패, 원인은: " + ioe.getMessage());
        } finally {
            //자원 반납
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("파일 닫기 실패");
                }
            }
        }
        return loadCount;   //등록된 사람 수를 카운트 하는 곳에 값을 넣어주기 위해 필요(5칸짜리로 만들어 놓아서 length로는 확인 불가능해서)
    }
}
