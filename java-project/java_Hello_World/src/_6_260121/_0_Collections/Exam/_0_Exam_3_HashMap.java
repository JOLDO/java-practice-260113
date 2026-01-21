package _6_260121._0_Collections.Exam;

import java.util.HashMap;

public class _0_Exam_3_HashMap {
    public static void main(String[] args) {
        /*
        HashMap (메뉴판 관리)
        다음 요구사항을 만족하는 코드를 작성하세요.
        1. `HashMap<String, Integer>`를 생성합니다. (변수명: `menuMap`)
        2. 다음 메뉴와 가격을 추가하세요.
            * "김밥": 3000
            * "라면": 4500
            * "떡볶이": 5000
        3. "라면"의 가격을 출력하세요.
        4. "김밥"의 가격을 **3500원**으로 수정하세요.
        5. "돈까스"라는 메뉴가 있는지 확인하고, 결과를 출력하세요.
        6. 맵에 들어있는 모든 메뉴 이름(Key)와 값도 같이 출력하세요.
        */

        //1
        HashMap<String, Integer> menuMap = new HashMap<>();

        //2
        menuMap.put("김밥", 3000);
        menuMap.put("라면", 4500);
        menuMap.put("떡볶이", 5000);

        //3
        System.out.println(menuMap.get("라면"));

        //4
        menuMap.put("김밥", 3500);

        //5
        boolean hasKey = menuMap.containsKey("돈까스");
        if(hasKey) {
            System.out.println(hasKey + ", " + menuMap.get("돈까스"));
        }

        //6
        for(String menu: menuMap.keySet()) {
            System.out.println(menu + " : " + menuMap.get(menu));
        }

        //값으로 계산
        System.out.println(menuMap.values().stream().mapToInt(Integer::intValue).average().orElse(0));
        System.out.println(menuMap.values().stream().mapToInt(i -> i.intValue()).average().orElse(0));
        System.out.println(menuMap.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println(menuMap.values().stream().mapToInt(i -> i.intValue()).sum());
    }
}
