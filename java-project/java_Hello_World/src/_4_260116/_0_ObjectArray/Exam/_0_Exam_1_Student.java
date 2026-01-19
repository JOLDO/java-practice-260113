package _4_260116._0_ObjectArray.Exam;

public class _0_Exam_1_Student {
    private String name;
    private int score;

    public _0_Exam_1_Student() {}

    public _0_Exam_1_Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void printStudentA(_0_Exam_1_Student[] arr) {
        boolean isValid = false;
        for(_0_Exam_1_Student s: arr) {
            if(s.getScore() >= 90) {
                isValid = true;
                System.out.println("학생 이름 : " + s.getName() + ", 학생 점수 : " + s.getScore());
            }
        }
        if(!isValid)    System.out.println("90점 이상이 없습니다.");
    }

    public _0_Exam_1_Student[] createStudents() {
        _0_Exam_1_Student student1 = new _0_Exam_1_Student("이름1", 90);
        _0_Exam_1_Student student2 = new _0_Exam_1_Student("이름2", 91);
        _0_Exam_1_Student student3 = new _0_Exam_1_Student("이름3", 99);

        return new _0_Exam_1_Student[] { student1, student2, student3 };
    }
}
