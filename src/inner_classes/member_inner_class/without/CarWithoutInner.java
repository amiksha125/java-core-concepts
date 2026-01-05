package inner_classes.member_inner_class.without;

public class CarWithoutInner {
    private String model;

    private boolean isEngineOn;

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public CarWithoutInner(String model){
        this.model = model;
        this.isEngineOn = false;
    }
}
