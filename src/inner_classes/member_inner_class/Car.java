package inner_classes.member_inner_class;

public class Car {
    private String model;

    private boolean isEngineOn;

    public Car(String model){
        this.model = model;
        this.isEngineOn = false;
    }

    // We will create a separate class to on the engine, but we want to turn the engine on using Car's object only

    class Engine{
        void start(){
            if(!isEngineOn){
                isEngineOn = true;
                System.out.println(model + " engine started.");
            } else {
                System.out.println(model + " engine is already on.");
            }
        }

        void stop(){
            if(isEngineOn){
                isEngineOn = false;
                System.out.println(model + " engine stopped.");
            } else {
                System.out.println(model + " engine is already off.");
            }
        }
    }
}
