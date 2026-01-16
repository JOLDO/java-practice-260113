package _4_260116;

public class _1_Exam_2_Manufacturer {
    private static String manufacturer = "삼성";

    private String model;
    private String phoneNumber;

    public _1_Exam_2_Manufacturer(String model, String phoneNumber) {
        this.model = model;
        this.phoneNumber = phoneNumber;
        printInfo();
    }

    public String getModel() {
        return model;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printInfo() {
        System.out.println("제조사 : " + manufacturer + ", 폰모델 : " + model + ", 폰번호 : " + phoneNumber);
    }

    public static void changeManufacturer(String str) {
        System.out.println("제조사 변경 => " + str);
        manufacturer = str;
    }

    public static void changeManufacturer(_1_Exam_2_Manufacturer c, String str) {
        System.out.println("제조사 변경 => " + str);
        manufacturer = str;
        if (str == "삼성") {
            c.model = "갤럭시";    //스태틱이 아닌 변수를 변경하거나 함수를 호출 하려면 클래스 객체를 받아와서 명시적으로 선택해줘야 함
        } else {
            c.model = "아이폰";    //스태틱이 아닌 변수를 변경하거나 함수를 호출 하려면 클래스 객체를 받아와서 명시적으로 선택해줘야 함
        }

    }
}
