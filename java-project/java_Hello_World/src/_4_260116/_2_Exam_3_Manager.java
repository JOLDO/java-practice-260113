package _4_260116;

public class _2_Exam_3_Manager extends _2_Exam_3_Employee{
    public _2_Exam_3_Manager(String department) {
        super(department);
    }

    public void printDept() {
        System.out.println("소속 부서 : " + department);
    }
}
