public class DuplicateElement {

    public static void findDuplicateElements(int a[]){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length-1;j++){
                if (a[i] == a[j]) {
                    System.out.print(a[i]+ " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int a[] ={1,2,3,3,4};
        findDuplicateElements(a);
    }
}
