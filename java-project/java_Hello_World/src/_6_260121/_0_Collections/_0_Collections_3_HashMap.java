package _6_260121._0_Collections;

import java.util.HashMap;

public class _0_Collections_3_HashMap {
    public static void main(String[] args) {
        //HashMap
        //순서 x, 키 중복 x, 값 중복 o
        //1)기본 생성방법 : HashMap<키 타입, 값 타입> [변수이름] = new HashMap<>();
        //2)추가 및 수정 : map.put(키 타입 조건이 맞는 데이터, 값 타입 조건이 맞는 데이터) //키 값이 같으면 해당 값이 수정됨
        //3)삭제 : map.remove(키)
        //4-1)키 검색 : map.containsKey(키)
        //4-2)값 검색 : map.containsValue(값)
        //5)조회 : map.get(키)
        //6-1)키를 이용한 전체 조회 : map.keySet()   //for 문으로 조회
        //6-2)값만 출력 : map.values()  //for 문으로 조히
        //Integer : 기초 타입 정수를 객체 타입으로 변환된 클래스
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("추가");
        map.put("user1", 90);
        map.put("user2", 85);
        map.put("user3", 100);

        System.out.println();
        System.out.println("조회");
        System.out.println(map.get("user2"));

        System.out.println();
        System.out.println("수정");
        map.put("user2", 90);
        System.out.println(map.get("user2"));

        System.out.println();
        System.out.println("삭제");
        map.remove("user2");
        System.out.println(map.get("user2"));

        System.out.println();
        System.out.println("검색");
        boolean hasKey = map.containsKey("user1");
        System.out.println("키가 존재하는지 여부=" + hasKey);
        boolean hasValue = map.containsValue(90);
        System.out.println("키가 존재하는지 여부=" + hasValue);

        for(String key : map.keySet()) {
            System.out.println("키=" + key + ", 값=" + map.get(key));
        }

        for(int num : map.values()) {
            System.out.println("값들만 출력=" + num);
        }
    }
}
