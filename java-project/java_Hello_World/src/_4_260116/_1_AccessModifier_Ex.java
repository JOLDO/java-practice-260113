package _4_260116;

public class _1_AccessModifier_Ex {
    private String owner;
    public static int accountCount = 0;
    public static final double INTEREST_RATE = 0.015;

    public _1_AccessModifier_Ex(String owner) {
        this.owner = owner;
        accountCount++;
    }

    public void info() {
        System.out.println("예금주: " + owner);
    }

    public static void showInfo() {
        System.out.println("총 계좌 수: " + accountCount);
        System.out.println("이자율: " + INTEREST_RATE);
    }
}
