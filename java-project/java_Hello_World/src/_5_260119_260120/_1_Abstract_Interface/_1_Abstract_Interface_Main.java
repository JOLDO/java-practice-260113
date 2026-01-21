package _5_260119_260120._1_Abstract_Interface;

public class _1_Abstract_Interface_Main {
    public static void main(String[] args) {
        _1_Abstract_Printer printer = new _1_Abstract_Printer();
        printer.operate();

        _1_Interface_SmartPhone smartPhone = new _1_Interface_SmartPhone();
        smartPhone.makeCall();
        smartPhone.takePhoto();
        smartPhone.turnOn();
    }
}
