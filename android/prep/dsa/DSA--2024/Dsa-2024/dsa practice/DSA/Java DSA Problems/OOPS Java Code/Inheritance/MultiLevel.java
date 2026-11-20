
class A{
    void display(){
        System.out.println("Class A");
    }
}

class C extends B{
    void display(){
        super.display();
        System.out.println("Class C");
    }
}
class B extends A{
    void display(){
        super.display();
        System.out.println("Class B");
    }
}




public class MultiLevel {
    public static void main(String[] args) {
        C c = new C();
        c.display();
    }
}
