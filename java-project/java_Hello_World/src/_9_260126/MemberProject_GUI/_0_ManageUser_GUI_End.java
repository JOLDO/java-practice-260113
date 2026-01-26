package _9_260126.MemberProject_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class _0_ManageUser_GUI_End extends JFrame {
    //임시저장파일 추가(파일 이름 미리 지정, 정적(static))
    //파일이름을 미리 지정
//    private static final String FILE_NAME = "src/" + _0_ManageUser_GUI_End.class.getPackageName().replace(".", "/") + "/members.txt";   //회원가입한 유저 데이터 저장팔 파일 이름(고정)
    private static final String FILE_NAME = Path.of("src", _0_ManageUser_GUI_End.class.getPackageName().replace(".", File.separator), "members.txt").toString();
    private Map<String, _0_MemberBase_GUI_End> members = new HashMap<>();
    private _0_MemberBase_GUI_End loginMember = null;

    private JTextArea displayArea;
    private JPanel buttonPanel;
    private JLabel statusLabel;

    private JButton btnJoin, btnList, btnLoginLogout, btnEdit, btnSearch, btnDelete, btnExit;

    public static void main(String[] args) {
        /*
        members = members.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey()) //키 값으로 오름차순 정렬
                        .collect(
                                LinkedHashMap::new,
                                (m, e) 
                                        -> m.put(e.getKey(), e.getValue()), //m은 LinkedHashMap(순서있는 맵), e는 members의 정렬된채로 차례대로 읽어오는 각각의 (키,값)엔트리
                                LinkedHashMap::putAll   //LinkedHashMap으로 집어 모두 넣는다.
                        );  //즉 members를 HashMap -> LinkedHashMap으로 변경
         */
        SwingUtilities.invokeLater(() -> {  //생성자를 스레드로 호출해준다.
            new _0_ManageUser_GUI_End();
        });
    }

    public _0_ManageUser_GUI_End() {
        super("회원 관 시스템 ver 3.2(GUI버전)");
        loadMembers(members);

        initUI();

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //화면 중앙배치
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setLayout(new BorderLayout());

        //1.상단 - 상태표시중
        statusLabel = new JLabel("로그인 상태 : 로그아웃 됨", SwingConstants.CENTER);
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));   //위아래 패딩 비슷한것
        add(statusLabel, BorderLayout.NORTH);

        //2.중앙 - 텍스트 영역(콘솔 출력 대체)
        displayArea = new JTextArea();
        displayArea.setEditable(false); //수정 불가 세팅
        displayArea.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 14));
        add(new JScrollPane(displayArea), BorderLayout.CENTER); //textArea안에 스크롤 생성

        //3.하단 - 버튼 패널
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5));

        //패널에 버튼 추가
        btnJoin = new JButton("1 회원가입");
        btnList = new JButton("2 목록조회");
        btnLoginLogout = new JButton("3 로그인");
        btnEdit = new JButton("4 회원수정");
        btnSearch = new JButton("5 회원검색");
        btnDelete = new JButton("6 회원탈퇴");
        btnExit = new JButton("7 종료");

        btnJoin.addActionListener(new ActionHandler());
        btnList.addActionListener(new ActionHandler());
        btnLoginLogout.addActionListener(new ActionHandler());
        btnEdit.addActionListener(new ActionHandler());
        btnSearch.addActionListener(new ActionHandler());
        btnDelete.addActionListener(new ActionHandler());
        btnExit.addActionListener(new ActionHandler());

        buttonPanel.add(btnJoin);
        buttonPanel.add(btnList);
        buttonPanel.add(btnLoginLogout);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnExit);

        //패널 배치
        add(buttonPanel, BorderLayout.SOUTH);

        //버튼들의 초기 상태 결정. 임시 메서드 설정
        updateButtonState();

        //버튼 이벤트리스너
    }

    //버튼이벤트 내부 클래스(버튼이 많을땐 재사용할수 있게 내부 클래스로 사용)
    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //e.getSource()는 입력 대상
            //Object: 모든 클래스의 부모(최상위 부모)
            //클릭한 요소를 Object에 넣어두고 요소가 무엇인지 정확히 분기
            Object source = e.getSource();
            if (source == btnJoin) {
                handleJoin();
            } else if (source == btnList) {
                handleList();
            } else if (source == btnLoginLogout) {
                handleLoginLogout();
            } else if (source == btnEdit) {
                handleEdit();
            } else if (source == btnSearch) {
                handleSearch();
            } else if (source == btnDelete) {
                handleDelete();
            } else if (source == btnExit) {
                handleExit();
            }
        }
    }

    //함수 기능 구현
    //로그 출력 헬퍼
    private void printLog(String msg){
        displayArea.append(msg + "\n");
        //스크롤을 최하단으로 이동
        displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }

    //회원가입
    private void handleJoin() {
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();    //마스킹 처리 editText
        JTextField ageField = new JTextField();

        //타입 : Object배열 생성 후 데이터 담기
        //문자열과 UI 요소를 담기위해 Object로 배열을 만듬
        Object[] message = {
                "이름 : ", nameField,
                "이메일 : ", emailField,
                "비밀번호 : ", passwordField,
                "나이 : ", ageField
        };

        //this : 다이얼로그 창 화면을 어디에 출력 할지? 현재 frame창
        //message : 입력된 내용.
        //"회원가입" : 다이얼로그 창 제목
        //JOptionPane.OK_CANCEL_OPTION : 확인 - 0, 취소 - 2
        int option = JOptionPane.showConfirmDialog(this, message, "회원가입", JOptionPane.OK_CANCEL_OPTION);
        System.out.println(option);
        if(option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword()); //이거 그냥 컨버트 해봐
            String ageStr = ageField.getText();

            if(members.containsKey(email)) {
                JOptionPane.showMessageDialog(this, "이미 가입된 이메일입니다.");
                return;
            }

            try {
                int age = Integer.parseInt(ageStr);
                _0_NormalMember_GUI_End newMember = new _0_NormalMember_GUI_End(name, email, password, age);
                members.put(email, newMember);
                saveMembers(members);
                displayArea.setText("");
                printLog("회원가입 완료 : " + email);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "나이는 숫자만 입력하세요.");
            }
        }
    }

    //목록조회
    private void handleList() {
        if(loginMember == null) {
            JOptionPane.showMessageDialog(this, "로그인 후 이용해주세요.");
            return; //수정기능 나가기
        }
        displayArea.setText("");    //최초엔 항상 데이터 비우고, 새로 데이터 채우기
        printLog("===회원 목록===");
        if(members.isEmpty()) {
            printLog("가입된 회원이 없습니다.");
        } else {
            members.entrySet().stream()
                                .sorted(Map.Entry.comparingByKey()) //키 기준 오픔차순
//                                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))  //키 기준 내림차순
//                    .sorted(Map.Entry.comparingByValue(Comparator.comparing(_0_MemberBase_GUI::getAge)  //주 기준 나이순 오름차순
//                            .thenComparing(_0_MemberBase_GUI::getName, Comparator.reverseOrder()))) //부 기준 이름순 내림차순
                    .forEach(e -> {
                        _0_MemberBase_GUI_End sorted = e.getValue();
                        String info = String.format("이름 : %s | 이메일 : %s | 나이 : %d", sorted.getName(), sorted.getEmail(), sorted.getAge());
                        printLog(info);
                    });
            /*
            for(_0_MemberBase_GUI member : members.values()) {
                String info = String.format("이름 : %s | 이메일 : %s | 나이 : %d",
                        member.getName(), member.getEmail(), member.getAge());
                printLog(info);
            }
            */
        }
    }

    //로그인_로그아웃
    private void handleLoginLogout() {  //여기 선생님 코드랑 비교해서 더 넣을거 있는지 확인해보기
        if(loginMember == null) {
            JTextField emailField = new JTextField();
            JPasswordField passwordField = new JPasswordField();    //마스킹 처리 editText

            Object[] message = {
                    "이메일 : ", emailField,
                    "비밀번호 : ", passwordField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "로그인", JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if(members.containsKey(email)) {
                    _0_MemberBase_GUI_End user = members.get(email);
                    if (user.getPassword().equals(password)) {
                        loginMember = user;
                        printLog(">>>>로그인 되었습니다.");
                        updateButtonState();
                    } else {
                        JOptionPane.showMessageDialog(this, "비밀번호 틀림");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "사용자 정보 없음");
                }
            }
        } else {
            loginMember = null;
            printLog(">>>>로그아웃 되었습니다.");
            updateButtonState();
        }
    }

    //회원수정
    private void handleEdit() {
        //로그인 체크 후, 로그인시에만 수정가능
        if(loginMember == null) {
            JOptionPane.showMessageDialog(this, "로그인 후 이용해주세요.");
            return; //수정기능 나가기
        }
        //화면 선택 다이얼로그
        String[] options = {"비밀번호", "이름", "나이"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "수정할 항목 선택 해주세요.",
                "회원정보변경",
                JOptionPane.DEFAULT_OPTION, //옵션 종류
                JOptionPane.INFORMATION_MESSAGE,   //메세지 형태의 아이콘
                null,   //커스텀 아이콘
                options,    //선택지
                null    //초기 선택지
//                options[0]
        );

        if(choice == -1) {
            return;
        }

        String newValue = JOptionPane.showInputDialog(this, "새로운 값을 입력하세요 : ");
        if(newValue == null) {
            return;
        }
        if(newValue.isBlank() || (choice != 1 && newValue.contains(" "))) {
            JOptionPane.showMessageDialog(this, "값을 정상적으로 입력해주세요.");
            return;
        }

        boolean isUpdated = false;
        switch (choice) {
            case 0:
                loginMember.setPassword(newValue);
                isUpdated = true;
                break;

            case 1:
                loginMember.setName(newValue);
                isUpdated = true;
                break;

            case 2:
                try {
                    loginMember.setAge(Integer.parseInt(newValue));
                    isUpdated = true;
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "잘못된 나이 입력입니다.");
                }
                break;
        }

        if(isUpdated) {
            saveMembers(members);
            printLog(">>>>정보가 수정되었습니다.");
            updateButtonState();
        }

    }

    //회원검색
    private void handleSearch() {
        if(loginMember == null) {
            JOptionPane.showMessageDialog(this, "로그인 후 이용해주세요.");
            return; //수정기능 나가기
        }
        String[] options = {"이메일 검색", "이름으로 검색"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "검색할 항목 선택 해주세요.",
                "회원 검색",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null
        );
        if(choice == -1) {
            return;
        }
        String newValue = JOptionPane.showInputDialog(this, "검색어를 입력하세요.");
        if(newValue == null || newValue.trim().isEmpty())    return;
        displayArea.setText("");
        printLog(">>>검색 결과 : " + newValue + " ~~");
        boolean isFound = false;
        if(choice == 0) {
            if(members.containsKey(newValue)) {
                _0_MemberBase_GUI_End member = members.get(newValue);
                printLog(String.format("이름 : %s | 이메일 : %s | 나이 : %d", member.name, member.email, member.age));
                isFound = true;
            }
        } else if(choice == 1) {
            for(_0_MemberBase_GUI_End member : members.values()) {
                if (member.getName().contains(newValue)) {
                    printLog(String.format("이름 : %s | 이메일 : %s | 나이 : %d", member.name, member.email, member.age));
                    isFound = true;
                }
            }
        }

        if(!isFound)   printLog("검색결과가 없습니다.");
    }

    private void handleDelete() {
        if(loginMember == null) {
            JOptionPane.showMessageDialog(this, "로그인 후 본인탈퇴만 가능합니다.");
            return;
        }
        int response = JOptionPane.showConfirmDialog(this, "정말로 회원 탈퇴를 하시겠습니까?\n모든 정보가 삭제됩니다.", "회원 탈퇴 확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(response == JOptionPane.YES_OPTION) {
            String inputPassword = JOptionPane.showInputDialog(this, "비밀번호를 입력하세요.");
            if(inputPassword != null && inputPassword.equals(loginMember.getPassword())) {
                String targetEmail = loginMember.getEmail();
                members.remove(targetEmail);
                saveMembers(members);
                printLog(">>>회원탈퇴 완료 " + targetEmail);
                handleLoginLogout();

                JOptionPane.showMessageDialog(this, "탈퇴 처리가 완료되었습니다.");
            } else if(inputPassword != null) {
                JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
            }
        }
    }

    //종료
    private void handleExit() {
        System.exit(0);
    }

    private void updateButtonState() {
        if(loginMember == null) {
            statusLabel.setText("로그인 상태 : 로그아웃 됨");
            btnLoginLogout.setText("3 로그인");
            btnList.setEnabled(false);
            btnEdit.setEnabled(false);  //버튼 비활성화
            btnSearch.setEnabled(false);
            btnDelete.setEnabled(false);
        } else {
            statusLabel.setText("로그인 중 : " + loginMember.getEmail() + "(" + loginMember.getName() + ")");
            btnLoginLogout.setText("3 로그아웃");
            btnList.setEnabled(true);
            btnEdit.setEnabled(true);   //버튼 활성화
            btnSearch.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }

        /*Scanner sc = new Scanner(System.in);

        //메뉴 반복문 이용해서 그려보기.
        while(true) {
            System.out.println("\n=======회원 관리 시스템 ver 2.1=======(검색기능 추가)");
            if(loginMember != null) {  //실습2 수정2: 로그인 한 유저 데이터가 있으면
                System.out.println("로그인한 유저 : " + loginMember.getEmail());
                System.out.println("1.회원가입 2.목록조회 3.로그아웃 4.회원수정 5.회원검색 6.종료");
            } else {
//                System.out.println("1.회원가입 2.목록조회 3.종료");
                System.out.println("1.회원가입 2.목록조회 3.로그인 4.회원수정 5.회원검색 6.종료"); //실습 수정1: 메뉴 변경
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

                    if(members.containsKey(email)) {
                        System.out.println("동일한 이메일이 존재합니다.");
                        break;
                    }

                    System.out.println("비밀번호 : ");  //비밀번호 정보 받기
                    String password = sc.nextLine();

                    System.out.println("나이 : ");
                    try {
                        int age = Integer.parseInt(sc.nextLine());

                        //다형성 활용 : 부모 타입 배열에 자식 객체 저장.
                        _0_NormalMember_GUI newMember = new _0_NormalMember_GUI(name, email, password, age);    //실습 수정8: 생성자의 매개변수에 password 추가

                        members.put(email, newMember);
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
                        members.entrySet().stream()
//                                .sorted(Map.Entry.comparingByKey()) //키 기준 오픔차순
//                                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))  //키 기준 내림차순
                                .sorted(Map.Entry.comparingByValue(Comparator.comparing(_0_MemberBase_GUI::getAge)  //주 기준 나이순 오름차순
                                        .thenComparing(_0_MemberBase_GUI::getName, Comparator.reverseOrder()))) //부 기준 이름순 내림차순
                                .forEach(e -> e.getValue().showInfo()); //각각 showInfo()로 사용해줌
                        //이렇게 정렬할수 있음
//                        for(_0_MemberBase_HashMap member : members.values()) {
//                            member.showInfo();  //다형성(오버라이딩된 메서드 실행)
//                        }
                    }
                    break;

                //로그인 기능 추가
                case 3:
                    if(loginMember == null) {
                        System.out.println("\n=====로그인=====");
                        //이메일과 패스워드 정보 받아서 배열에 등록된 이메일로 유저 찾고 비밀번호가 일치하면 로그인, 불일치하면 로그인 불가
                        System.out.println("이메일 : ");
                        String inputEmail = sc.nextLine();

                        System.out.println("패스워드 : ");
                        String inputPassword = sc.nextLine();

                        //회원정보가 들어있는 배열 전체 순회
                        //for(_0_MemberBase_HashMap member : members.values()) {
                        if(members.containsKey(inputEmail)) {
                            _0_MemberBase_GUI member = members.get(inputEmail);
                            //임시 메모리에 저장된 회원의 이메일과 패스워드 확인 절차
                            //저장된 회원 한명씩 꺼내서, member에 담아두고, 입력된 이메일, 패스워드와 불러운 이메일, 패스워드를 비교
                            //수정
                            //주의 사항, 문자열 비교시에는 문자열.equals(비교문자열) 사용
                            if (member.getPassword().equals(inputPassword)) {
                                loginMember = member;  //로그인 성공시 그 맴버의 데이터를 로그인 한 멤버 데이터에 넣어줌
                                System.out.println("로그인 성공!! 환영합니다.~" + member.name + "님");
                            }  else {
                                System.out.println("로그인 실패: 비밀번호가 일치하지 않습니다.");
                            }
                        } else {
                            System.out.println("로그인 실패: 정보가 일치하지 않습니다.");
                        }
                        //로그인 실패인 경우
                    } else {
                        System.out.println("로그아웃 되었습니다.");
                        loginMember = null;    //로그아웃을 할때 로그인한 유저 데이터를 비워준다.
                    }
                    break;

                //종료 기능 3에서 4로 변경
                case 4:
                    //회원 수정 기능 추가(로그인 했을경우만)
                    if(loginMember == null) {
                        System.out.println("로그인 이후에 수정할 수 있습니다.");
                    } else {
                        System.out.println("\n========회원 정보 수정=========");
                        System.out.println("수정할 항목을 선택하세요.");
                        System.out.println("1.비밀번호 2.이름 3.나이 4.취소");
                        System.out.println("입력>>");
                        String choiceNumber = sc.nextLine();
                        boolean isUpdated = false;

                        switch (choiceNumber) {
                            case "1":
                                System.out.println("새로운 비밀번호 입력: ");
                                String newPw = sc.nextLine();
                                loginMember.setPassword(newPw);
                                isUpdated = true;
                                break;

                            case "2":
                                System.out.println("새로운 이름 입력: ");
                                String newName = sc.nextLine();
                                loginMember.setPassword(newName);
                                isUpdated = true;
                                break;

                            case "3":
                                System.out.println("새로운 나이 입력: ");
                                try {
                                    int newAge = Integer.parseInt(sc.nextLine());
                                    loginMember.setAge(newAge);
                                    isUpdated = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("잘못된 나이 입력입니다.");
                                }
                                break;

                            case "4":
                                System.out.println("수정 취소");
                                break;

                            default:
                                System.out.println("잘못된 입력입니다.");
                        }
                        if(isUpdated) {
                            saveMembers(members);
                        }

                    }
                    break;

                case 5:
                    System.out.println("\n========회원 정보 수정=========");
                    System.out.println("1.이메일(ID)로 검색(정확히 일치)");
                    System.out.println("2.이름으로 검색(포함된 이름)");
                    System.out.println("번호선택>>");
                    String searchType = sc.nextLine();
                    if(searchType.equals("1")) {
                        System.out.println("검색할 이메일 입력 : ");
                        String searchEmail = sc.nextLine();
                        if(members.containsKey(searchEmail)) {
                            System.out.println("\n검색 결과");
                            members.get(searchEmail).showInfo();
                        } else {
                            System.out.println("해당 이메일의 회원이 없습니다.");
                        }
                    } else if(searchType.equals("2")) {
                        System.out.println("검색할 이름 입력 : ");
                        String searchName = sc.nextLine();
                        boolean isFound = false;
                        System.out.println("검색중....");
                        for(_0_MemberBase_GUI member : members.values()) {
                            if (member.getName().contains(searchName)) {
                                member.showInfo();
                                isFound = true;
                            }
                        }
                        if(!isFound) System.out.println("회원을 찾을수 없습니다.");
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                    break;

                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); //스캐너 자원반납
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }*/

    //임시저장파일 추가(저장하는 기능 메서드 만들기, 정적(static)
    //준비물:
    //1)메모리 상에 저장된 멤버들 배열 members
    //2)가입된 인원수 count

    //임시저장파일 추가(불러오는 기능 메서드 만들기, 정적(static)
    //준비물:
    //1)메모리에 저장된 배열
    public static void saveMembers(Map<String, _0_MemberBase_GUI_End> members) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (_0_MemberBase_GUI_End member : members.values()) {
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

    public static void loadMembers(Map<String, _0_MemberBase_GUI_End> members) {
        File file = new File(FILE_NAME);

        if(!file.exists()) {
            return;
        }
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {

                String[] data = line.split(",");
                if(data.length == 4) {
                    String name = data[0];
                    String email = data[1];
                    String password = data[2];
                    int age = Integer.parseInt(data[3]);
                    members.put(email, new _0_NormalMember_GUI_End(name, email, password, age));
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
