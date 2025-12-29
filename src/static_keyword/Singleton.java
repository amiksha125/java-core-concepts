package static_keyword;

public class Singleton {

    public static void main(String[] args) {
        School instance = School.getInstance();
    }
    
}

class School{
    private static School school = new School();
    
    private School(){
        
    }
    
    public static School getInstance(){
        return school;
    }
}
