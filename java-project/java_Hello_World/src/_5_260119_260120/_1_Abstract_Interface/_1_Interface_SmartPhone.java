package _5_260119_260120._1_Abstract_Interface;

public class _1_Interface_SmartPhone implements _1_Interface_Camera, _1_Interfaece_Phone, _1_Interface_RemoteControl{
    @Override
    public void makeCall() {
        System.out.println("전화");
    }

    @Override
    public void takePhoto() {
        System.out.println("사진");
    }

    @Override
    public void turnOn() {
        System.out.println("켬");
    }
}
