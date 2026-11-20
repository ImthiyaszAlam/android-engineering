
class Person {
    String name;
    int weight;
}

public class Practice2 extends Person {
    public static void main(String[] args) {
        Practice2 practice2 = new Practice2();
        practice2.name = "Alam";
        System.out.println(practice2.name);
        practice2.weight = 50;
        System.out.println(practice2.weight);
        practice2.rollNo = 100;
        System.out.println(practice2.rollNo);
        practice2.schoolName="MKHMMO";
        System.out.println(practice2.schoolName);


    }

    int rollNo;
    String schoolName;
}
