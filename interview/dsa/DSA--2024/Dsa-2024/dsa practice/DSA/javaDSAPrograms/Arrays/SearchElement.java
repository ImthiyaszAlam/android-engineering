public class SearchElement {

    public int searchIndex( int a[],int value){
        if (a.length == 0) {
            return -1;
        }
        else{
            for(int i=0;i<a.length;i++){
                if (a[i] == value) {
                    return i;
                }
            }
            return -1;
        }


    }
    public static void main(String[] args) {
        int a[] = {100,20,30,40,50};
        SearchElement searchElement = new SearchElement();
        int index = searchElement.searchIndex(a, 40);

        if (index == -1) {
            System.out.println("Value doesn't exist in given array");
        }
        else{
            
            System.out.print("The index is" +""+ index);
        }

    }
}
