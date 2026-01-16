package _4_260116;

public class _0_Exam_1 {
    public static void main(String[] args) {
        /*
        1) 성적이 90점 이상인 학생만 출력하시오.
        클래스명 StudentEx1(_0_Exam_1_Student) :
        멤버 변수 : name(String), score(int)
        생성자 : 매개변수가 2개인 생성자 생성

        StudentEx1(_0_Exam_1_Student) 를 요소로 가지는 배열을 생성해서,
        샘플 학생 3명 생성, 배열에 담아서, 반복문 이용해서 출력하기.
        학생 이름과, 점수를 출력하기.
        */

        /*
        2)
        객체 배열을 반환하는 메소드 만들기
        메소드명 : createStudents
        반환타입: StudentEx1(_0_Exam_1_Student)
        이용해보기.
        */

//        printStudentA(createStudents());

//        _0_Exam_1_Student[] result = createStudents();
//        printStudentA(result);  //printStudentA(createStudents());

//        _0_Exam_1_Student students = new _0_Exam_1_Student();
//        students.printStudentA(createStudents());

        _0_Exam_1_Student students = new _0_Exam_1_Student();
        students.printStudentA(students.createStudents());
    }

    private static _0_Exam_1_Student[] createStudents() {
        _0_Exam_1_Student student1 = new _0_Exam_1_Student("이름1", 90);
        _0_Exam_1_Student student2 = new _0_Exam_1_Student("이름2", 91);
        _0_Exam_1_Student student3 = new _0_Exam_1_Student("이름3", 99);

        return new _0_Exam_1_Student[] { student1, student2, student3 };
    }

    private static void printStudentA(_0_Exam_1_Student[] arr) {
        boolean isValid = false;
        for(_0_Exam_1_Student s: arr) {
            if(s.getScore() >= 90) {
                isValid = true;
                System.out.println("학생 이름 : " + s.getName() + ", 학생 점수 : " + s.getScore());
            }
        }
        if(!isValid)    System.out.println("90점 이상이 없습니다.");
    }
}
