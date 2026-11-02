
class Test {

    static int marks;

    void setMarks(int marks) {
        this.marks = marks;
    }
}

public class Practice4 {

    public static void main(String[] args) {
        Test test = new Test();
        test.setMarks(100);
        System.out.println(Test.marks);
    }
}
