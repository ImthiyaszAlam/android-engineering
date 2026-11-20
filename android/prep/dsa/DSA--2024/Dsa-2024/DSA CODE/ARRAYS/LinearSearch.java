
public class LinearSearch {

    public static int linearSearch(String arr[],String key){
        for(int i=0;i<arr.length;i++){
            if (arr[i].equals(key)) {
                int index = i;
            }
        }
        return -1;
    } 
    public static void main(String[] args) {
        String food[] = {"dosa","samosa","aalu","pyaz"};
        String key = "aalu";
        System.out.println(linearSearch(food, key));
        
    }
}