package _4_260116;

public class _0_ObjectArray {
    public static void main(String[] args) {
        //3명의 학생 정보를 저장하는 `Student` 객체 배열을 만들고 이름을 출력하시오.
        //방법1
        _0_ObjectArray_Student[] arr = {
                new _0_ObjectArray_Student("지민"),
                new _0_ObjectArray_Student("정국"),
                new _0_ObjectArray_Student("태형")
        };
        //방법2
        _0_ObjectArray_Student student1 = new _0_ObjectArray_Student("지민");
        _0_ObjectArray_Student student2 = new _0_ObjectArray_Student("정국");
        _0_ObjectArray_Student student3 = new _0_ObjectArray_Student("태형");
        _0_ObjectArray_Student[] arr2 = {
                student1, student2, student3
        };

        for(_0_ObjectArray_Student s: arr) {
            System.out.println(s.getName());
        }

        for(_0_ObjectArray_Student s: arr2) {
            System.out.println(s.getName());
        }
    }
}
