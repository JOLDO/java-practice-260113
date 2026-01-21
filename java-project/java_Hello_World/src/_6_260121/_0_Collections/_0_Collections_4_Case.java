package _6_260121._0_Collections;

import java.util.HashMap;

public class _0_Collections_4_Case {
    public static void main(String[] args) {
        _0_Collections_4_Case_Person person1 = new _0_Collections_4_Case_Person("최철수", 24);
        _0_Collections_4_Case_Person person2 = new _0_Collections_4_Case_Person("김종원", 36);
        _0_Collections_4_Case_Person person3 = new _0_Collections_4_Case_Person("오태흔", 36);
        _0_Collections_4_Case_Person person4 = new _0_Collections_4_Case_Person("손민", 37);

        HashMap<_0_Collections_4_Case_Person, Integer> studentsMap = new HashMap<>();

        studentsMap.put(person1, 70);
        studentsMap.put(person2, 90);
        studentsMap.put(person3, 15);
        studentsMap.put(person4, 0);

        for(_0_Collections_4_Case_Person student : studentsMap.keySet()) {
            System.out.println(student + ":" + studentsMap.get(student));
        }

        System.out.println();
        System.out.println("========참조형 객체는 값만 같아도 컬렉션에서 get으로 찾아낼수 있음========");
        System.out.println(
            new _0_Collections_4_Case_Person("김종원", 36) +
            ":" +
            studentsMap.get(new _0_Collections_4_Case_Person("김종원", 36))  //참조형은 값만 같아도 찾을수 있음
        );

    }
}
