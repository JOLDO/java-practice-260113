package _4_260116;

public class _1_AccessModifier_Ex_Main {
    public static void main(String[] args) {
        _1_AccessModifier_Ex client1 = new _1_AccessModifier_Ex("고객1");
        client1.info();
        _1_AccessModifier_Ex client2 = new _1_AccessModifier_Ex("고객2");
        client2.info();
        _1_AccessModifier_Ex client3 = new _1_AccessModifier_Ex("고객3");
        client3.info();

        _1_AccessModifier_Ex.showInfo();
    }
}
