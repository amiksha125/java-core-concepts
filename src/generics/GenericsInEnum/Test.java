package generics.GenericsInEnum;


enum Operation{
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b){
        // this will tell us the enum type whether ADD, SUBTRACT

        switch(this){
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUBTRACT:
                return a.doubleValue() - b.doubleValue();
            case MULTIPLY:
                return a.doubleValue() * b.doubleValue();
            case DIVIDE:
                return  a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown Operation: " + this);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        double res1 = Operation.ADD.apply(25, 35);
        System.out.println(res1);

        double res2 = Operation.MULTIPLY.apply(45, 3);
        System.out.println(res2);

        double res3 = Operation.DIVIDE.apply(366 , 4 );
        System.out.println(res3);
    }

}
