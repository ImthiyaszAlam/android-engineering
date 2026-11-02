public class Blueprint {
    public static void main(String[] args) {
        Student.studentName("alam");
        Student.studentMarks(100);
        Student.studentPercentage(100, 20, 10);


        String studentName = "alam";
        College college = new College();
        college.addStudent(studentName);
       
    }

}

abstract class Student {
    public static void studentName(String name) {
        System.out.println(name);
    }

    public static void studentMarks(int marks) {
        System.out.println(marks);
    }

    public static void studentPercentage(int phy, int chem, int math) {
        int subs = (phy + chem + math) / 3;
        System.out.println(subs);
    }

}

final  class College {
    String students;


    public  void addStudent(String s) {
        System.out.println(s = students);
    }

 
}