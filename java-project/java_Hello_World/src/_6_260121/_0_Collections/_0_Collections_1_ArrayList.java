package _6_260121._0_Collections;

import java.util.ArrayList;

public class _0_Collections_1_ArrayList {
    public static void main(String[] args) {
        //import 팁은 설정 -> 자동가져오기 -> 모호하지 않은 import 문 즉시 추가, 문import 문 즉시 최적화 체크 -> 적용
        //자동적으로 import 추가되고, 삭제됨
        //ArrayList
        //순서 o, 중복 o
        //1)기본 생성방법 : ArrayList<타입> [변수이름] = new ArrayList<>();
        //2)<> : 다이아몬드 연산자, "제네릭"이라고 부름, 어떤 타입으로 배열의 구성요소를 지정할지 정함
        //3)추가 : list.add(타입 조건이 맞는 데이터)
        //4)조회 : list.get(인덱스 번호)
        //5)수정 : list.set(인덱스 번호, 타입 조건이 맞는 데이터)
        //6)삭제 : list.remove(인덱스 번호)
        //7)전체 삭제 : list.clear()
        //8)리스트가 비어있는지 여부 확인 : list.isEmpty();
        //9)전체 출력 방법 : for 문 사용(향상된 for 문)
        //10-1)검색 방법 : contains(타입 조건이 맞는 데이터) 이용(있는지 확인)
        //10-2)검색 방법 : indexOf(타입 조건이 맞는 데이터) / lastIndexOf(타입 조건이 맞는 데이터) : 데이터가 몇번 인덱스에 있는지 확인
        //10-3)검색 방법 : 반복문을 이용한 조건 검색
        ArrayList<String> list = new ArrayList<>();
        System.out.println("ArrayList의 추가");
        list.add("사과");
        list.add("바나나");
        System.out.println("ArrayList의 전체 출력");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("ArrayList의 조회");
            System.out.println(list.get(i));
        }

        System.out.println();
        System.out.println("ArrayList의 수정");
        list.set(0, "딸기");
        System.out.println("ArrayList의 전체 출력(향상된 for 문)");
        for (String fruit: list) {
            System.out.println(fruit);
        }

        System.out.println();
        System.out.println("ArrayList의 삭제");
        list.remove(0);
        for (String fruit: list) {
            System.out.println("ArrayList의 크기");
            System.out.println(fruit + "\t사이즈 : " + list.size());
        }

        System.out.println();
        System.out.println("ArrayList의 전체 삭제");
        list.clear();
        System.out.println("ArrayList의 비어있는지 여부");
        System.out.println(list.isEmpty());

        list.add("사과");
        list.add("바나나");
        list.add("사과");
        boolean isCheckApple = list.contains("사과");
        System.out.println("사과 있는지 검색" + isCheckApple);

        int indexApple = list.indexOf("사과");
        int lastIndexApple = list.lastIndexOf("사과");
        int indexBerry = list.indexOf("딸기");
        System.out.println("사과 : indexOf=" + indexApple + ", lastIndexOf=" + lastIndexApple + ", 없는 데이터의 인덱스=" + indexBerry);

        String findFruit = null;
        for(String fruit: list) {
            if(fruit.startsWith("사")) {
                findFruit = fruit;
                break;
            }
        }
        System.out.println("'사'로 시작하는 과일 : " + findFruit);
    }
}
