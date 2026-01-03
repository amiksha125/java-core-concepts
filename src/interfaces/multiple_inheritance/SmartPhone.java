package interfaces.multiple_inheritance;

public class SmartPhone implements Camera, MusicPlayer,Phone {

    @Override
    public void playMusic() {
        System.out.println("Playing music on smartphone..");
    }

    @Override
    public void stopMusic() {
        System.out.println("Pausing music on smartphone..");
    }

    @Override
    public void makeCall(String number) {
        System.out.println("Calling "+number+" from smartphone..");
    }

    @Override
    public void endCall() {
        System.out.println("Ending call from smartphone..");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking photo with smartphone..");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording video with smartphone..");
    }
}
