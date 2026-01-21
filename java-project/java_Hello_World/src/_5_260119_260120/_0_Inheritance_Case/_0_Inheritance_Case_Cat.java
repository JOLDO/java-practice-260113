package _5_260119_260120._0_Inheritance_Case;

public class _0_Inheritance_Case_Cat extends _0_Inheritance_Case_Animal{
    @Override   //재정의를 안하면 부모의 sound할수 호출
    public void sound() {
        System.out.println("야옹~");
    }
}
