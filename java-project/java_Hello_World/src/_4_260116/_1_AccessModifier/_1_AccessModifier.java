package _4_260116._1_AccessModifier;

public class _1_AccessModifier {
    public static void main(String[] args) {
        _1_AccessModifier_Private samplePrivate = new _1_AccessModifier_Private();
        //name이 public일 경우 : sample1.name = ""; 접근 가능 하지만 private는 접근 불가
        //보통 private로 변수 선언후 public으로 getter/setter로 선언해서 호출
        samplePrivate.setName("태흔");
        System.out.println(samplePrivate.getName());

        _1_AccessModifier_Static sampleStatic1 = new _1_AccessModifier_Static();
        sampleStatic1.num = 100;
        System.out.println(sampleStatic1.num);

        _1_AccessModifier_Static sampleStatic2 = new _1_AccessModifier_Static();
        sampleStatic2.num = 200;
        System.out.println(sampleStatic2.num);

        System.out.println(sampleStatic1.getCount() + "/" + sampleStatic2.getCount() + "/" + _1_AccessModifier_Static.count);
        _1_AccessModifier_Static.increment();
        _1_AccessModifier_Static.increment();
        System.out.println(sampleStatic1.getCount() + "/" + sampleStatic2.getCount() + "/" + _1_AccessModifier_Static.count);


        _1_AccessModifier_Final sampleFinal = new _1_AccessModifier_Final();
//        _1_AccessModifier_Final.PI = 11.1;    //파이널이라 상수라서 변경 안됨
        sampleFinal.printMessage();
    }


}
