package _4_260116;

public class _1_AccessModifier_Private {
    private String name;    //다른 클래스에서 접근 불가

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
