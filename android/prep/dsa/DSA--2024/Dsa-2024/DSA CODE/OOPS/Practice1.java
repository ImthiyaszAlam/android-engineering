
class Student {
    String name;
    int marks;
}

public class Practice1 {
    public static void main(String[] args) {
        Student s = new Student();
        String name = s.name = "Alam";
        System.out.println(name);

      System.out.println(  s.marks = 100);
    }
}
