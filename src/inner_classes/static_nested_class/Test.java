package inner_classes.static_nested_class;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer("HP", "ABC", "XYZ");
        computer.getOs().displayInfo();

        Computer.USB usb = new Computer.USB("TYPE-C");
        // FOR GROUPING COMPUTER RELATED EXTERNAL DEVICES WHOSE FUNCTIONS AND USAGE ARE INDEPENDENT OF A PARTICULAR COMPUTER
        // EXAMPLE, CD , DVD THIS WILL LEAD TO BETTER MEMORY USAGE , SAVES MEMORY BY NOT CREATING USB FOR EACH COMPUTER
    }
}
