public class SecondLargest {
    public static void main(String[] args) {
        int numbers[] = { 10, 20, 30, 40, 50 };

        if (numbers.length < 2) {
            System.out.println("Must be atleast 2 numbers");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element exists");
        } else {
            System.out.println(secondLargest);
        }

    }

    // Dry Run:
    // For array {10, 20, 30, 40, 50}:

    // Iteration 1: num = 10, update largest = 10, secondLargest =
    // Integer.MIN_VALUE.
    // Iteration 2: num = 20, update secondLargest = 10, largest = 20.
    // Iteration 3: num = 30, update secondLargest = 20, largest = 30.
    // Iteration 4: num = 40, update secondLargest = 30, largest = 40.
    // Iteration 5: num = 50, update secondLargest = 40, largest = 50.
    // Result: Second largest is 40.
}
