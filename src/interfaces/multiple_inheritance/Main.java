package interfaces.multiple_inheritance;

public class Main {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.makeCall("8735427886");
        smartPhone.endCall();
        smartPhone.playMusic();
        smartPhone.stopMusic();
        smartPhone.takePhoto();
        smartPhone.recordVideo();
    }
}
