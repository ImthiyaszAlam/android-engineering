public class BinarySearchElement {

    public int searchIndexElement(int a[],int value,int start,int end){
        if (a.length == 0 || start>end) {
            return -1;
        }

        int mid  = (start+end)/2;
        if (value == a[mid]) {
            return mid;
        }

        if (value<a[mid]) {
            searchIndexElement(a, value, start, mid-1);
        }
        else{
            searchIndexElement(a, value, mid+1, end);
        }
        return end;
    }
    public static void main(String[] args) {
        BinarySearchElement binarySearchElement = new BinarySearchElement();
        int a [] = {10,20,30,40,50};
        int indexValue = binarySearchElement.searchIndexElement(a,20, 0, a.length-1);

        if (indexValue == -1) {
            System.out.println("Value doesn't exist");
        }
        else{
            System.out.println(indexValue);
        }
  

    }
}
