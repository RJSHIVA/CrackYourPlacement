import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();  // number of test cases
        
        while (t-- > 0) {
            int N = scanner.nextInt();
            int C = scanner.nextInt();
            
            int[] stalls = new int[N];
            for (int i = 0; i < N; i++) {
                stalls[i] = scanner.nextInt();
            }
            
            // Find the largest minimum distance
            System.out.println(findLargestMinDistance(stalls, C));
        }
        
        scanner.close();
    }

    // Function to check if it is feasible to place C cows with at least distance d
    private static boolean isFeasible(int[] stalls, int C, int d) {
        int count = 1;  // Place the first cow in the first stall
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= d) {
                count++;
                lastPosition = stalls[i];
                if (count == C) {
                    return true;
                }
            }
        }
        
        return false;
    }

    // Function to find the largest minimum distance
    private static int findLargestMinDistance(int[] stalls, int C) {
        Arrays.sort(stalls);  // Sort stall positions
        
        int low = 1;  // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0];  // Maximum possible distance
        int best = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(stalls, C, mid)) {
                best = mid;  // Update best result
                low = mid + 1;  // Try for a larger distance
            } else {
                high = mid - 1;  // Try for a smaller distance
            }
        }
        
        return best;
    }
}
