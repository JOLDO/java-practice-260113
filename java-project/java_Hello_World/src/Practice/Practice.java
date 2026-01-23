package Practice;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, User> map = new HashMap<>();
        loadFile(map);
        User loginUser = null;

        while(true) {
            System.out.println("===========메인===========");
            if(loginUser == null) {
                System.out.println("1.회원가입 2.회원목록 3.로그인 4.종료");
            } else {
                System.out.println(loginUser.getEmail());
                System.out.println("1.회원가입 2.회원목록 3.로그아웃 4.회원수정 5.회원검색 6.종료");
            }
            System.out.print("선택>> ");
            //숫자만되도록
            String mainNum = sc.nextLine();
            switch(mainNum) {
                case "1":
                    System.out.println("-----------회원가입-----------");
                    System.out.println("이메일을 입력해주세요.\n입력>> ");
                    String inputEmail = sc.nextLine();
                    if(map.containsKey(inputEmail)) {
                        System.out.println("이미 가입된 이메일입니다.");
                        break;
                    }
                    System.out.println("비밀번호를 입력해주세요.\n입력>> ");
                    String inputPassword = sc.nextLine();
                    System.out.println("이름을 입력해주세요.\n입력>> ");
                    String inputName = sc.nextLine();
                    boolean successSignUp = false;
                    for(int i = 0; i < 5; i++) {
                        try {
                            System.out.print("나이를 입력해주세요.\n입력>> ");
                            int inputAge = Integer.parseInt(sc.nextLine());

                            map.put(inputEmail, new User(inputEmail, inputPassword, inputName, inputAge));
                            System.out.println(map.get(inputEmail).getName());
                            saveFile(map);
                            successSignUp = true;
                            break;
                        } catch (Exception e) {
                            System.out.println("숫자로 입력해주세요.\n----------------------");
                        }
                    }
                    if(successSignUp) System.out.println("가입이 완료되었습니다.");
                    else System.out.println("가입에 실패했습니다.");
                    break;

                case "2":
                    System.out.println("-----------회원목록-----------");
                    if(map.isEmpty())   break;
                    for(User user : map.values()) {
                        user.info();
                    }
                    break;

                case "3":
                    if(loginUser == null) {
                        System.out.println("-----------로그인-----------");
                        System.out.println("이메일을 입력해주세요.\n입력>> ");
                        String loginId = sc.nextLine();
                        System.out.println("비밀번호를 입력해주세요.\n입력>> ");
                        String loginPw = sc.nextLine();
                        boolean isLogin = false;
                        boolean isLoginLock = false;
                            if (map.containsKey(loginId)) {
                                User attemptLogin = map.get(loginId);
                                if(!attemptLogin.getIsLock()) {
                                    if (loginPw.equals(attemptLogin.getPassword())) {
                                        isLogin = true;
                                        loginUser = attemptLogin;
                                        attemptLogin.setLockCount(0);
                                    } else {
                                        attemptLogin.setLockCount(attemptLogin.getLockCount() + 1);
                                        if (attemptLogin.getLockCount() == 3) {
                                            attemptLogin.setIsLock(true);
                                        }
                                    }
                                    saveFile(map);
                                }else {
                                    isLoginLock = true;
                                }
                            }
                            if(isLoginLock) System.out.println("로그인이 불가능합니다.");
                            else if (!isLogin) System.out.println("로그인에 실패했습니다.");
                    } else {
                        System.out.println("로그아웃되었습니다.");
                        loginUser = null;
                    }
                    break;

                case "4":
                    if(loginUser == null) {
                        System.out.println("-----------종료-----------");
                        return;
                    } else {
                        boolean modiExit = false;
                        boolean successModify = false;
                        do {
                            System.out.println("-----------회원수정-----------");
                            System.out.println("1.비밀번호 2.이름 3.나이 4.종료");
                            System.out.print("입력>> ");
                            String modiNum = sc.nextLine();
                            switch (modiNum) {
                                case "1":
                                    System.out.println("수정할 비밀번호로 입력해주세요.\n입력>> ");
                                    String modiPw = sc.nextLine();
                                    loginUser.setPassword(modiPw);
                                    saveFile(map);
                                    successModify = true;
                                    break;

                                case "2":
                                    System.out.println("수정할 이름으로 입력해주세요.\n입력>> ");
                                    String modiName = sc.nextLine();
                                    loginUser.setName(modiName);
                                    saveFile(map);
                                    successModify = true;
                                    break;

                                case "3":
                                    for(int i = 0; i < 5; i++) {
                                        try {
                                            System.out.println("수정할 나이로 입력해주세요.\n입력>> ");
                                            int modiAge = Integer.parseInt(sc.nextLine());
                                            loginUser.setAge(modiAge);
                                            saveFile(map);
                                            successModify = true;
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("숫자로 입력해주세요.\n----------------------");
                                        }
                                    }
                                    if(!successModify) System.out.println("수정에 실패했습니다.");
                                    break;

                                case "4":
                                    modiExit = true;
                                    System.out.println("-----------종료-----------");
                                    break;
                                default:
                                    System.out.println("선택한 기능이 없습니다.");
                            }
                        } while (!modiExit);
                        if(successModify) System.out.println("수정되었습니다.");
                    }
                    break;

                case "5":
                    if(loginUser == null) {
                        System.out.println("선택한 기능이 없습니다.");
                    } else {
                        boolean searchExit = false;
                        do{
                            System.out.println("-----------회원검색-----------");
                            System.out.println("1.이메일 2.이름 3.종료");
                            System.out.print("입력>> ");
                            String searchNum = sc.nextLine();
                            switch (searchNum) {
                                case "1":
                                    System.out.println("찾으실 이메일을 입력해주세요.\n입력>> ");
                                    String searchEmail = sc.nextLine();

                                    if (map.containsKey(searchEmail)) {
                                        map.get(searchEmail).info();
                                    } else {
                                        System.out.println("해당 이메일이 없습니다.");
                                    }
                                    break;

                                case "2":
                                    System.out.println("찾으실 이름을 입력해주세요.\n입력>> ");
                                    String searchName = sc.nextLine();

                                    boolean isExist = false;
                                    for (User search : map.values()) {
                                        if (search.getName().contains(searchName)) {
                                            isExist = true;
                                            search.info();
                                        }
                                    }
                                    if(!isExist) System.out.println("해당 사용자가 없습니다.");
                                    break;

                                case "3":
                                    searchExit = true;
                                    System.out.println("-----------종료-----------");
                                    break;

                                default:
                                    System.out.println("선택한 기능이 없습니다.");
                            }
                        } while (!searchExit);
                    }
                    break;

                case "6":
                    System.out.println("-----------종료-----------");
                    return;
                default:
                    System.out.println("선택한 기능이 없습니다.");
            }
        }
    }

    private static void saveFile(HashMap<String, User> map) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("members.txt"));
            for(User user : map.values()) {
                bw.write(user.getEmail() + "," + user.getPassword() + "," + user.getName() + "," + user.getAge() + "," + user.getLockCount() + "," + user.getIsLock());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {

        }
    }

    private static void loadFile(HashMap<String, User> map) {
        File file = new File("members.txt");
        if(!file.exists()) {
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length == 6) {
                    map.put(data[0], new User(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
                }
            }
        } catch (IOException e) {

        }
    }
}
