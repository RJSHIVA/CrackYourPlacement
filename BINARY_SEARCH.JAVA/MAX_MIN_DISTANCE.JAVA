import java.util.Arrays;

public class Solution {
    
    // Check if it is feasible to place k elements with at least `mid` distance apart
    static boolean isFeasible(int mid, int arr[], int n, int k) {
        int pos = arr[0];
        int elements = 1; // Place the first element at the first position

        // Try placing k elements with minimum distance `mid`
        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= mid) {
                pos = arr[i];
                elements++;
                // Return true if all elements are placed successfully
                if (elements == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // Returns the largest minimum distance for placing k elements in arr[0..n-1]
    static int largestMinDist(int arr[], int n, int k) {
        Arrays.sort(arr); // Sort the positions

        int left = 1; // Minimum possible distance
        int right = arr[n - 1]; // Maximum possible distance
        int res = -1; // Result initialized to -1

        // Binary search for the largest minimum distance
        while (left <= right) {
            int mid = (left + right) / 2;

            if (isFeasible(mid, arr, n, k)) {
                res = mid; // Update result if feasible
                left = mid + 1; // Try for a larger distance
            } else {
                right = mid; // Try for a smaller distance
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 4, 9};
        int n = arr.length;
        int k = 3;
        System.out.println("Largest minimum distance: " + largestMinDist(arr, n, k));
    }
}
