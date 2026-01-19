package _5_260119._0_Inheritance_Case;

public class _0_Inheritance_Case {
    public static void main(String[] args) {
        _0_Inheritance_Case_Child child1 = new _0_Inheritance_Case_Child();

//        _0_Inheritance_Case_Parent p = new _0_Inheritance_Case_Child(); // 업캐스팅
//        if (p instanceof _0_Inheritance_Case_Child) {
//            _0_Inheritance_Case_Child c = (_0_Inheritance_Case_Child) p; // 다운캐스팅 (명시적)
//        }
        _0_Inheritance_Case_Cat cat1 = new _0_Inheritance_Case_Cat();
        cat1.sound(); // "야옹~" (오버라이딩된 메소드 호출)

        _0_Inheritance_Case_Animal cat_animal = new _0_Inheritance_Case_Cat(); // 업캐스팅(cat2는 애니멀 타입)
        cat_animal.sound(); // "야옹~" (오버라이딩된 메소드 호출)

        if (cat_animal instanceof _0_Inheritance_Case_Cat) {  //타입확인(업케스팅 상황)해당 타입이 맞는지
            _0_Inheritance_Case_Cat cat_cat = (_0_Inheritance_Case_Cat) cat_animal; //캣타입으로 변경
            System.out.println("Cat 타입입니다.");
        }
    }
}
