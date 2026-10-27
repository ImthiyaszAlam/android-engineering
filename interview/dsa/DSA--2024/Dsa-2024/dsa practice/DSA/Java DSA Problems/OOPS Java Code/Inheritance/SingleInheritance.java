
class A {
    void display1() {
        System.out.println("Class A");
    }
}


class B extends A {
    
    void display2() {
        super.display1();
        System.out.println("class B");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        B b = new B();
        b.display2();
    }

}