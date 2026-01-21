package _6_260121._0_Collections.Exam;

import java.util.ArrayList;

public class _0_Exam_1_ArrayList {
    public static void main(String[] args) {
        /*
        ArrayList (순서가 있는 목록 관리)
        다음 요구사항을 만족하는 코드를 작성하세요.
        1. `ArrayList<String>`을 생성합니다. (변수명: `studentList`)
        2. "홍길동", "이순신", "강감찬" 3명의 이름을 순서대로 추가하세요.
        3. 리스트의 **두 번째** 사람("이순신")을 출력하세요.
        4. "강감찬"을 "을지문덕"으로 **수정**하세요.
        5. "홍길동"을 리스트에서 **삭제**하세요.
        6. 리스트의 크기(Size)를 출력하고, 남은 사람들을 모두 출력하세요.
        */

        //1
        ArrayList<String> studentList = new ArrayList<>();

        //2
        studentList.add("홍길동");
        studentList.add("이순신");
        studentList.add("강감찬");

        //3
        if(studentList.size() > 2) {
            System.out.println(studentList.get(1));
        }

        //4
        int indexOfStudent = studentList.indexOf("강감찬");
        if(indexOfStudent != -1) {
            studentList.set(indexOfStudent, "을지문덕");
        }

        //5
        if(studentList.size() > 1) {
            System.out.println("\"홍길동\" 삭제=" + studentList.remove("홍길동"));
        }

        //6
        System.out.println(studentList.size());
        for (String student : studentList) {
            System.out.println(student);
        }
    }
}
