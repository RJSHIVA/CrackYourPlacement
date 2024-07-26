import java.util.Arrays;

public class RadixSort {

    // Function to get the maximum value in an array
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Function to perform counting sort on the array based on a specific digit
    public static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Output array to store the sorted order
        int[] count = new int[10]; // Array to store the count of digits (0-9)

        // Initialize count array with zeros
        Arrays.fill(count, 0);

        // Store count of occurrences of each digit in the array
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it contains the actual position of this digit in the output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the output array to the original array
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Main function to implement radix sort
    public static void radixSort(int[] array) {
        // Get the maximum number to know the number of digits
        int max = getMax(array);

        // Perform counting sort for every digit. The exponent is used to get the digit at a specific place.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
