
 class Book {
    int price ;
    public static int count;
    public Book(int price){
        this.price = price;
        count++;
    }
}
public class Practice3 {
    public static void main(String[] args) {
        Book book = new Book(100);
        Book book2 = new Book(200);
        Book boo3 = new Book(100);
        Book book4 = new Book(200);
        System.out.println(Book.count);
    
    }
}
