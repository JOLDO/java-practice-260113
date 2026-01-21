package _6_260121._0_Collections;

import java.util.HashSet;

public class _0_Collections_2_HashSet {
    public static void main(String[] args) {
        //HashSet
        //순서 x, 중복 x
        //1)기본 생성방법 : HashSet<타입> [변수이름] = new HashSet<>();
        //2)추가 : set.add(타입 조건이 맞는 데이터) //중복된 값 추가 불가능
        //3)수정 : 삭제 후 추가    //set.remove(타입 조건이 맞는 데이터) -> set.add(타입 조건이 맞는 데이터)
        //4)삭제 : set.remove(타입 조건이 맞는 데이터)
        //5)조회 : 크기조회=set.size(), 해당 값이 있는지 조회=set.contains(타입 조건이 맞는 데이터)
        //6)전체 조회 : for 문으로 조회
        HashSet<Integer> set = new HashSet<>();
        System.out.println();
        System.out.println("추가");
        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println();
        System.out.println("중복 추각 여부");
        boolean isAdded = set.add(10);
        System.out.println("중복 추가=" + isAdded);


        System.out.println();
        System.out.println("수정(삭제 -> 추가)");
        set.remove(10);
        set.add(100);

        System.out.println();
        System.out.println("조회");
        System.out.println("크기=" + set.size());
        System.out.println("100이 있는지 조회=" + set.contains(100));

        System.out.println();
        System.out.println("전체 조회");
        for(int integer: set) {
            System.out.println(integer);
        }

    }
}
