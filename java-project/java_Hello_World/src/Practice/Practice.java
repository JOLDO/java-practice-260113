package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Practice extends JFrame {
    private final String FILE_NAME = Path.of("src", Practice.class.getPackageName().replace(".", File.separator), "members.txt").toString();   //회원가입한 유저 데이터 저장팔 파일 이름(고정)
    private HashMap<String, User> map = new HashMap<>();
    private User loginUser = null;
    private JLabel statusLabel = new JLabel("-로그아웃-", SwingConstants.CENTER);
    private JTextArea textArea;
    private JPanel btnPanel;
    private JButton signUpBtn, listBtn, loginBtn, editBtn, searchBtn, deleteBtn, exitBtn;

    public Practice() {
        super("UI연습용");

        loadFile(map);

        initView();
        updateStateButton();

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initView() {
        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        btnPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        signUpBtn = new JButton("회원가입");
        listBtn = new JButton("회원목록");
        loginBtn = new JButton("로그인");
        editBtn = new JButton("회원수정");
        searchBtn = new JButton("회원검색");
        deleteBtn = new JButton("회원삭제");
        exitBtn = new JButton("종료");

        signUpBtn.addActionListener(new ActionHandler());
        listBtn.addActionListener(new ActionHandler());
        loginBtn.addActionListener(new ActionHandler());
        editBtn.addActionListener(new ActionHandler());
        searchBtn.addActionListener(new ActionHandler());
        deleteBtn.addActionListener(new ActionHandler());
        exitBtn.addActionListener(new ActionHandler());

        btnPanel.add(signUpBtn);
        btnPanel.add(listBtn);
        btnPanel.add(loginBtn);
        btnPanel.add(editBtn);
        btnPanel.add(searchBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(exitBtn);

        add(btnPanel, BorderLayout.SOUTH);
    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source == signUpBtn) {
                if(loginUser == null) {
                    signUp();
                } else {
                    printText("로그아웃을 먼저 해주세요.");
                }
            } else if(source == listBtn) {
                if(loginUser == null)   textArea.setText("");
                listUp();
            } else if(source == loginBtn) {
                if(loginUser == null) {
                    login();
                } else {
                    logout(false);
                }
            } else if(source == editBtn) {
                if(loginUser == null) {
                    printText("로그인을 먼저 해주세요.");
                } else {
                    edit();
                }
            } else if(source == searchBtn) {
                if(loginUser == null) {
                    printText("로그인을 먼저 해주세요.");
                } else {
                    search();
                }
            } else if(source == deleteBtn) {
                if(loginUser == null) {
                    printText("로그인을 먼저 해주세요.");
                } else {
                    delete();
                }
            } else if(source == exitBtn) {
                System.exit(0);
            }
        }
    }

    private void signUp() {
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField ageField = new JTextField();
        Object[] signComp = new Object[] {
                "이름 : ", nameField,
                "이메일 : ", emailField,
                "비밀번호 : ", passwordField,
                "나이 : ", ageField
        };
        int option = JOptionPane.showConfirmDialog(this, signComp, "회원가입", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            if(map.containsKey(emailField.getText())) {
                printText("등록된 유저 정보가 존재합니다.");
            } else {
                try {
                    map.put(emailField.getText(), new User(
                            emailField.getText(),
                            new String(passwordField.getPassword()),
                            nameField.getText(),
                            Integer.parseInt(ageField.getText())
                    ));
                    printText(nameField.getText() + "님 회원가입에 성공했습니다.");
                    saveFile(map);
                } catch (NumberFormatException nfe) {
                    printText(nameField.getText() + "님 회원가입에 실패했습니다.");
                }
            }
        }
    }

    private void listUp() {
        if(map.isEmpty()) {
            printText("회원이 없습니다.");
            return;
        }

        textArea.append("==============================================================\n");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            printText(e.getValue().infoStr());
        });
        /*for(User user : map.values()) {
            printText(user.infoStr());
        }*/
        textArea.append("==============================================================\n");
    }

    private void login() {
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        Object[] loginComp = new Object[] {
                "이메일 : ", emailField,
                "비밀번호 : ", passwordField
        };
        int option = JOptionPane.showConfirmDialog(this, loginComp, "로그인", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            if(map.containsKey(emailField.getText())) {
                User attempedUser = map.get(emailField.getText());
                if(attempedUser.getIsLock()) {
                    printText("로그인이 불가능합니다.");
                    return;
                }
                if(attempedUser.getPassword().equals(new String(passwordField.getPassword()))) {
                    textArea.setText("");
                    printText("로그인에 성공했습니다.");
                    loginUser = attempedUser;
                    attempedUser.setLockCount(0);
                    updateStateButton();
                } else {
                    printText("로그인에 실패했습니다.");
                    attempedUser.setLockCount(attempedUser.getLockCount() + 1);
                    if(attempedUser.getLockCount() == 3) {
                        attempedUser.setIsLock(true);
                    }
                }
                saveFile(map);
            } else {
                printText("로그인에 실패했습니다.");
            }
        }
    }

    private void logout(boolean deleteFlag) {
        if(deleteFlag) {
            printText("삭제되었습니다.");
        } else {
            printText("로그아웃되었습니다.");
        }
        loginUser = null;
        updateStateButton();
    }

    private void updateStateButton() {
        if(loginUser == null) {
            statusLabel.setText("-로그아웃-");
            loginBtn.setText("로그인");
            listBtn.setEnabled(false);
            editBtn.setEnabled(false);
            searchBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            statusLabel.setText("-" + loginUser.getName() + "님 로그인-");
            loginBtn.setText("로그아웃");
            listBtn.setEnabled(true);
            editBtn.setEnabled(true);
            searchBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }

    private void edit() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        JPasswordField passwordField = new JPasswordField();
        JTextField inputField = new JTextField();
        inputPanel.add(passwordField, BorderLayout.CENTER);

        ButtonGroup btnGroup = new ButtonGroup();
        JRadioButton passwordBtn = new JRadioButton("비밀번호");
        JRadioButton nameBtn = new JRadioButton("이름");
        JRadioButton ageBtn = new JRadioButton("나이");

        ActionListener editListener = e -> {
            inputPanel.removeAll();
            if(passwordBtn.isSelected()) {
                passwordField.setText("");
                inputPanel.add(passwordField);
            } else {
                inputField.setText("");
                inputPanel.add(inputField);
            }
            inputPanel.revalidate();
            inputPanel.repaint();
        };

        passwordBtn.addActionListener(editListener);
        nameBtn.addActionListener(editListener);
        ageBtn.addActionListener(editListener);

        btnGroup.add(passwordBtn);
        btnGroup.add(nameBtn);
        btnGroup.add(ageBtn);

        passwordBtn.setSelected(true);

        Object[] editComp = new Object[] {
                passwordBtn,
                nameBtn,
                ageBtn,
                "\n",
                "수정 값 : ", inputPanel
        };
        int option = JOptionPane.showConfirmDialog(this, editComp, "수정", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            try {
                if(passwordBtn.isSelected()) {
                    loginUser.setPassword(new String(passwordField.getPassword()));
                } else if(nameBtn.isSelected()) {
                    loginUser.setName(inputField.getText());
                } else if(ageBtn.isSelected()) {
                    loginUser.setAge(Integer.parseInt(inputField.getText()));
                }
                saveFile(map);
                printText("수정에 성공했습니다.");
            } catch (NumberFormatException nfe) {
                printText("수정에 실패했습니다.");
            }
        }
    }

    private void search() {
        ButtonGroup btnGroup = new ButtonGroup();
        JRadioButton emailBtn = new JRadioButton("이메일");
        JRadioButton nameBtn = new JRadioButton("이름");
        JTextField searchField = new JTextField();

        btnGroup.add(emailBtn);
        btnGroup.add(nameBtn);

        emailBtn.setSelected(true);

        Object[] searchComp = new Object[] {
                emailBtn,
                nameBtn,
                "\n",
                "검색 내용 : ", searchField
        };

        int option = JOptionPane.showConfirmDialog(this, searchComp, "검색", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            if(emailBtn.isSelected()) {
                if(map.containsKey(searchField.getText())) {
                    printText(map.get(searchField.getText()).infoStr());
                } else {
                    printText("유저 정보가 없습니다.");
                }
            } else if(nameBtn.isSelected()) {
                boolean isSearch = false;
                for(User user : map.values()) {
                    if(user.getName().contains(searchField.getText())) {
                        isSearch = true;
                        printText(user.infoStr());
                    }
                }
                if(!isSearch)   printText("유저 정보가 없습니다.");
            }
        }

    }

    private void delete() {
        JPasswordField passwordField = new JPasswordField();
        Object[] deleteComp = new Object[] {
                "비밀번호 : ", passwordField
        };

        int option = JOptionPane.showConfirmDialog(this, deleteComp, "삭제", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            if(loginUser.getPassword().equals(new String(passwordField.getPassword()))) {
                map.remove(loginUser.getEmail());
                saveFile(map);
                logout(true);
            } else {
                printText("삭제에 실패했습니다.");
            }
        }
    }

    private void printText(String msg) {
        textArea.append(msg + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Practice();
        });
    }

    private void saveFile(HashMap<String, User> map) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for(User user : map.values()) {
                bw.write(user.getEmail() + "," + user.getPassword() + "," + user.getName() + "," + user.getAge() + "," + user.getLockCount() + "," + user.getIsLock());
                bw.newLine();
            }
        } catch (IOException e) {

        }
    }

    private void loadFile(HashMap<String, User> map) {
        File file = new File(FILE_NAME);
        if(!file.exists()) {
            return;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
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
