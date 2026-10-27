import java.util.Scanner;

class Areas {
  void area(int a, int b) {
    int area = a * b;
    System.out.println("area of rectangle is: " + area);
  }

  void area(int a) {
    int area = a * a;
    System.out.println("area of square is: " + area);
  }

  void area(double  r) {
    double area = (3.14) * r * r;
    System.out.println("area of circle is: " + area);
  }
}

public class Static {
  public static void main(String[] args) {
    Areas areas = new Areas();
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter length of rectangle");
    int a1 = scanner.nextInt();
    System.out.println("enter breadth of rectangle");
    int a2 = scanner.nextInt();

    System.out.println("enter side of square");
    int s1 = scanner.nextInt();

    System.out.println("enter radius of circle");
    int r1 = scanner.nextInt();

    areas.area(r1);
    areas.area(s1);
    areas.area(a1,a2);
  }
}