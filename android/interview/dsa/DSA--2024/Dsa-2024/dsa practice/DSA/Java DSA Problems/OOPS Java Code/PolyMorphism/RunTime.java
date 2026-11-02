
class Good{
    void life(){
        System.out.println("Good Life");
    }
}

class Bad extends Good{
    void life(){
        System.out.println("Bad Life");
    }
}


public class RunTime {
    public static void main(String[] args) {
        Good b = new Good();
        b.life();
    }
}
