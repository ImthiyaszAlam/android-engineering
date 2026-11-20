public class CommonElement {
    public static void main(String[] args) {
        int a[] = {1,21,13,14,15,16};
        int b[] = {2,21,22,23,15,25};

        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<b.length-1;j++){
                if (a[i] == b[j]) {
                    System.out.println("Common element is: "+a[i]);
                }
            }
        }
    }
}
