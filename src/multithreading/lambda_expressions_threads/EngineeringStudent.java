package multithreading.lambda_expressions_threads;

public class EngineeringStudent implements Student{
    @Override
    public String getBio(String name) {
        return name + " is engineering student.";
    }

    public static void main(String[] args) {
//        Student student = new EngineeringStudent();
//        System.out.println(student.getBio("Rashu"));
//        anonymous class
//        Student student = new Student() {
//            @Override
//            public String getBio(String name) {
//                return "";
//            }
//        };

        //Instead of implementing from EnginneringStudent, use lambda expression

        Student student =  name -> {
            return name + " is engineering student.";
        };


        System.out.println(student.getBio("Ruhi"));

    }
}
