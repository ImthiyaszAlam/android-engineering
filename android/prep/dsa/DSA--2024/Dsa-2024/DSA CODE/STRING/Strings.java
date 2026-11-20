import java.util.Scanner;

public class Strings {

    public static void printName(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
    }
     
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName = sc.nextLine();
        
        System.out.println("Enter your last name");
        String lastName = sc.nextLine();

        String fullName = firstName+" "+lastName;
        printName(fullName);
    }
}