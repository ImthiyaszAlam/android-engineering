public class ShortestPath1 {

    public static int getShortestPath(String path) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            if (direction == 'S') {
                y--;
            } else if (direction == 'W') {
                x--;
            } else if (direction == 'N') {
                x++;
            } else {
                x++;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (int) Math.sqrt(x2 + y2);

    }

    public static void main(String[] args) {
        String path = "WNSENNN";
        System.out.println(getShortestPath(path));
    }
}
