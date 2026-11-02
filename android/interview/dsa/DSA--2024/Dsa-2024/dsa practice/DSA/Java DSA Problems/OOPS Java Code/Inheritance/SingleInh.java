
class A{
    int a,b;
A(){
a = 5;
b = 4;
}

void sum(){
    int sum = a+b;
    System.out.println("sum is: "+sum);
}
}
class B extends A{
int p,q;
B(){
    p = 4;q = 3;
}
void sum(){
    super.sum();
    int sum = p+q;
    System.out.println("sum of p and q is: "+sum);
}
}


public class SingleInh {
    public static void main(String[] args) {
        A b = new A();
        b.sum();
    }
}
