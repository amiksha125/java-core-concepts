package inner_classes.member_inner_class.without;

public class Engine {

    // this class cannot directly access the private members of car class in the package.
    // we need to pass the obj of car to attach with engine
    // and then call getter setter methods , tedious process, better to use inner class
    CarWithoutInner car;
    Engine(CarWithoutInner obj){
        car = obj;
    }

    void start(){
//        if(car.isEngineOn) cannot its private
        if(car.isEngineOn()){

        }
    }

//    void start(){
//        if(!isEngineOn){
//            isEngineOn = true;
//            System.out.println(model + " engine started.");
//        } else {
//            System.out.println(model + " engine is already on.");
//        }
//    }
//
//    void stop(){
//        if(isEngineOn){
//            isEngineOn = false;
//            System.out.println(model + " engine stopped.");
//        } else {
//            System.out.println(model + " engine is already off.");
//        }
//    }
}
