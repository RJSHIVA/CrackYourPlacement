import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSort {
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        
        // Create an array of pairs (value, index)
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Create a mapping from original index to sorted index
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sortedArr[i], i);
        }

        // Count the minimum number of swaps
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            // Skip already visited or already in correct position
            if (visited[i] || indexMap.get(arr[i]) == i) {
                continue;
            }
            
            // Compute the cycle size
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(arr[j]);
                cycleSize++;
            }
            
            // If there is a cycle of size `cycleSize`, then we need `cycleSize - 1` swaps
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println("Minimum number of swaps required: " + minSwaps(arr));
    }
}
