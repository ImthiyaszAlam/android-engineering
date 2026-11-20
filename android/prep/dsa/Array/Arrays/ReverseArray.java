public class ReverseArray {


    // Problem Statement
    // Reverse the order of elements in an array. For example:
    
    // Input: {1, 2, 3, 4, 5}
    // Output: {5, 4, 3, 2, 1}
    // Logic Explanation
    // To reverse an array, the goal is to swap elements from both ends of the array, moving toward the center. Here's the logic:
    
    // Two Pointers Approach:
    
    // Use two pointers:
    // start: Points to the beginning of the array.
    // end: Points to the end of the array.
    // Swap the elements at start and end.
    // Move the start pointer forward (start++) and the end pointer backward (end--) after each swap.
    // Repeat until the pointers meet or cross each other (i.e., start >= end).
    // Why This Works:
    
    // Swapping ensures that each element from the left moves to its corresponding position on the right, and vice versa.
    // By working toward the center, we handle all elements in one pass.
    
    
    //     Step-by-Step Dry Run
    // Let’s take arr = {1, 2, 3, 4, 5} and reverse it step by step.
    
    // Initial State:
    // arr = {1, 2, 3, 4, 5}
    // start = 0, end = 4
    
    // Iteration 1:
    
    // Swap arr[start] and arr[end] → Swap arr[0] and arr[4].
    // arr = {5, 2, 3, 4, 1}.
    // Move pointers: start = 1, end = 3.
    // Iteration 2:
    
    
    // Swap arr[start] and arr[end] → Swap arr[1] and arr[3].
    // arr = {5, 4, 3, 2, 1}.
    // Move pointers: start = 2, end = 2.
    // Iteration 3:
    
    // Now start == end → Stop the loop.
    // Final State:
    // arr = {5, 4, 3, 2, 1}.
    
    // Edge Cases
    // Empty Array (arr = {}):
    // Nothing to reverse → Handle as a special case.
    // Single Element (arr = {1}):
    // No need to reverse → Output is the same.
    // Even Length Array (arr = {1, 2, 3, 4}):
    // Swaps will still work, stopping at the center.
    // Why Use Two Pointers?
    // Efficient: Only one loop is needed (O(n) complexity).
    // Minimal space: No extra space is required (in-place reversal).
    
    public static void main(String[] args) {
        int numbers[]  = {1,2,3,4,5,6,7,8,9,0};
        int left = 0;
        int right = numbers.length-1;

        while (left<right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;

        }

//
        System.out.println("Reversed Array is:");
        for(int num:numbers){
            System.out.print(num+" ");
        }
    }
}
