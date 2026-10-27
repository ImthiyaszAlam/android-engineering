
class A {
    int a, b;

    A() {
        a = 2;
        b = 3;
    }

    void display() {
        int sum = a + b;
        System.out.println("sum of class A: " + sum);
    }
}

class B extends A {
    int a, b;

    B() {
        a = 2;
        b = 3;
    }

    void display() {
        super.display();
        int sum = a + b;
        System.out.println("sum of class B: " + sum);
    }
}

class C extends B {
    int a, b;

    C() {
        a = 2;
        b = 3;
    }

    void display() {
        super.display();
        int sum = a + b;
        System.out.println("sum of class C: " + sum);
    }
}

public class Multilevel1 {
    public static void main(String[] args) {
        C c = new C();
        c.display();
    }
}
