public class CommonInSortedArray {

    // public static void findCommonElement(int a[], int b[], int c[]) {
    //     for (int i = 0; i < a.length - 1; i++) {
    //         for (int j = 0; j < b.length - 1; j++) {
    //             for (int k = 0; k < c.length - 1; k++) {
    //                 if (a[i] == b[j] && b[j] == c[k]) {
    //                     System.out.println(a[i]);
    //                 }
    //             }
    //         }
    //     }
    // }

    public static void findCommonElement(int a[],int b[],int c[]){
        int x=0,y=0,z=0;
        while (x<a.length && y<b.length && z<c.length) {
            if (a[x] == b[y]&& b[y] == c[z]) {
                System.out.println(a[x]);
                x++;
                y++;
                z++;
            }else if (a[x]>b[y]) {
                y++;
            }else if (b[y]>c[z]) {
                z++;
            }else{
                x++;
            }
        }
    }
    public static void main(String[] args) {
        int a1[] = { 1, 2, 3, 4, 5 };
        int a2[] = { 1, 4};
        int a3[] = { 1, 5 };
        findCommonElement(a1, a2, a3);
    }
}
