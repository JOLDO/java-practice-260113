package Practice;

public class User {
    private String email;
    private String password;
    private String name;
    private int age;
    private int lockCount;
    private boolean isLock;

    public User(String email, String password, String name, int age) {
        this(email, name, password, age, 0, false);
    }

    public User(String email, String password, String name, int age, int lockCount, boolean isLock) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
        this.lockCount = lockCount;
        this.isLock = isLock;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getLockCount() { return lockCount; }
    public boolean getIsLock() { return isLock; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setLockCount(int lockCount) { this.lockCount = lockCount; }
    public void setIsLock(boolean isLock) { this.isLock = isLock; }

    public void info() {
        System.out.println("==================================");
        System.out.println("이메일 : " + email);
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("이용불가 : " + isLock);
        System.out.println("==================================");
    }
}
