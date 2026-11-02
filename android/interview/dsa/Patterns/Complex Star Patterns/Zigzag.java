public class Zigzag {

    public static void main(String[] args) {
        int column = 9;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < column; j++) {

                if ((i + j) % 4 == 0 || (i == 1 && j % 2 == 0)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            
                System.out.println();
        }
    }
}